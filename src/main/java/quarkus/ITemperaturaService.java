package quarkus;

import java.util.List;
import java.util.Optional;

public interface ITemperaturaService {
    void addTemperatura(Temperatura t);
    List<Temperatura> obtenerTemperaturas();

    //uSO DE EXCEPCIONES
    Optional<Temperatura> sacarTemperatura(String ciudad);
    boolean isEmpty();
    int maxima = 0;
}
