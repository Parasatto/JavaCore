package Interfaces.AnonimClass;

public class Main {
    public static void main(String[] args) {


        AbleTo n1 = new AbleTo() {
            @Override
            public void AbleToEat() {
                System.out.println("I used this methoed by anonim class");
            }


            @Override
            public void AbleToDo(){
                System.out.println("Yeas");
            }
        };





    }
}
