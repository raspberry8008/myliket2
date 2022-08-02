package com.myliket2.myliket.dao;

import com.myliket2.myliket.dto.Todo;

import java.util.List;

//@Mapper
//@Repository
public interface TodoDAO {

    /**
     * 전체 카테고리의 할일을 조회 한다.
     * methodName : allTodoList
     *
     * @return List<ResponseInfo> 할일 목록
     */
    List<Todo.ResponseInfo> allTodoList () throws Exception;

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일을 조회
     * methodName : getCategoryTodoList
     *
     * @return List<ResponseInfo> 할일 목록
     */
    List<Todo.ResponseInfo> getCategoryTodoList (String categoryId) throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoNo 요청한 할일의 고유번호
     * @return ResponseInfo(Object) 할일 상세정보
     */
    Todo.ResponseInfo getTodoDetail (Long todoNo) throws Exception;

    /**
     * 할일 등록
     * methodName : insertTodo
     *
     * @param requestInsert(Object) 등록할 할일정보
     * @return int 할일 추가 처리 수
     */
    int insertTodo (Todo.RequestInsert requestInsert) throws Exception;

    /**
     * 할일 수정
     * methodName : updateTodo
     * @param requestUpdate(Object) 수정할 할일정보
     * @return int 할일 수정 처리 수
     * */
    int updateTodo(Todo.RequestUpdate requestUpdate) throws Exception;

    /**
     * 할일 삭제
     * methodName : deleteTodo
     * @param todoNo 삭제요청한 할일의 고유번호
     * @return int 할일 삭제 데이터 처리 수
     * */
    int deleteTodo (Long todoNo) throws Exception;
}
