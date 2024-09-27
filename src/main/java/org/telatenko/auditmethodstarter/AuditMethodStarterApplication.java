package org.telatenko.auditmethodstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AuditMethodStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuditMethodStarterApplication.class, args);
    }
}
