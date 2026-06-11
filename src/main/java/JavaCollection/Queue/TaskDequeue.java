package JavaCollection.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskDequeue {
    public static void main(String[] args) {
        Deque<String> gameAction = new ArrayDeque<>();

        gameAction.push("Go in");
        gameAction.push("Go forward 10 steps");
        gameAction.push("Turn right");
        gameAction.push("Go forward 10 steps");
        gameAction.push("Turn left");

        System.out.println(gameAction);
        System.out.println(gameAction.peek());

        System.out.println("The action: '"+ gameAction.pop()+"' was canceled");
        System.out.println(gameAction);
    }
}
