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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.*;
import javax.swing.border.Border;

public class AdminMain implements ActionListener, MouseListener{
	JFrame frame;
	JPanel bPanel,hPanel,aPanel;
	Font font01, font02,font03,font04;
	Color light01 = new Color(247, 248, 243);
	Color light02 = new Color(237, 237, 233);
	Color lightblue = new Color(120, 188, 196);
	Color darkblue = new Color(0, 44, 62);
	Color red = new Color(247, 68, 78);
	
	ImageIcon profIcon;
	JLabel display;
	JLabel title, titleName;
	JButton editProfBtn;
	JLabel lbl01,lbl02,lbl03,lbl04,lbl05;
	JLabel ilbl01,ilbl02,ilbl03,ilbl04,ilbl05;
	JButton logoutBtn;
	
	JLabel mLbl01,mLbl02,mLbl03,mLbl04;
	JTextField eptf01,eptf02,eptf03,eptf04,eptf05;
	
	JButton bBtn,sBtn;
	JLabel dTLbl;
	JPanel dpnl01,dpnl02,dpnl03;
	int userID;
	
	JLabel dLbl01,dLbl02,dLbl03,dLbl04,dLbl05;
	
	JTextField adtf01,adtf02,adtf03,adtf04,adtf05;
	JLabel adLbl01,adLbl02,adLbl03,adLbl04,adLbl05;
	JButton adBtn,adBBtn;
	
	
	JLabel rdLbl01,rdLbl02,rdLbl03,rdLbl04;
	JTextField rdtf01,rdtf02,rdtf03,rdtf04;
	JButton rdRBtn, rdBBtn;
	
	
	JTextField ud01tf01,ud01tf02;
	JLabel ud01Lbl01,ud01Lbl02;
	JButton udNBtn,udBBtn;
	
	JTextField udtf01,udtf02,udtf03,udtf04,udtf05;
	JLabel udLbl01,udLbl02,udLbl03,udLbl04,udLbl05;
	JButton udBtn,uddBBtn;
	
	
	JLabel spLbl01,spLbl02;
	JTextField sptf01,sptf02;
	JButton spCBtn,spBBtn;
	
