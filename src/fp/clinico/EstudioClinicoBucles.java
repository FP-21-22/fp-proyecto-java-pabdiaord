package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class EstudioClinicoBucles implements EstudioClinico {
	private List<PacienteEstudio> pacientes;
	
	//C2: construye el tipo EstudioClinicoBucles a partir de una lista de objetos del tipo PacienteEstudio como parámetro 
	public EstudioClinicoBucles(List<PacienteEstudio> pacientes) {
		super();
		this.pacientes = pacientes;
	}
	//C1: construye el tipo EstudioClinicoBucles creando lista sin elementos
	public EstudioClinicoBucles() {
		super();
		this.pacientes = new ArrayList<>();
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
		// Auto-generated method stub
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
		this.pacientes.clear();;
	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		// Auto-generated method stub
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
	}
	
	public static PacienteEstudio parseaLinea(String cadena){
		return PacienteEstudio.parse(cadena);
	}
	
		

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		//  Auto-generated method stub
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
		// Auto-generated method stub
		Boolean res = true;
		for(PacienteEstudio p:this.pacientes) {
			if(!(p.tipoResidencia()==tipo)) {
				res=false;
				
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		System.out.println("->"+ this.pacientes.size()+"<-");
		Boolean res = false;
		for(PacienteEstudio p:this.pacientes) {
			if(p.tipoResidencia()==tipo) {
				res=true;
				
			}
		}
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Integer res = 0;
		for(PacienteEstudio p:this.pacientes) {
			if(p.factorDeRiesgo().equals(true)) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// Auto-generated method stub
		Double suma = 0.;
		Integer cont=0;
		for(PacienteEstudio p:this.pacientes) {
			if(p.factorDeRiesgo().equals(true)) {
				suma+=p.edad();
			}
			cont++;
		}
		return suma/cont;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// Auto-generated method stub
		List<PacienteEstudio> res = new ArrayList<>();
		for(PacienteEstudio p:this.pacientes) {
			if(p.edad().equals(edad)) {
				res.add(p);
			}
		}
		return res;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//Auto-generated method stub  ver lo de paciente
		Map<String, List<PacienteEstudio>> res = new HashMap<String, List<PacienteEstudio>>();
		for(PacienteEstudio p:this.pacientes) {
			String clave = p.genero();
			if(p.edad() > edad){
				if(!res.containsKey(clave)) {
					List<PacienteEstudio> listaAux = new ArrayList<PacienteEstudio>();
					listaAux.add(p);
					res.put(clave, listaAux);
				}else {
					res.get(clave).add(p);
				}
				
				
			}
		}
		return res;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// Auto-generated method stub
		Map<String, Long> res = new HashMap<String, Long>();
		for(PacienteEstudio p:this.pacientes) {
			String clave = p.genero();
			if(!res.containsKey(clave)) {
				//primera vez, inicializa la veriable que cuenta
				res.put(clave, (long) 1);
				
			}else {
				//actualizando, incrementa el contador
				res.put(clave, res.get(clave) + 1);
			}
		}
		return res;
		
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// Auto-generated method stub
		Map<String, Double> res = new HashMap<String, Double>();
		for(PacienteEstudio p:this.pacientes) {
			String clave = p.genero();
			Double edadHombres=0.;
			Double edadMujeres=0.;
			Integer contHombres=0;
			Integer contMujeres=0;
			if(p.genero()=="Female") {
				edadMujeres+=p.edad();
				contMujeres++;
				Double mediaMujeres = edadMujeres/contMujeres;
				res.put(clave, mediaMujeres);
			}else {
				edadHombres+=p.edad();
				contHombres++;
				Double mediaHombres = edadHombres/contHombres;
				res.put(clave, mediaHombres);
			}
			
		}
		return res;
	}

}
