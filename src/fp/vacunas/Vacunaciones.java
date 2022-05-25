package fp.vacunas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class Vacunaciones {
	private List<Vacunacion> vacunaciones;
	
	public List<Vacunacion> getVacunaciones() {
		return vacunaciones;
	}

	public Vacunaciones(Stream<Vacunacion> st) {
		this.vacunaciones = st.collect(Collectors.toList());
	}
	
	public void anyadeVacunacion(Vacunacion vac) {
		this.vacunaciones.add(vac);
	}
	
	public  List<Vacunacion> vacunacionesEntreFechas(LocalDate fechaIncial, LocalDate fechaFinal){
		return this.vacunaciones.stream()
				.filter(x-> x.fecha().isAfter(fechaIncial) && x.fecha().isBefore(fechaFinal))
				.collect(Collectors.toList());
		
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer n) {
		//TODO
		return this.vacunaciones.stream().filter(x->x.comunidad().equals(comunidad)).anyMatch(x->x.numeroPersonas()>n);
		
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		Vacunacion aux= this.vacunaciones.stream().filter(x->x.comunidad().equals(comunidad)).max(Comparator.comparing(Vacunacion::numeroTotal)).orElse(null);
		return aux.fecha();
		
	}
	
	public Map<LocalDate,List<Vacunacion>> vacunacionesPorFecha(){
		return this.vacunaciones.stream().collect(Collectors.groupingBy(Vacunacion::fecha));
	}
	
	public Map<String, Integer> maximoNumTotalVacunasporComunidad(){
		return this.vacunaciones.stream()
				.collect(Collectors.groupingBy(
						Vacunacion::comunidad, 
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Vacunacion::numeroTotal)), 
								x->x.get().numeroPersonas())
						));
	}
	

}
