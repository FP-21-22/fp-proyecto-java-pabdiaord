package fp.clinico.test;

import java.util.List;
import java.util.Map;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoBucles;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;




public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		
		EstudioClinico a = new EstudioClinicoBucles();
		EstudioClinico b =a.of("data/estudio_clinico.csv");
		System.out.println("\n #### Test lectura de fichero ####");
		System.out.println(b);
		
		System.out.println("\n #### Test numeroPacientes() ####");
		Integer numeroPacientes = b.numeroPacientes();
		System.out.println(String.format("Hay %d pacientes", numeroPacientes));
		
		System.out.println("\n #### Test estaPaciente() ####");
		Boolean esta = b.estaPaciente(PacienteEstudio.of("311306","Male",80.55,false,true,TipoResidencia.URBANA,83.34));
		System.out.println(esta);
		
		System.out.println("\n #### todosPacienteSonDelTipo(TipoResidencia tipo) ####");
		Boolean todosSon = b.todosPacienteSonDelTipo(TipoResidencia.RURAL);
		System.out.println(todosSon);
		
		System.out.println("\n #### existeAlgunPacienteDelTipo(TipoResidencia tipo) ####");
		Boolean existeAlguno = b.todosPacienteSonDelTipo(TipoResidencia.URBANA);
		System.out.println(existeAlguno);
		
		System.out.println("\n #### numeroPacientesFactorRiesgo() ####");
		Integer numeroRiesgo = b.numeroPacientesFactorRiesgo();
		System.out.println(String.format("Hay %d pacientes de riesgo", numeroRiesgo));
		
		System.out.println("\n #### edadMediaPacientesConFactorRiesgo() ####");
		Double edadMediaRiesgo = b.edadMediaPacientesConFactorRiesgo();
		System.out.println(String.format("La edad media de pacientes de riesgo es %d", edadMediaRiesgo));
		
		System.out.println("\n ####  filtraPacientesPorEdad(Double edad) ####");
		List<PacienteEstudio> filtroPorEdad = b.filtraPacientesPorEdad(20.);
		for(PacienteEstudio pe:filtroPorEdad) {
			System.out.println(pe);
		}
		
		System.out.println("\n ####  agruparPacientesEdadMayorQuePorGenero(Double edad) ####");
		Map<String, List<PacienteEstudio>> pacientesMayorQueGenero = b.agruparPacientesEdadMayorQuePorGenero(30.);
		for(String e:pacientesMayorQueGenero.keySet()) {
			System.out.println(e + "-->"+ pacientesMayorQueGenero.get(e));
		}
		/*for(Map.Entry<String, List<PacienteEstudio>> e:pacientesMayorQueGenero.entrySet()) {
			System.out.println(e.getKey()+"===>"+e.getValue());
		}*/
		
		System.out.println("\n #### numeroPacientesPorGenero() ####");
		Map<String, Long> numeroPorGenero = b.numeroPacientesPorGenero();
		System.out.println(numeroPorGenero);
		
		System.out.println("\n #### edadMediaPacientesPorPorGenero() ####");
		Map<String, Double> edadMediaGenero = b.edadMediaPacientesPorPorGenero();
		System.out.println(edadMediaGenero);
		
	/*
	 * Como le comenté por correo hay dos funciones que me salta un error que le madé por captura de pantalla. No he 
	 * conseguido arreglarlo y siguiendo lo que me dijo de verlo en clase y comentarselo en la entrega, le pongo este comentario.
	 * Se trata de las funciones edadMediaPacientesConFactorRiesgo() y numeroPacientesFactorRiesgo() que al hacer el test
	 * salta error. 
	 * Tambien al ejecutar agruparPacientesEdadMayorQuePorGenero sale vacío y no encuentro el problema. Creía que era por el tamaño
	 * horizontal de la consola, pero al imprimir los resultados con un bucle sigue sin salir.
	 * Lo vemos en clase y si es con una tutoria también.
	 */
	
	
	
	}
	
}

