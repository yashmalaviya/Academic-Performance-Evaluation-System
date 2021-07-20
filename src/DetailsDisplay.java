import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class DetailsDisplay extends JFrame {
	private final String[] SUBJECTS= {"Data Structures","OOPM","Digital Systems","Discrete structures"};
	private final String[] COLUMN =  {"Subjects","Mid Sem 1 (20)", "Mid sem 2 (20)", "End sem (70)", "Internal (20)", "Total (100)", "Grade"};


	private JPanel contentPane;
	private JTable table;
	
	private JTextField nameTF;
	private JTextField rollNoTF;
	private JTextField classTF;
	private JTextField sectionTF;
	private JTextField totalGradeTF;
	private JLabel totalGradeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsDisplay frame = new DetailsDisplay();
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
	public DetailsDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel subjectsModel=new DefaultTableModel();
		for(int i = 0; i < COLUMN.length; i++) {
			subjectsModel.addColumn(COLUMN[i]);
		}
		for(int i = 0; i < SUBJECTS.length; i++) {
			subjectsModel.insertRow(i,new Object[] {SUBJECTS[i],0,0,0,0,0});
		}
		
		
		
        JTable table = new JTable(subjectsModel);
        
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(367,195);
        this.pack();
        this.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

		
        
        JLabel nameLabel = new JLabel("Name -");
		nameLabel.setBounds(65, 500, 135, 43);
		nameLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		nameTF.setBounds(194, 500, 272, 35);
		nameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		getContentPane().add(nameTF);
		nameTF.setColumns(10);
		
		JLabel rollNoLabel = new JLabel("Roll No. -");
		rollNoLabel.setBounds(507, 500, 107, 35);
		rollNoLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		rollNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(rollNoLabel);
		
		rollNoTF = new JTextField();
		rollNoTF.setHorizontalAlignment(SwingConstants.CENTER);
		rollNoTF.setBounds(624, 500, 187, 35);
		rollNoTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		getContentPane().add(rollNoTF);
		rollNoTF.setColumns(10);
		
		totalGradeTF = new JTextField();
		totalGradeTF.setBounds(600,420,95,35);
		totalGradeTF.setVisible(false);
		totalGradeTF.setEditable(false);
		totalGradeTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		totalGradeTF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(totalGradeTF);
		
		totalGradeLabel = new JLabel("Total Grade");
		totalGradeLabel.setBounds(440,420,150,35);
		totalGradeLabel.setVisible(false);
		totalGradeLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		totalGradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(totalGradeLabel);
		
		JLabel classLabel = new JLabel("Class - ");
		classLabel.setBounds(844, 500, 95, 35);
		classLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		classLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(classLabel);
		
		classTF = new JTextField();
		classTF.setHorizontalAlignment(SwingConstants.CENTER);
		classTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		classTF.setBounds(949, 500, 107, 40);
		getContentPane().add(classTF);
		classTF.setColumns(10);
		
		JLabel sectionLabel = new JLabel("Section -");
		sectionLabel.setBounds(1095, 500, 95, 35);
		sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sectionLabel.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		getContentPane().add(sectionLabel);
		
		
		sectionTF = new JTextField();
		sectionTF.setHorizontalAlignment(SwingConstants.CENTER);
		sectionTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		sectionTF.setBounds(1200, 500, 108, 43);
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
		
		
		
		
		JButton showResultButton = new JButton("Show Result");
		showResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String roll = rollNoTF.getText();
				MongoClient client = MongoConnection.getClient();
				MongoCollection<Document> collection = client.getDatabase("StudentDetails").getCollection("details");
				MongoCursor<Document> cursor = collection.find(new Document("_id",roll)).iterator();
				Gson gson = new Gson();
				int oopm[] = new int[4]; int discrete[] = new int[4]; int digital[] = new int[4]; int ds[] = new int[4];
				int oopm1[] = new int[3]; int discrete1[] = new int[3]; int digital1[] = new int[3]; int ds1[] = new int[3];
			    int midsemOopm, sumOopm = 0, midsemDiscrete, midsemDigital, midsemDS, sumDiscrete = 0, sumDigital = 0, sumDS = 0;
				if(cursor.hasNext()) {
					Document doc = cursor.next();
					String name = doc.getString("name");
					String className = doc.getString("className");
					String section = doc.getString("section");
					
					Document marks = (Document)doc.get("subjectMarks");
					for(int i = 1; i < 5; i++) {
						int a = ((Document)marks.get("OOPM")).getInteger(COLUMN[i]);
						oopm[i - 1] = a;
					}
					for(int i = 1; i < 5; i++) {
						discrete[i - 1] = ((Document)marks.get("Discrete structures")).getInteger(COLUMN[i]);
					}
					for(int i = 1; i < 5; i++) {
						digital[i - 1] = ((Document)marks.get("Digital Systems")).getInteger(COLUMN[i]);
					}
					for(int i = 1; i < 5; i++) {
						ds[i - 1] = ((Document)marks.get("Data Structures")).getInteger(COLUMN[i]);
					}
					
					nameTF.setText(name);
					classTF.setText(className);
					sectionTF.setText(section);
					
				}
				if(oopm[0] > oopm[1]) {
					midsemOopm = oopm[0]/2;
				}
				else if(oopm[1] > oopm[0]) {
					midsemOopm = oopm[1]/2;
				}
				else {
					midsemOopm = oopm[0]/2;
				}
				oopm1[0] = midsemOopm;
				oopm1[1] = oopm[2];
				oopm1[2] = oopm[3];
				
				for(int i = 0; i < 3; i++) {
					sumOopm += oopm1[i];
				}
				
				//Discrete Total
				if(discrete[0] > discrete[1]) {
					midsemDiscrete = discrete[0]/2;
				}
				else if(discrete[1] > discrete[0]) {
					midsemDiscrete = discrete[1]/2;
				}
				else {
					midsemDiscrete = discrete[0]/2;
				}
				discrete1[0] = midsemDiscrete;
				discrete1[1] = discrete[2];
				discrete1[2] = discrete[3];
				
				for(int i = 0; i < 3; i++) {
					sumDiscrete += discrete1[i];
				}
				
				// Digital Systems Total
				if(digital[0] > digital[1]) {
					midsemDigital = digital[0]/2;
				}
				else if(digital[1] > digital[0]) {
					midsemDigital = digital[1]/2;
				}
				else {
					midsemDigital = digital[0]/2;
				}
				digital1[0] = midsemDigital;
				digital1[1] = digital[2];
				digital1[2] = digital[3];
				
				for(int i = 0; i < 3; i++) {
					sumDigital += digital1[i];
				}
				
				//Data Structures Total
				if(ds[0] > ds[1]) {
					midsemDS = ds[0]/2;
				}
				else if(ds[1] > ds[0]) {
					midsemDS = ds[1]/2;
				}
				else {
					midsemDS = ds[0]/2;
				}
				ds1[0] = midsemDS;
				ds1[1] = ds[2];
				ds1[2] = ds[3];
				
				for(int i = 0; i < 3; i++) {
					sumDS += ds1[i];
				}
				
				for(int j = 1; j < 5; j++) {
					table.setValueAt(ds[j - 1],0,j);
				}
				table.setValueAt(sumDS, 0, 5);
				if(sumDS >= 91 && sumDS <= 100) {
					table.setValueAt("A+", 0, 6);
				}
				else if(sumDS >= 81 && sumDS <= 90) {
					table.setValueAt("A", 0, 6);
				}
				else if(sumDS >= 71 && sumDS <= 80) {
					table.setValueAt("B+",0, 6);
				}
				else if(sumDS >= 61 && sumDS <= 70) {
					table.setValueAt("B", 0, 6);
				}
				else if(sumDS >= 51 && sumDS <= 60) {
					table.setValueAt("C+", 0, 6);
				}
				else if(sumDS >= 41 && sumDS <= 50) {
					table.setValueAt("C",0,6);
				}
				else if(sumDS == 40) {
					table.setValueAt("D",0, 6);
				}
				else {
					table.setValueAt("F",0,6);
				}
				
				
				for(int j = 1; j < 5; j++) {
					table.setValueAt(oopm[j - 1], 1, j);
				}
				table.setValueAt(sumOopm, 1, 5);
				if(sumOopm >= 91 && sumOopm <= 100) {
					table.setValueAt("A+", 1, 6);
				}
				else if(sumOopm >= 81 && sumOopm <= 90) {
					table.setValueAt("A", 1, 6);
				}
				else if(sumOopm >= 71 && sumOopm <= 80) {
					table.setValueAt("B+",1, 6);
				}
				else if(sumOopm >= 61 && sumOopm <= 70) {
					table.setValueAt("B", 1, 6);
				}
				else if(sumOopm >= 51 && sumOopm <= 60) {
					table.setValueAt("C+", 1, 6);
				}
				else if(sumOopm >= 41 && sumOopm <= 50) {
					table.setValueAt("C",1,6);
				}
				else if(sumOopm == 40) {
					table.setValueAt("D",1, 6);
				}
				else {
					table.setValueAt("F",1,6);
				}
				
				
				for(int j = 1; j < 5; j++) {
					table.setValueAt(digital[j - 1],2,j);
				}
				table.setValueAt(sumDigital, 2, 5);
				if(sumDigital >= 91 && sumDigital <= 100) {
					table.setValueAt("A+", 2, 6);
				}
				else if(sumDigital >= 81 && sumDigital <= 90) {
					table.setValueAt("A", 2, 6);
				}
				else if(sumDigital >= 71 && sumDigital <= 80) {
					table.setValueAt("B+",2, 6);
				}
				else if(sumDigital >= 61 && sumDigital <= 70) {
					table.setValueAt("B", 2, 6);
				}
				else if(sumDigital >= 51 && sumDigital <= 60) {
					table.setValueAt("C+", 2, 6);
				}
				else if(sumDigital >= 41 && sumDigital <= 50) {
					table.setValueAt("C",2,6);
				}
				else if(sumDigital == 40) {
					table.setValueAt("D",2, 6);
				}
				else {
					table.setValueAt("F",2,6);
				}
				
				
				for(int j = 1; j < 5; j++) {
					table.setValueAt(discrete[j - 1],3,j);
				}
				table.setValueAt(sumDiscrete, 3, 5);
				if(sumDiscrete >= 91 && sumDiscrete <= 100) {
					table.setValueAt("A+", 3, 6);
				}
				else if(sumDiscrete >= 81 && sumDiscrete <= 90) {
					table.setValueAt("A", 3, 6);
				}
				else if(sumDiscrete >= 71 && sumDiscrete <= 80) {
					table.setValueAt("B+",3, 6);
				}
				else if(sumDiscrete >= 61 && sumDiscrete <= 70) {
					table.setValueAt("B", 3, 6);
				}
				else if(sumDiscrete >= 51 && sumDiscrete <= 60) {
					table.setValueAt("C+", 3, 6);
				}
				else if(sumDiscrete >= 41 && sumDiscrete <= 50) {
					table.setValueAt("C",3,6);
				}
				else if(sumDiscrete == 40) {
					table.setValueAt("D",3, 6);
				}
				else {
					table.setValueAt("F",3,6);
				}
				
				
				int totalSum = (sumDS + sumOopm + sumDigital + sumDiscrete) / 4;
				String grade;
				if(totalSum >= 91 && totalSum <= 100) {
					grade = "A+";
				}
				else if(totalSum >= 81 && totalSum <= 90) {
					grade = "A";
				}
				else if(totalSum >= 71 && totalSum <= 80) {
					grade = "B+";
				}
				else if(totalSum >= 61 && totalSum <= 70) {
					grade = "B";
				}
				else if(totalSum >= 51 && totalSum <= 60) {
					grade = "C+";
				}
				else if(totalSum >= 41 && totalSum <= 50) {
					grade = "C";
				}
				else if(totalSum == 40) {
					grade = "D";
				}
				else {
					grade = "F";
				}
				totalGradeLabel.setVisible(true);
				totalGradeTF.setVisible(true);
				if(totalSum >= 40 && totalSum <= 100) {
					totalGradeTF.setBackground(Color.GREEN);
				}
				else {
					totalGradeTF.setBackground(Color.RED);
				}
				totalGradeTF.setText(grade);
			}
		});
		showResultButton.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		showResultButton.setBounds(600, 630, 180, 55);
		contentPane.add(showResultButton);
		
		JButton goBack = new JButton("<< Go Back");
		goBack.setBackground(Color.RED);
		goBack.setBounds(800,578, 250, 41);
		goBack.setFont(new Font("Verdana", Font.BOLD, 12));
		goBack.setVisible(true);
		goBack.setEnabled(true);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intro1 intro = new intro1();
				intro.setVisible(true);
				disposeDetailsDisplay();
			}
		});
		getContentPane().add(goBack);
		
		contentPane.add(scrollPane);
		
	}
	void disposeDetailsDisplay() {
		this.dispose();
	}
}
