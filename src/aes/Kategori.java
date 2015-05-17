/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import aes.Enums.Kompetens;
import java.util.ArrayList;

/**
 *
 * @author wallejr
 */
public class Kategori
{
    private String kategoriNamn;
    private ArrayList<String> arbBeskM;
    private Kompetens kat;
    
    /**
     * @param katName
     * @return the kategoriNamn
     */
    public String getKategoriNamn(Kompetens katName)
    {
        this.kat = katName;
        kategoriNamn = kat.toString();
        return kategoriNamn;
    }

    /**
     * @param kategoriNamn the kategoriNamn to set
     */
    public void setKategoriNamn(String kategoriNamn)
    {
        this.kategoriNamn = kategoriNamn;
    }

    /**
     * @return the arbBeskM
     */
    public ArrayList<String> getArbBeskM()
    {
        switch (kat)
        {
            case Network:
                arbBeskM = new ArrayList<>();
                arbBeskM.add("1. Do this in network");
                arbBeskM.add("2. Do that");
                arbBeskM.add("3. Do this again");
                break;
                case Security:
                arbBeskM = new ArrayList<>();
                arbBeskM.add("1. Do this in security");
                arbBeskM.add("2. Do that");
                arbBeskM.add("3. Do this again");
                break;
                case Installation:
                arbBeskM = new ArrayList<>();
                arbBeskM.add("1. Do this in installations");
                arbBeskM.add("2. Do that");
                arbBeskM.add("3. Do this again");
                break;
                case Users:
                arbBeskM = new ArrayList<>();
                arbBeskM.add("1. Do this in users");
                arbBeskM.add("2. Do that");
                arbBeskM.add("3. Do this again");
                break;
        }
        return arbBeskM;
    }

    /**
     * @param arbBeskM the arbBeskM to set
     */
    public void setArbBeskM(ArrayList<String> arbBeskM)
    {
        this.arbBeskM = arbBeskM;
    }


    
    
    
    
}
