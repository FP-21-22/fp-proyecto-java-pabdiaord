package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class FactoriaVacunaciones {
	public static List<Vacunacion> leeFichero(String nombreFichero){
		List<Vacunacion> res = new ArrayList<Vacunacion>();
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
				Vacunacion v = parseaLinea(e);
				res.add(v);
			}
			cont++;
		}
		return res;
	}
	
	public static Stream<Vacunacion> leerVacunaciones2(String fichero){
		Stream<Vacunacion> res = null;
		try {
			res = Files.lines(Paths.get(fichero)).skip(1).map(x->parseaLinea(x));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	private static Vacunacion parseaLinea(String cadena) {
		
		String[] aux = cadena.split(";");
		LocalDate fecha = LocalDate.parse(aux[0].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		String comunidad = aux[1].trim();
		Integer pfizer = Integer.parseInt(aux[2].trim());
		Integer  moderna= Integer.parseInt(aux[3].trim());
		Integer astrazeneca= Integer.parseInt(aux[4].trim());
		Integer janssen= Integer.parseInt(aux[5].trim());
		Integer numeroPersonas= Integer.parseInt(aux[6].trim());
		Vacunacion res = new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
		return res;
	}

}
