import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordField;
	private JTextField incorrectTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 10, 311, 53);
		contentPane.add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(58, 143, 121, 33);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(58, 232, 121, 33);
		contentPane.add(passwordLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(189, 148, 238, 29);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 232, 238, 33);
		contentPane.add(passwordField);
		
		incorrectTF = new JTextField();
		incorrectTF.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		incorrectTF.setEditable(false);
		incorrectTF.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectTF.setBounds(189, 292, 198, 27);
		incorrectTF.setVisible(false);
		contentPane.add(incorrectTF);
		incorrectTF.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
		        String pass = passwordField.getText();
		        String username1 = "admin1234";
		        String pass1 = "12345678";
		        if(username.equals(username1) && pass.equals(pass1)){
		            StudentDetails2 detail = new StudentDetails2();
		            detail.setVisible(true);
		           disposeAdminPage();
		        }
		        else {
		        	incorrectTF.setBackground(Color.RED);
		        	incorrectTF.setText("Incorrect Details");
		        	incorrectTF.setVisible(true);
		        }
			}
		});
		
		btnNewButton.setBounds(209, 339, 135, 53);
		contentPane.add(btnNewButton);
		
		JButton goBackButton = new JButton("<< Go Back");
		goBackButton.setBackground(new Color(255, 99, 71));
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intro1 intro = new intro1();
				intro.setVisible(true);
				disposeAdminPage();
			}
		});
		goBackButton.setFont(new Font("Verdana", Font.BOLD, 12));
		goBackButton.setBounds(464, 72, 121, 41);
		contentPane.add(goBackButton);
		
	}
	public void disposeAdminPage(){
		this.dispose();
	}
}
