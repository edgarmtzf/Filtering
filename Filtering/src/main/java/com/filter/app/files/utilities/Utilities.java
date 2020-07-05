package com.filter.app.files.utilities;

import java.util.List;

public final class Utilities {
	
	/**
	 * Validates if the line in the input file only contains one word.
	 * 
	 * @param line
	 * @return String
	 * @author Edgar Mtz
	 * @since 05/07/2020
	 */
	public static String validateOneWordInputFile(String line, int num) {
		
		String [] numW = line.split(" ");
		
		if(numW.length>1) return "The line "+num+" of the input file contains more than one word";
		
		return null;
	}
	
	/**
	 * Validates if the line in the input param only contains one word.
	 * 
	 * @param line
	 * @return String
	 * @author Edgar Mtz
	 * @since 05/07/2020
	 */
	public static String validateOneWordInputParam(List<String> param) {
		
		for(int i = 0 ; i<param.size(); i++) {
			if(param.get(i).split(" ").length > 1) return "One or more strings of the parameter 'words' contains more than one word.";
		}
		
		return null;
	}

}
