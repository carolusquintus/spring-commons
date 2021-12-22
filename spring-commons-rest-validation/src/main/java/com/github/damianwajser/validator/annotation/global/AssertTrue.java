package com.github.damianwajser.validator.annotation.global;

import com.github.damianwajser.validator.constraint.global.AssertTrueConstraint;
import org.springframework.http.HttpMethod;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {AssertTrueConstraint.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(AssertTrue.List.class)
public @interface AssertTrue {

	HttpMethod[] excludes() default {};

	HttpMethod[] onlyIn() default {};

	String message() default "{javax.validation.constraints.AssertTrue.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String businessCode();

	boolean isNulleable() default false;

	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
	@Retention(RUNTIME)
	@Documented
	@interface List {
		AssertTrue[] value();
	}
}
