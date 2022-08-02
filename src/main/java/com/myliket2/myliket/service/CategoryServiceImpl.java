package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryDAO;
import com.myliket2.myliket.dto.Category;
import com.myliket2.myliket.dto.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Response allCategoryList() throws Exception {
        List<Category.ResponseInfo> resultList = categoryDAO.allCategoryList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryDetail(String CategoryId) throws Exception {
        Category.ResponseInfo resultVO = categoryDAO.getCategoryDetail(CategoryId);

        if (ObjectUtils.isEmpty(resultVO)) {
            return Response.builder().data("").build();
        }
        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public int insertCategory(Category.RequestInsert requestInsert) throws Exception {

        // uuid 생성
        String isCategoryId = UUID.randomUUID().toString().replace("-","");
        requestInsert.setCategoryId(isCategoryId);

        return categoryDAO.insertCategory(requestInsert);
    }

    @Transactional
    @Override
    public int updateCategory(Category.RequestUpdate requestUpdate ) throws Exception {
        return categoryDAO.updateCategory(requestUpdate);
    }

    @Transactional
    @Override
    public int deleteCategory(String CategoryId) throws Exception {
        return categoryDAO.deleteCategory(CategoryId);
    }
}
