package org.flysli.gadget.hibernatevalidator;

import org.flysli.gadget.bean.Person;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Person person = new Person();
        person.setAge(1);
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        validate.parallelStream().forEach(e->{
            System.out.println(e.getPropertyPath()+""+e.getMessage());
        });

    }
}
