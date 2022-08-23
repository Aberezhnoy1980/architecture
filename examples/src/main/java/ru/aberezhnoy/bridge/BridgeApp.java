package ru.aberezhnoy.bridge;

public class BridgeApp {

    public static void main(String[] args) {

        DarkTheme darkTheme = new DarkTheme();

        // Some gag ..
        WebPage aboutLightTheme = PageFactory
                .createAboutPage(ThemeFactory
                        .creatLightTheme());

        WebPage careersLightTheme = PageFactory
                .createCareersPage(ThemeFactory
                        .creatLightTheme());


        About aboutDarkTheme = new About(darkTheme);
        Careers careersDarkTheme = new Careers(darkTheme);

        System.out.println(aboutDarkTheme
                .getContent()); // output: "about page in Dark Black"
        System.out.println(careersDarkTheme
                .getContent()); // output: "Careers page in Dark Black"

        System.out.println(aboutLightTheme
                .getContent());
        System.out.println(careersLightTheme
                .getContent());

        System.out.println(PageFactory
                .createAboutPage(ThemeFactory
                        .creatAquaTheme())
                .getContent());
        System.out.println(PageFactory
                .createCareersPage(ThemeFactory
                        .creatAquaTheme())
                .getContent());
    }
}
