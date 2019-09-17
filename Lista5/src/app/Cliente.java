package app;

public class Cliente {
	//Atributos
	int ID;
	String nome;
	
	//Construtor
	Cliente(int pID, String pNome){
		this.ID = pID;
		this.nome = pNome;
	}
	
	//Métodos get
	int getID (){ return this.ID; }
	String getNome (){ return this.nome; }
	
	//Métodos set
	void setID (int pID){ this.ID = pID; }	
	void setNome (String pNome){ this.nome = pNome; }
	
	//Override toString
	public String toString() { return this.ID + " " + this.nome; }
}