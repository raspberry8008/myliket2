package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryDAO;
import com.myliket2.myliket.domain.dto.Response;
import com.myliket2.myliket.domain.vo.CategoryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {

        this.categoryDAO = categoryDAO;

    }



    @Override
    public Response allCategoryList() throws Exception {
        return Response.builder().resultList(categoryDAO.allCategoryList()).build();
    }

    @Override
    public Response getCategoryDetail(CategoryVO categoryVO) throws Exception {

        CategoryVO resultVO=  categoryDAO.getCategoryDetail(categoryVO);

        if (ObjectUtils.isEmpty(resultVO) || ObjectUtils.nullSafeEquals(null, resultVO)) {
            return Response.builder().data("").build();
        } else {
            return Response.builder().data(resultVO).build();
        }

    }

    @Transactional
    @Override
    public void insertCategory(CategoryVO categoryVO) throws Exception {
        categoryDAO.insertCategory(categoryVO);
    }

    @Transactional
    @Override
    public void updateCategory(CategoryVO categoryVO) throws Exception {
        categoryDAO.updateCategory(categoryVO);
    }

    @Transactional
    @Override
    public int deleteCategory(CategoryVO categoryVO) throws Exception {
        return categoryDAO.deleteCategory(categoryVO);
    }
}
