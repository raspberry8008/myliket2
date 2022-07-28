package com.myliket2.myliket.dao;

import com.myliket2.myliket.vo.CategoryTodoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryTodoDAOImpl implements CategoryTodoDAO {

    private final SqlSession sqlSession;

    private static final String nameSpace = "com.myliket2.myliket.CategotyTodoMapper";

    public CategoryTodoDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<CategoryTodoVO> getCategoryTodoList(String categoryId) throws Exception {
        return sqlSession.selectList(nameSpace +".getCategoryTodoList", categoryId);
    }

    @Override
    public CategoryTodoVO getTodoDetail(int todoNo) throws Exception {
        return sqlSession.selectOne(nameSpace+".getTodoDetail", todoNo);
    }
}
