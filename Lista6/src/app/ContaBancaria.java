package app;

/**
 * ContaBancaria
 */
public abstract class ContaBancaria implements Imprimivel {
    int numero;
    double saldo;

    int getNumero() { return numero; }
    void setNumero(int numero) { this.numero = numero; }
    double getSaldo() { return saldo; }
    void setSaldo(double saldo) { this.saldo = saldo; }

    abstract boolean sacar(double valor);
    abstract boolean depositar(double valor);

    abstract boolean transferir(double valor, ContaBancaria contaBancaria);

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj != null && obj instanceof ContaBancaria && this.numero == ((ContaBancaria)obj).getNumero()) {
			return false;
		}
		return false;
    }
}