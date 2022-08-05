package com.myliket2.myliket.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.myliket2.myliket.domain.vo.TodoVO;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Response {

    private Object data;
    private List<?> resultList;

}
