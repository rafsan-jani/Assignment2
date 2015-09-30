/**
 * Created by rafsan.jani on 9/22/15.
 */
public class AnnotationRunner {

    @CanWalk
    public void method1() {
        System.out.println("method1");
    }

    @CanRun
    public void method2() {
        System.out.println("method2");
    }
    @CanWalk
    public void method3() {
        System.out.println("method3");
    }

    @CanRun
    public void method4() {
        System.out.println("method4");
    }

}
/*
     public static void main(String[] args) {

        AnnotationRunner runner = new AnnotationRunner();
        System.out.println(runner.getClass());

        Method[] methods = AnnotationRunner.class.getMethods();
//        Method[] methods = runner.getClass().getDeclaredMethods();

        for (Method method : methods) {
            CanRun annos = method.getAnnotation(CanRun.class);
            CanWalk walkAble = method.getAnnotation(CanWalk.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
//                    System.out.println(method.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("*************************");
        for (Method method : methods) {
            CanWalk annos = method.getAnnotation(CanWalk.class);
            //CanWalk walkAble = method.getAnnotation(CanWalk.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
 * */