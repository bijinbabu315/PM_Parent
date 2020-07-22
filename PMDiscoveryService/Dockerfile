FROM alpine-jdk:base
MAINTAINER javaonfly
COPY target/PMDiscoveryService-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/PMDiscoveryService-0.0.1-SNAPSHOT.jar"]
EXPOSE 9091
