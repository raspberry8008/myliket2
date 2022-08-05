package com.myliket2.myliket.dao;

import com.myliket2.myliket.domain.vo.TodoVO;
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
    public List<TodoVO> allTodoList() throws Exception {
        return sqlSession.selectList(nameSpace + ".allTodoList");
    }

    @Override
    public List<TodoVO> getCategoryTodoList(TodoVO todoVO) throws Exception {
        return sqlSession.selectList(nameSpace + ".getCategoryTodoList", todoVO);
    }

    @Override
    public TodoVO getTodoDetail(TodoVO todoVO) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getTodoDetail", todoVO);
    }

    @Override
    public void insertTodo(TodoVO todoVO) throws Exception {
        sqlSession.insert(nameSpace + ".insertTodo", todoVO);
    }

    @Override
    public void updateTodo(TodoVO todoVO) throws Exception {
        sqlSession.update(nameSpace + ".updateTodo", todoVO);
    }

    @Override
    public int deleteTodo(TodoVO todoVO) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteTodo", todoVO);
    }
}
