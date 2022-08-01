package com.myliket2.myliket.common.validation;

import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoTimeValidator implements ConstraintValidator<TodoDateTimeCheck, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime checkTime, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime nowTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        return checkTime.isAfter(nowTime);

    }
}
