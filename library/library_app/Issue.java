package librarypack;

import java.sql.*;
import javax.swing.JOptionPane;

public class Issue {
    Connection connection;
    Statement sobj ;
	ResultSet robj ;
    PreparedStatement insertStatement;
    PreparedStatement selectMemberStatement;
    PreparedStatement selectBookStatement;

    public Issue() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            sobj = connection.createStatement();
            insertStatement = connection.prepareStatement("INSERT INTO issued (memberName, bookName, issueDate, returnDate) VALUES (?, ?, ?, ?)");
            selectMemberStatement = connection.prepareStatement("SELECT * FROM Member WHERE id = ?");
            selectBookStatement = connection.prepareStatement("SELECT * FROM Book WHERE bookId = ?");
			// Fetching records
			robj = sobj.executeQuery("SELECT * FROM issued");
			
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//show all----------------------
	public void show(){
		try{
			System.out.println("\n\t\t details ");
			System.out.println("\tsno\tmember name\tbook name\tissue date\t return date");
			System.out.println("\t=======================");
			
			while (robj.next()) {
				System.out.print("\t" + robj.getInt("sno"));
				System.out.print("\t" + robj.getString("memberName"));
				System.out.print("\t\t" + robj.getString("bookName"));
				System.out.print("\t\t" + robj.getString("issueDate"));
				System.out.println("\t" + robj.getString("returnDate"));
				
			}
			robj.close();
			connection.close();
		}catch(Exception eobj)
		{
			
			eobj.printStackTrace();
		}
	}
	

    public boolean isBookAvailable(int bookId) {
        try {
            selectBookStatement.setInt(1, bookId);
            ResultSet resultSet = selectBookStatement.executeQuery();
            return resultSet.next(); // Returns true if a row is found, indicating the book is available
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isMemberExist(int id) {
        try {
            selectMemberStatement.setInt(1, id);
            ResultSet resultSet = selectMemberStatement.executeQuery();
            return resultSet.next(); // Returns true if a row is found, indicating the member exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void issueBook() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the member ID"));
            if (isMemberExist(id)) {
                selectMemberStatement.setInt(1, id);
                ResultSet memberResultSet = selectMemberStatement.executeQuery();
                int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter the book ID"));
                if (isBookAvailable(bookId)) {
                    selectBookStatement.setInt(1, bookId);
                    ResultSet bookResultSet = selectBookStatement.executeQuery();
                    String issueDate = JOptionPane.showInputDialog("Enter the issue date (YYYY-MM-DD)");
                    String returnDate = JOptionPane.showInputDialog("Enter the return date (YYYY-MM-DD)");

                    if (memberResultSet.next()) {
                        String memberName = memberResultSet.getString("fname");

                        if (bookResultSet.next()) {
                            String bookName = bookResultSet.getString("bookTitle");

                            insertStatement.setString(1, memberName);
                            insertStatement.setString(2, bookName);
                            insertStatement.setString(3, issueDate);
                            insertStatement.setString(4, returnDate);

                            int count = insertStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, count + " row(s) inserted successfully");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter book details ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please enter member details ");
            }
            connection.close();
        } catch (Exception eobj) {
            System.out.println("exception" + eobj);
            JOptionPane.showMessageDialog(null, "Please enter valid input");
        }
    }
}


//javac -d e:\star\package -cp e:\star\com.mysql.jdbc_5.1.5.jar Issue.java