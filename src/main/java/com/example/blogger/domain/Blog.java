package com.example.blogger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String body;
    private int wordCount;

    public Blog(String title, String body) {
        this(0, title, body);
    }

    public Blog(long id) {
        this(id, null, null);
    }

    public Blog(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.wordCount = this.body.split("\\s").length;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public long getId() {
        return id;
    }
}
