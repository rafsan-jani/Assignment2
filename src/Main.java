import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args){
        ValidationFramework validationFramework=new ValidationFramework();
        Method[] methods=validationFramework.getClass().getMethods();
        for(Method method:methods){
            Test test=method.getAnnotation(Test.class);
            if(test!=null) {
                System.out.print("Runing " + method.getName() + " :");
                try {
                    method.invoke(validationFramework);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println();

            }
        }
    }
}
