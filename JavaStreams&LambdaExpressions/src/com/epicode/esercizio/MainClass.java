package com.epicode.esercizio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
	
	static List<Product> catalogoProdotti = new ArrayList<Product>();
	
	public static void main(String[] args) {
		
		addProducts();
		
//		Esercizio #1
		List<Product> BooksOver100 = BooksOver100();
		
		for (Product product : BooksOver100) {
			System.out.println(product);
		}
		
//		Esercizio #2
		
	}
	
	private static void addProducts() {
		catalogoProdotti.add(new Product(1, "La banda dei carusi", "Books", 17.57));
		catalogoProdotti.add(new Product(2, "Dieci cose che ho imparato", "Books", 18.05));
		catalogoProdotti.add(new Product(3, "The legend of Zelda: Tears of the Kingdom. La guida ufficiale completa. Edizione da collezione", "Books", 33.24));
		catalogoProdotti.add(new Product(4, "Berlinetta Boxer. The legend. Ediz. italiana", "Books", 185.25));
		catalogoProdotti.add(new Product(5, "Harry Potter. La serie completa. Edizione Tassofrasso", "Books", 122.55));
		catalogoProdotti.add(new Product(6, "Harry Potter. La serie completa. Edizione Corvonero", "Books", 122.55));
		catalogoProdotti.add(new Product(7, "Harry Potter. La serie completa. Edizione Serpeverde", "Books", 122.55));
		catalogoProdotti.add(new Product(8, "Harry Potter. La serie completa. Edizione Grifondoro", "Books", 122.55));

		catalogoProdotti.add(new Product(9, "Passeggino", "Baby", 118));
		catalogoProdotti.add(new Product(10, "Seggiolino per Auto", "Baby", 219));
		catalogoProdotti.add(new Product(11, "Girelli Per Bambini", "Baby", 76.95));
		
		catalogoProdotti.add(new Product(12, "Casco Jet Demi Jet FGTR CLASSIC - MOMO DESIGN", "Boys", 179.95));
		catalogoProdotti.add(new Product(13, "RPHA 11 CARBON LINEA RPHA - HJC", "Boys", 579.90));
		catalogoProdotti.add(new Product(14, "Giacca estiva T-GP PLUS RV2 AIR - ALPINESTARS", "Boys", 189.95));
	}
	
	private static List<Product> BooksOver100() {
		List<Product> s = catalogoProdotti.stream()
								.filter(currentProduct -> currentProduct.getPrice() > 100 && currentProduct.getCategory() == "Books")
								.collect(Collectors.toList());
		return s;
	}

}