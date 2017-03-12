package game;

public class Terrain {

	Object[][] matrice;
	
	public Terrain(int x, int y)
	{
		matrice = new Object[x][y];
		System.out.println(matrice.length + " " + matrice[x-1].length);
		
	}
	
	public void generer()
	{
		// Géneration des murs haut et bas
		for(int y = 0; y < matrice[0].length; y++)
		{
			matrice[0][y] = new MurSolide();
			matrice[matrice.length-1][y] = new MurSolide();
		}
		
		// Géreration des murs gauche et droit
		for(int i = 1; i < matrice.length - 1; i++)
		{
			matrice[i][0] = new MurSolide();
			for(int y = 1; y < matrice[i].length - 1; y++)
			{
				matrice[i][y] = "V";
			}
			matrice[i][matrice[0].length-1] = new MurSolide();
		}
		
		// Géneration des murs destructibles
		int nbMur = (matrice[0].length - 2) * (matrice.length -2) / 2; 
	}
	
	public String toString()
	{
		String str = "";
		for(int i = 0; i < matrice.length; i++)
		{
			for(int y = 0; y < matrice[i].length; y++)
			{
				if(matrice[i][y].equals("V"))
				{
					str += " ";
				}
				else
				{
					str += matrice[i][y];
				}
				str += " ";
			}
			str += "\n";
		}
		return str;
	}

	
	
}
