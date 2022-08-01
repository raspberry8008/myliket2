package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryDAO;
import com.myliket2.myliket.dto.CategoryDTO;
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
    public Response getCategoryList() throws Exception {
        List<CategoryVO> resultList = categoryDAO.getCategoryList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryDetail(String CategoryId) throws Exception {
        CategoryVO resultVO = categoryDAO.getCategoryDetail(CategoryId);

        if (ObjectUtils.isEmpty(resultVO)) {
            return Response.builder().data("").build();
        }
        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public int insertCategory(CategoryDTO categoryDTO) throws Exception {

        // uuid 생성
        String isCategoryId = UUID.randomUUID().toString().replace("-","");
        categoryDTO.setCategoryId(isCategoryId);

        return categoryDAO.insertCategory(categoryDTO);
    }

    @Transactional
    @Override
    public int updateCategory(CategoryDTO categoryDTO) throws Exception {
        return categoryDAO.updateCategory(categoryDTO);
    }

    @Transactional
    @Override
    public int deleteCategory(String CategoryId) throws Exception {
        return categoryDAO.deleteCategory(CategoryId);
    }
}
