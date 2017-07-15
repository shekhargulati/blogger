package com.example.blogger.resources;

import com.example.blogger.domain.Blog;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogCreateRequest {

    private final String title;
    private final String body;

    @JsonCreator
    public BlogCreateRequest(@JsonProperty("body") String body, @JsonProperty("title") String title) {
        this.body = body;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Blog toBlog() {
        return new Blog(this.title, this.body);
    }
}
