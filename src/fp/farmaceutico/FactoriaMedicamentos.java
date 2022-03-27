package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		TipoMedicamento res;
		if(cadena=="Anatómico") {
			res = TipoMedicamento.ANATOMICO;
		}else if(cadena=="Químico") {
			res = TipoMedicamento.QUIMICO;
		}else if(cadena=="Terapéutico") {
			res = TipoMedicamento.TERAPEUTICO;
		}
		else {
			res=null;
		}
		return res;
	}

}
