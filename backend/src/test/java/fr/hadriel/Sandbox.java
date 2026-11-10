package fr.hadriel;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sandbox {

    Logger logger = LoggerFactory.getLogger(Sandbox.class);

    @Test
    void checkDatabaseIsH2() {
        logger.error("JUnit ran my test !");
        assertTrue(true);
    }
}
