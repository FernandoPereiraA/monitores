
public class Principal 
{
	public static void main( String [] args )
	{	
		BaseDatos bd = new BaseDatos();
		
		Lector lector;	
		
		Escritor escritor;
		
		int y = 1;
		//se intercalan los escritores entre los lectores
		//se crean dos lectores y un escritor
		for(int x = 1; x <= 10; x++)
		{			
			if(x % 2 == 1)
			{
				escritor = new Escritor(bd, y);
				 
				escritor.start();
				
				y++;
			}
			
			lector = new Lector(bd, x);
			 
			lector.start();
		}		
	} 
}