package bank.management.system;

import java.awt.*;

import java.sql.*;

import javax.swing.*;

import java.awt.event.*;

public class login extends JFrame implements ActionListener{
	
	JLabel label1, label2, label3;
	JTextField textfield1;
	JPasswordField passwordfield1;
	JButton button1, button2, button3;
	
	String accno;
	login(String accno){
		super("Bank Management System");
		this.accno = accno;
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,10,100,100);
		add(image);
		

		label1 = new JLabel("Welcome to the Bank Management System");
		label1.setForeground(null);
		label1.setFont(new Font("AvantGrade", Font.BOLD, 24));
		label1.setBounds(170,120,600,40);
		add(label1);
		
		label2 = new JLabel("Account No:");
		label2.setFont(new Font("Ralway", Font.BOLD, 28));
		label2.setForeground(null);
		label2.setBounds(150,190,375,30);
		add(label2);
		
		textfield1 = new JTextField(15);
		textfield1.setBounds(325,190,230,30);
		textfield1.setFont(new Font("Arial", Font.BOLD, 14));
		add(textfield1);
		
		label3 = new JLabel("Password:");
		label3.setFont(new Font("Ralway", Font.BOLD, 28));
		label3.setForeground(null);
		label3.setBounds(150,250,375,30);
		add(label3);
		
		passwordfield1 = new JPasswordField(15);
		passwordfield1.setBounds(325,250,230,30);
		passwordfield1.setFont(new Font("Arial", Font.BOLD, 14));
		add(passwordfield1);
		
		button1 = new JButton("Login in");
		button1.setFont(new Font("Arial", Font.BOLD, 14));
		button1.setBounds(300,300,100,30);
		button1.addActionListener(this);
		add(button1);
		
		button2 = new JButton("Sign Up");
		button2.setFont(new Font("Arial", Font.BOLD, 14));
		button2.setBounds(400,300,100,30);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Reset");
		button3.setFont(new Font("Arial", Font.BOLD, 14));
		button3.setBounds(500,300,100,30);
		button3.addActionListener(this);
		add(button3);
		
		
				ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/bg.jpg"));
				Image ii2 = ii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
				ImageIcon ii3 = new ImageIcon(ii2);
				JLabel iimage = new JLabel(ii3);
				iimage.setBounds(0,0,850,480);
				add(iimage);		
				
		setLayout(null);
		setSize(850,480);
		setLocation(250,200);
		setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == button1) {
				con c = new con();
				String accno = textfield1.getText();
				String pass = passwordfield1.getText();
				String q = "select * from login where accno = '"+accno+"' and pass = '"+pass+"'";
				ResultSet resultset = c.statement.executeQuery(q);
				if(resultset.next()) {
					setVisible(false);
					new services(accno);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
				}
			}else if(e.getSource() == button2) {
				new signup();
				setVisible(false);
				
			}else if(e.getSource() == button3) {
				textfield1.setText("");
				passwordfield1.setText("");
			}
		
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new login("");
		}
}
