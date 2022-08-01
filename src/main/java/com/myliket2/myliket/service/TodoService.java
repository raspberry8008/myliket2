package com.myliket2.myliket.service;

import com.myliket2.myliket.dto.TodoDTO;
import com.myliket2.myliket.vo.TodoVO;

import java.util.List;

public interface TodoService {

    /**
     * 전체 카테고리의 할일을 조회 한다.
     * methodName : allCategoryTodoList
     * @return List<TodoVO> 할일 목록
     * */
    List<TodoVO> allTodoList () throws Exception;

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일을 조회
     * methodName : getCategoryTodoList
     * @return List<TodoVO> 할일 목록
     * */
    List<TodoVO> getCategoryTodoList (String categoryId) throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoNo 요청한 할일의 고유번호
     * @return todoVO(Object) 할일 상세정보
     */
    TodoVO getTodoDetail (Long todoNo) throws Exception;

    /**
     * 할일 등록
     * methodName : insertTodo
     *
     * @param todoDTO(Object) 등록할 할일정보
     * @return int 할일 추가 처리 수
     */
    int insertTodo (TodoDTO todoDTO) throws Exception;

    /**
     * 할일 수정
     * methodName : updateTodo
     * @param todoDTO(Object) 수정할 할일정보
     * @return int 할일 수정 처리 수
     * */
    int updateTodo(TodoDTO todoDTO) throws Exception;

    /**
     * 할일 삭제
     * methodName : deleteTodo
     * @param todoNo 삭제요청한 할일의 고유번호
     * @return int 할일 삭제 데이터 처리 수
     * */
    int deleteTodo (Long todoNo) throws Exception;
}
