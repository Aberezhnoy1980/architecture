package ru.aberezhnoy.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFromFixedValueTest {
    public ServerConfig config;

    @Test
    public void testConfigFromFile() {
        config = new ConfigFromFixedValue();
        Assert.assertEquals("/Users/alex/Documents/Study/Portfolio/architecture/www", config.getUrlHome());
        Assert.assertEquals(8088, config.getPort());
    }
}
