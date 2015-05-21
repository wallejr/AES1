/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author wallejr
 */
public class Case
{
    private int id;
    private String bestallareFullNamn;
    private String bestallareAnvNamn;
    private String kategori;
    private String status;
    private String avdelning;
    private String skapadAv;
    private String tilldeladTill;
    private Date skapad;
    private String phoneNR;
    private String compName;
    private Date andrad;
    private int beraknadTid;
    private int tidsAtgang;
    private String caseDesc;
    private String solution;
    private String titel;
    private String comments;
    
    public Case()
    {  
    }
    
    




    /**
     * @return the kategori
     */
    public String getKategori()
    {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori)
    {
        this.kategori = kategori;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the skapadAv
     */
    public String getSkapadAv()
    {
        return skapadAv;
    }

    /**
     * @param skapadAv the skapadAv to set
     */
    public void setSkapadAv(String skapadAv)
    {
        this.skapadAv = skapadAv;
    }

    /**
     * @return the tilldeladTill
     */
    public String getTilldeladTill()
    {
        return tilldeladTill;
    }

    /**
     * @param tilldeladTill the tilldeladTill to set
     */
    public void setTilldeladTill(String tilldeladTill)
    {
        this.tilldeladTill = tilldeladTill;
    }

    /**
     * @return the beraknadTid
     */
    public int getBeraknadTid()
    {
        return beraknadTid;
    }

    /**
     * @param beraknadTid the beraknadTid to set
     */
    public void setBeraknadTid(int beraknadTid)
    {
        this.beraknadTid = beraknadTid;
    }

    /**
     * @return the caseDesc
     */
    public String getCaseDesc()
    {
        return caseDesc;
    }

    /**
     * @param caseDesc the caseDesc to set
     */
    public void setCaseDesc(String caseDesc)
    {
        this.caseDesc = caseDesc;
    }

    /**
     * @return the titel
     */
    public String getTitel()
    {
        return titel;
    }

    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel)
    {
        this.titel = titel;
    }
    

    /**
     * @return the skapad
     */
    public Date getSkapad()
    {
        return skapad;
    }

    /**
     * @param skapad the skapad to set
     */
    public void setSkapad(Date skapad)
    {
        this.skapad = skapad;
    }

    /**
     * @return the bestallareFullNamn
     */
    public String getBestallareFullNamn()
    {
        return bestallareFullNamn;
    }

    /**
     * @param bestallareFullNamn the bestallareFullNamn to set
     */
    public void setBestallareFullNamn(String bestallareFullNamn)
    {
        this.bestallareFullNamn = bestallareFullNamn;
    }

    /**
     * @return the bestallareAnvNamn
     */
    public String getBestallareAnvNamn()
    {
        return bestallareAnvNamn;
    }

    /**
     * @param bestallareAnvNamn the bestallareAnvNamn to set
     */
    public void setBestallareAnvNamn(String bestallareAnvNamn)
    {
        this.bestallareAnvNamn = bestallareAnvNamn;
    }
    
     public String getPhoneNR()
    {
        return phoneNR;
    }

    /**
     * @param phoneNR the phoneNR to set
     */
    public void setPhoneNR(String phoneNR)
    {
        this.phoneNR = phoneNR;
    }

    /**
     * @return the compName
     */
    public String getCompName()
    {
        return compName;
    }

    /**
     * @param compName the compName to set
     */
    public void setCompName(String compName)
    {
        this.compName = compName;
    }

