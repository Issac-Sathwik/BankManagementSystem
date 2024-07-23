package bank.management.system;

import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

public class services extends JFrame implements ActionListener{
	
	JButton b1, b2, b3, b4, b5, b6, b7;
	JLabel l5;
	String accno;
	
	services(String accno){
		super("Customer Dashboard");
		this.accno = accno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sbg.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1000,1000);
		add(image);
		
		JLabel l1 = new JLabel("Welcome to Customer Dashboard");
		l1.setBounds(320,50,700,35);
		l1.setFont(new Font("System", Font.BOLD, 24));
		image.add(l1);
		
		JLabel l2 = new JLabel("Account Number:");
		l2.setBounds(320,100,700,35);
		l2.setFont(new Font("System", Font.ITALIC, 20));
		image.add(l2);
		
		JLabel l3 = new JLabel(accno);
		l3.setFont(new Font("Raleway", Font.BOLD, 18));
		l3.setBounds(500,100,700,35);
		image.add(l3);
		
		JLabel l4 = new JLabel("Account Balance:");
		l4.setBounds(320,150,700,35);
		l4.setFont(new Font("System", Font.ITALIC, 20));
		image.add(l4);
		
		l5 = new JLabel ();
		l5.setFont(new Font("System", Font.BOLD, 22));
		l5.setBounds(500,150,700,35);
		image.add(l5);
		
		b1 = new JButton("Cash Deposit");
		b1.setForeground(Color.BLACK);
		b1.setBackground(new Color(65,125,128));
		b1.setFont(new Font("Raleway", Font.BOLD, 14));
		b1.setBounds(300,220,150,35);
		b1.addActionListener(this);
		image.add(b1);
		
		b2 = new JButton("Cash Withdrawl");
		b2.setForeground(Color.BLACK);
		b2.setBackground(new Color(65,125,128));
		b2.setFont(new Font("Raleway", Font.BOLD, 14));
		b2.setBounds(600,220,150,35);
		b2.addActionListener(this);
		image.add(b2);
		
		b3 = new JButton("Mini Statement");
		b3.setForeground(Color.BLACK);
		b3.setBackground(new Color(65,125,128));
		b3.setFont(new Font("Raleway", Font.BOLD, 14));
		b3.setBounds(300,290,150,35);
		b3.addActionListener(this);
		image.add(b3);
		
		b4 = new JButton("Pin Change");
		b4.setForeground(Color.BLACK);
		b4.setBackground(new Color(65,125,128));
		b4.setFont(new Font("Raleway", Font.BOLD, 14));
		b4.setBounds(600,290,150,35);
		b4.addActionListener(this);
		image.add(b4);
		
		b5 = new JButton("Balance Enquiry");
		b5.setForeground(Color.BLACK);
		b5.setBackground(new Color(65,125,128));
		b5.setFont(new Font("Raleway", Font.BOLD, 14));
		b5.setBounds(300,360,150,35);
		b5.addActionListener(this);
		image.add(b5);
		
		b6 = new JButton("Close Account");
		b6.setForeground(Color.BLACK);
		b6.setBackground(new Color(65,125,128));
		b6.setFont(new Font("Raleway", Font.BOLD, 14));
		b6.setBounds(600,360,150,35);
		b6.addActionListener(this);
		image.add(b6);
		
		b7 = new JButton("Log Out");
		b7.setForeground(Color.BLACK);
		b7.setBackground(new Color(65,125,128));
		b7.setFont(new Font("Raleway", Font.BOLD, 14));
		b7.setBounds(440,460,150,35);
		b7.addActionListener(this);
		image.add(b7);
		
		int balance = 0;
		try {
			con c = new con();
			ResultSet resultset = c.statement.executeQuery("select * from bank where accno = '"+accno+"'");
			while(resultset.next()) {
				if(resultset.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(resultset.getString("amount"));
				}else {
					balance -= Integer.parseInt(resultset.getString("amount"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		l5.setText(""+balance);
		
		setLayout(null);
		setSize(1000,1000);
		setLocation(200,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			new ser_deposit(accno);
			setVisible(false);
			
			}else if(e.getSource()==b2) {
				new withdrawl(accno);
				setVisible(false);
				
			}else if(e.getSource()==b3) {
				new ministmt(accno);
				setVisible(false);
				
			}else if(e.getSource()==b4) {
				new pass(accno);
				setVisible(false);
			
			}else if(e.getSource()==b5) {
				new benq(accno);
				setVisible(false);
				
			}else if(e.getSource()==b6) {
				new closeacc(accno);
				setVisible(false);
			
			}else if(e.getSource()==b7) {
				System.exit(ABORT);
				setVisible(false);
			
			}
	}
	
	public static void main(String[] args) {
		new services("");
	}

}
