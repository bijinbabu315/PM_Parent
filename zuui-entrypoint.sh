#!/bin/sh
while ! nc -z eureka-server 9091 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
java -jar /opt/lib/PMZuuIAPIGateway-0.0.1-SNAPSHOT.jar
