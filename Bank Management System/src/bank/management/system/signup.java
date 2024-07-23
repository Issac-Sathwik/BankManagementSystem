package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class signup extends JFrame implements ActionListener{
	
	JRadioButton r1,r2;
	JRadioButton m1,m2;
	
	JButton  next;
	
	JTextField textname, textnumber, textemail, textaddress, textcity, textpc, textstate;
	JDateChooser dateChooser;
	
	
	Random ran = new Random();
	long first3 = (ran.nextLong() % 700l) + 100l;
	String first = " " + Math.abs(first3);
	
	signup(){
		super("Customer Registration Form");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(25,10,100,100);
		add(image);
		
		JLabel label1 = new JLabel("Form No."+first);
		label1.setBounds(160,20,600,40);
		label1.setFont(new Font("Raleway", Font.BOLD, 38));
		add(label1);
		
		JLabel label2 = new JLabel("Page 1");
		label2.setBounds(430,70,600,30);
		label2.setFont(new Font("Raleway", Font.BOLD, 22));
		add(label2);
		
		JLabel label3 = new JLabel("Personal Details");
		label3.setBounds(375,120,600,30);
		label3.setFont(new Font("Raleway", Font.BOLD, 22));
		add(label3);
		
		JLabel labelName = new JLabel("Full Name:");
		labelName.setFont(new Font("Raleway", Font.BOLD, 20));
		labelName.setBounds(100,190,200,30);
		add(labelName);
		
		textname = new JTextField();
		textname.setFont(new Font("Raleway", Font.BOLD, 14));
		textname.setBounds(300,190,400,30);
		add(textname);
		
		JLabel labelNumber = new JLabel("Mobile No:");
		labelNumber.setFont(new Font("Raleway", Font.BOLD, 20));
		labelNumber.setBounds(100,240,200,30);
		add(labelNumber);
		
		textnumber = new JTextField();
		textnumber.setFont(new Font("Raleway", Font.BOLD, 14));
		textnumber.setBounds(300,240,400,30);
		add(textnumber);
		
		
		JLabel labelEmail = new JLabel("Email id:");
		labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
		labelEmail.setBounds(100,290,200,30);
		add(labelEmail);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Raleway", Font.BOLD, 14));
		textemail.setBounds(300,290,400,30);
		add(textemail);
		
		JLabel labeldob = new JLabel("Date of Birth:");
		labeldob.setFont(new Font("Raleway", Font.BOLD, 20));
		labeldob.setBounds(100,340,300,30);
		add(labeldob);
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Raleway", Font.BOLD, 14));
		dateChooser.setBounds(300,340,400,30);
		add(dateChooser);
		
		JLabel labelgender = new JLabel("Gender:");
		labelgender.setFont(new Font("Ralway", Font.BOLD, 20));
		labelgender.setBounds(100,390,200,30);
		add(labelgender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBounds(300,390,100,30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBounds(400,390,200,30);
		add(r2);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(r1);
		buttonGroup.add(r2);
		
		JLabel labelmar = new JLabel("Marital Status:");
		labelmar.setFont(new Font("Ralway", Font.BOLD, 20));
		labelmar.setBounds(100,440,200,30);
		add(labelmar);
		
		m1 = new JRadioButton("Married");
		m1.setFont(new Font("Raleway", Font.BOLD, 14));
		m1.setBounds(300,440,100,30);
		add(m1);
		
		m2 = new JRadioButton("Single");
		m2.setFont(new Font("Raleway", Font.BOLD, 14));
		m2.setBounds(400,440,200,30);
		add(m2);
		
		ButtonGroup buttonggroup = new ButtonGroup();
		buttonggroup.add(m1);
		buttonggroup.add(m2);
		
		JLabel labeladdress = new JLabel("Address:");
		labeladdress.setFont(new Font("Raleway", Font.BOLD, 20));
		labeladdress.setBounds(100,490,100,30);
		add(labeladdress);
		
		textaddress = new JTextField();
		textaddress.setFont(new Font("Raleway", Font.BOLD, 14));
		textaddress.setBounds(300,490,400,30);
		add(textaddress);
		
		JLabel labelcity = new JLabel("City:");
		labelcity.setFont(new Font("Raleway", Font.BOLD, 20));
		labelcity.setBounds(100,540,100,30);
		add(labelcity);
		
		textcity = new JTextField();
		textcity.setFont(new Font("Raleway", Font.BOLD, 14));
		textcity.setBounds(300,540,400,30);
		add(textcity);
		
		JLabel labelpc = new JLabel("Pin Code:");
		labelpc.setFont(new Font("Raleway", Font.BOLD, 20));
		labelpc.setBounds(100,590,100,30);
		add(labelpc);
		
		textpc = new JTextField();
		textpc.setFont(new Font("Raleway", Font.BOLD, 14));
		textpc.setBounds(300,590,400,30);
		add(textpc);
		
		JLabel labelstate = new JLabel("State:");
		labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
		labelstate.setBounds(100,640,100,30);
		add(labelstate);
		
		textstate = new JTextField();
		textstate.setFont(new Font("Raleway", Font.BOLD, 14));
		textstate.setBounds(300,640,400,30);
		add(textstate);
		
		next = new JButton("Next");
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620,700,80,30);
		next.addActionListener(this);
		add(next);
		
		setLayout(null);
		setSize(850,800);
		setLocation(360,40);
		getContentPane().setBackground(new Color(222, 225, 228));
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String formno = first;
		String name = textname.getText();
		String number = textnumber.getText();
		String email = textemail.getText();
		String dob =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}else if(r2.isSelected()) {
			gender = "Female";
		}
		String mar = null;
		if(m1.isSelected()) {
			mar = "Married";
		}else if(m2.isSelected()) {
			mar = "Single";
		}
		String address = textaddress.getText();
		String city = textcity.getText();
		String pc = textpc.getText();
		String state = textstate.getText();
		
		try {
			if(textname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill all the fields");
			}else {
				con con1 = new con();
				String q = "insert into signup values('"+formno+"','"+name+"','"+number+"','"+email+"','"+dob+"','"+gender+"','"+mar+"','"+address+"','"+city+"','"+pc+"','"+state+"')";
				con1.statement.executeUpdate(q);
				new signup1(formno);
				setVisible(false);
			}
			
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	
public static void main(String[] args) {
	new signup();
	}
}
