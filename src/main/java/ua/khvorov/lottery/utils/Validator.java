package ua.khvorov.lottery.utils;

public class Validator {

    private Validator() {
    }

    public static boolean areArgumentsValid(String[] args) {
        return !(args == null || args.length != 2);
    }
}