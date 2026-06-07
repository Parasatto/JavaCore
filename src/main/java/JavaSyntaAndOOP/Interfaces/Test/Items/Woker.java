package JavaSyntaAndOOP.Interfaces.Test.Items;

import JavaSyntaAndOOP.Interfaces.Test.Security.Checkable;

public class Woker implements Checkable {

    String name;

    public Woker(String name) {
        this.name = name;
    }

    @Override
    public void check() {
        System.out.println("Сотрудник " +name+ " прошел через металлоискатель");
    }
}
