package app;

public class Saque extends Operacao {

    public Conta contaOrigem;

    public Saque(String pTipo, double pValor, Conta contaOrigem) {
        super(pTipo, pValor);
        this.contaOrigem = contaOrigem;
    }

    @Override
    public String toString() {
        return "Saque [valor=" + valor + "]";
    }
}