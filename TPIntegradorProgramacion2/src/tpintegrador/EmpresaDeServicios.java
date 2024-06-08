package tpintegrador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmpresaDeServicios {
	
	private Map <Integer, Cliente> clientes;
	private Map <Integer, Especialista> especialistas;
	private Map <Integer, Servicio> serviciosSolicitados;
	private Map <String, Double> facturacionTotalPorTipo;


	
	//Constructor
	EmpresaDeServicios(){
		this.clientes=new HashMap <Integer,Cliente>();
		this.especialistas=new HashMap <Integer,Especialista>();
		this.serviciosSolicitados=new HashMap <Integer,Servicio>();
		this.facturacionTotalPorTipo=new HashMap <String, Double>();
		this.facturacionTotalPorTipo.put("Pintura", 0.0);
		this.facturacionTotalPorTipo.put("PinturaEnAltura", 0.0);
		this.facturacionTotalPorTipo.put("GasistaInstalacion", 0.0);
		this.facturacionTotalPorTipo.put("GasistaRevision", 0.0);
		this.facturacionTotalPorTipo.put("Electricidad", 0.0);
		
		

	}
	/**
	* Registra un nuevo cliente en el sistema dado su:
	* - dni,
	* - nombre y
	* - teléfono de contacto.
	*
	* Si el dni ya está en el sistema se debe generar una
	* excepción.
	*/
	public void registrarCliente(int dni, String nombre, String telefono) {
		
			if(clientes.containsKey(dni)) 
				throw new RuntimeException("Este cliente ya se encuentra registrado");
			
			else 
				clientes.put(dni,new Cliente(dni,nombre,telefono));	
	}

	
	/**
	* Registra un nuevo especialista en el sistema dados su:
	* - nroEspecialista,
	* - nombre,
	* - teléfono y
	* - tipo De servicio en el que se especializa.
	*
	* Si el nroEspecialista ya está registrado en el sistema
	* se debe generar una excepción.
	*/
	
	public void registrarEspecialista(int nroEspecialista, String nombre,String telefono, String especialidad) {
		
			if(especialidad!="Pintura" && especialidad!="PinturaEnAltura" && especialidad!="GasistaInstalacion" && especialidad!="GasistaRevision" && especialidad!="Electricidad")	
				throw new RuntimeException("La empresa no cuenta con este tipo de servicio");
			
			if(especialistas.containsKey(nroEspecialista)) 
					throw new RuntimeException("Este especialista ya se encuentra registrado");
			
			else 
					especialistas.put(nroEspecialista,new Especialista(nroEspecialista,nombre,telefono,especialidad));
				
			}

	/**
	* Se registra la prestación de un servicio de tipo Electricidad en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por hora de trabajo del especialista
	* - cantidad de horas estimadas que llevará realizar el trabajo.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por hora o las horas de trabajo estimado son menores o
	* iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioElectricidad(int dni, int nroEspecialista,
	 String direccion, double precioPorHora,
	 int horasTrabajadas) {
		
		
		if(!this.clientes.containsKey(dni))
			throw new RuntimeException("El cliente no está registrado en el sistema");
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		Especialista esp=especialistas.get(nroEspecialista);
		
		if(!esp.getEspecialidad().equals("Electricidad"))
			throw new RuntimeException("El especialista no se especializa en pintura");
		
		if(precioPorHora<0)
			throw new RuntimeException("El precio por hora debe ser mayor a 0");
		
		if(horasTrabajadas<0)
			throw new RuntimeException("Las horas de trabajo estimado deben ser mayores a 0");
		
		Electricidad electricidad=new Electricidad(dni,nroEspecialista, direccion, precioPorHora, horasTrabajadas);
		int codigo=electricidad.getCodigo();
		serviciosSolicitados.put(codigo, electricidad);
		
		esp.setServiciosACargo(codigo, direccion);
		
		return codigo;
	}
	/**
	* Se registra la prestación de un servicio de tipo Pintura en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados son menores o
	* iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista,String direccion, int metrosCuadrados, double precioPorMetroCuadrado) {
		
		if(!this.clientes.containsKey(dni))
			throw new RuntimeException("El cliente no está registrado en el sistema");
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		Especialista esp=especialistas.get(nroEspecialista);
		if(!esp.getEspecialidad().equals("Pintura"))
			throw new RuntimeException("El especialista no se especializa en pintura");
		
		if(metrosCuadrados<0)
			throw new RuntimeException("Los metros cuadrados a pintar deben ser mayores a 0");
		
		if(precioPorMetroCuadrado<0)
			throw new RuntimeException("El precio por metro cuadrado debe ser mayor a 0");
		
		
		Pintura pintura=new Pintura(dni, nroEspecialista, direccion, metrosCuadrados, precioPorMetroCuadrado);
		int codigo=pintura.getCodigo();
		serviciosSolicitados.put(codigo, pintura);
		
		esp.setServiciosACargo(codigo, direccion);
		
		return codigo;
		
	}
	/**
	* Se registra la prestación de un servicio de tipo PinturaEnAltura en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar
	* - nro de piso en el que se realizará el trabajo.
	* - costo del seguro
	* - costo del alquiler de los andamios.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados o el piso o el costo
	* del seguro o el costo del alquiler de los andamios son menores o iguales a 0,
	* se debe generar una excepción.
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista,String direccion, int metrosCuadrados,double precioPorMetroCuadrado, int piso,
			 double seguro, double alqAndamios) {
		
		if(!this.clientes.containsKey(dni))
			throw new RuntimeException("El cliente no está registrado en el sistema");
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		Especialista esp=especialistas.get(nroEspecialista);
		
		if(!esp.getEspecialidad().equals("PinturaEnAltura"))
			throw new RuntimeException("El especialista no se especializa en pintura");
		
		if(metrosCuadrados<0)
			throw new RuntimeException("Los metros cuadrados a pintar deben ser mayores a 0");
		
		if(precioPorMetroCuadrado<0)
			throw new RuntimeException("El precio por metro cuadrado debe ser mayor a 0");
		
		if(piso<0)
			throw new RuntimeException("El piso debe ser mayor a 0");
		
		if(seguro<0)
			throw new RuntimeException("El costo del seguro debe ser mayor a 0");
		
		if(alqAndamios<0)
			throw new RuntimeException("El costo de alquiler de los andamios debe ser mayor a 0");
		
		PinturaEnAltura pintura=new PinturaEnAltura(dni, nroEspecialista, direccion, metrosCuadrados, precioPorMetroCuadrado, piso ,seguro, alqAndamios);
		int codigo=pintura.getCodigo();
		serviciosSolicitados.put(codigo, pintura);
		
		esp.setServiciosACargo(codigo, direccion);
		
		return codigo;
	}
	/**
	* Se registra la prestación de un servicio de tipo GasistaInstalacion en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a instalar
	* - precio por la instalación de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a instalar son
	* menores o iguales a 0, se debe generar una excepción.
	*/

	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		
		if(!this.clientes.containsKey(dni))
			throw new RuntimeException("El cliente no está registrado en el sistema");
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		Especialista esp=especialistas.get(nroEspecialista);
		
		if(!esp.getEspecialidad().equals("GasistaInstalacion"))
			throw new RuntimeException("El especialista no se especializa en pintura");
		
		if(precioPorArtefacto<0)
			throw new RuntimeException("El precio por artefacto debe ser mayor a 0");
		
		if(cantArtefactos<0)
			throw new RuntimeException("La cantidad de artefactos a instalar debe ser mayor a 0");
		
		
		Instalacion inst=new Instalacion(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
		int codigo=inst.getCodigo();
		serviciosSolicitados.put(codigo, inst);
		
		esp.setServiciosACargo(codigo, direccion);
		
		return codigo;	

	}
	/**
	* Se registra la prestación de un servicio de tipo GasistaRevison en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a revisar
	* - precio por la revisión de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a revisar son
	* menores o iguales a 0, se debe generar una excepción.
	*/

	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		
		if(!this.clientes.containsKey(dni))
			throw new RuntimeException("El cliente no está registrado en el sistema");
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		Especialista esp=especialistas.get(nroEspecialista);
		
		if(!esp.getEspecialidad().equals("GasistaRevision"))
			throw new RuntimeException("El especialista no se especializa en pintura");
		
		if(precioPorArtefacto<0)
			throw new RuntimeException("El precio por artefacto debe ser mayor a 0");
		
		if(cantArtefactos<0)
			throw new RuntimeException("La cantidad de artefactos a revisar debe ser mayor a 0");
		
		
		Revision rev=new Revision(dni, nroEspecialista, direccion, cantArtefactos, precioPorArtefacto);
		int codigo=rev.getCodigo();
		serviciosSolicitados.put(codigo, rev);
		
		esp.setServiciosACargo(codigo, direccion);
		
		return codigo;

	}
	/*
	 * Se registra que el servicio solicitado ya fué concluido. Para esto se debe
	 * ingresar el costo de los materiales utilizados para poder realizar el
	 * trabajo.
	 *
	 * Se devuelve el precio que se debe facturar al cliente.
	 * Este precio se obtiene sumando el costo de los materiales con el costo del
	 * servicio realizado. Cada tipo de servicio tiene su forma de calcular el
	 * costo del trabajo.
	 *
	 * Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
	 * se debe generar una excepción.
	 *
	* Se debe realizar esta operación en O(1).
	*/
	public double finalizarServicio(int codServicio, double costoMateriales) {
		
		if(!this.serviciosSolicitados.containsKey(codServicio))
				throw new RuntimeException("El código de servicio no se encuentra registrado en el sistema");
		
		Servicio serv=this.serviciosSolicitados.get(codServicio);
		
		if(!serv.getEstado())
			throw new RuntimeException("El servicio ya fue finalizado");
		
		serv.finalizarServicio();
		
	//	this.serviciosSolicitados.put(codServicio, serv); no hace falta si serv apunta al valor del map
		//double costoPorTipo=this.facturacionTotalPorTipo
		double costoPorTipo=0;
		
		if(this.facturacionTotalPorTipo.containsKey(serv.getTipo()))
			costoPorTipo=this.facturacionTotalPorTipo.get(serv.getTipo());
		
		this.facturacionTotalPorTipo.put(serv.getTipo(), costoPorTipo+serv.costo(costoMateriales));
		
		return serv.costo(costoMateriales);
		
	}
	/**
	 * Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	 * cantidad de servicios realizados de ese tipo.
	 * Si un tipo de servicio no tuvo ninguna demanda, el valor de esa entrada debe
	 * ser 0.
	 */
	
	
	public Map<String,Integer> cantidadDeServiciosRealizadosPorTipo(){
		int cantServiciosPintura=0;
		int cantServiciosPinturaEnAltura=0;
		int cantServiciosGasistaInstalacion=0;
		int cantServiciosGasistaRevision=0;
		int cantServiciosElectricidad=0;
		
		Map<String, Integer> cantDeServRealizadosPorTipo=new HashMap<>();
		
		for(int codServicio : this.serviciosSolicitados.keySet()) {
			
			Servicio serv = this.serviciosSolicitados.get(codServicio);
			
			if(serv.getTipo().equals("Pintura") && serv.getEstado()==false) 
				cantServiciosPintura=cantServiciosPintura+1;
			
			else if(serv.getTipo().equals("PinturaEnAltura") && serv.getEstado()==false) 
				cantServiciosPinturaEnAltura=cantServiciosPinturaEnAltura+1;			
			
			else if(serv.getTipo().equals("GasistaInstalacion") && serv.getEstado()==false) 
				cantServiciosGasistaInstalacion=cantServiciosGasistaInstalacion+1;
				
			
			else if(serv.getTipo().equals("GasistaRevision") && serv.getEstado()==false) 
				cantServiciosGasistaRevision=cantServiciosGasistaRevision+1;

			
			else if(serv.getTipo().equals("Electricidad") && serv.getEstado()==false)
				cantServiciosElectricidad=cantServiciosElectricidad+1;
				
		}
		
		cantDeServRealizadosPorTipo.put("Pintura", cantServiciosPintura);
		cantDeServRealizadosPorTipo.put("PinturaEnAltura", cantServiciosPinturaEnAltura);
		cantDeServRealizadosPorTipo.put("GasistaInstalacion", cantServiciosGasistaInstalacion);
		cantDeServRealizadosPorTipo.put("GasistaRevision", cantServiciosGasistaRevision);
		cantDeServRealizadosPorTipo.put("Electricidad", cantServiciosElectricidad);
		
		return cantDeServRealizadosPorTipo;
	}
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* son del tipo pasado por parámetro.
	* Si el tipo de servicio es invalido, debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/ 
	public double facturacionTotalPorTipo(String tipoServicio) {
		
		if(!this.facturacionTotalPorTipo.containsKey(tipoServicio))
			throw new RuntimeException("El tipo de servicio es inválido");
		
		
		return this.facturacionTotalPorTipo.get(tipoServicio);
		
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* realizó la empresa.
	*/
	public double facturacionTotal() {
		double facturacionTotal=0;
		
		Iterator <String> it = facturacionTotalPorTipo.keySet().iterator();
		
		while(it.hasNext()) {
			String clave=it.next();
			double valor=facturacionTotalPorTipo.get(clave);
			facturacionTotal=facturacionTotal+valor;
		}
		
		return facturacionTotal;
	}
	/**
	* Debe cambiar el especialista responsable del servicio.
	* Si código de Servicio o el nroEspecialista no están registrados en el sistema
	* se debe generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	*
	*
	* Se debe realizar esta operación en O(1).
	*/
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		
		if(!this.serviciosSolicitados.containsKey(codServicio)) 
			throw new RuntimeException("El código de servicio es inválido");
		
		
		if(!this.especialistas.containsKey(nroEspecialista))
			throw new RuntimeException("El número de especialista es inválido");
		
		
		Servicio serv=this.serviciosSolicitados.get(codServicio);
		Especialista esp=especialistas.get(nroEspecialista);
		
		if(!serv.getTipo().equals(esp.getEspecialidad()))
			throw new RuntimeException("El especialista no se especializa en este tipo de servicio");
	
	
		int nroEspecialistaAnterior=serv.getNroEspecialista();
		Especialista especialistaAnterior=especialistas.get(nroEspecialistaAnterior);
		
		
		especialistaAnterior.eliminarServicioDelHistorial(codServicio);
		
		serv.setNroEspecialista(nroEspecialista);
		
		esp.setServiciosACargo(codServicio, serv.getDireccion());
	
	}
	
	/**
	* Devuelve un String con forma de listado donde cada renglón representa un
	* servicio realizado.
	* Cada renglón debe respetar el siguiente formato:
	* " + [ codServicio - GasistaInstalacion ] Dirección"
	* por ejemplo:
	* " + [ 1492 - GasistaInstalacion ] uan María Gutiérrez 1150"
	* Si el nroEspecialista no está registrado en el sistema, se debe generar una
	* excepción.
	* Si el especialista no ha realizado ningún servicio hasta el momento, se debe
	* devolver un String vacío.
	*/
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		
		if(!this.especialistas.containsKey(nroEspecialista)) {
			throw new RuntimeException("El número de especialista es inválido");
		}
		
		return this.especialistas.get(nroEspecialista).listadoServiciosACargo();
	}
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("La EmpresaDeServicios cuenta con [").append(this.facturacionTotalPorTipo.size()).append(" servicios, ")
		.append(this.clientes.size()).append(" clientes, ").append(this.especialistas.size()).append(" especialistas, ")
		.append(this.serviciosSolicitados.size()).append(" serviciosSolicitados").append("]\n")
		.append("\nServicios realizados por tipo (finalizados):\n").append(this.cantidadDeServiciosRealizadosPorTipo())
		.append("\n\nFacturación total en Electricidad: ").append(this.facturacionTotalPorTipo("Electricidad"))
		.append("\nFacturacion total en Pintura: ").append(this.facturacionTotalPorTipo("Pintura"))
		.append("\nFacturacion total en PinturaEnAltura: ")
        .append(this.facturacionTotalPorTipo("PinturaEnAltura"))
        .append("\nFacturacion total en GasistaInstalacion: ")
        .append(this.facturacionTotalPorTipo("GasistaInstalacion"))
        .append("\nFacturacion total en GasistaRevision: ")
        .append(this.facturacionTotalPorTipo("GasistaRevision"))
        .append("\n\nFacturacion total: ").append(this.facturacionTotal());
	
		
		
		return sb.toString();
		
	}
	

}
