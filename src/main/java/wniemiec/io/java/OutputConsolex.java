/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Responsible for console output.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
class OutputConsolex {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private static final int MARGIN_LEFT = 5;
	private static final int DIV_WIDTH = 80;
	private static final String DIV_SYMBOL = "-";
	private HistoryConsolex history;
	private LoggerConsolex logger;
	private int marginLeft;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	public OutputConsolex() {
		marginLeft = 0;
		history = new HistoryConsolex();
		logger = new LoggerConsolex(history);
	}

	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	public void writeLine(Object line) {
		final String finalString = addMargin(line.toString());
		
		System.out.println(finalString);
		history.add(finalString);
	}

	private String addMargin(String line) {
		return buildMargin(marginLeft) + line;
	}

	static String buildMargin(int width) {
		StringBuilder div = new StringBuilder();
		
		for (int i = 0; i < width; i++)
			div.append(" ");
		
		return div.toString();
	}
	
	public void writeLines(Object... lines) {
		for (Object line : lines)
			writeLine(line);
	}

	public void writeLines(List<String> lines) {
		for (Object line : lines)
			writeLine(line);
	}

	public void write(Object obj) {
		final String finalString = addMargin(obj.toString());
		
		System.out.print(finalString);
		history.add(finalString);
	}

	public void writeFileLines(Path testFile) throws IOException {
		List<String> fileContent = Files.readAllLines(normalize(testFile));
		
		for (String line : fileContent) {
			writeLine(line);
		}
	}

	private Path normalize(Path file) {
		return file.normalize().toAbsolutePath();
	}

	public void writeFileLinesWithEnumeration(Path testFile) throws IOException {
		List<String> fileContent = Files.readAllLines(normalize(testFile));
		
		for (int i = 0; i < fileContent.size(); i++) {
			writeLineWithEnumeration(fileContent.get(i), i+1);
		}
	}

	private void writeLineWithEnumeration(String line, int lineNumber) {
		System.out.printf("%-" + MARGIN_LEFT + "d\t%s\n", lineNumber, line);
		history.add(line);
	}

	public void writeDiv() {
		writeDiv(DIV_SYMBOL);
	}
	
	public void writeDiv(String symbol) {
		writeLine(buildDiv(symbol));
	}
	
	static String buildDiv(String symbol) {
		StringBuilder div = new StringBuilder();
		
		for (int i = 0; i < DIV_WIDTH; i++)
			div.append(symbol);
		
		return div.toString();
	}

	public void writeHeader(Object line) {
		writeHeader(line, DIV_SYMBOL);
	}

	public void writeHeader(Object line, String symbol) {
		writeDiv(symbol);
		writeTitle(line.toString());
		writeDiv(symbol);
	}
	
	private void writeTitle(String title) {
		writeLine(buildTitle(title));
	}
	
	static String buildTitle(String title) {
		int titleLen = title.length();
		int width = 80;
		int center = width/2 - titleLen/2;
		
		return buildSpaces(center) + title;
	}

	static String buildSpaces(int amount) {
		StringBuilder spaces = new StringBuilder();
		
		for (int i=0; i<amount; i++)
			spaces.append(" ");
		
		return spaces.toString();
	}

	public void writeError(Object message) {
		logger.writeError(message.toString());
	}
	
	public void writeWarning(Object message) {
		logger.writeWarning(message.toString());
	}
	
	public void writeInfo(Object message) {
		logger.writeInfo(message.toString());
	}
	
	public void writeDebug(Object message) {
		logger.writeDebug(message.toString());
	}
	
	public void clearHistory() {
		history.clear();
	}
	
	public void dumpTo(Path output) {
		history.dumpTo(output);
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters & Setters
	//-------------------------------------------------------------------------
	public void setLoggerLevel(LogLevel level) {
		logger.setLevel(level);
	}

	public LogLevel getLoggerLevel() {
		return logger.getLoggerLevel();
	}
	
	public void setMarginLeft(int margin) {
		marginLeft = margin;
	}

	public List<String> getHistory() {
		return history.getHistory();
	}
	
	static String getDefaultDivSymbol() {
		return DIV_SYMBOL;
	}
}
