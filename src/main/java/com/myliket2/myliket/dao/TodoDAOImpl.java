package com.myliket2.myliket.dao;

import com.myliket2.myliket.dto.TodoDTO;
import com.myliket2.myliket.vo.TodoVO;
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
    public List<TodoVO> getCategoryTodoList(String categoryId) throws Exception {
        return sqlSession.selectList(nameSpace + ".getCategoryTodoList", categoryId);
    }

    @Override
    public TodoVO getTodoDetail(Long todoNo) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getTodoDetail", todoNo);
    }

    @Override
    public int insertTodo(TodoDTO todoDTO) throws Exception {
        return sqlSession.insert(nameSpace + ".insertTodo", todoDTO);
    }

    @Override
    public int updateTodo(TodoDTO todoDTO) throws Exception {
        return sqlSession.update(nameSpace + ".updateTodo", todoDTO);
    }

    @Override
    public int deleteTodo(Long todoNo) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteTodo", todoNo);
    }
}
