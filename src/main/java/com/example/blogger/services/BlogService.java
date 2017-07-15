package com.example.blogger.services;

import com.example.blogger.domain.Blog;
import com.example.blogger.repositories.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final Notifier notifier;

    @Autowired
    public BlogService(BlogRepository blogRepository, Notifier notifier) {
        this.blogRepository = blogRepository;
        this.notifier = notifier;
    }

    public Blog createAndNotify(Blog blog) {
        Blog saved = blogRepository.save(blog);
        notifier.notify(String.format("Created a new blog %d", saved.getId()));
        return saved;
    }
}
