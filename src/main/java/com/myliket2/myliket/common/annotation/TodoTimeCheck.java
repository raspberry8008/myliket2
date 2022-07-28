package com.myliket2.myliket.common.annotation;

import com.myliket2.myliket.common.validation.TodoTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={TodoTimeValidator.class})
public @interface TodoTimeCheck {

    String message() default "과거 시간으로 설정할 수 없습니다.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 }
