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
public class Case
{
    private int id;
    private String bestallareFullNamn;
    private String bestallareAnvNamn;
    private String kategori;
    private String status;
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
    
    public Case(String bestFull, String bestnANamn, String kat, String stat, String skapadav, String tilldelad,
            int bertid, String casedesc, String tit)
    {
        setBestallareAnvNamn(bestnANamn);
        setBestallareFullNamn(bestFull);
        setKategori(kat);
        setStatus(stat);
        setSkapadAv(skapadav);
        setTilldeladTill(tilldelad);
        setBeraknadTid(bertid);
        setCaseDesc(casedesc);
        setTitel(tit);
        
        
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
        String DBURL = "jdbc:derby://localhost:1527/AES;user=wallejr;password=aik71111";
        java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(getSkapad().getTime());
        java.sql.Timestamp sqlAndradDate = new java.sql.Timestamp(getAndrad().getTime());
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            cn = DriverManager.getConnection(DBURL);
            
            if (cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            PreparedStatement caseStmt = cn.prepareStatement("INSERT INTO CASES (TITEL, DESCRIPTION, SKAPATDEN, ANDRATDEN, STATUS, SKAPATAV, REQUESTERFULLNAME, REQUESTERUSERNAME, PHONENR, COMPUTERNAME, TIDBEREKNAD, STATUS)" 
                  +  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            PreparedStatement commentStmt = cn.prepareStatement("INSERT INTO COMMENTS(COMMENTS)" + "VALUES (?)");
            
            
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
            caseStmt.setString(12, getStatus());
            
            
            if (!getComments().isEmpty())
                commentStmt.setString(1, getComments());
            
            
            
            int x = commentStmt.executeUpdate();
            int i = caseStmt.executeUpdate();
            
            if (i > 0 || x > 0)
            {
                succes = true;
            }
            
            return  succes;
            
        } catch (ClassNotFoundException classE)
        {
            throw new SQLException("Problem med db:" + classE.getMessage());
        }
        
        finally
        {
            if (cn != null)
                cn.close();
        }
    }
    
        
    public static java.sql.Date convertFromJAVADateToSQLDate(
            java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = (java.sql.Date) new Date(javaDate.getTime());
        }
        return sqlDate;
    }

    /**
     * @return the phoneNR
     */
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
    
}
