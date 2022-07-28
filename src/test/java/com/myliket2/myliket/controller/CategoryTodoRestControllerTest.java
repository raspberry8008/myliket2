package com.myliket2.myliket.controller;

import com.myliket2.myliket.service.CategoryTodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategoryTodoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryTodoService categoryTodoService;

    @DisplayName("단일 카테고리의 할일 목록 조회")
    @Test
    void getCategoryTodoList() throws Exception {
        mockMvc.perform(get("/categorys/57E28D94037340779DAF421C2C493789/todos")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("할일 단일 조회")
    @Test
    void getTodoDetail() throws Exception {
        mockMvc.perform(get("/categorys/57E28D94037340779DAF421C2C493789/todos/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }
}