package org.dontpanic.ysoserial.simple;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java -jar ysoserial-simple-1.0-SNAPSHOT.jar <file>");
            System.out.println("Creating sample payload...");
            serializeObject();
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

    private static void serializeObject() {

        String filename = "SimpleSafe.payload.bin";
        CommandRunner obj = new CommandRunner("touch Simple_serialized.flag");

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
            System.out.println("Serialized object to file " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}