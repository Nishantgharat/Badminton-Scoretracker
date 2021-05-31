package badminton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;                                      
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;                                                                               
import javax.swing.JFrame;                                                                                
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;                                                                            
import java.sql.*;

import com.mysql.cj.protocol.Resultset;                                                                                                          
public class MatchUI extends JFrame{        //edited here1                                                                            
	Match match = new Match();                                                                            
	JButton buttonA = new JButton();                                                                      
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonE = new JButton();
	JButton buttonF = new JButton();	
	JButton buttonG = new JButton();


	
	

	JLabel scoreA = new JLabel();                                                                         
	JLabel scoreB = new JLabel();                                                                         
	                                                                                                      
	JTextField playerA = new JTextField();                                                                
	JTextField playerB = new JTextField();                                                                
	JLabel labelA = new JLabel();                                                                         
	JLabel labelB = new JLabel();                                                                         
	JFrame frame = new JFrame();                                                                          
	JLabel matchState = new JLabel();                                                                     
	                                                                                                      
	int display = 1;                                                                                      
	public static String playerAName;                                                                           
	public static String playerBName;                                                                           
	private boolean matchStarted;                                                                         
	private boolean matchEnded;         
	
	
	void initialize() {                                                                                   
		int topMargin = 100;                                                                              
		Font labelFont = new Font("Arial", Font.BOLD, 30);                                               
		Font font = new Font("Arial", Font.PLAIN, 40); 
		Font font1 = new Font("Arial", Font.PLAIN, 20);
		Font font2 = new Font("Arial", Font.PLAIN, 15);
		Font font3 = new Font("Arial", Font.BOLD, 50);

		                                                                                                  
		JLabel title = new JLabel();                                                                      
		title.setBounds(100, 20, 700, 40);                                                                
		title.setText("Badminton Scoreboard");                                                         
		title.setFont(font3);                                                                         
		frame.add(title);                                                                                 
                                                                                                          
		matchState.setBounds(335, 300, 300, 50);                                                          
		matchState.setFont(new Font("Arial", Font.BOLD, 35));                                            
		matchState.setVisible(false);                                                                     
		frame.add(matchState);                                                                            
		                                                                                                  
		labelA.setBounds(170, topMargin + 20, 175, 50);                                                   
		labelA.setFont(labelFont);                                                                        
		playerA.setBounds(170, topMargin + 20, 100, 25);                                                  
		frame.add(labelA);                                                                                
		frame.add(playerA);                                                                               
		                                                                                                  
		labelB.setBounds(460, topMargin + 20, 175, 50);  
		labelB.setFont(labelFont);                                                                        
		playerB.setBounds(460, topMargin + 20, 100, 25);                                                  
		frame.add(labelB);                                                                                
		frame.add(playerB);                                                                               
		                                                                                                  
		                                                                                                  
		scoreA.setText("0");                                                                              
		scoreA.setBounds(210, topMargin + 50, 200, 100);                                                  
		scoreA.setFont(font);                                                                             
		frame.add(scoreA);                                                                                
		                                                                                                  
		scoreB.setFont(font);                                                                             
		scoreB.setText("0");                                                                              
		scoreB.setBounds(500, topMargin + 50, 200, 100);                                                  
		frame.add(scoreB);                                                                                
		                                                                                                  
		buttonA.setBackground(Color.BLUE);                                                                
		buttonA.setOpaque(true);                                                                          
		buttonA.setBounds(50, topMargin + 300, 300, 300);                                                 
		buttonA.setFocusable(false);                                                                      
		buttonA.setFont(font);                                                                            
		buttonA.setText("0");                                                                             
		frame.add(buttonA);  
		
		buttonB.setBackground(Color.RED);                                                                 
		buttonB.setBounds(450, topMargin + 300, 300, 300);                                                
		buttonB.setOpaque(true);                                                                          
		buttonB.setFocusable(false);                                                                      
		buttonB.setFont(font);                                                                            
		buttonB.setText("0");                                                                             
		frame.add(buttonB); 
		
		buttonC.setBackground(Color.GREEN);                                                                
		buttonC.setOpaque(true);                                                                          
		buttonC.setBounds(50, 300 , 140, 45);                                                 
		buttonC.setFocusable(false);                                                                      
		buttonC.setFont(font1);                                                                            
		buttonC.setText("View Scores");  
		frame.add(buttonC);
		
		buttonD.setBackground(Color.GREEN);                                                                
		buttonD.setOpaque(true);                                                                          
		buttonD.setBounds(200, 300 , 125, 45);                                                 
		buttonD.setFocusable(false);                                                                      
		buttonD.setFont(font1);                                                                            
		buttonD.setText("LeaderBoard");  
		frame.add(buttonD);

		buttonE.setBackground(Color.GREEN);                                                                
		buttonE.setOpaque(true);                                                                          
		buttonE.setBounds(540, 300 , 210, 45);                                                 
		buttonE.setFocusable(false);                                                                      
		buttonE.setFont(font1);                                                                            
		buttonE.setText("NEW TOURNAMENT");  
		frame.add(buttonE);
		
		buttonF.setBackground(Color.GREEN);                                                                
		buttonF.setOpaque(true);                                                                          
		buttonF.setBounds(50, 250 , 140, 40);                                                 
		buttonF.setFocusable(false);                                                                      
		buttonF.setFont(font2);                                                                            
		buttonF.setText("SCORE STREAM");  
		frame.add(buttonF);
		
		buttonG.setBackground(Color.GREEN);                                                                
		buttonG.setOpaque(true);                                                                          
		buttonG.setBounds(540, 250 , 140, 40);                                                 
		buttonG.setFocusable(false);                                                                      
		buttonG.setFont(font1);                                                                            
		buttonG.setText("New Match");  
		frame.add(buttonG);
		buttonG.setVisible(false);

                                                                                                          
		                                                                                         
		buttonA.addActionListener(new ActionListener() {                                                  
			                                                                                              
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {                                                  
				increment("A");                                                                           
			}                                                                                             
		});  
		
		buttonB.addActionListener(new ActionListener() {                                                  
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {                                                  
				increment("B");                                                                           
			}                                                                                             
		}); 
		
		buttonC.addActionListener(new ActionListener() {                                                  
            
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {  
				
			    Fetch f=new Fetch();  
			    
			}                                                                                             
		});
		
        buttonD.addActionListener(new ActionListener() {                                                  
            
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {  
//				JFrame framed = new JFrame();
//				framed.setBounds(150, 70, 850, 850);                                                               
//				framed.setLayout(null);                                                                            
//				framed.setVisible(true);
				Leaderboard l = new Leaderboard();
				                                                                           
			}                                                                                             
		});
        
        buttonE.addActionListener(new ActionListener() {                                                  
            
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {  
				int confirmed = JOptionPane.showConfirmDialog(null, "THIS WILL DELETE ALL PREVIOUS MATCHES DATA","ARE U SURE",JOptionPane.YES_NO_OPTION);
		        if(confirmed == JOptionPane.YES_OPTION) {
			    //rset r=new rset();
		        Resettst r= new Resettst();	
			    new MatchUI().initialize();
			    }
			    
			}                                                                                             
		});
        
        
       buttonF.addActionListener(new ActionListener() {                                                  
            
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {  
				Sstream s = new Sstream();
				
				                                                                           
			}                                                                                             
		});
        
       
       buttonG.addActionListener(new ActionListener() {                                                  
           
			@Override                                                                                     
			public void actionPerformed(ActionEvent e) {  
				new MatchUI().initialize();

				
				                                                                           
			}                                                                                             
		});
        
        
//      frame.setBounds(100, 20, 800, 800);                                                               
//		frame.setLayout(null);                                                                            
//		frame.setVisible(true);                                                                                                  
		                                                                                                  
		                                                                                                 
		frame.setBounds(100, 20, 800, 800); 
        frame.setSize(800,800);
		frame.setLayout(null);                                                                            
		frame.setVisible(true);
		Color myWhite = new Color(55, 155, 245);
		frame.setBackground(myWhite);
		frame.getContentPane().setBackground(myWhite);
		
		
		ImageIcon img=new ImageIcon("image/abc.jpeg");//IMG_0988.jpg=new JLabel(new ImageIcon("/Users/nishant/Downloads/IMG_0994.heic"));
		Image imggg=img.getImage();
		Image temp=imggg.getScaledInstance(1200,1200,Image.SCALE_SMOOTH);
		img=new ImageIcon(temp);
		JLabel back=new JLabel(img);
		back.setLayout(null);
		back.setBounds(0,0,1200,1200);
		
		frame.add(back);
//		JLabel background=new JLabel(img);
		//background.setLayout(new FlowLayout());
		//background.setBackground(myWhite);
		//background.setSize(1500,1500);
		//frame.add(background);
		
		
                                                                                                  
	}                                                                                                     
	                                                                                                      
