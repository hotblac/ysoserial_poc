package org.dontpanic.ysoserial.simple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    final static Path EXPLOIT_FLAG = Paths.get(System.getProperty("user.dir"), "Simple_exploitedX.flag");

    @AfterEach
    void tearDown() throws Exception{
        Files.deleteIfExists(EXPLOIT_FLAG);
    }

    @Test
    void exploitWithModifiedSerializedFile() throws Exception {
        Main.main(new String[]{"src/test/resources/SimpleExploit.payload.bin"});
        assertTrue(Files.exists(EXPLOIT_FLAG));
    }
}