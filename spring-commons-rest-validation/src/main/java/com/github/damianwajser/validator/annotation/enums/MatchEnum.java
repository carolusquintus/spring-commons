package com.github.damianwajser.validator.annotation.enums;

import com.github.damianwajser.validator.constraint.enums.MatchEnumConstraint;
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
@Constraint(validatedBy = {MatchEnumConstraint.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(MatchEnum.List.class)
public @interface MatchEnum {

	HttpMethod[] excludes() default {};

	HttpMethod[] onlyIn() default {};

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String businessCode();

	boolean isNulleable() default false;

	Class<? extends Enum<?>> enumClass();

	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
	@Retention(RUNTIME)
	@Documented
	@interface List {
		MatchEnum[] value();
	}
}