	public static void main(String[] args) {                                                              
		new MatchUI().initialize();
		
		
		
//		try {	
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/badminton";
//			String user = "root";
//			String password = "20022002Ng";
//			String query="select * from player_info ";
//			
//			Connection conn= DriverManager.getConnection(url, user, password);
//			
//			if (conn != null) {
//              System.out.println("Connected to the database test2");
//          }
//			
//			Statement stmt=conn.createStatement();
//			Resultset rst= (Resultset) stmt.executeQuery(query);
//			
//			//(Resultset)rst.next();
////			((ResultSet) rst).next();
////			String name=((ResultSet) rst).getString("name");
////			System.out.println(name);
////			
//			
//			while (((ResultSet) rst).next()) {
//				System.out.println(((ResultSet) rst).getString("player_a"));
//				System.out.println(((ResultSet) rst).getString("player_b"));
//				//System.out.print("hello");
//			}
//			//$con = mysqli_connect("localhost","root","","search");
//			//echo $con;
//		}
//		catch(Exception e){System.out.print("hello exc occ"+e);
//		}
		
		
		
	}                                                                                                     
	                                                                                                      
	private void increment(String team) {                                                                 
		if(matchEnded) {                                                                                  
			return;                                                                                       
		}                                                                                                 
		                                                                                                  
		if(!matchStarted) {                                                                               
			playerAName = "".equals(playerA.getText()) ? "BLUE" : playerA.getText() ;                     
			playerBName = "".equals(playerB.getText()) ? "RED" : playerB.getText();
			
			
			
			try {	
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/badminton";
				String user = "root";
				String password = "20022002Ng";
				String query="insert into player_info (player_a,player_b) values ('"+playerAName+"','"+playerBName+"');  ";
				String qry2="DROP table scored ;";
				String qry3="create table scored (score_no int NOT NULL AUTO_INCREMENT,\n"
						+ "    scored_by varchar(20),\n"
						+ "    PRIMARY KEY (score_no));";  
				System.out.println(query);

				Connection conn= DriverManager.getConnection(url, user, password);
				
				if (conn != null) {
	              System.out.println("Connected to the database test3");
	          }
				
				Statement stmt=conn.createStatement();
				
				
		        PreparedStatement    st = conn.prepareStatement(query);
		        st.executeUpdate();
		        
		        conn.close();
				
				//(Resultset)rst.next();
//				((ResultSet) rst).next();
//				String name=((ResultSet) rst).getString("name");
//				System.out.println(name);
//				
				
//				while (((ResultSet) rst).next()) {
//					System.out.println(((ResultSet) rst).getString("scored_by"));	
//					System.out.print("hello");
//				}
				//$con = mysqli_connect("localhost","root","","search");
				//echo $con;
			}
			catch(Exception e){System.out.print("hello exc occ"+e);
			}
			
			
			labelA.setText(playerAName); 
			labelB.setText(playerBName);                                                                  
			playerA.setVisible(false);                                                                    
			playerB.setVisible(false);                                                                    
			matchStarted = true;                                                                          
		}                                                                                                 
		match.incrementScore(team);                             // match class madla method call                                          
		buttonB.setText(match.currentScore.teamBScore+"");                                                
		buttonA.setText(match.currentScore.teamAScore+"");                                                
		                                                                                                  
		                                                                                                  
		scoreA.setText("" + match.Awon);                                                                  
		scoreB.setText("" + match.Bwon);                                                                  
		                                                                                                  
		switch(match.winner) {                                                                            
			case "A" :                                                                                    
				matchState.setText(playerAName + " wins!!");
				Winnqry n=new Winnqry(playerAName,playerBName,0);
				String winnn = "" + playerAName + " wins";
				JOptionPane.showMessageDialog(null,winnn);
				buttonG.setVisible(true);                                                   // ikde team a scored ani team b scored 
				matchState.setVisible(true);                                                              
				matchEnded = true;                                                                        
				break;                                                                                    
			case "B" :                                                                                    
				matchState.setVisible(true);
				String winn = "" + playerBName + " wins";
				Winnqry nn=new Winnqry(playerAName,playerBName,1);
				JOptionPane.showMessageDialog(null,winn);
				matchState.setText(playerBName + " wins!!");  
				buttonG.setVisible(true);                                                   // ikde team a scored ani team b scored 

				matchEnded = true;                                                                        
				break;                                                                                    
			                                                                                              
		}                                                                                                 
		                                                                                                  
	}                                                                                                     
}                                                                                                         
                                                                                                          