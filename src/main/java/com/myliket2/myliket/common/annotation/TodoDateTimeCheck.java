package com.myliket2.myliket.common.annotation;

import com.myliket2.myliket.common.validation.TodoTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={TodoTimeValidator.class})
public @interface TodoDateTimeCheck {

    String message() default "일졍을 과거로 설정할 수 없습니다.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 }
