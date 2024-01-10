package dam;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Login implements ActionListener, MouseListener {
	
	JFrame frame;
	JPanel pnl01,pnl02,pnl03;
	Font font01, font02,font03,font04;
	Color light01 = new Color(247, 248, 243);
	Color light02 = new Color(237, 237, 233);
	Color lightblue = new Color(120, 188, 196);
	Color darkblue = new Color(0, 44, 62);
	Color red = new Color(247, 68, 78);
	
	JLabel lbl01;
	JButton loginBtn,docBtn;
	
	JTextField tf01;
	JPasswordField tf02;
	JLabel lbl02,lbl03;
	JLabel errLbl01,errLbl02,loginLabel;
	
	JLabel display;
	ImageIcon img01,img02;
	JLabel reg;
	
	public int userid = 0;
	
	public Login() {
		
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
		Font errorLabelFont = font04.deriveFont(12f);
		Font loginFont = font02.deriveFont(96f);
		
		frame = new JFrame();
		frame.setSize(950,600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(light01);
		frame.setResizable(false);
		
		pnl02 = new JPanel();
		pnl02.setBounds(870,0,22,125);
		pnl02.setBackground(red);
		frame.add(pnl02);
		
		pnl03 = new JPanel();
		pnl03.setBounds(810,50,125,22);
		pnl03.setBackground(red);
		frame.add(pnl03);
		
		pnl01 = new JPanel();
		pnl01.setBounds(0,0,950,218);
		pnl01.setBackground(lightblue);
		frame.add(pnl01);
		
		lbl02 = new JLabel("Email");
		lbl02.setBounds(278,271,100,40);
		lbl02.setFont(inputLabelFont);
		frame.add(lbl02);
		
		lbl03 = new JLabel("Password");
		lbl03.setBounds(278,370,100,40);
		lbl03.setFont(inputLabelFont);
		frame.add(lbl03);
		
		lbl01 = new JLabel("Do not have an account?");
		lbl01.setBounds(30,500,148,40);
		lbl01.setForeground(darkblue);
		lbl01.setFont(loginLabelFont);
		frame.add(lbl01);
		
		errLbl01 = new JLabel();
		errLbl01.setBounds(278, 340, 100, 40);
		errLbl01.setForeground(red);
		errLbl01.setFont(errorLabelFont);
		frame.add(errLbl01);
		
		errLbl02 = new JLabel();
		errLbl02.setBounds(278, 439, 100, 40);
		errLbl02.setForeground(red);
		errLbl02.setFont(errorLabelFont);
		frame.add(errLbl02);
		
		tf01 = new JTextField();
		tf01.setBounds(278,310,486,40);
		tf01.setFont(textFieldFont);
		tf01.setBackground(light02);
		tf01.setForeground(darkblue);
		tf01.setBorder(null);
		frame.add(tf01);
		
		tf02 = new JPasswordField();
		tf02.setBounds(278,409,223,40);
		tf02.setFont(textFieldFont);
		tf02.setBackground(light02);
		tf02.setForeground(darkblue);
		tf02.setBorder(null);
		tf02.setEchoChar('*');
		frame.add(tf02);
		
		display = new JLabel();
		display.setBounds(511, 418, 20, 20);
		frame.add(display);
		
		
		
		img01 = new ImageIcon(getClass().getResource("eye.png"));
		img02 = new ImageIcon(getClass().getResource("view.png"));
		
		Image img11 = img01.getImage();
		Image newImg11 = img11.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		img01 = new ImageIcon(newImg11);
		
		Image img22 = img02.getImage();
		Image newImg22 = img22.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		img02 = new ImageIcon(newImg22);
		
		display.setIcon(img01);
		
		display.addMouseListener(new MouseListener() {
			boolean hide = true;
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(hide == true) {
					display.setIcon(img01);
					hide = !hide;
					tf02.setEchoChar('*');
				}else {
					display.setIcon(img02);
					hide = !hide;
					tf02.setEchoChar((char) 0);
				}
				
			}
		});
		
		reg = new JLabel("Register");
		reg.setBounds(168,500,70,40);
		reg.setFont(errorLabelFont);
		reg.addMouseListener(this);
		reg.setForeground(darkblue);
		frame.add(reg);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(795,500,100,40);
		loginBtn.setFocusable(false);
		loginBtn.setBackground(red);
		loginBtn.setBorder(null);
		loginBtn.setFont(loginBtnFont);
		loginBtn.addActionListener(this);
		frame.add(loginBtn);
		
		docBtn = new JButton("Doctor");
		docBtn.setBounds(666,500,100,40);
		docBtn.setFocusable(false);
		docBtn.setBackground(red);
		docBtn.setBorder(null);
		docBtn.setFont(loginBtnFont);
		docBtn.addActionListener(this);
		frame.add(docBtn);
		
		pnl01.setLayout(null);
		loginLabel = new JLabel("Login");
		loginLabel.setBounds(10, -5, 300, 115);
		loginLabel.setForeground(darkblue);
		loginLabel.setFont(loginFont);
		pnl01.add(loginLabel);
		
		frame.setVisible(true);
		frame.validate();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String email = tf01.getText();
		String pass = tf02.getText();
		String emailRegex = "^[a-z0-9]+@[a-z]+(\\.[a-z]+)+$";
		String passRegex = "^((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])).{8,20}$";
		Border inpuErrorBorder = BorderFactory.createLineBorder(red, 2);
		
		if(e.getSource() == loginBtn) {
			errLbl01.setVisible(false);
			errLbl02.setVisible(false);
			tf01.setBorder(null);
			tf02.setBorder(null);
			
			if(tf01.getText().length() == 0) {
				
				errLbl01.setText("enter email");
				
				tf01.setBorder(inpuErrorBorder);
				errLbl01.setVisible(true);
				
			}else if(tf01.getText().length()>0 && !Pattern.matches(emailRegex, email)) {
				
				errLbl01.setText("invalid email");
				tf01.setBorder(inpuErrorBorder);
				errLbl01.setVisible(true);
				
			} else if(tf02.getText().length() == 0) {
				
				errLbl02.setText("enter password");
				tf02.setBorder(inpuErrorBorder);
				errLbl02.setVisible(true);
				
			}else if(tf02.getText().length()>0 && !Pattern.matches(passRegex, pass)) {
				
				errLbl02.setText("invalid password");
				tf02.setBorder(inpuErrorBorder);
				errLbl02.setVisible(true);
				
			}else {
				String url = "jdbc:mysql://localhost:4206/dam";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "dam", "");
					
					Statement st = con.createStatement();
					
					ResultSet rss = st.executeQuery("select `admin_id`,`email`,`pass` from `registration`");
					boolean CorrectE = false;
					boolean CorrectP = false;
					
					while(rss.next()) {
						if(rss.getString(2).equals(email)) {
							CorrectE = true;
							
							if(rss.getString(3).equals(pass)) {
								CorrectP = true;
								userid = rss.getInt(1);
							}
						}
					}
					
					if(CorrectE == true && CorrectP == true) {
						
						System.out.println(userid);
						frame.dispose();
						new AdminMain(userid);
						
					}else {
						if(CorrectE != true) {
							errLbl01.setText("incorrect email");
							tf01.setBorder(inpuErrorBorder);
							errLbl01.setVisible(true);
						}
						
						if(CorrectP != true) {
							errLbl02.setText("incorrect password");
							tf02.setBorder(inpuErrorBorder);
							errLbl02.setVisible(true);
						}
					}
					st.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
		if(e.getSource() == docBtn) {
			frame.dispose();
			new DoctorLogin();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == reg) {
			frame.dispose();
			new Registration();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
