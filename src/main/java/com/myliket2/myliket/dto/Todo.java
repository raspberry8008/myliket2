package com.myliket2.myliket.dto;

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


public class Todo {

    /*
     *  ResponseInfo : 조회 요청한 할일 상세 정보
     *
     *  String categoryName : 카테고리 이름
     *  Long todoNo : 할일 고유번호
     *  String todoTitle : 할일 제목
     *  String todoContent : 할일 내용
     *  LocalDate todoDay : 할일 일정일자
     *  LocalTime todoTime : 할일 일정시간
     *  String stateKor : 할일 상태코드 한글명
     */
    @Getter
    @ToString
    public static class ResponseInfo {

        private String categoryName; // 카테고리 이름
        private Long todoNo; // 할일 고유번호

        private String todoTitle; // 할일 제목
        private String todoContent; // 할일 내용

        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate todoDay; // 할일 일정일자
        @JsonFormat(pattern = "HH:mm:ss")
        private String todoTime; // 할일 일정시간

        private String stateKor; // 할일 상태 코드 한글명

        @Builder
        public ResponseInfo(String categoryName, Long todoNo, String todoTitle, String todoContent, LocalDate todoDay, String todoTime, String stateKor) {
            this.categoryName = categoryName;
            this.todoNo = todoNo;
            this.todoTitle = todoTitle;
            this.todoContent = todoContent;
            this.todoDay = todoDay;
            this.todoTime = "";
            this.stateKor = stateKor;
        }
    }

    /*
     *  RequestInsert : 등록할 할일 상세 정보
     *
     *  String categoryId : 카테고리 아이디 (필수값 :TRUE)
     *  String todoTitle : 할일 제목 (필수값 :TRUE)
     *  String todoContent : 할일 내용 (필수값 :TRUE)
     *  LocalDate todoDay : 할일 일정일자 (필수값 :TRUE)
     *  LocalTime todoTime : 할일 일정시간
     *  LocalDateTime checkDateTime : 할일 일정 및 시간 (todoDay + todoTime - 유효성검증)
     *
     */

    @Getter
    @Setter
    @ToString
    public static class RequestInsert {

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
        private LocalDate todoDay; // 할일 일정일자

        private LocalTime todoTime; // 할일 일정시간

        @TodoDateTimeCheck
        private LocalDateTime checkDateTime; // 할일 일정 및 시간

        @Builder
        public RequestInsert(String categoryId, String todoTitle, String todoContent, LocalDate todoDay, LocalTime todoTime) {
            this.categoryId = categoryId;
            this.todoTitle = todoTitle;
            this.todoContent = todoContent;
            this.todoDay = todoDay;
            this.todoTime = todoTime;
            this.checkDateTime = checkDateTimeMake( todoDay,todoTime );
        }


        /*
            checkDateTimeMake : 유효성 검증용 LocalDateTime
            @param : todoDay(할일일정 일자), todoTime (할일 일정시간)
         */
        private LocalDateTime checkDateTimeMake( LocalDate todoDay, LocalTime todoTime) {

            if (Objects.equals(null, todoTime)) {
                return LocalDateTime.parse(LocalDateTime.of(todoDay, LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
            }
            return LocalDateTime.parse(LocalDateTime.of(todoDay, todoTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }

    }

    /*
     *  RequestUpdate : 수정할 할일 상세 정보
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

    @Getter
    @Setter
    @ToString
    public static class RequestUpdate {
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
        private LocalDate todoDay; // 할일 일정일자

        private LocalTime todoTime; // 할일 일정시간

        @TodoDateTimeCheck
        private LocalDateTime checkDateTime; // 할일 일정 및 시간
        @Pattern(regexp = "^[A-Z]{2}$", message = "할일 상태코드를 입력해주세요.")
        private String todoState; // 할일 상태 코드

        @Builder
        public RequestUpdate(Long todoNo, String categoryId, String todoTitle, String todoContent, LocalDate todoDay, LocalTime todoTime, String todoState) {
            this.todoNo = todoNo;
            this.categoryId = categoryId;
            this.todoTitle = todoTitle;
            this.todoContent = todoContent;
            this.todoDay = todoDay;
            this.todoTime = todoTime;
            this.todoState = todoState;
            this.checkDateTime = checkDateTimeMake( todoDay,todoTime );
        }


        /*
            checkDateTimeMake : 유효성 검증용 LocalDateTime
            @param : todoDay(할일일정 일자), todoTime (할일 일정시간)
         */
        private LocalDateTime checkDateTimeMake( LocalDate todoDay, LocalTime todoTime) {

            if (Objects.equals(null, todoTime)) {
                return LocalDateTime.parse(LocalDateTime.of(todoDay, LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
            }
            return LocalDateTime.parse(LocalDateTime.of(todoDay, todoTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }

    }

}
