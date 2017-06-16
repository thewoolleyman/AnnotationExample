import java.lang.reflect.Method;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Anno {
  String type();
}

public class Main {

  public static void main(String[] args) throws NoSuchMethodException {
    Class<Main> mainClass = Main.class;
    Method method = mainClass.getMethod("someMethod", new Class[]{});
    Anno anno = method.getAnnotation(Anno.class);
    System.out.println(anno.type());
  }

  @Anno(type = "tater")
  public void someMethod() {
  }
}
