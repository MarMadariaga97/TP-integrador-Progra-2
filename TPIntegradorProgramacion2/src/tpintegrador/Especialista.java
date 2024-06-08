package tpintegrador;

import java.util.HashMap;
import java.util.Map;

public class Especialista {
	
	private int nroDeEspecialista;
	private String nombre;
	private String telefono;
	private String especialidad;
	private Map<Integer, String> serviciosACargo;
	
	
	public Especialista(int nroDeEspecialista, String nombre, String telefono, String especialidad) {
		this.nroDeEspecialista = nroDeEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad=especialidad;
		this.serviciosACargo=new HashMap<Integer, String> ();
		
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	/*------------------------------------------------------------------------------*/
	
	public int getNroDeEspecialista() {
		return this.nroDeEspecialista;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public String getEspecialidad() {
		return this.especialidad;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public boolean equals(int nroDeEspecialista) {
		return this.nroDeEspecialista==nroDeEspecialista;
	}
	
	/*------------------------------------------------------------------------------*/
	 
	public void setServiciosACargo(int nroDeServicio, String domicilio) {
		this.serviciosACargo.put(nroDeServicio, domicilio);
	}
	
	/*------------------------------------------------------------------------------*/
	public String listadoServiciosACargo()
	{
		if(this.serviciosACargo.size()==0) {
			return "";
		}
		
		StringBuilder listado=new StringBuilder();
		
		
		for(int clave : this.serviciosACargo.keySet()) {
			String valor = this.serviciosACargo.get(clave);
			
			listado.append(" + [ " + clave + " - " + this.especialidad + " ] " + valor + "\n");
		}
		
		return listado.toString();
	}

	/*------------------------------------------------------------------------------*/
	
	public void eliminarServicioDelHistorial(int codServicio) {
		this.serviciosACargo.remove(codServicio);
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(this.nombre)
		.append("\nEspecialidad: ").append(this.especialidad).append("\nCantidad de servicios a cargo: ")
		.append(this.serviciosACargo.size());
		return sb.toString();
	}

}
