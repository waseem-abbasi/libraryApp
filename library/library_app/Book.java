package librarypack;
import java.sql.*;
import javax.swing.JOptionPane;

public class Book {
    Connection cobj = null;
    Statement sobj = null;
    ResultSet robj = null;
    PreparedStatement pstObj = null;
	PreparedStatement uptObj =  null;
	PreparedStatement delObj =  null;
    public Book() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            sobj = cobj.createStatement();

            // Pre-Compiled Statement (Usually Used for Action Queries)(insert)
            pstObj = cobj.prepareStatement("INSERT INTO Book(bookTitle, Price, Author) VALUES (?, ?, ?)");
			
			//update
			 uptObj = cobj.prepareStatement("UPDATE Book SET bookTitle = ?, Price = ?, Author = ? WHERE bookId = ?");
			 
			 //delete
			 delObj = cobj.prepareStatement("Delete from book where bookId = ?");
			
			
			// Fetching records
			robj = sobj.executeQuery("SELECT * FROM book");
			
		
			
        } catch (Exception eobj) {
          eobj.printStackTrace();
        }
    }
	
	//value input
    public void input() {
        try {
            String title = JOptionPane.showInputDialog("Enter the book title");
            int price = Integer.parseInt(JOptionPane.showInputDialog("Enter the book price"));
            String author = JOptionPane.showInputDialog("Enter the book author");

            pstObj.setString(1, title);
            pstObj.setInt(2, price);
            pstObj.setString(3, author);

            int count = pstObj.executeUpdate();
            JOptionPane.showMessageDialog(null, count + " row(s) inserted successfully");
			
			robj.close();
			sobj.close();
			cobj.close();
			
			
        } catch (Exception eobj) {
           JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");
        }
    }
	
	//update
	public void update(){
		try{
			int id = Integer.parseInt(JOptionPane.showInputDialog("enter id for which you want to change"));
			String btitle = JOptionPane.showInputDialog("enter the book title you update");
			int bprice = Integer.parseInt(JOptionPane.showInputDialog("enter the price you want change"));
			String bauthor = JOptionPane.showInputDialog("enter the auhtor name you want change");
			
			uptObj.setString(1,btitle);
			uptObj.setInt(2,bprice);
			uptObj.setString(3,bauthor);
			uptObj.setInt(4,id);
			
			int roweffected = uptObj.executeUpdate();
			
			//check the result
			if(roweffected > 0)
			{
				JOptionPane.showMessageDialog(null,"book details succfully update...."+roweffected);
				//System.exit(0);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"please check book id....");
				//System.exit(0);
			}
			uptObj.close();
			cobj.close();	
			
		}catch(Exception eobj){
			JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");
		}
	}
	
	//delete
	public void delete(){
		try{
			int delete = Integer.parseInt(JOptionPane.showInputDialog("enter the book id you want to delte"));
			delObj.setInt(1,delete);
			int dcount = delObj.executeUpdate();
			if(dcount > 0)
			{
				JOptionPane.showMessageDialog(null,"book details succfully delete....");
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
	
	// Method to display book records
	public void displayBooks() {
		try {
			System.out.println("\n\t\t Book Data ");
			System.out.println("\tid\ttitle\tprice\tauthor");
			System.out.println("\t=======================");
			
			while (robj.next()) {
				System.out.print("\t" + robj.getInt("bookId"));
				System.out.print("\t" + robj.getString("bookTitle"));
				System.out.print("\t" + robj.getInt("price"));
				System.out.println("\t" + robj.getString("author"));
				
			}
			robj.close();
			cobj.close();
		} catch (Exception eobj) {
			eobj.printStackTrace();
		}
	}
	//one search
	public void search() {
    try {
        int search = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ID you want to search"));
		// Create the PreparedStatement and assign the select query
		PreparedStatement pobj = cobj.prepareStatement("SELECT * FROM Book WHERE bookId = ?");
       
        
        // Set the parameter of the PreparedStatement
        pobj.setInt(1, search);

        robj = pobj.executeQuery();

        if (robj.next()) {
            System.out.println("\n\t\tBook Data ");
            System.out.println("\tid\ttitle\tprice\tauthor");
            System.out.println("\t=======================");
            
            System.out.print("\t" + robj.getInt("bookId"));
            System.out.print("\t" + robj.getString("bookTitle"));
            System.out.print("\t" + robj.getInt("price"));
            System.out.println("\t" + robj.getString("author"));
        } else {
            JOptionPane.showMessageDialog(null, "No book found with the specified ID. Please check the book ID.");
        }

        robj.close();
        pobj.close();
        cobj.close();
    } catch (Exception eobj) {
       JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");
    }
}

}

// javac -d e:\star\package -cp e:\star\com.mysql.jdbc_5.1.5.jar Book.java
