package id.ten.realtimedashboard.service;

import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class.getName());

    @Value("${kafka.topic}")
    public String TOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {

        while(true) {
            Thread.sleep(1000);

            String data = generateData();

            logger.info(String.format("$$ -> Producing message --> %s",data));
            this.kafkaTemplate.send(TOPIC,data);
        }



    }

    private String generateData() {
        int min = 1;
        int max = 100;
        int data = min + (int)(Math.random() * ((max - min) + 1));
        return String.valueOf(data);
    }
}
