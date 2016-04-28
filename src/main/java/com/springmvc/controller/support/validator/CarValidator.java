package com.springmvc.controller.support.validator;

import com.springmvc.demo.model.Car;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CarValidator implements Validator {

    /**
     * supports(): declare classes supported by this validator
     * @param aClass
     * @return
     */
    public boolean supports(Class aClass) {
        return Car.class.equals(aClass);
    }

    /**
     * To add an error these parameters are needed:
     * Car field name
     * error message key
     * default message if no message is not found for the key
     *
     * @param obj
     * @param errors
     */
    public void validate(Object obj, Errors errors) {
        Car car = (Car) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "field.required", "Required field");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required field");
        if (!errors.hasFieldErrors("price")) {
            if (car.getPrice().intValue() == 0)
                errors.rejectValue("price", "not_zero", "Can't be free!");
        }
    }
}