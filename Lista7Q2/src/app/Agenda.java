package app;

import java.util.List;

/**
 * Agenda
 */
public class Agenda {

    private List<Contato> contatos;

	public Agenda() {}

	public Agenda(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Agenda [contatos=" + contatos + "]";
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void addContato(Contato contato) {
        contatos.add(contato);
    }
    
    public void removeContato(Contato contato) {
        for(Contato cont : contatos) {
            if(contato == cont) {
                contatos.remove(contato);
                break;
            }
        }
    }
}