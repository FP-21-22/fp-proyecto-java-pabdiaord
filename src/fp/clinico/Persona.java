package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) 
						implements Comparable<Persona>{
	
	//redefinimos el constructor para las restricciones
	public Persona{
		Checkers.check("fechaNacimiento debe ser anterior a la fecha actual", fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("dni debe ser cadena con 8 digitos y una letra", sonDigitos(dni) && Character.isLetter(dni.charAt(8)));
	}
	
	private Boolean sonDigitos(String dni) {
		Boolean res=true;
		for(int i=0; i<dni.length()-1;i++) {
			res = Character.isDigit(dni.charAt(i));
			if(!res) {
				break;
			}
			
		}
		return res;
	}
	
	
	//Métodos derivados
	public Integer edad() {
		LocalDate hoy = LocalDate.now();
		Integer res = this.fechaNacimiento.until(hoy).getYears();
		return res;
	}
	
	//metodos de factoria 
	
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		Persona res = new Persona(nombre,  apellidos,  dni,  fechaNacimiento);
		return res;
	}
	
	public static Persona parse(String cadena) {
		String[] partes = cadena.split(",");
		String nb = partes[0].trim();
		String ap = partes[1].trim();
		String[] ap_partes = ap.split(" ");
		String dn = partes[2].trim();
		LocalDate ld = LocalDate.parse(partes[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return Persona.of(nb, ap_partes[0] + " " + ap_partes[1], dn, ld);
		
		
	}
	
	//propiedades basicas asociadas al record
	
	//representacion como cadena y criterio de igualdad asociados al record
	
	//orden natural
	@Override
	public int compareTo(Persona o) {
		int res = this.dni().compareTo(o.dni());
		if(res==0) {
			res = 0;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Persona p = Persona.of("Pablo", "Diaz Ordoñez", "20230589L", LocalDate.of(2002, 06, 12));
		Persona p2 = Persona.parse("Juan, García Rodríguez, 12755078Z, 20/03/1965");
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p.edad());
		
	}

}
