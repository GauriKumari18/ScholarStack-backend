package com.gaurikumari.marketplace.util;

import org.springframework.stereotype.Component;

@Component
public class TechStackCalculator {

    // Each known technology contributes a fixed score when found in the tech stack string.
    private static final double DEFAULT_TECH_SCORE = 5;
    private static final double ADVANCED_TECH_SCORE = 10;

    // Technologies considered "advanced" and weighted higher
    private static final String[] ADVANCED_TECHNOLOGIES = {
            "spring boot", "kubernetes", "docker", "kafka", "microservices",
            "machine learning", "tensorflow", "graphql", "react native", "aws"
    };

    /**
     * Calculates a score based on the number and weight of technologies
     * mentioned in the techStack string (e.g. "Spring Boot, React, MySQL").
     */
    public double calculateScore(String techStack) {
        if (techStack == null || techStack.trim().isEmpty()) {
            return 0;
        }

        String[] technologies = techStack.split(",");
        double totalScore = 0;

        for (String tech : technologies) {
            String normalized = tech.trim().toLowerCase();
            if (normalized.isEmpty()) {
                continue;
            }

            if (isAdvancedTechnology(normalized)) {
                totalScore += ADVANCED_TECH_SCORE;
            } else {
                totalScore += DEFAULT_TECH_SCORE;
            }
        }

        return totalScore;
    }

    private boolean isAdvancedTechnology(String tech) {
        for (String advanced : ADVANCED_TECHNOLOGIES) {
            if (tech.contains(advanced)) {
                return true;
            }
        }
        return false;
    }

}