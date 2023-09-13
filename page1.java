import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel; 



class adminProvidingSalaries extends JFrame implements ActionListener
{ 
JButton b1,b2,b3,b4; 
 JTextField t1,t2,t3,t4,t5,tx;
  JLabel l1,l2,l3,l4,l5,lx,ly,ll1,ll2,ll3,ll4,ll5;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	   JTable jt;
	  JPanel heading;
	  String courseCode=new String();
	  	String id,password,userType;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.YELLOW);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.RED);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});} 





	adminProvidingSalaries()
	{   super("Admin Providing Salaries");



	 



////////////////////////////////////////////
	   
   	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,870);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(true);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Finances of All Employees");
		 header.setBounds( 300,3,900,80);
		header.setFont(f);
		header.setForeground(Color.CYAN);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page2.jpg");

		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(100,100,1300,700);
		  p1.setBackground(new Color(0,0,10,60));
		p1.setLayout(null);
		 
		/*  lx = new JLabel("CGPA:");
		  lx.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      lx.setForeground(Color.yellow);
		  lx.setBounds(430,10,200,50);
		  lx.setBackground(Color.WHITE);
		  p1.add(lx);
		  
		  tx=new JTextField( );
		  tx.setFont(f2);
		  tx.setBounds(520,10,130,50);
		  tx.addActionListener(this);
		  tx.setForeground(Color.black);
		  tx.setBackground(Color.white);
		  tx.setEditable(false);
		  
		  p1.add(tx); */
		  
		 b2=new JButton("Pay for All");
		  b2.setBounds(310,630,200,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		      ylw(b2);
		  
		  p1.add(b2);
		
		
		
		
		 
		  b1=new JButton("Refresh");
		  b1.setBounds(530,630,200,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      ylw(b1);
		  
		  p1.add(b1);
		 
		 
		 
		 
		 
		    
		 
		 
		 
		 
		 
		  b3=new JButton("Back");
		  b3.setBounds(750,630,200,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		   
		 
		 
	        
	      //  p1.add(j);
		 
		   
	        JScrollPane jsp=new JScrollPane();
	        jsp.setBounds(100, 100, 1100, 500);
	        jsp.setVisible(true);
	        p1.add(jsp);

		 
		
		
		
	        jt = new JTable( );
	        jt.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
	        jt.setRowHeight(30);
	        jsp.setViewportView(jt);
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
		
		
		jt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			TableModel tmodel = jt.getModel();
			int selectedRowIndex=jt.getSelectedRow();
			 
		 
			 
			 
			 
			 
			}});
		
		
		
		
		
		 
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
		      
			  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			  Statement  stmtx=conx.createStatement();
			  String sqlx="select * from salary_view";
			  PreparedStatement psx=conx.prepareStatement(sqlx);
			//  ResultSet rsx=psx.executeQuery();
			  
			   
			   ResultSet RS=stmtx.executeQuery(sqlx);
			 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
			  
			    
			   
			  
			   if(RS.next())
			   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
			
			
			
			    
			
			
			
			
		   }
		catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
		
	}




public void actionPerformed(ActionEvent ae)
		{   if(ae.getSource()==b1 )
			{    
				try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtx=conx.createStatement();
					  String sqlx="select * from salary_view";
					  PreparedStatement psx=conx.prepareStatement(sqlx);
					//  ResultSet rsx=psx.executeQuery();
					  
					   
					   ResultSet RS=stmtx.executeQuery(sqlx);
					 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
					  
					    
					   
					  
					   if(RS.next())
					   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
					
					
					
					
					   conx.close();
					
					
					
				   }
				catch(Exception e){JOptionPane.showMessageDialog(null,e);  }
				 
		    }
		
		
		else if(ae.getSource()==b2 )
		{    
			   
				   
			try {  
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
			       
			      
				  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				  Statement  stmtx=conx.createStatement();
				  String sqlx="update salary_view set balance=balance+salary";
				  PreparedStatement psx=conx.prepareStatement(sqlx);
				//  ResultSet rsx=psx.executeQuery();
				  
				   
				   ResultSet RS=stmtx.executeQuery(sqlx);
				 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
				  
				    
				   
				  
				   
				   JOptionPane.showMessageDialog(null,"Salary successfully provided to all the employees");
				
				
				   try {  
						
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conN=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtN=conN.createStatement();
						  String sqlN="select * from salary_view";
						  PreparedStatement psN=conN.prepareStatement(sqlN);
						//  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RSN=stmtx.executeQuery(sqlN);
						 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
						  
						    
						   
						  
						   if(RSN.next())
						   { jt.setModel(DbUtils.resultSetToTableModel(RSN)); }
						
						
						
						
						   conx.close();
						
						
						
					   }
					catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
				
				
				
				
			   }
			catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				       
				    
			 
			
	    }
			
			
			else if(ae.getSource()==b3 )
			{    
				   
					   
					       adminMenu t =new adminMenu();
					        t.setVisible(true);
					       this.setVisible(false);
					       
					    
				 
				
		    }
		 
		
}


 
  

}





class studentViewingRegistration extends JFrame implements ActionListener
{ 
JButton b1,b2,b3,b4; 
 JTextField t1,t2,t3,t4,t5,tx;
  JLabel l1,l2,l3,l4,l5,lx,ly,ll1,ll2,ll3,ll4,ll5;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	   JTable jt;
	  JPanel heading;
	  String courseCode=new String();
	  	String id,password,userType;
		 
	
	 


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.RED);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});} 





	studentViewingRegistration()
	{   super("Student Viewing Courses");



	 



////////////////////////////////////////////
	   
   	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,870);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(true);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("    Available Courses");
		 header.setBounds( 400,3,900,80);
		header.setFont(f);
		header.setForeground(Color.CYAN);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page3.jpg");

		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(100,100,1300,700);
		  p1.setBackground(new Color(0,0,10,60));
		p1.setLayout(null);
		 
	 
		  
		 
		 
		  b1=new JButton("Refresh");
		  b1.setBounds(380,630,200,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      
		  
		  p1.add(b1);
		  
		  
		 
		 
		 
		 
		 
		 
		    
		 
		 
		 
		 
		 
		  b3=new JButton("Back");
		  b3.setBounds(900,630,200,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		   
		 
		 
	        
	      //  p1.add(j);
		 
		   
	        JScrollPane jsp=new JScrollPane();
	        jsp.setBounds(100, 100, 1100, 500);
	        jsp.setVisible(true);
	        p1.add(jsp);

		 
		
		
		
	        jt = new JTable( );
	        jt.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
	        jt.setRowHeight(30);
	        jsp.setViewportView(jt);
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
		
		
		jt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			TableModel tmodel = jt.getModel();
			int selectedRowIndex=jt.getSelectedRow();
			 
		 
			 
			 
			 
			 
			}});
		
		
		
		
		
		 
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
		      
			  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			  Statement  stmtx=conx.createStatement();
			  String sqlx="select * from unlockable_courses";
			  PreparedStatement psx=conx.prepareStatement(sqlx);
			//  ResultSet rsx=psx.executeQuery();
			  
			   
			   ResultSet RS=stmtx.executeQuery(sqlx);
			 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
			  
			    
			   
			  
			   if(RS.next())
			   { jt.setModel(DbUtils.resultSetToTableModel(RS));
			   
			   
			   Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
			      
				  Connection conxw=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				  Statement  stmtxw=conxw.createStatement();
				  String sqlxw="select id from loggedinTable";
				  PreparedStatement psxw=conxw.prepareStatement(sqlxw);
				//  ResultSet rsx=psx.executeQuery();
				  
				   
				   ResultSet RSw=stmtx.executeQuery(sqlxw);
				   
				   if(RSw.next())
				   {
					   
					   id=RSw.getString("id");
					   
					   conx.close();
				   }
			   
			   
			   
			   
			   }
			
			
			
			    
			
			
			
			
		   }
		catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
		
	}




public void actionPerformed(ActionEvent ae)
		{   if(ae.getSource()==b1 )
			{    
				try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtx=conx.createStatement();
					  String sqlx="select * from unlockable_courses";
					  PreparedStatement psx=conx.prepareStatement(sqlx);
					//  ResultSet rsx=psx.executeQuery();
					  
					   
					   ResultSet RS=stmtx.executeQuery(sqlx);
					 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
					  
					    
					   
					  
					   if(RS.next())
					   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
					
					
					
					
					
					   conx.close();
					
					
				   }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				 
		    }
		
		
		else if(ae.getSource()==b2 )
		{    
			   
				   
			try {  
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
			       
			      
				  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				  Statement  stmtx=conx.createStatement();
				  String sqlx="begin fresher_registration; end;";
				  PreparedStatement psx=conx.prepareStatement(sqlx);
				//  ResultSet rsx=psx.executeQuery();
				  
				   
				   ResultSet RS=stmtx.executeQuery(sqlx);
				 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
				  
				    
				   
				  
				    
				
				    
				
				   conx.close();
				
				
				
				
			   }
			catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
				       
				    
			 
			
	    }
			
			
			else if(ae.getSource()==b3 )
			{    
				   
					   
					       studentMenu t =new studentMenu(id);
					        t.setVisible(true);
					       this.setVisible(false);
					       
					    
				 
				
		    }
		 
		
}


 
  

}















