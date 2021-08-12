/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Facilitator of reading and writing on the console.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
public class Consolex  {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private static OutputConsolex out;
	private static InputConsolex in;
	
	
	//-------------------------------------------------------------------------
	//		Initialization blocks
	//-------------------------------------------------------------------------
	static {
		out = new OutputConsolex();
		in = new InputConsolex();
	}
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	private Consolex() {
	}


	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	/**
	 * Reads a line from console.
	 *  
	 * @return		Read line
	 * 
	 * @throws		IOException If it is not possible to read the console input 
	 */
	public static String readLine() throws IOException {
		return in.readLine();
	}
	
	/**
	 * Writes a line on the console, putting a line break at the end.
	 * 
	 * @param		line Line to be written
	 */
	public static void writeLine(Object line) {
		out.writeLine(line);
	}
	
	/**
	 * Writes lines on the console, putting a line break at the end of each line.
	 * 
	 * @param		lines Lines to be written
	 */
	public static void writeLines(Object... lines) {
		out.writeLines(lines);
	}

	/**
	 * Writes lines on the console, putting a line break at the end of each line.
	 * 
	 * @param		lines Lines to be written
	 */
	public static void writeLines(List<String> lines) {
		out.writeLines(lines);
	}

	/**
	 * Writes a content on the console without putting a line break at the end of
	 * each line.
	 * 
	 * @param		content Content to be written
	 */
	public static void write(Object content) {
		out.write(content);
	}

	/**
	 * Write lines from a text file to the console. 
	 * 
	 * @param		file File  that will have its lines written on the console
	 * 
	 * @throws		IOException If file cannot be read
	 */
	public static void writeFileLines(Path file) throws IOException {
		out.writeFileLines(file);
	}

	/**
	 * Write lines from a text file to the console. Besides, it shows the line 
	 * number of each line on the left. 
	 * 
	 * @param		file File  that will have its lines written on the console
	 * 
	 * @throws		IOException If file cannot be read
	 */
	public static void writeFileLinesWithEnumeration(Path file) 
			throws IOException {
		out.writeFileLinesWithEnumeration(file);
	}

	/**
	 * Writes a division line.
	 */
	public static void writeDiv() {
		out.writeDiv();
	}
	
	/**
	 * Writes a division line.
	 * 
	 * @param		symbol Symbol that will compose the division
	 */
	public static void writeDiv(String symbol) {
		out.writeDiv(symbol);
	}

	/**
	 * Writes a title between two dividers.
	 * 
	 * @param		title Header title
	 */
	public static void writeHeader(Object title) {
		out.writeHeader(title);
	}

	/**
	 * Writes a title between two dividers.
	 * 
	 * @param		title Header title
	 * @param		symbol Symbol that will compose the dividers 
	 */
	public static void writeHeader(Object title, String symbol) {
		out.writeHeader(title, symbol);
	}

	/**
	 * Displays an error message. <br>
	 * <b>Format:</b> <code>[ERROR] &lt;message&gt;</code>
	 * 
	 * @param		message Message to be displayed
	 */
	public static void writeError(Object message) {
		out.writeError(message);
	}
	
	/**
	 * Displays a warning message. <br>
	 * <b>Format:</b> <code>[WARN] &lt;message&gt;</code>
	 * 
	 * @param		message Message to be displayed
	 */
	public static void writeWarning(Object message) {
		out.writeWarning(message);
	}
	
	/**
	 * Displays an information message. <br>
	 * <b>Format:</b> <code>[INFO] &lt;message&gt;</code>
	 * 
	 * @param		message Message to be displayed
	 */
	public static void writeInfo(Object message) {
		out.writeInfo(message);
	}
	
	/**
	 * Displays a debug message. <br>
	 * <b>Format:</b> <code>[DEBUG] &lt;message&gt;</code>
	 * 
	 * @param		message Message to be displayed
	 */
	public static void writeDebug(Object message) {
		out.writeDebug(message);
	}

	/**
	 * Clears the history of messages sent to the console. 
	 */
	public static void clearHistory() {
		out.clearHistory();
	}
	
	/**
	 * Exports the history of messages sent to the console to a file.
	 *  
	 * @param		directoryPath Output directory
	 */
	public static void dumpTo(Path directoryPath) {
		out.dumpTo(directoryPath);
	}

	
	//-------------------------------------------------------------------------
	//		Getters & Setters
	//-------------------------------------------------------------------------
	/**
	 * Gets messages sent to the console. 
	 * 
	 * @return		List of messages
	 */
	public static List<String> getHistory() {
		return out.getHistory();
	}
	
	/**
	 * Defines the distance between messages and the log level tag.
	 * 
	 * @param		margin Margin left
	 */
	public static void setMarginLeft(int margin) {
		out.setMarginLeft(margin);
	}
	
	/**
	 * Sets log level. The level defines what type of message will be 
	 * displayed.
	 * 
	 * @param		level New log level
	 */
	public static void setLoggerLevel(LogLevel level) {
		out.setLoggerLevel(level);
	}

	/**
	 * Gets current log level. The level defines what type of message will be 
	 * displayed.
	 * 
	 * @return		Current log level
	 */
	public static LogLevel getLoggerLevel() {
		return out.getLoggerLevel();
	}
}
