package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.controller.Message;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafka;

    public void send(String topic,Message msg) {
        kafka.send(topic, msg);
    }

}
