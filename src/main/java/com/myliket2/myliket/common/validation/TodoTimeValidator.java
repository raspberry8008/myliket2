package com.myliket2.myliket.common.validation;

import com.myliket2.myliket.common.annotation.TodoDateTimeCheck;
import lombok.val;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

/*
    TodoTimeValidator : 일정 시간 과거 확인
    LocalDateTime todoTime : 할일 일정 및 시간

    일정 입력을 안했을 떄의 값 : 1000-01-01T00:00

 */
public class TodoTimeValidator implements ConstraintValidator<TodoDateTimeCheck, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime todoTime, ConstraintValidatorContext constraintValidatorContext) {

        // 시간 설정을 안했다면 true
        if (todoTime.toString().matches("1000-01-01T00:00")) {
            return true;
        }
        // 오늘 날짜 및 현재시간
        LocalDateTime nowTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        // 입력받은 날짜 및 시간
        LocalDateTime isTime = LocalDateTime.parse(todoTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        return nowTime.isBefore(isTime);
    }
}
