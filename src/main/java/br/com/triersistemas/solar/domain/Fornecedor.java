package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.helper.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedor")
@Getter
public class Fornecedor extends PessoaJuridica {

    @ManyToMany
    @JoinTable(
            name = "fornecedor_produto",
            joinColumns = @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id")
    )
    private List<Produto> produtos;

    public Fornecedor() {
        this.produtos = new ArrayList<>();
    }

    public Fornecedor(final String nome, final LocalDate aniver, final String cnpj) {
        super(nome, aniver, cnpj);
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
