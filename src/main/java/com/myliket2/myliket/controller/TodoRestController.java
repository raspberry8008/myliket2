package com.myliket2.myliket.controller;

import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;
import com.myliket2.myliket.domain.dto.Response;
import com.myliket2.myliket.domain.dto.TodoDto;
import com.myliket2.myliket.domain.vo.TodoRequestVO;
import com.myliket2.myliket.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping(value = "/categorys")
public class TodoRestController {

    private final TodoService todoService;
    private TodoDto todoVO;

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
        TodoRequestVO todoRequestVO = TodoDto.RequestInfo.builder().categoryId(categoryId).build();
        Response response = todoService.getCategoryTodoList(todoRequestVO);
        return ResponseEntity.ok().body(response);

    }

    /**
     * 할일 상세조회 API
     *
     * @param categoryId(카테고리아이디), todoNo(할일 고유번호)
     * @return ResponseEntity<Response> 200 OK, 할일 상세정보
     */

    @GetMapping(value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Response> getTodoDetail(@PathVariable("categoryId") @NotBlank String categoryId, @PathVariable("todoNo") @NotBlank Long todoNo) throws Exception {
        TodoRequestVO todoRequestVO = TodoDto.RequestInfo.builder().categoryId(categoryId).todoNo(todoNo).build();
        Response response = todoService.getTodoDetail(todoRequestVO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 할일 등록 API
     *
     * @param requestInsert(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "/{categoryId}/todos")
    public ResponseEntity<Void> insertTodo(@PathVariable("categoryId") @NotBlank String categoryId, @RequestBody @Validated TodoDto.RequestInsert requestInsert) throws Exception {

        LocalDateTime nowTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        if (requestInsert.getTodoTime() != null) {

            requestInsert.setTodoDateTime(LocalDateTime.parse(LocalDateTime.of(requestInsert.getTodoDay(), requestInsert.getTodoTime())
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))));

            if (nowTime.isBefore(requestInsert.getTodoDateTime())){
                todoService.insertTodo(requestInsert);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            System.out.println("과거시간");
        }

        if (requestInsert.getTodoTime() == null) {
            requestInsert.setTodoDateTime(LocalDateTime.parse(LocalDateTime.of(requestInsert.getTodoDay(), LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))));
            if (nowTime.isBefore(requestInsert.getTodoDateTime())){
                todoService.insertTodo(requestInsert);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            System.out.println("과거시간");
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

        LocalDateTime nowTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        if (requestUpdate.getTodoTime() != null) {

            requestUpdate.setTodoDateTime(LocalDateTime.parse(LocalDateTime.of(requestUpdate.getTodoDay(), requestUpdate.getTodoTime())
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))));

            if (nowTime.isBefore(requestUpdate.getTodoDateTime())){
                todoService.updateTodo(requestUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            System.out.println("과거시간 입니다.");
        }

        if (requestUpdate.getTodoTime() == null) {
            requestUpdate.setTodoDateTime(LocalDateTime.parse(LocalDateTime.of(requestUpdate.getTodoDay(), LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))));
            if (nowTime.isBefore(requestUpdate.getTodoDateTime())){
                todoService.updateTodo(requestUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            System.out.println("과거시간");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 할일 삭제 API
     *
     * @param todoNo 삭제할 할일 객체의 고유번호
     * @return ResponseEntity<Object> 201 CREATED : 이동할 페이지 없음
     */
    @DeleteMapping(value = "/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Object> deleteTodo(@PathVariable("categoryId") @NotBlank String categoryId, @PathVariable("todoNo") @NotBlank Long todoNo) throws Exception {
        TodoRequestVO todoRequestVO = TodoDto.RequestInfo.builder().categoryId(categoryId).todoNo(todoNo).build();
        int result = todoService.deleteTodo(todoRequestVO);

        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
