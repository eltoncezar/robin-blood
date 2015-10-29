package business;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	
	//Converter data para String
	public String convertStringToDate(Date indate){
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}

}
