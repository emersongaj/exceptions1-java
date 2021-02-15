package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {  //tiramos a exce��o propagada, pois vamos trat�-la 
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {  //todo o c�digo dentro do try
			System.out.print("Room Number:");
			int number = sc.nextInt();
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); //o parse � uma chamada que pode lan�ar uma exce��o. O compilador reclama para tratarmos essa
												 //exce��o ou propagamos (dizer que ela vai ser lan�ada para outros m�todos at� que encontre um trycatch ou at� que ela n�o tenha mais pra onde ir) essa exce��o no m�todo onde est�, que no caso � o main
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			//Instanciar a reserva. Obs: N�o pode ser instanciada se a data de checkout n�o for posterior a data de checkin
			
			Reservation reservation = new Reservation(number, checkOut, checkIn);
			System.out.println("Reservation: " + reservation); //chama implicitamente o toString, caso n�o tenha implementado o toString, ele apareceria assim model.entities.Reservation@54a097cc
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
		
			reservation.updateDates(checkIn, checkOut); //agora o m�todo updateDates n�o vai mais retornar uma string com msg de erro. Vamos lan�ar uma exce��o caso ocorra
			System.out.println("Reservation: " + reservation);
		} //abaixo vamos tratar as poss�veis exce��es do program
		
		catch(ParseException e)	{
			System.out.println("Invalid date format");
		}
		catch(DomainException e)	{
			System.out.println("Error in reservation: " + e.getMessage());  
		}
		catch(RuntimeException e)	{   //qualquer outra exce��o, exemplo, entrar com string no n�mero do quarto
			System.out.println("Unexpected error");  
		}
		
		
		sc.close();
		/*
		 * Colocar no github
		 * 
		 * Comandos: git status //verifica se tem alguma mudan�a no stagend pra ser
		 * commitada (aparece em vermelho o que foi modificado) git add . //jogar na
		 * �rea de staged git commit -m "Bad Solution" git push //jogar no github
		 * 
		 * 
		 * 
		 * 
		 */
		
	}
}

