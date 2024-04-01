package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class KnihaSluzba {
    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKeKniham = Path.of("src/resources/cz.czechitas.ukol07/knihy.json");
    List<Kniha> seznamKnih;
    private InputStream inputStream;
    public KnihaSluzba() throws IOException {
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("/cz/czechitas/ukol07/knihy.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            seznamKnih = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {});
        }
    }

    public List<String> vratVsechnyKnihy() {
        //která vrátí seznam všech knih
        Stream<Kniha> streamKnih = seznamKnih.stream();
        Stream<String>  streamNazvuKnih = streamKnih.map(Kniha::getNazev);
        return streamNazvuKnih.toList();
    }

    public List<String> vratKnihyAutora(String autor) {
        //vrátí seznam všech knih od zadaného autora, seznam může být prázdný
        Stream<Kniha> streamKnih = seznamKnih.stream();
        streamKnih = streamKnih.filter(kniha -> kniha.getAutor().equals(autor));
        Stream<String>  streamNazvuKnih = streamKnih.map(Kniha::getNazev);
        return streamNazvuKnih.toList();
    }

    public List<List> vratKnihyRok(Integer rokVydani) {
        //vrátí seznam všech knih vydaných v zadaném roce, seznam může být prázdný.
        Stream<Kniha> streamKnih = seznamKnih.stream();
        streamKnih = streamKnih.filter(kniha -> kniha.getRokVydani().equals(rokVydani));
        Stream<List>  streamUdajuOKnihe = streamKnih.map(kniha -> {
            List<String> udajeOKnihe = new ArrayList<>();
            udajeOKnihe.add(kniha.getNazev());
            udajeOKnihe.add(kniha.getAutor());
            return udajeOKnihe;
        });
        return streamUdajuOKnihe.toList();
    }
}