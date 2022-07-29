package com.myliket2.myliket.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

/*
    TodoVO : 할일 상세정보
 */

@Getter
@ToString
public class TodoVO {

    private Long todoNo; // 할일 고유번호
    private String categoryId; // 카테고리 아이디
    private String todoTitle; // 할일 제목
    private String todoContent; // 할일 내용
    private LocalDate todoDay; // 할일 일정일자
    private LocalTime todoTime; // 할일 일정시간
    private String todoState; // 할일 일정상태
    private String todoEndDate;// 할일 완료일
    private String todoCreatedAt; // 할일 최초 등록일시
    private String todoUpdatedAt; // 할일 마지막 수정일

    @Builder
    public TodoVO(Long todoNo, String categoryId, String todoTitle, String todoContent,
                  LocalDate todoDay, LocalTime todoTime, String todoState, String todoEndDate,
                  String todoCreatedAt, String todoUpdatedAt) {
        this.todoNo = todoNo;
        this.categoryId = categoryId;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDay = todoDay;
        this.todoTime = todoTime;
        this.todoState = todoState;
        this.todoEndDate = todoEndDate;
        this.todoCreatedAt = todoCreatedAt;
        this.todoUpdatedAt = todoUpdatedAt;
    }
}
