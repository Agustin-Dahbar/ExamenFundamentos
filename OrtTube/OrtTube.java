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
	
	//3er metodo principal.
	public void verCanalesEnVivo(ArrayList<Creador> listaCreadores)
	{
		for(Creador creadorIterado: this.listaCreadores) //Iteramos por todos los creadores, obtenemos sus canales que estén transmitiendo en vivo.
		{
			System.out.println(creadorIterado.obtenerCanalesEnVivo()); //Metodo que devuelve una ArrayList<String>
		}
	}
}
