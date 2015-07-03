package com.google.android.gms.plus.sample.quickstart;

/**
 * Created by fares on 7/3/15.
 */
public class Book {

    private String title;
    private String subtitle;
    private String[] authors;
    private String description;
    private String[] industryIdentifiers;
    private String previewLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(String[] industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }
}
