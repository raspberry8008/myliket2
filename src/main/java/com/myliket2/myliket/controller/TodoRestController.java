package com.myliket2.myliket.controller;

import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/todos")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 할일 전체 목록 조회 API
     * @return ResponseEntity<Response> 200 OK, 할일 정보 목록
     * */
//    @GetMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" )
//    @GetMapping(value="",  produces=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8" )
    @GetMapping(value="")
    public ResponseEntity<Response> getTodoList () throws Exception {

        List<TodoVO> resultList = todoService.getTodoList();

        if (ObjectUtils.isEmpty(resultList)) {
            return ResponseEntity.noContent().build();
        }

        Response response = Response.builder()
                            .resultList(resultList)
                            .build();

//        return new ResponseEntity<>(response, HttpStatus.OK);
        return  ResponseEntity.ok().body(response);

    }

    /**
     * 할일 상세조회 API
     * @param todoNo 상세조회 할 할일의 고유번호
     * @return ResponseEntity<Response> 200 OK, 할일 상세정보
     * */

    @GetMapping(value ="/{todoNo}")
//    @GetMapping(value ="/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
    public ResponseEntity<Response> getTodoDetail (@PathVariable("todoNo") int todoNo) throws Exception {

        TodoVO resultVO = todoService.getTodoDetail(todoNo);

        if (ObjectUtils.isEmpty(resultVO)) {
//            throw new RuntimeException();
            return ResponseEntity.noContent().build();
        }

        Response response = Response.builder()
                            .data(resultVO)
                            .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param todoVO(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "")
//    @PostMapping(value = "", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public ResponseEntity<Object> insertTodo (@RequestBody TodoVO todoVO) throws Exception {
        int result = todoService.insertTodo(todoVO);

        if (result==0) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).build();
    }

    /**
     * 할일 수정 API
     * @param todoVO(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     * */
//    @PutMapping( value = "/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8", produces=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
    @PutMapping( value = "/{todoNo}")
    public ResponseEntity<Object> updateTodo(@PathVariable("todoNo") int todoNo, @RequestBody TodoVO todoVO) throws Exception {
        int result =todoService.updateTodo(todoVO);

        if (result==0) {
//            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.status(201).build();
    }

    /**
     * 할일 삭제 API
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 204 No Content
     * */
//    @DeleteMapping(value = "/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8" )
    @DeleteMapping(value = "/{todoNo}" )
    public ResponseEntity<Object> deleteTodo (@PathVariable("todoNo") int todoNo) throws Exception {
        int result =todoService.deleteTodo(todoNo);

        if (result==0) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.noContent().build();
    }
}
