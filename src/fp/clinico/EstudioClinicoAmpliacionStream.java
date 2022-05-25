package fp.clinico;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoAmpliacionStream extends EstudioClinicoStream implements EstudioClinicoAmpliacion {
	//Atributos
	//protected List<PacienteEstudio> pacientes;
	/*
	 * Nota: en la clase EstudioClinicoStream debe cambiar el atributo pacientes de private a protected. De esta
forma es visible en la clase hija � la clase EstudioClinicoAmpliacionStream � y puede llamarlo a trav�s de la
cl�usula super, como podemos ver en el c�digo de arriba. 
	 */
	//Constructores
	public EstudioClinicoAmpliacionStream() {
		super();
	}
	public EstudioClinicoAmpliacionStream(List<PacienteEstudio> lista) {
		super(lista);
	}
	public EstudioClinicoAmpliacionStream(Stream<PacienteEstudio> st) {
		super(st);
	}
	
	//Metodos
	@Override
	public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
		// 
		return super.pacientes.stream().collect(Collectors.groupingBy(
				PacienteEstudio::tipoResidencia, 
				Collectors.collectingAndThen(Collectors.counting(), x->x.intValue())
				));
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		// 
		return super.pacientes.stream().collect(Collectors.groupingBy(
				PacienteEstudio::tipoResidencia, 
				Collectors.averagingDouble(PacienteEstudio::nivelMedioGlucosa)
				));
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		// tener en cuenta lo del optional al devolver
		return super.pacientes.stream().collect(Collectors.groupingBy(
				PacienteEstudio::tipoResidencia, 
				Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(PacienteEstudio::nivelMedioGlucosa)), 
						x->x.get())
				));
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		//
		return super.pacientes.stream().collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto() {
		// TODO Auto-generated method stub
		return super.pacientes.stream().collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.toSet()));
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
