package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what size board?");
        int size = scanner.nextInt();

        while (size < 4) {
            System.out.println("too small, try again");
            System.out.println("what size board?");
            size = scanner.nextInt();
        }

        Board board = new Board(size);
        System.out.println("Board size is " + board.getSize());

    }

    public static void sayHello(){
        System.out.println("Hello");
    }

    public static void sayGoodbye(){
        System.out.println("bye!");
    }
}

