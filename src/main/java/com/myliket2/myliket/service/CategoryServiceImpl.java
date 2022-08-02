package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryDAO;
import com.myliket2.myliket.dto.Category;
import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.vo.CategoryVO;
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
        List<CategoryVO> resultList = categoryDAO.allCategoryList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryDetail(CategoryVO categoryVO) throws Exception {
        CategoryVO resultVO = categoryDAO.getCategoryDetail(categoryVO);

        if (ObjectUtils.isEmpty(resultVO) || !(categoryVO.getCategoryId().equals(resultVO.getCategoryId()))) {
            return Response.builder().data("").build();
        }
        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public int insertCategory(CategoryVO categoryVO) throws Exception {
        return categoryDAO.insertCategory(categoryVO);
    }

    @Transactional
    @Override
    public int updateCategory(CategoryVO categoryVO) throws Exception {
        return categoryDAO.updateCategory(categoryVO);
    }

    @Transactional
    @Override
    public int deleteCategory(CategoryVO categoryVO) throws Exception {
        return categoryDAO.deleteCategory(categoryVO);
    }
}
