package seedu.inventorydock.logging;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.inventorydock.exception.InventoryDockException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerConfigTest {
    private Logger rootLogger;
    private Handler[] originalHandlers;
    private Path logPath;

    @BeforeEach
    public void setUp() {
        rootLogger = Logger.getLogger("");
        originalHandlers = rootLogger.getHandlers().clone();

        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
            handler.close();
        }
    }

    @AfterEach
    public void tearDown() throws IOException {
        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
            handler.close();
        }

        for (Handler handler : originalHandlers) {
            rootLogger.addHandler(handler);
        }

        if (logPath != null) {
            Files.deleteIfExists(logPath);
            Files.deleteIfExists(logPath.getParent());
            Files.deleteIfExists(logPath.getParent().getParent());
        }
    }

    @Test
    public void createsLogFile_removesConsoleHandler_addsFileHandler()
            throws IOException, InventoryDockException {
        Path tempDir = Files.createTempDirectory("logger-test");
        logPath = tempDir.resolve("logs").resolve("test.log");

        rootLogger.addHandler(new ConsoleHandler());

        LoggerConfig loggerConfig = new LoggerConfig(logPath.toString());
        loggerConfig.setup();

        assertTrue(Files.exists(logPath));

        Handler[] handlers = rootLogger.getHandlers();
        assertFalse(Arrays.stream(handlers).anyMatch(handler -> handler instanceof ConsoleHandler));
        assertTrue(Arrays.stream(handlers).anyMatch(handler -> handler instanceof FileHandler));
    }
}
