package com.support.framework.support;

import io.codearte.jfairy.Fairy;

public class DataGenerator {

    private static Fairy fairy = Fairy.create();

    public static String getRandomEmail() {
        return fairy.person().getEmail();
    }

    public static String getRandomFullName() {
        return fairy.person().getFullName();
    }

    public static String getRandomLastName() {
        return fairy.person().getLastName();
    }

    public static String getRandomName() {
        return fairy.person().getFirstName();
    }

    public static String getRandomParagraph(int sentenceCount) {
        return fairy.textProducer().paragraph(sentenceCount);
    }

    public static String getRandomSentence(int worldCount) {
        return fairy.textProducer().sentence(worldCount);
    }

}

