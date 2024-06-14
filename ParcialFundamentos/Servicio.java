package ParcialFundamentos;

public class Servicio 
{
	private String nombre; 
	private double precioAdicional;
	private Usuario reservadoPor; //Si esta disponible su valor es null
	
	
	//Getter y setter del atributo reservadoPor que lo requerimos en el metodo reservarServicio() de la clase Servicios. (línea 68 y 70)
	public Usuario getReservadoPor() 
	{
		return this.reservadoPor;
	}
	
	public void setReservadoPor(Usuario usuario) 
	{
		this.reservadoPor = usuario;
	}

	//Metodo necesitado en línea 89 de la clase CowORTking en el metodo calcularImporte()
	public double getPrecioAdicional() 
	{
		return this.precioAdicional;
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
}
