package com.epicode.main.project.classes;

public class RegistrazioneAudio extends ElementoRiproducibile {

	public RegistrazioneAudio(String titolo, int durata) {
		super(titolo, durata);
	}

	@Override
	public void play() {
		
		for (int i = 0; i < this.durata; i++) {
			System.out.println(this.getTitolo() + " " + "!".repeat(this.volume));
		}
		System.out.println();
	}

}
