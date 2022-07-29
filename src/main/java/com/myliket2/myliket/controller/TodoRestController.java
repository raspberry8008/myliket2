package com.myliket2.myliket.controller;

import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.dto.TodoDTO;
import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/todos")
public class TodoRestController {

    private final TodoService todoService;
    private TodoVO todoVO;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 전체 카테고리의 할일을 조회 API
     * @return ResponseEntity<Response> 200 OK, 할일 정보 목록
     * */
    @GetMapping(value="")
    public ResponseEntity<Response> allCategoryTodoList () throws Exception {

        List<TodoVO> resultList = todoService.allCategoryTodoList();

        Response response = Response.builder()
                            .resultList(resultList)
                            .build();

        return  ResponseEntity.ok().body(response);

    }

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일 조회 API
     * @return ResponseEntity<Response> 200 OK, 할일 정보 목록
     * */
    @GetMapping(value="?")
    public ResponseEntity<Response> getCategoryTodoList (@RequestParam("categoryId") String categoryId) throws Exception {

        List<TodoVO> resultList = todoService.getCategoryTodoList(categoryId);

        Response response = Response.builder()
                .resultList(resultList)
                .build();

        return  ResponseEntity.ok().body(response);

    }

    /**
     * 할일 상세조회 API
     * @param todoNo 상세조회 할 할일의 고유번호
     * @return ResponseEntity<Response> 200 OK, 할일 상세정보
     * */

    @GetMapping(value ="/{todoNo}")
    public ResponseEntity<Response> getTodoDetail (@PathVariable("todoNo") Long todoNo) throws Exception {

        TodoVO resultVO = todoService.getTodoDetail(todoNo);

        Response response = Response.builder()
                            .data(resultVO)
                            .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param todoDTO(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "")
//    @PostMapping(value = "", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<Void> insertTodo (@RequestBody @Validated TodoDTO todoDTO) throws Exception {

        todoService.insertTodo(todoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 할일 수정 API
     * @param todoDTO(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     * */
//    @PutMapping( value = "/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
    @PutMapping( value = "/todos/{todoNo}")
    public ResponseEntity<Object> updateTodo(@RequestBody @Validated  TodoDTO todoDTO) throws Exception {
        todoService.updateTodo(todoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 할일 삭제 API
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 201 CREATED : 이동할 페이지 없음
     * */
    @DeleteMapping(value = "/{todoNo}" )
    public ResponseEntity<Object> deleteTodo (@PathVariable("todoNo") Long todoNo) throws Exception {
        todoService.deleteTodo(todoNo);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
