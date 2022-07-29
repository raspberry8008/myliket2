package com.myliket2.myliket.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
public class CategoryVO {

    private String categoryId; // 카테고리 코드
    private String categoryName; //카테고리 이름
    private String categoryState; // 카테고리 코드 상태
    private LocalDateTime categoryCreatedAt; //	최초 등록일자
    private LocalDateTime categoryUpdatedAt;  // 최근 수정일자

    @Builder
    public CategoryVO(String categoryId, String categoryName, String categoryState) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryState = categoryState;
    }
}
