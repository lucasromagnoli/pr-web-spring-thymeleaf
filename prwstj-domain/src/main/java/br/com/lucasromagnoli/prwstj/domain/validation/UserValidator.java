package br.com.lucasromagnoli.prwstj.domain.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.lucasromagnoli.prwstj.domain.model.User;
import br.com.lucasromagnoli.prwstj.domain.repository.jpa.UsersJpaRepository;
import br.com.lucasromagnoli.utils.validation.ValidatorUtils;

@Component
public class UserValidator implements Validator{

	@Autowired
	UsersJpaRepository usersJpaRepository;
	
	public static final int NAME_MIN_LENGTH = 3;
	public static final int NAME_MAX_LENGTH = 30;
	public static final int PASSWORD_MIN_LENGTH = 8;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validator.input.generic.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validator.input.generic.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validator.input.generic.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "validator.input.generic.field.required");
	}

	public void validateSignUp(User user, Errors errors) {
		validate(user, errors);
		
		if (!errors.hasFieldErrors("name")) {
			if (!ValidatorUtils.hasOnlyLettersIgnoreAccentsAndWhiteSpace(user.getName())) {
				errors.rejectValue("name", "validator.input.users.name.dont.has.only.letters");
			}
		}

		if (!errors.hasFieldErrors("name")) {
			if (!ValidatorUtils.hasLengthBetween(user.getName(), NAME_MIN_LENGTH, NAME_MAX_LENGTH)) {
				errors.rejectValue("name", "validator.input.users.name.out.of.range");
			}
		}

		if (!errors.hasFieldErrors("email")) {
			if (!ValidatorUtils.hasEmailFormat(user.getEmail())) {
				errors.rejectValue("email", "validator.input.users.email.invalid");
			}
		}
		
		if (!errors.hasFieldErrors("password")) {
			if (!ValidatorUtils.hasMinCharactersAndOneUpperCaseLatterAndOneNumber(user.getPassword(), PASSWORD_MIN_LENGTH)) {
				errors.rejectValue("password", "validator.input.users.password.dont.has.min.conditions");
			}
		}

		if (!errors.hasFieldErrors("password") && !errors.hasFieldErrors("passwordConfirm")) {
			if (!(user.getPassword().equals(user.getPasswordConfirm()))) {
				errors.rejectValue("passwordConfirm", "validator.input.users.password.dont.match");
				errors.rejectValue("password", "validator.input.users.password.dont.match");
			}
		}
		
		if (!errors.hasErrors()) {
			if (usersJpaRepository.existsUserByEmail(user.getEmail())) {
				errors.rejectValue("email", "validator.input.users.email.already.registred");
			}
			usersJpaRepository.existsUserByEmail(user.getEmail());
		}

	}
}
