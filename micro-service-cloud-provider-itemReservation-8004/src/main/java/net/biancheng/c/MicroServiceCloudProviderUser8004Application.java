package net.biancheng.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Spring cloud Eureka 客户端，自动将本服务注册到 Eureka Server 注册中心中
public class MicroServiceCloudProviderUser8004Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProviderUser8004Application.class, args);
    }
}