package tpintegrador;

public class Gasista extends Servicio {
	
	protected int cantArtefactos;
	protected double precioPorArtefactos;
	
	public Gasista(int dni, int nroEspecialista, String direccion, 
			int CantArtefactos, double precioPorArtefactos) {
		
		super(dni, nroEspecialista, direccion);
		this.cantArtefactos=CantArtefactos;
		this.precioPorArtefactos=precioPorArtefactos;
		super.generarCodigo();
	}
	/*------------------------------------------------------------------------------*/
	
	public String getTipo() {
		return "";
	}
	
	/*------------------------------------------------------------------------------*/
	
	@Override
	public double costo(double costoMateriales) {
			return (this.cantArtefactos*this.precioPorArtefactos) + costoMateriales;
	}

	/*------------------------------------------------------------------------------*/
	
	public int getCantArtefactos() {
		return this.cantArtefactos;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public double getPrecioPorArtefacto() {
		return this.precioPorArtefactos;
	}

	@Override	
	public String toString() {
		return "";
	}






}
