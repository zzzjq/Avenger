package avenger.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * Avengers Assemble
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午4:39:16
 *
 **/
@SpringBootApplication
@ComponentScan("avenger")
@Slf4j
public class AvengersAssemble {

	public static void main(String[] args) {
		log.info("Avengers !!!");
		SpringApplication.run(AvengersAssemble.class, args);
		log.info("Assemble !!!");
	}
}
