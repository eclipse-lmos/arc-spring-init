## SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
##
## SPDX-License-Identifier: Apache-2.0
## Stage 1 : unpack fat-jar
FROM amazoncorretto:21 AS builder

USER root
COPY build/libs/arc-spring-init-0.1.0.jar /deployments/app.jar
WORKDIR /deployments
RUN java -Djarmode=layertools -jar app.jar extract
# Ensure that the snapshot-dependencies folder is created even if there were no snapshot dependencies in the jar file (to avoid error when copying from that directory below)
RUN mkdir -p snapshot-dependencies

## Stage 2 : create image
FROM amazoncorretto:21
USER 185
WORKDIR /deployments
COPY --from=builder /deployments/dependencies/ ./
COPY --from=builder /deployments/snapshot-dependencies/ ./
COPY --from=builder /deployments/spring-boot-loader/ ./
COPY --from=builder /deployments/application/ ./
COPY config ./config
COPY agents ./agents

EXPOSE 9094
EXPOSE 9095
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]