package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.helper.StringUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Pessoa {

    private UUID id;
    private String nome;
    private LocalDate aniver;

    protected Pessoa() {
        this.id = UUID.randomUUID();
        this.aniver = LocalDate.now();
        this.nome = StringUtils.getRandomName();
    }

    protected Pessoa(final String nome, final LocalDate aniver) {
        this();
        this.nome = nome;
        this.aniver = aniver;
    }

    protected Pessoa editar(final String nome, final LocalDate aniver) {
        this.nome = nome;
        this.aniver = aniver;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAniver() {
        if (Objects.nonNull(this.aniver)) {
            return this.aniver.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }

    public Long getIdade() {
        return Objects.nonNull(this.aniver) ? ChronoUnit.YEARS.between(this.aniver, LocalDate.now()) : 0L;
    }

    public abstract String getDocumento();

    public abstract Boolean getDocumentoValido();

    protected List<Integer> geraDocumento(final int tamanho) {
        var rd = new SplittableRandom();
        List<Integer> digitos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            digitos.add(rd.nextInt(0, 10));
        }
        return digitos;
    }

    protected int mod11(final List<Integer> digitos, final int... multiplicadores) {
        /*
        int soma = 0;
        for (int i = 0; i < multiplicadores.length; i++) {
            soma += digitos.get(i) * multiplicadores[i];
        }
        int resto = soma % 11;
        return resto > 9 ? 0 : resto;
        */
        final AtomicInteger i = new AtomicInteger(0);
        int resto = digitos.stream()
                .reduce(0, (p, e) -> p + e * multiplicadores[i.getAndIncrement()]) % 11;
        return resto > 9 ? 0 : resto;
    }


}
