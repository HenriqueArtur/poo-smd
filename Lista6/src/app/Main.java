package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        List<ContaBancaria> contas = new ArrayList<>();
        ContaBancaria conta1 = new ContaCorrente(1, 100.00, 1.00);
        ContaBancaria conta2 = new ContaPoupanca(2, 200.00, 1.00);
        ContaBancaria conta3 = new ContaCorrente(3, 300.00, 1.00);
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);

        Banco devBank = new Banco(contas);
        devBank.gerenciaConta(sc);
        
        sc.close();
    }
}