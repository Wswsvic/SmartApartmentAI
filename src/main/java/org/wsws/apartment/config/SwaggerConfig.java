package org.wsws.apartment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("智能公寓助手 API 文档")
                        .version("1.0")
                        .description("AI 赋能的公寓管理助手")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your-email@example.com")));
    }
}