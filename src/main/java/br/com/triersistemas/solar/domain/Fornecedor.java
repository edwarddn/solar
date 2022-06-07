package br.com.triersistemas.solar.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Fornecedor extends PessoaJuridica {

    private List<String> produtos;

    public Fornecedor() {
        this.geraListaProdutos();
    }

    public Fornecedor(final String nome, final LocalDate aniver, final String cnpj) {
        super(nome, aniver, cnpj);
        this.geraListaProdutos();
    }

    private void geraListaProdutos() {
        this.produtos = new ArrayList<>();
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

        for (int i = 0; i < rd.nextInt(2, lista.size()); i++) {
            var p = lista.get(rd.nextInt(0, lista.size()));
            this.produtos.add(p);
            lista.remove(p);
        }
    }

    public List<String> getProdutos() {
        return produtos;
    }
}
