package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
import com.myliket2.myliket.dto.TodoDTO;
import com.myliket2.myliket.vo.TodoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoDAO todoDAO;

    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public List<TodoVO> allTodoList() throws Exception {
        List<TodoVO> resultList = todoDAO.allTodoList();

        return resultList;
    }

    @Override
    public List<TodoVO> getCategoryTodoList (String categoryId) throws Exception {
        List<TodoVO> resultList = todoDAO.getCategoryTodoList(categoryId);
        return resultList;
    }

    @Override
    public TodoVO getTodoDetail(Long todoNo) throws Exception {
        TodoVO resultVO = todoDAO.getTodoDetail(todoNo);
        return resultVO;
    }

    @Transactional
    @Override
    public int insertTodo(TodoDTO todoDTO) throws Exception {

        return todoDAO.insertTodo(todoDTO);
    }

    @Transactional
    @Override
    public int updateTodo(TodoDTO todoDTO) throws Exception {
        return todoDAO.updateTodo(todoDTO);
    }

    @Transactional
    @Override
    public int deleteTodo(Long todoNo) throws Exception {
        return todoDAO.deleteTodo(todoNo);
    }

}
