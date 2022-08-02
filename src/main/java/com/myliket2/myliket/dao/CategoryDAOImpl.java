package com.myliket2.myliket.dao;

import com.myliket2.myliket.dto.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    private final SqlSession sqlSession;

    private static final String nameSpace = "com.myliket2.myliket.CategoryMapper";

    public CategoryDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Category.ResponseInfo> allCategoryList() throws Exception {
        return sqlSession.selectList(nameSpace + ".allCategoryList");
    }

    @Override
    public Category.ResponseInfo getCategoryDetail(String CategoryId) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getCategoryDetail", CategoryId);
    }

    @Override
    public int insertCategory(Category.RequestInsert requestInsert) throws Exception {
        return sqlSession.insert(nameSpace + ".insertCategory", requestInsert);
    }

    @Override
    public int updateCategory(Category.RequestUpdate requestUpdate) throws Exception {
        return sqlSession.update(nameSpace + ".updateCategory", requestUpdate);
    }

    @Override
    public int deleteCategory(String CategoryId) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteCategory", CategoryId);
    }
}
