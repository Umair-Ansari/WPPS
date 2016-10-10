package com.manage_ad.hashim.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.Utility.umair.AdId;
import com.Utility.umair.AreaCityName;
import com.Utility.umair.House;
import com.Utility.umair.UserArea;
import com.Utility.umair.GoogleMap;
import com.create_agent.umair.DbLayer.ConnetDb;

public class AdManagementDb 
{
	public static String PostAd(String price,String far,String type,String land,String details, String longitude, String latitude, String a_id,String u_id, String landtype) throws SQLException
	{ 
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing, pakage : com.manage_ad.DbLayer , Method : PostAd");	
			return result = null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 0);
		String date = sdf.format(c.getTime());
		String query = "INSERT INTO google_map(longitude,latitude)values('"+longitude+"','"+latitude+"')";
		try 
		(
				Statement st = connection.createStatement();
		)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				String query2 = "INSERT INTO ad (price,far,typee,land,date_time,details,u_id,g_id,a_id,land_type)values('"+price+"','"+far+"','"+type+"','"+land+"','"+date+"','"+details+"','"+u_id+"',(SELECT g_id FROM google_map WHERE longitude='"+longitude+"' AND latitude='"+latitude+"'),'"+a_id+"','"+landtype+"')";
				System.out.println(query2);
				try (
						Statement st2 = connection.createStatement();
						)	
				{
					if (st.executeUpdate(query2) > 0) 
					{
						String query3 = "SELECT MAX(p_id) AS p_id FROM ad";
						try (
								
								ResultSet rs3 = st.executeQuery(query3);)
							{
								if (rs3.next())
								{
									result = rs3.getString("p_id");
								}
							}
							catch(Exception e){
									e.printStackTrace();
									System.out.println( e.getMessage()+" : method is not prepared in pakage : com.create_agent.umair.DbLayer");
									return result = null;
							}
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage()+" query2  Method : PostAd not prepared in pakage : com.manage_ad.DbLayer");
					return result = null;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" query  Method : PostAd not prepared in pakage : com.manage_ad.DbLayer");
			return result = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return result;
	}
	public static List<House> viewAd(String type) throws SQLException
	{
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE typee='"+type+"' ORDER BY date_time DESC LIMIT 10";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> viewAdUser(String user,int ad) throws SQLException
	{
		int upper_limit = ad+10;
		
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE u_id='"+user+"' ORDER BY date_time DESC LIMIT "+ad+","+upper_limit+"";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String DeleteAdArea(String id) throws SQLException
	{ 
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return result = null;
		}
		String query = "SELECT g_id FROM ad WHERE p_id='"+id+"'";
		try (
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);)
			{
				if (rs.next())
				{
					String g_id = rs.getString("g_id");
					String query2 = "DELETE FROM google_map WHERE g_id='"+g_id+"'";
					try (
							Statement st2 = connection.createStatement();
							)	
					{
						if (st2.executeUpdate(query2) > 0) 
						{
							String query3 = "DELETE FROM ad WHERE p_id='"+id+"'";
							try (
									Statement st3 = connection.createStatement();
									)	
							{
								if (st.executeUpdate(query3) > 0) 
								{
									return result = "true";
								}
								
							} catch (SQLException e) {
								System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
								return result = null;
							}
						}
						
					} catch (SQLException e) {
						System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
						return result = null;
					}
				}
			}
			catch(Exception e){
					e.printStackTrace();
					System.out.println( e.getMessage()+" : method is not prepared in pakage : com.create_agent.umair.DbLayer");
					return result = null;
			}
		
		
		finally{
			if(connection != null)
				connection.close();
		}
	return result;
	}
	public static List<House> GetUpdateAD(String p_id,String u_id) throws SQLException
	{
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE u_id='"+u_id+"' AND p_id='"+p_id+"' LIMIT 1";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String UpdateAd(String p_id,String price,String far,String type,String land,String details, String longitude, String latitude, String a_id,String u_id,String g_id,String landtype) throws SQLException
	{ 
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.manage_ad.DbLayer , Method : PostAd");	
			return result = null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 0);
		String date = sdf.format(c.getTime());
		String query = "UPDATE google_map SET longitude = '"+longitude+"',latitude = '"+latitude+"' WHERE g_id = '"+g_id+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				String query2 = "UPDATE ad SET price = '"+price+"', far = '"+far+"',typee = '"+type+"',land = '"+land+"', details = '"+details+"', land_type = '"+landtype+"' WHERE p_id =  '"+p_id+"'";
				System.out.println(query2);
				try (
						Statement st2 = connection.createStatement();
						)	
				{
					if (st.executeUpdate(query2) > 0) 
					{
						result = "true";
						return result;
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage()+" query2  Method : PostAd not prepared in pakage : com.manage_ad.DbLayer");
					return result = null;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" query  Method : PostAd not prepared in pakage : com.manage_ad.DbLayer");
			return result = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return result;
	}
	public static String DeleteAd(String id,String user) throws SQLException
	{ 
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return result = null;
		}
		String query = "SELECT g_id FROM ad WHERE p_id='"+id+"' AND u_id='"+user+"'";
		try (
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);)
			{
				if (rs.next())
				{
					String g_id = rs.getString("g_id");
					String query2 = "DELETE FROM google_map WHERE g_id='"+g_id+"'";
					try (
							Statement st2 = connection.createStatement();
							)	
					{
						if (st2.executeUpdate(query2) > 0) 
						{
							String query3 = "DELETE FROM ad WHERE u_id='"+user+"' AND p_id='"+id+"'";
							try (
									Statement st3 = connection.createStatement();
									)	
							{
								if (st.executeUpdate(query3) > 0) 
								{
									return result = "true";
								}
								
							} catch (SQLException e) {
								System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
								return result = null;
							}
						}
						
					} catch (SQLException e) {
						System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
						return result = null;
					}
				}
			}
			catch(Exception e){
					e.printStackTrace();
					System.out.println( e.getMessage()+" : method is not prepared in pakage : com.create_agent.umair.DbLayer");
					return result = null;
			}
		
		
		finally{
			if(connection != null)
				connection.close();
		}
	return result;
	}
	public static List<AdId> GetAdId(String a_id) throws SQLException
	{
		List<AdId> get_adId= new ArrayList<AdId>();
	 	List<AdId> result = new ArrayList<AdId>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT p_id FROM ad WHERE a_id='"+a_id+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_adId.add(new AdId(rs));
				result = get_adId;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> ViewAdUserArea(String user,String a_id) throws SQLException
	{
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE u_id='"+user+"' AND a_id='"+a_id+"' ORDER BY date_time DESC LIMIT 10";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> viewAd(int ad) throws SQLException
	{
		ad = ad+1;
		int upper = ad+14;
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad ORDER BY date_time DESC LIMIT "+ad+","+upper+"";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> SearchResult(String id) throws SQLException
	{
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE p_id='"+id+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<AreaCityName> AreaCityNames(String a_id) throws SQLException
	{
		List<AreaCityName> get_area= new ArrayList<AreaCityName>();
		List<AreaCityName> result = new ArrayList<AreaCityName>();
		String area = "";
		String city = "";
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT area.area,city.city FROM area,city WHERE area.a_id ='"+a_id+"' AND city.c_id=(SELECT c_id from area WHERE a_id='"+a_id+"')";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				
				//System.out.println(rs.getString("city.city"));
				get_area.add(new AreaCityName(rs));
				result = get_area;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<GoogleMap> GoogleMap(String p_id) throws SQLException
	{
		List<GoogleMap> get_area= new ArrayList<GoogleMap>();
		List<GoogleMap> result = new ArrayList<GoogleMap>();
		String area = "";
		String city = "";
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM google_map WHERE g_id = (SELECT g_id FROM ad WHERE p_id='"+p_id+"')";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				
				//System.out.println(rs.getString("city.city"));
				get_area.add(new GoogleMap(rs));
				result = get_area;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String PageNumberAd() throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) FROM ad";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(p_id)");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String PageNumberAdNo(String user) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) FROM ad WHERE u_id = '"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(p_id)");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String PageNumberAd(String CheckSearch) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) FROM ad";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(p_id)");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String PageNumberAd(String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far) throws SQLException
	{
		if (area.equals("Any"))
		{
			area = "";
		}
		else
		{
			area = "AND a_id = '"+area+"' ";
		}
		if (type.equals("Any"))
		{
			type = "";
		}
		else
		{
			type = "AND typee = '"+type+"' ";
		}
		if (far.equals("Any"))
		{
			far = "";
		}
		else
		{
			far = "AND far = '"+far+"' ";
		}
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) FROM ad WHERE price BETWEEN "+lower_price+" AND "+upper_price+" AND land BETWEEN "+lower_area+" AND "+upper_area+" "+area+type+far+"ORDER BY price LIMIT 0,15";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(p_id)");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> viewAd(String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int ad) throws SQLException
	{
		if (area.equals("Any"))
		{
			area = "";
		}
		else
		{
			area = "AND a_id = '"+area+"' ";
		}
		if (type.equals("Any"))
		{
			type = "";
		}
		else
		{
			type = "AND typee = '"+type+"' ";
		}
		if (far.equals("Any"))
		{
			far = "";
		}
		else
		{
			far = "AND far = '"+far+"' ";
		}
		int upper_limit = ad+15;
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE price BETWEEN "+lower_price+" AND "+upper_price+" AND land BETWEEN "+lower_area+" AND "+upper_area+" "+area+type+far+"ORDER BY price LIMIT "+ad+","+upper_limit+"";
		
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> viewAdUser(int ad) throws SQLException
	{
		int upper_limit = ad+10;
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad ORDER BY date_time DESC LIMIT "+ad+","+upper_limit+"";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String DeleteAd(String id) throws SQLException
	{ 
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return result = null;
		}
		String query = "SELECT g_id FROM ad WHERE p_id='"+id+"'";
		try (
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);)
			{
				if (rs.next())
				{
					String g_id = rs.getString("g_id");
					String query2 = "DELETE FROM google_map WHERE g_id='"+g_id+"'";
					try (
							Statement st2 = connection.createStatement();
							)	
					{
						if (st2.executeUpdate(query2) > 0) 
						{
							String query3 = "DELETE FROM ad WHERE p_id='"+id+"'";
							try (
									Statement st3 = connection.createStatement();
									)	
							{
								if (st.executeUpdate(query3) > 0) 
								{
									return result = "true";
								}
								
							} catch (SQLException e) {
								System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
								return result = null;
							}
						}
						
					} catch (SQLException e) {
						System.out.println(e.getMessage()+"  Method : delete add not prepared in pakage : com.create_agent.umair.DbLayer");
						return result = null;
					}
				}
			}
			catch(Exception e){
					e.printStackTrace();
					System.out.println( e.getMessage()+" : method is not prepared in pakage : com.create_agent.umair.DbLayer");
					return result = null;
			}
		
		
		finally{
			if(connection != null)
				connection.close();
		}
	return result;
	}
	public static List<House> viewAdUser(String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int ad) throws SQLException
	{
		if (area.equals("Any"))
		{
			area = "";
		}
		else
		{
			area = "AND a_id = '"+area+"' ";
		}
		if (type.equals("Any"))
		{
			type = "";
		}
		else
		{
			type = "AND typee = '"+type+"' ";
		}
		if (far.equals("Any"))
		{
			far = "";
		}
		else
		{
			far = "AND far = '"+far+"' ";
		}
		int upper_limit = ad+10;
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE price BETWEEN "+lower_price+" AND "+upper_price+" AND land BETWEEN "+lower_area+" AND "+upper_area+" "+area+type+far+"ORDER BY price LIMIT "+ad+","+upper_limit+"";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<House> viewAdUser(String user,String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int ad) throws SQLException
	{
		if (area.equals("Any"))
		{
			area = "";
		}
		else
		{
			area = "AND a_id = '"+area+"' ";
		}
		if (type.equals("Any"))
		{
			type = "";
		}
		else
		{
			type = "AND typee = '"+type+"' ";
		}
		if (far.equals("Any"))
		{
			far = "";
		}
		else
		{
			far = "AND far = '"+far+"' ";
		}
		int upper_limit = ad+10;
		List<House> get_ad= new ArrayList<House>();
	 	List<House> result = new ArrayList<House>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM ad WHERE u_id='"+user+"' AND price BETWEEN "+lower_price+" AND "+upper_price+" AND land BETWEEN "+lower_area+" AND "+upper_area+" "+area+type+far+"ORDER BY price LIMIT "+ad+","+upper_limit+"";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_ad.add(new House(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String PageNumberAd(String user,String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far) throws SQLException
	{
		if (area.equals("Any"))
		{
			area = "";
		}
		else
		{
			area = "AND a_id = '"+area+"' ";
		}
		if (type.equals("Any"))
		{
			type = "";
		}
		else
		{
			type = "AND typee = '"+type+"' ";
		}
		if (far.equals("Any"))
		{
			far = "";
		}
		else
		{
			far = "AND far = '"+far+"' ";
		}
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) FROM ad WHERE u_id ='"+user+"' price BETWEEN "+lower_price+" AND "+upper_price+" AND land BETWEEN "+lower_area+" AND "+upper_area+" "+area+type+far+"ORDER BY price LIMIT 0,15";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(p_id)");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
}
