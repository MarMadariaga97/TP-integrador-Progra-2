package tpintegrador;

public abstract class Servicio {
	private static int codigoDeServicio=0;
	private String direccion;
	private int dni; //identifica al cliente 
	private int nroDeEspecialista; //identifica al especialista
	private boolean activo=true; //al solicitar el servicio, el booleano siempre está en true
	private double costo;

	
	
	public Servicio(int dni, int nroEspecialista, String direccion) {
		this.dni=dni;
		this.nroDeEspecialista=nroEspecialista;
		this.direccion=direccion;

	}
	/*------------------------------------------------------------------------------*/
	public int getCodigo() {
		return codigoDeServicio;
	}
	/*------------------------------------------------------------------------------*/
	public void setCodigo(int cod) {
		codigoDeServicio=cod;
	}
	/*------------------------------------------------------------------------------*/
	public int generarCodigo() {
		codigoDeServicio+=1;
		return codigoDeServicio;
	}
	
	
	/*------------------------------------------------------------------------------*/
	public abstract String getTipo();
	
	/*------------------------------------------------------------------------------*/
	
	public double getCosto() {
		return this.costo;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public void setCosto( double costo) {
		this.costo=costo;
	}
	

	/*------------------------------------------------------------------------------*/
	
	public abstract double costo(double costoMateriales);
	
	/*------------------------------------------------------------------------------*/
	
	public String getDireccion() {
		return this.direccion;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public int getDniCliente() {
		return this.dni;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public int getNroEspecialista() {
		return this.nroDeEspecialista;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public void setNroEspecialista(int nroEspecialista) {
		this.nroDeEspecialista=nroEspecialista;
	}

	/*------------------------------------------------------------------------------*/
	
	public boolean getEstado() {
		return this.activo;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public void finalizarServicio() {
		this.activo=false;
	}
	
	public abstract String toString();

	
}
