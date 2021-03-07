package me.lubin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMQ8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQ8801.class, args);
    }

}
