package AppCompras;
import java.util.ArrayList;
import java.util.Scanner;

public class VoyDeCompras 
{
	private ArrayList<Negocios> listaNegocio;
	private ArrayList<Articulos> listaArticulos;
	
	//ArrayList<Articulo> listaCompras;
    //ArrayList<Articulo> listaComprados;
	
	public VoyDeCompras(ArrayList<Negocios> negocio, ArrayList<Articulos> articulo) 
	{
		this.listaNegocio = negocio; 
		this.listaArticulos = articulo;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void cargarArticuloAcomprar(String nombreArticulo, int cantidad) 
	{
		while(nombreArticulo.equals("")) 
		{
			System.out.println("El articulo a comprar no puede estar vacio. Reingresalo");
			nombreArticulo = scanner.nextLine();
		}
		
		while(!(cantidad > 0)) 
		{
			System.out.println("La cantidad debe ser mayor a 0. Reingresala.");
			cantidad = scanner.nextInt();
		}
		
		//Ya con ambos parametros correctos procedemos a cargar el artículo.
		//Recorremos todos los articulos 
		for(Articulos articulo: listaArticulos) 
		{
			//Y comprobamos si el producto recibido ya esta en la lista, si lo está solo aumentamos la cantidad.
			if(articulo.getNombre().equals(nombreArticulo)) 
			{
				int cantidadActual = articulo.getCantidad();
				int cantidadActualizada = cantidadActual + cantidad;
				articulo.setCantidad(cantidadActualizada);
				System.out.println("Artículo ya cargado previamente. Solo cargaremos la cantidad recibida.");
				
			}
		}
		//Si el artículo no está en la lista de compras, lo agregamos..
		listaArticulos.add(new Articulos(nombreArticulo, cantidad));
		
		
	}
}
