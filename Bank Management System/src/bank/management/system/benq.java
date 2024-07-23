package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.sql.ResultSet;

import java.util.*;

import javax.swing.*;

public class benq extends JFrame implements ActionListener{
	
	
	String accno;	
	JLabel  l3;
	JButton b1;
	benq(String accno){
		this.accno = accno;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/abg.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,500,500);
		add(image);
		
		JLabel l1 = new JLabel ("Welcome to Banking services");
		l1.setFont(new Font("System", Font.BOLD, 24));
		l1.setBounds(100,50,400,35);
		image.add(l1);
		
		JLabel l2 = new JLabel ("Your current Balance is Rs.");
		l2.setFont(new Font("System", Font.ITALIC, 20));
		l2.setBounds(50,100,300,35);
		image.add(l2);
		
		l3 = new JLabel ();
		l3.setFont(new Font("System", Font.BOLD, 22));
		l3.setBounds(310,100,500,35);
		image.add(l3);
		
		b1 = new JButton("Ok");
		b1.setBounds(300,300,150,35);
		b1.addActionListener(this);
		image.add(b1);
		
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
		
		l3.setText(""+balance);
		
		
		setLayout(null);
		setSize(500,500);
		setLocation(500,200);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new services(accno);
		
	}
	
	public static void main(String[] args) {
		new benq("");
	}

}
