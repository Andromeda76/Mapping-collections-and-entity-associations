package com.example.springdatawthboot.config;




import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.http.ResponseCookie;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;



//@EnableWebFlux
@Configuration
@EntityScan(basePackages = {"com.example.springdatawthboot.entity"})

@SpringBootApplication
        (scanBasePackages = "com.example.springdatawthboot")

@EnableJpaRepositories(basePackages = {
                "com.example.springdatawthboot.facade"})

@EnableReactiveMongoRepositories(basePackages =
        "com.example.springdatawthboot.facade.mongo")

@EnableAsync
@EnableScheduling

//@EnableAspectJAutoProxy(proxyTargetClass = true)

public class Config implements InitializingBean, DisposableBean {

        public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Bean
    TaskScheduler taskScheduler() {
        var tpts = new ThreadPoolTaskScheduler();
        tpts.setPoolSize(3);
        tpts.setThreadNamePrefix("tsc4-");
        tpts.setErrorHandler(Throwable::printStackTrace);
        return tpts;
    }

}
