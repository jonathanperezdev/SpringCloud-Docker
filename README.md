# SpringCloud-Docker

## RELEASE1 - Discovery and Config server 

SpringCloud project with Discovery and Config server, a postgresql database, a server project connected with postgresql that gets data and a UI project that shows that data to the user 

## RELEASE2 - Hystrix
This release shows how to implement the Hystrix concepts chapter 5 of Spring Microservices in Action, the class TeachingClassServiceDB has an example of the next concepts

* Circuit Breaker (method listClasses)
* Fallback (method listClasses)
* Bulkheads (method getExampleProperty)

## RELEASE3 - SpringCloud Gateway
This release show how to set up SpringCloud Gateway server for routing that replaces Netflix Zuul

First at all you should enabled the actuator gateway endpoint to validate by example the routes in gateway server to do this go to the properties file into the config server (gateway-docker.yml) and add next properties
* management.endpoint.gateway.enabled=true //This is to enable gateway endpoints
* endpoints.web.exposure.include=gateway //This is for expose the gateway endpoints 

The Gateway can be configured to create routes based on services registered with a DiscoveryClient compatible service registry. 
* spring.cloud.gateway.discovery.locator.enabled=true

To see the routes after do the last steps 
http://localhost:5555/actuator/gateway/routes/

Next URL has all the gateway endpoints
[Gateway Actuator Endpoints](https://cloud.spring.io/spring-cloud-gateway/reference/html/#recap-list-of-all-endpoints) 
[Important Documentation](https://github.com/spring-cloud/spring-cloud-gateway/blob/master/docs/src/main/asciidoc/spring-cloud-gateway.adoc#fluent-java-routes-api)

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
* [Gateway](http://localhost:5555/actuator/gateway/routes) - Spring cloud gateway

## Documentation
* [Documentation](https://docs.google.com/document/d/1Nl-01uY2qwOkfeiMySlihSKqqlsS3DFwrofJ-WgGyGY/edit#) - Documentation

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