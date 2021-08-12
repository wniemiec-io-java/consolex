![](https://github.com/wniemiec-io-java/consolex/blob/master/docs/img/logo/logo.jpg)

<h1 align='center'>Consolex</h1>
<p align='center'>Facilitator of reading and writing on the console.</p>
<p align="center">
	<a href="https://github.com/wniemiec-io-java/consolex/actions/workflows/windows.yml"><img src="https://github.com/wniemiec-io-java/consolex/actions/workflows/windows.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/consolex/actions/workflows/macos.yml"><img src="https://github.com/wniemiec-io-java/consolex/actions/workflows/macos.yml/badge.svg" alt=""></a>
	<a href="https://github.com/wniemiec-io-java/consolex/actions/workflows/ubuntu.yml"><img src="https://github.com/wniemiec-io-java/consolex/actions/workflows/ubuntu.yml/badge.svg" alt=""></a>
	<a href="https://codecov.io/gh/wniemiec-io-java/consolex"><img src="https://codecov.io/gh/wniemiec-io-java/consolex/branch/master/graph/badge.svg?token=R2SFS4SP86" alt="Coverage status"></a>
	<a href="http://java.oracle.com"><img src="https://img.shields.io/badge/java-11+-D0008F.svg" alt="Java compatibility"></a>
	<a href="https://mvnrepository.com/artifact/io.github.wniemiec-io-java/consolex"><img src="https://img.shields.io/maven-central/v/io.github.wniemiec-io-java/consolex" alt="Maven Central release"></a>
	<a href="https://github.com/wniemiec-io-java/consolex/blob/master/LICENSE"><img src="https://img.shields.io/github/license/wniemiec-io-java/consolex" alt="License"></a>
</p>
<hr />

## ❇ Introduction
Complete and easy-to-use console, featuring logging, read and write operations on the console, as well as text file display operations.

## ❓ How to use
1. Add one of the options below to the pom.xml file: 

#### Using Maven Central (recomended):
```
<dependency>
  <groupId>io.github.wniemiec-io-java</groupId>
  <artifactId>consolex</artifactId>
  <version>LATEST</version>
</dependency>
```

#### Using GitHub Packages:
```
<dependency>
  <groupId>wniemiec.io.java</groupId>
  <artifactId>consolex</artifactId>
  <version>LATEST</version>
</dependency>
```

2. Run
```
$ mvn install
```

3. Use it
```
[...]

import wniemiec.io.java.Consolex;

[...]

String line = "hello world";
Consolex.writeHeader(line);

Consolex.writeLine("Simple console message");

Consolex.writeError("Error message");
Consolex.writeWarning("Warning message");
Consolex.writeInfo("Info message");
Consolex.writeDebug("Debug message");

System.out.println( Consolex.getHistory() );

[...]
```

## 📖 Documentation
|        Property        |Parameter type|Return type|Description|Default parameter value|
|----------------|-------------------------------|-----|------------------------|--------|
|readLine |`void`|`String`|Reads a line from console| - |
|writeLine |`line: Object`|`void`|Write a line on the console, putting a line break at the end| - |
|writeLines |`lines: (Object... | List<String>)`|`void`|Write lines on the console, putting a line break at the end of each line| - |
|write |`content: Object`|`void`|Writes a content on the console without putting a line break at the end of each line| - |
|writeFileLines | `file: Path`|`void`|Write lines from a text file to the console| - |
|writeFileLinesWithEnumeration | `file: Path`|`void`|Write lines from a text file to the console. Besides, it shows the line number of each line on the left| - |
|writeDiv | `symbol: String`|`void`|Writes a division line| `"-"` |
|writeHeader | `title: Object, symbol: String`|`void`|Writes a title between two dividers| - , `"-"`|
|writeError | `message: Object`|`void`|Displays an error message.| - |
|writeWarning | `message: Object`|`void`|Displays a warning message.| - |
|writeInfo | `message: Object`|`void`|Displays an info message. - |
|writeDebug | `message: Object`|`void`|Displays a debug message.| - |
|clearHistory | `void`|`void`|Clears the history of messages sent to the console| - |
|dumpTo | `file: Path`|`void`|Exports the history of messages sent to the console to a file| - |
|getHistory | `void`|`List<String>`|Gets messages sent to the console| - |
|setMarginLeft | `margin: int`|`void`|Defines the distance between messages and the log level tag| - |
|setLoggerLevel | `level: LogLevel`|`void`|Sets log level. The level defines what type of message will be displayed| - |
|getLoggerLevel | `void`|`LogLevel`|Gets current log level. The level defines what type of message will be displayed| - |


## 🚩 Changelog
Details about each version are documented in the [releases section](https://github.com/williamniemiec/wniemiec-io-java/consolex/releases).

## 🤝 Contribute!
See the documentation on how you can contribute to the project [here](https://github.com/wniemiec-io-java/consolex/blob/master/CONTRIBUTING.md).

## 📁 Files

### /
|        Name        |Type|Description|
|----------------|-------------------------------|-----------------------------|
|dist |`Directory`|Released versions|
|docs |`Directory`|Documentation files|
|src     |`Directory`| Source files|
