package classes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBean {

 public static void main(String argv[]) {
	 	  
		System.out.println("PendingTests: ");
		PendingTests a = new PendingTests();	
		PendingTests b = a.getPendingTests();
		a.deletePendingTest();
		
		if(b.getScript() != null) {
		
		try {
			 
			String content = b.getScript();
 
			File file = new File("C:\\Users\\jamesduin\\sahi_prov511\\userdata\\scripts\\"+b.getTestCaseName()+".sah");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done creating test script.");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
			String content = "";
			
			br = new BufferedReader(new FileReader("C:\\Users\\jamesduin\\sahi_prov511\\userdata\\scripts\\updater.sah"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				if(sCurrentLine.contains("spec")) {
				    content = content + "_setValue(_textarea(\"_.spec\"), \"H/2 "+b.getTime()+" * * "+b.getDay()+"\");\n";
				} else {
					content = content + sCurrentLine+"\n";
				}
			}
			
			 
			File file = new File("C:\\Users\\jamesduin\\sahi_prov511\\userdata\\scripts\\updater.sah");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		} else {
			System.out.println("No pending tests.");
		}
		
	}
}