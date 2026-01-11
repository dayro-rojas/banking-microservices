    package com.banking.auth_service.validation;

    import jakarta.validation.Constraint;
    import jakarta.validation.Payload;
    import java.lang.annotation.*;

    @Documented
    @Constraint(validatedBy = UsernameUniqueValidator.class)
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UsernameUnique {
        String message() default "El nombre de usuario ya existe";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }