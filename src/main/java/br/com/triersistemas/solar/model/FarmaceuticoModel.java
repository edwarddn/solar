package br.com.triersistemas.solar.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class FarmaceuticoModel {

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String nome;

    @NotNull
    private LocalDate aniver;

    @NotNull
    @NotBlank
    private String cpf;
}
