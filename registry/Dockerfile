FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar"]

EXPOSE 8761