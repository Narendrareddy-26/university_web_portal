package com.university.portal.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String evaluate(String text) {
        int words = text.split(" ").length;
        int score = Math.min(10, words / 50);

        return "AI Score: " + score +
                "\nGood structure. Improve grammar and clarity.";
    }
}

