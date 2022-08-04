package com.myliket2.myliket.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;


/*
 *  TodoResponseVO : 조회된 할일 상세 정보
 *
 *  String categoryId : 카테고리 이름
 *  String categoryName : 카테고리 이름
 *  Long todoNo : 할일 고유번호
 *  String todoTitle : 할일 제목
 *  String todoContent : 할일 내용
 *  LocalDate todoDay : 할일 일정일자
 *  LocalTime todoTime : 할일 일정시간
 *  String stateKor : 할일 상태코드 한글명
 */


@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoResponseVO {

    private String categoryId; // 카테고리 아이디

    private Long todoNo; // 할일 고유번호

    private String categoryName; // 카테고리 이름

    private String todoTitle; // 할일 제목

    private String todoContent; // 할일 내용

    private LocalDate todoDay; // 할일 일정일자

    private String todoTime ; // 할일 일정시간

    {
        todoTime ="";
    }

    private String todoState; // 할일 상태 코드

    private String stateKor; // 할일 상태코드 한글명

}
