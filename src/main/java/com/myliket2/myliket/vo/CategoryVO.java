package com.myliket2.myliket.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class CategoryVO {

    private String categoryId; // 카테고리 코드

//    private String memberId; //	 회원 아이디
    @NotBlank
    @Size(min=1, max=15)
    private String categoryName; //카테고리 이름

    private String categoryState; // 카테고리 코드 상태
    private LocalDateTime categoryCreatedAt; //	최초 등록일자
    private LocalDateTime categoryUpdatedAt;  // 최근 수정일자

}
