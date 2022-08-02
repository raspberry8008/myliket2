package com.myliket2.myliket.dao;

import com.myliket2.myliket.dto.Category;
import com.myliket2.myliket.vo.CategoryVO;

import java.util.List;

//@Mapper
//@Repository
public interface CategoryDAO {

    /**
     * 카테고리 전체 목록 조회
     * methodName : allCategoryList
     *
     * @return List<Category.ResponseInfo> 카테고리 목록
     */
    List<CategoryVO> allCategoryList () throws Exception;

    /**
     * 카테고리 상세조회
     * methodName : getCategoryDetail
     *
     * @param categoryVO 요청한 카테고리 아이디
     * @return Category.ResponseInfo(Object) 카테고리 상세정보
     */
    CategoryVO getCategoryDetail (CategoryVO categoryVO) throws Exception;

    /**
     * 카테고리 등록
     * methodName : insertCategory
     *
     * @param categoryVO(Object) 등록할 카테고리 정보
     * @return int 카테고리 등록 처리 수
     */
    int insertCategory (CategoryVO categoryVO) throws Exception;

    /**
     * 카테고리 수정
     * methodName : updateCategory
     * @param categoryVO(Object) 수정할 카테고리 정보
     * @return int 카테고리 수정 처리 수
     * */
    int updateCategory(CategoryVO categoryVO) throws Exception;

    /**
     * 카테고리 삭제
     * methodName : deleteCategory
     * @param categoryVO 삭제요청한 카테고리 아이디
     * @return int 카테고리 삭제 데이터 처리 수
     * */
    int deleteCategory (CategoryVO categoryVO) throws Exception;
}
