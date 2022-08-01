package com.myliket2.myliket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*
 *  TodoDTO 사용자에게 입력받은 할일 상세 정보
 *
 *  Long todoNo : 할일 고유번호 (필수값 :TRUE)
 *  String categoryId : 카테고리 아이디 (필수값 :TRUE)
 *  String todoTitle : 할일 제목 (필수값 :TRUE)
 *  String todoContent : 할일 내용 (필수값 :TRUE)
 *  LocalDate todoDay : 할일 일정일자 (필수값 :TRUE)
 *  LocalTime todoTime : 할일 일정시간 (필수값 : FALSE)
 *  LocalDateTime checkDateTime : 할일 일정 및 시간 (todoDay + todoTime)
 *  String todoState : 할일 상태코드
 */


@Setter
@ToString
public class TodoDTO {

    @NotNull
    @JsonFormat (pattern = "^[0-9]+$")
    private Long todoNo; // 할일 고유번호
    @NotBlank
    private String categoryId; // 카테고리 아이디

    @NotBlank
    @Size(min=1, max=15)
    private String todoTitle; // 할일 제목

    @NotBlank
    @Size(min=1, max=100)
    private String todoContent; // 할일 내용

    @NotNull(message = "일정을 입력해주세요.")
    private LocalDate todoDay; // 할일 일정일자

    private LocalTime todoTime; // 할일 일정시간

    @TodoDateTimeCheck
    private LocalDateTime checkDateTime; // 할일 일정 및 시간

    @JsonFormat (pattern = "^[A-Z]+$")
    @Size(min=2, max=2)
    private String todoState; // 할일 상태 코드

    @Builder
    public TodoDTO(Long todoNo, String categoryId, String todoTitle, String todoContent, LocalDate todoDay, LocalTime todoTime, String todoState) {
        this.todoNo = (Long)todoNo;
        this.categoryId = categoryId;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDay = todoDay;
        this.todoTime = todoTime;
        this.todoState = todoState;
        this.checkDateTime = checkDateTime( todoDay,todoTime );
    }


    /*
        checkDateTime : 사용자에게 입력받은 할일 일정 및 시간 과거 인지 확인
        @param : todoDay(할일일정 일자), todoTime (할일 일정시간)
     */
    private LocalDateTime checkDateTime(LocalDate todoDay, LocalTime todoTime) {

        if (Objects.equals(null, todoTime)) {
            return LocalDateTime.parse(LocalDateTime.of(this.todoDay, LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }
        return LocalDateTime.parse(LocalDateTime.of(this.todoDay, this.todoTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }


}
