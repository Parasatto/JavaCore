package Repeating.Lesson21;

public class Employee {
    public static void main(String[] args) {
        Employee e1 = new Employee("Parasat", 200);
        e1.printInfo();
        System.out.println(Employee.countEmployee);
        System.out.println(Employee.companyName);
    }

    private String name;
    private int salary;

    public static String companyName = "JavaTech";
    public static int countEmployee;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        countEmployee++;
    }

    public void printInfo(){
        System.out.println(name+", "+ salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
