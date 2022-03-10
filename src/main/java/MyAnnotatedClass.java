import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation(name = "Name", description = "Description")
public class MyAnnotatedClass {

    @MyAnnotation(name = "Class field annotation")
    public int classField = 0;

    @MyAnnotation(name = "Constructor annotation", description = "Annotation for constructor")
    public MyAnnotatedClass() throws NoSuchMethodException, NoSuchFieldException {
        Constructor<?> constructor = getClass().getConstructors()[0];
        MyAnnotation ann = constructor.getAnnotation(MyAnnotation.class);
        System.out.println("name : " + ann.name());
        System.out.println("description: " + ann.description());
        someMethod_1();
        someMethod_2();
        someMethod_3("String arg");
        someMethod_4();
    }

    @MyAnnotation(name = "Method annotation")
    public void someMethod_1() throws NoSuchMethodException {
        Method m = getClass().getMethod("someMethod_1");
        MyAnnotation ann = m.getAnnotation(MyAnnotation.class);
        System.out.println("name : " + ann.name());
        System.out.println("description: " + ann.description());
    }

    @MyAnnotation(name = "Method annotation", description = "Annotation for method")
    public void someMethod_2() throws NoSuchMethodException {
        Method m = getClass().getMethod("someMethod_2");
        MyAnnotation ann = m.getAnnotation(MyAnnotation.class);
        System.out.println("name : " + ann.name());
        System.out.println("description: " + ann.description());
    }

    public void someMethod_3(@MyAnnotation(name = "Method argument annotation") String arg) throws NoSuchMethodException {
        Method method = getClass().getMethod("someMethod_3", String.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotations : parameterAnnotations) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation ann = (MyAnnotation) annotation;
                    System.out.println("name : " + ann.name());
                    System.out.println("description: " + ann.description());
                }
            }
        }
    }

    public void someMethod_4() throws NoSuchFieldException {
        Field classField = getClass().getField("classField");
        MyAnnotation ann = classField.getAnnotation(MyAnnotation.class);
        System.out.println("name : " + ann.name());
        System.out.println("description: " + ann.description());
    }
}
