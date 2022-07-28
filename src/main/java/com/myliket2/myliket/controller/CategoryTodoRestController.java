package com.myliket2.myliket.controller;

import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.service.CategoryTodoService;
import com.myliket2.myliket.vo.CategoryTodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categorys")
public class CategoryTodoRestController {

    private final CategoryTodoService categoryTodoService;

    public CategoryTodoRestController(CategoryTodoService categoryTodoService) {
        this.categoryTodoService = categoryTodoService;
    }

    /**
     * 단일 카테고리의 할일 전체 목록 조회 API
     * @return ResponseEntity<Response> 200 OK, 할일 정보 목록
     * */
    @GetMapping(value="/{categoryId}/todos")
    public ResponseEntity<Response> getCategoryTodoList (@PathVariable("categoryId") String categoryId) throws Exception {

//        Map<String, CategoryVO> map = new HashMap<>();
//        map.put("categoryId", CategoryVO.builder().categoryId(categoryId).build());
        String categoryId2=categoryId;

        List<CategoryTodoVO> resultList = categoryTodoService.getCategoryTodoList(categoryId2);

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

    @GetMapping(value ="/{categoryId}/todos/{todoNo}")
    public ResponseEntity<Response> getTodoDetail (@PathVariable("todoNo") int todoNo) throws Exception {

        CategoryTodoVO resultVO = categoryTodoService.getTodoDetail(todoNo);

        Response response = Response.builder()
                            .data(resultVO)
                            .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
