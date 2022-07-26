package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
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
    public List<TodoVO> getTodoList() throws Exception {
        return todoDAO.getTodoList();
    }

    @Override
    public TodoVO getTodoDetail(int todoNo) throws Exception {
        return todoDAO.getTodoDetail(todoNo);
    }

    @Transactional
    @Override
    public int insertTodo(TodoVO todoVO) throws Exception {
        return todoDAO.insertTodo(todoVO);
    }

    @Transactional
    @Override
    public int updateTodo(TodoVO todoVO) throws Exception {
        return todoDAO.updateTodo(todoVO);
    }

    @Transactional
    @Override
    public int deleteTodo(int todoNo) throws Exception {
        return todoDAO.deleteTodo(todoNo);
    }

}
