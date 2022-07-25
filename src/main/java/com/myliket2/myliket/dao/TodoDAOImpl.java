package com.myliket2.myliket.dao;

import com.myliket2.myliket.vo.TodoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDAOImpl implements TodoDAO{

    private SqlSession sqlSession;

    private static final String nameSpace = "com.myliket2.myliket.TodoMapper";

    public TodoDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Object> getTodoList() throws Exception {
        return sqlSession.selectList(nameSpace + ".getTodoList");
    }

    @Override
    public TodoVO getTodoDetail(int todoNo) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getTodoDetail", todoNo);
    }

    @Override
    public int insertTodo(TodoVO todoVO) throws Exception {
        return sqlSession.insert(nameSpace + ".insertTodo", todoVO);
    }

    @Override
    public int updateTodo(TodoVO todoVO) throws Exception {
        return sqlSession.update(nameSpace + ".updateTodo", todoVO);
    }

    @Override
    public int deleteTodo(int todoNo) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteTodo", todoNo);
    }
}
