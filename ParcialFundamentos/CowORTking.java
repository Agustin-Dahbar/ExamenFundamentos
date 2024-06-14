package ParcialFundamentos;
import java.util.ArrayList;

public class CowORTking 
{
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Sede> listaSedes;
	
	
	//Reservarmos un servicio para un usuario, primero comprobaremos que el usuario no tenga ese servicio a la brevedad
	//luego que el nombre de la sede que nos indicó exista en la empresa CowORTking y finalmente lo mismo con el servicio
	//pero no desarrollaremos lógica, usaremos otro metodo heredado de su clase.
	public Ticket reservarServicio(String dni, Sede nombreSede, Servicio nombreServicio) 
	{
		Usuario usuario = null; //Variable donde almanecaremos al usuario, de no encontrarlo quedará en null y se devolverá eso.
		//Variables que necesitaremos para instanciar al ticket que debemos devolver.
		Sede sede = null;
		Servicio servicio = null;
		
		
		//Foreach que itera por todos los usuarios de la lista con el fin de buscarlo.
		for(Usuario usuarioIterado : this.listaUsuarios) 
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
		
		//Lo mismo con la sede
		for(Sede sedeIterada: this.listaSedes) 
		{
			if(sedeIterada.getNombre().equals(nombreSede)) 
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
		
		servicio = sede.obtenerServicioDisponible(nombreServicio); //Obtenemos el atributo nombre de Servicios o null y se acaba el metodo.
		
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
	
	
	
	//metodo necesario en la Línea 71 metodo principal reservarServicio()
	public double calcularImporte(String dni, Servicio servicio) 
	{
		Usuario usuario = null;
		double importe = servicio.getPrecioAdicional(); //Heredamos un metodo de la clase Servicios gracias a recibir un servicio por parámetro.
		
		//Bucle foreach, buscaremos al usuario en la lista, si no lo encontramos no contrató ningun servicio por lo que en el próximo if se cancelará el metodo.
		for(Usuario usuarioIterado : this.listaUsuarios) 
		{
			if(usuarioIterado.getDni().equals(dni)) 
			{
				usuario = usuarioIterado;
				break;
			}
		}
		
		//Cancelamos el metodo.
		if(usuario == null) 
		{
			System.out.println("No se encontró el usuario");
			return 0.0;
		}
		

		//Si continua el código es porque la anterior sentencia if no sucedió, por lo tanto encontramos al usuario parametrizado en la lista.
		
		//Si el usuario no pagó  la cuota == if(false)
		if(!usuario.getIsCuotaPagada()) 
		{
			importe = 15000;
		}
		
		return importe;
	}
	
}