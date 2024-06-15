package OrtTube;


public class Canal 
{
	private String nombre;
	private boolean estaEnVivo;
	
	public Canal(String nombre, boolean estaEnVivo) 
	{
		this.nombre = nombre;
		this.estaEnVivo = estaEnVivo;
	}
	
	//Metodo usado en el metodo principal (obtenerCanalesEnVivo) de la clase Creador (línea 34)
	public boolean estaEnVivo() 
	{
		return this.estaEnVivo;
	}
	
	//Getter del nombre que usaremos en el mismo metodo principal en la línea 36.
	public String getNombre() 
	{
		return this.nombre;
	}
	
}
