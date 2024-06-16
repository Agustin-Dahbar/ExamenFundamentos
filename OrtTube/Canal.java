package OrtTube;


public class Canal 
{
	private String nombre;
	private boolean estaEnVivo;
	
	public Canal(String nombre) 
	{
		this.nombre = nombre;
		this.estaEnVivo = false;
	}

	
	public boolean iniciarTransmision() 
	{
		if(!this.estaEnVivo) 
		{
			System.out.println("Iniciando transmisión..");
			this.estaEnVivo = true;
			return true;
		}
		
		return false; 
	}
	
	public boolean detenerTransmision() 
	{
		if(this.estaEnVivo) 
		{
			System.out.println("Deteniendo transmision..");
			this.estaEnVivo = false;
			return true;
		}
		
		return false;
	}
	
	//Getters: 
	//Getter del nombre que usaremos en el mismo metodo principal en la línea 36.
	public String getNombre() 
	{
		return this.nombre;
	}
	
	//Metodo usado en el metodo principal (obtenerCanalesEnVivo) de la clase Creador (línea 34)
	public boolean estaEnVivo() 
	{
		return this.estaEnVivo;
	}

	
	//ToString();
	@Override
	public String toString() 
	{
		return "Canal: " + this.nombre  + " esta en directo? " + this.estaEnVivo;
	}
}
