FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/sandbox.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/sandbox.jar"]

EXPOSE 7000