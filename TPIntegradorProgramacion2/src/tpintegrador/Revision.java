package tpintegrador;

public class Revision extends Gasista {
	
	
	public Revision(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto){
		super(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
		
	}
	
	
	@Override
	public double costo(double costoMateriales) {
		double costoTotal=getCantArtefactos()*getCantArtefactos();
		
		if(getCantArtefactos()>5 && getCantArtefactos()<11)
			return costoTotal=costoTotal-(10*costoTotal/100);
		
		if(getCantArtefactos()>=11)
			return costoTotal=costoTotal-(15*costoTotal/100);
		
		return costoTotal;
	}
/*------------------------------------------------------------------------------*/
	@Override
	public String getTipo() {
		return "GasistaRevision";
	}
/*------------------------------------------------------------------------------*/

	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Servicio: ").append(super.getTipo())
		.append("\nCantidad de artefactos a instalar: ").append(super.getCantArtefactos())
		.append("\nCCosto total: ")
		.append(super.getCosto());
		return sb.toString();
	}

	

}
