package com.example.cv_receiver.kafka;

import com.example.cv_receiver.dto.ApplicantInfo;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantCvProducer {

    private NewTopic topic;

    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(ApplicantInfo applicantsCv) {
        Message<ApplicantInfo> message = MessageBuilder
                .withPayload(applicantsCv)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        System.out.println("sent info via kafka " + message);
        kafkaTemplate.send(message);
    }
}
