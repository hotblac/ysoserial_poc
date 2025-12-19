package org.dontpanic.ysoserial.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();

        if (args.length < 1) {
            System.out.println("Usage: java -jar ysoserial-jackson-1.0-SNAPSHOT-all.jar <file>");
            System.out.println("Sample JSON:" + sampleJson(objectMapper));
            return;
        }

        String filename = args[0];
        System.out.printf("Reading file %s%n", filename);

        Object[] shapes = objectMapper.readValue(new File(filename), Object[].class);
        System.out.println("Read shapes: " + Arrays.toString(shapes));
    }

    private static String sampleJson(ObjectMapper objectMapper) throws Exception {
        Shape circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(10.0, 20.0);
        return objectMapper.writeValueAsString(new Shape[]{circle, rectangle});
    }

}