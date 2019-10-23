package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ErroArray erroArray = new ErroArray();

        Scanner sc = new Scanner(System.in);

        System.out.print("Value: ");
        int value = sc.nextInt();
        System.out.print("Pos: ");
        int pos = sc.nextInt();

        try {
            erroArray.addInArrayPossition(value, pos);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Try pos from 0 to 9");
            System.out.print("Value: ");
            value = sc.nextInt();
            System.out.print("Pos: ");
            pos = sc.nextInt();
            erroArray.addInArrayPossition(value, pos);
        }

        sc.close();
    }
}