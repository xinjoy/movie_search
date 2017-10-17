package populate;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class populate {

	public static void main(String[] args) {
		populate populateData = new populate();
		populateData.run(args);
	}

	private void run(String[] fileArr) {
        Connection con = null;
        try {
            con = openConnection();
            deleteTables(con);
            for (int i = 0; i < fileArr.length; i++) {
                switch(fileArr[i]) {
                case "movies.dat":
                	populateMovie(con, "resources/movies.dat");
                	break;
                case "movie_genres.dat":
                	populateMovieGenre(con, "resources/movie_genres.dat");
                	break;
                case "movie_countries.dat":
                	populateMovieCountry(con, "resources/movie_countries.dat");
                	break;
                case "movie_locations.dat":
                	populateMovieLocation(con, "resources/movie_locations.dat");
                	break;
                case "tags.dat":
                	populateTag(con, "resources/tags.dat");
                	break;
                case "movie_tags.dat":
                	populateMovieTag(con, "resources/movie_tags.dat");
                	break;
                default:
                	break;
                
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error occurs when populating data: " + e.getMessage());
        } finally {
            closeConnection(con);
        }
    }
	
	private void deleteTables(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		
		String query = "delete from Movies";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		query = "delete from Movie_genres";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		query = "delete from Movie_countries";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		query = "delete from Movie_locations";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		query = "delete from Tags";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		query = "delete from Movie_tags";
		System.out.println(query);
		stmt.executeUpdate(query);
		
	}
  
    private void populateMovie(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String mid = lineData[0];
            String title = lineData[1];
            String year = lineData[5];
            String all_critics_rating = lineData[7];
            String all_critics_num_review = lineData[8];
            String top_critics_rating = lineData[12];
            String top_critics_num_review = lineData[13];
            String audience_rating = lineData[17];
            String audience_num_rating = lineData[18];

            if (title.contains("'")) {
                StringBuilder title_sb = new StringBuilder(title);
                int pos = title.indexOf('\'');
                while (pos >= 0) {
                	title_sb.insert(pos+1, '\'');
                	title = title_sb.toString();
                    pos = title.indexOf('\'', pos+2);
                }
            }

            if (all_critics_rating.equals("\\N")) {
                all_critics_rating = "NULL";
            }

            if (all_critics_num_review.equals("\\N")) {
                all_critics_num_review = "NULL";
            }

            if (top_critics_rating.equals("\\N")) {
                top_critics_rating = "NULL";
            }

            if (top_critics_num_review.equals("\\N")) {
                top_critics_num_review = "NULL";
            }

            if (audience_rating.equals("\\N")) {
                audience_rating = "NULL";
            }

            if (audience_num_rating.equals("\\N")) {
            	audience_num_rating = "NULL";
            }


            String query = "insert into Movies values (" + mid +  ", '" + title + "', " + year + ", " + 
                            all_critics_rating + ", " + all_critics_num_review + ", " + top_critics_rating + "," + 
                            top_critics_num_review + "," + audience_rating + "," + audience_num_rating + ")";
            System.out.println(query);
            stmt.executeUpdate(query); 
        }
       
        stmt.close();   
        br.close();       
    }
    
    private void populateMovieGenre(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String mid = lineData[0];
            String genres = "";
            if (lineData.length > 1) {
            	genres = lineData[1];
            }
            
            String query = "";
            if (genres.length() == 0) {
            	query = "insert into Movie_genres values (" + mid +  ", NULL)";
            } 
            else {
            	query = "insert into Movie_genres values (" + mid +  ", '" + genres + "')";
            }
            
            System.out.println(query);
            stmt.executeUpdate(query); 
        }
       
        stmt.close();   
        br.close();       
    }
    
    private void populateMovieCountry(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String mid = lineData[0];
            String country = "";
            if (lineData.length > 1) {
            	country = lineData[1];
            }
            
            String query = "";
            if (country.length() == 0) {
            	query = "insert into Movie_countries values (" + mid +  ", NULL)";
            } 
            else {
            	query = "insert into Movie_countries values (" + mid +  ", '" + country + "')";
            }
            
            System.out.println(query);
            stmt.executeUpdate(query); 
            
        }
       
        stmt.close();   
        br.close();       
    }
    
    private void populateMovieLocation(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String mid = lineData[0];
            String location = "";
            if (lineData.length > 1) {
            	location = lineData[1];
            }
            String query = "";
            if (location.length() == 0) {
            	query = "insert into Movie_locations values (" + mid +  ", NULL)";
            } 
            else {
            	query = "insert into Movie_locations values (" + mid +  ", '" + location + "')";
            }
            
            System.out.println(query);
            stmt.executeUpdate(query); 
            
        }
       
        stmt.close();   
        br.close();       
    }
    
    private void populateTag(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String id = lineData[0];
            String tag = lineData[1];
            
            String query = "";
            if (tag.length() == 0) {
            	query = "insert into Tags values (" + id +  ", NULL)";
            } 
            else {
            	query = "insert into Tags values (" + id +  ", '" + tag + "')";
            }
            
            System.out.println(query);
            stmt.executeUpdate(query); 
        }
       
        stmt.close();   
        br.close();       
    }
    
    private void populateMovieTag(Connection con, String fileName) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";    
        br.readLine();
    
        Statement stmt = con.createStatement();
    
        while ((line = br.readLine()) != null) {
            String[] lineData = line.split("\\t");
            String mid = lineData[0];
            String tid = lineData[1];
            String tagWeight = lineData[2];
            
            String query = "";
            if (tagWeight.length() == 0) {
            	query = "insert into Movie_tags values (" + mid +  ", " + tid + ", NULL)";
            } 
            else {
            	query = "insert into Movie_tags values (" + mid +  ", " + tid + ", " + tagWeight + ")";
            }
            
            System.out.println(query);
            stmt.executeUpdate(query); 
        }
       
        stmt.close();   
        br.close();       
    }
    
    private Connection openConnection() throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        String host = "localhost";
        String port = "1521";
        String dbName = "ORCL";
        String userName = "xinxin";
        String password = "xinxin";
            
        String dbURL = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + dbName;
        return DriverManager.getConnection(dbURL, userName, password);
    }
	
	private void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
	}

}
