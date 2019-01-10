package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner input = new Scanner(System.in);
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = input.nextInt();
		System.out.print("Check-in date: (dd/mm/yyyy) ");
		Date checkIn = date.parse(input.next());
		System.out.print("Check-out date: (dd/mm/yyyy) ");
		Date checkOut = date.parse(input.next());
		
		if(!checkOut.after(checkIn)) {
			
			System.out.println("Error id reservation: Check-out date must be after check-in date.");
			
		}
		else {
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date: (dd/mm/yyyy) ");
			checkIn = date.parse(input.next());
			System.out.print("Check-out date: (dd/mm/yyyy) ");
			checkOut = date.parse(input.next());
			
				
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {	
				System.out.println("Reservation: " + reservation);
			}		
						
		}
		
		input.close();

	}

}
