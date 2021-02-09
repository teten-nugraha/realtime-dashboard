package id.ten.realtimedashboard;

import id.ten.realtimedashboard.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("id.ten")
public class RealtimeDashboardApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	public static void main(String[] args) {
		SpringApplication.run(RealtimeDashboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaProducerService.sendMessage();
	}
}
