package app;

/**
 * PFisica
 */
public class PFisica extends Contribuinte {
    private static int cont = 1;
    private final long cpf;
    private final int indetificador;

    public PFisica(String nome, double rendaBruta, long cpf) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
        this.cpf = cpf;
        this.indetificador = cont++;
    }

    /**
     * @return the indetificador
     */
    public int getIndetificador() {
        return indetificador;
    }

    @Override
    public double calcularImposto() {
        if(this.rendaBruta >= 0.00 && this.rendaBruta <= 1400.00){
            return 0.00;
        } else if(this.rendaBruta > 1400.00 && this.rendaBruta <= 2100.00) {
            return this.rendaBruta * 0.1;
        } else if(this.rendaBruta > 2100.00 && this.rendaBruta <= 2800.00) {
            return this.rendaBruta * 0.15;
        } else if(this.rendaBruta > 2800.00 && this.rendaBruta <= 3600.00) {
            return this.rendaBruta * 0.25;
        } else {
            return this.rendaBruta * 0.3;
        }
    }
    
}