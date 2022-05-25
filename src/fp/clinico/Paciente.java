package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
	
	//redefinimos el constructor para las restricciones
	public Paciente{
		Checkers.check("fechaHoraIngreso debe ser anterior o igual a la actual", fechaHoraIngreso.isBefore(LocalDateTime.now()) || fechaHoraIngreso.isEqual(LocalDateTime.now()));
	}
	
	//Metodos derivados
	public LocalDate fechaIngreso() {
		
		return this.fechaHoraIngreso.toLocalDate();
	}
	
	public String horaIngreso() {
		
		return this.fechaHoraIngreso.toLocalTime().toString();
	}
	
	
	
	//Representación como cadena: por defecto asociado al record.Criterio de igualdad: por defecto asociado al record.
	
	//factorias
	public static Paciente of(String nombre, String apellidos, 
			String dni, LocalDate fechaNacimiento, 
			String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		Persona persona = new Persona(nombre, apellidos, dni, fechaNacimiento);
		Paciente res = new Paciente(persona, codigoIngreso, fechaHoraIngreso);
		return res;
		
	}
	
	
	
	public static Paciente of(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		Paciente res = new Paciente(persona, codigoIngreso, fechaHoraIngreso);
		return res;
		
		
	}
	
	public static void main(String[] args) {
		Paciente p = Paciente.of("pa", "nufn nfjn", "20230589L", LocalDate.of(2002, 06, 12), "trgfmtogfmtog", LocalDateTime.of(2004, 04, 20, 10, 20));
		System.out.println(p.fechaIngreso());
		System.out.println(p.horaIngreso());
		
	}

}
