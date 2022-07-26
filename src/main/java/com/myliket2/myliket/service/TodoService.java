package com.myliket2.myliket.service;

import com.myliket2.myliket.vo.TodoVO;

import java.util.List;

public interface TodoService {

    /**
     * 할일 전체 목록 조회
     * methodName : getTodoList
     * @return List<TodoVO> 할일 목록
     * */
    List<TodoVO> getTodoList () throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoNo 요청한 할일의 고유번호
     * @return todoVO(Object) 할일 상세정보
     */
    TodoVO getTodoDetail (int todoNo) throws Exception;

    /**
     * 할일 등록
     * methodName : insertTodo
     *
     * @param todoVO(Object) 등록할 할일정보
     * @return int 할일 추가 처리 수
     */
    int insertTodo (TodoVO todoVO) throws Exception;

    /**
     * 할일 수정
     * methodName : updateTodo
     * @param todoVO(Object) 수정할 할일정보
     * @return int 할일 수정 처리 수
     * */
    int updateTodo(TodoVO todoVO) throws Exception;

    /**
     * 할일 삭제
     * methodName : deleteTodo
     * @param todoNo 삭제요청한 할일의 고유번호
     * @return int 할일 삭제 데이터 처리 수
     * */
    int deleteTodo (int todoNo) throws Exception;
}
