package ru.aberezhnoy.bridge;

public class About extends WebPageAbstract implements WebPage {

//    protected Theme theme;

    public About(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "About page in " + this.theme.getColor();
    }
}
