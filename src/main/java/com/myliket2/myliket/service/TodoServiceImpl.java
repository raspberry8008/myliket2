package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
import com.myliket2.myliket.domain.dto.Response;
import com.myliket2.myliket.domain.vo.TodoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoDAO todoDAO;

    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public Response allTodoList() throws Exception {
        List<TodoVO> resultList = todoDAO.allTodoList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryTodoList(TodoVO todoVO) throws Exception {
        List<TodoVO> resultList = todoDAO.getCategoryTodoList(todoVO);
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getTodoDetail(TodoVO todoVO) throws Exception {
        TodoVO resultVO = todoDAO.getTodoDetail(todoVO);

        if (ObjectUtils.isEmpty(resultVO)) {
            TodoVO resultVO1 = TodoVO.builder().build();
            return Response.builder().data(resultVO1).build();
        }

        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public void insertTodo(TodoVO todoVO) throws Exception {
        todoDAO.insertTodo(todoVO);
    }

    @Transactional
    @Override
    public void updateTodo(TodoVO todoVO) throws Exception {
        todoDAO.updateTodo(todoVO);
    }

    @Transactional
    @Override
    public int deleteTodo(TodoVO todoVO) throws Exception {
        return todoDAO.deleteTodo(todoVO);
    }

}
