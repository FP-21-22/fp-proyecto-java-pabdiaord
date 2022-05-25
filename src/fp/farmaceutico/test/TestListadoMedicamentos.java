package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.ListadoMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;



public class TestListadoMedicamentos {

	public static void main(String[] args) {
		
		String rutaFichero = "data/medicamentos.csv";
		ListadoMedicamentos med = new ListadoMedicamentos(FactoriaMedicamentos.leerMedicamentos2(rutaFichero));
		System.out.println("\n #### Test lectura fichero ####");
		for(Medicamento e:med.getMedicamentos()) {
			System.out.println(e);
		}
		System.out.println(med.getMedicamentos().size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de existeMedicamentoSegunTipoAnteriorA() ####");
		System.out.println(med.existeMedicamentoSegunTipoAnteriorA(TipoMedicamento.ANATOMICO, LocalDate.of(2019, 12, 05)));//04/12/2019
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de nombreMedicamentosPuntuacionMayorA() ####");
		for(String e:med.nombreMedicamentosPuntuacionMayorA(90.)) {
			System.out.println(e);
		}
		System.out.println(med.nombreMedicamentosPuntuacionMayorA(90.).size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento() ####");
		System.out.println(med.nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento.QUIMICO));
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de agrupaTipoMedicamentoSegunPuntuacionMedia() ####");
		System.out.println(med.agrupaTipoMedicamentoSegunPuntuacionMedia().entrySet());
		System.out.println(med.agrupaTipoMedicamentoSegunPuntuacionMedia().size());
		
		System.out.println("\n =======================");
		
		System.out.println("\n #### Test de fechaCatalogoMasFrecuente() ####");
		System.out.println(med.fechaCatalogoMasFrecuente());
		System.out.println("\n =======================");

	}
	
	

}
