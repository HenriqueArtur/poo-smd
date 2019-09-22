package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Banco
 */
public class Banco implements Imprimivel {

    List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public Banco(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public void gerenciaConta(Scanner sc){
        System.out.println();
        System.out.println("OPCOES DE OPERAÇÕES");
        System.out.println("1. Criar Conta");
        System.out.println("2. Selecionar Conta (incompleto)");
        System.out.println("3. Remover Conta");
        System.out.println("4. Gerar Relatorio");
        System.out.println("5. Finalizar");

        
        System.out.print("Opcao: ");
        int gerenciaOpcao = sc.nextInt();
        switch (gerenciaOpcao) {
            case 1:
                System.out.println();
                System.out.println("TIPOS DE CONTA");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupanca");
                System.out.print("Qual tipo de conta gostaria de cria: ");
                int tipo = sc.nextInt();
                criarConta(sc, tipo);
                break;
            case 2:
                selecionarConta(sc);
                break;
            case 3:
                System.out.println();
                System.out.print("Numero de conta que deseja remover: ");
                int numeroConta = sc.nextInt();
                removeConta(sc, numeroConta);
                break;
            case 4:
                System.out.println();
                System.out.println("RELATORIO:");
                mostraDados();
                break;
            case 5:
                System.out.println();
                System.out.println("Obrigado por usar os caixas do Dev Bank");
                System.exit(0);
                break;
            default:
                System.out.println();
                System.out.println("Opcao invalida. Tente novamente");
                gerenciaConta(sc);
        }
        outraOperação(sc);
        System.out.println();
    }

    public void outraOperação(Scanner sc) {

        System.out.println();
        System.out.println("Gostaria de fazer outra operação? (1.Sim / 2. Não)");
        System.out.print("Opcao: ");
        int opcao = sc.nextInt();
        if(opcao >= 3) {
            System.out.println("OPCAO INVALIDA!!!");
            outraOperação(sc);
        } else if(opcao == 1) {
            gerenciaConta(sc);
        } else {
            System.out.println();
            System.out.println("Obrigado por usar os caixas do Dev Bank");
            System.exit(0);
        }
        
    }

    public boolean criarConta(Scanner sc,int tipo) {
        ContaBancaria contaBancaria;
        int numero;
        double saldo;

        switch(tipo) {
            case 1:
                // Conta Corrente
                System.out.print("Insira um número de Conta: ");
                numero = sc.nextInt();
                contaExiste(sc, numero, tipo);
                System.out.print("Insira um saldo: ");
                saldo = sc.nextDouble();
                System.out.print("Insira uma taxa de operação: ");
                double txOper = sc.nextDouble();
                contaBancaria = new ContaCorrente(numero, saldo, txOper);
                break;
            case 2:
                // Conta Poupanca
                System.out.print("Insira um número de Conta: ");
                numero = sc.nextInt();
                contaExiste(sc, numero, tipo);
                System.out.print("Insira um saldo: ");
                saldo = sc.nextDouble();
                System.out.print("Insira um limite: ");
                double limite = sc.nextDouble();
                contaBancaria = new ContaPoupanca(numero, saldo, limite);
                break;
            default:
                // Messagem de erro
                System.out.println();
                System.out.println("OPCAO INVALIDA!!!");
                System.out.println("Criação de conta não foi concluida!");
                return false;
        }

        inserir(contaBancaria);
        System.out.println(contaBancaria.toString());
        return true;
    }

    public void selecionarConta(Scanner sc) {
        System.out.println();
        System.out.print("Selecione o numero da conta: ");
        int numeroConta = sc.nextInt();
        operacaoConta(sc, numeroConta);
    }

    public void operacaoConta(Scanner sc, int numeroConta) {
        for (ContaBancaria contaBancariaOrigem : contas) {
            if(numeroConta - 1 == contaBancariaOrigem.getNumero()) {
                System.out.println();
                System.out.println("TIPOS DE OPERACOES:");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Transferir");
                System.out.println("4. Relatorio");
                System.out.println("5. Volta");

                System.out.println();
                System.out.print("Opcao: ");
                int operacao = sc.nextInt();
                tipoOperacao(sc, operacao, contaBancariaOrigem);
                outraOperação(sc);
            }
        }
        System.out.println();
        System.out.println("CONTA INEXISTENTE!");
        outraOperação(sc);
    }

    public void tipoOperacao(Scanner sc, int operacao, ContaBancaria contaBancariaOrigem){
        double valor;
        switch (operacao){
            case 1:
                System.out.println();
                System.out.print("Valor do deposito: ");
                valor = sc.nextDouble();
                contaBancariaOrigem.depositar(valor);
                break;
            case 2:
                System.out.println();
                System.out.print("Valor do saque: ");
                valor = sc.nextDouble();
                contaBancariaOrigem.sacar(valor);
                break;
            case 3:
                System.out.println();
                System.out.print("Conta Destino: ");
                int contaDestino = sc.nextInt();
                for (ContaBancaria contaBancariaDestino : contas) {
                    if(contaBancariaOrigem.getNumero() + 1 == contaDestino) {
                        System.out.println();
                        System.out.println("OPERACAO INVALIDA.");
                        System.out.println("VOCE NAO PODE FAZER UMA TRANSFERENCIA PRA SUA PROPRIA CONTA");
                        outraOperação(sc);
                    } else if(contaDestino == contaBancariaDestino.getNumero()) {
                        System.out.println();
                        System.out.print("Insira o valor da transferencia: ");
                        valor = sc.nextDouble();
                        contaBancariaOrigem.transferir(valor, contaBancariaDestino);
                        System.out.println();
                        contaBancariaOrigem.mostraDados();
                        contaBancariaDestino.mostraDados();
                        outraOperação(sc);
                    }
                }
                System.out.println();
                System.out.println("Conta " + contaDestino + " nao encontrada");
                break;
            case 4:
                contaBancariaOrigem.mostraDados();
                break;
            case 5:
                gerenciaConta(sc);
                break;
            default:
                System.out.println();
                System.out.println("OPERACAO INVALIDA!");
                System.out.println("TENTE NOVAMENTE.");
                selecionarConta(sc);
        }
    }

    public boolean removeConta(Scanner sc, int numeroConta) {
        for(ContaBancaria contaBancaria : contas) {
            if(contaBancaria.numero == numeroConta) {
                contas.remove(contaBancaria);
                System.out.println("Conta bancaria " + numeroConta + " removida.");
                return true;
            }
        }
        System.out.println("Conta bancaria " + numeroConta + " nao encontrada.");
        return false;
    }

    public void contaExiste(Scanner sc, int idConta, int tipo){
        for(ContaBancaria contaBancaria : contas) {
            if(contaBancaria.getNumero() == idConta){
                System.out.println("Conta existente. Tente novamente!");
                criarConta(sc, tipo);
            }
        }
    }

    public void inserir(ContaBancaria contaBancaria) {
        contas.add(contaBancaria);
    }

    @Override
    public void mostraDados() {
        Relatorio relatorio = new Relatorio();
        for(ContaBancaria contaBancaria : contas) {
            relatorio.gerarRelatorio(contaBancaria);
        }
    }
}