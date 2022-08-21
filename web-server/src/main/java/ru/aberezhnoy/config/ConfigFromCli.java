package ru.aberezhnoy.config;

public class ConfigFromCli implements ServerConfig {

    private final String urlHome;

    private final int port;

    public ConfigFromCli(String[] args) {
        System.out.println("Getting config from command line parameters");
        if (args.length < 2) {
            throw new IllegalStateException("Not enough parameter specified");
        }
        this.urlHome = args[0];
        this.port = Integer.parseInt(args[1]);
    }
    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getUrlHome() {
        return this.urlHome;
    }
}
