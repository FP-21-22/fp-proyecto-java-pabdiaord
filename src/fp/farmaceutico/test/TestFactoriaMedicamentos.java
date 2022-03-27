package fp.farmaceutico.test;

import java.time.LocalDate;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		
		Medicamento m = FactoriaMedicamentos.parseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		Medicamento m1 = new Medicamento("efavirenz", TipoMedicamento.QUIMICO, "Y22YE4", "Actavis Mid Atlantic LLC", 89.0, 1877, LocalDate.of(2020, 11, 12));
		System.out.println(m);
		System.out.println(m.getTipoMedicamento());
		System.out.println(m.tratarEnfermedad("Y22YE4"));
		System.out.println(m.tratarEnfermedad("Y212XXA"));
		System.out.println(m1);
		System.out.println(m1.getTipoMedicamento());
		System.out.println(m1.tratarEnfermedad("Y22YE4"));
		
		/*
		 * al ejecutar el main en m.getTipoMedicamento() y m.tratarEnfermedad("Y212XXA") debe de haber un peque�o error 
		 * pues no sale lo que deberia de salir, pero no consigo ver la causa de que salga null
		 * Coinciden con llamadas al objeto creeado por la factoria
		 */

		
	}

}
