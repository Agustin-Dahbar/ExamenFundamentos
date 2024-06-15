package OrtTube;
import java.util.ArrayList;

public class Creador 
{
	private String email;
	private String nombre;
	private ArrayList<Canal> listaCanales;
	private ArrayList<String> nombreCanales;
	public boolean cambioSuNombre;
	
	public Creador(String email, String nombre) 
	{
		this.email = email;
		this.nombre = nombre;
		this.listaCanales = getListaCanales();
	}
	
	//1er metodo principal
	public ArrayList<String> obtenerCanalesEnVivo()
	{
		//Declaramos la ArrayList que será devuelta, si ningún canal resulta estar en vivo devolverá null.
		ArrayList<String>canalesEnVivo = null;
		
		//Iteramos por todos los canales para averiguar si están transmitiendo en vivo con el metodo correspondiente que heredamos del parámetro recibido.
		for(Canal canalIterado: this.listaCanales) 
		{
			if(canalIterado.estaEnVivo()) //Si esta en vivo (true)
			{
				String nombreCanal = canalIterado.getNombre(); //Obtenemos su nombre para asignarlo a la lista de String. No lo podemos asignar directamente porque su tipado es Canal.
				canalesEnVivo.add(nombreCanal);
			}
		}
		//Al finalizar el bucle foreach sobre los canales y averiguar si estaban en vivo, devolvemos el nombre de todos los canales que lo estabán o null si ninguno trasnmitía.
		return canalesEnVivo;
	}
	
	
	//Metodo principal (último)
	public RESULTADO cambiarNombreUsuario(String nuevoNombre) 
	{
		if(!cambioSuNombre()) 
		{
			this.nombre = nuevoNombre;
			System.out.println("Se ha cambiado el nuevo nombre correctamente.");
			return RESULTADO.OK;
			
		}
		else if(creadorTransmitiendo()) 
		{
			System.out.println("El usuario esta transmitiendo en vivo, no podemos comprobar eso ahora mismo.");
			return RESULTADO.USUARIO_TRANSMITIENDO;
		}
		else 
		{
			System.out.println("Lo siento ya cambió su nombre anteriormente.");
			return RESULTADO.NOMBRE_YA_CAMBIADO;
		}
	}
	
	
	public boolean cambioSuNombre() 
	{
		return this.cambioSuNombre;
	}
	
	public boolean creadorTransmitiendo() 
	{
		for(Canal canalIterado: this.listaCanales) 
		{
			if(canalIterado.estaEnVivo()) 
			{
				return true;
			}
		}
		
		return false;
	}
	
	//Usada en el constructor para asignarle valor al atributo que almacena la lista de sus canales
	public ArrayList<Canal> getListaCanales()
	{
		return this.listaCanales;
	}
}

