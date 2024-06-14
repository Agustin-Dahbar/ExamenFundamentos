package ParcialFundamentos;

public class Ticket 
{
	Sede sede;
	Servicio servicios;
	double importeAabonar;
	
	public Ticket(Sede sede, Servicio servicio, double importeAabonar) 
	{
		this.sede = sede;
		this.servicios = servicio;
		this.importeAabonar = servicio.getPrecioAdicional(); //Heredamos y usamos el metodo de la clase servicio gracias al parametro servicio recibido para calcular el importe.
	}
}
