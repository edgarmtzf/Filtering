package com.filter.app.files.model;

import java.util.List;

/**
 * Class that contain the model for the input of the service
 * 
 * @author Edgar Mtz
 * @since 05/07/2020
 */
public class FilterModel {
	
	private String dir;
	private List<String> words;
	
	/**
	 * @return the dir
	 */
	public String getDir() {
		return dir;
	}
	/**
	 * @param dir the dir to set
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	/**
	 * @return the words
	 */
	public List<String> getWords() {
		return words;
	}
	/**
	 * @param words the words to set
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}

}
