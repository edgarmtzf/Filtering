package com.filter.app.files.model;

import org.springframework.stereotype.Component;

/**
 * Model that contains the response of the service
 * 
 * @author Edgar
 * @since 05/07/2020
 */
@Component
public class OutputModel {
	
	private String dir;

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

}
