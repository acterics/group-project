FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/api-gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/api-gateway.jar"]

EXPOSE 4000