package com.wallferjdi.wallfer.search;


//Вохможные значения для параметров поиска
public class CategorySearchValues {

    private String title;

    public CategorySearchValues() {
    }

    public CategorySearchValues(String text) {
        this.title = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
