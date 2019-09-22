package app;

/**
 * ContaCorrente
 */
public class ContaCorrente extends ContaBancaria {
    double txOper;

    public ContaCorrente(int numero, double saldo, double txOper) {
        this.numero = numero;
        this.saldo = saldo;
        this.txOper = txOper;
    }

    @Override
    boolean sacar(double valor){
        if(valor > (getSaldo() -this.txOper)){
            return false;
        } else {
            setSaldo(this.saldo - valor - txOper);
            return true;
        }   
    }

    @Override
    boolean depositar(double valor){
        setSaldo(this.saldo + valor - txOper);
        return true;
    }

    @Override
    public boolean transferir(double valor, ContaBancaria contaBancaria) {
        if(this.equals(contaBancaria)){
            return false;
        } else if(valor + this.txOper <= getSaldo()) {
            this.sacar(valor);
            contaBancaria.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [numero=" + numero + ", saldo=" + saldo + ", txOper=" + txOper + "]";
    }


    @Override
    public void mostraDados() {
        System.out.println("ContaPoupanca [numero=" + numero + ", saldo=" + saldo + ", txOper=" + txOper + "]");
    }
}