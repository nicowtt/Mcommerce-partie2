package com.clientui;

//import com.clientui.exceptions.CustomErrorDecoder;
import com.clientui.configurations.LocalRibbonClientConfiguration;
import com.clientui.proxies.MicroserviceProduitsProxy;
import feign.Feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.clientui")
@RibbonClient(name = "microservice-produits", configuration = LocalRibbonClientConfiguration.class)
public class ClientuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientuiApplication.class, args);

		/*	Feign.builder()
				.contract(new SpringMvcContract())
				.errorDecoder(new CustomErrorDecoder())
				.target(MicroserviceProduitsProxy.class, "localhost:9001");
				*/
	}

}
