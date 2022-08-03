package com.myliket2.myliket.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;



/*
 *  TodoVO : 할일 상세 정보
 *
 *  Long todoNo : 할일 고유번호
 *  String categoryId : 카테고리 이름
 *  String categoryName : 카테고리 이름
 *  Long todoNo : 할일 고유번호
 *  String todoTitle : 할일 제목
 *  String todoContent : 할일 내용
 *  LocalDate todoDay : 할일 일정일자
 *  LocalTime todoTime : 할일 일정시간
 *  LocalDateTime todoDayTime : 할일 일정일자 및 시간
 *  String stateKor : 할일 상태코드 한글명
 */

@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoRequestVO {

    private Long todoNo; // 할일 고유번호

    private String categoryId; // 카테고리 아이디

    private String categoryName; // 카테고리 이름

    private String todoTitle; // 할일 제목

    private String todoContent; // 할일 내용

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate todoDay; // 할일 일정일자

    private LocalTime todoTime; // 할일 일정시간

    private String todoState; // 할일 상태 코드

    private String stateKor; // 할일 상태코드 한글명
//    @JsonIgnoreProperties
    private LocalDateTime todoDateTime;


    @Builder
    public TodoRequestVO(Long todoNo, String categoryId, String categoryName, String todoTitle, String todoContent, LocalDate todoDay,
                         LocalTime todoTime, String todoState, String stateKor, LocalDateTime todoDateTime) {
        this.todoNo = todoNo;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDay = todoDay;
        this.todoTime = todoTime;
        this.todoState = todoState;
        this.stateKor = stateKor;
        this.todoDateTime = todoDateTime;
    }



}
