package br.com.triersistemas.solar.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

public class StringUtils {

    private StringUtils() {}

    public static String getRandomName() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Alexson");
        nomes.add("Ana");
        nomes.add("Murilo");
        nomes.add("Matias");
        nomes.add("Vinicius");
        nomes.add("Guilherme");
        nomes.add("João Paulo");
        nomes.add("Julio");
        nomes.add("Gabriel");
        nomes.add("Edward");
        var rd = new SplittableRandom();
        return nomes.get(rd.nextInt(0, nomes.size()));
    }

    public static String getRandomMedicine() {
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

    public static List<String> getRandomListMedicine() {
        List<String> listaRetorno = new ArrayList<>();
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
            listaRetorno.add(p);
            lista.remove(p);
        }
        return listaRetorno;
    }

    public static String extractNumbers(final String documento) {
        if (Objects.nonNull(documento)) {
            return documento.replaceAll("\\D+", "");
        }
        return "";
    }

    public static List<Integer> toListInteger(final String documento) {
        final var digitos = new ArrayList<Integer>();
        for (char item : extractNumbers(documento).toCharArray()) {
            digitos.add(Integer.parseInt(String.valueOf(item)));
        }
        return digitos;
    }

    public static String listToString(final List<Integer> digitos) {
        return digitos.stream()
                .map(Object::toString)
                .reduce("", (p, e) -> p + e);
    }
}
