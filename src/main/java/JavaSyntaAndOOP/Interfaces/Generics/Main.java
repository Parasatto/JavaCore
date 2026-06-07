package JavaSyntaAndOOP.Interfaces.Generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<WorkAble> workers= new ArrayList<>();

        WorkAble w1 = new Robot();
        WorkAble w2 = new Crane();
        WorkAble w3 = new Robot();

        workers.add(w1);
        workers.add(w2);
        workers.add(w3);

        for (WorkAble w: workers){
            w.work();
        }
    }
}
