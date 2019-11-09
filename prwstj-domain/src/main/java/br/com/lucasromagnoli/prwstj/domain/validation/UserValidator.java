package br.com.lucasromagnoli.prwstj.domain.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.lucasromagnoli.prwstj.domain.model.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validator.input.generic.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validator.input.generic.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validator.input.generic.field.required");
	}

	public void validateSignUp(User user, Errors errors) {
		validate(user, errors);
		if (!(user.getPassword().equals(user.getPasswordConfirm()))) {
			errors.rejectValue("password", "validator.input.users.password.dont.match");
		}
	}
}
