package com.example.yazlab;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "mergedTexts")
public class TextEntity {
    @Id
    public String id;

    public String[] texts;

    public String mergedText;

    public double elapsedTime;

    public TextEntity() {
    }



    public TextEntity(List<String> texts, String mergedText, double elapsedTime) {
        this.texts = texts.toArray(new String[0]);
        this.mergedText = mergedText;
        this.elapsedTime = elapsedTime;
    }


}
