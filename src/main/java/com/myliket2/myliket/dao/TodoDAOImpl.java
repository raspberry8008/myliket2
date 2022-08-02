package com.myliket2.myliket.dao;

import com.myliket2.myliket.dto.Todo;
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
    public List<Todo.ResponseInfo> allTodoList() throws Exception {
        return sqlSession.selectList(nameSpace + ".allTodoList");
    }

    @Override
    public List<Todo.ResponseInfo> getCategoryTodoList(String categoryId) throws Exception {
        return sqlSession.selectList(nameSpace + ".getCategoryTodoList", categoryId);
    }

    @Override
    public Todo.ResponseInfo getTodoDetail(Long todoNo) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getTodoDetail", todoNo);
    }

    @Override
    public int insertTodo(Todo.RequestInsert requestInsert) throws Exception {
        return sqlSession.insert(nameSpace + ".insertTodo", requestInsert);
    }

    @Override
    public int updateTodo(Todo.RequestUpdate requestUpdate) throws Exception {
        return sqlSession.update(nameSpace + ".updateTodo", requestUpdate);
    }

    @Override
    public int deleteTodo(Long todoNo) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteTodo", todoNo);
    }
}
