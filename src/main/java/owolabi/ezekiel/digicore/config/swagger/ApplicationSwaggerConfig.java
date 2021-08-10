package owolabi.ezekiel.digicore.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationSwaggerConfig {
  @Bean
  public Docket digicoreApi(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select().apis(RequestHandlerSelectors.basePackage("owolabi.ezekiel.digicore"))
        .paths(PathSelectors.any())
        .build().apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Digicore Technical Assessment - Springboot Swagger Configuration")
        .description("\"Swagger configuration for application\"")
        .version("1.0")
        .license("Apache 2.0")
        .contact(new Contact("Owolabi Tobiloba", "github.io/owolabiezekiel", "owo.ezekiel@gmail.com"))
        .build();
  }
}
