package com.myliket2.myliket.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@ToString
public class TodoRequestInfoDto {

    /*
     *  TodoRequestInfoDto : 조회 요청 정보
     *
     *  String categoryId : 카테고리 아이디
     *  String todoNo : 할일 고유번호
     *
     */
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class CategoryId extends TodoRequestVO {

        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        public CategoryId(String categoryId) {
            this.categoryId=categoryId;

        }

    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class TodoNo extends TodoRequestVO {

        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId; // 카테고리 아이디

        @NotNull
        @JsonFormat(pattern = "^[0-9]")
        private Long todoNo; // 할일 고유번호

        public TodoNo(String categoryId, Long todoNo) {
            this.categoryId=categoryId;
            this.todoNo=todoNo;

        }
    }

}
