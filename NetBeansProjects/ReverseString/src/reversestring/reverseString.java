/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;

/**
 *
 * @author Serge Jabo Byusa
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class reverseString {
	public static void main (String args[]) throws IOException{
		
		int i=0,j=0;
		BufferedWriter bw=null;
		BufferedReader br=null;
		try{
			File in  = new File("/home/serge/NetBeansProjects/ReverseString/src/reversestring/in.txt"); 
			File out = new File("/home/serge/NetBeansProjects/ReverseString/src/reversestring/out.txt");
			br = new BufferedReader(new FileReader(in));
			bw = new BufferedWriter(new FileWriter(out));
			String readLine = " ";
			while((readLine=br.readLine())!=null){
				String[] split = readLine.split(" ");
				String result = "";
				for (i = split.length - 1; i >= 0; i--) {
				  result += (split[i] + " ");
				}
				//System.out.println(result.trim());

				if(j==0){
					String nothing= "nothing happens";
				}else{
					bw.write("Case #"+j+": "+result.trim()+"\n");
				}
				j++;

			}
			
        } catch (IOException e) {
        	e.printStackTrace();
			System.out.println(e);
		}
		finally{
			try{
				if(bw!=null)
					bw.close();
					br.close();
			}catch (IOException ex){
				ex.printStackTrace();
			}
		}
	}
		
	
}









