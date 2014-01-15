import java.net.*;
import java.io.*;
//Sql.java -- sample program to read a database 
import java.sql.*;

public class Main {
	
	
	public static void readUniversityList(String state) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost", "", "");
        
        String sURL2;
        sURL2="http://www.ratemyprofessors.com/SelectSchool.jsp?country=0&stateselect="+state;
        URL oracle2 = new URL(sURL2);
        BufferedReader in2 = new BufferedReader(
        new InputStreamReader(oracle2.openStream()));
        
        String inputLine = in2.readLine();

        PrintStream out2 = new PrintStream(new FileOutputStream("output2.txt"));
        System.setOut(out2);

        String s1 = "ratemycampusA.jsp";
        String r1="",r2="",sSQL2="";
       
        while ((inputLine = in2.readLine()) != null){
            
            if (inputLine.contains(s1)){
                inputLine = inputLine.trim();
                r2 = inputLine.substring(31,inputLine.indexOf('&', 31));
                out2.println(r2);
            }
            
            if (inputLine.contains(s1)){
                inputLine = inputLine.trim();
                r1 = inputLine.substring(inputLine.indexOf("&sname=")+7,
                        inputLine.indexOf("</a>")-2) ;
                r1 = r1.replaceAll("'", "");
                out2.println(r1);
                sSQL2 = "INSERT INTO universities(univid, univname,univstate) VALUES("+r2+",'"+r1+"','"+state+"');";  
                out2.println(sSQL2);
                stmt = con.prepareStatement(sSQL2);
                stmt.executeUpdate();
                
            }
        }
        
