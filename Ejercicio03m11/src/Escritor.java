
public class Escritor extends Thread 
{
	BaseDatos bd;
	int numero;
	int numpuerta;
	
	public Escritor( BaseDatos bd, int numero)
	{
		this.bd = bd;
		this.numero = numero;
	}
	
	public void run()
	{								
		try
		{
			bd.escribir(numero);
			//el sleep simepre que se pueda fuera del metodo sincronizado
			Thread.sleep((int)(Math.random() * 80) );
			
			bd.fin_escribir(numero);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	} 
} 