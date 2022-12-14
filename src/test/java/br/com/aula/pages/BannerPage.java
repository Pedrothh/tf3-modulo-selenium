package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static br.com.aula.pages.HomePage.btnCookies;

public class BannerPage extends BasePage{
    private static final By textValidate =
            By.cssSelector("#root-app > div > div.ui-search-main.ui-search-main--deals.ui-search-main--without-header.ui-search-main--only-products.shops__search-main > aside > div.ui-search-breadcrumb.shops__breadcrumb > h1");

    private static final By plantaoBlackFriday =
            By.cssSelector(".main-slider-container > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)");

    private static final By ofertas =
            By.cssSelector("h1.title");

    private static final By textVeiculos =
            By.cssSelector(".category-list__title");

    @Step("Valida se houve redirecionamento")
    public String validarTextNaTela(){
        try {
            return getText(textValidate);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            try {
                return getText(ofertas);
            } catch (Exception err2) {
                System.out.println(err2.getMessage());
                try {
                    return getText(textVeiculos);
                } catch (Exception err3){
                    return "Deu ruim na validação de texto! " + err3.getMessage();
                }
            }
        }
    }


    @Step("Clica no Banner Black Friday")
    public void clicarPlantaoBlackFriday(){
        click(btnCookies);
        click(plantaoBlackFriday);
    }

}
