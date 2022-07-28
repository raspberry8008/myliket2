package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.CategoryTodoDAO;
import com.myliket2.myliket.vo.CategoryTodoVO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryTodoServiceImpl implements CategoryTodoService {

    private CategoryTodoDAO categoryTodoDAO;

    public CategoryTodoServiceImpl(CategoryTodoDAO categoryTodoDAO) {
        this.categoryTodoDAO = categoryTodoDAO;
    }


    @Override
    public List<CategoryTodoVO> getCategoryTodoList(String categoryId) throws Exception {
        List<CategoryTodoVO> resultList = categoryTodoDAO.getCategoryTodoList(categoryId);

        if (resultList.isEmpty()) {
            resultList.add(CategoryTodoVO.builder().build());
            return resultList;
        }

        return resultList;
    }

    @Override
    public CategoryTodoVO getTodoDetail(int todoNo) throws Exception {
        CategoryTodoVO resultVO = categoryTodoDAO.getTodoDetail(todoNo);

        if (ObjectUtils.isEmpty(resultVO)) {
            return CategoryTodoVO.builder().build();
        }
        return resultVO;
    }
}
