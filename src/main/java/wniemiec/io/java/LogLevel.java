/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

/**
 * Logging levels.
 * 
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
public enum LogLevel {
	
	//-------------------------------------------------------------------------
	//		Enumerations
	//-------------------------------------------------------------------------
	/**
	 * Disables all messages.
	 */
	OFF(false, false, false, false, "OFF"),
	
	/**
	 * Displays only error messages.
	 */
	ERROR(true, false, false, false, "ERROR"), 
	
	/**
	 * Displays error and warning messages.
	 */
	WARNING(true, true, false, false, "WARN"), 
	
	/**
	 * Displays error, warning and info messages.
	 */
	INFO(true, true, true, false, "INFO"),
	
	/**
	 * Displays error, warning, info and debug messages.
	 */
	DEBUG(true, true, true, true, "DEBUG");
	
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private boolean error;
	private boolean warn;
	private boolean info;
	private boolean debug;
	private String name;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	private LogLevel(boolean error, boolean warn, boolean info, boolean debug, 
					 String name) {
		this.error = error;
		this.warn = warn;
		this.info = info;
		this.debug = debug;
		this.name = name;
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	public boolean shouldDisplayError() {
		return error;
	}
	
	public boolean shouldDisplayWarning() {
		return warn;
	}
	
	public boolean shouldDisplayInfo() {
		return info;
	}
	
	public boolean shouldDisplayDebug() {
		return debug;
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters
	//-------------------------------------------------------------------------
	public String getName() {
		return name;
	}
}
