import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by rafsan.jani on 9/22/15.
 */
public class ValidationFramework {

    @Test
    public void test1() {
        Employee employee = new Employee("", "Jani", "rafsan.jani@gmail.com", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test2() {
        Employee employee = new Employee("Rafsan", "", "rafsan.jani@gmail.com", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test3() {
        Employee employee = new Employee("Rafsan", "Jani", "", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test4() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test5() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani@gmail.com", 5, "male");
        validateObject(employee);
    }

    @Test
    public void test6() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani@gmail.com", 500, "male");
        validateObject(employee);
    }

    @Test
    public void test7() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani@gmail.com", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test8() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani@gmail.com", 25, "");
        validateObject(employee);
    }

    @Test
    public void test9() {
        Employee employee = new Employee("Rafsan", "Jani", "rafsan.jani@gmail.com", 25, "male");
        validateObject(employee);
    }

    @Test
    public void test10() {
        Employee employee = new Employee("Taylor", "Swift", "taylor@yahoo.com", 25, "female");
        validateObject(employee);
    }

    @Test
    public void test11() {
        Employee employee = new Employee();
        employee.setFirstName("Hason");
        employee.setLastName("Raja");
        employee.setEmail("hasonraja@therapserveices.net");
        employee.setAge(65);
        employee.setSex("male");
        validateObject(employee);
    }

    private boolean validateEmail(String text) {
        return EmailValidator.getInstance().validate(text);
    }

    private void validateObject(Employee employee) {
        Field[] fields = employee.getClass().getDeclaredFields();
        boolean valid = true;
        Object object = null;
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            //System.out.println("\n"+field.getName()+" has "+annotations.length+" annotaions.");
            field.setAccessible(true);
            try {
                object = field.get(employee);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (Annotation annotation : annotations) {
                if(valid==false){
                    break;
                }
                if (annotation instanceof NotNull) {
                    if (object instanceof String) {
                        if ( object.equals("")) {
                            valid = false;
                            System.out.println("Error!!!");
                            System.out.println("Attribute "+field.getName() + " is Null.");
                        }
                    } else if (object instanceof Integer) {
                        if (object == null) {
                            valid = false;
                            System.out.println("Error!!!");
                            System.out.println("Attribute "+field.getName() + " is Null.");
                        }
                    }

                    // System.out.println("NotNull");l
                } else if (annotation instanceof Range) {
                    if (object instanceof Integer) {
                        if (((Integer) object).intValue() > 150 || ((Integer) object).intValue() < 15) {
                            valid = false;
                            System.out.println("Error!!!");
                            System.out.println("Attribute "+field.getName() + " is out of range.");
                        }
                    }
                    //   System.out.println("Range");
                } else if (annotation instanceof ValidEmail) {
                    if (object instanceof String) {
                        if (validateEmail(object.toString())==false) {
                            valid = false;
                            System.out.println("Error!!!");
                            System.out.println("Attribute "+field.getName() + " is invalid.");
                        }
                    }
                }
            }
            field.setAccessible(false);
        }
        if (valid) {
            System.out.println(" Passed");
        }

    }
}
