package com.myliket2.myliket.vo;

import lombok.*;

/*
 *  CategoryVO : 조회 요청한 카테고리 상세 정보
 *
 *  String categoryId : 카테고리 아이디/UUID (필수값 :TRUE)
 *  String categoryName : 카테고리 이름 (필수값 :TRUE)
 *  String stateKor : 카테고리 상태코드 한글명 (필수값 :TRUE)
 */

@Getter
@ToString
public class CategoryVO {

    private String categoryId; // 카테고리 아이디
    private String categoryName; //카테고리 이름
    private String stateKor; // 카테고리 상태코드 한글명

    @Builder
    public CategoryVO(String categoryId, String categoryName, String stateKor) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.stateKor = stateKor;
    }
}
