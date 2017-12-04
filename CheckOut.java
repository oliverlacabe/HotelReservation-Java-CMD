import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;
import javax.swing.JOptionPane;

 public class CheckOut
 {
	 private Scanner input, berting;
	 private Formatter output;
	 private clientRecord record = new clientRecord();
	 private double total;
	 private boolean found = false;
	 private File f1, f2;
	 private String f, l;
	
	 public void openFile()
	 {
		 try
		 {
		 	input = new Scanner( new File( "Clients.dat" ) );
		 }
		 catch ( FileNotFoundException fileNotFoundException )
		 {
			 System.err.println( "Error opening file." );
			 System.exit( 1 );
		 }
	 }public void openFile2()
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
	 }
	
	 public void list()
	 {
	 	
		 System.out.println("O=============== C L I E N T  R E C O R D S =================O");
		 System.out.printf( "%-15s%-15s%-15s%12s\n", "First Name", "Last Name", "Contact No.", "Room No." );
    	 System.out.println("O==============================O=============================O");
		
		 try
		 {
		 	while(input.hasNext() )
			{
				record.setFname( input.next() );
				record.setLname( input.next() );
				record.setContact( input.next() );
				record.setRNum( input.nextInt() );
					
				System.out.printf( "%-15s%-15s%-15s%12d\n", record.getFname(),
				record.getLname(), record.getContact(), record.getRNum() );
			}
		 
    	 System.out.println("O==============================O=============================O");
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
			 System.exit( 1 );
		 }
	 }
	 public void checkOut()
	 {
	 	 berting = new Scanner(System.in);
		 System.out.print( "Enter First Name.: " );
		 f = berting.next();
		 System.out.print( "Enter Last Name.: " );
		 l = berting.next();
		 try
		 {
		 	
		 	 while(input.hasNext() )
			 {
				record.setFname( input.next() );
				record.setLname( input.next() );
				record.setContact( input.next() );
				record.setRNum( input.nextInt() );
				if( !f.equals(record.getFname()) && !l.equals(record.getLname()) )
				{	
			 		output.format( "\n%s %s %s %d\n", record.getFname(),
					record.getLname(), record.getContact(), record.getRNum() );
				}
				else
					found = true;
			 }
			 if(found == true)
			 {
			 	JOptionPane.showMessageDialog(null ,"Succes!");
			 }
			 else
			 	JOptionPane.showMessageDialog(null ,"Client not found!");
			 	
		 	 System.out.print("Press any numeric key continue: ");
			 while(!berting.hasNextInt())
			 {
		 		JOptionPane.showMessageDialog(null ,"Invalid Input");
		 		System.out.print("Press any numeric key continue: ");
		 		berting.next();
	   	 	 }
				 	berting.nextInt();
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
			 System.exit( 1 );
		 }
	 	
	 }
	 public void closeFile()
	 {
		 if ( input != null )
		 	input.close();
	 }
	 
	 public void closeFile2()
	 {
		 if ( input != null )
		 	input.close();
		 if ( output != null )
		 	output.close();
		 	
		 f1.delete();
		 f2.renameTo( f1 );
	 }
 }