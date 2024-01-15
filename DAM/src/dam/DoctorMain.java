package dam;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DoctorMain implements ActionListener,MouseListener{
	int doc_id = 1;
	JFrame frame;
	JPanel bPanel,hPanel,aPanel;
	Font font01, font02,font03,font04;
	Color light01 = new Color(247, 248, 243);
	Color light02 = new Color(237, 237, 233);
	Color lightblue = new Color(120, 188, 196);
	Color darkblue = new Color(0, 44, 62);
	Color red = new Color(247, 68, 78);
	ImageIcon docProfIcon;
	JLabel display;
	
	JLabel mLbl01,mLbl02,mLbl03,mLbl04,mLbl05;
	
	JLabel dttlLbl,dfLblb,epLbl;
	JLabel lbl01,lbl02,lbl03,lbl04,lbl05;
	JLabel ilbl01,ilbl02,ilbl03,ilbl04,ilbl05;
	JButton logoutBtn;
	JTextField eptf01,eptf02,eptf03;
	JButton epSBtn,epBBtn;
	
	JPanel pPnl01,pPnl02;
	JLabel mttlLbl;
	JTable apTable;
	JScrollPane apSPane;
	JButton apVBtn,apDBtn;
	DefaultTableModel model;
	
	JTextField smtf;
	JTextArea smta;
	JLabel smLbl01,smLbl02;
	JButton smSBtn;
	
	JLabel upLbl01,upLbl02;
	JTextField uptf01,uptf02;
	JButton upCBtn;
	
	public DoctorMain(int docID) {
		doc_id = docID;
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
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		Font loginFont = font02.deriveFont(96f);
		Font inputLabelFont = font02.deriveFont(16f);
		
		frame = new JFrame();
		frame.setSize(950,600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(light01);
		frame.setResizable(false);
		
		docProfIcon = new ImageIcon(getClass().getResource("profile.png"));
		
		Image img11 = docProfIcon.getImage();
		Image newImg11 = img11.getScaledInstance(139, 139,  java.awt.Image.SCALE_SMOOTH);
		docProfIcon = new ImageIcon(newImg11);
		
		hPanel = new JPanel();
		hPanel.setBounds(18,0,22,476);
		hPanel.setBackground(red);
		frame.add(hPanel);
		
		aPanel = new JPanel();
		aPanel.setBounds(0,142,60,22);
		aPanel.setBackground(red);
		frame.add(aPanel);
		
		
		
//		Profile Section
		
		display = new JLabel(docProfIcon);
		display.setBounds(312, 30, 139, 139);
		frame.add(display);
		display.setVisible(false);
		
		dttlLbl = new JLabel();
		dttlLbl.setBounds(475, 58, 400, 50);
		dttlLbl.setFont(titleNameFont);
		dttlLbl.setForeground(darkblue);
		frame.add(dttlLbl);
		dttlLbl.setVisible(false);
		
		dfLblb = new JLabel();
		dfLblb.setBounds(475, 90, 300, 50);
		dfLblb.setFont(normalLabel);
		dfLblb.setForeground(darkblue);
		frame.add(dfLblb);
		dfLblb.setVisible(false);
		
		epLbl = new JLabel("Edit Profile");
		epLbl.setBounds(475, 115, 100, 50);
		epLbl.setFont(btnFont);
		epLbl.setForeground(darkblue);
		epLbl.addMouseListener(this);
		frame.add(epLbl);
		epLbl.setVisible(false);
		
		
		
		lbl01 = new JLabel("Name:");
		lbl01.setFont(normalLabel);
		lbl01.setForeground(darkblue);
		lbl01.setBounds(370, 223, 100, 40);
		frame.add(lbl01);
		lbl01.setVisible(false);
		
		lbl02 = new JLabel("BMDC ID:");
		lbl02.setFont(normalLabel);
		lbl02.setForeground(darkblue);
		lbl02.setBounds(370, 270, 120, 40);
		frame.add(lbl02);
		lbl02.setVisible(false);
		
		lbl03 = new JLabel("Field:");
		lbl03.setFont(normalLabel);
		lbl03.setForeground(darkblue);
		lbl03.setBounds(370, 317, 100, 40);
		frame.add(lbl03);
		lbl03.setVisible(false);
		
		lbl04 = new JLabel("Email Address:");
		lbl04.setFont(normalLabel);
		lbl04.setForeground(darkblue);
		lbl04.setBounds(370, 364, 150, 40);
		frame.add(lbl04);
		lbl04.setVisible(false);
		
		lbl05 = new JLabel("Phone:");
		lbl05.setFont(normalLabel);
		lbl05.setForeground(darkblue);
		lbl05.setBounds(370, 411, 100, 40);
		frame.add(lbl05);
		lbl05.setVisible(false);
		
		
		
		ilbl01 = new JLabel();
		ilbl01.setFont(rglrFont);
		ilbl01.setForeground(darkblue);
		ilbl01.setBounds(569, 223, 150, 40);
		frame.add(ilbl01);
		ilbl01.setVisible(false);
		
		ilbl02 = new JLabel();
		ilbl02.setFont(rglrFont);
		ilbl02.setForeground(darkblue);
		ilbl02.setBounds(569, 270, 150, 40);
		frame.add(ilbl02);
		ilbl02.setVisible(false);
		
		ilbl03 = new JLabel();
		ilbl03.setFont(rglrFont);
		ilbl03.setForeground(darkblue);
		ilbl03.setBounds(569, 317, 250, 40);
		frame.add(ilbl03);
		ilbl03.setVisible(false);
		
		ilbl04 = new JLabel();
		ilbl04.setFont(rglrFont);
		ilbl04.setForeground(darkblue);
		ilbl04.setBounds(569, 364, 250, 40);
		frame.add(ilbl04);
		ilbl04.setVisible(false);
		
		ilbl05 = new JLabel();
		ilbl05.setFont(rglrFont);
		ilbl05.setForeground(darkblue);
		ilbl05.setBounds(569, 411, 250, 40);
		frame.add(ilbl05);
		ilbl05.setVisible(false);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(781,492,100,40);
		logoutBtn.setFocusable(false);
		logoutBtn.setBackground(red);
		logoutBtn.setBorder(null);
		logoutBtn.setFont(btnFont);
		logoutBtn.addActionListener(this);
		frame.add(logoutBtn);
		logoutBtn.setVisible(false);
		
		
		
		
//		Edit Profile Section
		
		eptf01 = new JTextField();
		eptf01.setBounds(565,225,275,40);
		eptf01.setFont(textFieldFont);
		eptf01.setBackground(light02);
		eptf01.setForeground(darkblue);
		eptf01.setBorder(null);
		eptf01.setVisible(false);
		frame.add(eptf01);
		
		eptf02 = new JTextField();
		eptf02.setBounds(565,362,350,40);
		eptf02.setFont(textFieldFont);
		eptf02.setBackground(light02);
		eptf02.setForeground(darkblue);
		eptf02.setBorder(null);
		eptf02.setVisible(false);
		frame.add(eptf02);
		
		eptf03 = new JTextField();
		eptf03.setBounds(565,411,225,40);
		eptf03.setFont(textFieldFont);
		eptf03.setBackground(light02);
		eptf03.setForeground(darkblue);
		eptf03.setBorder(null);
		eptf03.setVisible(false);
		frame.add(eptf03);
		
		epSBtn = new JButton("Save");
		epSBtn.setBounds(794,492,100,40);
		epSBtn.setFocusable(false);
		epSBtn.setBackground(red);
		epSBtn.setBorder(null);
		epSBtn.setFont(btnFont);
		epSBtn.addActionListener(this);
		frame.add(epSBtn);
		epSBtn.setVisible(false);
		
		epBBtn = new JButton("Back");
		epBBtn.setBounds(312,492,100,40);
		epBBtn.setFocusable(false);
		epBBtn.setBackground(red);
		epBBtn.setBorder(null);
		epBBtn.setFont(btnFont);
		epBBtn.addActionListener(this);
		frame.add(epBBtn);
		epBBtn.setVisible(false);
		
		
		
//		Appointment Section
		
		pPnl01 = new JPanel();
		pPnl01.setBounds(865,0,22,125);
		pPnl01.setBackground(red);
		frame.add(pPnl01);
		pPnl01.setVisible(false);
		
		pPnl02 = new JPanel();
		pPnl02.setBounds(810,50,125,22);
		pPnl02.setBackground(red);
		frame.add(pPnl02);
		pPnl02.setVisible(false);
		
		mttlLbl = new JLabel("Appointment");
		mttlLbl.setBounds(156, 10, 700, 115);
		mttlLbl.setForeground(darkblue);
		mttlLbl.setFont(loginFont);
		frame.add(mttlLbl);
		mttlLbl.setVisible(false);
		
		apTable = new JTable();
		apTable.setBounds(287, 169, 590, 300);
		frame.add(apTable);
		apTable.setBackground(light01);
		apTable.getTableHeader().setBackground(light02);
		apSPane = new JScrollPane(apTable);
		apSPane.setBounds(318, 161, 590, 300);
		apSPane.setBackground(light01);
		apSPane.setBorder(null);
		frame.add(apSPane);
		apSPane.setVisible(false);
		
		apVBtn = new JButton("Visited");
		apVBtn.setBounds(810,490,80,40);
		apVBtn.setFocusable(false);
		apVBtn.setBackground(red);
		apVBtn.setBorder(null);
		apVBtn.setFont(btnFont);
		apVBtn.addActionListener(this);
		apVBtn.setVisible(false);
		frame.add(apVBtn);
		
		apDBtn = new JButton("Display");
		apDBtn.setBounds(693,490,80,40);
		apDBtn.setFocusable(false);
		apDBtn.setBackground(red);
		apDBtn.setBorder(null);
		apDBtn.setFont(btnFont);
		apDBtn.addActionListener(this);
		apDBtn.setVisible(false);
		frame.add(apDBtn);
		
		
		
//		mail Section
		
		smtf = new JTextField();
		smtf.setBounds(339,245,429,40);
		smtf.setFont(textFieldFont);
		smtf.setBackground(light02);
		smtf.setForeground(darkblue);
		smtf.setBorder(null);
		smtf.setVisible(false);
		frame.add(smtf);
		
		smta = new JTextArea();
		smta.setBounds(339,339,341,123);
		smta.setFont(textFieldFont);
		smta.setBackground(light02);
		smta.setForeground(darkblue);
		smta.setBorder(null);
		smta.setVisible(false);
		frame.add(smta);
		
		smLbl01 = new JLabel("Email Address");
		smLbl01.setBounds(339,212,200,40);
		smLbl01.setFont(inputLabelFont);
		smLbl01.setVisible(false);
		frame.add(smLbl01);
		
		smLbl02 = new JLabel("Message");
		smLbl02.setBounds(339,306,200,40);
		smLbl02.setFont(inputLabelFont);
		smLbl02.setVisible(false);
		frame.add(smLbl02);
		
		smSBtn = new JButton("Send");
		smSBtn.setBounds(800,490,80,40);
		smSBtn.setFocusable(false);
		smSBtn.setBackground(red);
		smSBtn.setBorder(null);
		smSBtn.setFont(btnFont);
		smSBtn.addActionListener(this);
		smSBtn.setVisible(false);
		frame.add(smSBtn);
		
		
//		Change passcode Section
		
		uptf01 = new JTextField();
		uptf01.setBounds(503,283,200,40);
		uptf01.setFont(textFieldFont);
		uptf01.setBackground(light02);
		uptf01.setForeground(darkblue);
		uptf01.setBorder(null);
		uptf01.setVisible(false);
		frame.add(uptf01);
		
		uptf02 = new JTextField();
		uptf02.setBounds(503,375,200,40);
		uptf02.setFont(textFieldFont);
		uptf02.setBackground(light02);
		uptf02.setForeground(darkblue);
		uptf02.setBorder(null);
		uptf02.setVisible(false);
		frame.add(uptf02);
		
		upLbl01 = new JLabel("Previous Passcode");
		upLbl01.setBounds(503,250,200,40);
		upLbl01.setFont(inputLabelFont);
		upLbl01.setVisible(false);
		frame.add(upLbl01);
		
		upLbl02 = new JLabel("New Passcode");
		upLbl02.setBounds(503,341,200,40);
		upLbl02.setFont(inputLabelFont);
		upLbl02.setVisible(false);
		frame.add(upLbl02);
		
		upCBtn = new JButton("Confirm");
		upCBtn.setBounds(800,490,80,40);
		upCBtn.setFocusable(false);
		upCBtn.setBackground(red);
		upCBtn.setBorder(null);
		upCBtn.setFont(btnFont);
		upCBtn.addActionListener(this);
		upCBtn.setVisible(false);
		frame.add(upCBtn);
		
		
		
		
		
		mLbl01 = new JLabel("Profile");
		mLbl01.setFont(activeBtnFont);
		mLbl01.setForeground(darkblue);
		mLbl01.setBounds(74, 133, 80, 40);
		mLbl01.addMouseListener(this);
		frame.add(mLbl01);
		
		mLbl02 = new JLabel("Appointment");
		mLbl02.setFont(normalLabel);
		mLbl02.setForeground(darkblue);
		mLbl02.setBounds(54, 184, 120, 40);
		mLbl02.addMouseListener(this);
		frame.add(mLbl02);
		
		mLbl03 = new JLabel("Mail to Admin");
		mLbl03.setFont(normalLabel);
		mLbl03.setForeground(darkblue);
		mLbl03.setBounds(54, 237, 150, 40);
		mLbl03.addMouseListener(this);
		frame.add(mLbl03);
		
		mLbl04 = new JLabel("Update Passcode");
		mLbl04.setFont(normalLabel);
		mLbl04.setForeground(darkblue);
		mLbl04.setBounds(54, 290, 150, 40);
		mLbl04.addMouseListener(this);
		frame.add(mLbl04);
		
		
		bPanel = new JPanel();
		bPanel.setBounds(0,0,280,600);
		bPanel.setBackground(lightblue);
		frame.add(bPanel);
		
		ProfileSection();
		frame.setVisible(true);
		frame.validate();
	}
	
	public void ProfileSection() {
		
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
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		
		
		mLbl04.setFont(normalLabel);
		mLbl04.setBounds(54, 290, 150, 40);
		mLbl02.setFont(normalLabel);
		mLbl02.setBounds(54, 184, 150, 40);
		mLbl01.setBounds(74, 133, 80, 40);
		mLbl01.setFont(activeBtnFont);
		aPanel.setBounds(0,142,60,22);
		mLbl03.setBounds(54, 237, 150, 40);
		mLbl03.setFont(normalLabel);
		
		display.setVisible(true);
		dttlLbl.setVisible(true);
		dfLblb.setVisible(true);
		epLbl.setVisible(true);
		
		lbl01.setVisible(true);
		lbl02.setVisible(true);
		lbl03.setVisible(true);
		lbl04.setVisible(true);
		lbl05.setVisible(true);
		
		ilbl01.setVisible(true);
		ilbl02.setVisible(true);
		ilbl03.setVisible(true);
		ilbl04.setVisible(true);
		ilbl05.setVisible(true);
		
		logoutBtn.setVisible(true);
		
		model = (DefaultTableModel) apTable.getModel();
		model.setRowCount(0);
		
		uptf01.setVisible(false);
		uptf02.setVisible(false);
		upLbl01.setVisible(false);
		upLbl02.setVisible(false);
		upCBtn.setVisible(false);
		
		smLbl01.setVisible(false);
		smLbl02.setVisible(false);
		smtf.setVisible(false);
		smta.setVisible(false);
		smSBtn.setVisible(false);
		
		pPnl01.setVisible(false);
		pPnl02.setVisible(false);
		
		mttlLbl.setVisible(false);
		
		apTable.setVisible(false);
		apSPane.setVisible(false);
		
		apDBtn.setVisible(false);
		apVBtn.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		epBBtn.setVisible(false);
		epSBtn.setVisible(false);
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `bmdc_id`,`doc_name`,`field`,`email`,`phone` from `doctor` where doctor_id = '"+doc_id+"'");
			
			rss.next();
			dttlLbl.setText("Dr. " + rss.getString(2));
			dfLblb.setText(rss.getString(3));
			
			ilbl01.setText(rss.getString(2));
			ilbl02.setText(rss.getString(1));
			ilbl03.setText(rss.getString(3));
			ilbl04.setText(rss.getString(4));
			ilbl05.setText("+88 " + rss.getString(5));
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void EditProfileSection() {
		
		eptf01.setVisible(true);
		eptf02.setVisible(true);
		eptf03.setVisible(true);
		epBBtn.setVisible(true);
		epSBtn.setVisible(true);
		
		epLbl.setVisible(false);
		ilbl01.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `bmdc_id`,`doc_name`,`field`,`email`,`phone` from `doctor` where doctor_id = '"+doc_id+"'");
			
			rss.next();
			dttlLbl.setText("Dr. " + rss.getString(2));
			dfLblb.setText(rss.getString(3));
			
			eptf01.setText(rss.getString(2));
			ilbl02.setText(rss.getString(1));
			ilbl03.setText(rss.getString(3));
			eptf02.setText(rss.getString(4));
			eptf03.setText(rss.getString(5));
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void UpdateProfiletoDB() {
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `bmdc_id`,`doc_name`,`field`,`email`,`phone` from `doctor` where doctor_id = '"+doc_id+"'");
			
			rss.next();
			dttlLbl.setText("Dr. " + rss.getString(2));
			String docName = eptf01.getText();
			String email = eptf02.getText();
			String phone = eptf03.getText();
			
			
			int rsss = st.executeUpdate("UPDATE `doctor` SET `doc_name`='"+docName+"',`email`='"+email+"',`phone`='"+phone+"' WHERE `doctor_id` = '"+doc_id+"'");
			
			if(rsss > 0) {
				JOptionPane.showMessageDialog(null, "profile updated","message",JOptionPane.INFORMATION_MESSAGE);
			}else {
				System.out.println("something went wrong");
			}
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.dispose();
		new DoctorMain(doc_id);
	}
	
	public void AppointmentSection() {
		
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
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		
		mLbl04.setFont(normalLabel);
		mLbl04.setBounds(54, 290, 150, 40);
		mLbl02.setFont(activeBtnFont);
		mLbl02.setBounds(74, 184, 150, 40);
		mLbl01.setBounds(54, 133, 80, 40);
		mLbl01.setFont(normalLabel);
		aPanel.setBounds(0,193,60,22);
		mLbl03.setBounds(54, 237, 150, 40);
		mLbl03.setFont(normalLabel);
		
		pPnl01.setVisible(true);
		pPnl02.setVisible(true);
		
		mttlLbl.setVisible(true);
		mttlLbl.setText("Appointment");
		mttlLbl.setBounds(156,10,700,100);
		
		apTable.setVisible(true);
		apSPane.setVisible(true);
		
		apDBtn.setVisible(true);
		apVBtn.setVisible(true);
		
//		model = (DefaultTableModel) apTable.getModel();
//		model.setRowCount(0);
		
		uptf01.setVisible(false);
		uptf02.setVisible(false);
		upLbl01.setVisible(false);
		upLbl02.setVisible(false);
		upCBtn.setVisible(false);
		
		smLbl01.setVisible(false);
		smLbl02.setVisible(false);
		smtf.setVisible(false);
		smta.setVisible(false);
		smSBtn.setVisible(false);
		
		display.setVisible(false);
		dttlLbl.setVisible(false);
		dfLblb.setVisible(false);
		epLbl.setVisible(false);
		
		lbl01.setVisible(false);
		lbl02.setVisible(false);
		lbl03.setVisible(false);
		lbl04.setVisible(false);
		lbl05.setVisible(false);
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		epBBtn.setVisible(false);
		epSBtn.setVisible(false);
		
		
	}
	
	public void DisplayAppointments() {
		
		model = (DefaultTableModel) apTable.getModel();
		model.setRowCount(0);
		
			String url = "jdbc:mysql://localhost:4206/dam";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, "dam", "");
				
				Statement st = con.createStatement();
				ResultSet rs1 = st.executeQuery("SELECT doc_name FROM `doctor` WHERE doctor_id = '"+doc_id+"'");
				rs1.next();
				String dName = rs1.getString(1);
				
				ResultSet rs = st.executeQuery("SELECT `p_name`, `age`, `Gender`, `app_date`, `app_time`,`phone` FROM `appoinments` WHERE doct_name = '"+dName+"' AND app_status = 'NV'");
				ResultSetMetaData rsmd = rs.getMetaData();
				model = (DefaultTableModel) apTable.getModel();
				
				int col = rsmd.getColumnCount();
				String[] colName = new String[col];
				
				for(int i = 0; i < col; i++) 
					colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				
				String pName,age, gender, appDate, appTime, phone;
				
				while(rs.next()) {
					
					pName = rs.getString(1);
					age = String.valueOf(rs.getInt(2));
					gender = rs.getString(3);
					appDate = rs.getString(4);
					appTime = rs.getString(5);
					phone = rs.getString(6);
					String[] row = {pName,age,gender,appDate,appTime,phone};
					model.addRow(row);
				}
				
				st.close();
				con.close();
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
	
	public void UpdateAppointmentsToDB() {
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			String pName = null;
			String phone = null;
			if(apTable.getSelectedRowCount() == 1) {
				int row = apTable.getSelectedRow();
				pName = model.getValueAt(row, 0).toString();
				phone = model.getValueAt(row, 5).toString();
			}else {
				if(apTable.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is Empty","Warning",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Select any single row","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			if(pName != null && phone != null) {
				int rs = st.executeUpdate("UPDATE `appoinments` SET `app_status`='Visited' WHERE `p_name` = '"+pName+"' AND `phone` = '"+phone+"'");
				
				if(rs>0) {
					JOptionPane.showMessageDialog(null, "Appoinment Status: Visited","Warning",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Something went wrong","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void MailSection() {
		
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
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		
		mLbl04.setFont(normalLabel);
		mLbl04.setBounds(54, 290, 150, 40);
		mLbl02.setFont(normalLabel);
		mLbl02.setBounds(54, 184, 150, 40);
		mLbl01.setBounds(54, 133, 80, 40);
		mLbl01.setFont(normalLabel);
		mLbl03.setBounds(74, 237, 150, 40);
		mLbl03.setFont(activeBtnFont);
		aPanel.setBounds(0,245,60,22);
		
		pPnl01.setVisible(true);
		pPnl02.setVisible(true);
		
		mttlLbl.setVisible(true);
		mttlLbl.setText("Mail");
		mttlLbl.setBounds(296,10,500,100);
		
		smLbl01.setVisible(true);
		smLbl02.setVisible(true);
		smtf.setVisible(true);
		smta.setVisible(true);
		smSBtn.setVisible(true);
		
		
		
		
		uptf01.setVisible(false);
		uptf02.setVisible(false);
		upLbl01.setVisible(false);
		upLbl02.setVisible(false);
		upCBtn.setVisible(false);
		
		apTable.setVisible(false);
		apSPane.setVisible(false);
		
		apDBtn.setVisible(false);
		apVBtn.setVisible(false);
		
		model = (DefaultTableModel) apTable.getModel();
		model.setRowCount(0);
		
		display.setVisible(false);
		dttlLbl.setVisible(false);
		dfLblb.setVisible(false);
		epLbl.setVisible(false);
		
		lbl01.setVisible(false);
		lbl02.setVisible(false);
		lbl03.setVisible(false);
		lbl04.setVisible(false);
		lbl05.setVisible(false);
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		epBBtn.setVisible(false);
		epSBtn.setVisible(false);
	}
	
	public void SendMailToAdmin() {
		String toAd = smtf.getText();
		String Msg = smta.getText();
		
		try {
			SendEmail mail = new SendEmail();
			mail.setEmailAndMsg(toAd, Msg);
			mail.setupServerProperties();
			mail.draftEmail();
			mail.sendEmail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		JOptionPane.showMessageDialog(null, "Email sent successfully","Message",JOptionPane.INFORMATION_MESSAGE);
		
		smtf.setText(null);
		smta.setText(null);
		smtf.requestFocus();
	}
	
	public void UpdatePasscodeSection() {
		
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
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		
		mLbl04.setFont(activeBtnFont);
		mLbl04.setBounds(74, 290, 200, 40);
		mLbl02.setFont(normalLabel);
		mLbl02.setBounds(54, 184, 150, 40);
		mLbl01.setBounds(54, 133, 80, 40);
		mLbl01.setFont(normalLabel);
		mLbl03.setBounds(54, 237, 150, 40);
		mLbl03.setFont(normalLabel);
		aPanel.setBounds(0,294,60,22);
		
		pPnl01.setVisible(true);
		pPnl02.setVisible(true);
		
		mttlLbl.setVisible(true);
		mttlLbl.setText("Pass");
		mttlLbl.setBounds(296,10,500,100);
		
		uptf01.setVisible(true);
		uptf02.setVisible(true);
		upLbl01.setVisible(true);
		upLbl02.setVisible(true);
		upCBtn.setVisible(true);
		
		smLbl01.setVisible(false);
		smLbl02.setVisible(false);
		smtf.setVisible(false);
		smta.setVisible(false);
		smSBtn.setVisible(false);
		
		
		
		
		apTable.setVisible(false);
		apSPane.setVisible(false);
		
		apDBtn.setVisible(false);
		apVBtn.setVisible(false);
		
		model = (DefaultTableModel) apTable.getModel();
		model.setRowCount(0);
		
		display.setVisible(false);
		dttlLbl.setVisible(false);
		dfLblb.setVisible(false);
		epLbl.setVisible(false);
		
		lbl01.setVisible(false);
		lbl02.setVisible(false);
		lbl03.setVisible(false);
		lbl04.setVisible(false);
		lbl05.setVisible(false);
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		epBBtn.setVisible(false);
		epSBtn.setVisible(false);
	}
	
	public void UpdatePassToDB() {
		String url = "jdbc:mysql://localhost:4206/dam";
		String PrePass = uptf01.getText();
		String NewPass = uptf02.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			int rs = st.executeUpdate("UPDATE `doctor` SET `passcode`='"+NewPass+"' WHERE passcode = '"+PrePass+"' AND doctor_id = '"+doc_id+"'");
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Passcode Updated","Warning",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Something went wrong","Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			uptf01.setText(null);
			uptf02.setText(null);
			uptf01.requestFocus();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
//	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == epLbl) {
			EditProfileSection();
		}
		
		if(e.getSource() == mLbl01) {
			ProfileSection();
		}
		
		if(e.getSource() == mLbl02) {
			AppointmentSection();
		}
		
		if(e.getSource() == mLbl03) {
			MailSection();
		}
		
		if(e.getSource() == mLbl04) {
			UpdatePasscodeSection();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == logoutBtn) {
			frame.dispose();
			new DoctorLogin();
		}
		
		if(e.getSource() == epBBtn) {
			ProfileSection();
		}
		
		if(e.getSource() == epSBtn) {
			UpdateProfiletoDB();
		}
		
		if(e.getSource() == apDBtn) {
			DisplayAppointments();
		}
		
		if(e.getSource() == apVBtn) {
			UpdateAppointmentsToDB();
		}
		
		if(e.getSource() == smSBtn) {
			SendMailToAdmin();
		}
		
		if(e.getSource() == upCBtn) {
			UpdatePassToDB();
		}
	}
}
