package com.example.blogger.resources;

import com.example.blogger.domain.Blog;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlogCreateRequestTests {

    @Test
    public void should_convert_request_to_blog() throws Exception {
        /*
        Test case three parts -- AAA
        1. A arrange
        2  A act
        3. A assert
         */
        BlogCreateRequest request = new BlogCreateRequest("My awesome blog", "My blog"); // arrange
        Blog blog = request.toBlog(); // act
        assertThat(blog).isNotNull(); // assert
        assertThat(blog.getTitle()).isEqualTo("My blog");
        assertThat(blog.getBody()).isEqualTo("My awesome blog");
        assertThat(blog.getWordCount()).isEqualTo(3);
    }
}
