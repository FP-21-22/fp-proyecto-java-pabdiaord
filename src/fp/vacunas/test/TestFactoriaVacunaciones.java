package fp.vacunas.test;

import java.util.List;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;



public class TestFactoriaVacunaciones {

	public static void main(String[] args) {
		//  Auto-generated method stub
		String ruta = "data/ccaa_vacunas_3.csv";
		List<Vacunacion> lista = FactoriaVacunaciones.leeFichero(ruta);
		for(Vacunacion e:lista) {
			System.out.println(e);
		}

	}

}
