
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RideOver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub


		Class.forName("org.sqlite.JDBC");
		Scanner scn = new Scanner(System.in);
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Rideover");
		Statement stat = conn.createStatement();

		System.out.println("opened database successfully");
		int modify=0;
		int queries=0;
		int key= 1;
		while (key ==1)	
		{	
     		System.out.println("You have two options:\n 1. Modify Database \n 2. Run Queries");
			int choice = scn.nextInt();
			if(choice==1)
			{
			System.out.println("1. To insert into database.");
			System.out.println("2. To delete row from database. ");
			System.out.println("3. To edit database. ");
			//System.out.println("2. To insert into directors table.");
			//System.out.println("4. To update director's dob.");
			
			modify = scn.nextInt();
			}
			else if(choice==2)
			{
				System.out.println("1. Search for rides. ");
				/*
			System.out.println("1. To find out the actors who worked with younger directors.");
			System.out.println("2. To list the directors in ascending order of their birthyear.");
			System.out.println("3. To find out the genre with highest number of movies.");
			System.out.println("4. Search movies by year released.");
			System.out.println("5. Search movies by actor.");*/
			
			queries = scn.nextInt();
			}
			else
			{
				System.out.println("WRONG CHOICE!!!...Enter Again");
				continue;
			}
			
			switch (modify)
			{

			case 1:

				int i =1;

				//String  a_aname=null, a_adob=null, a_agender=null;
				String leaving_from = null, going_to= null, leaving_date= null;
				String username= null, leaving_time= null, am_pm= null, seats= null, price= null;  

				while(i == 1 )
				{	

					try {

						scn.nextLine();
						//System.out.println("Enter name: ");
						//a_aname = scn.nextLine();
						
/*
						System.out.println("Enter date of birth (yyyy-mm-dd): ");
						//a_adob = scn.nextLine();

						System.out.println("Enter gender: ");
						//a_agender = scn.nextLine();
*/
						System.out.println("Enter username: ");
						username = scn.nextLine();
						
						System.out.println("Enter leaving from: ");
						leaving_from = scn.nextLine();
						
						System.out.println("Enter going to: ");
						going_to = scn.nextLine();
						
						System.out.println("Enter leaving time (hh:mm): ");
						leaving_time = scn.nextLine();
						
						System.out.println("Enter AM or PM to indicate time: ");
						am_pm = scn.nextLine();
						
						System.out.println("Enter leaving date (yyyy-mm-dd): ");
						leaving_date = scn.nextLine();
						
						System.out.println("Enter number of seats: ");
						seats = scn.nextLine();
						
						System.out.println("Enter price: ");
						price = scn.nextLine();
						
						/*String sql = "INSERT INTO actors(a_aname, a_adob, a_agender)" +
								"VALUES (?, ?, ?)";*/
						

						String sql = "INSERT INTO ShareARide(SAR_username, SAR_leaving_from, SAR_going_to, SAR_leaving_time, SAR_am_pm, SAR_leaving_date, SAR_seats, SAR_price)" +
								"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						/*preparedStatement.setString(1, a_aname);
						preparedStatement.setString(2, a_adob);
						preparedStatement.setString(3, a_agender);*/
						
						preparedStatement.setString(1, username);
						preparedStatement.setString(2, leaving_from);
						preparedStatement.setString(3, going_to);
						preparedStatement.setString(4, leaving_time);
						preparedStatement.setString(5, am_pm);
						preparedStatement.setString(6, leaving_date);
						preparedStatement.setString(7, seats);
						preparedStatement.setString(8, price);
					

						preparedStatement.executeUpdate(); 

						System.out.println("If you want to insert another row enter 1 else enter 0: "); 
						i= scn.nextInt();
						
					}
					
					finally {
						// ... cleanup that will execute whether or not an error occurred ...
					}
				}
				
				break;
			
			case 2:
				
				i = 1;
				
				 username = null;
				
	
				while(i == 1){
					try{
						scn.nextLine();
						System.out.println("Enter username: ");
						username = scn.nextLine();
						
						String sql = "DELETE FROM ShareARide WHERE SAR_username = ?";

						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						preparedStatement.setString(1, username);
						preparedStatement.executeUpdate(); 

						System.out.println("If you want to delete another row enter 1 else enter 0: "); 
						i= scn.nextInt();
						
					}finally {
						// ... cleanup that will execute whether or not an error occurred ...
					}
				}
				
				break;
					
				

/*
			case 2:

				i =1;

				String  d_dname=null, d_ddob=null;

				while(i == 1 )
				{	

					try {

						System.out.println("Enter name: ");
						a_aname = scn.next();

						System.out.println("Enter date of birth (yyyy-mm-dd): ");
						a_adob = scn.next();

						String sql = "INSERT INTO actors(d_dname, d_ddob)" +
								"VALUES (?, ?)";

						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						preparedStatement.setString(1, d_dname);
						preparedStatement.setString(2, d_ddob);

						preparedStatement.executeUpdate(); 

						System.out.println("If you want to insert another row enter 1 else enter 0: "); 
						i= scn.nextInt();
						
					}
					
					finally {
						// ... cleanup that will execute whether or not an error occurred ...
					}
				}
				
				break;
				
*/
			case 3:

				i =1;

				//a_aname=null; a_adob=null;
				 leaving_time = null; am_pm = null; username = null;

				while(i == 1 )
				{	

					try {
						
						scn.nextLine();
						/*System.out.println("Enter name: ");
						a_aname = scn.nextLine();

						
						System.out.println("Enter new date of birth (yyyy-mm-dd): ");
						a_adob = scn.nextLine();

						
						String sql = "UPDATE actors SET a_adob = ? WHERE a_aname = ?";
*/
						System.out.println("Enter username: ");
						username = scn.nextLine();
						
						System.out.println("Enter leaving_time: ");
						leaving_time = scn.nextLine();
						
						System.out.println("Enter AM or PM to indicate time: ");
						am_pm = scn.nextLine();
						
						String sql = "UPDATE ShareARide SET SAR_leaving_time = ?, SAR_am_pm = ? WHERE SAR_username = ?";
						
						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						/*preparedStatement.setString(1, a_adob);
						preparedStatement.setString(2, a_aname);*/
						
						preparedStatement.setString(1, leaving_time);
						preparedStatement.setString(2, am_pm);
						preparedStatement.setString(3, username);

						preparedStatement.executeUpdate(); 

						System.out.print("If you want to update another row enter 1 else enter 0: "); 
						i= scn.nextInt();
					}
					finally {
						// ... cleanup that will execute whether or not an error occurred ...
					}
				}
				
				break;

/*			case 4:

				i =1;

				d_dname=null; d_ddob=null;

				while(i == 1 )
				{	

					try {

						scn.nextLine();
						System.out.println("Enter name: ");
						a_aname = scn.nextLine();

						System.out.println("Enter new date of birth (yyyy-mm-dd): ");
						a_adob = scn.nextLine();

						String sql = "UPDATE directors SET d_ddob = ? WHERE d_dname = ?";

						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						preparedStatement.setString(1, d_ddob);
						preparedStatement.setString(2, d_dname);

						preparedStatement.executeUpdate(); 

						System.out.print("If you want to update another row enter 1 else enter 0: "); 
						i= scn.nextInt();
						
					}
					
					finally {
						// ... cleanup that will execute whether or not an error occurred ...
					}
				}
				break;
*/
			}
			
			switch(queries)
			
			{
			case 1:
				scn.nextLine();
				System.out.print("Enter leaving from: ");
				String leaving_from= scn.nextLine();
				System.out.println("Enter going to: ");
				String going_to = scn.nextLine();
				System.out.println("Enter leaving date (yyyy-mm-dd): ");
				String leaving_date = scn.nextLine();
				//System.out.println("Movies released in the given year :");
				try
				{
					ResultSet rs = stat.executeQuery("SELECT * FROM ShareARide WHERE SAR_leaving_from='" + leaving_from +"' AND SAR_going_to='" + going_to + "' AND SAR_leaving_date='" + leaving_date + "'");
					
					while (rs.next()) 
					{
						//System.out.println(rs.getString("m_mtitle") + "    " + rs.getString("m_myear") + "    " + rs.getString("m_mgenre"));
						System.out.println(rs.getString("SAR_username") + "    " + rs.getString("SAR_leaving_from") + "    " +
						rs.getString("SAR_going_to") + "    " + rs.getString("SAR_leaving_time") + "    " + 
						rs.getString("SAR_am_pm") + "    " + rs.getString("SAR_leaving_date") + "    " + 
						rs.getString("SAR_seats") + "    " + rs.getString("SAR_price") + "    ") ;
					}
					rs.close();
				}
				
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;
			/*
			case 1:
				
				try
				{
					ResultSet rs = stat.executeQuery("SELECT DISTINCT(w_aname) AS name FROM workin, directedby WHERE w_mtitle=db_mtitle AND w_adob<db_ddob");
					
					System.out.println("name of actors: " );
					
					while (rs.next()) 
					{
						System.out.println(rs.getString("name"));
					}
					rs.close();
					
				}
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;
				*/
				
			case 2:
				/*
				System.out.println("directors with ascending order of their birthyear :");
				try
				{
					ResultSet rs = stat.executeQuery("SELECT STRFTIME('%Y',d_ddob) AS birthyear, d_dname FROM directors ORDER BY STRFTIME('%Y',d_ddob) ASC");
					
					while (rs.next()) 
					{
						System.out.println(rs.getString("birthyear") + "    " + rs.getString("d_dname"));
					}
					rs.close();
				}
				
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;*/
				
				
				
			case 3:
				/*
				System.out.println("genre with highest number of movies is : ");
				try
				{
					String query = "SELECT S3.m_mgenre AS genre, S3.num_mov AS num FROM (SELECT MAX(S1.num_mov) AS max_num FROM (SELECT m_mgenre, COUNT(m_mtitle) AS num_mov FROM movies GROUP BY m_mgenre) S1) S2 ,(SELECT m_mgenre, COUNT(m_mtitle) AS num_mov FROM movies GROUP BY m_mgenre) S3 WHERE S3.num_mov=S2.max_num";
					
					ResultSet rs = stat.executeQuery(query);
					while (rs.next()) 
					{
						System.out.println(rs.getString("genre") + "  " + rs.getString("num"));
					}
					rs.close();
				}
				
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;*/
				
				
			case 4:
				/*
				System.out.print("What year movies do you want to look for? ");
				int year= scn.nextInt();
				System.out.println("Movies released in the given year :");
				try
				{
					ResultSet rs = stat.executeQuery("SELECT * FROM movies WHERE m_myear=" + year);
					
					while (rs.next()) 
					{
						System.out.println(rs.getString("m_mtitle") + "    " + rs.getString("m_myear") + "    " + rs.getString("m_mgenre"));
					}
					rs.close();
				}
				
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;
				*/
				
				
			case 5:
				/*
				scn.nextLine();
				System.out.print("Give the actor's name you want to search movies with :");
				String actor= scn.nextLine();
				System.out.println("Given actor acted in the following movies (with director's name) :");
				try
				{
					ResultSet rs = stat.executeQuery("SELECT w_mtitle, w_myear, db_dname FROM workin, directedby WHERE w_aname=" + "'" + actor + "'" + " AND w_mtitle=db_mtitle");
					
					while (rs.next()) 
					{
						System.out.println(rs.getString("w_mtitle") + "    " + rs.getString("w_myear") + "    " + rs.getString("db_dname"));
					}
					rs.close();
				}
				
				finally {
					// ... cleanup that will execute whether or not an error occurred ...
				}
				break;*/



			}
			
			System.out.print("Do you want to go back to main options? If yes enter 1 else enter 0: "); 

			key = scn.nextInt();
			modify=0;
			queries=0;
		}

	}

}
	
