package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD) // target xác định Annotation này sẽ tác động lên FIELD
@Retention(value = RetentionPolicy.RUNTIME) // retention xác định Annotation này tác động khi nào, ở đây trong lúc chạy Run Time
public @interface Normalize {

}
