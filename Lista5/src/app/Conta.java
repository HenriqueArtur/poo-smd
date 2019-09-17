package app;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	//Atributos
	int numero;
	double saldo;
	List<Operacao> listaOper;
	protected Cliente cliente;
	
	//Construtor
	Conta(int pNumero, double pSaldo, List<Operacao> pListaOper, Cliente pCliente){
		this.numero = pNumero;
		this.saldo = pSaldo;
		this.listaOper = pListaOper;
		this.cliente = pCliente;
	}
	
	Conta(int pNumero, double pSaldo, Cliente pCliente){
		this.numero = pNumero;
		this.saldo = pSaldo;
		this.numero = pNumero;
		this.cliente = pCliente;
		this.listaOper = new ArrayList<Operacao>();
	}
	
	//Métodos get
	int getNumero (){ return this.numero; }
	double getSaldo (){ return this.saldo; }
	Cliente getCliente (){ return this.cliente; }
	List<Operacao> getListaOper (){ return this.listaOper; }
	
	//Métodos set
	void setNumero (int pNumero){ this.numero = pNumero; }
	void setSaldo (double pSaldo){ this.saldo = pSaldo; }
	void setCliente (Cliente pCliente){ this.cliente = pCliente; }
	void setListaOper (List<Operacao> pListaOper){ this.listaOper = pListaOper; }
	
	//Demais Métodos
	String imprimeExtrato(){ return this.listaOper.toString(); }
	String imprimeExtrato(int N){
		String aux = "";
		for (int i = this.listaOper.size() - 1; i >=0; i--){
			aux += this.listaOper.get(i).toString() + " ";
			if(this.listaOper.size()-N == i) break;
		}
		return aux;
	}

	boolean sacar(Saque saque){
		if (saque.getValor() <= 0 || saque.getValor() > this.saldo) {
			return false;
		} else {
			listaOper.add(saque);
			this.saldo -= saque.getValor();
			return true;
		}
	}

	boolean depositar(Transferencia transferencia){
		if (transferencia.getValor() <= 0) {
			return false;
		} else {
			Saque saque = new Saque("Saque", transferencia.valor, transferencia.contaOrigem);
			transferencia.contaOrigem.sacar(saque);
			transferencia.contaOrigem.listaOper.add(transferencia);
			listaOper.add(transferencia);
			this.saldo += transferencia.getValor();
			return true;
		}
	}

	@Override
	public String toString() {
		return "[cliente=" + cliente.getNome() + ", listaOper=" + listaOper + ", numero=" + numero + ", saldo=" + saldo
				+ "]";
	}

}