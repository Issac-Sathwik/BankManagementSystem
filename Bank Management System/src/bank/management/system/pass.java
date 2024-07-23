package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class pass extends JFrame implements ActionListener{
	
	JButton b1,b2;
	JPasswordField p1,p2;
	
	String accno;
	
	pass(String accno){
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
		
		JLabel l2 = new JLabel ("Change Pin services:");
		l2.setFont(new Font("System", Font.ITALIC, 20));
		l2.setBounds(50,100,300,35);
		image.add(l2);
		
		JLabel l3 = new JLabel ("New PIN:");
		l3.setFont(new Font("System", Font.ITALIC, 20));
		l3.setBounds(50,150,300,35);
		image.add(l3);
		
		p1 = new JPasswordField(15);
		p1.setBounds(150,150,300,35);
		p1.setFont(new Font("Arial", Font.BOLD, 14));
		image.add(p1);
		
		JLabel l4 = new JLabel ("Re-enter new PIN:");
		l4.setFont(new Font("System", Font.ITALIC, 20));
		l4.setBounds(50,200,300,35);
		image.add(l4);
		
		p2 = new JPasswordField(15);
		p2.setBounds(250,200,200,35);
		p2.setFont(new Font("Arial", Font.BOLD, 14));
		image.add(p2);
		
		b1 = new JButton("Change Pin");
		b1.setBounds(300,300,150,35);
		b1.addActionListener(this);
		image.add(b1);
		
		b2 = new JButton("Back");
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
			
			String pass1 = p1.getText();
			String pass2 = p2.getText();
			
			if(!pass1.equals(pass2)){
				JOptionPane.showMessageDialog(null, "Entered Pins doesn't match. Please Check!");
				return;
				}
			if(e.getSource()==b1) {
				if(p1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter the Pin");
					return;
				}
				if(e.getSource()==b2) {
					JOptionPane.showMessageDialog(null, "Re-Enter the Pin");
					return;
				}
				
				con c = new con();
				String q1 = "update bank set Default_password = '"+pass1+"' where Default_password = '"+accno+"'";
				String q2 = "update login set Default_password = '"+pass1+"' where Default_password = '"+accno+"'";
				String q3 = "update signup1 set Default_password = '"+pass1+"' where Default_password = '"+accno+"'";
				
				c.statement.executeUpdate(q1);
				c.statement.executeUpdate(q2);
				c.statement.executeUpdate(q3);
				
				JOptionPane.showMessageDialog(null,  "PIN changed successfully.");
				setVisible(false);
				new services(accno);
			
			}else if(e.getSource()==b2) {
				new services(accno);
				setVisible(false);
			}
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new pass("");
		
	}

}
