package com.example.kafka_producer.service;

import com.example.kafka_producer.model.Cat;
import com.example.kafka_producer.repository.CatRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CatService {
    private final CatRepository catRepository;
    private final KafkaProducer kafkaProducer;
    private final Random rand = new Random();

    public CatService(CatRepository catRepository, KafkaProducer kafkaProducer) {
        this.catRepository = catRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Scheduled(fixedRate = 3000)
    public void sendRandomCat() {
        List<Cat> allCats = catRepository.findAll();
        if (allCats.isEmpty()) return;

        Cat randomCat = allCats.get(rand.nextInt(allCats.size()));
        kafkaProducer.sendMessage(randomCat.toString());
    }

    public void setupCats() {
        List<Cat> cats = Arrays.asList(
                new Cat("Tom", 3, "Grey"),
                new Cat("Jerry", 2, "Brown"),
                new Cat("Simba", 4, "Golden"),
                new Cat("Bella", 1, "White"),
                new Cat("Luna", 2, "Black"),
                new Cat("Max", 5, "Tabby"),
                new Cat("Milo", 3, "Orange"),
                new Cat("Chloe", 4, "Calico"),
                new Cat("Leo", 6, "Gray"),
                new Cat("Nala", 2, "White"),
                new Cat("Coco", 7, "Brown"),
                new Cat("Oliver", 5, "Black"),
                new Cat("Charlie", 3, "Tabby"),
                new Cat("Sasha", 1, "Black"),
                new Cat("Felix", 8, "Grey"),
                new Cat("Zoe", 2, "White"),
                new Cat("Rocky", 6, "Gray"),
                new Cat("Misty", 5, "Calico"),
                new Cat("Smokey", 7, "Silver"),
                new Cat("Ruby", 2, "Orange")
        );
        catRepository.saveAll(cats);
    }
}
