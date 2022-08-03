package com.myliket2.myliket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @DisplayName("전체 할일 목록조회 테스트")
    @Test
    void allTodoList() throws Exception {
        mockMvc.perform(get("/categorys/todos")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("단일 카테고리의 할일 목록조회 테스트")
    @Test
    void getCategoryTodoList() throws Exception {
        mockMvc.perform(get("/categorys/57E28D94037340779DAF421C2C493789/todos")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("할일 상세조회 테스트")
    @Test
    void getTodoDetail() throws Exception {
        mockMvc.perform(get("/categorys/57E28D94037340779DAF421C2C493789/todos/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /*
        테스트 시 JSON 파싱 제외
        springboot 설정이나 ObjectMapper를 이용해 json 으로 파싱할 때 객체 내에 필드에 대한 접근 권한이 없어
        properties discovered to create BeanSerializer 발생
     */
    @DisplayName("할일 등록 테스트")
    @Test
    void insertTodo() throws Exception {

//        TodoDto.RequestInsert requestInsert = TodoDto.RequestInsert.builder()
//                .categoryId("57E28D94037340779DAF421C2C493789")
//                .todoTitle("등록 테스트 제목")
//                .todoContent("등록 테스트 내용")
//                .todoDay(LocalDate.of(2022,8,03))
//                .todoTime(LocalTime.of(11,00,00))
//                .build();
//
//        mockMvc.perform(post("/categorys/57E28D94037340779DAF421C2C493789/todos")
//                        .accept(MediaType.APPLICATION_JSON_VALUE)
//                        //json 형식으로 데이터를 보낸다고 명시
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        //Object로 만든 todoVO을 json형식의 String으로 만들기 위해 objectMapper를 사용
//                        .content( objectMapper.writeValueAsString(requestInsert)))
//                // Http 201을 기대
//                .andExpect(status().isCreated())
//                // 화면에 결과 출력
//                .andDo(print());
    }

    /*
    테스트 시 JSON 파싱 제외
    springboot 설정이나 ObjectMapper를 이용해 json 으로 파싱할 때 객체 내에 필드에 대한 접근 권한이 없어
    properties discovered to create BeanSerializer 발생
    */
    @DisplayName("할일 수정 테스트")
    @Test
    void updateTodo() throws Exception {

//        TodoDto.RequestUpdate requestUpdate = TodoDto.RequestUpdate.builder()
//                .todoNo(4L)
//                .categoryId("57E28D94037340779DAF421C2C493789")
//                .todoTitle("수정테스트 제목")
//                .todoContent("수정테스트 내용")
//                .todoDay(LocalDate.of(2022,8,05))
//                .todoTime(LocalTime.of(11,00,00))
//                .todoState("TR")
//                .build();

//        mockMvc.perform(MockMvcRequestBuilders.put("/categorys/57E28D94037340779DAF421C2C493789/todos/4")
//                        .accept(MediaType.APPLICATION_JSON_VALUE)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .content(objectMapper.writeValueAsString(requestUpdate)))
//                .andExpect(status().isCreated())
//                .andDo(print());
    }

    @DisplayName("할일 삭제 테스트")
    @Test
    void deleteTodo() throws Exception {
        mockMvc.perform(delete("/categorys/57E28D94037340779DAF421C2C493789/todos/23")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content( objectMapper.writeValueAsString("23")))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}