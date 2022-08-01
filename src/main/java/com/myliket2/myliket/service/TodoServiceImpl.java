package com.myliket2.myliket.service;

import com.myliket2.myliket.dao.TodoDAO;
import com.myliket2.myliket.dto.Response;
import com.myliket2.myliket.dto.TodoDTO;
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
        List<TodoVO> resultList = todoDAO.allTodoList();
        return Response.builder().resultList(resultList).build();
    }

    @Override
    public Response getCategoryTodoList (String categoryId) throws Exception {
        List<TodoVO> resultList = todoDAO.getCategoryTodoList(categoryId);
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
