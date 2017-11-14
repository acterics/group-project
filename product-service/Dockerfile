FROM java:8-jre
MAINTAINER Oleg Lipskiy <lolego1601@gmail.com>

ADD ./build/libs/product-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/product-service.jar"]

EXPOSE 7001