	public AdminMain(int user) {
		
		frame = new JFrame();
		frame.setSize(950,600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(light01);
		frame.setResizable(false);
		MainProfile(user);
		

		frame.setVisible(true);
		frame.validate();
	}
	
	public void MainProfile(int user) {
		userID = user;
		
		
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
		
		profIcon = new ImageIcon(getClass().getResource("profile.png"));
		
		Image img11 = profIcon.getImage();
		Image newImg11 = img11.getScaledInstance(139, 139,  java.awt.Image.SCALE_SMOOTH);
		profIcon = new ImageIcon(newImg11);
		
		hPanel = new JPanel();
		hPanel.setBounds(18,0,22,476);
		hPanel.setBackground(red);
		frame.add(hPanel);
		
		aPanel = new JPanel();
		aPanel.setBounds(0,142,60,22);
		aPanel.setBackground(red);
		frame.add(aPanel);
		
		
		
		
		
//		doc section
		
		dTLbl = new JLabel("Doctor");
		dTLbl.setBounds(274, 10, 500, 115);
		dTLbl.setForeground(darkblue);
		dTLbl.setFont(loginFont);
		frame.add(dTLbl);
		dTLbl.setVisible(false);
		
		dpnl01 = new JPanel();
		dpnl01.setBounds(865,0,22,125);
		dpnl01.setBackground(red);
		frame.add(dpnl01);
		dpnl01.setVisible(false);
		
		dpnl02 = new JPanel();
		dpnl02.setBounds(810,50,125,22);
		dpnl02.setBackground(red);
		frame.add(dpnl02);
		dpnl02.setVisible(false);
		
		dpnl03 = new JPanel();
		dpnl03.setBounds(291,132,22,320);
		dpnl03.setBackground(red);
		frame.add(dpnl03);
		dpnl03.setVisible(false);
		
		dLbl01 = new JLabel("Add Doctor");
		dLbl01.setFont(normalLabel);
		dLbl01.setForeground(darkblue);
		dLbl01.setBounds(329, 193, 100, 40);
		dLbl01.addMouseListener(this);
		frame.add(dLbl01);
		dLbl01.setVisible(false);
		
		dLbl02 = new JLabel("Remove Doctor");
		dLbl02.setFont(normalLabel);
		dLbl02.setForeground(darkblue);
		dLbl02.setBounds(329, 242, 150, 40);
		dLbl02.addMouseListener(this);
		frame.add(dLbl02);
		dLbl02.setVisible(false);
		
		dLbl03 = new JLabel("Update Doctor");
		dLbl03.setFont(normalLabel);
		dLbl03.setForeground(darkblue);
		dLbl03.setBounds(329, 291, 150, 40);
		dLbl03.addMouseListener(this);
		frame.add(dLbl03);
		dLbl03.setVisible(false);
		
		dLbl04 = new JLabel("View Schedule");
		dLbl04.setFont(normalLabel);
		dLbl04.setForeground(darkblue);
		dLbl04.setBounds(329, 340, 150, 40);
		dLbl04.addMouseListener(this);
		frame.add(dLbl04);
		dLbl04.setVisible(false);
		
		dLbl05 = new JLabel("Set Passcode");
		dLbl05.setFont(normalLabel);
		dLbl05.setForeground(darkblue);
		dLbl05.setBounds(329, 389, 150, 40);
		dLbl05.addMouseListener(this);
		frame.add(dLbl05);
		dLbl05.setVisible(false);
		

		
		
		
//		add doc section
		
		adtf01 = new JTextField();
		adtf01.setBounds(311,191,155,40);
		adtf01.setFont(textFieldFont);
		adtf01.setBackground(light02);
		adtf01.setForeground(darkblue);
		adtf01.setBorder(null);
		adtf01.setVisible(false);
		frame.add(adtf01);
		
		adtf02 = new JTextField();
		adtf02.setBounds(510,191,276,40);
		adtf02.setFont(textFieldFont);
		adtf02.setBackground(light02);
		adtf02.setForeground(darkblue);
		adtf02.setBorder(null);
		adtf02.setVisible(false);
		frame.add(adtf02);
				
		adtf03 = new JTextField();
		adtf03.setBounds(311,277,276,40);
		adtf03.setFont(textFieldFont);
		adtf03.setBackground(light02);
		adtf03.setForeground(darkblue);
		adtf03.setBorder(null);
		adtf03.setVisible(false);
		frame.add(adtf03);
		
		adtf04 = new JTextField();
		adtf04.setBounds(311,363,400,40);
		adtf04.setFont(textFieldFont);
		adtf04.setBackground(light02);
		adtf04.setForeground(darkblue);
		adtf04.setBorder(null);
		adtf04.setVisible(false);
		frame.add(adtf04);
		
		adtf05 = new JTextField();
		adtf05.setBounds(311,449,276,40);
		adtf05.setFont(textFieldFont);
		adtf05.setBackground(light02);
		adtf05.setForeground(darkblue);
		adtf05.setBorder(null);
		adtf05.setVisible(false);
		frame.add(adtf05);
		
		adLbl01 = new JLabel("BMDC ID");
		adLbl01.setBounds(311,156,100,40);
		adLbl01.setFont(inputLabelFont);
		adLbl01.setVisible(false);
		frame.add(adLbl01);
		
		adLbl02 = new JLabel("Name");
		adLbl02.setBounds(510,156,100,40);
		adLbl02.setFont(inputLabelFont);
		adLbl02.setVisible(false);
		frame.add(adLbl02);
		
		adLbl03 = new JLabel("Field");
		adLbl03.setBounds(311,244,100,40);
		adLbl03.setFont(inputLabelFont);
		adLbl03.setVisible(false);
		frame.add(adLbl03);
		
		adLbl04 = new JLabel("Email");
		adLbl04.setBounds(311,330,100,40);
		adLbl04.setFont(inputLabelFont);
		adLbl04.setVisible(false);
		frame.add(adLbl04);
		
		adLbl05 = new JLabel("Phone");
		adLbl05.setBounds(311,416,100,40);
		adLbl05.setFont(inputLabelFont);
		adLbl05.setVisible(false);
		frame.add(adLbl05);
		
		adBtn = new JButton("Add");
		adBtn.setBounds(800,490,80,40);
		adBtn.setFocusable(false);
		adBtn.setBackground(red);
		adBtn.setBorder(null);
		adBtn.setFont(btnFont);
		adBtn.addActionListener(this);
		adBtn.setVisible(false);
		frame.add(adBtn);
		
		adBBtn = new JButton("Back");
		adBBtn.setBounds(686,490,80,40);
		adBBtn.setFocusable(false);
		adBBtn.setBackground(red);
		adBBtn.setBorder(null);
		adBBtn.setFont(btnFont);
		adBBtn.addActionListener(this);
		adBBtn.setVisible(false);
		frame.add(adBBtn);
		
		
		
//		remove doc section
		
		rdtf01 = new JTextField();
		rdtf01.setBounds(311,191,155,40);
		rdtf01.setFont(textFieldFont);
		rdtf01.setBackground(light02);
		rdtf01.setForeground(darkblue);
		rdtf01.setBorder(null);
		rdtf01.setVisible(false);
		frame.add(rdtf01);
		
		
		rdtf02 = new JTextField();
		rdtf02.setBounds(510,191,276,40);
		rdtf02.setFont(textFieldFont);
		rdtf02.setBackground(light02);
		rdtf02.setForeground(darkblue);
		rdtf02.setBorder(null);
		rdtf02.setVisible(false);
		frame.add(rdtf02);
		
		rdtf03 = new JTextField();
		rdtf03.setBounds(311,277,276,40);
		rdtf03.setFont(textFieldFont);
		rdtf03.setBackground(light02);
		rdtf03.setForeground(darkblue);
		rdtf03.setBorder(null);
		rdtf03.setVisible(false);
		frame.add(rdtf03);
		
		rdtf04 = new JTextField();
		rdtf04.setBounds(311,363,429,40);
		rdtf04.setFont(textFieldFont);
		rdtf04.setBackground(light02);
		rdtf04.setForeground(darkblue);
		rdtf04.setBorder(null);
		rdtf04.setVisible(false);
		frame.add(rdtf04);
		
		rdLbl01 = new JLabel("BMDC ID");
		rdLbl01.setBounds(311,156,100,40);
		rdLbl01.setFont(inputLabelFont);
		rdLbl01.setVisible(false);
		frame.add(rdLbl01);
		
		rdLbl02 = new JLabel("Name");
		rdLbl02.setBounds(510,156,100,40);
		rdLbl02.setFont(inputLabelFont);
		rdLbl02.setVisible(false);
		frame.add(rdLbl02);
		
		rdLbl03 = new JLabel("Field");
		rdLbl03.setBounds(311,244,100,40);
		rdLbl03.setFont(inputLabelFont);
		rdLbl03.setVisible(false);
		frame.add(rdLbl03);
		
		rdLbl04 = new JLabel("Email Address");
		rdLbl04.setBounds(311,330,120,40);
		rdLbl04.setFont(inputLabelFont);
		rdLbl04.setVisible(false);
		frame.add(rdLbl04);
		
		rdRBtn = new JButton("Remove");
		rdRBtn.setBounds(800,490,80,40);
		rdRBtn.setFocusable(false);
		rdRBtn.setBackground(red);
		rdRBtn.setBorder(null);
		rdRBtn.setFont(btnFont);
		rdRBtn.addActionListener(this);
		rdRBtn.setVisible(false);
		frame.add(rdRBtn);
		
		rdBBtn = new JButton("Back");
		rdBBtn.setBounds(686,490,80,40);
		rdBBtn.setFocusable(false);
		rdBBtn.setBackground(red);
		rdBBtn.setBorder(null);
		rdBBtn.setFont(btnFont);
		rdBBtn.addActionListener(this);
		rdBBtn.setVisible(false);
		frame.add(rdBBtn);
		
		
		
		
//		update doc section
		
		ud01tf01 = new JTextField();
		ud01tf01.setBounds(427,271,155,40);
		ud01tf01.setFont(textFieldFont);
		ud01tf01.setBackground(light02);
		ud01tf01.setForeground(darkblue);
		ud01tf01.setBorder(null);
		ud01tf01.setVisible(false);
		frame.add(ud01tf01);
		
		ud01tf02 = new JTextField();
		ud01tf02.setBounds(427,363,276,40);
		ud01tf02.setFont(textFieldFont);
		ud01tf02.setBackground(light02);
		ud01tf02.setForeground(darkblue);
		ud01tf02.setBorder(null);
		ud01tf02.setVisible(false);
		frame.add(ud01tf02);
		
		
		ud01Lbl01 = new JLabel("BMDC ID");
		ud01Lbl01.setBounds(427,239,120,40);
		ud01Lbl01.setFont(inputLabelFont);
		ud01Lbl01.setVisible(false);
		frame.add(ud01Lbl01);
		
		ud01Lbl02 = new JLabel("Field");
		ud01Lbl02.setBounds(427,329,120,40);
		ud01Lbl02.setFont(inputLabelFont);
		ud01Lbl02.setVisible(false);
		frame.add(ud01Lbl02);
		
		
		udNBtn = new JButton("Next");
		udNBtn.setBounds(800,490,80,40);
		udNBtn.setFocusable(false);
		udNBtn.setBackground(red);
		udNBtn.setBorder(null);
		udNBtn.setFont(btnFont);
		udNBtn.addActionListener(this);
		udNBtn.setVisible(false);
		frame.add(udNBtn);
		
		udBBtn = new JButton("Back");
		udBBtn.setBounds(686,490,80,40);
		udBBtn.setFocusable(false);
		udBBtn.setBackground(red);
		udBBtn.setBorder(null);
		udBBtn.setFont(btnFont);
		udBBtn.addActionListener(this);
		udBBtn.setVisible(false);
		frame.add(udBBtn);
		
//		update 02 section 
		
		
		udtf01 = new JTextField();
		udtf01.setBounds(311,191,155,40);
		udtf01.setFont(textFieldFont);
		udtf01.setBackground(light02);
		udtf01.setForeground(darkblue);
		udtf01.setBorder(null);
		udtf01.setVisible(false);
		frame.add(udtf01);
		
		udtf02 = new JTextField();
		udtf02.setBounds(510,191,276,40);
		udtf02.setFont(textFieldFont);
		udtf02.setBackground(light02);
		udtf02.setForeground(darkblue);
		udtf02.setBorder(null);
		udtf02.setVisible(false);
		frame.add(udtf02);
				
		udtf03 = new JTextField();
		udtf03.setBounds(311,277,276,40);
		udtf03.setFont(textFieldFont);
		udtf03.setBackground(light02);
		udtf03.setForeground(darkblue);
		udtf03.setBorder(null);
		udtf03.setVisible(false);
		frame.add(udtf03);
		
		udtf04 = new JTextField();
		udtf04.setBounds(311,363,400,40);
		udtf04.setFont(textFieldFont);
		udtf04.setBackground(light02);
		udtf04.setForeground(darkblue);
		udtf04.setBorder(null);
		udtf04.setVisible(false);
		frame.add(udtf04);
		
		udtf05 = new JTextField();
		udtf05.setBounds(311,449,276,40);
		udtf05.setFont(textFieldFont);
		udtf05.setBackground(light02);
		udtf05.setForeground(darkblue);
		udtf05.setBorder(null);
		udtf05.setVisible(false);
		frame.add(udtf05);
		
		udLbl01 = new JLabel("BMDC ID");
		udLbl01.setBounds(311,156,100,40);
		udLbl01.setFont(inputLabelFont);
		udLbl01.setVisible(false);
		frame.add(udLbl01);
		
		udLbl02 = new JLabel("Name");
		udLbl02.setBounds(510,156,100,40);
		udLbl02.setFont(inputLabelFont);
		udLbl02.setVisible(false);
		frame.add(udLbl02);
		
		udLbl03 = new JLabel("Field");
		udLbl03.setBounds(311,244,100,40);
		udLbl03.setFont(inputLabelFont);
		udLbl03.setVisible(false);
		frame.add(udLbl03);
		
		udLbl04 = new JLabel("Email");
		udLbl04.setBounds(311,330,100,40);
		udLbl04.setFont(inputLabelFont);
		udLbl04.setVisible(false);
		frame.add(udLbl04);
		
		udLbl05 = new JLabel("Phone");
		udLbl05.setBounds(311,416,100,40);
		udLbl05.setFont(inputLabelFont);
		udLbl05.setVisible(false);
		frame.add(udLbl05);
		
		udBtn = new JButton("Update");
		udBtn.setBounds(800,490,80,40);
		udBtn.setFocusable(false);
		udBtn.setBackground(red);
		udBtn.setBorder(null);
		udBtn.setFont(btnFont);
		udBtn.addActionListener(this);
		udBtn.setVisible(false);
		frame.add(udBtn);
		
		uddBBtn = new JButton("Back");
		uddBBtn.setBounds(686,490,80,40);
		uddBBtn.setFocusable(false);
		uddBBtn.setBackground(red);
		uddBBtn.setBorder(null);
		uddBBtn.setFont(btnFont);
		uddBBtn.addActionListener(this);
		uddBBtn.setVisible(false);
		frame.add(uddBBtn);
		
		
//		set passcode section
		
		sptf01 = new JTextField();
		sptf01.setBounds(483,263,200,40);
		sptf01.setFont(textFieldFont);
		sptf01.setBackground(light02);
		sptf01.setForeground(darkblue);
		sptf01.setBorder(null);
		sptf01.setVisible(false);
		frame.add(sptf01);
		
		sptf02 = new JTextField();
		sptf02.setBounds(482,355,200,40);
		sptf02.setFont(textFieldFont);
		sptf02.setBackground(light02);
		sptf02.setForeground(darkblue);
		sptf02.setBorder(null);
		sptf02.setVisible(false);
		frame.add(sptf02);
		
		
		spLbl01 = new JLabel("Previous Passcode");
		spLbl01.setBounds(483,230,150,40);
		spLbl01.setFont(inputLabelFont);
		spLbl01.setVisible(false);
		frame.add(spLbl01);
		
		spLbl02 = new JLabel("New Passcode");
		spLbl02.setBounds(483,321,120,40);
		spLbl02.setFont(inputLabelFont);
		spLbl02.setVisible(false);
		frame.add(spLbl02);
		
		
		spCBtn = new JButton("Confirm");
		spCBtn.setBounds(800,490,80,40);
		spCBtn.setFocusable(false);
		spCBtn.setBackground(red);
		spCBtn.setBorder(null);
		spCBtn.setFont(btnFont);
		spCBtn.addActionListener(this);
		spCBtn.setVisible(false);
		frame.add(spCBtn);
		
		spBBtn = new JButton("Back");
		spBBtn.setBounds(686,490,80,40);
		spBBtn.setFocusable(false);
		spBBtn.setBackground(red);
		spBBtn.setBorder(null);
		spBBtn.setFont(btnFont);
		spBBtn.addActionListener(this);
		spBBtn.setVisible(false);
		frame.add(spBBtn);
		
		
		
		mLbl01 = new JLabel("Profile");
		mLbl01.setFont(activeBtnFont);
		mLbl01.setForeground(darkblue);
		mLbl01.setBounds(74, 133, 80, 40);
		mLbl01.addMouseListener(this);
		frame.add(mLbl01);
		
		mLbl02 = new JLabel("Doctors");
		mLbl02.setFont(normalLabel);
		mLbl02.setForeground(darkblue);
		mLbl02.setBounds(54, 184, 80, 40);
		mLbl02.addMouseListener(this);
		frame.add(mLbl02);
		
		mLbl03 = new JLabel("Appointments");
		mLbl03.setFont(normalLabel);
		mLbl03.setForeground(darkblue);
		mLbl03.setBounds(54, 237, 130, 40);
		mLbl03.addMouseListener(this);
		frame.add(mLbl03);
		
		mLbl04 = new JLabel("Emergency");
		mLbl04.setFont(normalLabel);
		mLbl04.setForeground(darkblue);
		mLbl04.setBounds(54, 290, 110, 40);
		mLbl04.addMouseListener(this);
		frame.add(mLbl04);
		
		bPanel = new JPanel();
		bPanel.setBounds(0,0,250,600);
		bPanel.setBackground(lightblue);
		frame.add(bPanel);
		
		display = new JLabel(profIcon);
		display.setBounds(317, 56, 140, 140);
		frame.add(display);
		
		titleName = new JLabel();
		titleName.setBounds(475, 95, 300, 50);
		titleName.setFont(titleNameFont);
		titleName.setForeground(darkblue);
		frame.add(titleName);
		
		title = new JLabel();
		title.setBounds(475, 124, 100, 50);
		title.setFont(normalLabel);
		title.setForeground(darkblue);
		title.setText("Admin");
		frame.add(title);
		
		editProfBtn = new JButton("Edit Profile");
		editProfBtn.setBounds(781,104,100,40);
		editProfBtn.setFocusable(false);
		editProfBtn.setBackground(red);
		editProfBtn.setBorder(null);
		editProfBtn.setFont(btnFont);
		editProfBtn.addActionListener(this);
		frame.add(editProfBtn);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(781,492,100,40);
		logoutBtn.setFocusable(false);
		logoutBtn.setBackground(red);
		logoutBtn.setBorder(null);
		logoutBtn.setFont(btnFont);
		logoutBtn.addActionListener(this);
		frame.add(logoutBtn);
		
		sBtn = new JButton("Save");
		sBtn.setBounds(794,492,100,40);
		sBtn.setFocusable(false);
		sBtn.setBackground(red);
		sBtn.setBorder(null);
		sBtn.setFont(btnFont);
		sBtn.addActionListener(this);
		frame.add(sBtn);
		sBtn.setVisible(false);
		
		bBtn = new JButton("Back");
		bBtn.setBounds(275,492,100,40);
		bBtn.setFocusable(false);
		bBtn.setBackground(red);
		bBtn.setBorder(null);
		bBtn.setFont(btnFont);
		bBtn.addActionListener(this);
		frame.add(bBtn);
		bBtn.setVisible(false);
		
		lbl01 = new JLabel("First Name:");
		lbl01.setFont(normalLabel);
		lbl01.setForeground(darkblue);
		lbl01.setBounds(334, 238, 150, 40);
		frame.add(lbl01);
		
		lbl02 = new JLabel("Last Name:");
		lbl02.setFont(normalLabel);
		lbl02.setForeground(darkblue);
		lbl02.setBounds(334, 285, 150, 40);
		frame.add(lbl02);
		
		lbl03 = new JLabel("Email Address:");
		lbl03.setFont(normalLabel);
		lbl03.setForeground(darkblue);
		lbl03.setBounds(334, 332, 150, 40);
		frame.add(lbl03);
		
		lbl04 = new JLabel("Phone:");
		lbl04.setFont(normalLabel);
		lbl04.setForeground(darkblue);
		lbl04.setBounds(334, 379, 150, 40);
		frame.add(lbl04);
		
		lbl05 = new JLabel("Area:");
		lbl05.setFont(normalLabel);
		lbl05.setForeground(darkblue);
		lbl05.setBounds(334, 426, 150, 40);
		frame.add(lbl05);
		
		ilbl01 = new JLabel();
		ilbl01.setFont(rglrFont);
		ilbl01.setForeground(darkblue);
		ilbl01.setBounds(533, 238, 150, 40);
		frame.add(ilbl01);
		
		ilbl02 = new JLabel();
		ilbl02.setFont(rglrFont);
		ilbl02.setForeground(darkblue);
		ilbl02.setBounds(533, 285, 150, 40);
		frame.add(ilbl02);
		
		ilbl03 = new JLabel();
		ilbl03.setFont(rglrFont);
		ilbl03.setForeground(darkblue);
		ilbl03.setBounds(533, 332, 250, 40);
		frame.add(ilbl03);
		
		ilbl04 = new JLabel();
		ilbl04.setFont(rglrFont);
		ilbl04.setForeground(darkblue);
		ilbl04.setBounds(533, 379, 250, 40);
		frame.add(ilbl04);
		
		eptf01 = new JTextField();
		eptf01.setBounds(536,232,223,40);
		eptf01.setFont(textFieldFont);
		eptf01.setBackground(light02);
		eptf01.setForeground(darkblue);
		eptf01.setBorder(null);
		frame.add(eptf01);
		
		eptf02 = new JTextField();
		eptf02.setBounds(536,279,223,40);
		eptf02.setFont(textFieldFont);
		eptf02.setBackground(light02);
		eptf02.setForeground(darkblue);
		eptf02.setBorder(null);
		frame.add(eptf02);
		
		eptf03 = new JTextField();
		eptf03.setBounds(536,326,380,40);
		eptf03.setFont(textFieldFont);
		eptf03.setBackground(light02);
		eptf03.setForeground(darkblue);
		eptf03.setBorder(null);
		frame.add(eptf03);
		
		eptf04 = new JTextField();
		eptf04.setBounds(536,373,223,40);
		eptf04.setFont(textFieldFont);
		eptf04.setBackground(light02);
		eptf04.setForeground(darkblue);
		eptf04.setBorder(null);
		frame.add(eptf04);
		
		eptf05 = new JTextField();
		eptf05.setBounds(536,420,380,40);
		eptf05.setFont(textFieldFont);
		eptf05.setBackground(light02);
		eptf05.setForeground(darkblue);
		eptf05.setBorder(null);
		frame.add(eptf05);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		eptf04.setVisible(false);
		eptf05.setVisible(false);
		
		ilbl05 = new JLabel();
		ilbl05.setFont(rglrFont);
		ilbl05.setForeground(darkblue);
		ilbl05.setBounds(533, 426, 250, 40);
		frame.add(ilbl05);
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `first_name`,`last_name`,`email`,`phone`,`area` from `registration` where admin_id = '"+user+"'");
			
			rss.next();
			titleName.setText(rss.getString(1) + " " + rss.getString(2));
			ilbl01.setText(rss.getString(1));
			ilbl02.setText(rss.getString(2));
			ilbl03.setText(rss.getString(3));
			ilbl04.setText(rss.getString(4));
			ilbl05.setText(rss.getString(5));
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void editProfileSection(int user) {
		
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
		
		sBtn.setVisible(true);
		bBtn.setVisible(true);
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		editProfBtn.setVisible(false);
		logoutBtn.setVisible(false);
		
		eptf01.setVisible(true);
		eptf02.setVisible(true);
		eptf03.setVisible(true);
		eptf04.setVisible(true);
		eptf05.setVisible(true);
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `first_name`,`last_name`,`email`,`phone`,`area` from `registration` where admin_id = '"+user+"'");
			
			rss.next();
			titleName.setText(rss.getString(1) + " " + rss.getString(2));
			eptf01.setText(rss.getString(1));
			eptf02.setText(rss.getString(2));
			eptf03.setText(rss.getString(3));
			eptf04.setText(rss.getString(4));
			eptf05.setText(rss.getString(5));
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void backProfileSection(int user) {
		
		ilbl01.setVisible(true);
		ilbl02.setVisible(true);
		ilbl03.setVisible(true);
		ilbl04.setVisible(true);
		ilbl05.setVisible(true);
		editProfBtn.setVisible(true);
		logoutBtn.setVisible(true);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		eptf04.setVisible(false);
		eptf05.setVisible(false);
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `first_name`,`last_name`,`email`,`phone`,`area` from `registration` where admin_id = '"+user+"'");
			
			rss.next();
			titleName.setText(rss.getString(1) + " " + rss.getString(2));
			ilbl01.setText(rss.getString(1));
			ilbl02.setText(rss.getString(2));
			ilbl03.setText(rss.getString(3));
			ilbl04.setText(rss.getString(4));
			ilbl05.setText(rss.getString(5));
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void updateProfile(int user) {
		
		String url = "jdbc:mysql://localhost:4206/dam";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			ResultSet rss = st.executeQuery("select `first_name`,`last_name`,`email`,`phone`,`area` from `registration` where admin_id = '"+user+"'");
			
			rss.next();
			titleName.setText(rss.getString(1) + " " + rss.getString(2));
			String f_name = eptf01.getText();
			String l_name = eptf02.getText();
			String email = eptf03.getText();
			String phone = eptf04.getText();
			String area = eptf05.getText();
			
			int rsss = st.executeUpdate("UPDATE `registration` SET `first_name`='"+f_name+"',`last_name`='"+l_name+"',`email`='"+email+"',`phone`='"+phone+"',`area`='"+area+"' WHERE `admin_id` = '"+user+"'");
			
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
		new AdminMain(user);
		
	}
	
	public void backtoProfile(int user) {
		
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
		rdtf01.setVisible(false);
		rdtf02.setVisible(false);
		rdtf03.setVisible(false);
		rdtf04.setVisible(false);
		
		rdLbl01.setVisible(false);
		rdLbl02.setVisible(false);
		rdLbl03.setVisible(false);
		rdLbl04.setVisible(false);    
		
		rdRBtn.setVisible(false);
		rdBBtn.setVisible(false);
		
		
		ud01tf02.setVisible(false);
		ud01tf01.setVisible(false);
		ud01Lbl02.setVisible(false);
		ud01Lbl01.setVisible(false);
		udBBtn.setVisible(false);
		udNBtn.setVisible(false);
		
		
		udtf01.setVisible(false);
		udtf02.setVisible(false);
		udtf03.setVisible(false);
		udtf04.setVisible(false);
		udtf05.setVisible(false);
		
		udLbl01.setVisible(false);
		udLbl02.setVisible(false);
		udLbl03.setVisible(false);
		udLbl04.setVisible(false);
		udLbl05.setVisible(false);
		
		uddBBtn.setVisible(false);
		udBtn.setVisible(false);
		
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		lbl01.setVisible(false);
		lbl02.setVisible(false);
		lbl03.setVisible(false);
		lbl04.setVisible(false);
		lbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		editProfBtn.setVisible(false);
		titleName.setVisible(false);
		title.setVisible(false);
		display.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		eptf04.setVisible(false);
		eptf05.setVisible(false);
		sBtn.setVisible(false);
		bBtn.setVisible(false);
		
		dTLbl.setVisible(false);
		
		dLbl01.setVisible(false);
		dLbl02.setVisible(false);
		dLbl03.setVisible(false);
		dLbl04.setVisible(false);
		dLbl05.setVisible(false);
		
		dpnl01.setVisible(false);
		dpnl02.setVisible(false);
		dpnl03.setVisible(false);
		
		adtf01.setVisible(false);
		adtf02.setVisible(false);
		adtf03.setVisible(false);
		adtf04.setVisible(false);
		adtf05.setVisible(false);
		
		adLbl01.setVisible(false);
		adLbl02.setVisible(false);
		adLbl03.setVisible(false);
		adLbl04.setVisible(false);
		adLbl05.setVisible(false);
		
		adBtn.setVisible(false);
		
		Font activeBtnFont = font02.deriveFont(20f);
		Font normalLabel = font02.deriveFont(16f);
		Font titleNameFont = font02.deriveFont(32f);
		Font btnFont = font02.deriveFont(12f);
		Font rglrFont = font01.deriveFont(15f);
		Font textFieldFont = font01.deriveFont(14f);
		
		mLbl02.setFont(normalLabel);
		mLbl02.setBounds(54, 184, 80, 40);
		mLbl01.setBounds(74, 133, 80, 40);
		mLbl01.setFont(activeBtnFont);
		aPanel.setBounds(0,142,60,22);
		
		ilbl01.setVisible(true);
		ilbl02.setVisible(true);
		ilbl03.setVisible(true);
		ilbl04.setVisible(true);
		ilbl05.setVisible(true);
		
		lbl01.setVisible(true);
		lbl02.setVisible(true);
		lbl03.setVisible(true);
		lbl04.setVisible(true);
		lbl05.setVisible(true);
		
		logoutBtn.setVisible(true);
		editProfBtn.setVisible(true);
		titleName.setVisible(true);
		title.setVisible(true);
		display.setVisible(true);
	}
	
	public void DoctorSection() {
		
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
		
		mLbl02.setFont(activeBtnFont);
		mLbl02.setBounds(74, 184, 80, 40);
		mLbl01.setBounds(54, 133, 80, 40);
		mLbl01.setFont(normalLabel);
		aPanel.setBounds(0,193,60,22);
		
		dTLbl.setVisible(true);
		
		
		adtf01.setVisible(false);
		adtf02.setVisible(false);
		adtf03.setVisible(false);
		adtf04.setVisible(false);
		adtf05.setVisible(false);
		
		adLbl01.setVisible(false);
		adLbl02.setVisible(false);
		adLbl03.setVisible(false);
		adLbl04.setVisible(false);
		adLbl05.setVisible(false);
		
		adBtn.setVisible(false);
		adBBtn.setVisible(false);
		
		
		
		dpnl01.setVisible(true);
		dpnl02.setVisible(true);
		dpnl03.setVisible(true);
		
		dLbl01.setVisible(true);
		
		dLbl02.setVisible(true);
		dLbl03.setVisible(true);
		dLbl04.setVisible(true);
		dLbl05.setVisible(true);
		
		dLbl02.addMouseListener(this);
		dLbl03.addMouseListener(this);
		dLbl04.addMouseListener(this);
		dLbl05.addMouseListener(this);
		dLbl01.addMouseListener(this);
		
		
		rdtf01.setVisible(false);
		rdtf02.setVisible(false);
		rdtf03.setVisible(false);
		rdtf04.setVisible(false);
		
		rdLbl01.setVisible(false);
		rdLbl02.setVisible(false);
		rdLbl03.setVisible(false);
		rdLbl04.setVisible(false);    
		
		rdRBtn.setVisible(false);
		rdBBtn.setVisible(false);
		
		
		ud01tf02.setVisible(false);
		ud01tf01.setVisible(false);
		ud01Lbl02.setVisible(false);
		ud01Lbl01.setVisible(false);
		udBBtn.setVisible(false);
		udNBtn.setVisible(false);
		
		
		udtf01.setVisible(false);
		udtf02.setVisible(false);
		udtf03.setVisible(false);
		udtf04.setVisible(false);
		udtf05.setVisible(false);
		
		udLbl01.setVisible(false);
		udLbl02.setVisible(false);
		udLbl03.setVisible(false);
		udLbl04.setVisible(false);
		udLbl05.setVisible(false);
		
		uddBBtn.setVisible(false);
		udBtn.setVisible(false);
		
		spLbl01.setVisible(false);
		spLbl02.setVisible(false);
		sptf01.setVisible(false);
		sptf02.setVisible(false);
		spCBtn.setVisible(false);
		spBBtn.setVisible(false);
		
		
		ilbl01.setVisible(false);
		ilbl02.setVisible(false);
		ilbl03.setVisible(false);
		ilbl04.setVisible(false);
		ilbl05.setVisible(false);
		
		lbl01.setVisible(false);
		lbl02.setVisible(false);
		lbl03.setVisible(false);
		lbl04.setVisible(false);
		lbl05.setVisible(false);
		
		logoutBtn.setVisible(false);
		editProfBtn.setVisible(false);
		titleName.setVisible(false);
		title.setVisible(false);
		display.setVisible(false);
		
		eptf01.setVisible(false);
		eptf02.setVisible(false);
		eptf03.setVisible(false);
		eptf04.setVisible(false);
		eptf05.setVisible(false);
		sBtn.setVisible(false);
		bBtn.setVisible(false);
		
	}
	
	public void AddDoctorSection() {
		dpnl03.setVisible(false);
		
		dLbl01.setVisible(false);
		dLbl02.setVisible(false);
		dLbl03.setVisible(false);
		dLbl04.setVisible(false);
		dLbl05.setVisible(false);
		
		adtf01.setVisible(true);
		adtf02.setVisible(true);
		adtf03.setVisible(true);
		adtf04.setVisible(true);
		adtf05.setVisible(true);
		
		adLbl01.setVisible(true);
		adLbl02.setVisible(true);
		adLbl03.setVisible(true);
		adLbl04.setVisible(true);
		adLbl05.setVisible(true);
		
		adBtn.setVisible(true);
		adBBtn.setVisible(true);
	}
	
	public void addDoctortoDB() {
		
		String docName = adtf02.getText();
		String Field = adtf03.getText();
		String email = adtf04.getText();
		String BMDCID = adtf01.getText();
		String phone = adtf05.getText();
		
		
		if(adtf01.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter BMDC ID","Warning",JOptionPane.WARNING_MESSAGE);
			
		}else if(adtf02.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Name","Warning",JOptionPane.WARNING_MESSAGE);
			
		}else if(adtf03.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Field","Warning",JOptionPane.WARNING_MESSAGE);
			
		}else if(adtf04.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter email","Warning",JOptionPane.WARNING_MESSAGE);
			
		}else if(adtf05.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Phone","Warning",JOptionPane.WARNING_MESSAGE);
			
		}else {
			String url = "jdbc:mysql://localhost:4206/dam";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, "dam", "");
				
				Statement st = con.createStatement();
				
				ResultSet rss = st.executeQuery("select `email`,`phone` from `doctor`");
				boolean duplicacy = false;
				
				while(rss.next()) {
					if(rss.getString(1).equals(email) || rss.getString(2).equals(phone)) {
						duplicacy = true;
					}
				}
				
				if(duplicacy != true) {
					int rs = st.executeUpdate("INSERT INTO `doctor`(`bmdc_id`, `doc_name`, `field`, `email`, `phone`) VALUES ('"+BMDCID+"','"+docName+"','"+Field+"','"+email+"','"+phone+"')");
					
					if(rs > 0) {
						adtf01.setText(null);
						adtf02.setText(null);
						adtf03.setText(null);
						adtf04.setText(null);
						adtf05.setText(null);
						adtf01.requestFocus();
						
					}else {
						System.out.println("Not Inserted");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Already registered","Warning",JOptionPane.WARNING_MESSAGE);
					adtf01.setText(null);
					adtf02.setText(null);
					adtf03.setText(null);
					adtf04.setText(null);
					adtf05.setText(null);
					adtf01.requestFocus();
				}
				st.close();
				con.close();
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void RemoveDoctorSection() {
		
		dpnl03.setVisible(false);
		
		dLbl01.setVisible(false);
		
		dLbl02.setVisible(false);
		dLbl03.setVisible(false);
		dLbl04.setVisible(false);
		dLbl05.setVisible(false);
		
		rdtf01.setVisible(true);
		rdtf02.setVisible(true);
		rdtf03.setVisible(true);
		rdtf04.setVisible(true);
		
		rdLbl01.setVisible(true);
		rdLbl02.setVisible(true);
		rdLbl03.setVisible(true);
		rdLbl04.setVisible(true);    
		
		rdRBtn.setVisible(true);
		rdBBtn.setVisible(true);
	}
	
	public void RemoveDocFromDB() {
		String url = "jdbc:mysql://localhost:4206/dam";
		String BMDCID = rdtf01.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			int rs = st.executeUpdate("DELETE FROM `doctor` WHERE bmdc_id = '"+BMDCID+"'");
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Doctor Removed","Warning",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Something went wrong","Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			rdtf01.setText(null);
			rdtf02.setText(null);
			rdtf03.setText(null);
			rdtf04.setText(null);
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void UpdateDoctorSection1() {
		
		dpnl03.setVisible(false);
		
		dLbl01.setVisible(false);
		
		dLbl02.setVisible(false);
		dLbl03.setVisible(false);
		dLbl04.setVisible(false);
		dLbl05.setVisible(false);
		
		ud01tf02.setVisible(true);
		ud01tf01.setVisible(true);
		ud01Lbl02.setVisible(true);
		ud01Lbl01.setVisible(true);
		udBBtn.setVisible(true);
		udNBtn.setVisible(true);
	}
	
	public void UpdateDoctorSection2() {
		
		
		udtf01.setVisible(true);
		udtf02.setVisible(true);
		udtf03.setVisible(true);
		udtf04.setVisible(true);
		udtf05.setVisible(true);
		
		udLbl01.setVisible(true);
		udLbl02.setVisible(true);
		udLbl03.setVisible(true);
		udLbl04.setVisible(true);
		udLbl05.setVisible(true);
		
		uddBBtn.setVisible(true);
		udBtn.setVisible(true);
		
		ud01tf02.setVisible(false);
		ud01tf01.setVisible(false);
		ud01Lbl02.setVisible(false);
		ud01Lbl01.setVisible(false);
		udBBtn.setVisible(false);
		udNBtn.setVisible(false);
	}
	
	public void SetPassSection() {
		
		dpnl03.setVisible(false);
		
		dLbl01.setVisible(false);
		
		dLbl02.setVisible(false);
		dLbl03.setVisible(false);
		dLbl04.setVisible(false);
		dLbl05.setVisible(false);
		
		spLbl01.setVisible(true);
		spLbl02.setVisible(true);
		sptf01.setVisible(true);
		sptf02.setVisible(true);
		spCBtn.setVisible(true);
		spBBtn.setVisible(true);
	}
	
	public void UpdatePasscode() {
		String url = "jdbc:mysql://localhost:4206/dam";
		String PrePass = sptf01.getText();
		String NewPass = sptf02.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "dam", "");
			
			Statement st = con.createStatement();
			
			int rs = st.executeUpdate("UPDATE `doctor` SET `passcode`='"+NewPass+"' WHERE passcode = '"+PrePass+"'");
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Passcode Updated","Warning",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Something went wrong","Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			sptf01.setText(null);
			sptf02.setText(null);
			DoctorSection();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == editProfBtn) {
			editProfileSection(userID);
		}
		
		if(e.getSource() == bBtn) {
			backProfileSection(userID);
		}
		
		if(e.getSource() == sBtn) {
			updateProfile(userID);
		}
		
		if(e.getSource() == logoutBtn) {
			frame.dispose();
			new Login();
		}
		
		if(e.getSource() == adBtn) {
			addDoctortoDB();
		}
		
		if(e.getSource() == adBBtn) {
			DoctorSection();
		}
		
		if(e.getSource() == rdBBtn) {
			DoctorSection();
		}
		
		if(e.getSource() == rdRBtn) {
			RemoveDocFromDB();
		}
		
		if(e.getSource() == udBBtn) {
			DoctorSection();
		}
		
		if(e.getSource() == uddBBtn) {
			DoctorSection();
		}
		
		if(e.getSource() == spBBtn) {
			DoctorSection();
		}
		
		if(e.getSource() == udNBtn) {
			UpdateDoctorSection2();
		}
		
		if(e.getSource() == spCBtn) {
			UpdatePasscode();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mLbl01) {
			backtoProfile(userID);
		}
		
		if(e.getSource() == mLbl02) {
			DoctorSection();
		}
		
		if(e.getSource() == dLbl01) {
			AddDoctorSection();
		}
		
		if(e.getSource() == dLbl02) {
			RemoveDoctorSection();
		}
		
		if(e.getSource() == dLbl03) {
			UpdateDoctorSection1();
		}
		
		if(e.getSource() == dLbl05) {
			SetPassSection();
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
