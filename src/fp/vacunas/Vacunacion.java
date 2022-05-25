package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna,
		Integer astrazeneca, Integer janssen, Integer numeroPersonas) implements Comparable<Vacunacion>{
	
	//redefinimos el constructor para las restricciones
	public Vacunacion{
		Checkers.check("fecha debe ser posterior al 01/01/2021", fecha.isAfter(LocalDate.of(2021, 01, 01)));
	}
	
	
	//Metodos derivados
	public Integer numeroTotal() {
		return this.pfizer + this.moderna + this.astrazeneca + this.janssen;
	}


	
	
	//Representación como cadena: por defecto asociado al record.
	
	//Criterio de igualdad: por defecto asociado al record
	
	//Orden natural
	@Override
	public int compareTo(Vacunacion o) {
		Integer res = this.comunidad.compareTo(o.comunidad);
		if(res==0) {
			res = this.fecha.compareTo(o.fecha);
		}
		return res;
	}
	
	//Factorias
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna,
		Integer astrazeneca, Integer janssen, Integer numeroPersonas) {
		return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
	
	public static Vacunacion parse(String cadena) {
		String[] partes = cadena.split(";");
		LocalDate ld = LocalDate.parse(partes[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String com = partes[1].trim();
		Integer pf = Integer.parseInt(partes[2].trim());
		Integer mod = Integer.parseInt(partes[3].trim());
		Integer ast = Integer.parseInt(partes[4].trim());
		Integer jan = Integer.parseInt(partes[5].trim());
		Integer np = Integer.parseInt(partes[6].trim());
		return Vacunacion.of(ld, com, pf, mod, ast, jan, ast);
	}
	
	public static void main(String[] args) {
		//Vacunacion v = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		//System.out.println(v); //sale error por la restricción
		Vacunacion v1 = Vacunacion.parse("04/08/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v1); 
		Vacunacion v2 = Vacunacion.of(LocalDate.of(2022, 02, 10), "Extremadura", 1234, 432, 34, 0, 0);
		System.out.println(v2);
		System.out.println("El número total de vacuna es: " + v2.numeroTotal());
		
	}

}
