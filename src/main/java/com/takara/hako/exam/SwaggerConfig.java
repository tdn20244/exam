package com.takara.hako.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author cyourin
 * @create 2019-03-06-9:31
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("cyourin", "", "tdn20244@sina.com");

    public static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo(
                    "在线考试系统",
                    "前后台联调api文档",
                    "1.0",
                    "urn:tos", DEFAULT_CONTACT,
                    "Apache 2.0",
                    "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
    }


}
