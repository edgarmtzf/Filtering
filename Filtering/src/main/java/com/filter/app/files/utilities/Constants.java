package com.filter.app.files.utilities;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * Class for the constants of the app.
 * 
 * @author Edgar
 * @since 05/07/2020
 */
public final class Constants {
	
	// Directory and name of the output file.
	public static final String OUTPUT_DIR = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+File.separator+"filtered.txt";

}
