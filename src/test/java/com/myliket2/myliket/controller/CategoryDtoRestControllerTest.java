package com.myliket2.myliket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myliket2.myliket.domain.vo.CategoryVO;
import com.myliket2.myliket.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategoryDtoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    CategoryService categoryService;

    @DisplayName("카테고리 전체목록 조회 테스트")
    @Test
    void allCategoryList() throws Exception {
        mockMvc.perform(get("/categorys")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("카테고리 상세조회 조회 테스트")
    @Test
    void getCategoryDetail() throws Exception {
        mockMvc.perform(get("/categorys/57E28D94037340779DAF421C2C493789")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("카테고리 등록 테스트")
    @Test
    void insertCategory() throws Exception {
        String isCategoryId = UUID.randomUUID().toString().replace("-","");

        CategoryVO requestInsert = CategoryVO.builder()
                .categoryId(isCategoryId)
                .categoryName("등록테스트")
                .build();

        mockMvc.perform(post("/categorys")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(requestInsert)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @DisplayName("카테고리 수정 테스트")
    @Test
    void updateCategory() throws Exception {
        CategoryVO categoryVO
                =CategoryVO.builder()
                .categoryId("57E28D94037340779DAF421C2C493789")
                .categoryName("수정테스트")
                .categoryState("CY")
                .build();

        mockMvc.perform(put("/categorys")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content( objectMapper.writeValueAsString(categoryVO)))
                .andExpect(status().is(201))
                .andDo(print());
    }

    @DisplayName("카테고리 삭제 테스트")
    @Test
    void deleteCategory() throws Exception {
        mockMvc.perform(delete("/categorys/639D0C0FCBF9406FA303406796C3D6F4")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content( objectMapper.writeValueAsString("639D0C0FCBF9406FA303406796C3D6F4")))
                .andExpect(status().is(201))
                .andDo(print());
    }
}