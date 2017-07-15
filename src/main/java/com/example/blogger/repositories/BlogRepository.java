package com.example.blogger.repositories;

import com.example.blogger.domain.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
