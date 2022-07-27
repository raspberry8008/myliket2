package com.myliket2.myliket.controller;

import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.service.CategoryService;
import com.myliket2.myliket.service.TodoService;
import com.myliket2.myliket.vo.CategoryVO;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/categorys")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 카테고리 전체 목록 조회 API
     * @return ResponseEntity<Response> 200 OK, 카테고리 정보 목록
     * */
    @GetMapping(value="")
    public ResponseEntity<Response> getCategoryList () throws Exception {

        List<CategoryVO> resultList = categoryService.getCategoryList();

        Response response = Response.builder()
                            .resultList(resultList)
                            .build();

        return  ResponseEntity.ok().body(response);

    }

    /**
     * 카테고리 상세조회 API
     * @param categoryId 상세조회 할 카테고리 아이디
     * @return ResponseEntity<Response> 200 OK, 카테고리 상세정보
     * */

    @GetMapping(value ="/{categoryId}")
    public ResponseEntity<Response> getTodoDetail (@PathVariable("categoryId") String categoryId) throws Exception {

        CategoryVO resultVO = categoryService.getCategoryDetail(categoryId);

        Response response = Response.builder()
                            .data(resultVO)
                            .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 카테고리 등록 API
     *
     * @param categoryVO(Object) 등록할 할일정보
     * @return ResponseEntity<Object> 201 Created
     */
    @PostMapping(value = "")
    public ResponseEntity<Void> insertTodo (@RequestBody @Validated CategoryVO categoryVO) throws Exception {

        categoryService.insertCategory(categoryVO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 카테고리 수정 API
     * @param categoryVO(Object) 수정할 카테고리 정보
     * @return ResponseEntity<Object> 201 Created
     * */
    @PutMapping( value = "")
    public ResponseEntity<Object> updateTodo(@RequestBody @Validated CategoryVO categoryVO) throws Exception {
        categoryService.updateCategory(categoryVO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 카테고리 삭제 API
     * @param categoryId 삭제할 카테고리 아이디
     * @return ResponseEntity<Object> 201 CREATED : 이동할 페이지 없음
     * */
    @DeleteMapping(value = "/{categoryId}" )
    public ResponseEntity<Object> deleteTodo (@PathVariable("categoryId") String categoryId) throws Exception {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
