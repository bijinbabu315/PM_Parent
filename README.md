# PM_Parent


# created project manager network 
docker network create projectmanager-network
# created database
docker container run --name mysqldb  --network projectmanager-network -e MYSQL_ROOT_PASSWORD=pass@word1 -e MYSQL_DATABASE=pmsdb -d mysql:8

# created aplhine jdk image
docker build --tag=alpine-jdk:base --rm=true .

#created eureka server image 
docker build --file=Dockerfile-eurekaserver -t eureka-server .

#created zuui gateway image 
docker build --file=Dockerfile_zuui -t pmzuuiservice .

# created project service image
docker build --file=Dockerfile_projectservice -t projectservice .

# created user service image
docker build --file=Dockerfile_userservice -t userservice .

# command to docker-compose up
docker-compose up --scale projectmanagermysqldb=3