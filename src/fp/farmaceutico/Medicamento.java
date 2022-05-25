package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento>{
	//Atributos
	private String nombreMedicamento;
	private TipoMedicamento tipoMedicamento;
	private String codigoEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;
	
	
	//Metodos constructores
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		super();
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
		Checkers.check("puntuacion debe ser mayor estricta que cero", puntuacion>0);
		Checkers.check("indiceSomatico debe ser mayor o igual que 1000", indiceSomatico >=1000);
		Checkers.check("fechaCatalogo debe ser posterior al 01/01/2015", fechaCatalogo.isAfter(LocalDate.of(2015, 01, 01)));
		
	}


	
	
	//Metodos de las propiedades
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}


	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		Checkers.check("fechaCatalogo debe ser posterior al 01/01/2015", fechaCatalogo.isAfter(LocalDate.of(2015, 01, 01)));

		this.fechaCatalogo = fechaCatalogo;
	}


	public String getNombreMedicamento() {
		return nombreMedicamento;
	}


	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}


	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}


	public String getFarmaceutica() {
		return farmaceutica;
	}


	public Double getPuntuacion() {
		return puntuacion;
	}


	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	
	
	//metodo derivado
	public Boolean tratarEnfermedad(String codigo) {
		Boolean res = null;
		if(this.getCodigoEnfermedad()==codigo) {
			res = true;
		}
		else {
			res=false;
		}
		return res;
		
	}




	
	
	//Metodos adicionales 
	//Representacion como cadena
	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}
	
	
	//criterio igualdad
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}


	//criterio orden

	@Override
	public int compareTo(Medicamento o) {
		int res = this.getNombreMedicamento().compareTo(o.getNombreMedicamento());
		if(res==0) {
			res = this.getFarmaceutica().compareTo(o.getFarmaceutica());
		}
		return res;
	}
	


}
