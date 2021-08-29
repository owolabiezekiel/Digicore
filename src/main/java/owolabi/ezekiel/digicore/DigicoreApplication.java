package owolabi.ezekiel.digicore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DigicoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(DigicoreApplication.class, args);
  }

}
