package tpintegrador;

public class Pintura extends Servicio {
	
	private int metrosCuadrados;
	private double precioPorMetroCuadrado;
	private int codigo;

	public Pintura(int dni, int nroEspecialista, String direccion, int metrosCuadradosAPintar, double precioPorMetroCuadrado) 
	{
		super(dni, nroEspecialista, direccion);
		this.metrosCuadrados=metrosCuadradosAPintar;
		this.precioPorMetroCuadrado=precioPorMetroCuadrado;
		this.codigo=super.generarCodigo();
	}
	/*------------------------------------------------------------------------------*/
	//Utilizo este constructor como base del constructor de PinturaEnAltura
	/*public Pintura(String nombre, int dni, int nroEspecialista, String direccion, int metrosCuadradosAPintar, double precioPorMetroCuadrado) 
	{
		super(dni, nroEspecialista, direccion);
		this.metrosCuadrados=metrosCuadradosAPintar;
		this.precioPorMetroCuadrado=precioPorMetroCuadrado;
		super.generarCodigo1();
		
	}*/
	/*------------------------------------------------------------------------------*/
	public int getCodigo() {
		return this.codigo;
	}
	/*------------------------------------------------------------------------------*/
	
	public String getTipo() {
		return "Pintura";
	}
	
	/*------------------------------------------------------------------------------*/
	public int getMetrosCuadrados() {
		return this.metrosCuadrados;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public double getPrecioPorMetroCuadrado() {
		return this.precioPorMetroCuadrado;
	}
	
	/*------------------------------------------------------------------------------*/
	
	@Override
	public double costo(double costoMateriales) {
		double costo=this.metrosCuadrados*this.precioPorMetroCuadrado+costoMateriales;
		super.setCosto(costo);
		return costo;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Servicio: ").append(this.getTipo())
		.append("\nMetros cuadrados a pintar: ").append(this.metrosCuadrados)
		.append("\nCCosto total: ")
		.append(super.getCosto());
		return sb.toString();
	}


}
