package ru.aberezhnoy.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFromFileTest {
    public ServerConfig config;

    @Test
    public void testConfigFromFile() {
        config = new ConfigFromFile("../../../server.properties");
        Assert.assertEquals("/homepath", config.getUrlHome());
        Assert.assertEquals(1234, config.getPort());
    }
}
