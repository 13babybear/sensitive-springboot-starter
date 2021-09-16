package cn.bounter.sensitive.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensitiveAutoConfiguration {

    @Bean
    public SensitiveValueFilter sensitiveValueFilter() {
        return new SensitiveValueFilter();
    }

}
