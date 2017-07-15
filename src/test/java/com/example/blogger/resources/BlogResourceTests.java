package com.example.blogger.resources;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BlogResourceTests extends AbstractRestApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_create_mockmvc_instance() throws Exception {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void should_create_a_blog() throws Exception {
        String json = "{\"title\":\"My first post\", \"body\":\"My awesome first blog\"}";
        mockMvc.perform(
                post("/api/v1/blogs").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/v1/blogs/1"));
    }
}
