package com.myliket2.myliket.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/*
 *  TodoVO : 조회 요청한 할일 상세 정보
 *
 *  String categoryName : 카테고리 이름 (필수값 :TRUE)
 *  Long todoNo : 할일 고유번호 (필수값 :TRUE)
 *  String todoTitle : 할일 제목 (필수값 :TRUE)
 *  String todoContent : 할일 내용 (필수값 :TRUE)
 *  LocalDate todoDay : 할일 일정일자 (필수값 :TRUE)
 *  LocalTime todoTime : 할일 일정시간 (필수값 : FALSE)
 *  String stateKor : 할일 상태코드 한글명 (필수값 :TRUE)
 */

@Getter
@ToString
public class TodoVO {

    private String categoryName; // 카테고리 이름
    private Long todoNo; // 할일 고유번호

    private String todoTitle; // 할일 제목
    private String todoContent; // 할일 내용

    @JsonFormat( pattern = "yyyy-MM-dd")
    private LocalDate todoDay; // 할일 일정일자
    @JsonFormat(pattern = "HH:mm:ss")
    private String todoTime; // 할일 일정시간

    private String stateKor; // 할일 상태 코드 한글명
//    private String todoCreatedAt; // 할일 최초 등록일시
//    private String todoUpdatedAt; // 할일 마지막 수정일

    @Builder
    public TodoVO(String categoryName, Long todoNo, String todoTitle, String todoContent, LocalDate todoDay, String todoTime, String stateKor) {
        this.categoryName = categoryName;
        this.todoNo = todoNo;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDay = todoDay;
        this.todoTime = "";
        this.stateKor = stateKor;
    }
}
