package game;

import java.util.Random;

public class Terrain {

	Object[][] matrice;
	Random rand = new Random();
	
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
		int a, b;
		while(nbMur > 0)
		{
			a = rand.nextInt(matrice.length - 1) + 1;
			b = rand.nextInt(matrice[0].length -1) + 1;
			
			if(matrice[a][b].equals("V"))
			{
				matrice[a][b] = new MurFragile();
				nbMur--;
			}

		}
		
		// Géneration du joueur
		matrice[1][1] = new Joueur();
		matrice[1][2] = "V";
		matrice[2][1] = "V";
	}
	
	public void refresh()
	{
		// Diminution du temps des bombes par 1
		for(int i = 1; i < matrice.length - 1; i++)
		{
			for(int y = 1; y < matrice[i].length - 1; y++)
			{
				if(matrice[i][y] instanceof Bombe)
				{
					Bombe b = (Bombe)matrice[i][y];
					if(b.getTemps() > 0)
					{
						b.diminuerTemps();
						matrice[i][y] = b;
					}
					else
					{
						exploser(i, y, b.getTailleExplosion());
					}
				}
			}
		}
	}
	
	public void exploser(int i, int y, int ex)
	{
		// Géneration des explosions (centrales + collatérales)
		matrice[i][y] = new Explosion();
		
		for(int a = 0; a < ex; a++)
		{
			if(y+a < matrice[0].length - 1)
			{
				matrice[i][y+a] = new Explosion();
			}
			if(y-a > 0)
			{
				matrice[i][y-a] = new Explosion();				
			}
			if(i+a < matrice.length - 1)
			{
				matrice[i+a][y] = new Explosion();
			}
			if(i-a > 0)
			{
				matrice[i-a][y] = new Explosion();
			}
		}
		
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
