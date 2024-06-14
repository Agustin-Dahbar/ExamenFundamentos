package ParcialFundamentos;

public class Usuario 
{
	private String dni;
	private String nombreCompleto;
	private boolean isCuotaPaga; 
	
	//Getter del dni. (Usado en metodo reservarServicio en clase CowOrtking;
	public String getDni() 
	{
		return this.dni;
	}
	
	//Getter del atributo 3 necesitado en el metodo secundario calcular importe de la clase CowORTking (línea 112).
	public boolean getIsCuotaPagada() 
	{
		return this.isCuotaPaga;
	}
	
}
