package fp.vuelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class VueloImpl implements Vuelo {
	private String codigo;
	private String origen;
	private String destino;
	private LocalDateTime fechaSalida;
	private Integer numeroPlazas;
	private Integer numeroPasajeros;

	public VueloImpl(String codigo, String origen, String destino, LocalDateTime fechaSalida, Integer numeroPlazas,
			Integer numeroPasajeros) {
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		Checkers.check("El número de pasajeros debe ser menor o igual al de plazas", numeroPasajeros<=numeroPlazas);
		this.numeroPlazas = numeroPlazas;
		this.numeroPasajeros = numeroPasajeros;
	}
	
	public VueloImpl(String codigo, String origen, String destino, LocalDateTime fechaSalida, Integer numeroPlazas) {
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.numeroPlazas = numeroPlazas;
		this.numeroPasajeros = 0;
	}

	@Override
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	@Override
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public Integer getNumeroPasajeros() {
		return numeroPasajeros;
	}

	@Override
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		Checkers.check("El número de pasajeros debe ser menor o igual al número de plazas", numeroPasajeros<=getNumeroPlazas());
		this.numeroPasajeros = numeroPasajeros;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String getOrigen() {
		return origen;
	}

	@Override
	public String getDestino() {
		return destino;
	}

	@Override
	public Integer getNumeroPlazas() {
		return numeroPlazas;
	}
	
	@Override
	public Boolean estaCompleto() {
		return getNumeroPlazas().equals(getNumeroPasajeros());
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof VueloImpl))
			return false;
		VueloImpl other = (VueloImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		return true;
	}

	public String toString() {
		String strFecha = getFechaSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		return String.format("(%s) %s-%s %s", getCodigo(), getOrigen(), getDestino(), strFecha);
	}
	
	@Override
	public int compareTo(Vuelo v) {
		int res = getCodigo().compareTo(v.getCodigo());
		if (res == 0) {
			res= getOrigen().compareTo(v.getOrigen());
			if (res == 0) {
				res = getDestino().compareTo(v.getDestino());
				if (res== 0) {
					res = getFechaSalida().compareTo(v.getFechaSalida());
				}
			}
		}
		return res;
	}
	

}
