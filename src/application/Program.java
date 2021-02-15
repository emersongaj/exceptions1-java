package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {   //Portanto o método main pode lançar a exceção do Tipo ParseException
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.print("Room Number:");
		int number = sc.nextInt();
		System.out.print("Chek-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); //o parse é uma chamada que pode lançar uma exceção. O compilador reclama para tratarmos essa
											 //exceção ou propagamos (dizer que ela vai ser lançada para outros métodos até que encontre um trycatch ou até que ela não tenha mais pra onde ir) essa exceção no método onde está, que no caso é o main
		System.out.print("Chek-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//Instanciar a reserva. Obs: Não pode ser instanciada se a data de checkout não for posterior a data de checkin
		
		//Date tem um método chamado after
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after Check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkOut, checkIn);
			System.out.println("Reservation: " + reservation); //chama implicitamente o toString, caso não tenha implementado o toString, ele apareceria assim model.entities.Reservation@54a097cc
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Chek-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)){
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after Check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			
			}
			
		}
			
		sc.close();

	}

}
