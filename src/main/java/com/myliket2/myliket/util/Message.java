package com.myliket2.myliket.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

//    private StatusEnum status;
//    private String message;

    private Object data;
    private List<Object> resultList;



    public Message() {
//        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.resultList = null;
//        this.message = null;
    }




//    public enum StatusEnum {
//
//        OK(200, "OK"),
//        BAD_REQUEST(400, "BAD_REQUEST"),
//        NOT_FOUND(404, "NOT_FOUND"),
//        INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");
//
//        int statusCode;
//        String code;
//
//        StatusEnum(int statusCode, String code) {
//            this.statusCode = statusCode;
//            this.code = code;
//        }
//    }
}
