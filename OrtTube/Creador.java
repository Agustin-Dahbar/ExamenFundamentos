package OrtTube;
import java.util.ArrayList;

public class Creador 
{
	private String nombre;
	private String email;
	private ArrayList<Canal> listaCanales;
	public boolean cambioSuNombre;
	
	
	public Creador(String nombre, String email) 
	{
		this.nombre = nombre;
		this.email = email;
		this.listaCanales = new ArrayList<>();
		this.cambioSuNombre = false;
	}
	
	
	public boolean registrarCanal(String nombre) 
	{
		//Iteramos por todos los canales en la lista
		for(Canal canalIterado:this.listaCanales) 
		{
			if(canalIterado.getNombre().equals(nombre)) //Validamos si ya existe un canal con el nombre recibido por parámetro.
			{
				System.out.println("Este nombre de canal ya existe.");
				return false;
			}
		}
		
		//Si salimos del foreach es porque no existe, entonces lo creamos
		Canal nuevoCanal = new Canal(nombre);
		listaCanales.add(nuevoCanal);
		return true;
	}
	
	//1er metodo principal
	public ArrayList<String> obtenerCanalesEnVivo()
	{
		//Declaramos la ArrayList que será devuelta, si ningún canal resulta estar en vivo devolverá null.
		ArrayList<String>canalesEnVivo = new ArrayList<>();
		
		//Iteramos por todos los canales para averiguar si están transmitiendo en vivo con el metodo correspondiente que heredamos del parámetro recibido.
		for(Canal canalIterado: this.listaCanales) 
		{
			if(canalIterado.estaEnVivo()) //Si esta en vivo es true
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
		if(!this.cambioSuNombre && obtenerCanalesEnVivo().isEmpty()) //Si nunca cambio su nombre y ninguno de sus canales está en vivo..
		{
			this.nombre = nuevoNombre; //le permitimos cambiar el nombre
			System.out.println("Se ha cambiado el nuevo nombre correctamente.");
			this.cambioSuNombre = true;
			return RESULTADO.OK;
			
		}
		else if(!obtenerCanalesEnVivo().isEmpty()) //Si esta transmitiendo
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
	
	
	//Metodos secundarios usados en el metodo principal anterior.
	public boolean creadorTransmitiendo() 
	{
		return !obtenerCanalesEnVivo().isEmpty(); //Si la obtención de canales transmitiendo NO (!) ESTA VACÍA (es decir hay alguno) devuelve TRUE.
	}
	
	
	//Usada en el constructor para asignarle valor al atributo que almacena la lista de sus canales
	public ArrayList<Canal> getListaCanales()
	{
		return this.listaCanales;
	}
	
	
	
	// Comentame este metodo tu chat gpt.
	public boolean mismoCreador(String nombre) 
	{
		return this.nombre.equals(nombre);

	}
	
	//Metodo que busca el canal recibido por parametro mediante un bucle foreach.
	public Canal buscarCanal(String nombreCanal) 
	{
		for(Canal canalIterado: this.listaCanales) 
		{
			if(canalIterado.getNombre().equals(nombreCanal)) 
			{
				Canal canalEncontrado = canalIterado;
				return canalEncontrado;
			}
		}
		
		return null;
	}
	
	//Getters
	public String getNombreUsuario() 
	{
		return this.nombre;
	}
	
	
	public String getEmail() 
	{
		return this.email;
	}
	
	
	
	 // Método para iniciar transmisión
    public boolean iniciarTransmision(String nombre) 
    {
        Canal canal = buscarCanal(nombre);
        
        if (canal != null && !canal.estaEnVivo()) 
        {
            canal.iniciarTransmision();
            return true;
        }
        
        return false;
    }
    
    // Método para detener transmisión
    public boolean detenerTransmision(String nombre) 
    {
        Canal canal = buscarCanal(nombre);
        
        if (canal != null && canal.estaEnVivo()) 
        {
            canal.detenerTransmision();
            return true;
        }
        
        return false;
    }
	
	//ToString();
	@Override
	public String toString() 
	{
		return "nombre: " + this.nombre;
	}
	
	
	
}

