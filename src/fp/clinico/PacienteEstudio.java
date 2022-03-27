package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension,
		Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) implements Comparable<PacienteEstudio>{
	
	//redefinimos el constructor para las restricciones
	public PacienteEstudio{
		Checkers.check("edad mayor o igual que cero y menor que 130", edad >=0 && edad <=130);
		Checkers.check("nivelMedioGlucosa tiene que ser mayor o igual que cero", nivelMedioGlucosa >=0);
	}
	
	//Metodos derivados
	public Boolean factorDeRiesgo() {
		Boolean res = null;
		if(this.hipertension==true && this.edad > 40) {
			res = true;
		}
		else {
			res = false;
		}
		return res;
	}

	
	
	//Representación como cadena
	@Override
	public String toString() {
		return "PacienteEstudio [id=" + id + ", edad=" + edad + "]";
		

	}

	
	
	//Criterio de igualdad: por defecto asociado al record
	
	//Criterio de orden
	
	@Override
	public int compareTo(PacienteEstudio o) {
		Integer res = this.edad().compareTo(o.edad());
		if(res==0) {
			res = this.id().compareTo(o.id());
		}
		return res;
		
	}
	
	
	//Factorias
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension,
		Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) {
		return new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
	}
	
	public static PacienteEstudio parse(String cadena){
		String[] partes = cadena.split(";");
		String i = partes[0].trim();
		String gen = partes[1].trim();
		Double ed = Double.parseDouble(partes[2].trim());
		Boolean hiper = esBooleano(partes[3].trim());
		Boolean enf = esBooleano(partes[4].trim());
		TipoResidencia tip = tipo(partes[5].trim());
		Double niv = Double.parseDouble(partes[6].trim());
		return PacienteEstudio.of(i, gen, ed, hiper, enf, tip, niv);
		
		
		
		
	}
	//metodos de ayuda para parse
	private static Boolean esBooleano(String cadena) {
		Boolean res = null;
		if(cadena=="true") {
			res=true;
		}
		else if(cadena=="false") {
			res=false;
		}
		return res;
	}
	private static TipoResidencia tipo(String cadena) {
		TipoResidencia res=null;
		if(cadena=="RURAL") {
			res = TipoResidencia.RURAL;
		}
		else if(cadena=="URBANA") {
			res = TipoResidencia.URBANA;
		}
		return res;
	}
	
	public static void main(String[] args) {
		PacienteEstudio pe = PacienteEstudio.of("1200", "Female", 45., true, true, TipoResidencia.RURAL, 76.44);
		PacienteEstudio pe2 = PacienteEstudio.parse("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(pe);
		System.out.println(pe.factorDeRiesgo());
		System.out.println(pe2);
		System.out.println(pe.tipoResidencia());
		System.out.println(pe2.tipoResidencia());
		System.out.println(pe2.hipertension());
	}
	
	/*
	 * al ejecutar el main en pe2.tipoResidencia() y pe2.hipertension() debe de haber un pequeño error 
	 * pues no sale lo que deberia de salir, pero no consigo ver la causa de que salga null
	 *  Coinciden con llamadas al objeto creeado por la factoria
	 */
	


}
