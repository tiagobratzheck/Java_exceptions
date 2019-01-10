package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = input.nextInt();
			System.out.print("Check-in date: (dd/mm/yyyy) ");
			Date checkIn = date.parse(input.next());
			System.out.print("Check-out date: (dd/mm/yyyy) ");
			Date checkOut = date.parse(input.next());
			
			
				
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date: (dd/mm/yyyy) ");
			checkIn = date.parse(input.next());
			System.out.print("Check-out date: (dd/mm/yyyy) ");
			checkOut = date.parse(input.next());
			
				
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
				
		
		input.close();

	}

}
