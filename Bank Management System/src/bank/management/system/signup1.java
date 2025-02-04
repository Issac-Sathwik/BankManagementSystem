package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;



public class signup1 extends JFrame implements ActionListener{
	
	JRadioButton r1,r2;
	JTextField textnom, textrel, textpan, textid, accno, pass;
	JComboBox combobox, combobox1;
	JButton submit, cancel;

	String formno;
	signup1(String formno){
		super("Customer Registration Form");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(25,10,100,100);
		add(image);
		
		this.formno = formno;
		
		JLabel l1 = new JLabel("Page 2");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(430,70,600,30);
		add(l1);
		
		JLabel l2 = new JLabel("Account Details");
		l2.setFont(new Font("Raleway", Font.BOLD, 22));
		l2.setBounds(375,120,600,30);
		add(l2);
		
		JLabel l3 = new JLabel("Form No:");
		l3.setFont(new Font("Raleway", Font.BOLD, 18));
		l3.setBounds(600,10,100,30);
		add(l3);
		
		JLabel l4 = new JLabel(formno);
		l4.setFont(new Font("Raleway", Font.BOLD, 18));
		l4.setBounds(680,10,120,30);
		add(l4);
		
		JLabel labelacc = new JLabel("Type of Account:");
		labelacc.setFont(new Font("Ralway", Font.BOLD, 20));
		labelacc.setBounds(100,190,200,30);
		add(labelacc);
		
		r1 = new JRadioButton("Savings Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBounds(300,190,200,30);
		add(r1);
		
		r2 = new JRadioButton("Current Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBounds(500,190,200,30);
		add(r2);
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(r1);
		buttongroup.add(r2);
		
		JLabel labelnom = new JLabel("Nominee Name:");
		labelnom.setFont(new Font("Raleway", Font.BOLD, 20));
		labelnom.setBounds(100,240,200,30);
		add(labelnom);
		
		textnom = new JTextField();
		textnom.setFont(new Font("Raleway", Font.BOLD, 14));
		textnom.setBounds(300,240,400,30);
		add(textnom);
		
		JLabel labelrel = new JLabel("Relation:");
		labelrel.setFont(new Font("Raleway", Font.BOLD, 20));
		labelrel.setBounds(100,290,200,30);
		add(labelrel);
		
		textrel = new JTextField();
		textrel.setFont(new Font("Raleway", Font.BOLD, 14));
		textrel.setBounds(300,290,400,30);
		add(textrel);
		
		JLabel labelpan = new JLabel("PAN Number:");
		labelpan.setFont(new Font("Raleway", Font.BOLD, 20));
		labelpan.setBounds(100,340,200,30);
		add(labelpan);
		
		textpan = new JTextField();
		textpan.setFont(new Font("Raleway", Font.BOLD, 14));
		textpan.setBounds(300,340,400,30);
		add(textpan);
		
		JLabel labelid = new JLabel("Aadhar Number:");
		labelid.setFont(new Font("Raleway", Font.BOLD, 20));
		labelid.setBounds(100,390,200,30);
		add(labelid);
		
		textid = new JTextField();
		textid.setFont(new Font("Raleway", Font.BOLD, 14));
		textid.setBounds(300,390,400,30);
		add(textid);
		
		JLabel rel = new JLabel("Religion:");
		rel.setFont(new Font("Raleway", Font.BOLD, 20));
		rel.setBounds(100,440,200,30);
		add(rel);
		
		String religion[] = {"Select","Christian","Hindhu","Muslim","Other"};
		combobox = new JComboBox(religion);
		combobox.setFont(new Font("Raleway", Font.BOLD, 14));
		combobox.setBounds(300,440,400,30);
		add(combobox);
		
		JLabel occ = new JLabel("Occupation:");
		occ.setFont(new Font("Raleway", Font.BOLD, 20));
		occ.setBounds(100,490,200,30);
		add(occ);
		
		String occupation[] = {"Select","Working Professional","Bussiness","Entreprenuer","Other"};
		combobox1 = new JComboBox(occupation);
		combobox1.setFont(new Font("Raleway", Font.BOLD, 14));
		combobox1.setBounds(300,490,400,30);
		add(combobox1);
		
		JCheckBox c1 = new JCheckBox("I agree to the terms & conditions");
		c1.setBackground(new Color(215, 252, 252));
		c1. setFont(new Font("Raleway", Font. BOLD, 12));
		c1.setBounds(100, 620, 600, 20);
		add(c1);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(620,650,80,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(520,650,80,30);
		cancel.addActionListener(this);
		add(cancel);
		
		setLayout(null);
		setSize(850,780);
		setLocation(360,40);
		getContentPane().setBackground(new Color(222,225,228));
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String acc = null;
		if(r1.isSelected()) {
			acc = "Savings Account";
		}else if(r2.isSelected()) {
			acc = "Current Account";
		}
		String nom = textnom.getText();
		String rel = textrel.getText();
		String pan = textpan.getText();
		String id = textid.getText();
		String religion = (String) combobox.getSelectedItem();
		String occupation = (String) combobox.getSelectedItem();
		
		Random ran = new Random();
		long first7 = (ran.nextLong() % 90000000) + 123400000000L;
		String accno = "" + Math.abs(first7);
		
		long first3 = (ran.nextLong() % 9000L) +  1000L;
		String pass = "" + Math.abs(first3);
		
		try {
			if(e.getSource()==submit) {
				if(acc.equals("") || textpan.getText().equals("") || textid.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill all the fields");
			}else {
				con con1 = new con();
				String q1 = "insert into signup1 values('"+formno+"','"+acc+"','"+nom+"','"+rel+"','"+pan+"','"+id+"','"+religion+"','"+occupation+"')";
				String q2 = "insert into login values('"+formno+"','"+accno+"','"+pass+"')";
				con1.statement.executeUpdate(q1);
				con1.statement.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "Account Number: "+accno+"\n Default Password: "+pass );
				new deposit(accno);
				setVisible(false);
				}
			}else if(e.getSource()==cancel) {
				System.exit(ABORT);
			}
			
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new signup1("");
	}
}
