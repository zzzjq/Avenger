package avenger.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午6:09:48
 *
 **/
@SpringBootApplication
@ComponentScan("avenger")
@Slf4j
public class AvengerApplication {

	public static void main(String[] args) {
		log.info("Avengers !!!");
		SpringApplication.run(AvengerApplication.class, args);
		log.info("Assemble !!!");
	}
}
