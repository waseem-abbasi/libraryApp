package librarypack;
import java.sql.*;
import javax.swing.JOptionPane;
public class Member
{
	Connection cobj = null;
	Statement sobj = null;
	ResultSet robj = null;
	PreparedStatement pobj = null;
	PreparedStatement uptobj = null;
	PreparedStatement delobj = null;
	
	public Member(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		cobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
		sobj = cobj.createStatement();
		
		//insert
		pobj = cobj.prepareStatement("INSERT INTO member(fname, lname, gender) VALUES (?, ?, ?)");
		
		//udpate
		uptobj = cobj.prepareStatement("update Member set fname = ?,lname = ?,gender = ? where id = ?");
		
		// Fetching records
		robj = sobj.executeQuery("SELECT * FROM Member");
		
		//delete
		delobj = cobj.prepareStatement("delete from member where id = ?");
		}catch(Exception eobj){
			eobj.printStackTrace();
		}
		
	}
	//adding members-------------------------
	public void add(){
		try{
		String fname = JOptionPane.showInputDialog("enter the first name");
		String lname = JOptionPane.showInputDialog("enter the last name");
		String gender = JOptionPane.showInputDialog("enter the gender");
		//becasue != not work in string...
		if(!fname.equals("") && !lname.equals("") && !gender.equals("") )
		{
			pobj.setString(1,fname);
			pobj.setString(2,lname);
			pobj.setString(3,gender);
			
			int count = pobj.executeUpdate();
			JOptionPane.showMessageDialog(null,count+"row inserted succegully");
			
			cobj.close();
			pobj.close();
		}
		else{
			JOptionPane.showMessageDialog(null,"please feel the fields");
		}
		}catch(Exception eobj)
		{
			JOptionPane.showMessageDialog(null,"please enter the valid number");
		}
	}
	//show one member details --------------------------
	public void showone()
	{
		try{
			int id = Integer.parseInt(JOptionPane.showInputDialog("enter the id you want to search"));
			PreparedStatement pobj = cobj.prepareStatement("select * from Member where id = ?");
			pobj.setInt(1,id);
			robj = pobj.executeQuery();
			
			 if (robj.next()) {
				System.out.println("\n\t\tmember details ");
				System.out.println("\tid\tfname\tlname\tgender");
				System.out.println("\t=======================");
				
				System.out.print("\t" + robj.getInt("id"));
				System.out.print("\t" + robj.getString("fname"));
				System.out.print("\t" + robj.getString("lname"));
				System.out.println("\t" + robj.getString("gender"));
			} else {
				JOptionPane.showMessageDialog(null, "No book found with the specified ID. Please check the book ID.");
			}
        robj.close();
        pobj.close();
        cobj.close();
		}	

		catch(Exception eobj)
		{
			 JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");
		}
	}
	//show all----------------------
	public void showall(){
		try{
			System.out.println("\n\t\t Book Data ");
			System.out.println("\tid\tfname\tlname\tgender");
			System.out.println("\t=======================");
			
			while (robj.next()) {
				System.out.print("\t" + robj.getInt("id"));
				System.out.print("\t" + robj.getString("fname"));
				System.out.print("\t" + robj.getString("lname"));
				System.out.println("\t" + robj.getString("gender"));
				
			}
			robj.close();
			cobj.close();
		}catch(Exception eobj)
		{
			
			eobj.printStackTrace();
		}
	}
	//update----------------------------------
	public void update()
	{
		try{
			int id = Integer.parseInt(JOptionPane.showInputDialog("enter the id you want to change"));
			String fname= JOptionPane.showInputDialog("enter the fname you want to change");
			String lname = JOptionPane.showInputDialog("enter the lname you wnat to change");
			String gender = JOptionPane.showInputDialog("enter the gender youw want to change");
			
			uptobj.setString(1,fname);
			uptobj.setString(2,lname);
			uptobj.setString(3,gender);
			uptobj.setInt(4,id);
			int count = uptobj.executeUpdate();
			
			if(count > 0)
			{
				JOptionPane.showMessageDialog(null,"book details succegully update"+count);
			}
			else{
				JOptionPane.showMessageDialog(null,"please check member id");
			}
			uptobj.close();
			cobj.close();
		}catch(Exception eobj)
		{
			
		}
	}
	
	//delete--------------------
	public void delete()
	{
		try{
			int delete = Integer.parseInt(JOptionPane.showInputDialog("enter the member id you want to delte"));
			delobj.setInt(1,delete);
			int dcount = delobj.executeUpdate();
			if(dcount > 0)
			{
				JOptionPane.showMessageDialog(null,"member details succfully delete....");
				//System.exit(0);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"please wright correct book id....");
				//System.exit(0);
			}
		}catch(Exception eobj){
		JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");
			}
	}
}





