package fp.vuelos;

import java.time.LocalDateTime;

public interface Vuelo extends Comparable<Vuelo>{

	LocalDateTime getFechaSalida();

	void setFechaSalida(LocalDateTime fechaSalida);

	Integer getNumeroPasajeros();

	void setNumeroPasajeros(Integer numeroPasajeros);

	String getCodigo();

	String getOrigen();

	String getDestino();

	Integer getNumeroPlazas();
	
	Boolean estaCompleto();

}