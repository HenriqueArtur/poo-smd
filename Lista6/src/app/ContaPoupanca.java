package app;

/**
 * ContaPoupanca
 */
public class ContaPoupanca extends ContaBancaria {
    double limite;

    public ContaPoupanca(int numero, double saldo, double limite) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }

    @Override
    boolean sacar(double valor){
        if(valor > getSaldo() + this.limite) {
            return false;
        } else {
            setSaldo(this.saldo - valor);
            return true;
        }   
    }

    @Override
    boolean depositar(double valor){
        setSaldo(this.saldo + valor);
        return true;
    }

    @Override
    public boolean transferir(double valor, ContaBancaria contaBancaria) {
        if(this.equals(contaBancaria)){
            return false;
        } else if(valor <= getSaldo() + this.limite) {
            this.sacar(valor);
            contaBancaria.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [numero=" + this.numero + ", saldo=" + this.saldo + ", limite=" + this.limite + "]";
    }
    
    @Override
    public void mostraDados() {
        System.out.println( "ContaPoupanca [numero=" + this.numero + ", saldo=" + this.saldo + ", limite=" + this.limite + "]");
    }
}