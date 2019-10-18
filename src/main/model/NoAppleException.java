package model;

public class NoAppleException extends AppleException {

    public NoAppleException() {
        System.out.println("Error: No apples found.");
    }

}