class adminViewingResults extends JFrame implements ActionListener
{ 
JButton b1,b2,b3,b4; 
 JTextField t1,t2,t3,t4,t5,tx;
  JLabel l1,l2,l3,l4,l5,lx,ly,ll1,ll2,ll3,ll4,ll5;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	   JTable jt;
	  JPanel heading;
	  String courseCode=new String();
	  	String id,password,userType;
		 
 


 





	adminViewingResults()
	{   super("Admin Viewing Results");



	 



////////////////////////////////////////////
	   
   	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,870);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(true);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("      All Results");
		 header.setBounds( 400,3,900,80);
		header.setFont(f);
		header.setForeground(Color.CYAN);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page2.jpg");

		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(100,100,1300,700);
		  p1.setBackground(new Color(0,0,10,60));
		p1.setLayout(null);
		 
		/*  lx = new JLabel("CGPA:");
		  lx.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      lx.setForeground(Color.yellow);
		  lx.setBounds(430,10,200,50);
		  lx.setBackground(Color.WHITE);
		  p1.add(lx);
		  
		  tx=new JTextField( );
		  tx.setFont(f2);
		  tx.setBounds(520,10,130,50);
		  tx.addActionListener(this);
		  tx.setForeground(Color.black);
		  tx.setBackground(Color.white);
		  tx.setEditable(false);
		  
		  p1.add(tx); */
		  
		 
		 
		  b1=new JButton("Refresh");
		  b1.setBounds(380,630,200,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      ylw(b1);
		  
		  p1.add(b1);
		  
		  
		/*  b2=new JButton("Auto Register");
		  b2.setBounds(160,630,200,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		      ylw(b2);
		   
		  //p1.add(b2);  */
		  
		  
		/*  b4=new JButton("Auto Register");
		  b4.setBounds(160,630,200,50);
		  b4.setFont(f2);
		  //b3.setVisible(false);
		  b4.addActionListener(this);
		  
		      ylw(b2);
		  
		  p1.add(b2); */
		 
		 
		 
		 
		 
		    
		 
		 
		 
		 
		 
		  b3=new JButton("Back");
		  b3.setBounds(900,630,200,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		   
		 
		 
	        
	      //  p1.add(j);
		 
		   
	        JScrollPane jsp=new JScrollPane();
	        jsp.setBounds(100, 100, 1100, 500);
	        jsp.setVisible(true);
	        p1.add(jsp);

		 
		
		
		
	        jt = new JTable( );
	        jt.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
	        jt.setRowHeight(30);
	        jsp.setViewportView(jt);
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
		
		
		jt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			TableModel tmodel = jt.getModel();
			int selectedRowIndex=jt.getSelectedRow();
			 
		 
			 
			 
			 
			 
			}});
		
		
		
		
		
		 
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
		      
			  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			  Statement  stmtx=conx.createStatement();
			  String sqlx="select * from admin_viewing_csrt";
			  PreparedStatement psx=conx.prepareStatement(sqlx);
			//  ResultSet rsx=psx.executeQuery();
			  
			   
			   ResultSet RS=stmtx.executeQuery(sqlx);
			 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
			  
			    
			   
			  
			   if(RS.next())
			   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
			
			
			
			    
			
			   conx.close();
			
			
		   }
		catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
		
	}




public void actionPerformed(ActionEvent ae)
		{   if(ae.getSource()==b1 )
			{    
				try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtx=conx.createStatement();
					  String sqlx="select * from admin_viewing_csrt";
					  PreparedStatement psx=conx.prepareStatement(sqlx);
					//  ResultSet rsx=psx.executeQuery();
					  
					   
					   ResultSet RS=stmtx.executeQuery(sqlx);
					 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
					  
					    
					   
					  
					   if(RS.next())
					   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
					
					
					
					
					   conx.close();
					
					
					
				   }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
				 
		    }
		
		
		else if(ae.getSource()==b2 )
		{    
			   
				   
			try {  
				
				/*Class.forName("oracle.jdbc.driver.OracleDriver"); 
			       
			      
				  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				  Statement  stmtx=conx.createStatement();
				  String sqlx="begin fresher_registration; end;";
				  PreparedStatement psx=conx.prepareStatement(sqlx);
				//  ResultSet rsx=psx.executeQuery();
				  
				   
				   ResultSet RS=stmtx.executeQuery(sqlx);
				 //  jt.setModel(DbUtils.resultSetToTableModel(RS)); */
				  
				    
				   
				  
				    
				
				    
				
				
				
				
				
				
			   }
			catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				       
				    
			 
			
	    }
			
			
			else if(ae.getSource()==b3 )
			{    
				   
					   
					       adminMenu t =new adminMenu();
					        t.setVisible(true);
					       this.setVisible(false);
					       
					    
				 
				
		    }
		 
		
}


 
  

}






class studentViewingResults extends JFrame implements ActionListener
{ 
JButton b1,b2,b3,b4; 
 JTextField t1,t2,t3,t4,t5,tx;
  JLabel l1,l2,l3,l4,l5,lx,ly,ll1,ll2,ll3,ll4,ll5;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	   JTable jt;
	  JPanel heading;
	  String courseCode=new String();
	  	String id,password,userType;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.YELLOW);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.RED);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});} 





	studentViewingResults()
	{   super("Student Viewing Result");



	 



////////////////////////////////////////////
	   
   	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,870);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(true);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("       Your Result");
		 header.setBounds( 400,3,900,80);
		header.setFont(f);
		header.setForeground(Color.CYAN);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page3.jpg");

		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(100,100,1300,700);
		  p1.setBackground(new Color(0,0,10,60));
		p1.setLayout(null);
		 
		  lx = new JLabel("CGPA:");
		  lx.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      lx.setForeground(Color.yellow);
		  lx.setBounds(430,10,200,50);
		  lx.setBackground(Color.WHITE);
		  p1.add(lx);
		  
		  tx=new JTextField( );
		  tx.setFont(f2);
		  tx.setBounds(520,10,130,50);
		  tx.addActionListener(this);
		  tx.setForeground(Color.black);
		  tx.setBackground(Color.white);
		  tx.setEditable(false);
		  
		  p1.add(tx);
		  
		 
		 
		  b1=new JButton("Refresh");
		  b1.setBounds(380,630,200,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      ylw(b1);
		  
		  p1.add(b1);
		 
		 
		 
		 
		 
		    
		 
		 
		 
		 
		 
		  b3=new JButton("Back");
		  b3.setBounds(600,630,200,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		   
		 
		 
	        
	      //  p1.add(j);
		 
		   
	        JScrollPane jsp=new JScrollPane();
	        jsp.setBounds(100, 100, 1100, 500);
	        jsp.setVisible(true);
	        p1.add(jsp);

		 
		
		
		
	        jt = new JTable( );
	        jt.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
	        jt.setRowHeight(30);
	        jsp.setViewportView(jt);
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
		
		
		jt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			TableModel tmodel = jt.getModel();
			int selectedRowIndex=jt.getSelectedRow();
			 
		 
			 
			 
			 
			 
			}});
		
		
		
		
		
		 
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
		      
			  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			  Statement  stmtx=conx.createStatement();
			  String sqlx="select * from csrt_this_student";
			  PreparedStatement psx=conx.prepareStatement(sqlx);
			//  ResultSet rsx=psx.executeQuery();
			  
			   
			   ResultSet RS=stmtx.executeQuery(sqlx);
			 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
			  
			    
			   
			  
			   if(RS.next())
			   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
			
			
			
			    
			
			conx.close();
			
			
		   }
		catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
		
	}




