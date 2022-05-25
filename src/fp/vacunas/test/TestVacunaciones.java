package fp.vacunas.test;

import java.time.LocalDate;
import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;
import fp.vacunas.Vacunaciones;




public class TestVacunaciones {

	public static void main(String[] args) {
		String rutaFichero = "data/ccaa_vacunas_3.csv";
		Vacunaciones vacuna = new Vacunaciones(FactoriaVacunaciones.leerVacunaciones2(rutaFichero));
		System.out.println("\n #### Test lectura fichero ####");
		for(Vacunacion e:vacuna.getVacunaciones()) {
			System.out.println(e);
		}
		System.out.println(vacuna.getVacunaciones().size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de vacunacionesEntreFechas() ####");
		for(Vacunacion e:vacuna.vacunacionesEntreFechas(LocalDate.of(2021, 01, 04), LocalDate.of(2021, 02, 01))){
			System.out.println(e);
		}
		System.out.println(vacuna.vacunacionesEntreFechas(LocalDate.of(2021, 01, 04), LocalDate.of(2021, 02, 01)).size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de existeNumPersonasPautaCompletaPorEncimaDe() ####");
		System.out.println(vacuna.existeNumPersonasPautaCompletaPorEncimaDe("Castilla y Leon", 10));
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de diaMasVacunacionesEn() ####");
		System.out.println(vacuna.diaMasVacunacionesEn("Castilla y Leon"));
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de vacunacionesPorFecha() ####");
		System.out.println(vacuna.vacunacionesPorFecha().size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de maximoNumTotalVacunasporComunidad() ####");
		System.out.println(vacuna.maximoNumTotalVacunasporComunidad());
		
		System.out.println("\n =======================");
		
		

	}
	
}


