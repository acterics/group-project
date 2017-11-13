FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8888