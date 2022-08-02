package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.dto.Todo;
import com.myliket2.myliket.vo.TodoVO;
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
        List<Todo.ResponseInfo> resultList = todoDAO.allTodoList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryTodoList (String categoryId) throws Exception {
        List<Todo.ResponseInfo> resultList = todoDAO.getCategoryTodoList(categoryId);
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getTodoDetail(Long todoNo) throws Exception {
        TodoVO resultVO = todoDAO.getTodoDetail(todoNo);

        if (ObjectUtils.isEmpty(resultVO)) {
            return Response.builder().data("").build();
        }

        return Response.builder().data(resultVO).build();
    }

    @Transactional
    @Override
    public int insertTodo(Todo.RequestInsert requestInsert) throws Exception {
        return todoDAO.insertTodo(requestInsert);
    }

    @Transactional
    @Override
    public int updateTodo(Todo.RequestUpdate requestUpdate) throws Exception {
        return todoDAO.updateTodo(requestUpdate);
    }

    @Transactional
    @Override
    public int deleteTodo(Long todoNo) throws Exception {
        return todoDAO.deleteTodo(todoNo);
    }

}
