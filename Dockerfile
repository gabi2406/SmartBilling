# ---- Runtime image (Java 21 JRE) ----
FROM eclipse-temurin:21-jre

# Run as non-root for safety
RUN useradd -u 10001 -m appuser
USER 10001

WORKDIR /app

# Copy the fat jar built by Maven in Jenkins
# Adjust the pattern if your jar name differs
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Optional JVM tuning (container-aware)
ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75 -XX:+UseSerialGC"

# Spring Boot default port (change if your app uses another)
EXPOSE 8080

# Optional healthcheck (uncomment if you have Actuator and curl/wget available)
# RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
# HEALTHCHECK --interval=30s --timeout=5s --start-period=20s --retries=5 \
#   CMD curl -fsS http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh","-c","exec java $JAVA_TOOL_OPTIONS -jar /app/app.jar"]
