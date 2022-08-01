package com.myliket2.myliket.service;

import com.myliket2.myliket.dto.CategoryDTO;
import com.myliket2.myliket.dto.Response;


public interface CategoryService {

    /**
     * 카테고리 전체 목록 조회
     * methodName : getCategoryList
     * @return List<CategoryVO> 카테고리 목록
     * */
    Response getCategoryList () throws Exception;

    /**
     * 카테고리 상세조회
     * methodName : getCategoryDetail
     *
     * @param CategoryId 요청한 카테고리 아이디
     * @return todoVO(Object) 카테고리 상세정보
     */
    Response getCategoryDetail (String CategoryId) throws Exception;

    /**
     * 카테고리 등록
     * methodName : insertCategory
     *
     * @param categoryDTO(Object) 등록할 카테고리 정보
     * @return int 카테고리 등록 처리 수
     */
    int insertCategory (CategoryDTO categoryDTO) throws Exception;

    /**
     * 카테고리 수정
     * methodName : updateCategory
     * @param categoryDTO(Object) 수정할 카테고리 정보
     * @return int 카테고리 수정 처리 수
     * */
    int updateCategory(CategoryDTO categoryDTO) throws Exception;

    /**
     * 카테고리 삭제
     * methodName : deleteCategory
     * @param CategoryId 삭제요청한 카테고리 아이디
     * @return int 카테고리 삭제 데이터 처리 수
     * */
    int deleteCategory (String CategoryId) throws Exception;
}
