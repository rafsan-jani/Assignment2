import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args){
        Testing testing=new Testing();
        Method[] methods=testing.getClass().getMethods();
        for(Method method:methods){
            Test test=method.getAnnotation(Test.class);
            if(test!=null) {
                System.out.print("Runing " + method.getName() + " :");
                try {
                    method.invoke(testing);
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
