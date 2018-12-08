package com.pacgame.testEnv;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class JavaFxThread {

    private static boolean jfxIsSetup;

    private static void doOnJavaFXThread(Runnable pRun) throws RuntimeException {
        if (!jfxIsSetup) {
            setupJavaFX();
            jfxIsSetup = true;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            pRun.run();
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupJavaFX() throws RuntimeException {
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            new JFXPanel(); // initializes JavaFX environment
            latch.countDown();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void run(Runnable runnable)
    {
        doOnJavaFXThread(runnable);
    }
}
