package OrtTube;

public class Test 
{
	public static void main(String[] args) 
	{
		OrtTube ortTube = new OrtTube();
		
		Creador agustin = new Creador("Agustin", "agustindahbar@hotmail.com");
		System.out.println(agustin);
        
        System.out.println(agustin.cambiarNombreUsuario("Agustin Dahbar"));
        
        System.out.println(agustin);
        
        agustin.registrarCanal("AgustinDirectos"); //Creamos un canal a agustin
        
        System.out.println(agustin.getListaCanales()); //Mostramos la lista de canales de agustin.
        
        // Obtener el nombre del canal que recién registramos
        String canalAgustin = agustin.getListaCanales().get(0).getNombre(); // Suponiendo que es el primer canal en la lista

        // Iniciar la transmisión del canal
        boolean inicioExitoso = agustin.iniciarTransmision(canalAgustin);
        
        if (inicioExitoso) 
        {
            System.out.println("Se inició la transmisión en el canal " + canalAgustin);
        } 
        else 
        {
            System.out.println("No se pudo iniciar la transmisión en el canal " + canalAgustin);
        }
        
    }
}
