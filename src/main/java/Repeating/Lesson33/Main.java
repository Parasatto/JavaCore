package Repeating.Lesson33;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<WorkAble> workables = new ArrayList<>();

        workables.add(new Crane());
        workables.add(new Robot());
        workables.add(new Crane());



        for (WorkAble w : workables){
            w.work();
        }

        WorkAble workAble = new WorkAble() {
            @Override
            public void work() {
                System.out.println("Testing anonim classes");
            }
        };

        workAble.work();




    }
}
