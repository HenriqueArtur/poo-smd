package app;

/**
 * Conta
 */
public abstract class Conta {

    public int id;
    public double saldo;

    public abstract void credito(double valor);
    public abstract void debito(double valor);
    public double consultarSaldo(){
        return this.saldo;
    }
}