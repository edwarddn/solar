package br.com.triersistemas.solar.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Farmaceutico extends PessoaFisica {

    private String promocaoDia;

    public Farmaceutico() {
        this.promocaoDia = gerarPromocaoDia();
    }

    public Farmaceutico(final String nome, final LocalDate aniver, final String cpf) {
        super(nome, aniver, cpf);
        this.promocaoDia = gerarPromocaoDia();
    }

    private String gerarPromocaoDia() {
        List<String> lista = new ArrayList<>();
        lista.add("Dramin");
        lista.add("Nivea For Man");
        lista.add("Eno");
        lista.add("Rivotril");
        lista.add("Valium");
        lista.add("Dipirona");
        lista.add("Ibulprofeno");
        lista.add("Paracetamol");
        lista.add("Gardenal");
        lista.add("Benegripe");
        var rd = new SplittableRandom();
        return lista.get(rd.nextInt(0, lista.size()));
    }

    public String getPromocaoDia() {
        return promocaoDia;
    }
}
