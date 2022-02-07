
public class Lector extends Thread 
{
	BaseDatos bd;
	int numero;
	int numpuerta;
	
	public Lector( BaseDatos bd, int numero)
	{
		this.bd = bd;
		this.numero = numero;
	}
	
	public void run()
	{								
		try
		{
			bd.leer(numero);
			//el sleep simepre que se pueda fuera del metodo sincronizado
			Thread.sleep((int)(Math.random() * 50) );
			
			bd.fin_leer(numero);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	} 
} 