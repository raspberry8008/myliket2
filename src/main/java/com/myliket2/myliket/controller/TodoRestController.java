package com.myliket2.myliket.controller;

import com.myliket2.myliket.domain.dto.*;
import com.myliket2.myliket.domain.vo.TodoVO;
import com.myliket2.myliket.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@RestController
@RequestMapping(value = "/categorys")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 전체 카테고리의 할일을 조회 API
     *
     * @return ResponseEntity<Response> 200 OK, 전체 할일목록
     */
    @GetMapping(value = "/todos")
    public ResponseEntity<Response> allTodoList() throws Exception {
        return ResponseEntity.ok().body(todoService.allTodoList());
    }

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일 조회 API
     *
     * @return ResponseEntity<Response> 200 OK, 카테고리 {categoryId} 의 할일목록
     */
    @GetMapping(value = "/{categoryId}/todos")
    public ResponseEntity<Response> getCategoryTodoList(@PathVariable("categoryId") @NotBlank String categoryId) throws Exception {
        TodoVO todoVO = TodoDto.PathCategoryId.builder().categoryId(categoryId).build();
        Response response = todoService.getCategoryTodoList(todoVO);
        return ResponseEntity.ok().body(response);

    }

    /**
     * 할일 상세조회 API
     *
     * @param categoryId(카테고리아이디), todoNo(할일 고유번호)
     * @return ResponseEntity<Response> 200 OK, 할일 상세정보
     */

    @GetMapping(value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Response> getTodoDetail(@PathVariable("categoryId") @NotBlank String categoryId
            , @PathVariable("todoNo") @NotBlank Long todoNo) throws Exception {
        TodoVO todoVO = TodoDto.PathCategoryId.builder().categoryId(categoryId).todoNo(todoNo).build();

        Response response = todoService.getTodoDetail(todoVO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param requestInsert(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "/{categoryId}/todos")
    public ResponseEntity<Void> insertTodo(@PathVariable("categoryId") @NotBlank String categoryId
            , @RequestBody @Validated TodoDto.RequestInsert requestInsert) throws Exception {

        if (categoryId.equals(requestInsert.getCategoryId())) {
            todoService.insertTodo(requestInsert);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    /**
     * 할일 수정 API
     *
     * @param requestUpdate(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PutMapping(value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Object> updateTodo(@PathVariable("categoryId") @NotBlank String categoryId, @PathVariable("todoNo") @NotBlank Long todoNo,
                                             @RequestBody @Validated TodoDto.RequestUpdate requestUpdate) throws Exception {

        if (Objects.equals(categoryId, requestUpdate.getCategoryId())) {
            if (Objects.equals(todoNo, requestUpdate.getTodoNo())) {
                todoService.updateTodo(requestUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 할일 삭제 API
     *
     * @param categoryId, todoNo 삭제할 할일의 카테고리아이디와 할일 고유번호
     * @return ResponseEntity<Object> 201 CREATED : 이동할 페이지 없음
     */
    @DeleteMapping(value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Object> deleteTodo(@PathVariable("categoryId") @NotBlank String categoryId
            , @PathVariable("todoNo") @NotBlank Long todoNo) throws Exception {

        TodoVO todoVO = TodoDto.PathCategoryId.builder().categoryId(categoryId).todoNo(todoNo).build();

        int result = todoService.deleteTodo(todoVO);

        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