public void actionPerformed(ActionEvent ae)
		{   if(ae.getSource()==b1 )
			{    
				try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtx=conx.createStatement();
					  String sqlx="select * from csrt_this_student";
					  PreparedStatement psx=conx.prepareStatement(sqlx);
					//  ResultSet rsx=psx.executeQuery();
					  
					   
					   ResultSet RS=stmtx.executeQuery(sqlx);
					 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
					  
					    
					   
					  
					   if(RS.next())
					   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
					
					
					
					
					
					   conx.close();
					
					
				   }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				 
		    }
		
		
		 
			
			
			else if(ae.getSource()==b3 )
			{    
				
                 try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conP=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtP=conP.createStatement();
					  String sqlP="select id from loggedinTable";
					  PreparedStatement psP=conP.prepareStatement(sqlP);
					 
					  
					   
					   ResultSet RSP=stmtP.executeQuery(sqlP);
					  
					     
					    
					   
					  
					   if(RSP.next())
					   { id=RSP.getString("id");
					   
					       studentMenu t =new studentMenu(id);
					        t.setVisible(true);
					       this.setVisible(false);
					       
					   
					   }
					
					
					
					
					
					
					
					
				      }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				
		    }
		 
		
}


 
  

}
class updateMarks extends JFrame implements ActionListener
{ 
JButton b1,b2,b3,b4; 
 JTextField t1,t2,t3,t4,t5,tx;
  JLabel l1,l2,l3,l4,l5,lx,ly,ll1,ll2,ll3,ll4,ll5;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	   JTable jt;
	  JPanel heading;
	  String courseCode=new String();
	  	String id,password,userType;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.YELLOW);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                 j.setBackground(Color.RED);
                  }

               public void mouseExited(java.awt.event.MouseEvent evt) {
             j.setBackground(UIManager.getColor("control"));
   }});} 





updateMarks()
	{   super("Teacher Updating Marks");



	 



////////////////////////////////////////////
	   
   	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,870);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(true);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("      Update Marks");
		 header.setBounds( 400,3,900,80);
		header.setFont(f);
		header.setForeground(Color.YELLOW);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("pagex.jpg");

		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(100,100,1300,700);
		  p1.setBackground(new Color(0,0,10,60));
		p1.setLayout(null);
		 
		  lx = new JLabel("Student ID:");
		  lx.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      lx.setForeground(Color.yellow);
		  lx.setBounds(30,10,200,50);
		  lx.setBackground(Color.WHITE);
		  p1.add(lx);
		  
		  tx=new JTextField( );
		  tx.setFont(f2);
		  tx.setBounds(220,10,190,50);
		  tx.addActionListener(this);
		  tx.setForeground(Color.black);
		  tx.setBackground(Color.CYAN);
		  
		  p1.add(tx);
		  
		 
		 
		  b1=new JButton("Refresh");
		  b1.setBounds(500,630,200,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      ylw(b1);
		  
		  p1.add(b1);
		 
		 
		 
		 
		 
		   b2=new JButton("Publish");
		  b2.setBounds(120,630,250,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		      ylw(b2);
		  
		  p1.add(b2);
		 
		 
		 
		 
		 
		  b3=new JButton("Back");
		  b3.setBounds(800,630,200,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		  l1 = new JLabel("Attendance:");
		  l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      l1.setForeground(Color.yellow);
		  l1.setBounds(30,110,200,50);
		  p1.add(l1);
		  
		  
		  t1=new JTextField( );
		  t1.setFont(f2);
		  t1.setBounds(200,110,100,50);
		  t1.addActionListener(this);
		  p1.add(t1);
		  
		  
		  ll1 = new JLabel("/10");
		  ll1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      ll1.setForeground(Color.yellow);
		  ll1.setBounds(310,110,50,50);
		  p1.add(ll1);
		  
		  
		  l2 = new JLabel("Quiz:");
		  l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      l2.setForeground(Color.yellow);
		  l2.setBounds(30,210,200,50);
		  p1.add(l2);
		  
		  
		  t2=new JTextField( );
		  t2.setFont(f2);
		  t2.setBounds(200,210,100,50);
		  t2.addActionListener(this);
		  p1.add(t2);
		  
		  ll2 = new JLabel("/20");
		  ll2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      ll2.setForeground(Color.yellow);
		  ll2.setBounds(310,210,50,50);
		  p1.add(ll2);
		  
		  l3 = new JLabel("Assignment:");
		  l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      l3.setForeground(Color.yellow);
		  l3.setBounds(30,310,200,50);
		  p1.add(l3);
		  
		  
		  t3=new JTextField( );
		  t3.setFont(f2);
		  t3.setBounds(200,310,100,50);
		  t3.addActionListener(this);
		  p1.add(t3);
		  
		  
		  ll3 = new JLabel("/20");
		  ll3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      ll3.setForeground(Color.yellow);
		  ll3.setBounds(310,310,50,50);
		  p1.add(ll3);
		  
		  l4 = new JLabel("Assessment:");
		  l4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      l4.setForeground(Color.yellow);
		  l4.setBounds(30,410,200,50);
		  p1.add(l4);
		  
		  
		  t4=new JTextField( );
		  t4.setFont(f2);
		  t4.setBounds(200,410,100,50);
		  t4.addActionListener(this);
		  p1.add(t4);
		  
		  ll4 = new JLabel("/50");
		  ll4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      ll4.setForeground(Color.yellow);
		  ll4.setBounds(310,410,50,50);
		  p1.add(ll4);
		  
		  l5 = new JLabel("Bonus:");
		  l5.setFont(new Font("Comic Sans MS",Font.BOLD,25));
	      l5.setForeground(Color.yellow);
		  l5.setBounds(30,510,200,50);
		  p1.add(l5);
		  
		  
		  t5=new JTextField( );
		  t5.setFont(f2);
		  t5.setBounds(200,510,100,50);
		  t5.addActionListener(this);
		  p1.add(t5);
		 
		 
		 
	        
	      //  p1.add(j);
		 
		   
	        JScrollPane jsp=new JScrollPane();
	        jsp.setBounds(500, 100, 700, 500);
	        jsp.setVisible(true);
	        p1.add(jsp);

		 
		
		
		
	        jt = new JTable( );
	        jt.setFont(new Font("Arial Rounded MT", Font.PLAIN, 20));
	        jt.setRowHeight(30);
	        jsp.setViewportView(jt);
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
		
		
		jt.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			TableModel tmodel = jt.getModel();
			int selectedRowIndex=jt.getSelectedRow();
			//ly.setVisible(true);
			tx.setText(tmodel.getValueAt(selectedRowIndex, 2).toString());
			tx.setEditable(false);
			t1.setText("0");
			 t2.setText("0");
			 t3.setText("0");
			 t4.setText("0");
			 t5.setText("0");
			 
			 courseCode=tmodel.getValueAt(selectedRowIndex, 0).toString();
			 
			// t5.setText("0");
			}});
		
		
		
		
		
		 
		try {  
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		       
		      
			  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			  Statement  stmtx=conx.createStatement();
			  String sqlx="select * from csrt_this_teacher";
			  PreparedStatement psx=conx.prepareStatement(sqlx);
			//  ResultSet rsx=psx.executeQuery();
			  
			   
			   ResultSet RS=stmtx.executeQuery(sqlx);
			 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
			  
			    
			   
			  
			   if(RS.next())
			   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
			
			
			
			    
			   conx.close();
			
			
			
		   }
		catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
		
	}




public void actionPerformed(ActionEvent ae)
		{   if(ae.getSource()==b1 )
			{    
				try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtx=conx.createStatement();
					  String sqlx="select * from csrt_this_teacher";
					  PreparedStatement psx=conx.prepareStatement(sqlx);
					//  ResultSet rsx=psx.executeQuery();
					  
					   
					   ResultSet RS=stmtx.executeQuery(sqlx);
					 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
					  
					    
					   
					  
					   if(RS.next())
					   { jt.setModel(DbUtils.resultSetToTableModel(RS)); }
					
					
					
					   conx.close();
					
					
					
					
				   }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				 
		    }
		
		
		else if(ae.getSource()==b2 )
			{   
				
				 try {  int m1=Integer.parseInt(t1.getText());
				        int m2=Integer.parseInt(t2.getText());
				        int m3=Integer.parseInt(t3.getText());
				        int m4=Integer.parseInt(t4.getText());
				        int m5=Integer.parseInt(t5.getText());
				 
				        m1=m1+m2+m3+m4+m5;
				 
				        //JOptionPane.showMessageDialog(null,"TOTAL MARKS of \n"+"Student "+tx.getText()+" will be "+String.valueOf(m1)+" \nPublish?");
				        
				        int x=JOptionPane.showConfirmDialog(this,"TOTAL MARKS of \n"+"Student "+tx.getText()+" will be "+String.valueOf(m1)+" \nPublish?","PUBLISH?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				        
				        if(x==JOptionPane.YES_OPTION)
						  {
							   
				        	Class.forName("oracle.jdbc.driver.OracleDriver"); 
						      
						      
							  Connection conR=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
							   Statement  stmtR=conR.createStatement();
							 
							 String sqlR="begin  update_marks('"+tx.getText()+"','"+courseCode+"',"+String.valueOf(m1)+"); end;";
							  PreparedStatement psR=conR.prepareStatement(sqlR);
							  ResultSet rsR=stmtR.executeQuery(sqlR);
							  
							  
							  
							  try {  
									
									Class.forName("oracle.jdbc.driver.OracleDriver"); 
								       
								      
									  Connection conE=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
									  Statement  stmtE=conE.createStatement();
									  String sqlE="select * from csrt_this_teacher";
									  PreparedStatement psE=conE.prepareStatement(sqlE);
									//  ResultSet rsx=psx.executeQuery();
									  
									   
									   ResultSet RSE=stmtE.executeQuery(sqlE);
									 //  jt.setModel(DbUtils.resultSetToTableModel(RS));
									  
									    
									   
									  
									   if(RSE.next())
									   { jt.setModel(DbUtils.resultSetToTableModel(RSE)); }
									
									
									
									
									
									
									
									
								   }
								catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
							  
						  }
				 
				 }
				 catch(Exception e){JOptionPane.showMessageDialog(null,"Fill up the fields properly!");
				 
				  
				 }
		    }
			
			
			else if(ae.getSource()==b3 )
			{    
				
                 try {  
					
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
				       
				      
					  Connection conP=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
					  Statement  stmtP=conP.createStatement();
					  String sqlP="select id from loggedinTable";
					  PreparedStatement psP=conP.prepareStatement(sqlP);
					 
					  
					   
					   ResultSet RSP=stmtP.executeQuery(sqlP);
					  
					     
					    
					   
					  
					   if(RSP.next())
					   { id=RSP.getString("id");
					   
					        teacherMenu t =new teacherMenu(id);
					        t.setVisible(true);
					         this.setVisible(false);
					       
					   
					   }
					
					
					
					
					
					
					
					
				      }
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				
		    }
		 
		
}


 
	 
	 
	  
	 
 


 

}

