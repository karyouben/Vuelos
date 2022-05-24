package fp.vuelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasVuelos {

	private List<Vuelo> vuelos;
	
	public EstadisticasVuelos() {
		vuelos = new ArrayList<Vuelo>();
	}
	
	public EstadisticasVuelos(Stream<Vuelo> vuelos) {
		this.vuelos = vuelos.collect(Collectors.toList());	
	}
	
	public EstadisticasVuelos(Collection<Vuelo> vuelos) {
		this();
		this.vuelos.addAll(vuelos);	
	}
	
	public void agregarVuelo(Vuelo v) {
		vuelos.add(v);
	}
	
	public Map <String,Set<LocalDate>> getFechasPorDestino(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino,
						Collectors.mapping(v->v.getFechaSalida().toLocalDate(),
						Collectors.toSet())));
		
	}
	
	private Map<String,Long> contarVuelosPorDestino() {
		return vuelos.stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino,
						Collectors.counting()));
	}
	
	public String getDestinoConMasVuelos(){
		Map<String,Long> mAux =contarVuelosPorDestino();
		Comparator<Map.Entry<String,Long>> c =
				Comparator.comparing(Map.Entry::getValue);
		Comparator<Map.Entry<String,Long>> c2 =
				Map.Entry.comparingByValue();
		
		return mAux.entrySet().stream()
				.max(c)
				.get()
				.getKey();
		
	}
	
	public String getSegundoDestinoConMasVuelos(){
		Map<String,Long> mAux= contarVuelosPorDestino();
		Comparator<Map.Entry<String,Long>> c =
				Map.Entry.comparingByValue();
		return mAux.entrySet().stream()
				.sorted(c.reversed())
				.skip(1)
				.findFirst()
			//	.map(Map.Entry::getKey)
				.get()
				.getKey();
		
	}
	
	
}
