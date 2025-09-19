pipeline {
  agent any
  tools { jdk 'JDK21'; maven 'Maven3' } // Configure under "Global Tool Configuration"

  options {
    timestamps()
    timeout(time: 30, unit: 'MINUTES')
  }

  environment {
    APP_NAME   = 'smartbilling'
    IMAGE_TAG  = "${env.BRANCH_NAME ?: env.GIT_BRANCH ?: 'local'}-${env.BUILD_NUMBER}"
    REGISTRY   = 'registry:5000'                  // inside the compose network
    IMAGE_NAME = "${APP_NAME}"
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

   stage('Sanitize Image Tag') {
      steps {
        script {
          def raw = env.IMAGE_TAG
           // 2) Strip common prefixes ONLY if they’re at the start
            //    (use normal strings, not /slash/ regex literals)
            raw = raw.replaceFirst('refs/heads/', '')
                     .replaceFirst('refs/remotes/origin/', '')
                     .replaceFirst('origin/', '')
                     .replaceFirst('remotes/', '')

            // 3) Replace ALL slashes with hyphens (literal replace, not regex)
            raw = raw.replace('/', '-')  // replaces every '/' char

            // 4) Replace any other invalid tag chars with '-'
            def safe = raw.replaceAll('[^A-Za-z0-9_.-]', '-')
          IMAGE_TAG = "${safe}"
          echo "${raw}gggggggggggggggppppppp=${safe}"
          echo "Using IMAGE_TAGppppppp=${env.IMAGE_TAG}"
        }
      }
   }

    stage('Build & Test') {
      steps {
        sh 'mvn -B -U -DskipTests=false clean package'
      }
      post {
        always { junit '**/target/surefire-reports/*.xml' }
      }
    }

    stage('Docker sanity') {
      steps {
        sh '''
          docker version
        '''
      }
    }

    stage('Docker Build') {
      steps {

        script {

        sh """
          docker build -t ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG} -t ${IMAGE_NAME}:latest .
        """
      }
     }
    }
    stage('Push to Local Registry') {
      steps {
        sh """
          docker push ${IMAGE_NAME}:${IMAGE_TAG}
          docker push ${IMAGE_NAME}:latest
        """
      }
    }
  }

  post {
    success { echo "Pushed ${IMAGE_NAME}:${IMAGE_TAG} to local registry." }
    always { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
  }
}