        out2.close();
        in2.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                   stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                   con.close();                    
                } catch (SQLException ex) {
                }
            }
        }
    
    }
	

	

	public static void readUniversity(int univId, int pageNum) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost", "", "");
        
        String sURL;
        sURL="http://www.ratemyprofessors.com/SelectTeacher.jsp?the_dept=All&sid="+univId+"&orderby=TNumRatings&toggel=true&pageNo="+pageNum;
        URL oracle = new URL(sURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        
        String s1 = "<div class=\"profDept\">";
        String s2 = "<div class=\"profRatings\">";
        String s3 = "<div class=\"profAvg\">";
        String s4 = "<div class=\"profEasy\">";
        String s5 = "<div class=\"profName\">";
        String r1="",r2="",r3="",r4="",r5="",sSQL="";
       
        while ((inputLine = in.readLine()) != null){
            if (inputLine.contains(s1)){
                inputLine = inputLine.trim();
                r1 = inputLine.substring(22,inputLine.length()-6);
                out.println(r1);
            }
            
            if (inputLine.contains(s2)){
                inputLine = inputLine.trim();
                r2 = inputLine.substring(25,inputLine.length()-6);
                out.println(r2);
            }
            
            if (inputLine.contains(s3)){
                inputLine = inputLine.trim();
                r3 = inputLine.substring(21,inputLine.length()-6);
                out.println(r3);
            }
            
            if (inputLine.contains(s5)){
                inputLine = inputLine.trim();
                r5 = inputLine.substring(51,inputLine.indexOf('"', 51));
                out.println(r5);
            }
            
            if (inputLine.contains(s4)){
                inputLine = inputLine.trim();
                r4 = inputLine.substring(22,inputLine.length()-6);
                out.println(r4);
                sSQL = "call InsertUpdateRatings("+univId+",'"+r1+"',"+r2+","+r3+","+r4+","+r5+"); ";
                out.println(sSQL);
                stmt = con.prepareStatement(sSQL);
                stmt.executeUpdate();
            } 
        }
        
        out.close();
        in.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                   stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                   con.close();                    
                } catch (SQLException ex) {
                }
            }
        }    
    }
	
	
	public static void readProfessor(int profId, int pageNum) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost", "", "");
        
        String sURL;
        sURL="http://www.ratemyprofessors.com/ShowRatings.jsp?tid="+profId+"&pageNo="+pageNum;
        URL oracle = new URL(sURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        
        PrintStream out = new PrintStream(new FileOutputStream("output3.txt"));
        System.setOut(out);
        
        // NEED: univid, profDept, Class, Easiness, Helpfulness, Clarity, RaterInterest
        String s1 = "<li>School: ";  // univid
        String s2 = "<li>Department: "; // profDept
        String s3 = "word-wrap:break-word;"; // Class
        String s4 = "<strong>Easiness</strong>"; // Easiness
        String s5 = "<strong>Helpfulness</strong>"; // Helpfulness
        String s6 = "<strong>Clarity</strong>"; // Clarity
        String s7 = "<strong>Rater Interest</strong>"; // RaterInterest
        //String s8 = "<div class=\"date\">"; // userDate
        
        String r1="",r2="",r3="",r4="",r5="",r6="",r7="",sSQL="";
       
        while ((inputLine = in.readLine()) != null){
            if (inputLine.contains(s1)){
                inputLine = inputLine.trim();
                r1 = inputLine.substring(51,inputLine.indexOf('"', 51));
                out.println(r1);
            }
            
            if (inputLine.contains(s2)){
                inputLine = inputLine.trim();
                r2 = inputLine.substring(61,inputLine.indexOf('&', 61));
                out.println(r2);
            }
            
            if (inputLine.contains(s3)){
                inputLine = inputLine.trim();
                r3 = inputLine.substring(52,inputLine.length()-4);
                out.println(r3);
            }
            
            if (inputLine.contains(s4)){
                inputLine = inputLine.trim();
                r4 = inputLine.substring(56,57);
                out.println(r4);
            }
            
            if (inputLine.contains(s5)){
                inputLine = inputLine.trim();
                r5 = inputLine.substring(62,63);
                out.println(r5);
            }
            
            if (inputLine.contains(s6)){
                inputLine = inputLine.trim();
                r6 = inputLine.substring(58,59);
                out.println(r6);
            }
            
           /* if (inputLine.contains(s8)){
                inputLine = inputLine.trim();
                r8 = inputLine.substring(18,inputLine.length()-6);
                out.println(r8);
            }   */
            
            if (inputLine.contains(s7)){
                inputLine = inputLine.trim();
                r7 = inputLine.substring(66,67);
                out.println(r7);
                sSQL = "call InsertUpdateProfessors("+profId+","+r1+",'"+r2+"','"+r3+"',"+r4+","+r5+","+r6+","+r7+"); ";
                out.println(sSQL);
                stmt = con.prepareStatement(sSQL);
                stmt.executeUpdate();
            } 
        }
        
        out.close();
        in.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                   stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                   con.close();                    
                } catch (SQLException ex) {
                }
            }
        }    
    }
	
	

	public static int UniversityLast(int univid) throws IOException {

        String sURL;
        sURL="http://www.ratemyprofessors.com/SelectTeacher.jsp?sid="+univid;
        URL oracle = new URL(sURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        
        PrintStream out = new PrintStream(new FileOutputStream("output5.txt"));
        System.setOut(out);
        
      
        String lastNum="";
        String strLast = "id=\"last\"";
        while ((inputLine = in.readLine()) != null){
        if (inputLine.contains(strLast)){
        	out.println(inputLine);
            inputLine = inputLine.trim();
            lastNum = inputLine.substring(inputLine.indexOf("pageNo=")+7,
            		inputLine.indexOf('"', inputLine.indexOf("pageNo=")+7));
            out.println(lastNum);
        }
        }

        int intLast = Integer.parseInt(lastNum);
        out.println(intLast);

        out.close();
		return intLast;   
    }

    
	
	public static int ProfessorLast(int profId) throws IOException {

        String sURL;
        sURL="http://www.ratemyprofessors.com/ShowRatings.jsp?tid="+profId;
        URL oracle = new URL(sURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine = in.readLine();
        
        PrintStream out = new PrintStream(new FileOutputStream("output4.txt"));
        System.setOut(out);
        
      
        String lastNum="";
        String strLast = "id=\"last\"";
        while ((inputLine = in.readLine()) != null){
        if (inputLine.contains(strLast)){
        	out.println(inputLine);
            inputLine = inputLine.trim();
            lastNum = inputLine.substring(inputLine.indexOf("pageNo=")+7,
            		inputLine.indexOf('"', inputLine.indexOf("pageNo=")+7));
            out.println(lastNum);
        }
        }

        int intLast = Integer.parseInt(lastNum);
        out.println(intLast);

        out.close();
		return intLast;   
    }
    
	
	
	public static void CallUniversity() throws SQLException {

	    Statement stmt=null;
	    Connection con=null;
	        
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost", "", "");
	        
	        String query = "select univid from universities where univid=825 or univid=1072 or univid=1073 or univid=1222;";
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        int pages;
	        
	        
	        while (rs.next()) {
	        	
	            int university= rs.getInt("univid");
	            //System.out.println(university);
	            int total = UniversityLast(university);
	            
	            // university pages
	            for(pages=1;pages<total;pages++)
	            {
	            	readUniversity(university,pages);
	            	Thread.sleep(1000);
	            }	        
	            
	        }
	        
	        
	    } catch (Exception e) { 
	        e.printStackTrace();
	      } finally {
	          if (stmt != null) {
	             try {
	                stmt.close();
	             } catch (SQLException ex) {
	               }
	          }
	          if (con != null) {
	             try {
	                con.close();                    
	             } catch (SQLException ex) { 
	          } 
	      } 
	   } 
   	} 
	
	
	public static void CallProfessor() throws SQLException {

	    Statement stmt=null;
	    Connection con=null;
	        
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost", "", "");
	        
	        String query = "select profId from ratings where univid=1222;";
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	       
	        int pages;
	     
	        while (rs.next()) {
	        	
	            int professor= rs.getInt("profId");
	            
	            // professor pages
	            //int total = ProfessorLast(professor);
	           
	            readProfessor(professor,1);
	            
	            /*for(pages=1;pages<total;pages++)
	            {
	            	readProfessor(professor,pages);
	            	Thread.sleep(1000);
	            }*/

	        }
	        
	    } catch (Exception e) { 
	        e.printStackTrace();
	      } finally {
	          if (stmt != null) {
	             try {
	                stmt.close();
	             } catch (SQLException ex) {
	               }
	          }
	          if (con != null) {
	             try {
	                con.close();                    
	             } catch (SQLException ex) { 
	          } 
	      } 
	   } 
   	} 

	// calls other procedures
    public static void main(String[] args) throws Exception {
        //readUniversity(825); // testing Rutgers University, read into universities table
        //readUniversity(1072); // testing UC Berkeley (California), read into universities table
        //readUniversity(1073); // testing UC Davis, read into universities table
        //readUniversity(1222); // testing Yale University, read into universities table
        //readUniversityList("CA"); // reading all universities in California
        //readUniversityList("NJ"); // reading all universities in New Jersey
        //readUniversityList("CT"); // reading all universities in Connecticut
    	//CallUniversity(); // read into ratings table
    	//CallProfessor(); // read into professors table
    	//ProfessorLast(56748); // testing total number of pages for a professor, returns correct result
    	//UniversityLast(825);  // testing total number of pages for a university, returns correct result
    }

}
    
