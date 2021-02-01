package app.majime.infrastructure.lims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EntityScan("app.majime")
@EnableSwagger2
public class LimsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimsApplication.class, args);
    }
}
