package JavaSyntaAndOOP.Serialaizble.LastTask;

import java.io.Serializable;

public class Employee implements Serializable {
    private String position;
    private int id;
    private transient int salary;
    private static final long serialVersionUID = 1L;

    public Employee(String position, int id, int salary) {
        this.position = position;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
