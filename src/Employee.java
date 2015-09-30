/**
 * Created by rafsan.jani on 9/30/15.
 */
public class Employee {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @ValidEmail
    private String email;
    @NotNull
    @Range
    private Integer age;
    @NotNull
    @ValidInfo
    private String sex;


    public Employee() {

    }

    public Employee(String firstName, String lastName, String email, Integer age, String sex) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setAge(age);
        this.setSex(sex);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void print() {
        System.out.println("**********************************************");
        System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.getEmail());
        System.out.println(this.getAge());
        System.out.println(this.getSex());
        System.out.println("**********************************************");
    }
}
