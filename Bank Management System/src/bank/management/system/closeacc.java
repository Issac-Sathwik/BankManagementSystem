package bank.management.system;

import java.awt.*;

import java.awt.event.*;

import java.sql.ResultSet;

import java.util.*;

import javax.swing.*;

public class closeacc extends JFrame implements ActionListener{
	
	String accno;
	JTextField accountNum;
    JButton b1, b2;
	
	closeacc(String accno){
		this.accno = accno;
		
		setLayout(null);
        getContentPane().setBackground(new Color(249, 249, 249));
        setSize(400, 300);
        setLocation(300, 200);
        setVisible(true);
        
        JLabel l1 = new JLabel("Delete Account");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(120, 20, 200, 30);
        add(l1);
		
        JLabel l2 = new JLabel("Account Number:");
        l2.setBounds(50, 80, 150, 30);
        add(l2);
        
        JLabel l3 = new JLabel(accno);
		l3.setFont(new Font("Raleway", Font.BOLD, 18));
		l3.setBounds(150, 80, 150, 30);
		add(l3);
        
        b1 = new JButton("Delete");
        b1.setBounds(50, 150, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(200, 150, 100, 30);
        b2.addActionListener(this);
        add(b2);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
        	deleteAccount();
        } else if (e.getSource() == b2) {
        	new services(accno);
            setVisible(false);
        }
    }

    private void deleteAccount() {
        try {
            con c = new con();
            String query1 = "DELETE FROM login WHERE accno = '" + accno + "'";
            String query2 = "DELETE FROM bank WHERE accno = '" + accno + "'";

            c.statement.executeUpdate(query1);
            c.statement.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Account deleted successfully.");
            System.exit(ABORT);
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting account. Please try again.");
        }
    }
	public static void main(String[] args) {
		new closeacc("");
	}
	

}
