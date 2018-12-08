package com.pacgame.provider.builder.component;

import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.provider.component.ui.text.LabelBuilder;
import com.pacgame.testEnv.JavaFxThread;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

class LabelBuilderTest extends TestCase {

    private LabelBuilder labelBuilder;

    private Label test;


    public LabelBuilderTest() {
        System.out.println("ad");
    }

    @BeforeEach
    protected void setUp() {
        JavaFxThread.run(()->{

            labelBuilder = new LabelBuilder();
            test = labelBuilder.text("Test").build();
        });

    }

    @Test
    void build() {
        Assert.assertEquals("Wartosc nazwy z konstruktora powinna byc rowna wartosci z buildera", String.valueOf(new Label("Test").getText()), test.getText() );

    }
}