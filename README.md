# SpringCloud-Docker

## RELEASE1 - Discovery and Config server 

SpringCloud project with Discovery and Config server, a postgresql database, a server project connected with postgresql that gets data and a UI project that shows that data to the user 

## Build
To build the java projects and create the docker images, in the root folder (SpringCloud-Docker/) execute the next command.

```
mvn clean install
```

## Deploy

Execute in the root folder (SpringCloud-Docker/) the next command.

```
# Deploy all the services in detached mode
docker-compose up -d

# Deploy a specific component in detached mode, example Discovery
docker-compose up -d discovery

# Deploy a specific component to see the logs in the console
docker-compose up discovery
```

## Components
* [Discovery](http://localhost:8761/) 
* [Config](http://localhost:8888/posgresql/docker)
* [Server](http://localhost:8081/class) - Server project connected with postgresql database
* [UI](http://localhost:8080) - Front end server connected with backend server 

## Stop or Undeploy

Execute in the root folder (SpringCloud-Docker/) the next command.

```
# Undeploy all the services
docker-compose down

# Stop a specific image or service, by example Discovery
docker-compose stop discovery

```

## Useful Docker Commands
```
# See the running containers and his status
docker ps

#Run Image Interactive mode, this allows you get into the image and execute commands
docker run -it image_name sh