package com.epicode.main.project;

import java.util.Scanner;

import com.epicode.main.project.classes.ElementoMultimediale;
import com.epicode.main.project.classes.Immagine;
import com.epicode.main.project.classes.RegistrazioneAudio;
import com.epicode.main.project.classes.Video;

public class LettoreMultimediale {
	
	
	

	public static void main(String[] args) {
		
		ElementoMultimediale[] elementsList = new ElementoMultimediale[5];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < elementsList.length; i++) {
			System.out.println("Premi 1 per creare una registrazione audio.");
			System.out.println("Premi 2 per creare un video.");
			System.out.println("Premi 3 per creare un immagine. \n");
			
			System.out.print(">>> ");
			int scelta = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch (scelta) {
			
			case 1:
				{
					System.out.println("Inserisci il titolo della registrazione:");
					System.out.print(">>> ");
					String titolo = sc.nextLine();
					System.out.println();
					
					System.out.println("Inserisci la durata della registrazione:");
					System.out.print(">>> ");
					int durata = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					elementsList[i] = new RegistrazioneAudio(titolo, durata);
					
					break;
				}
			
			case 2:
				{
					System.out.println("Inserisci il titolo del video:");
					System.out.print(">>> ");
					String titolo = sc.nextLine();
					System.out.println();
					
					System.out.println("Inserisci la durata del video:");
					System.out.print(">>> ");
					int durata = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					elementsList[i] = new Video(titolo, durata);
					
					break;
				}
			
			case 3:
				{
					System.out.println("Inserisci il titolo dell\'immagine:");
					System.out.print(">>> ");
					String titolo = sc.nextLine();
					
					elementsList[i] = new Immagine(titolo);
					System.out.println();
					
					break;
				}

			default:
				System.out.println("ERRORE!!!\n");
				break;
			}
			
		}
		
		int sceltaRiproduzione;
		while(true) {
			
			System.out.println("Scrivi un numero da 1 a 5 per scegliere quale risorsa eseguire. Inserisci 0 per uscire.");
			System.out.print(">>> ");
			sceltaRiproduzione = sc.nextInt();
			int s = sceltaRiproduzione - 1;
			sc.nextLine();
			System.out.println();
			
			if(sceltaRiproduzione == 0) {
				break;
			}
			
			if (elementsList[s] instanceof RegistrazioneAudio) {
				RegistrazioneAudio r = (RegistrazioneAudio) elementsList[s];
				r.play();
			}else if( elementsList[s] instanceof Video ) {
				Video v = (Video) elementsList[s];
				v.play();
			}else {
				Immagine a = (Immagine) elementsList[s];
				a.show();
			}
			
		}

	}

}
