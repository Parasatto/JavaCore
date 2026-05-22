package Interfaces;

import Interfaces.Test.Items.Woker;
import Interfaces.Test.Security.Checkable;
import Interfaces.Test.Security.DangerousCargo;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Parasat", 24);
        Animal animal = new Animal("Snake");



        Info i1 = person;
        Info i2 = animal;

        i1.showInfo();
        i2.showInfo();

        DangerousCargo d1 = new DangerousCargo("Cola", 20);

        Woker w1 = new Woker("Parasat");

        d1.check();
        w1.check();

        verify(d1);
        verify(w1);

    }

    public static void verify(Checkable checking){
        checking.check();
    }
}
