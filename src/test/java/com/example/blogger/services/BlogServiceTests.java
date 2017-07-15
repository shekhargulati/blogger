package com.example.blogger.services;

import com.example.blogger.domain.Blog;
import com.example.blogger.repositories.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTests {

    @Mock
    BlogRepository blogRepository;

    @Mock
    Notifier notifier;

    @InjectMocks
    BlogService blogService;

    @Test
    public void should_create_a_blog_and_notify() throws Exception {
        Blog blog = new Blog("title", "body");
        when(blogRepository.save(blog)).thenReturn(
                new Blog(1L, "title", "body"));
        Blog saved = blogService.createAndNotify(blog);
        assertThat(saved.getId()).isEqualTo(1L);
        assertThat(saved.getTitle()).isEqualTo("title");
        assertThat(saved.getBody()).isEqualTo("body");
        assertThat(saved.getWordCount()).isEqualTo(1);
        verify(notifier).notify("Created a new blog 1");
    }
}
