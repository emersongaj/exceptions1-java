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

	//métodos
	
	public long duration() {    //getTime retorna em milisegundos (tipo long)
		long diff = checkOut.getTime() - checkIn.getTime();
		//convertendo milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {  //não vai ser mais void, vai retornar uma String (msg de erro)
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)){
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after Check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;  //método pedi pra retornar alguma string, no caso de não der nenhuma das mensagens acima vamos retornar nulo dizendo que não deu nenhum erro
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
