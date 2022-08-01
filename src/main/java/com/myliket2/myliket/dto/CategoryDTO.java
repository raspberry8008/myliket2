package com.myliket2.myliket.dto;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
 *  CategoryDTO : 사용자가 입력한 카테고리 정보
 *
 *  String categoryId : 카테고리 아이디/UUID (필수값 : FALSE - uuid)
 *  String categoryName : 카테고리 이름 (필수값 :TRUE)
 *  String stateKor : 카테고리 상태코드 한글명 (필수값 : sql - now())
 */

@Setter
@ToString
@Builder
public class CategoryDTO {

    private String categoryId; // 카테고리 코드

    @NotBlank
    @Size(min=1, max=15)
    private String categoryName; //카테고리 이름

    private String categoryState; // 카테고리 코드 상태

}
