package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoStream implements EstudioClinico {
protected List<PacienteEstudio> pacientes;
	
	//C2: construye el tipo EstudioClinicoStream a partir de una lista de objetos del tipo PacienteEstudio como parámetro 
	public EstudioClinicoStream(List<PacienteEstudio> pacientes) {
		super();
		this.pacientes = pacientes;
	}
	//C1: construye el tipo EstudioClinicoStream creando lista sin elementos
	public EstudioClinicoStream() {
		super();
		this.pacientes = new ArrayList<>();
	}
	//C3:para la ampliacion
	public EstudioClinicoStream(Stream<PacienteEstudio> st) {
		this.pacientes=st.collect(Collectors.toList());
	}

	
	
	
	@Override
	public String toString() {
		String a ="";
		for(PacienteEstudio c:this.pacientes) {
			a = a + c + "\n";
		}
		return a;
	}

	

	

	@Override
	public Integer numeroPacientes() {
		//  Auto-generated method stub
		return this.pacientes.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		// Auto-generated method stub
		this.pacientes.add(paciente);
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		// Auto-generated method stub
		this.pacientes.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		// Auto-generated method stub
		this.pacientes.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		// Auto-generated method stub
		return this.pacientes.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		// Auto-generated method stub
		this.pacientes.removeAll(pacientes);
	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		
		return new EstudioClinicoStream(this.leeFichero(nombreFichero));
	}
	
	public static PacienteEstudio parseaLinea(String cadena){
		return PacienteEstudio.parse(cadena);
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		}catch(IOException e){
			e.printStackTrace();
		}
		//Hay que saltarse la primera linea
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				PacienteEstudio v = EstudioClinicoBucles.parseaLinea(e);
				res.add(v);
			}
			cont++;
		}
		return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		
		return this.pacientes.stream().allMatch(x->x.tipoResidencia()==tipo);
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		
		return this.pacientes.stream().anyMatch(x->x.tipoResidencia()==tipo);
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Long aux = this.pacientes.stream().filter(x->x.factorDeRiesgo().equals(true)).count();
		return aux.intValue();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		
		return this.pacientes.stream().filter(x->x.factorDeRiesgo().equals(true)).mapToDouble(x->x.edad()).average().orElse(0);
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		
		return this.pacientes.stream().filter(x->x.edad().equals(edad)).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		
		return this.pacientes.stream().filter(x->x.edad()>edad).collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		
		return this.pacientes.stream().collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.counting()));
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// 
		return this.pacientes.stream()
				.collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.averagingDouble(PacienteEstudio::edad)
						));
	}

}
