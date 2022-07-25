package com.myliket2.myliket.comtroller;

import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.util.Message;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoRestController {

    private TodoService todoService;
    private Message message;

    public TodoRestController(TodoService todoService, Message message) {
        this.todoService = todoService;
        this.message = message;
    }

    /**
     * 할일 전체 목록 조회 API
     * @return ResponseEntity<List<TodoVO>> 200 OK, 할일 정보 목록
     * */
    @GetMapping("")
    public ResponseEntity<Message> getTodoList () throws Exception {
        List<Object> resultList = todoService.getTodoList();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

//        message.setStatus(Message.StatusEnum.OK);
//        message.setMessage("200");
        message.setResultList(resultList);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    /**
     * 할일 상세조회 API
     * @param todoNo 상세조회 할 할일의 고유번호
     * @return ResponseEntity<TodoVO> 200 OK, 할일 상세정보
     * */
    @GetMapping(value ="/{todoNo}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message>  getTodoDetail (@PathVariable("todoNo") int todoNo) throws Exception {
        TodoVO resultVO = todoService.getTodoDetail(todoNo);
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setData(resultVO);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param todoVO(Object) 등록할 할일정보
     * @return ResponseEntity<TodoVO> 201 Created
     */
    @PostMapping(value = "",  produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertTodo (@RequestBody TodoVO todoVO) throws Exception {
        todoService.insertTodo(todoVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * 할일 수정 API
     * @param todoVO(Object) 수정할 할일 정보
     * @return ResponseEntity<Object> 201 Created
     * */
    @PutMapping(value = "/{todoNo}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateTodo(@PathVariable("todoNo") int todoNo, @RequestBody TodoVO todoVO) throws Exception {
        todoService.updateTodo(todoVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /**
     * 할일 삭제 API
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 204 No Content
     * */
    @DeleteMapping(value = "/{todoNo}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteTodo (@PathVariable("todoNo") int todoNo) throws Exception {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
