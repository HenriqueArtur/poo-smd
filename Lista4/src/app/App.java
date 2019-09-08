package app;

import java.util.ArrayList;
import java.util.List;

import entities.Agenda;
import entities.Contato;

public class App {
    public static void main(String[] args) throws Exception {
        List<Contato> contatos = new ArrayList<>();
        Contato sarah = new Contato("Sarah", "sarahisabell@gmail.com", 996101010l);
        contatos.add(sarah);
        Contato ze = new Contato("José Monteiro", "zemonteiro@gmail.com", 996202020l);
        contatos.add(ze);
        Contato alexandre = new Contato("Alexandre", "alexandre@gmail.com", 996303030l);
        contatos.add(alexandre);

        Agenda agenda = new Agenda(contatos);

        System.out.println(agenda.toString());
    }
}