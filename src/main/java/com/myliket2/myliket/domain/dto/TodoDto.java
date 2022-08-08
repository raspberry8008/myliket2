package com.myliket2.myliket.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myliket2.myliket.domain.vo.TodoVO;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class TodoDto {

    /*
     *  TodoRequestInfoDto : 카테고리 조회 요청 정보
     *
     *  String categoryId : 카테고리 아이디
     *  String todoNo : 할일 고유번호
     *
     */
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PathCategoryId extends TodoVO {

        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

    }

    /*
     *  TodoRequestInfoDto : 카테고리의 할일 상세 조회 요청 정보
     *
     *  String categoryId : 카테고리 아이디
     *  String todoNo : 할일 고유번호
     *
     */

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PathTodoNo extends TodoVO {

        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        @JsonFormat(pattern = "^[0-9]")
        private Long todoNo; // 할일 고유번호

    }


    /*
     *  TodoRequestInsertDto : 등록할 할일 상세 정보
     *
     *  String categoryId : 카테고리 아이디 (필수값 :TRUE)
     *  String todoTitle : 할일 제목 (필수값 :TRUE)
     *  String todoContent : 할일 내용 (필수값 :TRUE)
     *  LocalDateTime todoDayTime : 할일 일정 및 시간 (필수값 :TRUE)
     *
     */
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestInsert extends TodoVO {

        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        @NotBlank
        @Size(min = 1, max = 15)
        private String todoTitle; // 할일 제목

        @NotBlank
        @Size(min = 1, max = 100)
        private String todoContent; // 할일 내용

        @NotNull(message = "일정을 입력해주세요.")
        @FutureOrPresent
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime todoDayTime; // 할일 일자 및 시간

    }

    /*
     *  TodoUpdateDto : 수정할 할일 상세 정보
     *
     *  Long todoNo : 할일 고유번호 (필수값 :TRUE)
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
    public static class RequestUpdate extends TodoVO {

        @NotNull
        @JsonFormat(pattern = "^[0-9]")
        private Long todoNo; // 할일 고유번호
        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        @NotBlank
        @Size(min = 1, max = 15)
        private String todoTitle; // 할일 제목

        @NotBlank
        @Size(min = 1, max = 100)
        private String todoContent; // 할일 내용

        @NotNull(message = "일정을 입력해주세요.")
        @FutureOrPresent
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime todoDayTime; // 할일 일자 및 시간

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "할일 상태코드를 입력해주세요.")
        private String todoState; // 할일 상태 코드

    }

}
