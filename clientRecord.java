
public class clientRecord
{
	
private String CLname, CFname, contact;
private int room;

	public clientRecord()
	{
		this( "", "", "", 0);
	}
	
	public clientRecord( String f, String l,String c, int r )
	{
		setFname( f );
		setLname( l );
		setContact( c );
		setRNum( r );
	}
	public void setFname( String f )
	{
		CFname = f;
	}
	public String getFname()
	{
		return CFname;
	}
	public void setLname( String l )
	{
		CLname = l;
	}
	public String getLname()
	{
		return CLname;
	}
	public void setContact( String c )
	{
		contact = c;
	}
	public String getContact()
	{
		return contact;
	}
	public void setRNum( int r )
	{
		room = r;
	}
	public int getRNum()
	{
		return room;
	}
}