package ParcialFundamentos;
import java.util.ArrayList;

public class Sede 
{
	// private Usuarios usuarios;
	private String nombre;
	private ArrayList<Servicio> listaServicios;
	
	
	public Sede(String nombre) 
	{
		this.nombre = nombre;
		this.listaServicios = new ArrayList<Servicio>();
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
	
	//Metodo necesitado en la línea 57 del en el metodo reservarServicio de la clase CowORTKing.
	public Servicio obtenerServicioDisponible(Servicio nombreServicio) 
	{
		for(Servicio servicioIterado : this.listaServicios) 
		{
			if(servicioIterado.getNombre().equals(nombreServicio)) 
			{
				return servicioIterado; //Devolvemos el servicio y cumplimos el fin del metodo
			}
		}
		
		System.out.println("No hay servicio disponible.");
		return null;
	}
}
