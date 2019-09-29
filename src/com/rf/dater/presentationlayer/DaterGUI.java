package com.rf.dater.presentationlayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.rf.dater.businesslayer.CreateArrayRecords;
import com.rf.dater.businesslayer.PresentationBusinessLogic;
import com.rf.dater.businesslayer.ReturnMatchIDs;
import com.rf.dater.datalayer.ReturnMatchData;

import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DaterGUI extends JFrame {
	
	public enum SwitchVars {
		YES, NO, MALE, FEMALE;
	}

	private JPanel contentPane;
	private JPanel pnlShowRowSearch;
	private JPanel pnlDisplayRowNumber;
	private JPanel pnlDisplayMatchCriteria;
	
	private JTextField txtSearch;
	private JTextField txtFirstName;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTextField txtCompany;
	private JTextField txtCity;
	private JTextField txtEmail;
	private JTextField txtSurname;
	private JTextField txtRace;
	private JTextField txtJobTitle;
	private JTextField txtSmokes;
	private JTextField txtPets;
	private JTextField txtHasKids;
	
	private int recordNum;
	
	public static String firstName = "<Empty>";
	public static String gender = "<Empty>";
	public static String age = "<Empty>";
	public static String company = "<Empty>";
	public static String city = "<Empty>";
	public static String email = "<Empty>";
	public static String favouriteColour = "<Empty>";
	public static String surname = "<Empty>";
	public static String race = "<Empty>";
	public static String jobTitle = "<Empty>";
	public static String smokes = "<Empty>";
	public static String pets = "<Empty>";
	public static String wantsKids = "<Empty>";
	public static String hasKids = "<Empty>";
	
	// Load CSV file
	CreateArrayRecords createArrayRecords = new CreateArrayRecords();
	

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaterGUI frame = new DaterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// Create the frame.
	public DaterGUI() {
				
		// Create content pane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		// Panel init
		final JPanel pnlWelcomePage = new JPanel();
		contentPane.add(pnlWelcomePage, "name_137827202899584");
		pnlWelcomePage.setLayout(null);
		pnlWelcomePage.setVisible(true);
		
		final JPanel pnlShowRowSearch = new JPanel();
		contentPane.add(pnlShowRowSearch, "name_137840098798958");
		pnlShowRowSearch.setLayout(null);
		pnlShowRowSearch.setVisible(false);
		
		final JPanel pnlDisplayRowNumber = new JPanel();
		contentPane.add(pnlDisplayRowNumber, "name_137846329870897");
		pnlDisplayRowNumber.setLayout(null);
		pnlDisplayRowNumber.setVisible(false);
		
		final JPanel pnlShowPerfectMatches = new JPanel();
		contentPane.add(pnlShowPerfectMatches, "name_137843360956006");
		pnlShowPerfectMatches.setLayout(null);
		pnlShowPerfectMatches.setVisible(false);
		
		final JPanel pnlDisplayMatchCriteria = new JPanel();
		contentPane.add(pnlDisplayMatchCriteria, "name_137849133093256");
		pnlDisplayMatchCriteria.setLayout(null);
		pnlDisplayMatchCriteria.setVisible(false);
		
		// Welcome Page				
		JLabel lblTitle = new JLabel("Welcome to Dater");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		lblTitle.setBounds(182, 33, 359, 50);
		pnlWelcomePage.add(lblTitle);
		
		JButton btnSearch = new JButton(">>");
		btnSearch.setBounds(387, 164, 114, 29);
		pnlWelcomePage.add(btnSearch);
		
        ActionListener actLisSearchBtn = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	//ShowRowSearch.main(null);
            	pnlWelcomePage.setVisible(false);
            	pnlShowRowSearch.setVisible(true);
            }
        };
        
        btnSearch.addActionListener(actLisSearchBtn);
		
		JLabel lblSearchRecords = new JLabel("Search Records:");
		lblSearchRecords.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSearchRecords.setBounds(182, 167, 114, 16);
		pnlWelcomePage.add(lblSearchRecords);
		
		JLabel lblMatchMaker = new JLabel("Roommate Finder:");
		lblMatchMaker.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblMatchMaker.setBounds(182, 266, 156, 16);
		pnlWelcomePage.add(lblMatchMaker);
		
		JButton btnMaker = new JButton(">>");
		btnMaker.setBounds(387, 262, 114, 29);
		pnlWelcomePage.add(btnMaker);
		
		JLabel lblHeading = new JLabel("#1 for homeshare and roomates");
		lblHeading.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblHeading.setBounds(182, 81, 233, 41);
		pnlWelcomePage.add(lblHeading);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogo.setLocation(109, 0);
		lblLogo.setIcon(new ImageIcon("/Users/RegalBlack/Documents/workspace/RoomFinder/Dater-Pic.png"));
		//lblLogo.setSize(581, 418);
		lblLogo.setBounds(-107, -325, 1235, 1200);
		pnlWelcomePage.add(lblLogo);
		
        ActionListener actLisMakerBtn = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlWelcomePage.setVisible(false);
            	pnlDisplayMatchCriteria.setVisible(true);
            }
        };
        
        btnMaker.addActionListener(actLisMakerBtn); 
		
		
		// Show Row Search		
		JLabel lblRecordNumber = new JLabel("Search Client Records");
		lblRecordNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblRecordNumber.setBounds(198, 6, 305, 34);
		pnlShowRowSearch.add(lblRecordNumber);
		
		JLabel lblSearch = new JLabel("Enter Record Number:");
		lblSearch.setBounds(131, 146, 145, 16);
		pnlShowRowSearch.add(lblSearch);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(537, 393, 117, 29);
		pnlShowRowSearch.add(btnNext);
		
        ActionListener actLisNxtBtn = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		recordNum = Integer.parseInt(txtSearch.getText());
            		System.out.println("Record Number = " + recordNum);
            	}
            	catch (NumberFormatException ex)
            	{
            		System.out.println("Not a valid number, " + ex + " exception");
            	}
            	
            	//DisplayRowNumber.main(null);
        		pnlShowRowSearch.setVisible(false);
        		pnlDisplayRowNumber.setVisible(true);
        		
        		// Update Row Search
        		PresentationBusinessLogic.RowSearch(recordNum);
        		
        		txtFirstName.setText(firstName);
        		txtGender.setText(gender);
        		txtAge.setText(age);
        		txtCity.setText(city);
        		txtEmail.setText(email);
        		txtCompany.setText(company);
        		//txtFavouriteColour.setText(favouriteColour);
        		txtSurname.setText(surname);
        		txtRace.setText(race);
        		txtJobTitle.setText(jobTitle);
        		txtSmokes.setText(smokes);
        		txtPets.setText(pets);
        		//txtWantsKids.setText(wantsKids);
        		txtHasKids.setText(hasKids);
            }
        };
        
        btnNext.addActionListener(actLisNxtBtn);
        
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(41, 393, 117, 29);
		pnlShowRowSearch.add(btnPrevious);
				
        ActionListener actLisPreBtn = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
        		pnlShowRowSearch.setVisible(false);
        		pnlWelcomePage.setVisible(true);
            }
        };
        
        btnPrevious.addActionListener(actLisPreBtn);
        
		txtSearch = new JTextField();
		txtSearch.setText("0");
		txtSearch.setBounds(352, 141, 130, 26);
		pnlShowRowSearch.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		// Show Perfect Matches		
		JLabel lblYourPerfectMatch = new JLabel("Roommate Search Results");
		lblYourPerfectMatch.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblYourPerfectMatch.setBounds(216, 31, 303, 59);
		pnlShowPerfectMatches.add(lblYourPerfectMatch);
		
		JTextArea textAreaMatch = new JTextArea(10, 20);
		JScrollPane scroll = new JScrollPane (textAreaMatch, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textAreaMatch.setEditable(false);
		textAreaMatch.setLineWrap(true);
		scroll.setBounds(31, 102, 641, 278);
		pnlShowPerfectMatches.add(scroll);
			
		JButton btnPrevious2 = new JButton("Previous");
		btnPrevious2.setBounds(41, 393, 117, 29);
		pnlShowPerfectMatches.add(btnPrevious2);
		
		
        ActionListener actLisPreBtn2 = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	//DisplayMatchCriteria.main(null);
            	pnlShowPerfectMatches.setVisible(false);
            	pnlDisplayMatchCriteria.setVisible(true);
            }
        };
        
        btnPrevious2.addActionListener(actLisPreBtn2);
    
				
		// Display Row Number
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(6, 6, 88, 25);
		pnlDisplayRowNumber.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(370, 10, 77, 16);
		pnlDisplayRowNumber.add(lblSurname);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(6, 60, 61, 16);
		pnlDisplayRowNumber.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(370, 101, 61, 16);
		pnlDisplayRowNumber.add(lblEmail);
		
		JLabel lblRace = new JLabel("Race:");
		lblRace.setBounds(370, 60, 61, 16);
		pnlDisplayRowNumber.add(lblRace);
		
		JLabel lblCompany = new JLabel("Company:");
		lblCompany.setBounds(6, 210, 77, 16);
		pnlDisplayRowNumber.add(lblCompany);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(6, 282, 61, 16);
		pnlDisplayRowNumber.add(lblCity);
		
		JLabel lblSmokes = new JLabel("Smokes?");
		lblSmokes.setBounds(370, 370, 61, 16);
		pnlDisplayRowNumber.add(lblSmokes);
		
		JLabel lblPets = new JLabel("Pets?");
		lblPets.setBounds(370, 282, 61, 16);
		pnlDisplayRowNumber.add(lblPets);
		
		JLabel lblHasKids = new JLabel("Has Kids?");
		lblHasKids.setBounds(370, 329, 61, 16);
		pnlDisplayRowNumber.add(lblHasKids);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setBounds(6, 160, 61, 16);
		pnlDisplayRowNumber.add(lblJobTitle);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(6, 101, 61, 16);
		pnlDisplayRowNumber.add(lblAge);
		
		JButton btnPrevious3 = new JButton("Previous");
		btnPrevious3.setBounds(41, 393, 117, 29);
		pnlDisplayRowNumber.add(btnPrevious3);
				
        ActionListener actLisPreBtn3 = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlDisplayRowNumber.setVisible(false);
            	pnlShowRowSearch.setVisible(true);
            }
        };
        
        btnPrevious3.addActionListener(actLisPreBtn3);
		
		System.out.println("Record num = " + recordNum);
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(142, 5, 194, 26);
		pnlDisplayRowNumber.add(txtFirstName);
			
		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setColumns(10);
		txtGender.setBounds(142, 55, 88, 26);
		pnlDisplayRowNumber.add(txtGender);
			
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setColumns(10);
		txtAge.setBounds(142, 96, 67, 26);
		pnlDisplayRowNumber.add(txtAge);
			
		txtCompany = new JTextField();
		txtCompany.setEditable(false);
		txtCompany.setColumns(10);
		txtCompany.setBounds(142, 205, 289, 26);
		pnlDisplayRowNumber.add(txtCompany);
			
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setColumns(10);
		txtCity.setBounds(142, 277, 183, 26);
		pnlDisplayRowNumber.add(txtCity);
			
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(443, 96, 224, 26);
		pnlDisplayRowNumber.add(txtEmail);
			
		txtSurname = new JTextField();
		txtSurname.setEditable(false);
		txtSurname.setColumns(10);
		txtSurname.setBounds(443, 5, 202, 26);
		pnlDisplayRowNumber.add(txtSurname);
			
		txtRace = new JTextField();
		txtRace.setEditable(false);
		txtRace.setColumns(10);
		txtRace.setBounds(443, 55, 136, 26);
		pnlDisplayRowNumber.add(txtRace);
			
		txtJobTitle = new JTextField();
		txtJobTitle.setEditable(false);
		txtJobTitle.setColumns(10);
		txtJobTitle.setBounds(142, 155, 289, 26);
		pnlDisplayRowNumber.add(txtJobTitle);
			
		txtSmokes = new JTextField();
		txtSmokes.setEditable(false);
		txtSmokes.setBounds(459, 365, 77, 26);
		pnlDisplayRowNumber.add(txtSmokes);
		txtSmokes.setColumns(10);
			
		txtPets = new JTextField();
		txtPets.setEditable(false);
		txtPets.setColumns(10);
		txtPets.setBounds(459, 277, 77, 26);
		pnlDisplayRowNumber.add(txtPets);
			
		txtHasKids = new JTextField();
		txtHasKids.setEditable(false);
		txtHasKids.setColumns(10);
		txtHasKids.setBounds(459, 324, 77, 26);
		pnlDisplayRowNumber.add(txtHasKids);
	
		
		// Display Match Criteria
		JLabel lblTitleCri = new JLabel("Enter Roommate Criteria...");
		lblTitleCri.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitleCri.setBounds(215, 6, 261, 34);
		pnlDisplayMatchCriteria.add(lblTitleCri);
		
		JLabel lblNoKids = new JLabel("Kids?");
		lblNoKids.setBounds(215, 81, 61, 16);
		pnlDisplayMatchCriteria.add(lblNoKids);
		
		JLabel lblGuest = new JLabel("Guests?");
		lblGuest.setBounds(215, 143, 81, 16);
		pnlDisplayMatchCriteria.add(lblGuest);
		
		JLabel lblSmoker = new JLabel("Smoker?");
		lblSmoker.setBounds(215, 207, 61, 16);
		pnlDisplayMatchCriteria.add(lblSmoker);
		
		JLabel lblPets3 = new JLabel("Pets?");
		lblPets3.setBounds(215, 271, 94, 16);
		pnlDisplayMatchCriteria.add(lblPets3);
		
		JLabel lblGender3 = new JLabel("Gender?");
		lblGender3.setBounds(215, 331, 61, 16);
		pnlDisplayMatchCriteria.add(lblGender3);
		
		JButton btnNext3 = new JButton("Next");
		btnNext3.setBounds(537, 393, 117, 29);
		pnlDisplayMatchCriteria.add(btnNext3);
		
        ActionListener actLisNxtBtn3 = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlDisplayMatchCriteria.setVisible(false);
            	pnlShowPerfectMatches.setVisible(true);
            	textAreaMatch.setText(PresentationBusinessLogic.perfectMatch()); // Update Perfect Match text field
            }
        };
        
        btnNext3.addActionListener(actLisNxtBtn3);
        
		JButton btnPrevious4 = new JButton("Previous");
		btnPrevious4.setBounds(41, 393, 117, 29);
		pnlDisplayMatchCriteria.add(btnPrevious4);
		
        ActionListener actLisPreBtn4 = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlDisplayMatchCriteria.setVisible(false);
            	pnlWelcomePage.setVisible(true);
            }
        };
        
        btnPrevious4.addActionListener(actLisPreBtn4);
		
		JComboBox cbxNoKids = new JComboBox();
		cbxNoKids.setMaximumRowCount(2);
		cbxNoKids.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		cbxNoKids.setBounds(350, 76, 126, 29);
		pnlDisplayMatchCriteria.add(cbxNoKids);
				
        ActionListener actLisNoKids = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cbxNoKids.getSelectedItem();
                SwitchVars sv = null;
                sv = ((s == "Yes") ? sv.YES : sv.NO);

                switch (sv) {//check for a match
                	default:
                    case YES:
                        ReturnMatchIDs.wantedNoKids = "true";
                        System.out.println("No kids = true");
                        break;
                    case NO:
                        ReturnMatchIDs.wantedNoKids = "false";
                        System.out.println("No kids = false");
                        break;
                }
            }
        };
        
        cbxNoKids.addActionListener(actLisNoKids);
		
		JComboBox cbxMoreKids = new JComboBox();
		cbxMoreKids.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		cbxMoreKids.setMaximumRowCount(2);
		cbxMoreKids.setBounds(350, 139, 126, 29);
		pnlDisplayMatchCriteria.add(cbxMoreKids);
		
        ActionListener actLisMoreKids = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cbxMoreKids.getSelectedItem();
                SwitchVars sv = null;
                sv = ((s == "Yes") ? sv.YES : sv.NO);

                switch (sv) {//check for a match
                	default:
                    case YES:
                        ReturnMatchIDs.wantedMoreKids = "true";
                        System.out.println("More kids = true");
                        break;
                    case NO:
                        ReturnMatchIDs.wantedMoreKids = "false";
                        System.out.println("More kids = false");
                        break;
                }
            }
        };
        
        cbxMoreKids.addActionListener(actLisMoreKids);
		
		JComboBox cbxSmoker = new JComboBox();
		cbxSmoker.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		cbxSmoker.setMaximumRowCount(2);
		cbxSmoker.setBounds(350, 203, 126, 29);
		pnlDisplayMatchCriteria.add(cbxSmoker);
		
        ActionListener actLisSmoker = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cbxSmoker.getSelectedItem();
                SwitchVars sv = null;
                sv = ((s == "Yes") ? sv.YES : sv.NO);

                switch (sv) {//check for a match
                	default:
                    case YES:
                        ReturnMatchIDs.wantedSmoker = "true";
                        System.out.println("Wanted smoker = true");
                        break;
                    case NO:
                        ReturnMatchIDs.wantedSmoker = "false";
                        System.out.println("Wanted smoker = false");
                        break;
                }
            }
        };
        
        cbxSmoker.addActionListener(actLisSmoker);
		
		JComboBox cbxPets = new JComboBox();
		cbxPets.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		cbxPets.setMaximumRowCount(2);
		cbxPets.setBounds(350, 267, 126, 29);
		pnlDisplayMatchCriteria.add(cbxPets);
		
        ActionListener actLisPets = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cbxPets.getSelectedItem();
                SwitchVars sv = null;
                sv = ((s == "Yes") ? sv.YES : sv.NO);

                switch (sv) {//check for a match
                	default:
                    case YES:
                        ReturnMatchIDs.wantedPets = "true";
                        System.out.println("Wanted pets = true");
                        break;
                    case NO:
                        ReturnMatchIDs.wantedPets = "false";
                        System.out.println("Wanted pets = false");
                        break;
                }
            }
        };
		
        cbxPets.addActionListener(actLisPets);
		
		JComboBox cbxGender = new JComboBox();
		cbxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbxGender.setMaximumRowCount(2);
		cbxGender.setBounds(350, 327, 126, 29);
		pnlDisplayMatchCriteria.add(cbxGender);
		
        ActionListener actLisGender = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) cbxGender.getSelectedItem();
                SwitchVars sv = null;
                sv = ((s == "Male") ? sv.MALE : sv.FEMALE);

                switch (sv) {//check for a match
                	default:
                    case MALE:
                        ReturnMatchIDs.wantedGender = "Male";
                        System.out.println("Wanted gender = Male");
                        break;
                    case FEMALE:
                        ReturnMatchIDs.wantedGender = "Female";
                        System.out.println("Wanted gender = Female");
                        break;
                }
            }
        };
        
        cbxGender.addActionListener(actLisGender);
	}
}
