package app;

import java.util.ArrayList;
import java.util.List;

public class ContaEspecial extends Conta{
	double limiteExtra;
	
	ContaEspecial(int pNumero, double pSaldo, List<Operacao> pListaOper, Cliente pCliente, double pLimiteExtra){
		super(pNumero, pSaldo, pListaOper, pCliente);
		this.limiteExtra = pLimiteExtra;
	}

	ContaEspecial(int pNumero, double pSaldo, Cliente pCliente, double pLimiteExtra){
		super(pNumero, pSaldo, pCliente);
		this.limiteExtra = pLimiteExtra;
		this.listaOper = new ArrayList<Operacao>();
	}

	@Override
	boolean sacar(Saque saque){
		if (saque.getValor() <= -this.limiteExtra || saque.getValor() > this.saldo + this.limiteExtra) {
			return false;
		} else {
			this.saldo -= saque.getValor();
			listaOper.add(saque);
			return true;
		}
	}

	@Override
	public String toString() {
		return "[cliente=" + cliente.getNome() + ", listaOper=" + listaOper + ", numero=" + numero + ", saldo=" + saldo
		+ ", limiteExtra=" + limiteExtra + "]";
	}

	
}
