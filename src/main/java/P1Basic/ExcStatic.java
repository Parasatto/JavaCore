package P1Basic;

public class ExcStatic {
    public static void main(String[] args) {
        // 1. Создаем 3 сотрудников
        Employee emp1 = new Employee("Иван", 50000);
        Employee emp2 = new Employee("Мария", 60000);
        Employee emp3 = new Employee("Петр", 55000);

        // 2. Выводим информацию о каждом (обычный метод)
        emp1.printInfo();
        emp2.printInfo();
        emp3.printInfo();

        // 3. Выводим общее количество (статический метод через имя класса)
        System.out.println("Всего сотрудников: " + Employee.numbersofEmpoyee());

        // 4. Эксперимент: меняем название компании для всех сразу
        Employee.companyName = "New IT Corp";
        System.out.println("\n--- После смены названия компании ---");
        emp1.printInfo(); // У Ивана тоже изменится название компании
    }
}

class Employee {

    private String name;
    private int salary;

    private static int countEmployee = 0;
    public static String companyName = "JavaTech";

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        countEmployee++;
    }


    public void printInfo(){
        System.out.println(name + " "+salary+" "+companyName);
    }

    public static int numbersofEmpoyee(){
        return countEmployee;
    }

}
