package game;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y;
		Terrain jeu;
		
		do
		{
			
			System.out.println("Sélectionnez la longueur du terrain (>5): ");
			x = scan.nextInt();
			
		}while(x <= 5);
		
		do
		{
			
			System.out.println("Sélectionnez la largeur du terrain (>5): ");
			y = scan.nextInt();
			
		}while(y <= 5);
		
		jeu = new Terrain(y, x);
		jeu.generer();
		System.out.println(jeu.toString());
	}

}
