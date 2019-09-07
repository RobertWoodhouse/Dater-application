package com.rf.dater.businesslayer;

import com.rf.dater.presentationlayer.DaterGUI;;

public class PresentationBusinessLogic {
	
	// Load CSV file
	static CreateArrayRecords createArrayRecords = new CreateArrayRecords();
	
	public static String perfectMatch()
	{
		//createArrayRecords.loadDataFromFile("/Users/RegalBlack/Documents/workspace/RoomFinder/DaterDB.csv");
		createArrayRecords.loadDataFromFile("DaterDB.csv");
		
		// Handle database load exception
		try{
			String[] matchIDs = ReturnMatchIDs.returnMatchIDs(createArrayRecords.getRecords()); 
			
			String result = "";
			result = "";
			int i = 1;
			for(String s : matchIDs){
	          
				System.out.println(" ------------------ Match number " + i +" ----------------\n");
				result += " ------------------ Match number " + i +" ----------------\n";
				int idAsInt = Integer.parseInt(s) -1;
	        	System.out.println(createArrayRecords.getRecordNumber(idAsInt));
	        	result += createArrayRecords.getRecordNumber(idAsInt);
	        	i++;	
			}
			return result;
		}
		catch(Exception e){
			System.out.println("Something went wrong... " + e);
			
			if ((createArrayRecords.getNumberOfRecords()) == 0){
				System.out.println("DB empty or not found");
			}
		}
		return null;
	}
	
	public static void RowSearch(int recordNumber)
	{
		//createArrayRecords.loadDataFromFile("/Users/RegalBlack/Documents/workspace/CapitaDatingApp-Current_branch/src/DaterDater4.csv");
		createArrayRecords.loadDataFromFile("DaterDB.csv");
		
		// Handle database load exception
		try{		
			DaterGUI.firstName = createArrayRecords.getRecordNumber(recordNumber).getFirstName();
			DaterGUI.gender = createArrayRecords.getRecordNumber(recordNumber).getGender();
			DaterGUI.age = createArrayRecords.getRecordNumber(recordNumber).getAge();
			DaterGUI.company = createArrayRecords.getRecordNumber(recordNumber).getCompany();
			DaterGUI.city = createArrayRecords.getRecordNumber(recordNumber).getCity();
			DaterGUI.email = createArrayRecords.getRecordNumber(recordNumber).geteMail();
			DaterGUI.favouriteColour = createArrayRecords.getRecordNumber(recordNumber).getFavColour();
			DaterGUI.surname = createArrayRecords.getRecordNumber(recordNumber).getFamilyName();
			DaterGUI.race = createArrayRecords.getRecordNumber(recordNumber).getRace();
			DaterGUI.jobTitle = createArrayRecords.getRecordNumber(recordNumber).getJobTitle();
			DaterGUI.smokes = createArrayRecords.getRecordNumber(recordNumber).getSmokes();
			DaterGUI.pets = createArrayRecords.getRecordNumber(recordNumber).getHasPets();
			DaterGUI.wantsKids = createArrayRecords.getRecordNumber(recordNumber).getWantsKids();
			DaterGUI.hasKids = createArrayRecords.getRecordNumber(recordNumber).getHasKids();
		}
		catch(Exception e){
			System.out.println("Something went wrong... " + e);
			
			if ((createArrayRecords.getNumberOfRecords()) == 0){
				System.out.println("DB empty or not found");
			}
		}
	}

}
