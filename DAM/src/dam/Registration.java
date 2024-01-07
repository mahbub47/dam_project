package dam;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.InputStream;
//import java.security.KeyStore.TrustedCertificateEntry;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
import java.sql.*;

public class Registration implements ActionListener{
	
	JFrame frame;
	JPanel pnl01,pnl02,pnl03;
	Font font01, font02,font03, font04;
	Color light01 = new Color(247, 248, 243);
	Color light02 = new Color(237, 237, 233);
	Color lightblue = new Color(120, 188, 196);
	Color darkblue = new Color(0, 44, 62);
	Color red = new Color(247, 68, 78);
	
	JLabel[] inputLabel = new JLabel[7];
	JTextField[] inputField = new JTextField[7];
	JLabel lbl01,regLabel;
	JButton loginBtn,regBtn;
	JLabel[] errorLabel = new JLabel[7];
	
	public Registration() {
		
		try {
			font01 = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Regular.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Regular.ttf")));
			
			font02 = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf"));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf")));
			
			font03 = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Lightitalic.ttf"));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Lightitalic.ttf")));
			
			font04 = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-SemiBoldItalic.ttf"));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-SemiBoldItalic.ttf")));
		} catch(IOException | FontFormatException e) {
		}
		
		Font textFieldFont = font01.deriveFont(14f);
		Font inputLabelFont = font02.deriveFont(16f);
		Font loginBtnFont = font02.deriveFont(14f);
		Font loginLabelFont = font03.deriveFont(12f);
		Font errLabelFont = font04.deriveFont(12f);
		Font loginFont = font02.deriveFont(96f);
		
		
		frame = new JFrame();
		frame.setSize(950,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(light01);
		
		pnl02 = new JPanel();
		pnl02.setBounds(50,0,22,125);
		pnl02.setBackground(red);
		frame.add(pnl02);
		
		pnl03 = new JPanel();
		pnl03.setBounds(0,50,125,22);
		pnl03.setBackground(red);
		frame.add(pnl03);
		
		pnl01 = new JPanel();
		pnl01.setBounds(0,0,290,600);
		pnl01.setBackground(lightblue);
		frame.add(pnl01);
		
		lbl01 = new JLabel("Already have an account?");
		lbl01.setBounds(316,500,148,40);
		lbl01.setForeground(darkblue);
		lbl01.setFont(loginLabelFont);
		frame.add(lbl01);
		
		for(int i = 0; i < 7; i++) {
			inputField[i] = new JTextField();
			inputField[i].setBackground(light02);
			inputField[i].setBorder(null);
			frame.add(inputField[i]);
			inputField[i].setFont(textFieldFont);
			inputField[i].setForeground(darkblue);
		}
		
		inputField[0].setBounds(343,85,225,40);
		inputField[1].setBounds(608,85,225,40);
		inputField[2].setBounds(343,173,485,40);
		inputField[3].setBounds(343,261,225,40);
		inputField[4].setBounds(608,261,225,40);
		inputField[5].setBounds(343,350,300,40);
		inputField[6].setBounds(343,437,485,40);
		
		for(int i = 0; i < 7; i++) {
			inputLabel[i] = new JLabel();
			inputLabel[i].setForeground(darkblue);
			inputLabel[i].setFont(inputLabelFont);
			frame.add(inputLabel[i]);
		}
		
		inputLabel[0].setText("First Name");
		inputLabel[0].setBounds(343,50,180,40);
		inputLabel[1].setText("Last Name");
		inputLabel[1].setBounds(608,50,180,40);
		inputLabel[2].setText("Email Address");
		inputLabel[2].setBounds(343,139,300,40);
		inputLabel[3].setText("Password");
		inputLabel[3].setBounds(343,228,180,40);
		inputLabel[4].setText("Confirm password");
		inputLabel[4].setBounds(608,228,300,40);
		inputLabel[5].setText("Phone");
		inputLabel[5].setBounds(343,315,180,40);
		inputLabel[6].setText("Area");
		inputLabel[6].setBounds(343,403,180,40);
		
		for(int i = 0; i < 7; i++) {
			errorLabel[i] = new JLabel();
			errorLabel[i].setForeground(red);
			errorLabel[i].setFont(errLabelFont);
			frame.add(errorLabel[i]);
		}
		
		
		errorLabel[0].setBounds(343,113,180,40);
		errorLabel[0].setVisible(false);
		
		errorLabel[1].setBounds(608,113,180,40);
		errorLabel[1].setVisible(false);
		
		errorLabel[2].setBounds(343,201,300,40);
		errorLabel[2].setVisible(false);
		
		errorLabel[3].setBounds(343,289,180,40);
		errorLabel[3].setVisible(false);
		
		errorLabel[4].setBounds(608,289,300,40);
		errorLabel[4].setVisible(false);
		
		errorLabel[5].setBounds(343,376,180,40);
		errorLabel[5].setVisible(false);
		
		errorLabel[6].setBounds(343,467,180,40);
		errorLabel[6].setVisible(false);
		
		loginBtn = new JButton("login");
		loginBtn.setBounds(456,500,70,40);
		loginBtn.setFocusable(false);
		loginBtn.setBackground(light01);
		loginBtn.setBorder(null);
		loginBtn.setFont(errLabelFont);
		loginBtn.addActionListener(this);
		frame.add(loginBtn);
		
		regBtn = new JButton("Register");
		regBtn.setBounds(795,500,100,40);
		regBtn.setFocusable(false);
		regBtn.setBackground(red);
		regBtn.setBorder(null);
		regBtn.setFont(loginBtnFont);
		regBtn.addActionListener(this);
		frame.add(regBtn);
		
		pnl01.setLayout(null);
		regLabel = new JLabel("Reg");
		regLabel.setBounds(10, 435, 300, 115);
		regLabel.setForeground(darkblue);
		regLabel.setFont(loginFont);
		pnl01.add(regLabel);
		
		frame.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String firstName = inputField[0].getText();
		String lastName = inputField[1].getText();
		String email = inputField[2].getText();
		String pass = inputField[3].getText();
		String conPass = inputField[4].getText();
		String phone = inputField[5].getText();
		String area = inputField[6].getText();
		
		String nameRegex = "^[A-Z]{1}[a-z]{1,100}$";
		String emailRegex = "^[a-z0-9]+@[a-z]+(\\.[a-z]+)+$";
		String phoneRegex = "^(\\+88)?01[2-9]\\d{8}$";
		String passRegex = "^((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])).{8,20}$";
		String addRegex = "^[A-Za-z0-9]{1,200}$";
		
		if(e.getSource() == loginBtn) {
			frame.dispose();
			new Login();
		}
		
		if(e.getSource() == regBtn) {
			
			for(int i = 0; i < 7; i++) {
				errorLabel[i].setVisible(false);
			}
			
			for(int i = 0; i < 7; i++) {
				inputField[i].setBorder(null);
			}
			
			if(inputField[0].getText().length() == 0) {
				
				errorLabel[0].setText("enter first name");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[0].setBorder(inpuErrorBorder);
				errorLabel[0].setVisible(true);
				
			}else if(inputField[0].getText().length()>0 && !Pattern.matches(nameRegex, firstName)) {
				
				errorLabel[0].setText("invalid name");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[0].setBorder(inpuErrorBorder);
				errorLabel[0].setVisible(true);
				
			} else if(inputField[1].getText().length() == 0) {
				
				errorLabel[1].setText("enter last name");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[1].setBorder(inpuErrorBorder);
				errorLabel[1].setVisible(true);
				
			}else if(inputField[1].getText().length()>0 && !Pattern.matches(nameRegex, lastName)) {
				
				errorLabel[1].setText("invalid name");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[1].setBorder(inpuErrorBorder);
				errorLabel[1].setVisible(true);
				
			}else if(inputField[2].getText().length() == 0) {
				
				errorLabel[2].setText("enter email address");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[2].setBorder(inpuErrorBorder);
				errorLabel[2].setVisible(true);
				
			}else if(inputField[2].getText().length()>0 && !Pattern.matches(emailRegex, email)) {
				
				errorLabel[2].setText("invalid email address");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[2].setBorder(inpuErrorBorder);
				errorLabel[2].setVisible(true);
				
			}else if(inputField[3].getText().length() == 0) {
				
				errorLabel[3].setText("enter password");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[3].setBorder(inpuErrorBorder);
				errorLabel[3].setVisible(true);
				
			} else if(inputField[3].getText().length()>0 && !Pattern.matches(passRegex, pass)) {
				
				errorLabel[3].setText("invalid password");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[3].setBorder(inpuErrorBorder);
				errorLabel[3].setVisible(true);
				
			}else if(inputField[4].getText().length() == 0) {
				
				errorLabel[4].setText("enter confirm password");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[4].setBorder(inpuErrorBorder);
				errorLabel[4].setVisible(true);
				
			}else if(inputField[4].getText().length()>0 && !conPass.equals(pass)) {
				
				errorLabel[4].setText("password doesn't match");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[4].setBorder(inpuErrorBorder);
				errorLabel[4].setVisible(true);
				
			}else if(inputField[5].getText().length() == 0) {
				
				errorLabel[5].setText("enter phone number");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[5].setBorder(inpuErrorBorder);
				errorLabel[5].setVisible(true);
				
			}else if(inputField[5].getText().length()>0 && !Pattern.matches(phoneRegex, phone)) {
				
				errorLabel[5].setText("invalid phone");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[5].setBorder(inpuErrorBorder);
				errorLabel[5].setVisible(true);
				
			}else if(inputField[6].getText().length() == 0) {
				
				errorLabel[6].setText("enter address");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[6].setBorder(inpuErrorBorder);
				errorLabel[6].setVisible(true);
				
			}else if(inputField[6].getText().length()>0 && !Pattern.matches(addRegex, area)) {
				
				errorLabel[6].setText("invalid address");
				Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
				inputField[6].setBorder(inpuErrorBorder);
				errorLabel[6].setVisible(true);
				
			}
			else {
				
				String url = "jdbc:mysql://localhost:4206/dam";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "dam", "");
					
					Statement st = con.createStatement();
					
					ResultSet rss = st.executeQuery("select `email`,`phone` from `registration`");
					boolean duplicacy = false;
					
					while(rss.next()) {
						if(rss.getString(1).equals(email) || rss.getString(2).equals(phone)) {
							duplicacy = true;
						}
					}
					
					if(duplicacy != true) {
						int rs = st.executeUpdate("INSERT INTO `registration`(`first_name`, `last_name`, `email`, `pass`, `phone`, `area`) VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+pass+"','"+phone+"','"+area+"')");
						
						if(rs > 0) {
							for(int i = 0; i < 7; i++) {
								inputField[i].setText(null);
							}
							inputField[0].requestFocus();
							
						}else {
							System.out.println("Not Inserted");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Already registered","Warning",JOptionPane.WARNING_MESSAGE);
						for(int i = 0; i < 7; i++) {
							inputField[i].setText(null);
						}
						inputField[0].requestFocus();
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}

}
