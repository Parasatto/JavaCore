package Repeating.Lesson38;

public class Main {

    public static void main(String[] args) throws IllegalAgeException {

        int num = -1;

        if (num < 0 || num > 150){
            throw new IllegalAgeException("Возраст не может быть отрицательным или Введен слишком большой возраст");
        }

    }
}
