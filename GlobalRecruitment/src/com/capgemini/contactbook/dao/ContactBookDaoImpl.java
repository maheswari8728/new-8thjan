package com.capgemini.contactbook.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DBConnection;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements IContactBookDao{

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, SQLException, IOException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int enqryId=0;
		int queryResult=0;
		try {
			preparedStatement=connection.prepareStatement("insert into table name values");
			preparedStatement.setString(1, enqry.getfName());
			preparedStatement.setString(2, enqry.getiName());
			preparedStatement.setString(3, enqry.getContactNo());
			preparedStatement.setString(4, enqry.getpDomain());
			preparedStatement.setString(5, enqry.getpLocation());
			queryResult=preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("select * from table name");
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				enqryId=resultSet.getInt(1);
			}
			else if(queryResult==0) {
				logger.error("insertion failed");
				throw new ContactBookException("inserting contactbookdetails failed");
			}
			else {
				logger.info("contactbookdetails inserted successfully ");
				return enqryId;
			}
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new ContactBookException("Tehnical problem occured refer log");
			
		}
		
		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new ContactBookException("error in closing DBConnection");
				
			}
			
		}
		return queryResult;
	
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enqryId) throws ContactBookException, SQLException, IOException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		EnquiryBean enqry=null;
		try {
			preparedStatement=connection.prepareStatement("select * from table name");
			preparedStatement.setInt(1,enqryId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				enqry = new EnquiryBean();
				enqry.setfName(resultSet.getString(1));
				enqry.setiName(resultSet.getString(2));
				enqry.setpDomain(resultSet.getString(3));
				enqry.setpLocation(resultSet.getString(4));
			}
			if(enqry!=null) {
				logger.info("record found successfully");
				return enqry;
			}
			else {
				logger.info("record not found successfully");
				return null;
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
			logger.error(e.getMessage());
			throw new ContactBookException(e.getMessage());
			
		}
		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				System.err.println(e);
				logger.error(e.getMessage());
				throw new ContactBookException("error in closing dbconnection");
			}
		}
		return enqry;
	}

}
