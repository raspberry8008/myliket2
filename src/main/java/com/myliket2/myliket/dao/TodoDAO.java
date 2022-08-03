package com.myliket2.myliket.dao;

import com.myliket2.myliket.domain.vo.TodoResponseVO;
import com.myliket2.myliket.domain.vo.TodoRequestVO;

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
    List<TodoResponseVO> allTodoList () throws Exception;

    /**
     * 카테고리 {categoryId} 에 대한 전체 할일을 조회
     * methodName : getCategoryTodoList
     *
     * @return List<ResponseInfo> 할일 목록
     */
    List<TodoResponseVO> getCategoryTodoList (TodoRequestVO todoRequestVO) throws Exception;

    /**
     * 할일 상세조회
     * methodName : getTodoDetail
     *
     * @param todoRequestVO 요청한 할일의 고유번호
     * @return ResponseInfo(Object) 할일 상세정보
     */
    TodoResponseVO getTodoDetail (TodoRequestVO todoRequestVO) throws Exception;

    /**
     * 할일 등록
     * methodName : insertTodo
     *
     * @param todoRequestVO(Object) 등록할 할일정보
     */
    void insertTodo (TodoRequestVO todoRequestVO) throws Exception;

    /**
     * 할일 수정
     * methodName : updateTodo
     * @param todoRequestVO(Object) 수정할 할일정보
     * */
    void updateTodo(TodoRequestVO todoRequestVO) throws Exception;

    /**
     * 할일 삭제
     * methodName : deleteTodo
     * @param todoRequestVO 삭제요청한 할일의 고유번호
     * @return int 할일 삭제 데이터 처리 수
     * */
    int deleteTodo (TodoRequestVO todoRequestVO) throws Exception;
}
