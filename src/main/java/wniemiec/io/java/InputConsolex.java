/**
 * Copyright (c) William Niemiec.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package wniemiec.io.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Responsible for console input.
 * 
 * @author		William Niemiec &lt; williamniemiec@hotmail.com &gt;
 */
class InputConsolex {

	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	public String readLine() throws IOException {
		String input = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = br.readLine();
		}
		
		return input;
	}
}
