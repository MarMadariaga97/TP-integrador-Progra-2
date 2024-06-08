package tpintegrador;

public class Cliente {
	private double dni;
	private String nombre;
	private String nroDeContacto;

	
	
	public Cliente(double dni, String nombre, String nroDeContacto) {
		this.dni = dni;
		this.nombre = nombre;
		this.nroDeContacto = nroDeContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDNI() {
		return dni;
	}
	
	public String getNroDeContacto() {
		return this.nroDeContacto;
	}
	
	
	public boolean equals(double dni) {
		return this.dni==dni;
	}
	
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Nombre: ").append(this.nombre)
		.append("\nDni").append(this.dni).append("\nNumero de contacto: ")
		.append(this.nroDeContacto);
		return "";
	}
	
	

}
