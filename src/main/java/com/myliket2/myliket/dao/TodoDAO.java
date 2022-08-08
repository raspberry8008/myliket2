package com.myliket2.myliket.dao;

import com.myliket2.myliket.domain.vo.TodoVO;

import java.util.List;


public interface TodoDAO {

    /**
     * 전체 카테고리의 할일을 조회 한다.
     * methodName : allTodoList
     *
     * @return List<?> 할일 목록
     */
    List<TodoVO> allTodoList () throws Exception;

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일을 조회
     * methodName : getCategoryTodoList
     *
     * @return List<?> 할일 목록
     */
    List<TodoVO> getCategoryTodoList (TodoVO todoVO) throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoVO 요청한 할일의 고유번호
     * @return TodoVO(Object) 할일 상세정보
     */
    TodoVO getTodoDetail (TodoVO todoVO) throws Exception;

    /**
     * 할일 등록
     * methodName : insertTodo
     *
     * @param todoVO(Object) 등록할 할일정보
     */
    void insertTodo (TodoVO todoVO) throws Exception;

    /**
     * 할일 수정
     * methodName : updateTodo
     * @param todoVO(Object) 수정할 할일정보
     * */
    void updateTodo(TodoVO todoVO) throws Exception;

    /**
     * 할일 삭제
     * methodName : deleteTodo
     * @param todoVO 삭제요청한 할일의 고유번호
     * @return int 할일 삭제 데이터 처리 수
     * */
    int deleteTodo (TodoVO todoVO) throws Exception;
}
