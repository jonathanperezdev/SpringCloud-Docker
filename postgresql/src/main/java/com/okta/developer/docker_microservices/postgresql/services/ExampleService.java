package com.okta.developer.docker_microservices.postgresql.services;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ExampleService implements Example{
    private String exampleProperty;

    public ExampleService(@Value("${example.property}") String exampleProperty) {
        this.exampleProperty = exampleProperty;
    }

    private static Integer numOfCalls = 0;
    @Override
    @HystrixCommand(threadPoolKey = "getExampleProperty",
            commandProperties ={
                    //Number of consecutive calls that must occur within a 10-second or value defined in (metrics.rollingStats.timeInMilliseconds) window
                    // before Hystrix will consider tripping the circuit breaker for the call
                    @HystrixProperty(
                            name="circuitBreaker.requestVolumeThreshold",
                            value="2"),
                    //Percentage of calls that must fail
                    @HystrixProperty(
                            name="circuitBreaker.errorThresholdPercentage",
                            value="50"),
                    //Amount of time Hystrix will sleep once the circuit breaker is tripped
                    // before Hystrix will allow another call through to see if the service is healthy again
                    @HystrixProperty(
                            name="circuitBreaker.sleepWindowInMilliseconds",
                            value="8000"),
                    //Used to control the size of the window that will be used by Hystrix to monitor for problems with a service call
                    @HystrixProperty(
                            name="metrics.rollingStats.timeInMilliseconds",
                            value="15000"),
                    @HystrixProperty(
                            name="metrics.rollingStats.numBuckets",
                            value="2"),
                    @HystrixProperty(
                            name="execution.isolation.thread.timeoutInMilliseconds",
                            value="2000")
            })
    public String getExampleProperty(){
        numOfCalls ++;
        if(numOfCalls > 1){
            sleep(3000);
            numOfCalls = 0;
        }
        return this.exampleProperty;
    }

    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
