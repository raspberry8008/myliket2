package com.myliket2.myliket.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Category {

    /*
     *  Category.ResponseInfo : 카테고리 상세 정보
     *
     *  String categoryId : 카테고리 아이디/UUID
     *  String categoryName : 카테고리 이름
     *  String stateKor : 카테고리 상태코드 한글명
     */
    @Getter
    @ToString
    public static class ResponseInfo {

        private String categoryId; // 카테고리 아이디
        private String categoryName; //카테고리 이름
        private String stateKor; // 카테고리 상태코드 한글명

        @Builder
        public ResponseInfo(String categoryId, String categoryName, String stateKor) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.stateKor = stateKor;
        }
    }

    /*
     *  Category.RequestInsert : 등록할 카테고리 정보
     *
     *  String categoryId : 카테고리 아이디 (기본값 : UUID)
     *  String categoryName : 카테고리 이름 (필수값 :TRUE)
     *
     */
    @Getter
    @Setter
    @ToString
    public static class RequestInsert {

        private String categoryId; // 카테고리 코드

        @NotBlank
        @Size(min=1, max=15)
        private String categoryName; //카테고리 이름

        @Builder
        public RequestInsert(String categoryId, String categoryName) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
        }
    }

    /*
     *  Category.RequestUpdate : 수정할 카테고리 정보
     *
     *  String categoryId : 카테고리 아이디/UUID (필수값 :TRUE)
     *  String categoryName : 카테고리 이름 (필수값 :TRUE)
     *  String categoryState : 카테고리 상태 코드 (필수값 :TRUE)
     */
    @Getter
    @Setter
    @ToString
    public static class RequestUpdate {
        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId;

        @NotBlank
        @Size(min=1, max=15)
        private String categoryName;
        @NotBlank
        @Pattern(regexp = "[A-Z]{2}$", message = "카테고리 상태코드를 입력해주세요")
        private String categoryState;

        @Builder
        public RequestUpdate(String categoryId, String categoryName, String categoryState) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.categoryState = categoryState;
        }
    }

}
