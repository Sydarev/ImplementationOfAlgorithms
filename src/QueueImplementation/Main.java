package QueueImplementation;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");
        Queue<String> clients = new ArrayDeque<>(firstClients);
        String name;
        while (!clients.isEmpty()) {
            name = clients.poll();
            if (Math.random() < 0.5) {
                clients.offer("a friend of " + name);
            }
            System.out.println(name + " сделала новый маникюр");
        }

    }
}