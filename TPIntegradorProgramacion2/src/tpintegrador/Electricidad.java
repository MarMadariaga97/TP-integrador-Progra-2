package tpintegrador;

public class Electricidad extends Servicio {
	private int horasDeTrabajo;
	private double valorPorHora;

	public Electricidad(int dni,int nroEspecialista, String direccion, double valorPorHora, int horasDeTrabajo) {
		super(dni, nroEspecialista, direccion);
		this.horasDeTrabajo=horasDeTrabajo;
		this.valorPorHora=valorPorHora;
		super.generarCodigo();
	}

	//Servicio de electricidad: Requiere conocer las horas de trabajo y el valor por hora, que
	//está prefijado. Con estos datos se realiza el cálculo del importe total.
	
	/*------------------------------------------------------------------------------*/
	public int getHorasDeTrabajo() {
		return this.horasDeTrabajo;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public String getTipo() {
		return "Electricidad";
	}
	
	/*------------------------------------------------------------------------------*/
	
	public double getValorPorHora() {
		return this.valorPorHora;
	}
	
	/*------------------------------------------------------------------------------*/

	@Override
	public double costo(double costoMateriales) {
		double costo=(this.horasDeTrabajo*this.valorPorHora)+ costoMateriales;
		super.setCosto(costo);
		return costo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Servicio: ").append(this.getTipo())
		.append("\nHoras de trabajo: ").append(this.horasDeTrabajo)
		.append("\nCCosto total: ")
		.append(super.getCosto());
		return sb.toString();
	}

}
