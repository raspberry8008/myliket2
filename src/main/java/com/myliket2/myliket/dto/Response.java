package com.myliket2.myliket.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Response {

    private Object data;
    private List<?> resultList;
    @Builder
    public Response(Object data, List<?> resultList) {
        this.data = data;
        this.resultList = resultList;
    }

}
