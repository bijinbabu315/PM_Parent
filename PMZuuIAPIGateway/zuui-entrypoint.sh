
#!/bin/sh

while ! nc -z discoveryservice 9091 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
java -jar PMZuuIAPIGateway-0.0.1-SNAPSHOT.jar