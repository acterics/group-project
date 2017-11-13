FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 8888