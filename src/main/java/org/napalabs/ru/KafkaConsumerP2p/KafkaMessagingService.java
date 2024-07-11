package org.napalabs.ru.KafkaConsumerP2p;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMessagingService {

    private static final String USER_TASK_INCOMING_TOPIC = "${spring.kafka.consumer.topic}";
    private static final String CONSUMER_GROUP_ID = "${spring.kafka.consumer.group-id}";

    @KafkaListener(
            topics = USER_TASK_INCOMING_TOPIC,
            groupId = CONSUMER_GROUP_ID,
            properties = {"spring.json.value.default.type=java.lang.String"}
    )
    public void createUserTask(String msg) {
        System.out.println("msg:" + msg);
    }
}
