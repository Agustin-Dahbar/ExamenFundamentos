package OrtTube;
import java.util.ArrayList;

public class OrtTube 
{
	private ArrayList<Creador> listaCreadores;
	private ArrayList<Canal> listaCanales;
	
	public OrtTube() 
	{
		this.listaCreadores = new ArrayList<>();
		this.listaCanales = new ArrayList<>();
	}
	
	//Metodos consigna: 
	
	//3er metodo principal.
	public void verCanalesEnVivo()
	{
		for(Creador creadorIterado: this.listaCreadores) //Iteramos por todos los creadores, obtenemos sus canales que estén transmitiendo en vivo.
		{
			System.out.println(creadorIterado.obtenerCanalesEnVivo()); //Metodo que devuelve una ArrayList<String>
		}
	}
	
	
	//Metodos del UML del enunciado.
	public boolean registrarCreador(String nombreCreador, String nombreEmail) 
	{
		//Si no encontramos creadores con este mail. lo creamos. (Los nombres si pueden repetirse).
		if(buscarCreador(nombreEmail) == null) 
		{
			Creador creador = new Creador(nombreCreador, nombreEmail);
			this.listaCreadores.add(creador);
			System.out.println("Creador agregado.");
			return true;
		}
		
		System.out.println("El email ya esta registrado.");
		return false;
	}
	
	
	//Metodo secundario que usaremos repetidas veces para validaciones de existencia o para comprobar si el email está disponible (caso anterior).
	public Creador buscarCreador(String email) 
	{	
		Creador creadorEncontrado = null;
		
		for(Creador creadorIterado: this.listaCreadores) 
		{
			if(creadorIterado.getEmail().equals(email)) 
			{
				creadorEncontrado = creadorIterado;
			}
		}
		
		return creadorEncontrado; //Retornará al creador o null. Depende si se cumplió el if en el bucle foreach.
	}
	
	
	public boolean registrarCanal(String emailCreador, String nombreCanal) 
	{
		Creador creador = buscarCreador(emailCreador);
		
		if(creador != null) 
		{
			System.out.println("Canal registrado correctamente.");
			boolean nuevoCanal = creador.registrarCanal(nombreCanal);
			return nuevoCanal; //True
		}
		
		System.out.println("No se pudo registrar el canal ya que no se encontró su email.");
		return false;
	}
	
	
	 // Método para iniciar una transmisión
    public boolean iniciarTransmision(String emailCreador, String nombreCanal) 
    {
        Creador creador = buscarCreador(emailCreador);
        
        if (creador != null) 
        {
            return creador.iniciarTransmision(nombreCanal);
        }
        
        return false; // No se puede iniciar una transmisión si el creador no existe
    }

    // Método para detener una transmisión
    public boolean detenerTransmision(String emailCreador, String nombreCanal) 
    {
        Creador creador = buscarCreador(emailCreador);
        
        if (creador != null) 
        {
            return creador.detenerTransmision(nombreCanal);
        }
        return false; // No se puede detener una transmisión si el creador no existe
    }
	
    public RESULTADO cambiarNombreUsuario(String emailCreador, String nuevoNombre) 
    {
    	Creador creador = buscarCreador(emailCreador);
    	
    	if(creador != null) //Si encontamos un creador con este email, le cambiamos su nombre
    	{
    		return creador.cambiarNombreUsuario(nuevoNombre);
    	}
    	
    	System.out.println("No existe ningún creador con este mail");
    	return RESULTADO.CREADOR_INEXISTENTE;
    }
    
	
}
