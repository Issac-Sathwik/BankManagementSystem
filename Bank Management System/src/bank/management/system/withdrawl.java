package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.sql.ResultSet;

import java.util.*;

import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener {
	
		String accno;
		TextField t1;
		JButton b1,b2;
	
	withdrawl(String accno){
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
		
		JLabel l2 = new JLabel ("Enter the amount to Withdraw:");
		l2.setFont(new Font("System", Font.ITALIC, 20));
		l2.setBounds(50,100,300,35);
		image.add(l2);
		
		JLabel l3 = new JLabel ("(Maximum Withdrawl amount is Rs.10,000/-)");
		l3.setFont(new Font("System", Font.ITALIC, 14));
		l3.setBounds(50,150,500,35);
		image.add(l3);
		
		t1 = new TextField();
		t1.setBounds(50,200,400,25);
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		image.add(t1);
		
		b1 = new JButton("WITHDRAW");
		b1.setBounds(300,300,150,35);
		b1.addActionListener(this);
		image.add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(300,350,150,35);
		b2.addActionListener(this);
		image.add(b2);
		
		setLayout(null);
		setSize(500,500);
		setLocation(500,200);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
		try {
			String amount = t1.getText();
			Date date = new Date();
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please input valid amount");
			}else {
				double damount = Double.parseDouble(amount);
				if (damount>10000) {
					JOptionPane.showMessageDialog(null, "Maximum withdrawl amount is 10000");
				}else {
				con c = new con();
				ResultSet resultset = c.statement.executeQuery("select * from bank where accno = '"+accno+"'");
				int balance =0;
				while(resultset.next()) {
					if(resultset.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(resultset.getString("amount"));
					}else {
						balance -= Integer.parseInt(resultset.getString("amount"));
					}
				}
				if(balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				c.statement.executeUpdate("insert into bank values('"+accno+"', '"+date+"', 'Withdrawl', '"+amount+"')");
				JOptionPane.showMessageDialog(null,  "Rs. "+amount+" Withdrawed Successfully.");
				setVisible(false);
				new services(accno);
			}
			}
		}catch(Exception E) {
			
			}
		}else if(e.getSource()==b2) {
			setVisible(false);
			new services(accno);
		}
	}
	
	public static void main(String[] args) {
		new withdrawl("");
	}

}
