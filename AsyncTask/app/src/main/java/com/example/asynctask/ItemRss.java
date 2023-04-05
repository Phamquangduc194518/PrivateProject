package com.example.asynctask;

public class ItemRss {
    private String title;
    private String description;
    private String linkImage;
    private String linkHtml;
    private String datePublic;

    public ItemRss(String title, String description, String linkImage, String linkHtml, String datePublic) {
        this.title = title;
        this.description = description;
        this.linkImage = linkImage;
        this.linkHtml = linkHtml;
        this.datePublic = datePublic;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLinkImage() {
        return this.linkImage;
    }

    public String getLinkHtml() {
        return this.linkHtml;
    }

    public String getDatePublic() {
        return this.datePublic;
    }

    public void printInfo() {
        System.out.println("title: " + this.title);
        System.out.println("description: " + this.description);
        System.out.println("imageLink: " + this.linkImage);
        System.out.println("htmlLink: " + this.linkHtml);
        System.out.println("datePublic: " + this.datePublic);
        System.out.println("====================================");
    }
}
