package com.myliket2.myliket.domain.dto;

import com.myliket2.myliket.domain.vo.CategoryVO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;


public class CategoryDto  {

    /*
     *  CategoryDto.RequestInfo : 조회 요청한 카테고리 정보
     *
     *  String categoryId : 카테고리 아이디 (기본값 : UUID)
     *
     */
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestInfo extends CategoryVO {

        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId;

    }


    /*
     *  CategoryDto.RequestInsert : 등록할 카테고리 정보
     *
     *  String categoryId : 카테고리 아이디 (기본값 : UUID)
     *  String categoryName : 카테고리 이름 (필수값 :TRUE)
     *
     */
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestInsert extends CategoryVO {

        private String categoryId;

        {
            categoryId = UUID.randomUUID().toString().replace("-","");
        }

        @NotBlank
        @Size(min=1, max=15)
        private String categoryName; //카테고리 이름

    }

    /*
     *  CategoryDto.RequestUpdate : 수정할 카테고리 정보
     *
     *  String categoryId : 카테고리 아이디/UUID (필수값 :TRUE)
     *  String categoryName : 카테고리 이름 (필수값 :TRUE)
     *  String categoryState : 카테고리 상태 코드 (필수값 :TRUE)
     */
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestUpdate extends CategoryVO{

        @NotBlank
        @Pattern(regexp = "[A-Z0-9]{32}$", message = "카테고리 아이디를 입력해주세요.")
        private String categoryId;

        @NotBlank
        @Size(min=1, max=15)
        private String categoryName;
        @NotBlank
        @Pattern(regexp = "[A-Z]{2}$", message = "카테고리 상태코드를 입력해주세요")
        private String categoryState;

    }

}
