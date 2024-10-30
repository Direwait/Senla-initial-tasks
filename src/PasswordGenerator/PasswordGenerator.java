package PasswordGenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        do a=Check(scanner);
        while (a<8||a>12);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();
        char[] special = "!@#$%^&*(){}[]_-+~`/\\".toCharArray();
        StringBuilder tempPassWord = new StringBuilder();
        Random gen = new Random();

        tempPassWord.append(alphabet[gen.nextInt(alphabet.length)]);
        tempPassWord.append(Character.toUpperCase(alphabet[gen.nextInt(alphabet.length)]));
        tempPassWord.append(digits[gen.nextInt(digits.length)]);
        tempPassWord.append(special[gen.nextInt(special.length)]);
        for (int i = 4; i < a; i++) {
            int randomType = gen.nextInt(3);
            switch (randomType) {
                case 0:
                    tempPassWord.append(alphabet[gen.nextInt(alphabet.length)]);
                    break;
                case 1:
                    tempPassWord.append(digits[gen.nextInt(digits.length)]);
                    break;
                case 2:
                    tempPassWord.append(special[gen.nextInt(special.length)]);
                    break;
            }
        }
        String password = tempPassWord.toString();
        password = shuffleString(password);
        System.out.println(password);
    }
    private static int Check(Scanner scan){
        System.out.print("ВВЕДИТЕ ЧИСЛО ОТ 8 ДО 12 СИМВОЛОВ: ");
        return Integer.parseInt(scan.nextLine());
    }

    private static String shuffleString(String s) {
        char[] symbols = s.toCharArray();
        Random gen = new Random();
        for (int i = symbols.length - 1; i > 0; i--) {
            int index = gen.nextInt(i + 1);
            char temp = symbols[index];
            symbols[index] = symbols[i];
            symbols[i] = temp;
        }
        return new String(symbols);
    }
}