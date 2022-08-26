package ru.aberezhnoy.bridge;

public class PageFactory {

    //    public static WebPage createNewPage(WebPage webPage, Theme theme) {
//        if (webPage.equals(About)) {
//            return new About(theme);
//        }
//        if (webPage.equals(Careers)) {
//            return new Careers(theme);
//        }
//    }
    public static WebPage createAboutPage(Theme theme) {
        return new About(theme);
    }

    public static WebPage createCareersPage(Theme theme) {
        return new Careers(theme);
    }
}
