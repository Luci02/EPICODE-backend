package com.epicode.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
	
	static List<Product> catalogoProdotti = new ArrayList<Product>();
	static List<Customer> customersList = new ArrayList<Customer>();
	static List<Order> listaOrdini = new ArrayList<Order>();
	
	public static void main(String[] args) {

		addProducts();
		addCustomers();
		addOrders();
		
//		Esercizio #1
		List<Product> BooksOver100 = BooksOver100();
		
		for (Product product : BooksOver100) {
			System.out.println(product);
		}
		
//		Esercizio #2
		List<Order> filteredOrderList = new ArrayList<Order>();
		filteredOrderList = listaOrdini
				.stream()
				.filter(currentOrder -> currentOrder
											.getProducts()
											.stream()
											.anyMatch( p -> p
													.getCategory().
													equalsIgnoreCase("baby")
				)
						)
				.collect(Collectors.toList());
		
		for (Order o : filteredOrderList) {
			System.out.println( o );
		}
		
//		Esercizio #3
		List<Product> boysProducts = catalogoProdotti
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("boys"))
				.map( p -> {
					p.setPrice( 0.5 );
					return p;
				})
				.collect(Collectors.toList());
		
		for (Product product : boysProducts) {
			System.out.println( product );
		}
		
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
	
	private static void addCustomers() {
		customersList.add(new Customer(1, "Mario Rossi", 1));
		customersList.add(new Customer(2, "Luigi Verdi", 2));
		customersList.add(new Customer(3, "Marco Bianchi", 2));
	}
	
	private static List<Product> BooksOver100() {
		List<Product> s = catalogoProdotti.stream()
								.filter(currentProduct -> currentProduct.getPrice() > 100 && currentProduct.getCategory() == "Books")
								.collect(Collectors.toList());
		return s;
	}

	private static void addOrders() {
		
		listaOrdini.add(new Order(
				1, 
				"Ordinato", 
				LocalDate.of(2023, 7, 1), 
				Arrays.asList( catalogoProdotti.get(2) ),
				customersList.get(0)
				)
		);
		
		listaOrdini.add(
				new Order(
					2, 
					"Evaso", 
					LocalDate.of(2022, 11, 30), 
					catalogoProdotti, 
					customersList.get( 1 ) 
					)
		);
		
		listaOrdini.add(
				new Order(
					3, 
					"In Consegna", 
					LocalDate.of(2023, 6, 5), 
					catalogoProdotti
						.stream()
						.filter( e -> e.getCategory().equalsIgnoreCase("baby") )
						.collect(Collectors.toList()), 
					customersList.get( 2 ) 
					)
		);
	
	}

	
	
}