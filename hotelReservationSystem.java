import java.util.Scanner;
import javax.swing.JOptionPane;

public class hotelReservationSystem {
	
static Scanner input = new Scanner( System.in );
static int choice = 0;
    public static void main( String MayoraBertingKapitana[] ) {
    	choose();
    }
    static void choose()
    {
    	mainMenu();
    	while( !input.hasNextInt() )
    	{
    		JOptionPane.showMessageDialog( null ,"Invalid Input!");
    		clear();
    		mainMenu();
    		input.next();
    	}
    	choice = input.nextInt();
    	
    	switch( choice )
    	{
    		case 1:
    			clear();
    			checkIn in = new checkIn();
    			in.openFile();
    			in.checkIn();
    			in.closeFile();
    			clear();
    			choose();
    			break;
    		case 2:
    			clear();
    			CheckOut check = new CheckOut();
    			check.openFile();
    			check.list();
    			check.closeFile();
    			check.openFile2();
    			check.checkOut();
    			check.closeFile2();
    			clear();
    			choose();
    			break;
    		case 0:
    			System.exit( 0 );
    		default:
    			JOptionPane.showMessageDialog( null ,"Invalid Input!");
    			clear();
    			choose();
    			
    	}
    }
    
    static void mainMenu()
    {
    	System.out.println("\nO======== M A I N   M E N U =======O\n");
    	System.out.println("[1] Check In");
    	System.out.println("[2] Check Out");
    	System.out.println("[0] Exit");
    	System.out.println("\nO=================O================O");
    	System.out.print("Enter the no. of your choice: ");
    }
    static void checkInMenu()
    {
    	System.out.println("\nO========= C H E C K   I N ========O\n");
    	System.out.println("[1] Add Client Info");
    	System.out.println("[2] Add services");
    	System.out.println("[3] View Reservation Info");
    	System.out.println("[0] exit");
    	System.out.println("\nO=================O================O");
    	System.out.print("Enter the no. of your choice: ");
    }
    
    static void clear()
    {
    	for( int c = 0; c<30; c++)
    	{
    		System.out.println("");
    	}
    }
}