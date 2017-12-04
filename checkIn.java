import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Date;
import javax.swing.JOptionPane;

public class checkIn
{
	static Scanner input, mayora = new Scanner( System.in );;
	static Formatter output;
	static File f1, f2;
	static double day = 0, price =0 , service = 0, c = 0; 
	static int ctr = 1, found = 0, RNum = 0, berting;
	static String roomClass;
	static hotelReservationSystem mainMenu = new hotelReservationSystem();
	static boolean service1, service2, service3;
	
	public void openFile()
	{
		try
		{
		 	input = new Scanner( new File( "Clients.dat" ) );
		 	output = new Formatter( "Temp.dat" );
		 	
		 	f1 = new File( "Clients.dat" );
		 	f2 = new File( "Temp.dat" );
		}
		catch ( FileNotFoundException fileNotFoundException )
		{
			 System.err.println( "Error opening file." );
			 System.exit( 1 );
		}
		catch ( SecurityException securityException )
		{
			 System.err.println(
			 "You do not have write access to this file." );
			 System.exit( 1 );
		}
	}
	 
	static void checkIn()
	{
			service1 = false;
			service2 = false;
			service3 = false;
		clientRecord record = new clientRecord();
		
		try
		{
			while(input.hasNext() )
			{
				record.setFname( input.next() );
				record.setLname( input.next() );
				record.setContact( input.next() );
				record.setRNum( input.nextInt() );
					
				output.format( "\n%s %s %s %d\n", record.getFname(),
				record.getLname(), record.getContact(), record.getRNum() );
			}
		
			System.out.print("Enter First Name: ");
			String Fname = mayora.next();
			System.out.print("Enter Last Name: ");
			String Lname = mayora.next();
			System.out.print("Contact No.: ");
			while( !mayora.hasNext()){
				JOptionPane.showMessageDialog(null ,"Invalid Input!");
			System.out.print("Contact No.: ");
				mayora.next();
			}
			String  contact = mayora.next();
			clear();
			System.out.println("\nO============== R O O M   C L A S S ===========O\n");
			System.out.println("First Class 	Rooms 1 to 20	  Php 5000/day");
			System.out.println("Second Class 	Rooms 21 to 60	  Php 2500/day");
			System.out.println("Third Class 	Rooms 61 to 120	  Php 1000/day");
    		System.out.println("\nO=======================O======================O");
    		
			System.out.print("Enter Room Number: ");
			while( !mayora.hasNextInt()){
				JOptionPane.showMessageDialog(null ,"Invalid Room Number!");
				System.out.print("Enter Room Number: ");
				mayora.next();
			}
			int RNum = mayora.nextInt();
			while(input.hasNext() )
			{
				record.setFname( input.next() );
				record.setLname( input.next() );
				record.setContact( input.next() );
				record.setRNum( input.nextInt() );
				
				if( record.getRNum() == RNum )
				{
					JOptionPane.showMessageDialog(null ,"Room not available!!");
					mainMenu.choose();
				}
			}
			if ( RNum < 21 && RNum > 0){
				price = 5000;
				roomClass = "First Class";
			}
			else if ( RNum < 61 && RNum > 20){
				price = 2500;
				roomClass = "Second Class";
			}
			else if ( RNum < 121 && RNum > 60){
				price = 1000;
				roomClass = "Third Class";
			}
			else
			{
				JOptionPane.showMessageDialog(null ,"Invalid Room Number!");
				clear();
				mainMenu.choose();
			}
			System.out.print("Enter days of stay: ");
			while( !mayora.hasNextInt()){
				JOptionPane.showMessageDialog(null ,"Invalid input!");
				System.out.print("Enter days of stay: ");
				mayora.next();
			}
			day = mayora.nextInt();
			clear();
			c = addService();
			price = price + c;
			price = price * day;
			clear();
			System.out.println("\nO====== R E S E R V A T I O N   I N F O =======O\n");
			System.out.println("\nClient Name: 	" + Fname + " " + Lname);
			System.out.println("Room Class: 	" + roomClass);
			System.out.println("Room No.: 	" + RNum);
			System.out.println("Contac No. : 	" + contact);
			System.out.println("\nAcquired Services");
			System.out.println("	Massage Service :	" + service1);
			System.out.println("	Food Service :		" + service2);
			System.out.println("	Extra Bed Service :	" + service3);
			System.out.printf("\nDays of stay: 	%.0f" , day);
			System.out.println("\nO=======================O======================O");
			System.out.println("T O T A L : 				" + price);
			System.out.println("O=======================O======================O");
			
			output.format( "\n%s %s %s %d\n", Fname,
			Lname, contact, RNum );
			
			System.out.print("Press any numeric key to continue: ");
			while( !mayora.hasNextInt() )
			{
				JOptionPane.showMessageDialog( null ,"Invalid input!");
				System.out.print("Press any numeric key to continue: ");
				mayora.next();
			}
			mayora.nextInt();
		}
		catch ( NoSuchElementException elementException )
		{
			 System.err.println( "File improperly formed." );
			 input.close();
			 System.exit( 1 );
		}
		catch ( IllegalStateException stateException )
		{
			 System.err.println( "Error reading from file." );
		}
	}
	 public void closeFile()
	 {
		 if ( input != null )
		 	input.close();
		 if ( output != null )
			output.close();
			
		 f1.delete();
		 f2.renameTo(f1);
	 }
	 static void clear(){
	 for( int c = 0; c<30; c++)
    	{
    		System.out.println("");
    	}
	 }
	 static double addService()
	 {
			System.out.println("\nO================ S E R V I C E S =============O\n");
			System.out.println("[1] Massage Service		Php 1000");
			System.out.println("[2] Food Service		Php 500");
			System.out.println("[3] Extra Bed Service		Php 100/bed");
			System.out.println("[0] Exit");
    		System.out.println("\nO=======================O======================O");
			System.out.print("Enter Service no.: ");
			berting = mayora.nextInt();
			
			switch( berting )
			{
				case 1:
					if( service1 == false){
						service1 = true;
						service = service + 1000;
						clear();
						addService();
					}
					else
					{
						JOptionPane.showMessageDialog( null ,"Massage Service Already Acquired!");
						clear();
						addService();
					}
					break;
				case 2:
					if( service2 == false){
						service2 = true;
						service = service + 500;
						clear();
						addService();
					}
					else
					{
						JOptionPane.showMessageDialog( null ,"Food Service Already Acquired!");
						clear();
						addService();
					}
					break;
				case 3:
					if( service3 == false){
						service3 = true;
						System.out.print("Enter No. of Beds: ");
						service = service + 100 * mayora.nextInt();
						clear();
						addService();
					}
					else
					{
						JOptionPane.showMessageDialog( null ,"Extra Bed Service Already Acquired!");
						clear();
						addService();
					}
					break;
				case 0:
					return service;
					
			}
			return service;
	 	
	 }
}