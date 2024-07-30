package funcao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class Program {

	public static void main(String[] args) {
		
		// PROGRAMAÇÃO FUNCIONAL: FUNCTION E EXPRESSÃO LAMBIDA
		
		List<Product> list = new ArrayList<>();         //OBS:.stream() não cria uma nova lista, 
		list.add(new Product("Tv", 900.00));            // e sim altera cada elemento da coleçao
		list.add(new Product("Mouse", 50.00));          //conservando os dados originais da coleção
		list.add(new Product("Tablet", 350.50));        //é preciso criar uma nova coleção para 
		list.add(new Product("HD Case", 80.90));        // receber estes dados alterados.
		
		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList()); 
		/* função map() aplica uma função a cada elemento da de list através da .stream().
		 * .stream() irá processar a coleção usando a função map(),
		 * que aplicará new UpperCaseName(),convertendo as Strings em letras maiusculas,  
		 * .collect(collectors.toList()) converterá novamente em uma nova coleção, 
		 * onde a variavel 
		 * names que é uma List receberá esta nova coleção transformada.  */
		   
		   names.forEach(System.out:: println);
		
		System.out.println("");
		
		/*REFERENCIA COM MÉTODO STATICO*/
		   List<String> nomes = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		     nomes.forEach(System.out:: println);
		       System.out.println("");
		
		 /*REFERENCIA COM MÉTODO NÃO STATICO*/
			List<String> nonbres = list.stream().map(Product::nonstaticUpperCaseName).collect(Collectors.toList());
			  nonbres.forEach(System.out:: println);
			    System.out.println("");
	    
	     /*EXPRESSÃO LAMBIDA DECLARADA*/
			  Function<Product, String> func = p -> p.getName().toUpperCase();
			   List<String> lista = list.stream().map(func).collect(Collectors.toList());
			    lista.forEach(System.out:: println);
			     System.out.println("");
			    
		 /*EXPRESSÃO LAMBIDA INLINE*/
			  Function<Product, String> funcio = p -> p.getName().toUpperCase();
			    List<String> objeto = list.stream().map( p -> p.getName().toUpperCase()).collect(Collectors.toList());
				  objeto.forEach(System.out:: println);
				    System.out.println("");
				  
	}
	
	/* 
	 * -SAÍDA-
	 *TV
	 *MOUSE
	 *TABLET
     *HD CASE
       */
}
