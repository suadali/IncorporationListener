package com.incorporationRabbit.incorporationRabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private StudentRepository studentRepository;

    public MessageListener (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.queueName)
    public void listener(Student student) {
        System.out.println(student);
        studentRepository.save(student);
    }
}
