package com.myliket2.myliket.controller;

import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 할일 전체 목록 조회 API
     * @return ResponseEntity<Map<String, List<TodoVO>>> 200 OK, 할일 정보 목록
     * */
    @GetMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Map<String, List<TodoVO>>> getTodoList () throws Exception {
        List<TodoVO> resultList = todoService.getTodoList();

        Map<String, List<TodoVO>> outMap = new HashMap<>();
        outMap.put("resultList", resultList );

        return ResponseEntity.status(HttpStatus.OK).body(outMap);
    }

    /**
     * 할일 상세조회 API
     * @param todoNo 상세조회 할 할일의 고유번호
     * @return ResponseEntity<Map<String, TodoVO>> 200 OK, 할일 상세정보
     * */

    @GetMapping(value ="/{todoNo}",consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8" )
    public ResponseEntity<Map<String, TodoVO>> getTodoDetail (@PathVariable("todoNo") int todoNo) throws Exception {

        TodoVO resultVO = todoService.getTodoDetail(todoNo);

        Map<String, TodoVO> outMap = new HashMap<>();
        outMap.put("data", resultVO );

        return ResponseEntity.status(HttpStatus.OK).body(outMap);
    }

    /**
     * 할일 등록 API
     *
     * @param todoVO(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "",  consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Object> insertTodo (@RequestBody TodoVO todoVO) throws Exception {
        todoService.insertTodo(todoVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * 할일 수정 API
     * @param todoVO(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     * */
    @PutMapping(value = "/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Object> updateTodo(@PathVariable("todoNo") int todoNo, @RequestBody TodoVO todoVO) throws Exception {
        todoService.updateTodo(todoVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * 할일 삭제 API
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 204 No Content
     * */
    @DeleteMapping(value = "/{todoNo}", consumes=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public ResponseEntity<Object> deleteTodo (@PathVariable("todoNo") int todoNo) throws Exception {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
