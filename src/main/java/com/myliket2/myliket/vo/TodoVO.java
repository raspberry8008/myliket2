package com.myliket2.myliket.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
public class TodoVO {

    // 할일 상세정보
    private int todoNo; // 할일 고유번호
//    private String categoryId; // 카테고리 아이디
    private String todoTitle; // 할일 제목
    private String todoContent; // 할일 내용
    private String todoDay; // 할일 일정일자
    private String todoTime; // 할일 일정시간
    private String todoState; // 할일 일정상태
//    private String todoEndDate;// 할일 완료일
//    private String todoCreatedAt; // 할일 최초 등록일시
//    private String todoUpdatedAt; // 할일 마지막 수정일

}
