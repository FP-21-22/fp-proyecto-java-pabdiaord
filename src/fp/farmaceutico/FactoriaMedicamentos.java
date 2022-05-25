package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.vacunas.Vacunacion;

public class FactoriaMedicamentos {
	public static Medicamento parseaMedicamento(String cadena) {
		String[] partes = cadena.split(",");
		String nm = partes[0].trim();
		TipoMedicamento tm = tipo(partes[1].trim());
		String ce = partes[2].trim();
		String farm = partes[3].trim();
		Double pun = Double.parseDouble(partes[4].trim());
		Integer is = Integer.parseInt(partes[5].trim());
		LocalDate ld = LocalDate.parse(partes[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nm, tm, ce, farm, pun, is, ld);
	}
	//metodo auxiliar para parse
	private static TipoMedicamento tipo(String cadena) {
		TipoMedicamento res = null;
		if(cadena.equals("Anatomico")) {
			res = TipoMedicamento.ANATOMICO;
		}else if(cadena.equals("Quimico")) {
			res = TipoMedicamento.QUIMICO;
		}else if(cadena.equals("Terapeutico")) {
			res = TipoMedicamento.TERAPEUTICO;
		}
		else {
			
		}
		return res;
	}
	
	
	
	public static List<Medicamento> leeFichero(String nombreFichero){
		List<Medicamento> res = new ArrayList<Medicamento>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Hay que saltarse la primera linea
		int cont=0;
		for(String e:aux) {
			if(cont>0) {
				Medicamento m = parseaMedicamento(e);
				res.add(m);
			}
			cont++;
		}
		return res;
	}
	
	public static Stream<Medicamento> leerMedicamentos2(String fichero){
		Stream<Medicamento> res = null;
		try {
			res = Files.lines(Paths.get(fichero)).skip(1).map(x->parseaMedicamento(x));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}
