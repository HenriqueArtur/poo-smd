package app;

/**
 * PJuridica
 */
public class PJuridica extends Contribuinte {
    public final long cnpj;

    public PJuridica(String nome, double rendaBruta, long cnpj) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
        this.cnpj = cnpj;
    }

    @Override
    public double calcularImposto() {
        return this.rendaBruta * 0.1;
    }
    
}