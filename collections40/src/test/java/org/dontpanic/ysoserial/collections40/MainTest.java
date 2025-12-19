package org.dontpanic.ysoserial.collections40;

import org.apache.commons.collections4.FunctorException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    final static Path EXPLOIT_FLAG = Path.of(System.getProperty("user.dir") + "/CommonsCollections2_exploited.flag");

    @AfterEach
    void tearDown() throws Exception{
        Files.deleteIfExists(EXPLOIT_FLAG);
    }

    @Test
    void exploitWithYsoserialCommonsCollections2GadgetChain() throws Exception {

        try {
            Main.main(new String[]{"src/test/resources/CommonsCollections2.payload.bin"});
        } catch (FunctorException e) {
            // Expected
        }

       assertTrue(Files.exists(EXPLOIT_FLAG));
    }
}