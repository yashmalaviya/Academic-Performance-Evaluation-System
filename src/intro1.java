import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class intro1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro1 frame = new intro1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public intro1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 866);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel IntroLabel = new JLabel("Academic Performance Evaluation");
		IntroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IntroLabel.setForeground(new Color(255, 0, 0));
		IntroLabel.setBackground(new Color(244, 164, 96));
		IntroLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		IntroLabel.setBounds(296, 0, 1000, 65);
		contentPane.add(IntroLabel);
		
		JLabel lblNewLabel = new JLabel("By - Yash Malaviya || Enroll no. - 0176CS191204");
		lblNewLabel.setFont(new Font("MS PGothic", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(747, 70, 458, 32);
		contentPane.add(lblNewLabel);
		
		JButton adminLoginButton = new JButton("Admin Login");
		adminLoginButton.setForeground(new Color(0, 0, 0));
		adminLoginButton.setBackground(new Color(176, 224, 230));
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin admin = new AdminLogin();
				admin.setVisible(true);
				disposeIntroPage();
				
			}
		});
		adminLoginButton.setFont(new Font("Consolas", Font.BOLD, 18));
		adminLoginButton.setBounds(195, 182, 200, 70);
		contentPane.add(adminLoginButton);
		
		JButton studentButton = new JButton("Enter as Student/ Teacher/ Parent");
		studentButton.setBackground(new Color(176, 224, 230));
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailsDisplay display = new DetailsDisplay();
				display.setVisible(true);
				disposeIntroPage();
			}
		});
		studentButton.setFont(new Font("Consolas", Font.BOLD, 18));
		studentButton.setBounds(967, 182, 415, 70);
		contentPane.add(studentButton);
		
		JTextArea txtrHelloThere = new JTextArea();
		txtrHelloThere.setBackground(SystemColor.inactiveCaption);
		txtrHelloThere.setEditable(false);
		txtrHelloThere.setText("Hello There....\r\nThis is the Academic Performance Evaluation Poject made by Yash Malaviya.\r\nThis application evaluates the Final Grades of students by considering midsem 1, midsem 2, endsem, and Internal Marks\r\nof the student.\r\n* Remember - Only Admin can enter the details of Students. Admin can also add or delete any student, anytime they want.\r\n*Admin's Username - admin1234 ||  Admin's Password - 12345678\r\n\r\n* If you click on the \"Admin Login\" button, then you will be redirected to the Admin's login page. \r\n* Enter the Admin's username and password to enter the application as Admin.\r\n* Enter the details of students and save it.\r\n* After admin is done entering the details of student, they can logout by clicking the \"Logout\" button.\r\n* Now, anyone can enter the application by clicking the \"Enter as Student/ Teacher/ Parent\" button, to see\r\n  the Academic Performance of any student.\r\n* After viewing the details of Students, you can close the application.\r\n\r\nTHANK YOU :-)\r\n\r\nHope you will like it.");
		txtrHelloThere.setFont(new Font("Gabriola", Font.BOLD, 22));
		txtrHelloThere.setBounds(195, 302, 1200, 517);
		contentPane.add(txtrHelloThere);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Softwares\\College Project\\lnct-g-logo (1).png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(576, 112, 293, 180);
		contentPane.add(lblNewLabel_1);
	}
	public void disposeIntroPage(){
		this.dispose();
	}
}
