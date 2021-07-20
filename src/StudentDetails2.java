import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import model.MarksRecord;
import javax.swing.JTextArea;
import java.awt.Color;

public class StudentDetails2 extends JFrame {
	private final String[] SUBJECTS= {"Data Structures","OOPM","Digital Systems","Discrete structures"};
	private final String[] COLUMN =  {"Subjects","Mid Sem 1 (20)", "Mid sem 2 (20)", "End sem (70)", "Internal (20)", "Classes Attended"};
	//private JPanel contentPane;
	private JTextField nameTF;
	private JTextField rollNoTF;
	private JTextField classTF;
	private JTextField sectionTF;
	/**
	 * @wbp.nonvisual location=431,504
	 */
	private final JTextField DuplicateTF = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails2 frame = new StudentDetails2();
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
	
	 public StudentDetails2()
	    {
		getContentPane().setLayout(null);
		DuplicateTF.setBounds(700, 400, 350, 50);
		DuplicateTF.setFont(new Font("Tahoma", Font.BOLD, 14));
		DuplicateTF.setHorizontalAlignment(SwingConstants.CENTER);
		DuplicateTF.setColumns(10);
		DuplicateTF.setVisible(false);
		getContentPane().add(DuplicateTF);
	    	
			DefaultTableModel subjectsModel=new DefaultTableModel();
			for(int i = 0; i < COLUMN.length; i++) {
				subjectsModel.addColumn(COLUMN[i]);
			}
			for(int i = 0; i < SUBJECTS.length; i++) {
				subjectsModel.insertRow(i,new Object[] {SUBJECTS[i],0,0,0,0});
			}
	        //create table with data
	        JTable table = new JTable(subjectsModel);
	         
	        //add the table to the frame
	       
	         
	        this.setTitle("Table Example");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        this.setSize(367,195);
	        this.pack();
	        this.setVisible(true);
	        setExtendedState(JFrame.MAXIMIZED_BOTH);
	        
	        JLabel attendanceLabel = new JLabel("Total no. of classes in each subjects :");
	        attendanceLabel.setBounds(45, 400, 330, 43);
	        attendanceLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
	        attendanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().add(attendanceLabel);
	        
	        JLabel dsAttendance = new JLabel("Data Structures : ");
	        dsAttendance.setBounds(65, 460, 200, 43);
	        dsAttendance.setFont(new Font("Nirmala UI", Font.BOLD, 18));
	        dsAttendance.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().add(dsAttendance);
	        
	        JTextField dsAttendanceTF = new JTextField();
	        dsAttendanceTF.setBounds(267, 460, 108, 43);
	        dsAttendanceTF.setHorizontalAlignment(SwingConstants.CENTER);
	        dsAttendanceTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        dsAttendanceTF.setColumns(10);
	        getContentPane().add(dsAttendanceTF);
	        
	        JLabel oopmAttendance = new JLabel("OOPM : ");
	        oopmAttendance.setBounds(400, 460, 100, 43);
	        oopmAttendance.setFont(new Font("Nirmala UI", Font.BOLD, 18));
	        oopmAttendance.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().add(oopmAttendance);
	        
	        JTextField oopmAttendanceTF = new JTextField();
	        oopmAttendanceTF.setBounds(510, 460, 108, 43);
	        oopmAttendanceTF.setHorizontalAlignment(SwingConstants.CENTER);
	        oopmAttendanceTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        oopmAttendanceTF.setColumns(10);
	        getContentPane().add(oopmAttendanceTF);
	        
	        JLabel digiAttendance = new JLabel("Digital Systems : ");
	        digiAttendance.setBounds(660, 460, 150, 43);
	        digiAttendance.setFont(new Font("Nirmala UI", Font.BOLD, 18));
	        digiAttendance.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().add(digiAttendance);
	        
	        JTextField digiAttendanceTF = new JTextField();
	        digiAttendanceTF.setBounds(825, 460, 108, 43);
	        digiAttendanceTF.setHorizontalAlignment(SwingConstants.CENTER);
	        digiAttendanceTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        digiAttendanceTF.setColumns(10);
	        getContentPane().add(digiAttendanceTF);
	        
	        JLabel disAttendance = new JLabel("Discrete Structures : ");
	        disAttendance.setBounds(985, 460, 180, 43);
	        disAttendance.setFont(new Font("Nirmala UI", Font.BOLD, 18));
	        disAttendance.setHorizontalAlignment(SwingConstants.CENTER);
	        getContentPane().add(disAttendance);
	        
	        JTextField disAttendanceTF = new JTextField();
	        disAttendanceTF.setBounds(1180, 460, 108, 43);
	        disAttendanceTF.setHorizontalAlignment(SwingConstants.CENTER);
	        disAttendanceTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        disAttendanceTF.setColumns(10);
	        getContentPane().add(disAttendanceTF);
	    	
			JLabel nameLabel = new JLabel("Name -");
			nameLabel.setBounds(65, 580, 135, 43);
			nameLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(nameLabel);
			
			nameTF = new JTextField();
			nameTF.setHorizontalAlignment(SwingConstants.CENTER);
			nameTF.setBounds(194, 580, 272, 35);
			nameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
			getContentPane().add(nameTF);
			nameTF.setColumns(10);
			
			JLabel rollNoLabel = new JLabel("Roll No. -");
			rollNoLabel.setBounds(507, 580, 107, 35);
			rollNoLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
			rollNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(rollNoLabel);
			
			rollNoTF = new JTextField();
			rollNoTF.setHorizontalAlignment(SwingConstants.CENTER);
			rollNoTF.setBounds(624, 580, 187, 35);
			rollNoTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
			getContentPane().add(rollNoTF);
			rollNoTF.setColumns(10);
			
			JLabel classLabel = new JLabel("Class - ");
			classLabel.setBounds(844, 580, 95, 35);
			classLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
			classLabel.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(classLabel);
			
			classTF = new JTextField();
			classTF.setHorizontalAlignment(SwingConstants.CENTER);
			classTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
			classTF.setBounds(949, 580, 107, 40);
			getContentPane().add(classTF);
			classTF.setColumns(10);
			
			JLabel sectionLabel = new JLabel("Section -");
			sectionLabel.setBounds(1095, 580, 95, 35);
			sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			sectionLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
			getContentPane().add(sectionLabel);
			
			sectionTF = new JTextField();
			sectionTF.setHorizontalAlignment(SwingConstants.CENTER);
			sectionTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
			sectionTF.setBounds(1200, 580, 108, 43);
			getContentPane().add(sectionTF);
			sectionTF.setColumns(10);
			
			
			TableModel tmodel=table.getModel();
			
			for(int j = 0; j < tmodel.getColumnCount();j++) {
			table.getColumnModel().getColumn(j).setWidth(50);
			}
		
		table.setMaximumSize(new java.awt.Dimension(2147483647, 500));

		table.setMinimumSize(new java.awt.Dimension(75, 500));

		table.setPreferredSize(new java.awt.Dimension(375, 500));

		table.setRowHeight(40);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(65, 41, 1258, 346);
		JButton uploadButton = new JButton("Upload Data");
		uploadButton.setBounds(550, 680, 233, 43);
		uploadButton.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel tm=table.getModel();
				
				//Hash Map is a set of key value pair to be precise.
				//We make two Hash Maps 1. First Hash Map have key value pair of String and a Hash Map 2. And second Hash Map contains the key value pair of a String and a Integer
				// Second Hash Map have the name of examination as key and the marks in that examination as the value connected with the key. <String = Examinatin, Integer = Marks>
				// First Hash Map have the name of Subject as the key and the Second Hash Map (<String = Exam, Integer = Marks>) as the value. <String = Subject, HashMap = Second Hash Map>\
				// So the First Hash Map works like a Table.
				// We send the First Hash Map to the MongoDB Database.
				HashMap<String,HashMap<String,Integer>> subjectsMap=new HashMap<String,HashMap<String,Integer>>();
				for(int i=0;i<tm.getRowCount();i++) {
					HashMap<String,Integer> marksMap=new HashMap<String,Integer>();
					for(int j=1;j<tm.getColumnCount();j++) {
						System.out.println("Value of i="+i+" j="+j);
						Object mark=tm.getValueAt(i,j);
						Integer intmark=Integer.valueOf((String)mark.toString().trim());
						System.out.println("Read as String="+intmark);
						marksMap.put(COLUMN[j],intmark);
						subjectsMap.put(SUBJECTS[i], marksMap);
					}
				}
				String name1 = nameTF.getText();
			    String roll1 = rollNoTF.getText();
			    String className1 = classTF.getText();
			    String section1 = sectionTF.getText();
			    
			    // Send The First Hash Map which works like a Tabel is sent to MongoDB Database using MarksRecord.java
				MarksRecord marksRecord=new MarksRecord(name1,className1,section1, roll1,subjectsMap);
				Gson gson=new Gson();
				// As we know, Data is stored in MongoDB in the form of Json Object. So we convert the 
				String stobj=gson.toJson(marksRecord);
				System.out.println("String value of conveterted Java object to JSON object="+stobj);
				BasicDBObject obj=(BasicDBObject)JSON.parse(stobj);
				MongoClient client=MongoConnection.getClient();			
				DBCollection collection=client.getDB("StudentDetails").getCollection("details");
				try {
				collection.insert(obj);
				DuplicateTF.setVisible(true);
				DuplicateTF.setBackground(Color.GREEN);
				DuplicateTF.setText("Data uploaded for rollnumber:"+marksRecord.get_id());
				
				//call this at the time of dispose
				//client.close();
				}
				catch(DuplicateKeyException ex) {
					//System.out.println("Duplicate Entry. Please try again");
					DuplicateTF.setVisible(true);
					DuplicateTF.setBackground(Color.RED);
					DuplicateTF.setText("Duplicate Entry");
				}	
			}
			});
		
		JButton goBack = new JButton("<< Logout & Go Back");
		goBack.setBackground(Color.RED);
		goBack.setBounds(800,680, 250, 41);
		goBack.setFont(new Font("Verdana", Font.BOLD, 12));
		goBack.setVisible(true);
		goBack.setEnabled(true);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intro1 intro = new intro1();
				intro.setVisible(true);
				disposeStudentDetails();
			}
		});
		getContentPane().add(goBack);
			getContentPane().add(uploadButton);
			getContentPane().add(scrollPane);
		}
	 void disposeStudentDetails() {
		 this.dispose();
	 }
}
