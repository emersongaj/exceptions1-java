package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {   //Portanto o m�todo main pode lan�ar a exce��o do Tipo ParseException
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.print("Room Number:");
		int number = sc.nextInt();
		System.out.print("Chek-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); //o parse � uma chamada que pode lan�ar uma exce��o. O compilador reclama para tratarmos essa
											 //exce��o ou propagamos (dizer que ela vai ser lan�ada para outros m�todos at� que encontre um trycatch ou at� que ela n�o tenha mais pra onde ir) essa exce��o no m�todo onde est�, que no caso � o main
		System.out.print("Chek-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//Instanciar a reserva. Obs: N�o pode ser instanciada se a data de checkout n�o for posterior a data de checkin
		
		//Date tem um m�todo chamado after
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after Check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkOut, checkIn);
			System.out.println("Reservation: " + reservation); //chama implicitamente o toString, caso n�o tenha implementado o toString, ele apareceria assim model.entities.Reservation@54a097cc
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//delegamos o teste l�gico dos erros para a classe Reservation
			String error = reservation.updateDates(checkIn, checkOut); //j� que o m�todo retorna um String, esse error vai dizer se houve erro ou n�o
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
			System.out.println("Reservation: " + reservation);
			}
						
		}
			
		sc.close();

	}
	/*Colocar no github
	 
	 
	 
	 

	 */
}



