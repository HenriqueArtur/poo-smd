package app;

/**
 * Teste
 */
public class Teste {

    Teste(){}

    public void testePJuridica() {
        PJuridica pJuridica = new PJuridica("Joaozinho", 150000.00, 00125340L);

        System.out.println("Imposto pessoa juridica: " + pJuridica.calcularImposto());
    }

}