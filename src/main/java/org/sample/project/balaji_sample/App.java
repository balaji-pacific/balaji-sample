package org.sample.project.balaji_sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        System.out.println( "Hello World!" );
        
        String[] command = new String[10];
        command[0] = "cmd";
        command[1] = "/c";
        command[2] = "F:";
        command[3] = "cd F:\\MyWork\\workspace\\CoreJavaConcep\\balaji-sample";
        command[4] = "echo \"# balaji-sample\" >> README.md";
        command[5] = "git init";
		command[6] = "git add README.md"; 
		command[7] = "git commit -m \"first commit\""; 
		command[8] = "git remote add origin git@github.com:balaji-pacific/balaji-sample.git";
		command[9] = "git push -u origin master";
		 
        try {
			Process p = Runtime.getRuntime().exec(command);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String Error;
            while ((Error = stdError.readLine()) != null) {
                System.out.println(Error);
            }
            while ((Error = stdInput.readLine()) != null) {
                System.out.println(Error);
            }
            
        	System.out.println(p.exitValue());
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
