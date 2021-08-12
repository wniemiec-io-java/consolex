/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.nio.file.Path;

/**
 * Responsible for displaying log messages on the console.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
class LoggerConsolex {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private HistoryConsolex history;
	private LogLevel level;
	private LogMessage logMessage;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	public LoggerConsolex(HistoryConsolex history) {
		this.history = history;
		level = LogLevel.INFO;
		logMessage = new LogMessage();
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	public void writeError(String message) {
		if (message == null)
			throw new IllegalArgumentException("Message cannot be null");
		
		if (!level.shouldDisplayError())
			return;
		
		logMessage.log("ERROR", message);
		history.add(message);
	}
	
	public void writeWarning(String message) {
		if (message == null)
			throw new IllegalArgumentException("Message cannot be null");
		
		if (!level.shouldDisplayWarning())
			return;
		
		logMessage.log("WARN", message);
		history.add(message);
	}
	
	public void writeInfo(String message) {
		if (message == null)
			throw new IllegalArgumentException("Message cannot be null");
		
		if (!level.shouldDisplayInfo())
			return;
		
		logMessage.log("INFO", message);
		history.add(message);
	}
	
	public void writeDebug(String message) {
		if (message == null)
			throw new IllegalArgumentException("Message cannot be null");
		
		if (!level.shouldDisplayDebug())
			return;
		
		logMessage.log("DEBUG", message);
		history.add(message);
	}
	
	public void writeDebug(Class<?> source, String message) {
		if (source == null)
			throw new IllegalArgumentException("Source class cannot be null");
		
		if (message == null)
			throw new IllegalArgumentException("Message cannot be null");
		
		if (!level.shouldDisplayError())
			return;
		
		writeDebug("{ " + getClassName(source) + " } " + message);
	}
	
	private String getClassName(Class<?> source) {
		String[] terms = source.getName().split("\\.");
		
		return terms[terms.length-1]; 
	}
	
	public void dumpTo(Path output) {
		if (output == null)
			throw new IllegalArgumentException("Output cannot be null");
		
		history.dumpTo(output);
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters & Setters
	//-------------------------------------------------------------------------
	public void setLevel(LogLevel level) {
		if (level == null)
			throw new IllegalArgumentException("Level cannot be null");
		
		this.level = level;
	}

	public LogLevel getLoggerLevel() {
		return level;
	}
}
