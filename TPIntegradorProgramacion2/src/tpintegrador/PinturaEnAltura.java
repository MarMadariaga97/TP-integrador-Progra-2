package tpintegrador;

public class PinturaEnAltura extends Pintura {
	private int piso;
	private double costoDeSeguro;
	private double alquilerDeAndamios;

	/*
	 int dni, int nroEspecialista,String direccion, int metrosCuadrados,double precioPorMetroCuadrado, int piso,
			 double seguro, double alqAndamios) 
	 */
	public PinturaEnAltura(int dni, int nroDeEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado,
							int piso, double costoDeSeguro, double alquilerDeAndamio) {
		
		super(dni, nroDeEspecialista, direccion, metrosCuadrados, precioPorMetroCuadrado);
		this.piso=piso;
		this.costoDeSeguro=costoDeSeguro;
		this.alquilerDeAndamios=alquilerDeAndamio;
	}
	
	/*------------------------------------------------------------------------------*/
	@Override
	public double costo(double costoMateriales) {
		double costoTotal;
		if(this.piso>5) {
			this.alquilerDeAndamios=this.alquilerDeAndamios+(20*this.alquilerDeAndamios/100);
			costoTotal=(super.getMetrosCuadrados()*super.getPrecioPorMetroCuadrado())+this.costoDeSeguro+this.alquilerDeAndamios+costoMateriales;
			super.setCosto(costoTotal);
			return costoTotal;
		}
		
		else {
			costoTotal=(super.getMetrosCuadrados()*super.getPrecioPorMetroCuadrado()+this.costoDeSeguro+this.alquilerDeAndamios)+ costoMateriales;
			super.setCosto(costoTotal);
			return costoTotal;
			
		}
		
	}
/*------------------------------------------------------------------------------*/
	
	public String getTipo() {
		return "PinturaEnAltura";
	}
		
	/*------------------------------------------------------------------------------*/
	public int getPiso() {
		return this.piso;
	}

	/*------------------------------------------------------------------------------*/
	
	public double getCostoDeSeguro() {
		return this.costoDeSeguro;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public double getCostoAlqDeAndamios() {
		return this.alquilerDeAndamios;
	}

	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Servicio: ").append(super.getTipo())
		.append("\nMetros cuadrados a pintar: ").append(super.getMetrosCuadrados())
		.append("\nCCosto total: ")
		.append(super.getCosto());
		return sb.toString();
	}
}
