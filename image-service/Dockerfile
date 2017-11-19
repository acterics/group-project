FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/image-service.jar /app/

EXPOSE 80

HEALTHCHECK \
  --interval=5s \
  --timeout=5m \
  --start-period=5s \
  --retries=30 \
  CMD curl -f http://localhost/health || exit 1

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/image-service.jar"]