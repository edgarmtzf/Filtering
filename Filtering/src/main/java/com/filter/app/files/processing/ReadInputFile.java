package com.filter.app.files.processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.filter.app.files.model.FilterModel;
import com.filter.app.files.utilities.Constants;
import com.filter.app.files.utilities.Utilities;

@Component
public class ReadInputFile {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadInputFile.class);
	/**
	 * Method which reads the input file and verifies the coincidences of the parameter word.
	 * 
	 * @author Edgar Mtz
	 * @since 04/07/2020
	 */
	public String readFile(FilterModel model) {

		try {

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(model.getDir()));
			String st;
			List<String> filteredWords = new ArrayList<>();
			int line = 0;
			StringBuilder errors = new StringBuilder();
		
			// Validating if the input doesnt contian more than one word per param.
			String valInputParam = Utilities.validateOneWordInputParam(model.getWords());
			
			if(valInputParam!= null) return valInputParam;

			while((st = br.readLine()) != null) {
				
				line++;
				
				// Validating if the line of the input file doesnt contain more than one word.
				String val = Utilities.validateOneWordInputFile(st, line);
				
				if(val!=null) {
					errors.append(" "+ val);
				}else {
					st = st.replaceAll("[^A-Za-z0-9]", "");
					for(int i = 0; i<model.getWords().size(); i++) {
						if(model.getWords().get(i).equals(st)) filteredWords.add(model.getWords().get(i));
					}
				}
			
			}
			
			if(errors.toString().length()>0) return errors.toString();

			return writeFile(filteredWords);
		} catch (FileNotFoundException e) {
			LOGGER.error("Error on ReadInputFile.readFile(): ", e);
			return "Input file not found.";
		} catch (IOException e) {
			LOGGER.error("Error on ReadInputFile.readFile(): ", e);
			return "Error while reading the file.";
		}
	}

	/**
	 * Method that writes the output file.
	 * 
	 * @return String - dir of the file.
	 * @author Edgar Mtz
	 * @since 05/07/2020
	 */
	public String writeFile(List<String> words) {
		try {

			File outFile = new File(Constants.OUTPUT_DIR);

			if(!outFile.createNewFile()) {
				outFile.delete();
				outFile.createNewFile();
			}

			FileWriter fw = new FileWriter(Constants.OUTPUT_DIR);

			for(int i=0; i<words.size(); i++) {
				fw.write(words.get(i));
				fw.write(System.getProperty("line.separator"));
			}

			fw.close();

			return Constants.OUTPUT_DIR;
		} catch (IOException e) {
			LOGGER.error("Error on ReadInputFile.readFile(): ", e);
			return "An error has occured while the write of the output file.";
		}
	}

}
