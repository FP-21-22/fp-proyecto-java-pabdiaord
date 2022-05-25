package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class ListadoMedicamentos {
	private List<Medicamento> medicamentos;
	
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public ListadoMedicamentos(Stream<Medicamento> st) {
		this.medicamentos =  st.collect(Collectors.toList());
	}
	
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipo, LocalDate fecha) {
		return this.medicamentos.stream().filter(x->x.getTipoMedicamento().equals(tipo)).anyMatch(x->x.getFechaCatalogo().isBefore(fecha));
		
	}
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion){
		return this.medicamentos.stream().filter(x->x.getPuntuacion() > puntuacion)
				.map(Medicamento::getNombreMedicamento)
				.collect(Collectors.toSet());
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipo) {
		Medicamento aux = this.medicamentos.stream().filter(x->x.getTipoMedicamento().equals(tipo))
				.max(Comparator.comparing(Medicamento::getIndiceSomatico)).get();
		return aux.getNombreMedicamento();
	}
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
		return this.medicamentos.stream().collect(Collectors.groupingBy(
				Medicamento::getTipoMedicamento, 
				Collectors.averagingDouble(Medicamento::getPuntuacion)
				));
	}
	
	public LocalDate fechaCatalogoMasFrecuente(){
		Map<LocalDate, Long> mapaAux = this.medicamentos.stream()
				.collect(Collectors.groupingBy(
						Medicamento::getFechaCatalogo, 
						Collectors.counting()));
		Comparator<Map.Entry<LocalDate, Long>> cmp = (x,y)->x.getValue().compareTo(y.getValue());
		return mapaAux.entrySet().stream().max(cmp).get().getKey();
	}
}
