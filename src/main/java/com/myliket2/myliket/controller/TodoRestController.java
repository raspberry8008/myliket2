package com.myliket2.myliket.controller;

import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.dto.Todo;
import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.CategoryVO;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(value="/categorys")
public class TodoRestController {

    private final TodoService todoService;
    private Todo todoVO;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 전체 카테고리의 할일을 조회 API
     * @return ResponseEntity<Response> 200 OK, 전체 할일목록
     * */
    @GetMapping(value="/todos")
    public ResponseEntity<Response> allTodoList () throws Exception {
        Response response = todoService.allTodoList();
        return  ResponseEntity.ok().body(response);
    }

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일 조회 API
     * @return ResponseEntity<Response> 200 OK, 카테고리 {categoryId} 의 할일목록
     * */
    @GetMapping(value="/{categoryId}/todos")
    public ResponseEntity<Response> getCategoryTodoList (@PathVariable("categoryId") @NotBlank String categoryId) throws Exception {
        Response response = todoService.getCategoryTodoList(categoryId);
        return  ResponseEntity.ok().body(response);

    }

    /**
     * 할일 상세조회 API
     * @param todoNo 상세조회 카테고리아이디, 할일의 고유번호
     * @return ResponseEntity<Response> 200 OK, 할일 상세정보
     * */

    @GetMapping(value ="/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Response> getTodoDetail (@PathVariable ("categoryId") @NotBlank String categoryId, @PathVariable("todoNo") @NotBlank  Long todoNo) throws Exception {
        Response response = todoService.getTodoDetail(todoNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param requestInsert(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "/{categoryId}/todos")
    public ResponseEntity<Void> insertTodo (@PathVariable("categoryId") @NotBlank String categoryId, @RequestBody @Validated Todo.RequestInsert requestInsert) throws Exception {
        CategoryVO categoryPath = CategoryVO.builder().categoryId(categoryId).build();
        CategoryVO categoryInput = CategoryVO.builder().categoryId(requestInsert.getCategoryId()).build();
        if (categoryPath.equals(categoryInput)) {
            todoService.insertTodo(requestInsert);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 할일 수정 API
     * @param requestUpdate(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     * */
    @PutMapping( value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Object> updateTodo(@PathVariable("categoryId") @NotBlank String categoryId , @PathVariable("todoNo") @NotBlank Long todoNo,
                                             @RequestBody @Validated Todo.RequestUpdate requestUpdate) throws Exception {
        TodoVO todoPath = TodoVO.builder().categoryId(categoryId).todoNo(todoNo).build();
        TodoVO todoInput = TodoVO.builder().categoryId(requestUpdate.getCategoryId()).todoNo(requestUpdate.getTodoNo()).build();
        if (todoPath.equals(todoInput)) {
            todoService.updateTodo(requestUpdate);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    /**
     * 할일 삭제 API
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 201 CREATED : 이동할 페이지 없음
     * */
    @DeleteMapping(value = "/{categoryId}/todos/{todoNo}" )
    public ResponseEntity<Object> deleteTodo (@PathVariable("categoryId") @NotBlank String categoryId, @PathVariable("todoNo") @NotBlank Long todoNo) throws Exception {
        int result=todoService.deleteTodo(todoNo);

        if(result==0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
