package com.vesska;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class GithubTest {

    @Test
    void checkThatSoftAssertionsHasCodeExampleForJUnit5() {

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $$(".js-repo-nav ").findBy(Condition.visible).$("[data-tab-item=i5wiki-tab]").click();
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        $$(byText("SoftAssertions")).find(Condition.visible).click();
        $(".markdown-body").shouldHave(Condition.text("3. Using JUnit5 extend test class:"));

    }
}
