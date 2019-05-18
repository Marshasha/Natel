package com.company;

public class Article {

    /*
    By default Jackson maps the fields of a JSON object to fields in a Java object by matching the names of the JSON
    field to the getter and setter methods in the Java object. Jackson removes the "get" and "set" part of the names
    of the getter and setter methods, and converts the first character of the remaining name to lowercase.
    (http://tutorials.jenkov.com/java-json/jackson-objectmapper.html)
     */

    private String author;
    private String title;
    private String journal;
    private String url;

    /*
    A JSON field named author matches the Java getter and setter methods called getAuthor() and setAuthor().
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return author + ". " + title + ". In " + journal + ".\n(" + url + ")";
    }
}