package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryDAO;
import com.myliket2.myliket.dto.CategoryDTO;
import com.myliket2.myliket.vo.CategoryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<CategoryVO> getCategoryList() throws Exception {
        List<CategoryVO> resultList = categoryDAO.getCategoryList();

//        if (ObjectUtils.isEmpty(resultList)) {
//            resultList.isEmpty();
//
//            return resultList;
//        }
        return resultList;
    }

    @Override
    public CategoryVO getCategoryDetail(String CategoryId) throws Exception {
        CategoryVO resultVO = categoryDAO.getCategoryDetail(CategoryId);

        return resultVO;
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
