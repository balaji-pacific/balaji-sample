/**
 * 
 */
package org.sample.project.balaji_sample;

import java.io.File;
import java.util.concurrent.Executors;

import jodd.io.StreamGobbler;

/**
 * @author Balaji
 *
 */
public class PB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String homeDirectory = System.getProperty("user.home");
		boolean isWindows = true;
		ProcessBuilder builder = new ProcessBuilder();
		if (isWindows) {
		    builder.command("cmd.exe", "/c", "dir");
		} else {
		    builder.command("sh", "-c", "ls");
		}
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), "OUTPUT");
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}

}