    /**
     * @return the comments
     */
    public String getComments()
    {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the andrad
     */
    public Date getAndrad()
    {
        return andrad;
    }

    /**
     * @param andrad the andrad to set
     */
    public void setAndrad(Date andrad)
    {
        this.andrad = andrad;
    }

    /**
     * @return the solution
     */
    public String getSolution()
    {
        return solution;
    }

    /**
     * @param solution the solution to set
     */
    public void setSolution(String solution)
    {
        this.solution = solution;
    }

    /**
     * @return the tidsAtgang
     */
    public int getTidsAtgang()
    {
        return tidsAtgang;
    }

    /**
     * @param tidsAtgang the tidsAtgang to set
     */
    public void setTidsAtgang(int tidsAtgang)
    {
        this.tidsAtgang = tidsAtgang;
    }
    
        @Override
    public String toString()
    {
        return String.format("%-10s | %-15s | %-6s | %-10s | %-10s", getId(), getTitel(), getCaseDesc(), getSkapad(), getBestallareFullNamn());
    }
    
    public void addId()
    {
            setId(id++);
            
    }

    public boolean addCase() throws SQLException
    {
        boolean succes = false;
        Connection cn = null;
        //String DBURL = "jdbc:derby://localhost:1527/AES;user=wallejr;password=aik71111";
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
        java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(getSkapad().getTime());
        java.sql.Timestamp sqlAndradDate = new java.sql.Timestamp(getAndrad().getTime());
        
        try
        {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DBURL);
            
            if (cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            PreparedStatement caseStmt = cn.prepareStatement("INSERT INTO CASES (TITEL, DESCRIPTION, SKAPATDEN, ANDRATDEN, STATUS, " + 
                    "SKAPATAV, REQUESTERFULLNAME, REQUESTERUSERNAME, PHONENR, COMPUTERNAME, " + 
                    "TIDBEREKNAD, ASSIGNE, DEPARTMENT, KATEGORI) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            PreparedStatement commentStmt;
            
            
            caseStmt.setString(1, getTitel());
            caseStmt.setString(2, getCaseDesc());
            caseStmt.setTimestamp(3, sqlStartDate);
            caseStmt.setTimestamp(4, sqlAndradDate);
            caseStmt.setString(5, getStatus());
            caseStmt.setString(6, getSkapadAv());
            caseStmt.setString(7, getBestallareFullNamn());
            caseStmt.setString(8, getBestallareAnvNamn());
            caseStmt.setString(9, getPhoneNR());
            caseStmt.setString(10, getCompName());
            caseStmt.setInt(11, getBeraknadTid());
            caseStmt.setString(12, getTilldeladTill());
            caseStmt.setString(13, getAvdelning());
            caseStmt.setString(14, getKategori());
            
            
            
            int i = caseStmt.executeUpdate();
            
            if (i > 0 )
            {
                
                
                if (!getComments().isEmpty())
                {
                   
        
    
                    
                    commentStmt = cn.prepareStatement("INSERT INTO CASE_COMMENTS(COMMENTS, Timed, CASE_ID)" + "VALUES (?, ?, LAST_INSERT_ID())");
                    commentStmt.setString(1, getComments());
                    commentStmt.setTimestamp(2, sqlAndradDate);


                    commentStmt.executeUpdate();
                    
                    succes = true;

                }
                else
                {
                    succes = false;
                }
                
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
        
    } //End method addCase
    
        public boolean updateCase() throws SQLException, Exception
    {
        boolean succes = false;
        Connection cn = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
        "user=root&password=aik71111";

        
        try
        {
            Timestamp sqlStartDate = new Timestamp(getSkapad().getTime());
            Timestamp sqlAndradDate = new Timestamp(getAndrad().getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DBURL);
            
            if (cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            PreparedStatement caseStmt = cn.prepareStatement("UPDATE CASES SET " +
                        "TITEL = ?, " +
                        "DESCRIPTION = ?," +
                        "ANDRATDEN = ?," +
                        "STATUS = ?," +
                        "PHONENR = ?," +
                        "COMPUTERNAME = ?," +
                        "TIDBEREKNAD = ?," + 
                        "ASSIGNE = ?," +
                        "DEPARTMENT = ?, " +
                        "TIDSLUTFORT = ?, " +
                        "KATEGORI = ? " +
                        "where CASES_ID='"+getId()+"'");
                        
            
            caseStmt.setString(1, getTitel());
            caseStmt.setString(2, getCaseDesc());
            caseStmt.setTimestamp(3, sqlAndradDate);
            caseStmt.setString(4, getStatus());
            caseStmt.setString(5, getPhoneNR());
            caseStmt.setString(6, getCompName());
            caseStmt.setInt(7, getBeraknadTid());
            caseStmt.setString(8, getTilldeladTill());
            caseStmt.setString(9, getAvdelning());
            caseStmt.setInt(10, getTidsAtgang());
            caseStmt.setString(11, getKategori());
          
            
            int i = caseStmt.executeUpdate();
            
            if (i > 0 )
            {
                if (getComments() != null && !getComments().isEmpty())
                {
                   
                    PreparedStatement commentStmt = cn.prepareStatement("INSERT INTO CASE_COMMENTS(COMMENTS, Timed, CASE_ID)" + "VALUES (?, ?, '"+getId()+"'");
                    commentStmt.setString(1, getComments());
                    commentStmt.setTimestamp(2, sqlAndradDate);


                    int x = commentStmt.executeUpdate();
                    if (x > 0)
                    {
                        succes = true;
                    } //End inner, inner if, verifying comments insert success

                }//End inner if, runningt comments insert statement
                
                if(getSolution() != null && !getSolution().isEmpty())
                {
                    PreparedStatement solutionStmt = cn.prepareStatement("INSERT INTO CASE_SOLUTIONS(SOLUTION, Timed, CASE_ID)" + "VALUES(?, ?, '"+getId()+"'");
                    solutionStmt.setString(1, getSolution());
                    solutionStmt.setTimestamp(2, sqlStartDate);
                    
                    int x = solutionStmt.executeUpdate();
                    if (x > 0)
                    {
                        succes = true;
                    } //End inner, inner if, verifying solution insert success
                }
                
                
                succes = true;
            }//End outer if verifyt case update
            
            
        } catch (ClassNotFoundException classE)
        {
            throw new SQLException("Problem med db:" + classE.getMessage());
        }
        catch(NullPointerException nullE)
        {
            throw new NullPointerException(nullE.getMessage());
        }
                
        
        finally
        {
            if (cn != null)
                cn.close();
        }
        
        return  succes;
        
    } //End method updateCase
    
    public boolean openCase() throws SQLException
    {
        
        
        boolean success = false;
        Connection cn = null;
        String DBURL = "jdbc:mysql://localhost:3306/AES?" +
                "user=root&password=aik71111";
       
//        Timestamp sqlStartDate = new Timestamp(getSkapad().getTime());
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(DBURL);
            String s ="select * from CASES where CASES_ID='"+getId()+"'";
            Statement stmt = cn.createStatement();
            ResultSet rs=stmt.executeQuery(s);
            while(rs.next())
            {
                setTitel(rs.getString("TITEL"));
                setCaseDesc(rs.getString("DESCRIPTION"));
                setSkapad(rs.getDate("SKAPATDEN"));
                setAndrad(rs.getDate("ANDRATDEN"));
                setStatus(rs.getString("STATUS"));
                setSkapadAv(rs.getString("SKAPATAV"));
                setBestallareFullNamn(rs.getString("REQUESTERFULLNAME"));
                setBestallareAnvNamn(rs.getString("REQUESTERUSERNAME"));
                setPhoneNR(rs.getString("PHONENR"));
                setCompName(rs.getString("COMPUTERNAME"));
                setBeraknadTid(rs.getInt("TIDBEREKNAD"));
                setTidsAtgang(rs.getInt("TIDSLUTFORT"));
                setTilldeladTill(rs.getString("ASSIGNE"));
                setSolution(rs.getString("SOLUTION"));
                setAvdelning(rs.getString("DEPARTMENT"));
                setTidsAtgang(rs.getInt("TIDSLUTFORT"));
                setKategori(rs.getString("KATEGORI"));
            }
            
            success = true;
            
        } 
       catch (ClassNotFoundException classE)
        {
            throw new SQLException("Problem med db:" + classE.getMessage());
        }
        
        finally
        {
            if (cn != null)
                cn.close();
        }
        return success;

        
        
    }

    /**
     * @return the avdelning
     */
    public String getAvdelning()
    {
        return avdelning;
    }

    /**
     * @param avdelning the avdelning to set
     */
    public void setAvdelning(String avdelning)
    {
        this.avdelning = avdelning;
    }
    
        
//    private static java.sql.Date convertFromJAVADateToSQLDate(
//            java.util.Date javaDate) {
//        java.sql.Date sqlDate = null;
//        if (javaDate != null) {
//            sqlDate = (java.sql.Date) new Date(javaDate.getTime());
//        }
//        return sqlDate;
//    }

    /**
     * @return the phoneNR
     */
   
    
}
