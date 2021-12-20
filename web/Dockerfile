FROM gradle:jdk15 as builder
WORKDIR /app
COPY domain ./domain
COPY infrastructure ./infrastructure
COPY web ./web

COPY build.gradle ./build.gradle
RUN --mount=type=cache,target=./.gradle gradle clean test init

FROM openjdk:15 as backend
WORKDIR /root
COPY --from=builder /app/build/install/app ./
