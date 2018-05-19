package com.xm.ctyptocoin.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //未配置DataSource时需要先排除，否则启动报错
@SpringBootApplication()
@ComponentScan(value={"com.*"})
//@EnableJpaRepositories(basePackages={"com.*"})
//@EntityScan("*.entity")
public class TradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}
}
