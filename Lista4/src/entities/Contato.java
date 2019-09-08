package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Contato
 */
public class Contato {

    private String nome;
    private String email;
    private List<Long> telefones;

    public Contato(String nome, String email, Long telefone) {
        this.nome = nome;
        this.email = email;
        this.telefones = new ArrayList<>();
        telefones.add(telefone);
    }

    public Contato(String nome, String email, List<Long> telefones) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
    }

    public Contato(String nome, List<Long> telefones) {
        this.nome = nome;
        this.telefones = telefones;
    }

    public Contato(String nome, Long telefone) {
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

    public void addTelefone(Long numero) {
        telefones.add(numero);
    }

    public void removeTelefone(Long numero) {
        for(Long telefone : telefones) {
            if(telefone == numero) {
                telefones.remove(numero);
                break;
            }
        }
    }

}