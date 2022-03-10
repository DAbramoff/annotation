import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//RetentionPolicy.SOURCE - for code generation
//RetentionPolicy.CLASS - for code generation
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {
        ElementType.TYPE,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE,
        ElementType.CONSTRUCTOR,
        ElementType.TYPE_PARAMETER,
        ElementType.ANNOTATION_TYPE,
        ElementType.PACKAGE
})
public @interface MyAnnotation {
    String name();
    String description() default "Default description";
}
