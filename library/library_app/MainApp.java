import librarypack.*;
//import librarypack.Book;
import javax.swing.JOptionPane;

class MainClass {
    public static void main(String[] args) {
        String mainMenuStr = "Library Option(s)";
        mainMenuStr += "\n1. Book.";
        mainMenuStr += "\n2. Member.";
        mainMenuStr += "\n3. IssueDetails.";
        mainMenuStr += "\n4. showIssueDetails.";
        mainMenuStr += "\n5. Exit";

        mainMenuStr += "\n\nEnter Choice from above option : ";

        String subMenuStr = ""; // SubMenu Option";
        subMenuStr += "\n1. Add ";
        subMenuStr += "\n2. Update";
        subMenuStr += "\n3. Delete";
        subMenuStr += "\n4. Show all";
        subMenuStr += "\n5. show one";
        subMenuStr += "\n6. Exit";
        subMenuStr += "\n\nEnter Your Choice : ";

        while (true) {
			try{
            int choice = Integer.parseInt(JOptionPane.showInputDialog(mainMenuStr));
				
				switch (choice) 
				{
					case 1:
						subMenuStr = "Book Menu " + subMenuStr;
						while (true) {
							int bookChoice = Integer.parseInt(JOptionPane.showInputDialog(subMenuStr));
							switch (bookChoice) {
								case 1:
									Book bookinput = new Book();
									bookinput.input();
									break;
								case 2:
									Book bookupdate = new Book();
									bookupdate.update();
									break;
								case 3:
									
									Book bookdelete = new Book();
									bookdelete.delete();
									break;
								case 4:
									Book oneBookObj = new Book();
									oneBookObj.displayBooks();
									break;
								case 5:	
									Book bookSearch = new Book();
									bookSearch.search();
									break;
								case 6 :
									//System.exit(0);
									break;
								default :
									JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");	
							}
							if (bookChoice == 6)
								break;
						}
						break;
					
//------------------------------------------------------------------------						
					case 2:
						String subMenuSt = "Member Menu";
						subMenuSt += "\n1. Add Member ";
						subMenuSt += "\n2. Show One Member";
						subMenuSt += "\n3. Show All Member(s)";
						subMenuSt += "\n4. Update";
						subMenuSt += "\n5. Delete";
						subMenuSt += "\n6. Exit";
						subMenuSt += "\n\nEnter Your Choice : ";
						while (true) {
							int memberChoice = Integer.parseInt(JOptionPane.showInputDialog(subMenuSt));
							switch (memberChoice) {
								case 1:
									Member madd = new Member();
									madd.add();
									break;
								case 2:
									Member show = new Member();
									show.showone();
									
									break;
								case 3:
									Member showall = new Member();
									showall.showall();
									break;
								case 4:
									Member upd = new Member();
									upd.update();
									
									break;
								case 5:
									Member del = new Member();
									del.delete();
									break;
								case 6:
									JOptionPane.showMessageDialog(null, "Exiting Member Menu...!!!!");
									break;
								default :
									JOptionPane.showMessageDialog(null, "enter the valid number...!!!!");
							}
							if (memberChoice == 6)
								break;
						}
						break;
					case 3:
						Issue iss = new Issue();
						iss.issueBook();
						break;
					case 4:
						Issue details = new Issue();
						details.show();
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Thank you for using Library App...!!!!");
						System.exit(0);
					default :
						JOptionPane.showMessageDialog(null,"please enter the valid number....!!!!");	
				}
				
			}catch(Exception eobj){
				 JOptionPane.showMessageDialog(null, "plese enter the valid value(1 to 5 )...!!!!");
				 //System.exit(0);
			}
            
        }
    }
}
// compile:-javac -cp e:\star\package;e:\star\com.mysql.jdbc_5.1.5.jar MainApp.java

// run:-java -cp e:\star\package;e:\star\com.mysql.jdbc_5.1.5.jar;. MainClass