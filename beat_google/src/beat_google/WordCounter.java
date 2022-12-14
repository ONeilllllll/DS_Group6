package beat_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }

    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
 
	public int BoyerMoore(String T, String P){
	    	
    	int count = 0;
    	int i = T.indexOf(P);
    	
    	while(i != -1)
    	{
    		count++;
    		T = T.substring(i+P.length());
    		if(T.length() < P.length())
    		{
    			break;
    		}
    		i = T.indexOf(P);
    	}
    	
        return count;
        // Bonus: Implement Boyer-Moore Algorithm     
/*      int i = P.length() -1;
        int j = P.length() -1;  
  			
  		while(i <= T.length()-1)
        {
        	if(T.charAt(i) == P.charAt(j))
        	{
        		if(j == 0)
        		{
        			return i;
        		}
        		else 
        		{
        			i--;
        			j--;
				}
        	}
        	else 
        	{
        		int l = last(T.charAt(i), P);
        		i = i + P.length() - min(j, 1+l);
        		j = P.length() - 1;
			}
        }
        
        return -1;
*/        
    }
	
	public int last(char c, String P){
		// Bonus: Implement last occurence function
		if(P.lastIndexOf(c) == -1)
		{
	        return -1;
		}
		
		int index = P.lastIndexOf(c);
		return index;
	
	}
	
	public int min(int a, int b){
	    if (a < b)
	        return a;
	    else if (b < a)
	        return b;
	    else 
	        return a;
	}
	
	public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
	
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		
		retVal = BoyerMoore(content, keyword);
		
		// 1. calculates appearances of keyword (Bonus: Implement Boyer-Moore Algorithm)
	/*		int indexNow = 0;
		indexNow = BoyerMoore(content, keyword);
		if(indexNow != -1)
		{
			retVal++;
		}
		else
		{
			return retVal;
		}
		
		while(content.substring(indexNow+keyword.length()).length() >= keyword.length())
		{
			if(BoyerMoore(content.substring(indexNow+keyword.length()), keyword) == -1)
			{
				break;
			}
			indexNow = indexNow + keyword.length() + BoyerMoore(content.substring(indexNow+keyword.length()), keyword);
			retVal++;
		}
	*/
		return retVal;
	}
}