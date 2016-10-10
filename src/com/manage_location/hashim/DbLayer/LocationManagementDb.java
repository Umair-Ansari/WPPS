package com.manage_location.hashim.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Utility.umair.AdId;
import com.Utility.umair.Area;
import com.Utility.umair.AreaId;
import com.Utility.umair.City;
import com.Utility.umair.NewDate;
import com.Utility.umair.UserArea;
import com.Utility.umair.UserCity;
import com.create_agent.umair.DbLayer.ConnetDb;
import com.manage_ad.hashim.DbLayer.AdManagementDb;

public class LocationManagementDb {
	public static String AddCity(String city) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String query = "INSERT INTO city (city)values('"+city+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
				return re;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static List<City> ViewCity() throws SQLException
	{
		List<City> get_city= new ArrayList<City>();
		List<City> result = new ArrayList<City>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM city ORDER BY city";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_city.add(new City(rs));
				result = get_city;
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
	public static String AddArea(String city,String Area) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String query = "INSERT INTO area (area,c_id)values('"+Area+"','"+city+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
				return re;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static List<Area> ViewArea(String city) throws SQLException
	{
		List<Area> get_area= new ArrayList<Area>();
		List<Area> result = new ArrayList<Area>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM area WHERE c_id ='"+city+"'  ORDER BY area";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_area.add(new Area(rs));
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
	public static String DeleteArea(String area) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query = "DELETE FROM area WHERE a_id='"+area+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : delete area not prepared in pakage :  com.manage_location.hashim.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static List<AreaId> GetAreaId(String c_id) throws SQLException
	{
		List<AreaId> get_areaId= new ArrayList<AreaId>();
	 	List<AreaId> result = new ArrayList<AreaId>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT a_id FROM area WHERE c_id='"+c_id+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
				)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_areaId.add(new AreaId(rs));
				result = get_areaId;
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
	public static String DeleteCity(String c_id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query = "DELETE FROM city WHERE c_id='"+c_id+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : Delete City not prepared in pakage : com.manage_location.hashim.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static List<UserArea> ViewUserArea(String city,String user) throws SQLException
	{
		List<UserArea> get_area= new ArrayList<UserArea>();
		List<UserArea> result = new ArrayList<UserArea>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user_area WHERE uc_id ='"+city+"'  AND u_id='"+user+"' ORDER BY area";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_area.add(new UserArea(rs));
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
	
}
