package ParcialFundamentos;

public class Usuarios 
{
	private String dni;
	private String nombreCompleto;
	private boolean pagoCuota; 
	
	//Getter del dni. (Usado en metodo reservarServicio en clase CowOrtking;
	public String getDni() 
	{
		return this.dni;
	}
}
