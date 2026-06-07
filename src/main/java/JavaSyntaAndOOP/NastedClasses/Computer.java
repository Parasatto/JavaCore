package JavaSyntaAndOOP.NastedClasses;

public class Computer {


    private String modelName;

    public Computer(String modelName) {
        this.modelName = modelName;
    }


    private class Processor{
         void startProcessing(){
            System.out.println("Процессор компьютера "+ modelName+ " начал работу");
        }
    }

    public static class Ram{
        void getSpace(){
            System.out.println("Это оперативная память DDR4");
        }
    }


    void performSelfTest(){
         class SystemChecker{
            void check(){
                System.out.println("Проверка системы " + modelName + " пройдена");
            }
        }
        SystemChecker s1 = new SystemChecker();
         s1.check();
    }


}