class addStudent extends JFrame implements ActionListener
 {  
  JButton b1,b2,b3; 
  JTextField t1,t2,t3;
   JLabel l1,l2,l3,l4;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
		 
		 
			public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	 
			
			
			public void grn(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
               j.setBackground(Color.GREEN);
                }

             public void mouseExited(java.awt.event.MouseEvent evt) {
           j.setBackground(UIManager.getColor("control"));
 }});} 
		 
		 
	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	 	 
		 
	
	 addStudent()
	{  super("Student Registration");
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,50);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
	    setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		
	   heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,70));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Student Registration");
		 header.setBounds( 500,3,600,80);
		header.setFont(f);
		header.setForeground(Color.green);
		//heading.add(header);
		
		 
		
		 ImageIcon background_image=new ImageIcon("page6.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		 
		 //
		 
	      p1=new JPanel();
	     p1.setSize(800,500);
		 p1.setBounds(250,200,1000,800);
		 p1.setBackground(new Color(0,0,0,30));
		 p1.setLayout(null);
		 
		  p2=new JPanel();
		// p1.setSize(600,500);
		 p2.setBounds(400,200,700,600);
		  p2.setBackground(new Color(0,0,0,0));
		 p2.setLayout(null);
		 
		  l1 = new JLabel("Enter his/her Name:");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l1.setForeground(Color.yellow);
		l1.setBounds(50,120,1000,50);
		p1.add(l1);
		
		 
		 t1=new JTextField( );
		 t1.setFont(f2);
		 t1.setBounds(370,120,450,50);
	     t1.addActionListener(this);
		 p1.add(t1);
		 
		 l2 = new JLabel("Enter a Password:");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.yellow);
		l2.setBounds(50,190,1000,50);
		p1.add(l2);
		
		
		/*l3 = new JLabel("Enter a Password:");
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.yellow);
		l3.setBounds(50,260,1000,50);
		p1.add(l3);*/
		 
		  t2=new JTextField( );
		  t2.setFont(f2);
		  t2.setBounds(370,190,450,50);
	      t2.addActionListener(this);
		  p1.add(t2);
		  
		  
		 /* t3=new JTextField( );
		  t3.setFont(f2);
		  t3.setBounds(370,260,450,50);
	      t3.addActionListener(this);
		  p1.add(t3); */
		 
		 
		 
		 
		 
		 l3 = new JLabel( );
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.white);
		l3.setBounds(200,400,250,50);
		p1.add(l3);
		
	 
		   b1=new JButton("Register Student");
		 b1.setBounds(280,430,400,50);
		  b1.setFont(f2);
		  b1.setForeground(Color.black);
		  b1.addActionListener(this);
		  
		   grn(b1);
		  
		 p1.add(b1);
		  
		   b2=new JButton("Back");
		  b2.setBounds(170,490,300,50);
		  b2.setFont(f2);
		   
		  b2.addActionListener(this);
		  
		      ylw(b2);
		  p2.add(b2);
		  
		  
		   l2 = new JLabel("Select Department:");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.yellow);
		l2.setBounds(50,260,1000,50);
		p1.add(l2);
		 
		 String[] departments={"CSE"};
		 
		 JComboBox comboBox = new JComboBox(departments);
		 comboBox.setBounds(220,260,150,50);
		 comboBox.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		 comboBox.setVisible(true);
		   p2.add(comboBox);
		   
		   String[] semesters={"Summer 2022"};
		    JComboBox comboBox2 = new JComboBox(semesters);
		 comboBox2.setBounds(220,320,250,50);
		 comboBox2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		 comboBox2.setVisible(true);
		   p2.add(comboBox2);
		   
		l4 = new JLabel("Select Session:");
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l4.setForeground(Color.yellow);
		l4.setBounds(50,320,1000,50);
		p1.add(l4);
		   
		 
	 
		//  
		 
		 
		 
	 
		
	 
		
		  this.add(p1);
		  this.add(p2);
		  background.add(header);
		 add(background);
		 
		setVisible(true);
		
		  if(t1.getText()==null || t2.getText()==null )
			 {b1.setText("Texfields Are Empty!!!"); }
		 
	}
 
 
      void Delay(Long ms){

       Long dietime = System.currentTimeMillis()+ms;
       while(System.currentTimeMillis()<dietime){
           //do nothing
       }
   }

 
 
 public void actionPerformed(ActionEvent ae)
		{     
		    
				   
			
			if(ae.getSource()==b1  )
			{ 
				if(t1.getText().equals("")==false && t2.getText().equals("")==false)
				{
		
		        String max_id;
		
		
		
		
		
		
				try
					 {    
					     /* Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtx=conx.createStatement();
						  String sqlx="select max(id) max_id from all_students";
						  PreparedStatement psx=conx.prepareStatement(sqlx);
						  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RS=stmtx.executeQuery(sqlx);  
						  
						    
						   
						  
						   
						      max_id = RS.getString("max_id");
						    
							  int x=Integer.parseInt(max_id.substring(3,8));
							  x=x+1;
							  max_id="22-"+Integer.toString(x)+"-2"; 
						 
					
							   //JOptionPane.showMessageDialog(null,"Successful, "+max_id); */
							  
						Class.forName("oracle.jdbc.driver.OracleDriver"); 
					      
					      
						  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						   Statement  stmtx=con.createStatement();
						 // String sql="insert into all_students values('"+t1.getText()+"','"+max_id+"','"+t2.getText()+"','CSE',null,0,to_date('24-JUL-22','dd-mm-yyyy'),null,'Studying')";
						 String sql="begin register_student('"+t1.getText()+"','"+t2.getText()+"'); end;";
						  PreparedStatement ps=con.prepareStatement(sql);
						  ResultSet rsX=stmtx.executeQuery(sql);
						  
						 
						  
						   
							 // JOptionPane.showMessageDialog(null,"Registration successful\n Your new ID  is      : "+max_id+"\n and Password is  : "+t2.getText());
							 
							 
						  Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conw=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtw=conw.createStatement();
						  String sqlw="select max(id) max_id from all_students";
						  PreparedStatement psw=conw.prepareStatement(sqlw);
						  //ResultSet rsw=psw.executeQuery();
						  
						   
						   ResultSet RSw=stmtw.executeQuery(sqlw);  
						   
						   if(RSw.next())
						   {
							  max_id = RSw.getString("max_id"); 
							   
							  JOptionPane.showMessageDialog(null,"Registration successful\nYour new ID  is     : "+max_id+"\nand Password is  : "+t2.getText());
							   
						   }
							 
							 //JOptionPane.showMessageDialog(null,"Registration successful");
							  
							  
						  
						  
						   
						  
						 // else{JOptionPane.showMessageDialog(null,"Registration Failed!");}
						 
						 
						  
						  
						 
					 }
					 
					 
					 
					  catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
					 
					 

			    }
				
				else  
				 {JOptionPane.showMessageDialog(null,"One or more text fields are empty, try again!");} 
			}
			 
			 
		
			else if(ae.getSource()==b2)
					 {
						 adminMenu d=new adminMenu();
						 this.setVisible(false);
						 d.setVisible(true);
						 
						 
					 }
					 
					 
			 		 
			else  
			 {JOptionPane.showMessageDialog(null,"Text fields are empty, try again!"); } 
			 
			
			
		}
 
	 
 
 
 
 
 }
 
  


