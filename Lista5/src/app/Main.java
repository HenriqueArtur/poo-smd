package app;

public class Main {
	public static void main (String[] args) throws Exception {
		Cliente tici = new Cliente(360, "Ticiana");
		System.out.println(tici.getNome());
		// Ex. 1
		Conta ticiConta = new ContaEspecial(1331, 18000.00, tici, 1000);
		// Ex. 2
		System.out.println(ticiConta.toString());
		// Ex. 3, Ex. 6
		Cliente henrique = new Cliente(361, "Henrique");
		Conta henriqueConta = new Conta(1332, 256.00, henrique);
		System.out.println(henriqueConta.toString());
		Transferencia transferencia = new Transferencia("transferencia", 500.00, ticiConta, henriqueConta);
		// Ex. 5
		henriqueConta.depositar(transferencia);
		// Ex. 4, Ex. 7
		System.out.println(ticiConta.toString());
		System.out.println(henriqueConta.toString());

	}
}
