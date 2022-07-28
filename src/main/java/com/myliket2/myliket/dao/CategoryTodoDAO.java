package com.myliket2.myliket.dao;

import com.myliket2.myliket.vo.CategoryTodoVO;

import java.util.List;


public interface CategoryTodoDAO {

    /**
     * 단일 카테고리의 할일 전체 목록 조회
     * methodName : getCategoryTodoList
     *
     * @param categoryId 카테고리 아이디
     * @return List<TodoVO> 할일 목록
     * */
    List<CategoryTodoVO> getCategoryTodoList (String categoryId) throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoNo 요청한 할일의 고유번호
     * @return todoVO(Object) 할일 상세정보
     */
    CategoryTodoVO getTodoDetail (int todoNo) throws Exception;

}
