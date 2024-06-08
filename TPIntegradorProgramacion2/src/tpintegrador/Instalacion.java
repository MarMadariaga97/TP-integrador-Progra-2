package tpintegrador;

public class Instalacion extends Gasista {
	
	
	
	Instalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto){
		super(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
	}
/*------------------------------------------------------------------------------*/
	@Override
	public String getTipo() {
		return "GasistaInstalacion";
	}
/*------------------------------------------------------------------------------*/
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Servicio: ").append(super.getTipo())
		.append("\nCantidad de artefactos a instalar: ").append(super.getCantArtefactos())
		.append("\nCCosto total: ")
		.append(super.getCosto());
		return sb.toString();
	}

	

}
