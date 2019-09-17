package app;

public class Operacao {
	//Atributos
	String tipo;
	double valor;
	
	//Construtor
	Operacao(String pTipo, double pValor){
		this.tipo = pTipo;
		this.valor = pValor;
	}
	
	//Métodos get
	String getTipo (){ return this.tipo; }
	double getValor (){ return this.valor; }
	
	//Métodos set
	void setTipo (String pTipo){ this.tipo = pTipo; }
	void setValor (double pValor){ this.valor = pValor; }

	//Override toString
	@Override
	public String toString() {
		return "Operacao [tipo=" + tipo + ", valor=" + valor + "]";
	}
	
}