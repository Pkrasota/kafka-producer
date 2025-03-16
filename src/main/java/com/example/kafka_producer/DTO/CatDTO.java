package com.example.kafka_producer.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CatDTO {
    private long id;
    private String catName;
    private int age;
    private String color;

}
