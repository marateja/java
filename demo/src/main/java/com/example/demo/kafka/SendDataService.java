package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SendDataService {

    Consumer<String, String> consumer;

    public SendDataService(ConsumerFactory<String, String> consumerFactory) {
        consumer = consumerFactory.createConsumer("group-for-online","reader");
        consumer.subscribe(Arrays.asList("online"));
    }

    public List<String> getAll(){
        List<String> res= new ArrayList<>();
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.key());
            res.add(record.value());
        }
        return res;
    }

}