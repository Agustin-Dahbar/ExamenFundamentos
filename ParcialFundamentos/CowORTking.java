package ParcialFundamentos;
import java.util.ArrayList;

public class CowORTking 
{
	private ArrayList<Usuarios> listaUsuarios;
	private ArrayList<Sede> listaSedes;
	
	
	public Ticket reservarServicio(String dni, Sede sede, Servicios servicio) 
	{
		Usuarios usuario = null; //Variable donde almanecaremos al usuario, de no encontrarlo quedará en null y se devolverá eso.
		//Variables que necesitaremos para instanciar al ticket que debemos devolver.
		Sede sede = null;
		Servicios servicio = null;
		
		//ForeacH que itera por todos los usuarios de la lista con el fin de buscarlo.
		for(Usuarios usuarioIterado : this.listaUsuarios) 
		{
			//Validamos con un if si el dni del usuario que estamos iterando equivale al dni recibido por parametro, en este caso encontramos al usuario.
			if(usuarioIterado.getDni().equals(dni)) 
			{
				System.out.println("El usuario ");
				usuario = usuarioIterado; //Asignamos el usuarioIterado a la variable inicial donde pretendiamos almacenarlo al encontrarlo.
				break; //Ya que encontramos al usuario, salimos del bucle foreach.
			}
		}
		
		//Validamos si encontramos al usuario
		if(usuario == null) 
		{
			System.out.println("El usuario no reservó este servicio.");
			return null;
		}
		
		for(Sede sedeIterada: this.listaSedes) 
		{
			if(sedeIterada.getNombre().equals(sede)) 
			{
				sede = sedeIterada;
				break; //Salimos del foreach de las sedes ya que ya la obtuvimos.
			}
		}
		
		//Si en el foreach no se encontró la sede..
		if(sede == null) 
		{
			System.out.println("Sede no encontrada.");
			return null;
		}
		
		servicio = sede.obtenerServicioDisponible(servicio); //Obtenemos el atributo nombre de Servicios o null y se acaba el metodo.
		
		if(servicio == null) 
		{
			System.out.println("Servicio no disponible en esta sede");
			return null;
		}
		
		//Si continua el metodo significa que el return null anterior (56) no sucedió. Ya que recordemos los returns salen del metodo. 
		//Entonces el servicio recibido esta disponible en la sede.
		
		if(servicio.getReservadoPor() == null) //Si el servicio no esta reservado por nadie, esta disponible
		{
			servicio.setReservadoPor(usuario); //Ya obtuvimos atributo del usuario del Servicios (el último).
			double importe = calcularImporte(dni, servicio); //Obtenemos el atributo restante (el importe del servicio)
			
			Ticket ticket = new Ticket(sede, servicio, importe);
			return ticket;
		}
		else 
		{
			System.out.println("El servicio ya está reservado por otro usuario.");
			return null;
		}
		
		
	}
}