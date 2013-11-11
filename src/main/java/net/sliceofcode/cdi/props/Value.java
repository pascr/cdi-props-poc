package net.sliceofcode.cdi.props;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author pascr
 */
@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, PARAMETER, FIELD })
public @interface Value {
    //
    @Nonbinding public String value() default "";
}
