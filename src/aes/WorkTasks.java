/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 *
 * @author wallejr
 */
public class WorkTasks extends Case
{
    
    private String task;
    
    public WorkTasks()
    {}
    
    public WorkTasks(int id, String created, String tasks)
    {
        super(id, created);
        setTask(tasks);
        
    }
    
    
    public boolean addTask() throws SQLException
    {
        boolean succes = false;
        Connection cn = null;
        //String DBURL = "jdbc:derby://localhost:1527/AES;user=wallejr;password=aik71111";
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        Date date = new Date();
        java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(date.getTime());
        
        
        try
        {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DBURL);
            
            if (cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            PreparedStatement caseStmt = cn.prepareStatement("INSERT INTO workTasks (TASK, CREATEDBY, Timed, CASE_ID_FK) " +
                   "SELECT ?, ?, ?, CASES_ID " +
                    "FROM CASES "
                  + "WHERE CASES_ID = ?");

            
            caseStmt.setString(1, getTask());
            caseStmt.setString(2, getTilldeladTill());
            caseStmt.setTimestamp(3, sqlStartDate);
            caseStmt.setInt(4, getId());
            
            int i = caseStmt.executeUpdate();
            
            if (i > 0 )
            {
                succes = true;
            }
            
            //return  succes;
            
        } catch (ClassNotFoundException classE)
        {
            throw new SQLException("Problem med db:" + classE.getMessage());
        }
        
        finally
        {
            if (cn != null)
                cn.close();
            
        }
        
        return  succes;
        
    } //End method addTask
    
    public boolean deleteWorkTask(String task) throws SQLException
    {
         boolean succes = false;
        Connection cn = null;
        //String DBURL = "jdbc:derby://localhost:1527/AES;user=wallejr;password=aik71111";
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        Date date = new Date();
        java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(date.getTime());
        
        
        try
        {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DBURL);
            
            if (cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            PreparedStatement caseStmt = cn.prepareStatement("DELETE FROM workTasks " +
                     "WHERE TASK = ?");

            caseStmt.setString(1, task);
            
            int i = caseStmt.executeUpdate();
            
            if (i > 0 )
            {
                succes = true;
            }
            
            //return  succes;
            
        } catch (ClassNotFoundException classE)
        {
            throw new SQLException("Problem med db:" + classE.getMessage());
        }
        
        finally
        {
            if (cn != null)
                cn.close();
        }
        
        return  succes;
    }
    

    /**
     * @return the task
     */
    public String getTask()
    {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(String task)
    {
        this.task = task;
    }
    
    

   
}
