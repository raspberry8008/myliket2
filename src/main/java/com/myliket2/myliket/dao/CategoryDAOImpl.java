package com.myliket2.myliket.dao;

import com.myliket2.myliket.vo.CategoryVO;
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
    public List<CategoryVO> getCategoryList() throws Exception {
        return sqlSession.selectList(nameSpace + ".getCategoryList");
    }

    @Override
    public CategoryVO getCategoryDetail(String CategoryId) throws Exception {
        return sqlSession.selectOne(nameSpace + ".getCategoryDetail", CategoryId);
    }

    @Override
    public int insertCategory(CategoryVO categoryVO) throws Exception {
        return sqlSession.insert(nameSpace + ".insertCategory", categoryVO);
    }

    @Override
    public int updateCategory(CategoryVO categoryVO) throws Exception {
        return sqlSession.update(nameSpace + ".updateCategory", categoryVO);
    }

    @Override
    public int deleteCategory(String CategoryId) throws Exception {
        return sqlSession.delete(nameSpace + ".deleteCategory", CategoryId);
    }
}
