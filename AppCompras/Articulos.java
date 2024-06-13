package AppCompras;

public class Articulos 
{
	private String nombre;
	private int cantidad;
	
	public Articulos(String nombre, int cantidad) 
	{
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
	public int getCantidad() 
	{
		return this.cantidad;
	}
	
	public void setCantidad(int cantidadNueva) 
	{
		this.cantidad = cantidadNueva;
	}
}
