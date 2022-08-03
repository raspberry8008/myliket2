package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
import com.myliket2.myliket.domain.dto.Response;
import com.myliket2.myliket.domain.vo.TodoResponseVO;
import com.myliket2.myliket.domain.vo.TodoRequestVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoDAO todoDAO;

    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public Response allTodoList() throws Exception {
        List<TodoResponseVO> resultList = todoDAO.allTodoList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryTodoList (TodoRequestVO todoRequestVO) throws Exception {
        List<TodoResponseVO> resultList = todoDAO.getCategoryTodoList(todoRequestVO);
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getTodoDetail(TodoRequestVO todoRequestVO) throws Exception {
        TodoResponseVO resultVO = todoDAO.getTodoDetail(todoRequestVO);

        if (ObjectUtils.isEmpty(resultVO)) {
            return Response.builder().data("").build();
        }

        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public void insertTodo(TodoRequestVO todoRequestVO) throws Exception {
        todoDAO.insertTodo(todoRequestVO);
    }

    @Transactional
    @Override
    public void updateTodo(TodoRequestVO todoRequestVO) throws Exception {
        todoDAO.updateTodo(todoRequestVO);
    }

    @Transactional
    @Override
    public int deleteTodo(TodoRequestVO todoRequestVO) throws Exception {
        return todoDAO.deleteTodo(todoRequestVO);
    }

}
