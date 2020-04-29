package org.sample.project.balaji_sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cmdtest {
    public static void main(String[] args) {
        try {
            String[] command = new String[3];
            command[0] = "cmd";
            command[1] = "/c";
            command[2] = "f: && dir && cd snap";

            Process p = Runtime.getRuntime().exec(command);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}