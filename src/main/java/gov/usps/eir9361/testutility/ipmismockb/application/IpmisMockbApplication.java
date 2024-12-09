package gov.usps.eir9361.testutility.ipmismockb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "gov.usps.eir9361.testutility.ipmismockb")
@SpringBootApplication
public class IpmisMockbApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpmisMockbApplication.class, args);
	}

}
