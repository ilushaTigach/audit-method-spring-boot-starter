package org.telatenko.auditmethodstarter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.telatenko.auditmethodstarter")
public class AuditAutoConfiguration {
}
