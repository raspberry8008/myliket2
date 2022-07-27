package com.myliket2.myliket.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@ToString
@Builder
public class TodoVO {

    // 할일 상세정보

    private int todoNo; // 할일 고유번호
//    private String categoryId; // 카테고리 아이디

    @NotBlank
    @Size(min=1, max=15)
    private String todoTitle; // 할일 제목

    @NotBlank
    @Size(min=1, max=100)
    private String todoContent; // 할일 내용

    @NotNull
    @FutureOrPresent
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate todoDay; // 할일 일정일자

//    @FutureOrPresent
    @DateTimeFormat(pattern = "HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "Asia/Seoul")
    private LocalTime todoTime; // 할일 일정시간

    @DateTimeFormat(pattern = "^[A-Z]+$")
    private String todoState; // 할일 일정상태
//    private String todoEndDate;// 할일 완료일
//    private String todoCreatedAt; // 할일 최초 등록일시
//    private String todoUpdatedAt; // 할일 마지막 수정일

}
