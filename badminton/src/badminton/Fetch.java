package badminton;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class Fetch extends MatchUI {

	Fetch(){
		
		
		
		JFrame framec = new JFrame();
		framec.setBounds(150, 70, 850, 850);
		//framec.setLayout(null);                                                                            
		framec.setSize(500,700); 
	    framec.setVisible(true);
	    
	    
//	    String data[][]={ {"101","Amit","670000"},    
//                {"102","Jai","780000"},    
//                {"101","Sachin","700000"}};    
//String column[]={"ID","NAME","SALARY"};         
//JTable jt=new JTable(data,column);    
//jt.setBounds(30,40,200,300);          
//JScrollPane sp=new JScrollPane(jt);    
//framec.add(sp); 
		
		
	    
	    System.out.println("this will fetch data ");
		DefaultTableModel defaultTableModel;
		defaultTableModel = new DefaultTableModel();
		JTable table;
		table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        framec.add(new JScrollPane(table));
        defaultTableModel.addColumn("match_no");
        defaultTableModel.addColumn("player A");
        defaultTableModel.addColumn("Player B");
        defaultTableModel.addColumn("Winner");
	    
	    
		
		
	    try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/badminton";
			String user = "root";
			String password = "20022002Ng";
			String query="select * from player_info ";
			
			Connection conn= DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
              System.out.println("Connected to the database test2");
          }
			
			Statement stmt=conn.createStatement();
			Resultset rst= (Resultset) stmt.executeQuery(query);
			
			//(Resultset)rst.next();
//			((ResultSet) rst).next();
//			String name=((ResultSet) rst).getString("name");
//			System.out.println(name);
//			
			
			while (((ResultSet) rst).next()) {
				System.out.println(((ResultSet) rst).getString("player_a"));
				String name1=((ResultSet) rst).getString("player_a");
				System.out.println(((ResultSet) rst).getString("player_b"));
				String name2=((ResultSet) rst).getString("player_b");
				String matchno=((ResultSet) rst).getString("match_no");
				String winner=((ResultSet) rst).getString("winner");
				
				defaultTableModel.addRow(new Object[]{matchno,name1,name2,winner});
				//System.out.print("hello");
			}
			//$con = mysqli_connect("localhost","root","","search");
			//echo $con;
		}
		catch(Exception e){System.out.print("hello exc occ"+e);
		}
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
		

		
	}

}
