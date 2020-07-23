#!/bin/sh
while ! nc -z eureka-server 9091 ; do
    echo "Waiting for the Eureka Server"
    sleep 5
done
java -jar /opt/lib/ProjectManagerProjectAPI-0.0.1-SNAPSHOT.jar
