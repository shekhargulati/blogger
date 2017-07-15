package com.example.blogger.resources;

import java.net.URI;

import javax.validation.Valid;

import com.example.blogger.domain.Blog;
import com.example.blogger.services.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/blogs")
public class BlogResource {

    private BlogService blogService;

    @Autowired
    public BlogResource(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid BlogCreateRequest request) {
        /*
        1. Convert request to domain object
        2. Call a class that will save my domain object
        3. Create a response and return it
         */
        Blog blog = request.toBlog();
        Blog saved = blogService.createAndNotify(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/v1/blogs/" + saved.getId()));
        return new ResponseEntity<>(
                headers,
                HttpStatus.CREATED
        );
    }
}
