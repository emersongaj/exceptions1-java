package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkOut;
	private Date checkIn;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
		this.roomNumber = roomNumber;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckOut() {
		return checkOut;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	//m�todos
	
	public long duration() {    //getTime retorna em milisegundos (tipo long)
		long diff = checkOut.getTime() - checkIn.getTime();
		//convertendo milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {  //m�todo volta a ser void
		
		//agora caso ocorra algum erro, vamos lan�ar uma exce��o (n�o vai retornar nada)
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)){
			throw new IllegalArgumentException("Error in reservation: Reservation dates for update must be future dates"); //essa exce��o � quando os argumentos que passamos para o m�todo s�o inv�lidos
		}
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Error in reservation: Check-out date must be after Check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
		
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
	            + ", check-out: "
	            + sdf.format(checkOut)
	            + ", "
	            + duration()
	            + " nigths";
	
	}

}
