package wniemiec.io.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsolexTest {
	
	//-------------------------------------------------------------------------
	//		Test hooks
	//-------------------------------------------------------------------------
	@BeforeEach
	void prepare() {
		Consolex.clearHistory();
		Consolex.setLoggerLevel(LogLevel.OFF);
	}
	
	
	//-------------------------------------------------------------------------
	//		Tests
	//-------------------------------------------------------------------------
	@Test
	void testWriteLine() {
		String line = "hello world";
		Consolex.writeLine(line);
		
		assertConsoleOutputIs("hello world");
	}
	
	@Test
	void testWriteLines() {
		List<String> lines = List.of("hello", "world");
		Consolex.writeLines(lines);
		
		assertConsoleOutputIs("hello", "world");
	}
	
	@Test
	void testWrite() {
		Object foo = new Object() {
			@Override
			public String toString() { return "bar"; }
		};
		
		Consolex.write(foo);
		assertConsoleOutputIs("bar");
	}

	@Test
	void testWriteFileLines() throws IOException {
		Path testFile = Path.of(".", "src", "test", "resources", "auxfiles", "code-example.txt");
		Consolex.writeFileLines(testFile);
		
		assertConsoleOutputIsEqualsToFileContent(testFile);
	}

	@Test
	void testWriteFileLinesWithEnumeration() throws IOException {
		Path testFile = Path.of(".", "src", "test", "resources", "auxfiles", "code-example.txt");
		Consolex.writeFileLinesWithEnumeration(testFile);
		
		assertConsoleOutputIsEqualsToFileContent(testFile);
	}
	
	@Test
	void testWriteDiv() {
		Consolex.writeDiv();
		assertConsoleOutputIs(OutputConsolex.buildDiv(OutputConsolex.getDefaultDivSymbol()));
	}
	
	@Test
	void testWriteDivSpecified() {
		String symbol = "@";
		
		Consolex.writeDiv(symbol);
		assertConsoleOutputIs(OutputConsolex.buildDiv(symbol));
	}
	
	@Test
	void testWriteHeader() {
		String line = "hello world";
		Consolex.writeHeader(line);
		
		assertConsoleOutputIs(
				OutputConsolex.buildDiv(OutputConsolex.getDefaultDivSymbol()),
				OutputConsolex.buildTitle("hello world"),
				OutputConsolex.buildDiv(OutputConsolex.getDefaultDivSymbol())
		);
	}
	
	@Test
	void testWriteHeaderWithSpecifiedDiv() {
		String line = "hello world";
		String symbol = "@";
		Consolex.writeHeader(line, symbol);
		
		assertConsoleOutputIs(
				OutputConsolex.buildDiv(symbol),
				OutputConsolex.buildTitle("hello world"),
				OutputConsolex.buildDiv(symbol)
		);
	}
	
	@Test
	void testError() {
		String msg = "error message";
		
		Consolex.setLoggerLevel(LogLevel.ERROR);
		Consolex.writeError(msg);
		
		assertConsoleOutputIs(
				msg
		);
	}

	@Test
	void testWarning() {
		String msg = "warn message";
		
		Consolex.setLoggerLevel(LogLevel.WARNING);
		Consolex.writeWarning(msg);
		
		assertConsoleOutputIs(
				msg
		);
	}
	
	@Test
	void testInfo() {
		String msg = "info message";
		
		Consolex.setLoggerLevel(LogLevel.INFO);
		Consolex.writeInfo(msg);
		
		assertConsoleOutputIs(
				msg
		);
	}
	
	@Test
	void testDebug() {
		String msg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.DEBUG);
		Consolex.writeDebug(msg);
		
		assertConsoleOutputIs(
				msg
		);
	}
	
	@Test
	void testSetLogLevelAsOff() {
		String errorMsg = "error message";
		String warnMsg = "warning message";
		String infoMsg = "info message";
		String debugMsg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.OFF);
		Consolex.writeError(errorMsg);
		Consolex.writeWarning(warnMsg);
		Consolex.writeInfo(infoMsg);
		Consolex.writeDebug(debugMsg);
		
		assertConsoleOutputIsEmpty();
	}
	
	@Test
	void testSetLogLevelAsError() {
		String errorMsg = "error message";
		String warnMsg = "warning message";
		String infoMsg = "info message";
		String debugMsg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.ERROR);
		Consolex.writeError(errorMsg);
		Consolex.writeWarning(warnMsg);
		Consolex.writeInfo(infoMsg);
		Consolex.writeDebug(debugMsg);
		
		assertConsoleOutputIs(errorMsg);
	}
	
	@Test
	void testSetLogLevelAsWarning() {
		String errorMsg = "error message";
		String warnMsg = "warning message";
		String infoMsg = "info message";
		String debugMsg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.WARNING);
		Consolex.writeError(errorMsg);
		Consolex.writeWarning(warnMsg);
		Consolex.writeInfo(infoMsg);
		Consolex.writeDebug(debugMsg);
		
		assertConsoleOutputIs(errorMsg, warnMsg);
	}
	
	@Test
	void testSetLogLevelAsInfo() {
		String errorMsg = "error message";
		String warnMsg = "warning message";
		String infoMsg = "info message";
		String debugMsg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.INFO);
		Consolex.writeError(errorMsg);
		Consolex.writeWarning(warnMsg);
		Consolex.writeInfo(infoMsg);
		Consolex.writeDebug(debugMsg);
		
		assertConsoleOutputIs(errorMsg, warnMsg, infoMsg);
	}
	
	@Test
	void testSetLogLevelAsDebug() {
		String errorMsg = "error message";
		String warnMsg = "warning message";
		String infoMsg = "info message";
		String debugMsg = "debug message";
		
		Consolex.setLoggerLevel(LogLevel.DEBUG);
		Consolex.writeError(errorMsg);
		Consolex.writeWarning(warnMsg);
		Consolex.writeInfo(infoMsg);
		Consolex.writeDebug(debugMsg);
		
		assertConsoleOutputIs(errorMsg, warnMsg, infoMsg, debugMsg);
	}

	@Test
	void testClearHistory() {
		String msg1 = "message1";
		String msg2 = "message2";
		
		Consolex.writeLine(msg1);
		Consolex.writeLine(msg2);
		assertConsoleOutputIs(msg1, msg2);
		Consolex.clearHistory();
		assertConsoleOutputIsEmpty();
	}
	
	@Test
	void testNewLine() {
		Consolex.writeLine("");
		assertConsoleOutputIs("");
	}
	
	@Test
	void testMarginLeft() {
		String msg = "some message";
		int margin = 5;
		
		Consolex.writeLine(msg);
		assertConsoleOutputIs(msg);
		
		Consolex.clearHistory();
		Consolex.setMarginLeft(margin);
		Consolex.writeLine(msg);
		assertConsoleOutputIs(OutputConsolex.buildMargin(margin) + msg);
		
		Consolex.clearHistory();
		Consolex.setMarginLeft(0);
		Consolex.writeLine(msg);
		assertConsoleOutputIs(msg);
	}
	
	
	//-------------------------------------------------------------------------
	//		Methods
	//-------------------------------------------------------------------------
	private void assertConsoleOutputIsEqualsToFileContent(Path file) 
			throws IOException {
		assertConsoleOutputIs(Files.readAllLines(file));
	}
	
	private void assertConsoleOutputIs(String... lines) {
		List<String> listOfLines = new ArrayList<>();
		
		for (String line : lines) {
			listOfLines.add(line);
		}
		
		assertConsoleOutputIs(listOfLines);
	}
	
	private void assertConsoleOutputIs(List<String> lines) {
		List<String> consoleOutput = Consolex.getHistory();
		
		assertHasSameNumberOfLines(lines, consoleOutput);
		assertHasSameLines(lines, consoleOutput);
	}
	
	private void assertHasSameNumberOfLines(List<String> expected, List<String> obtained) {
		if (expected.size() != obtained.size()) {
			Assertions.fail("Console buffer does not have the same number of " + 
							"lines as the expected lines. Expected: " + 
							expected.size() + "; Obtained: " + obtained.size());
		}
	}
	
	private void assertHasSameLines(List<String> expected, List<String> obtained) {
		for (int i = 0; i < obtained.size(); i++) {
			Assertions.assertEquals(
					normalizeLine(expected.get(i)), 
					normalizeLine(obtained.get(i))
			);			
		}
	}
	
	private String normalizeLine(String line) {
		return line.trim();
	}
	
	private void assertConsoleOutputIsEmpty() {
		Assertions.assertTrue(Consolex.getHistory().isEmpty());
	}
}
