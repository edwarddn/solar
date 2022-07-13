package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name = "produto")
@NoArgsConstructor
public class Produto {

    @Id
    private UUID id;
    private String nome;
    private BigDecimal valor;

    public Produto(final String nome, final BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.valor = valor;
    }

    public Produto(ProdutoModel model) {
        this.nome = model.getNome();
        this.valor = model.getValor();
    }

    public Produto editar(final String nome, final BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
        return this;
    }
}
