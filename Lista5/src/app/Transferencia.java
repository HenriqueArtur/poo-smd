package app;

public class Transferencia extends Operacao {
    public Conta contaOrigem;
    public Conta contaDestino;

    public Transferencia(String pTipo, double pValor, Conta contaOrigem, Conta contaDestino) {
        super(pTipo, pValor);
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transferencia [valor=" +  valor + ", contaDestino=" + contaDestino.getCliente().getNome() + ", contaOrigem=" + contaOrigem.getCliente().getNome() + "]";
    }
    
    
}