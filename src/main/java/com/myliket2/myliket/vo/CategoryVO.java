package com.myliket2.myliket.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;

/*
 *  CategoryVO : 카테고리 상세정보
 *
 *  String categoryId : 카테고리 아이디/UUID
 *  String categoryName : 카테고리 이름
 *  String categoryState : 카테고리 상태 코드
 *  String stateKor : 카테고리 상태코드 한글명
 */



@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryVO {

    private String categoryId;
    private String categoryName;
    private String categoryState;
    private String stateKor;
    @Builder
    public CategoryVO(String categoryId, String categoryName, String categoryState, String stateKor) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryState = categoryState;
        this.stateKor = stateKor;
    }
}
