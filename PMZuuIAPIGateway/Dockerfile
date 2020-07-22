FROM alpine-jdk:base
MAINTAINER javaonfly
COPY target/PMZuuIAPIGateway-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/PMZuuIAPIGateway-0.0.1-SNAPSHOT.jar"]
EXPOSE 8095
