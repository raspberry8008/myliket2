package com.myliket2.myliket.common.validation;

import com.myliket2.myliket.common.annotation.TodoTimeCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TodoTimeValidator implements ConstraintValidator<TodoTimeCheck, LocalTime> {

    @Override
    public boolean isValid(LocalTime time, ConstraintValidatorContext constraintValidatorContext) {
        // 사용자 입력 시간
        LocalTime inputTime = LocalTime.parse(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        // 현재 시간
        LocalTime checkTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return "".equals(checkTime) || inputTime.isAfter(checkTime) ? true : false;

    }
}
