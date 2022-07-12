package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Farmaceutico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class FarmaceuticoModel {

    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String nome;

    @NotNull
    private LocalDate aniver;

    @NotNull
    @NotBlank
    private String cpf;

    private String promocaoDia;

    private Long idade;

    private String documento;

    private Boolean documentoValido;

    public FarmaceuticoModel(Farmaceutico farmaceutico) {
        this.id = farmaceutico.getId();
        this.nome = farmaceutico.getNome();
        this.aniver = farmaceutico.getAniver();
        this.cpf = farmaceutico.getDocumento();
        this.promocaoDia = farmaceutico.getPromocaoDia();

        this.idade = farmaceutico.getIdade();
        this.documento = this.cpf;
        this.documentoValido = farmaceutico.getDocumentoValido();
    }
}
