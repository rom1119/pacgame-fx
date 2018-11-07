package com.pacgame.provider.builder.component;

import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.provider.component.ui.text.LabelBuilder;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabelBuilderTest extends TestCase {

    private LabelBuilder labelBuilder;

    @BeforeEach
    protected void setUp() {
        labelBuilder = new LabelBuilder();
    }

    @Test
    void build() {
        Assert.assertEquals(String.valueOf(new Label("Test")), labelBuilder.buildedObject(), 0);

    }
}