package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {  //tiramos a exceção propagada, pois vamos tratá-la 
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {  //todo o código dentro do try
			System.out.print("Room Number:");
			int number = sc.nextInt();
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); //o parse é uma chamada que pode lançar uma exceção. O compilador reclama para tratarmos essa
												 //exceção ou propagamos (dizer que ela vai ser lançada para outros métodos até que encontre um trycatch ou até que ela não tenha mais pra onde ir) essa exceção no método onde está, que no caso é o main
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			//Instanciar a reserva. Obs: Não pode ser instanciada se a data de checkout não for posterior a data de checkin
			
			Reservation reservation = new Reservation(number, checkOut, checkIn);
			System.out.println("Reservation: " + reservation); //chama implicitamente o toString, caso não tenha implementado o toString, ele apareceria assim model.entities.Reservation@54a097cc
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
		
			reservation.updateDates(checkIn, checkOut); //agora o método updateDates não vai mais retornar uma string com msg de erro. Vamos lançar uma exceção caso ocorra
			System.out.println("Reservation: " + reservation);
		} //abaixo vamos tratar as possíveis exceções do program
		
		catch(ParseException e)	{
			System.out.println("Invalid date format");
		}
		catch(DomainException e)	{
			System.out.println("Error in reservation: " + e.getMessage());  
		}
		catch(RuntimeException e)	{   //qualquer outra exceção, exemplo, entrar com string no número do quarto
			System.out.println("Unexpected error");  
		}
		
		
		sc.close();
		/*
		 * Colocar no github
		 * 
		 * Comandos: git status //verifica se tem alguma mudança no stagend pra ser
		 * commitada (aparece em vermelho o que foi modificado) git add . //jogar na
		 * área de staged git commit -m "Bad Solution" git push //jogar no github
		 * 
		 * 
		 * 
		 * 
		 */
		
	}
}

