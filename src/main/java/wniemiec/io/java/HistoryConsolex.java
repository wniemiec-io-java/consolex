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
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for managing console history.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
class HistoryConsolex {
	
	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private static final int BUFFER_SIZE = 80000;
	private List<String> buffer;
	
	
	//-------------------------------------------------------------------------
	//		Constructor
	//-------------------------------------------------------------------------
	HistoryConsolex() {
		buffer = new ArrayList<>();
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	void add(String content) {
		if (buffer.size() == BUFFER_SIZE)
			freeBuffer();
		
		buffer.add(content);
		
	}
	
	void freeBuffer() {
		buffer = new ArrayList<>();
	}
	
	void clear() {
		buffer.clear();
	}
	
	void dumpTo(Path output) {
		try {
			Files.write(output, buffer);
		} 
		catch (IOException e) {
			// If dump fails, there is nothing to be done.
		}
	}
	
	
	//-------------------------------------------------------------------------
	//		Getters
	//-------------------------------------------------------------------------
	List<String> getHistory() {
		return buffer;
	}
}
