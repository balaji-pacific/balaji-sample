/**
 * 
 */
package org.sample.project.balaji_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Balaji
 *
 */
public class GitClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		//String command = "git clone git@github.com:balaji-pacific/datastructure-algorithm.git";
		
		//String[] command = new String[6];
        //command[0] = "echo \"# balaji-sample\" >> README.md";
        //command[1] = "git init";
		//command[2] = "git add README.md"; 
		//command[3] = "git commit -m \"first commit\""; 
		//command[4] = "git remote add origin git@github.com:balaji-pacific/balaji-sample.git";
		//command[5] = "git push -u origin master";
		
		//String[] command = new String[] {"git init"};
		String initCommand = "git init";
		runCommand(initCommand);
		
		String addCommand  = "git add .";
		runCommand(addCommand);
		
		String gitCommit  = "git commit -m \"first commit\"";
		runCommand(gitCommit);
		
		String remoteComamand  = "git remote add origin git@github.com:balaji-pacific/balaji-sample.git";
		runCommand(remoteComamand);
		
		String pushCommand  = "git push -u origin master";
		runCommand(pushCommand);
		
	}

	private static void runCommand(String command) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(command);
		Thread.sleep(2000);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		String text = command + "\n";
		System.out.println(text);
		while((line = input.readLine()) != null) {
			text += line;
			System.out.println("Line : " + text);
		}
	}

}