class logIn extends JFrame implements ActionListener
 {  
  JButton b1,b2,b3; 
  JTextField t1;
   JLabel l1,l2,l3;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
	  JPasswordField t2;
		 
		 
			public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	 
		 
		 
		public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	 
		 
	
	 logIn()
	{  super("Log In Page");
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,50);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
	    setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		
	   heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,70));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("  LOG  IN  PAGE");
		 header.setBounds( 500,4,500,80);
		header.setFont(f);
		header.setForeground(Color.WHITE);
		//heading.add(header);
		
		 
		
		 ImageIcon background_image=new ImageIcon("page2.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		 
		 //
		 
	      p1=new JPanel();
	     p1.setSize(600,500);
		 p1.setBounds(400,200,700,800);
		 p1.setBackground(new Color(0,0,0,30));
		 p1.setLayout(null);
		 
		  p2=new JPanel();
		// p1.setSize(600,500);
		 p2.setBounds(400,200,700,800);
		  p2.setBackground(new Color(0,0,0,0));
		 p2.setLayout(null);
		 
		  l1 = new JLabel("Enter Your ID :");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l1.setForeground(Color.white);
		l1.setBounds(90,100,1000,50);
		p1.add(l1);
		
		 
		 t1=new JTextField( );
		 t1.setFont(f2);
		 t1.setBounds(320,100,250,50);
	     t1.addActionListener(this);
		 p1.add(t1);
		 
		 l2 = new JLabel("Enter Password:");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.white);
		l2.setBounds(90,170,1000,50);
		p1.add(l2);
		 
		  t2=new JPasswordField( );
		  t2.setFont(f2);
		  t2.setBounds(320,170,250,50);
	      t2.addActionListener(this);
		  p1.add(t2);
		 
		 
		 
		 b1=new JButton("Log In");
		 b1.setBounds(180,280,300,50);
		  b1.setFont(f2);
		  b1.addActionListener(this);
		  
		   ylw(b1);
		  
		 p1.add(b1);
		 
		 l3 = new JLabel( );
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.white);
		l3.setBounds(200,400,250,50);
		p1.add(l3);
		
		 b2=new JButton("Proceed");
		 b2.setBounds(180,350,300,50);
		  b2.setFont(f2);
		  b2.setVisible(false);
		  b2.addActionListener(this);
		  
		       ylw(b2);
		  
		  p2.add(b2);
		  
		  
		   b3=new JButton("Back");
		  b3.setBounds(180,350,300,50);
		  b3.setFont(f2);
		  b3.setVisible(true);
		  b3.addActionListener(this);
		  
		      ylw(b3);
		  p2.add(b3);
		 
		 
		 
	 
		//
		 
		 
		 
	 
		
	 
		
		  this.add(p1);
		  this.add(p2);
		  background.add(header);
		 add(background);
		 
		setVisible(true);
		
		
	}
 
 
      void Delay(Long ms){

       Long dietime = System.currentTimeMillis()+ms;
       while(System.currentTimeMillis()<dietime){
           //do nothing
       }
   }

 
 
 public void actionPerformed(ActionEvent ae)
		{     
		    String id=t1.getText();
			boolean is_admin=false;
				   
			
			if(ae.getSource()==b1)
			{     


                     if(t1.getText().equals("alpha") && t2.getText().equals("omega") )
					 {
						  int x=JOptionPane.showConfirmDialog(this,"Admin Log In Successful, Continue?","Success",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					   if(x==JOptionPane.YES_OPTION)
					   {	
                          try{
													    Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						                                Connection conX=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						                                Statement  stmtX=conX.createStatement();
						                                String sqlX="begin update_loggedinTable('alpha','omega','admin');  end;";
					         	                        PreparedStatement psX=conX.prepareStatement(sqlX);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
						                                ResultSet rsX=stmtX.executeQuery(sqlX); conX.close();
														
						     }
				 
				         catch(Exception e){JOptionPane.showMessageDialog(null,e); }

                        is_admin=true;
				         
						adminMenu a=new adminMenu( );
						a.setVisible(true); 
						this.setVisible(false);
						 
				         
						
					   }
						 
						 
					 }


          if(is_admin==false)
		  {


           		try
					 {    Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmt=con.createStatement();
						  String sql="select * from all_students where id='"+t1.getText()+"' and password='"+t2.getText()+"'";
						  PreparedStatement ps=con.prepareStatement(sql);
						  ResultSet rs=ps.executeQuery();
						  
						   
						   ResultSet rs2=stmt.executeQuery(sql);
						  
						    
						   
						  
						  if(rs2.next())
						  { 
						      String name = rs2.getString("name");
						    
							
						    int x=JOptionPane.showConfirmDialog(this,"Student Log In Successful, continue?","Success",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
							  if(x==JOptionPane.YES_OPTION)
							  {
								   try{
													    Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						                                Connection con2x=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						                                Statement  stmt2x=con2x.createStatement();
						                                String sql4="begin update_loggedinTable('"+t1.getText()+"','"+t2.getText()+"','student');  end;";
					         	                        PreparedStatement psxxx=con2x.prepareStatement(sql4);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
						                                ResultSet rs3x=stmt.executeQuery(sql4);
														
														}
				 
				                                         catch(Exception e){JOptionPane.showMessageDialog(null,e); }
								   
								   studentMenu u =new  studentMenu(id);
				
		                            this.setVisible(false);
				                    u.setVisible(true); 
								  
								  
							  }
							  
							  
						  }
						  
	                   else{
						         try{
						         
						         
						         Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						          Connection con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						          Statement  stmt2=con2.createStatement();
						          String sql3="select * from all_teachers where id='"+t1.getText()+"' and password='"+t2.getText()+"'";
					         	  PreparedStatement psxx=con2.prepareStatement(sql3);
						          ResultSet rs2x=psxx.executeQuery();
						  
						   
						          ResultSet rs3=stmt.executeQuery(sql3);
						             
						            
						              
						            if(rs3.next())
						                     { 
						                       String name = rs3.getString("name");
						    
							
						                         int x=JOptionPane.showConfirmDialog(this,"Teacher Log In Successful, continue?","Success",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
							                    if(x==JOptionPane.YES_OPTION)
							                       {
													   
													   try{
													    Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						                                Connection con2x=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						                                Statement  stmt2x=con2x.createStatement();
						                                String sql4="begin update_loggedinTable('"+t1.getText()+"','"+t2.getText()+"','teacher');  end;";
					         	                        PreparedStatement psxxx=con2x.prepareStatement(sql4);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
						                                ResultSet rs3x=stmt.executeQuery(sql4);
														
														}
				 
				                                         catch(Exception e){JOptionPane.showMessageDialog(null,e); }
								                    
								    
								                     teacherMenu u =new  teacherMenu(id);
				
		                                             this.setVisible(false);
				                                      u.setVisible(true); 
								  
								  
							                       }
							  
							  
						                      }
						                      
						                else{JOptionPane.showMessageDialog(null,"Log In failed");}
						            
						            
						            
						            
						             
						            }
						         
						         catch(Exception e){JOptionPane.showMessageDialog(null,"Log In failed");}
						  
						  
						  
						  
						        //JOptionPane.showMessageDialog(null,"Log In failed");
						        
						        
						        
	                      }
						 
						 
						 
						 
					 }
					 
					 
					 
					 catch(Exception e){JOptionPane.showMessageDialog(null,"Log In failed");}
			
			
			}
			
			}
		
			else if(ae.getSource()==b2)
					 {
						/* sMenu d=new sMenu();
						 this.setVisible(false);
						 d.setVisible(true); */
						 
						 
					 }
					 
					 
			else if(ae.getSource()==b3)
					 {
						  page1 d=new page1();
						 this.setVisible(false);
						 d.setVisible(true); 
						 
						 
					 }		 
			 
			 
			
			
		}
 
 
 
 
 
 
 }




 class studentMenu extends JFrame implements ActionListener
 {  JButton b1,b2,b3,b4,bx; 
  JTextField t1,t2 ,tx1,tx2,tx3,tx4,tx5,tx6;
   JLabel l1,l2,l3,l4,l5,l6 ;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	
	
	 studentMenu(String student_id)
	{          super("User Menu");   
	String name,password,program,cgpa,cc;
	
			  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(400,180,700,800);
		  p1.setBackground(new Color(0,0,0,60));
		p1.setLayout(null);
		 
		
		 p2=new JPanel();
			// p1.setSize(600,500);
			 p2.setBounds(400,180,700,400);
			  p2.setBackground(new Color(6,5,9,60));
			p2.setLayout(null);
			p2.setVisible(false);
			
			 


	try{      
	                      
	                      Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtx=conx.createStatement();
						  String sqlx="select name,id,password,program,cgpa,credits_completed from all_students where id='"+student_id+"'";
						  PreparedStatement psx=conx.prepareStatement(sqlx);
						  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RS=stmtx.executeQuery(sqlx);
						  
						    
						   
						  
						  if(RS.next())
						  { 
						      name = RS.getString("name");
							  password = RS.getString("password");
							  program = RS.getString("program");
							  cgpa = RS.getString("cgpa");
							  cc = RS.getString("credits_completed");
						    
							  
						 		tx1 = new JTextField(); tx1.setText(name);
		                        tx1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // lx1.setForeground(Color.yellow);
		                        tx1.setBounds(350,60,300,50);
		                        tx1.setEditable(false);
		                         
		                         p2.add(tx1);
								 
								 
								tx2 = new JTextField(); tx2.setText(student_id);
		                        tx2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // lx2.setForeground(Color.yellow);
		                        tx2.setBounds(350,100,300,50);
		                        tx2.setEditable(false);
		                         p2.add(tx2);
								 
								 
								 tx3 = new JTextField(); tx3.setText(password);
		                        tx3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                        //lx3.setForeground(Color.yellow);
		                        tx3.setBounds(350,140,300,50);
		                        tx3.setEditable(false);
		                         p2.add(tx3);
								 
								 
								 tx4 = new JTextField(); tx4.setText(program);
		                        tx4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // lx4.setForeground(Color.yellow);
		                        tx4.setBounds(350,180,300,50);
		                        tx4.setEditable(false);
		                         p2.add(tx4);
								 
								 if (cgpa==null){cgpa="0";}
								 
								 tx5 = new JTextField(); tx5.setText(cgpa);
		                        tx5.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // lx5.setForeground(Color.yellow);
		                        tx5.setBounds(350,220,300,50);
		                        tx5.setEditable(false);
		                         p2.add(tx5);
								 
								 
								 tx6 = new JTextField(); tx6.setText(cc);
		                        tx6.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // lx6.setForeground(Color.yellow);
		                        tx6.setBounds(350,260,300,50);
		                        tx6.setEditable(false);
		                         p2.add(tx6);
		                         
		                         
		                         conx.close();
							    
							   
						  }
	
	
	                     }
					 
					 
					 
					 catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
	
	
	
    	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(false);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Student Account");
		 header.setBounds( 500,3,900,80);
		header.setFont(f);
		header.setForeground(Color.YELLOW);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page3.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
 
		 
		 
		 
		 
		 
		l1 = new JLabel("Student Name      : ");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l1.setForeground(Color.yellow);
		l1.setBounds(50,60,1000,50);
		p2.add(l1);


 

		
		l2 = new JLabel("Student   ID       : ");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.yellow);
		l2.setBounds(50,100,1000,50);
		p2.add(l2);
		

        l3 = new JLabel("Password            : ");
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.yellow);
		l3.setBounds(50,140,1000,50);
		p2.add(l3);
		
		
		l4 = new JLabel("Program             : ");
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l4.setForeground(Color.yellow);
		l4.setBounds(50,180,1000,50);
		p2.add(l4);
		 		
				
		l5 = new JLabel("CGPA                : ");
		l5.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l5.setForeground(Color.yellow);
		l5.setBounds(50,220,1000,50);
		p2.add(l5);
		
		
		l6 = new JLabel("Credits Completed : ");
		l6.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l6.setForeground(Color.yellow);
		l6.setBounds(50,260,1000,50);
		p2.add(l6);

		
		 
		 
		 
		    
		 
		 
		b2=new JButton("See Results");
		  b2.setBounds(180,80,300,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		  
		       ylw(b2);
		 
		       p1.add(b2);
		       
		       
		   b1=new JButton("Registration");
				  b1.setBounds(180,160,300,50);
				  b1.setFont(f2);
				  //b3.setVisible(false);
				  b1.addActionListener(this);
				  
				  
				  ylw(b1);
				 
				  p1.add(b1);
				  
				  
				  
		  b4=new JButton("Account Info");
			  b4.setBounds(180,240,300,50);
			  b4.setFont(f2);
				  //b3.setVisible(false);
			  b4.addActionListener(this);
				  
				  
			 ylw(b4);
				 
			 p1.add(b4);
		 
		 
	 
		 
		 
		  b3=new JButton("Log Out");
		  b3.setBounds(180,340,300,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		 
		 
		 
		 
		  bx=new JButton("Back");
		  bx.setBounds(180,330,300,50);
		  bx.setFont(f2);
		  //b3.setVisible(false);
		  bx.addActionListener(this);
		  
		  
		       ylw(bx);
		  
		  p2.add(bx); 
		
		
		
		
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		this.add(p2);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent ae)
		{  if(ae.getSource()==b1 )
			{ studentViewingRegistration sd = new studentViewingRegistration();
			this.setVisible(false);
			 sd.setVisible(true); 
		        }
		
		
		else if(ae.getSource()==b2 )
			{    
				
				studentViewingResults a=new studentViewingResults ();
				
		          this.setVisible(false);
				 a.setVisible(true); 
		    }
			
			
			else if(ae.getSource()==b3 )
			{   
		        page1 p=new page1();
				
				try{
				 
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
                 Connection con2x=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				 Statement  stmt2x=con2x.createStatement();
				 String sql4="begin set_loggedinTable_null; end;";
				 PreparedStatement psxxx=con2x.prepareStatement(sql4);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
				ResultSet rs3x=stmt2x.executeQuery(sql4); }
				 
				catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
				
				p.setVisible(true);
		        this.setVisible(false);
		        //this.dispose();
		    }
		
			else if(ae.getSource()==b4 )
			{    p1.setVisible(false);
			     p2.setVisible(true);
		    }
		
			else if(ae.getSource()==bx )
			{    p2.setVisible(false);
			     p1.setVisible(true);
		    }
		
		
 }
	
 
 
 }
 
 
  class teacherMenu extends JFrame implements ActionListener
 {  JButton b1,b2,b3,b4,bx,by,b5; 
  JTextField t1,t2;
   JLabel l1,l2,l3,l4,l5,l6,lx;
   JTextField tx1,tx2,tx3,tx4,tx5,tx6;
	  JPanel p1,p2,p3;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
	  int balance;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	
	
	 teacherMenu(String teacher_id)
	{          super("Teacher Menu");   
	String name,password,domain;
	
			  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(400,180,700,800);
		  p1.setBackground(new Color(0,0,6,60));
		p1.setLayout(null);
		
		p1.setVisible(true);
		 
		
		 p2=new JPanel();
			// p1.setSize(600,500);
			 p2.setBounds(400,180,700,400);
			  p2.setBackground(new Color(0,0,6,60));
			p2.setLayout(null);
			
			p2.setVisible(false);
			
			
			p3=new JPanel();
			// p1.setSize(600,500);
			 p3.setBounds(400,180,700,800);
			  p3.setBackground(new Color(0,0,6,60));
			p3.setLayout(null);
			
			p3.setVisible(false);


	try{      
	                      
	                      Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtx=conx.createStatement();
						  String sqlx="select name,id,password,domain,balance  from all_teachers where id='"+teacher_id+"'";
						  PreparedStatement psx=conx.prepareStatement(sqlx);
						  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RS=stmtx.executeQuery(sqlx);
						  
						    
						   
						  
						  if(RS.next())
						  { 
						      name = RS.getString("name");
							  password = RS.getString("password");
							  domain = RS.getString("domain");
							  balance=Integer.parseInt(RS.getString("balance"));
							 
						    
							  
						 		tx1 = new JTextField(); tx1.setText(name);
		                        tx1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                        //tx1.setForeground(Color.yellow);
		                        tx1.setBounds(350,60,300,50);
		                        tx1.setEditable(false);
		                         p2.add(tx1);
								 
								 
								tx2 = new JTextField(); tx2.setText(teacher_id);
		                        tx2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // tx2.setForeground(Color.yellow);
		                        tx2.setBounds(350,100,300,50);
		                        tx2.setEditable(false);
		                         p2.add(tx2);
								 
								 
								 tx3 = new JTextField(); tx3.setText(password);
		                        tx3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                       // tx3.setForeground(Color.yellow);
		                        tx3.setBounds(350,140,300,50);
		                        tx3.setEditable(false);
		                         p2.add(tx3);
								 
								 
								 tx4 = new JTextField(); tx4.setText(domain);
		                        tx4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                     //   tx4.setForeground(Color.yellow);
		                        tx4.setBounds(350,180,300,50);
		                        tx4.setEditable(false);
		                         p2.add(tx4);
		                         
		                         
		                         tx5 = new JTextField(); tx5.setText(String.valueOf(balance));
			                        tx5.setFont(new Font("Comic Sans MS",Font.BOLD,25));
			                        tx5.setForeground(Color.blue);
			                        tx5.setBounds(350,80,200,50);
			                        tx5.setEditable(false);
			                         p3.add(tx5);
			                         
			                         
			                         tx6 = new JTextField(); tx6.setText("0");
				                        tx6.setFont(new Font("Comic Sans MS",Font.BOLD,25));
				                     //   tx4.setForeground(Color.yellow);
				                        tx6.setBounds(350,170,200,50);
				                        
				                         p3.add(tx6);
		                         
		                         
		                     
								 
								 
				                         conx.close();
							    
							   
						  }
	
	
	                     }
					 
					 
					 
					 catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
	
	
	
    	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(false);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Teacher Account");
		 header.setBounds( 500,3,900,80);
		header.setFont(f);
		header.setForeground(Color.YELLOW);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("pagex.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		l5 = new JLabel("Account Balance    :  ");
		l5.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l5.setForeground(Color.yellow);
		l5.setBounds(50,77,1000,50);
		p3.add(l5);
		
		l6 = new JLabel("Enter Withdraw Amount: ");
		l6.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l6.setForeground(Color.yellow);
		l6.setBounds(50,170,1000,50);
		p3.add(l6);
		
 
		 
		 
		 
		 
		 
		l1 = new JLabel("Teacher Name      : ");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l1.setForeground(Color.yellow);
		l1.setBounds(50,60,1000,50);
		p2.add(l1);


 

		
		l2 = new JLabel("Teacher  ID       : ");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.yellow);
		l2.setBounds(50,100,1000,50);
		p2.add(l2);
		

        l3 = new JLabel("Password            : ");
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.yellow);
		l3.setBounds(50,140,1000,50);
		p2.add(l3);
		
		
		l4 = new JLabel("Domain              : ");
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l4.setForeground(Color.yellow);
		l4.setBounds(50,180,1000,50);
		p2.add(l4);
		 		
				
		  
		 b5=new JButton("Withdraw");
		  b5.setBounds(80,280,200,50);
		  b5.setFont(f2);
		  //b3.setVisible(false);
		  b5.addActionListener(this);
		  
		  
		  ylw(b5);
		  p3.add(b5);
		  
		  
		  by=new JButton("Back");
		  by.setBounds(380,280,200,50);
		  by.setFont(f2);
		  //b3.setVisible(false);
		  by.addActionListener(this);
		  
		  
		       red(by);
		 
		       p3.add(by);
		
		 
		 
		 
		    
		 b2=new JButton("Publish Marks");
		  b2.setBounds(180,80,300,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		  
		       ylw(b2);
		 
		       p1.add(b2);
		       
		       
		   b1=new JButton("Withdraw Salary");
				  b1.setBounds(180,160,300,50);
				  b1.setFont(f2);
				  //b3.setVisible(false);
				  b1.addActionListener(this);
				  
				  
				  ylw(b1);
				 
				  p1.add(b1);
				  
				  
				  
		  b4=new JButton("Account Info");
			  b4.setBounds(180,240,300,50);
			  b4.setFont(f2);
				  //b3.setVisible(false);
			  b4.addActionListener(this);
				  
				  
			 ylw(b4);
				 
			 p1.add(b4);
		 
		 
		  b3=new JButton("Log Out");
		  b3.setBounds(180,340,300,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		  
		  
		  bx=new JButton("Back");
		  bx.setBounds(180,290,300,50);
		  bx.setFont(f2);
		  //b3.setVisible(false);
		  bx.addActionListener(this);
		  
		  
		       ylw(bx);
		  
		  p2.add(bx);
		  
		  
		  
		 
		 
		 
		 
		   
		
		
		
		
		 
		 
		
		 
		 
	 
		
		this.add(p1);this.add(p2); this.add(p3);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent ae)
		{  if(ae.getSource()==b1 )
			{   p1.setVisible(false);
		     p3.setVisible(true);
		        }
		
		
		else if(ae.getSource()==b2 )
			{   
			updateMarks u = new updateMarks();
			u.setVisible(true);
			this.setVisible(false);
			
		    }
			
			
			else if(ae.getSource()==b3 )
			{   
		        page1 p=new page1();
				
				try{
				
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
                 Connection con2x=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				 Statement  stmt2x=con2x.createStatement();
				 String sql4="begin set_loggedinTable_null; end;";
				 PreparedStatement psxxx=con2x.prepareStatement(sql4);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
				 ResultSet rs3x=stmt2x.executeQuery(sql4);
				
				}
				 
				catch(Exception e){JOptionPane.showMessageDialog(null,"Unexpected errors have occured!");}
				p.setVisible(true);
		        this.setVisible(false);
		        //this.dispose();
		    }
		
		
			else if(ae.getSource()==b5 )
			{   
		        
				
				try{
				
				 
				 
				 
				 
				 
				 
				 
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
			       
			      
                 Connection conR=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				 Statement  stmtR=conR.createStatement();
				 String sqlR="update all_teachers set balance=balance-"+Integer.parseInt(tx6.getText())+" where id=(select id from loggedinTable)";
				 PreparedStatement psR=conR.prepareStatement(sqlR);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
				 ResultSet rsR=stmtR.executeQuery(sqlR);
				 
				 
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
			       
			      
				  Connection conK=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				  Statement  stmtK=conK.createStatement();
				  String sqlK="select  balance  from all_teachers where id=(select id from loggedinTable)";
				  PreparedStatement psK=conK.prepareStatement(sqlK);
				  ResultSet rsK=psK.executeQuery();
				  
				   
				   ResultSet RSK=stmtK.executeQuery(sqlK);
				  
				    
				   
				  
				  if(RSK.next())
				  { 
					  
					  balance=Integer.parseInt(RSK.getString("balance"));
					  tx5.setText(String.valueOf(balance));
					  
					  
					  
					  
				  }
				
				}
				 
				catch(Exception e){JOptionPane.showMessageDialog(null,e); }
				 
		        //this.dispose();
		    }
		
			else if(ae.getSource()==b4 )
			{    p1.setVisible(false);
			     p2.setVisible(true);
		    }
			else if(ae.getSource()==bx )
			{    p2.setVisible(false);
			     p1.setVisible(true);
		    }
		
			else if(ae.getSource()==by )
			{   p3.setVisible(false);
		     p1.setVisible(true);
		        }
		
		
		
		
 }
	
 
 
 }
 
 


class adminMenu extends JFrame implements ActionListener
 {  JButton b1,b2,b3,b4,b5,bx; 
  JTextField t1,t2,tx1,tx2,tx3,tx4,tx5,tx6;
   JLabel l1,l2,l3,l4,l5,l6 ;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
	  String id,password;
	  int revenue;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	
	
	 adminMenu( )
	{          super("Admin Menu");   
	 
	
			  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(400,180,700,800);
		  p1.setBackground(new Color(0,0,0,60));
		p1.setLayout(null);
		
		 p2=new JPanel();
			// p1.setSize(600,500);
			 p2.setBounds(400,180,700,400);
			  p2.setBackground(new Color(6,5,9,60));
			p2.setLayout(null);
			p2.setVisible(false);


	try{      
	                      
	                      Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtx=conx.createStatement();
						  String sqlx="select id,password,income-expenditure revenue from admin,this_semester_report";
						  PreparedStatement psx=conx.prepareStatement(sqlx);
						  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RS=stmtx.executeQuery(sqlx);
						  
						    
						   
						  
						  if(RS.next())
						  { 
						      id = RS.getString("id");
							  password = RS.getString("password");
							  revenue=Integer.parseInt(RS.getString("revenue"));
							   
							 
						    
							  
						 		tx1 = new JTextField(); tx1.setText("Admin");
		                        tx1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                        tx1.setForeground(Color.black);
		                        tx1.setBounds(350,60,300,50);
		                         p2.add(tx1);
								 
								 
								tx2 = new JTextField(); tx2.setText("alpha");
		                        tx2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                        tx2.setForeground(Color.black);
		                        tx2.setBounds(350,100,300,50);
		                         p2.add(tx2);
								 
								 
								 tx3 = new JTextField(); tx3.setText("omega");
		                        tx3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		                        tx3.setForeground(Color.black);
		                        tx3.setBounds(350,140,300,50);
		                         p2.add(tx3);
		                         
		                            tx4 = new JTextField(); tx4.setText("Tk. "+String.valueOf(revenue));
			                        tx4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
			                        tx4.setForeground(Color.black);
			                        tx4.setBounds(350,180,300,50);
			                         p2.add(tx4);
								 
								 
						    tx4.setEditable(false);
					
							    
							   
						  }
	
	
	                     }
					 
					 
					 
					 catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
	
	
	
    	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(false);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Admin Account");
		 header.setBounds( 500,3,900,80);
		header.setFont(f);
		header.setForeground(Color.YELLOW);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page2.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
 
		 
		 
		 
		 
		 
		l1 = new JLabel("Admin Name        : ");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l1.setForeground(Color.yellow);
		l1.setBounds(50,60,1000,50);
		p2.add(l1);


 

		
		l2 = new JLabel("Admin    ID       : ");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l2.setForeground(Color.yellow);
		l2.setBounds(50,100,1000,50);
		p2.add(l2);
		

        l3 = new JLabel("Password            : ");
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l3.setForeground(Color.yellow);
		l3.setBounds(50,140,1000,50);
		p2.add(l3);
		
		
	 	l4 = new JLabel("Revenue             : ");
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		l4.setForeground(Color.yellow);
		l4.setBounds(50,180,1000,50);
		p2.add(l4);
		 		
				
		 

		
		
		b5=new JButton("Register a Student");
		  b5.setBounds(180,90,300,50);
		  b5.setFont(f2);
		  //b3.setVisible(false);
		  b5.addActionListener(this);
		  
		  
		       ylw(b5);
		 
		       p1.add(b5);
		
		b2=new JButton("See All Results");
		  b2.setBounds(180,170,300,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		  
		       ylw(b2);
		 
		       p1.add(b2);
		       
		       
		   b1=new JButton("Pay Salaries");
				  b1.setBounds(180,250,300,50);
				  b1.setFont(f2);
				  //b3.setVisible(false);
				  b1.addActionListener(this);
				  
				  
				  ylw(b1);
				 
				  p1.add(b1);
				  
				  
				  
		  b4=new JButton("Account Info");
			  b4.setBounds(180,330,300,50);
			  b4.setFont(f2);
				  //b3.setVisible(false);
			  b4.addActionListener(this);
				  
				  
			 ylw(b4);
				 
			 p1.add(b4);
		 
		 
		    
		 
		 
		 
		 
		 
		  b3=new JButton("Log Out");
		  b3.setBounds(180,420,300,60);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		 
		 
		  bx=new JButton("Back");
		  bx.setBounds(180,330,300,50);
		  bx.setFont(f2);
		  //b3.setVisible(false);
		  bx.addActionListener(this);
		  
		  
		       ylw(bx);
		  
		  p2.add(bx); 
		 
		   
		
		
		
		
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		this.add(p2);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent ae)
		{  if(ae.getSource()==b5 )
			{    addStudent a = new addStudent();
			    a.setVisible(true);
			    this.setVisible(false);
		        }
		
	 
		 
		 else if(ae.getSource()==b1 )
			{    adminProvidingSalaries ad=new adminProvidingSalaries();
			     ad.setVisible(true);
				    this.setVisible(false);
		    }
		
		
		else if(ae.getSource()==b2 )
			{    adminViewingResults ad=new adminViewingResults();
			     ad.setVisible(true);
				    this.setVisible(false);
		    }
			
			
			else if(ae.getSource()==b3 )
			{   
		        page1 p=new page1();
				
				try{
				
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
                 Connection con2x=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
				 Statement  stmt2x=con2x.createStatement();
				 String sql4="begin set_loggedinTable_null; end;";
				 PreparedStatement psxxx=con2x.prepareStatement(sql4);
														
														//ResultSet rs2xx=psxx.executeQuery();
						  
						   
				 ResultSet rs3x=stmt2x.executeQuery(sql4);
				
				}
				 
				catch(Exception e){JOptionPane.showMessageDialog(null,"Unexpected errors have occured!");}
				p.setVisible(true);
		        this.setVisible(false);
		        //this.dispose();
		    }
		
			else if(ae.getSource()==b4 )
			{    p1.setVisible(false); 
		         p2.setVisible(true); 
		    }
		
			else if(ae.getSource()==bx )
			{    p2.setVisible(false); 
		         p1.setVisible(true); 
		    }
		
		
 }
	
 
 
 } 
 
 
 



 
 class page1 extends JFrame implements ActionListener
 {  JButton b1,b2,b3,b4; 
  JTextField t1,t2;
   JLabel l1,l2,l3;
	  JPanel p1,p2;
	  JLabel background;
	   JLabel header;
	  JPanel heading;
	  	String id,password,userType;
		 
	
		public void ylw(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.YELLOW);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});}


	public void red(JButton j){   j.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseEntered(java.awt.event.MouseEvent evt) {
                  j.setBackground(Color.RED);
                   }

                public void mouseExited(java.awt.event.MouseEvent evt) {
              j.setBackground(UIManager.getColor("control"));
    }});} 	
	
	 page1()
	{   super("Main Menu");


 
	 



////////////////////////////////////////////
    	 
		Font f=new Font("Arial Rounded MT BOLD",Font.BOLD,60);
		Font f2=new Font("Comic Sans MS",Font.BOLD,25);
		
		setSize(1700,850);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	   setResizable(false);
	   setLocationRelativeTo(null); 
	   
	   
	    heading=new JPanel();
	   heading.setBackground(new Color(0,0,0,0));
	   heading.setBounds(0,0,1700,120);
		
		
		 header=new JLabel("Welcome to AIUB Portal");
		 header.setBounds( 400,3,900,80);
		header.setFont(f);
		header.setForeground(Color.YELLOW);
		//heading.add(header);
		
		
		 
		 
		
		 ImageIcon background_image=new ImageIcon("page1.jpg");
 
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(1700,800,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		 background=new JLabel("",background_image,JLabel.CENTER);
		
		background.add(heading);
		background.setBounds(0,0,1700,800);
		
		 
	    
		
		
	    
		
		
		  p1=new JPanel();
		// p1.setSize(600,500);
		 p1.setBounds(400,180,700,800);
		  p1.setBackground(new Color(0,0,0,60));
		p1.setLayout(null);
		 
		 
		 
		 
		   b1=new JButton("Log In");
		  b1.setBounds(180,240,300,50);
		  b1.setFont(f2);
		  //b3.setVisible(false);
		  b1.addActionListener(this);
		  
		      ylw(b1);
		  
		  p1.add(b1);
		 
		 
		 
		 
		 
		   b2=new JButton("Registration");
		  b2.setBounds(180,140,300,50);
		  b2.setFont(f2);
		  //b3.setVisible(false);
		  b2.addActionListener(this);
		  
		      ylw(b2);
		  
		 // p1.add(b2);
		 
		 
		 
		 
		 
		  b3=new JButton("Exit");
		  b3.setBounds(180,340,300,50);
		  b3.setFont(f2);
		  //b3.setVisible(false);
		  b3.addActionListener(this);
		  
		  
		       red(b3);
		  
		  p1.add(b3);
		 
		 
		 
		 
		   b4=new JButton("About Us");
		  b4.setBounds(180,440,300,50);
		  b4.setFont(f2);
		  b4.setVisible(false);
		  b4.addActionListener(this);
		  
	 
         ylw(b4);


		  p1.add(b4);
		
		
		
		
		 
		 
		
		 
		 
	 
		
		this.add(p1);
		
		 
		 
		  background.add(header);
		 add(background);
		setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent ae)
		{  if(ae.getSource()==b1 )
			{   b1.setBackground(Color.yellow);
		        b2.setBackground(Color.white);
				b3.setBackground(Color.white);
				
				logIn l=new logIn();
				 this.setVisible(false);
				 l.setVisible(true); 
		        }
		
		
		else if(ae.getSource()==b2 )
			{   b2.setBackground(Color.yellow);
		      
		        b1.setBackground(Color.white);
				b3.setBackground(Color.white);
				
				addStudent a=new addStudent();
				
		          this.setVisible(false);
				 a.setVisible(true); 
		    }
			
			
			else if(ae.getSource()==b3 )
			{   this.setVisible(false);
		        this.dispose();
		    }
		
		
 }
	
	public static void main(String[] args)
 { String id=new String(); 
   String password= new String(); 
   String userType= new String();
   
   
   id=password=userType="sw";
   
	 try{      
	                      
	                      Class.forName("oracle.jdbc.driver.OracleDriver"); 
					       
					      
						  Connection conx=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
						  Statement  stmtx=conx.createStatement();
						  String sqlx="select id,password,user_type  from loggedinTable";
						  PreparedStatement psx=conx.prepareStatement(sqlx);
						  ResultSet rsx=psx.executeQuery();
						  
						   
						   ResultSet RS=stmtx.executeQuery(sqlx);
						  
						    
						   
						  
						  if(RS.next())
						  { 
						      id = RS.getString("id");
							  password = RS.getString("password");
							  userType = RS.getString("user_type");
							  
							  conx.close();
	  
						  }
						  
	    }						  
						  
      catch(Exception e){ JOptionPane.showMessageDialog(null,e);}
         
      try{
       if(userType.equals("student"))
	   {
		    studentMenu u =new  studentMenu(id);
			//this.setVisible(false);
			u.setVisible(true);
	   }
	   
	   else if(userType.equals("teacher"))
	   {   
		 	teacherMenu u =new  teacherMenu(id);
			//this.setVisible(false);
			u.setVisible(true);  
	   }
	   
	   else if(userType.equals("admin"))
	   {
		   adminMenu u =new  adminMenu( );
			//this.setVisible(false);
			u.setVisible(true); 
		   
	   }
	
	
	   else{page1 p=new page1();} 
	  }
	  
	  catch(NullPointerException n){ page1 p=new page1(); }
	
	 
	 
	 
	 
 }
 
 }
	