package ru.aberezhnoy.bridge;

public class Careers extends WebPageAbstract implements WebPage {

//    protected Theme theme;

    public Careers(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.getColor();
    }
}







