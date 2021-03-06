package com.Profiling.Profiling.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GuestCategorie")
public class ProfileCategorie {

    @Id
    private ClickCategorie click;

    private  int clickOnCategorie;


    public ProfileCategorie(ClickCategorie click, int clickOnCategorie) {
        this.click = click;
        this.clickOnCategorie = clickOnCategorie;
    }

    public ClickCategorie getClick() {
        return click;
    }

    public void setClick(ClickCategorie click) {
        this.click = click;
    }

    public int getClickOnCategorie() {
        return clickOnCategorie;
    }

    public void setClickOnCategorie(int clickOnCategorie) {
        this.clickOnCategorie = clickOnCategorie;
    }
}
