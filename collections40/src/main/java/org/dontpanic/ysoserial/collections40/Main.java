package org.dontpanic.ysoserial.collections40;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        if (args.length < 1) {
            System.out.println("Usage: java -jar ysoserial-collections40-1.0-SNAPSHOT-all.jar <file>");
            return;
        }

        String filename = args[0];
        System.out.printf("Reading file %s%n", filename);

        try (InputStream is = new FileInputStream(filename)) {
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj = ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}