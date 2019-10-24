# SpringCloud-Docker

## RELEASE1 - Discovery and Config server 

SpringCloud project with Discovery and Config server, a postgresql database, a server project connected with postgresql that gets data and a UI project that shows that data to the user 

## RELEASE2 - Hystrix
This release shows how to implement the Hystrix concepts chapter 5 of Spring Microservices in Action, the class TeachingClassServiceDB has an example of the next concepts

* Circuit Breaker (method listClasses)
* Fallback (method listClasses)
* Bulkheads (method getExampleProperty)

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
* [Config](http://localhost:8888/postgresql/docker)
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

## Documentation
[MicroServices and Docker](https://docs.google.com/document/d/1Nl-01uY2qwOkfeiMySlihSKqqlsS3DFwrofJ-WgGyGY/edit#heading=h.e0y84wpdmvxh) - Microservices and Docker documentation
