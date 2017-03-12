package game;

public class Bombe extends Sprite {
	int temps, tailleExplosion;
	
	public Bombe(int tailleExplosion)
	{
		this.temps = 4;
		this.tailleExplosion = tailleExplosion;	
	}
	
	public void diminuerTemps()
	{
		this.temps--;
	}
	
	public int getTemps()
	{
		return this.temps;
	}
	
	public int getTailleExplosion()
	{
		return tailleExplosion;
	}
}
