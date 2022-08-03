package com.myliket2.myliket.dao;

import com.myliket2.myliket.domain.vo.TodoResponseVO;
import com.myliket2.myliket.domain.vo.TodoRequestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoDAOImpl implements TodoDAO {

    private final SqlSession sqlSession;

    private static final String nameSpace = "com.myliket2.myliket.TodoMapper";

    public TodoDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<TodoResponseVO> allTodoList() throws Exception {
        return sqlSession.selectList(nameSpace + ".allTodoList");
    }

    @Override
    public List<TodoResponseVO> getCategoryTodoList(TodoRequestVO todoRequestVO) throws Exception {
        return sqlSession.selectList(nameSpace + ".getCategoryTodoList", todoRequestVO);
    }

    @Override
    public TodoResponseVO getTodoDetail(TodoRequestVO todoRequestVO) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getTodoDetail", todoRequestVO);
    }

    @Override
    public void insertTodo(TodoRequestVO todoRequestVO) throws Exception {
        sqlSession.insert(nameSpace + ".insertTodo", todoRequestVO);
    }

    @Override
    public void updateTodo(TodoRequestVO todoRequestVO) throws Exception {
        sqlSession.update(nameSpace + ".updateTodo", todoRequestVO);
    }

    @Override
    public int deleteTodo(TodoRequestVO todoRequestVO) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteTodo", todoRequestVO);
    }
}
