package org.dontpanic.ysoserial.jackson;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    final static Path EXPLOIT_FLAG = Paths.get(System.getProperty("user.dir"), "TemplatesImpl_exploited.flag");

    @AfterEach
    void tearDown() throws Exception{
        Files.deleteIfExists(EXPLOIT_FLAG);
    }

    @Test
    void exploitJacksonWithXalanTemplatesImpl() throws Exception {

        try {
            Main.main(new String[]{"src/test/resources/JacksonExploit_touchfile.json"});
        } catch (JsonMappingException e) {
            // Expected
        }

        assertTrue(Files.exists(EXPLOIT_FLAG));
    }
}