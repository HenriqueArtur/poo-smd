package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Contato
 */
public class Contato {

    private String nome;
    private String email;
    private List<Telefone> telefones;

    public Contato(String nome, String email, Telefone telefone) {
        this.nome = nome;
        this.email = email;
        this.telefones = new ArrayList<>();
        telefones.add(telefone);
    }

    public Contato(String nome, String email, List<Telefone> telefones) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
    }

    public Contato(String nome, List<Telefone> telefones) {
        this.nome = nome;
        this.telefones = telefones;
    }

    public Contato(String nome, Telefone telefone) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        telefones.add(telefone);
    }

    @Override
    public String toString() {
        return "Contato [email=" + email + ", nome=" + nome + ", telefones=" + telefones + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addTelefone(long numero) throws NumeroDeTelefonesExcedido {
        if(telefones.size() >= 4) {
            throw new NumeroDeTelefonesExcedido("Numero de telefones excedidos");
        }

        Telefone telefone = new Telefone(numero);

        telefones.add(telefone);
    }

    public void removeTelefone(long numero) throws NumeroNaoEncontrado {
        for(Telefone telefone : telefones) {
            if(telefone.getTelefone() == numero) {
                telefones.remove(telefone);
                break;
            }
        }
        throw new NumeroNaoEncontrado("Deu ruim!");
    }

}