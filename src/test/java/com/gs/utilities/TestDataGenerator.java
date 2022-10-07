package com.gs.utilities;

import org.junit.Test;

import java.util.Random;

public class TestDataGenerator {
    @Test
    public void test(){
        System.out.println(generateRandomText(256));
    }
    /**
     * This method is used to create random text with specific length
     * @param length
     * @return
     */
    public String generateRandomText(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public String suffix(String name){
        name = name + new Random().nextInt(10000);
        return name;
    }
}
