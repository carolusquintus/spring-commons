package com.github.damianwajser.validator.constraint.global;

import com.github.damianwajser.validator.annotation.global.Email;
import com.github.damianwajser.validator.constraint.AbstractConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraint extends AbstractConstraint implements ConstraintValidator<Email, Object> {

	private static final String PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	@Override
	public void initialize(Email field) {
		super.initialize(field.excludes(), field.onlyIn(), field.isNulleable());
		super.isNulleable = field.isNulleable();
	}

	@Override
	protected boolean hasError(Object field, ConstraintValidatorContext cxt) {
		return !new PatternConstraint().initialize(this.excludes, this.onlyIn, PATTERN, this.isNulleable).isValid(field, cxt);
	}
}
