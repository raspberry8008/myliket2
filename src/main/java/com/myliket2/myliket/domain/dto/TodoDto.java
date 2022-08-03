package com.myliket2.myliket.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;
import com.myliket2.myliket.domain.vo.TodoRequestVO;
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


public class TodoDto {

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

    }

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
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestInfo extends TodoRequestVO {

        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 이름
        @JsonFormat(pattern = "^[0-9]")
        private Long todoNo; // 할일 고유번호

    }

    /*
     *  TodoDto.RequestInsert : 등록할 할일 상세 정보
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
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestInsert extends TodoRequestVO {

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
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestUpdate extends TodoRequestVO {
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

        private LocalTime todoTime; // 할일 시간
//        @TodoDateTimeCheck

//        @JsonIgnoreProperties("todoDateTime")
//        private LocalDateTime todoDateTime = todoDateTimeMake(todoDay, todoTime);

        @Pattern(regexp = "^[A-Z]{2}$", message = "할일 상태코드를 입력해주세요.")
        private String todoState; // 할일 상태 코드



        /*
            todoDateTimeMake : 유효성 검증용 LocalDateTime
            @param : todoDay(할일일정 일자), todoTime (할일 일정시간)
         */

        public static LocalDateTime todoDateTimeMake ( LocalDate todoDay, LocalTime todoTime) {


            if (Objects.equals(null, todoTime)) {
                return LocalDateTime.parse(LocalDateTime.of(todoDay, LocalTime.now().plusHours(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
            }
            return LocalDateTime.parse(LocalDateTime.of(todoDay, todoTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }

    }

}
