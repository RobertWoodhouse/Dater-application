package com.rf.dater.businesslayer;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.rf.dater.datalayer.ReturnMatchData;


public class CreateArrayRecords {
	private ArrayList <ReturnMatchData> records;
	
	public ReturnMatchData record;
	
	public CreateArrayRecords() {
		records = new ArrayList<ReturnMatchData>();
	}

	public int getNumberOfRecords() {
		return records.size();
	}
	
	public ReturnMatchData getRecordNumber(int i){
		return records.get(i);		
	}	
	
	public ArrayList<ReturnMatchData> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<ReturnMatchData> records) {
		this.records = records;
	}

	public void loadDataFromFile(String filepath) {
		
		try{
			
			Scanner scanner = new Scanner(new FileReader(filepath));
			
			String line;
			//ReturnMatchData record;
			
			scanner.nextLine();
			
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				line = line.replace(", ", " - ");
				String[] results = line.split(",");
				
				String id = (results[0]);
				String firstName = (results[1]);
				String familyName = (results[2]);
				String gender = (results[4]);
				String eMail = (results[3]);
				String race = (results[5]);
				String company = (results[6]); 
				String city = (results[7]);
				String country = (results[8]);
				String smokes = (results[9]);
				String hasPets = (results[10]);
				String wantsKids = (results[11]);
				String hasKids = (results[12]);
				String jobTitle = (results[13]);
				String favColour = (results[14]);
				String age = (results[15]);
				
				
				record = new ReturnMatchData(id, firstName, familyName, gender, eMail, race, company, city, 
						 country, smokes, hasPets, wantsKids, hasKids, jobTitle, favColour, age);
				
				records.add(record);			
		}
		
		scanner.close();
		
	} catch (Exception e) {
		System.out.println("Error: " + e.getMessage() );
	}
	}
}


