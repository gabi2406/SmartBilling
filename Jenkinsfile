pipeline {
  agent any
  tools { jdk 'JDK21'; maven 'Maven3' } // Configure under "Global Tool Configuration"

  options {
    timestamps()
    timeout(time: 30, unit: 'MINUTES')
  }

  environment {
    APP_NAME   = 'smartbilling'
    IMAGE_TAG  = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
    REGISTRY   = 'registry:5000'                  // inside the compose network
    IMAGE_NAME = "${REGISTRY}/${APP_NAME}"
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
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
          unset DOCKER_TLS_VERIFY DOCKER_CERT_PATH DOCKER_HOST
          docker context use default || true
          docker version
        '''
      }
    }

    stage('Docker Build') {
      steps {
        sh """
          docker version
          docker build -t ${IMAGE_NAME}:${IMAGE_TAG} -t ${IMAGE_NAME}:latest .
        """
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
