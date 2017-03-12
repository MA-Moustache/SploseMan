package game;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y;
		Terrain jeu;
		String move;
		
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
		
		do
		{
			System.out.println("Déplacez vous (Z Q S D ou autre pour rester sur place): ");
			move = scan.next();
			
			switch(move.toLowerCase())
			{
				case "z" :
					jeu.moveJoueur(-1, 0);
					break;
				case "q" :
					jeu.moveJoueur(0, -1);
					break;
				case "s" :
					jeu.moveJoueur(1, 0);
					break;
				case "d" :
					jeu.moveJoueur(0, 1);
					break;
				default :
					break;
			}
			
			jeu.refresh();
			System.out.println(jeu.toString());
			
		}while(jeu.getJoueur().getIsAlive());
			
	}

}
