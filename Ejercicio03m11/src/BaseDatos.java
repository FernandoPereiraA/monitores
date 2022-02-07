
public class BaseDatos 
{
	private int lectores = 0;
	private int escritores = 0;
	//llamdo por los lectores
	public synchronized void leer(int numero)
	{
		String nombre = "El Lector " + numero ;
		// no puede haber escritores para leer
		while( escritores > 0)
		{
			try
			{		
				//si hay escritores espera
				System.out.println("-----------" + nombre + " ESPERA PARA LEER.------------");

				wait();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}			
		}		
		
		lectores++;
		
		System.out.println(nombre + " LEE.");
		
	}
	//llamdo por los lectores cuando acaban de leer
	public synchronized void fin_leer(int numero)
	{
		lectores--;
		
		System.out.println("El Lector " + numero  + " YA HA LEIDO.");
		//avisa a todos los hilos para verificar condicion
		notifyAll();
	}
	//llamado por los escritores cuando intentan escribir
	public synchronized void escribir(int numero)
	{
		String nombre = "El Escritor " + numero ;
		//no puede haber ni lectores ni escritores
		while( lectores > 0 || escritores > 0)
		{
			try
			{		
				//si hay lectores o escritores espera
				System.out.println("-----------" + nombre + " ESPERA PARA ESCRIBIR.------------");

				wait();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		escritores++;
		
		System.out.println(nombre + " ESCRIBE.");
	}
	//llanado escritores cuando acaban de escribir
	public synchronized void fin_escribir(int numero)
	{
		escritores--;
		
		System.out.println("El Escritor " + numero  + " YA ESCRIBIO.");
		//avisa a todos los hilos para verificar condicion
		notifyAll();
	}
	
}
