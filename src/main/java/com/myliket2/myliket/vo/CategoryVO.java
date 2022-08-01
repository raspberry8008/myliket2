package com.myliket2.myliket.vo;

import lombok.*;

@Getter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryVO {

    private String categoryId; // 카테고리 코드
    private String categoryName; //카테고리 이름
    private String stateKor; // 카테고리 코드 한글명

//    @Builder
//    public CategoryVO(String categoryId, String categoryName, String stateKor) {
//        this.categoryId = categoryId;
//        this.categoryName = categoryName;
//        this.stateKor = stateKor;
//    }
}
