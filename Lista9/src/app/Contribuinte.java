package app;

/**
 * Contribuinte
 */
public abstract class Contribuinte {

    public String nome;
    public double rendaBruta;

    public abstract double calcularImposto();
}