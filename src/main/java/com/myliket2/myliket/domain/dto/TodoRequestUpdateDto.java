package com.myliket2.myliket.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@ToString
public class TodoRequestUpdateDto {

    /*
     *  TodoUpdateDto : 수정할 할일 상세 정보
     *
     *  String categoryId : 카테고리 아이디 (필수값 :TRUE)
     *  String todoTitle : 할일 제목 (필수값 :TRUE)
     *  String todoContent : 할일 내용 (필수값 :TRUE)
     *  LocalDate todoDay : 할일 일정일자 (필수값 :TRUE)
     *  LocalTime todoTime : 할일 일정시간
     *  String todoState: 할일 상태 코드 (필수값 :TRUE)
     *  LocalDateTime checkDateTime : 할일 일정 및 시간 (todoDay + todoTime - 유효성검증)
     *
     */


        @NotNull
        @JsonFormat(pattern = "^[0-9]")
        private Long todoNo; // 할일 고유번호
        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        @NotBlank
        @Size(min=1, max=15)
        private String todoTitle; // 할일 제목

        @NotBlank
        @Size(min=1, max=100)
        private String todoContent; // 할일 내용


        @NotNull(message = "일정을 입력해주세요.")
        private  LocalDate todoDay; // 할일 일정일자

        private  LocalTime todoTime; // 할일 시간

        @TodoDateTimeCheck
        private LocalDateTime todoDateTime;

        @Pattern(regexp = "^[A-Z]{2}$", message = "할일 상태코드를 입력해주세요.")
        private String todoState; // 할일 상태 코드

        @Builder
        public TodoRequestUpdateDto(Long todoNo, String categoryId, String todoTitle, String todoContent, LocalDate todoDay, LocalTime todoTime, String todoState) {
                this.todoNo = todoNo;
                this.categoryId = categoryId;
                this.todoTitle = todoTitle;
                this.todoContent = todoContent;
                this.todoDay = todoDay;
                this.todoTime = todoTime;
                this.todoState = todoState;
                this.todoDateTime = todoDateTimeMake( todoDay,todoTime );
        }



/*
            todoDateTimeMake : 유효성 검증용 LocalDateTime
            @param : todoDay(할일일정 일자), todoTime (할일 일정시간)
         */
        private LocalDateTime todoDateTimeMake(LocalDate todoDay, LocalTime todoTime) {

        if (Objects.equals(null, todoTime)) {
                return LocalDateTime.parse(LocalDateTime.of(todoDay, LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }
        return LocalDateTime.parse(LocalDateTime.of(todoDay, todoTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
}


}
