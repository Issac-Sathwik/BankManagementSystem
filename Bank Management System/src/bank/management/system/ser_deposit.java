package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;

public class ser_deposit extends JFrame implements ActionListener{
	
	String accno;
	TextField t1;
	JButton b1,b2;
	
	ser_deposit(String accno){
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
		
		JLabel l2 = new JLabel ("Enter the amount to Deposit:");
		l2.setFont(new Font("System", Font.ITALIC, 20));
		l2.setBounds(50,100,300,35);
		image.add(l2);
		
		t1 = new TextField();
		t1.setBounds(50,150,400,25);
		t1.setFont(new Font("Raleway", Font.BOLD, 22));
		image.add(t1);
		
		b1 = new JButton("DEPOSIT");
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
		try {
			
		String amount = t1.getText();
		Date date = new Date();
		if(e.getSource()==b1) {
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter amount to deposit");
				}else {
				con c = new con();
				c.statement.executeUpdate("insert into bank values('"+accno+"', '"+date+"', 'Deposit', '"+amount+"')");
				JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
				setVisible(false);
				new services(accno);
				}
		}else if(e.getSource()==b2) {
			setVisible(false);
			new services(accno);
		}
		}catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ser_deposit("");
	}

}


