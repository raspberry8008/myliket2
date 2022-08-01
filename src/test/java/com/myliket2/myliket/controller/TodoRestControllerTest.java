package com.myliket2.myliket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myliket2.myliket.dto.TodoDTO;
import com.myliket2.myliket.service.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    TodoService todoService;

    @DisplayName("전체 할일 목록 조회")
    @Test
    void allCategoryTodoList() throws Exception {
        mockMvc.perform(get("/categorys/todos")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

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


    @DisplayName("할일 등록 테스트")
    @Test
    void insertTodo() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .todoTitle("등록 테스트 제목")
                .todoContent("등록 테스트 내용")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        //json 형식으로 데이터를 보낸다고 명시
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        //Object로 만든 todoVO을 json형식의 String으로 만들기 위해 objectMapper를 사용
                        .content( objectMapper.writeValueAsString(todoDTO)))
                // Http 201을 기대
                .andExpect(status().is(201))
                // 화면에 결과 출력
                .andDo(print());
    }

    @DisplayName("할일 수정 테스트")
    @Test
    void updateTodo() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .todoNo(4L)
                .categoryId("57E28D94037340779DAF421C2C493789")
                .todoTitle("수정테스트 제목")
                .todoContent("수정테스트 내용")
                .todoDay(LocalDate.of(2022,8,01))
                .todoTime(LocalTime.of(11,00,00))
                .todoState("TR")
                .build();

        mockMvc.perform(put("/categorys/57E28D94037340779DAF421C2C493789/todos/4")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(todoDTO)))
                .andExpect(status().is(201))
                .andDo(print());
    }

    @DisplayName("할일 삭제 테스트")
    @Test
    void deleteTodo() throws Exception {
        mockMvc.perform(delete("/todos/23")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content( objectMapper.writeValueAsString("23")))
                .andExpect(status().is(201))
                .andDo(print());
    }
}