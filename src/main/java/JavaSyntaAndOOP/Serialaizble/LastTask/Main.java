package JavaSyntaAndOOP.Serialaizble.LastTask;

import java.io.*;

public class Main {

    public static void main(String[] args) {



        try
            (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.bin")))
        {
                Employee p1 = new Employee("Back end devoleper", 1, 3000);
                oos.writeObject(p1);
            } catch (IOException e){
            e.printStackTrace();
        }

        try
                (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.bin")))
        {
            Employee p2 = (Employee) ois.readObject();
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
    }
}
}
