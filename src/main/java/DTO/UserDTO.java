package DTO;

public class UserDTO {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String age;
    private final String salary;
    private final String department;
    public UserDTO(String firstName, String lastName, String email, String age, String salary, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
    //-------------------- Getters and Setter------------------------
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getAge() {
        return age;
    }
    public String getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }

}
