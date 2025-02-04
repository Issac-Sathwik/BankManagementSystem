package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.itextpdf.io.source.OutputStream;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;

public class ministmt extends JFrame implements ActionListener {
    
	String accno;
    JButton button, printButton;
    
    ministmt(String accno){
        this.accno = accno;
        
        setLayout(null);
        getContentPane().setBackground(new Color(249,249,249));
        setSize(400,700);
        setLocation(500,500);
        setVisible(true);
        
        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("Mini Statement");
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,700,300,20);
        add(label4);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from login where accno = '"+accno+"'");
            
            while (resultSet.next()){
                label3.setText("Account Number:  "+ "XXXXXXXX" + resultSet.getString("accno").substring(8,12) + resultSet.getString("accno").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
        	int balance =0;
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where accno = '"+accno+"'");
            int count = 0;
            while (resultSet.next() && count < 10){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
                count++;
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        add(button);
        
        printButton = new JButton("Print");
        printButton.setBounds(140, 500, 100, 25);
        printButton.addActionListener(this);
        add(printButton);
    }

    private void generatePDF() {
    	try {
            String dest = "MiniStatement_" + accno + ".pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("Mini Statement"));
            document.add(new Paragraph("Account Number:  XXXXXX" + accno.substring(8, 12) + accno.substring(12)));

            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where accno = '" + accno + "'");
            int count = 0;
            int balance = 0;

            while (resultSet.next() && count < 10) {
                document.add(new Paragraph(resultSet.getString("date") + " - " + resultSet.getString("type") + " - " + resultSet.getString("amount")));

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                	balance -= Integer.parseInt(resultSet.getString("amount"));
                }
                count++;
            }

            document.add(new Paragraph("Your Total Balance is Rs " + balance));

            document.close();
            JOptionPane.showMessageDialog(null, "Mini Statement downloaded as " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
        	new services(accno);
            setVisible(false);
        } else if (e.getSource() == printButton) {
            generatePDF();
        }
    }
    public static void main(String[] args) {
        new ministmt("");
    }
}
