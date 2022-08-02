package com.myliket2.myliket.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Setter
@ToString
public class TodoVO {

    private String categoryId; // 카테고리 아이디
    private Long todoNo; // 할일 고유번호

    @Builder
    public TodoVO(String categoryId, Long todoNo) {
        this.categoryId = categoryId;
        this.todoNo = todoNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoVO todoVO = (TodoVO) o;
        return categoryId.equals(todoVO.categoryId) && todoNo.equals(todoVO.todoNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, todoNo);
    }
}
