package com.bloc.ontheblocapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BlocIdsExistValidator.class)
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
public @interface BlocIdsExist {
    String message() default "All supplied bloc ids must exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
