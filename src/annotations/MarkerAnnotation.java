package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//when annotation will be used
@Target(ElementType.TYPE)// where it can be applied? answer: to Types
public @interface MarkerAnnotation {

}
