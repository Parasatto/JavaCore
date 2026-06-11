package JavaCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class taskIterable {
    public static void main(String[] args) {
        List<Personn> mylist = new ArrayList<>();
        mylist.add(new Personn(14, "Parast"));
        mylist.add(new Personn(19, "Parast"));
        mylist.add(new Personn(20, "Parast"));
        mylist.add(new Personn(16, "Parast"));
        mylist.add(new Personn(22, "Parast"));
        mylist.add(new Personn(30, "Parast"));

        Iterator<Personn> myIterator = mylist.iterator();

        System.out.println("before");
        while (myIterator.hasNext()){
            System.out.println(myIterator.next());
        }

        Iterator<Personn> deleteIterator = mylist.iterator();
        while (deleteIterator.hasNext()){
            Integer age = deleteIterator.next().getAge();
            if (age < 18)
                deleteIterator.remove();
        }

        Iterator<Personn> afterdelete = mylist.iterator();
        System.out.println("after");
        while (afterdelete.hasNext()){
            System.out.println(afterdelete.next());
        }



    }
}
