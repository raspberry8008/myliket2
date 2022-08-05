package com.myliket2.myliket.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


/*
 *  TodoVO : 할일 상세 정보
 *
 *  String categoryId : 카테고리 아이디
 *  String categoryName : 카테고리 이름
 *  Long todoNo : 할일 고유번호
 *  String todoTitle : 할일 제목
 *  String todoContent : 할일 내용
 *  LocalDate todoDay : 할일 일정일자
 *  LocalDateTime todoTime : 할일 일정시간
 *  String todoState; // 할일 상태 코드
 *  String stateKor : 할일 상태코드 한글명
 */


@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoVO {

    private Long todoNo; // 할일 고유번호

    private String categoryId; // 카테고리 아이디

    private String categoryName; // 카테고리 이름

    private String todoTitle; // 할일 제목

    private String todoContent; // 할일 내용

    private LocalDate todoDay; // 할일 일정일자

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime todoTime ; // 할일 일정시간

    private String todoState; // 할일 상태 코드

    private String stateKor; // 할일 상태코드 한글명

    @Builder
    public TodoVO(Long todoNo, String categoryId, String categoryName, String todoTitle, String todoContent, LocalDate todoDay, LocalDateTime todoTime, String todoState, String stateKor) {
        this.todoNo = todoNo;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDay = todoDay;
        this.todoTime = todoTime;
        this.todoState = todoState;
        this.stateKor = stateKor;
    }
}
