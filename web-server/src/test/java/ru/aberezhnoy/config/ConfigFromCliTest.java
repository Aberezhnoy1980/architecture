package ru.aberezhnoy.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFromCliTest {
    public ServerConfig config;

    @Test
    public void testConfigFromFile() {
        String[] args = {"/homepath", "1234"};
        config = new ConfigFromCli(args);
        Assert.assertEquals(args[0], config.getUrlHome());
        Assert.assertEquals(Integer.parseInt(args[1]), config.getPort());
    }
}
