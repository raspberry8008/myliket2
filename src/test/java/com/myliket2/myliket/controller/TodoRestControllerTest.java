package com.myliket2.myliket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.TodoVO;
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


    @DisplayName("할일 전체목록 조회 테스트")
    @Test
    void getTodoList() throws Exception {
        mockMvc.perform(get("/todos")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("할일 상세조회 테스트")
    @Test
    void getTodoDetail() throws Exception {
        mockMvc.perform(get("/todos/2")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE+ ";charset=UTF-8"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @DisplayName("할일 등록 테스트")
    @Test
    void insertTodo() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .todoTitle("등록 테스트 제목")
                .todoContent("등록 테스트 내용")
                .todoDay("20220726")
                .todoTime("120000")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                        .accept(MediaType.APPLICATION_JSON_VALUE+ ";charset=UTF-8")
                        //json 형식으로 데이터를 보낸다고 명시
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        //Object로 만든 todoVO을 json형식의 String으로 만들기 위해 objectMapper를 사용
                        .content( objectMapper.writeValueAsString(todoVO)))
                // Http 201을 기대
                .andExpect(status().is(201))
                // 화면에 결과 출력
                .andDo(print());
    }

    @DisplayName("할일 수정 테스트")
    @Test
    void updateTodo() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .todoNo(2)
                .todoTitle("수정테스트 제목")
                .todoContent("수정테스트 내용")
                .todoDay("20220725")
                .todoTime("210000")
                .build();

        mockMvc.perform(put("/todos/2")
                        .accept(MediaType.APPLICATION_JSON_VALUE+ ";charset=UTF-8")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(todoVO)))
                .andExpect(status().is(201))
                .andDo(print());
    }

    @DisplayName("할일 삭제 테스트")
    @Test
    void deleteTodo() throws Exception {
        mockMvc.perform(delete("/todos/23")
                        .accept(MediaType.APPLICATION_JSON_VALUE+ ";charset=UTF-8")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content( objectMapper.writeValueAsString("23")))
                .andExpect(status().is(204))
                .andDo(print());
    }
}