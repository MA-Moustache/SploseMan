package game;

public class Joueur extends Sprite {

	private int posX;
	private int posY;
	private boolean isAlive;
	
	public Joueur(int x, int y)
	{
		this.forme = "X";
		this.posX = x;
		this.posY = y;
		this.isAlive = true;
	}
	
	public int getX()
	{
		return this.posX;
	}
	
	public int getY()
	{
		return this.posY;
	}
	
	public void setPosX(int x)
	{
		this.posX += x;
	}
	
	public void setPosy(int y)
	{
		this.posY += y;
	}
	
	public boolean getIsAlive()
	{
		return this.isAlive;
	}
}
