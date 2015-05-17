/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;


import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author wallejr
 */
public class ListManager<T> extends AbstractListModel<T>
{
    // Instance variable som innehåller kollektion t_list
    private ArrayList<T> t_list;
    private int count;

  

    /**
     * @return the count
     */
    public int getCount()
    {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    
   

    /**
     * @return the t_list
     */
    public ArrayList<T> getT_list()
    {
        return t_list;
    }

    /**
     * @param t_list the t_list to set
     */
    public void setT_list(ArrayList<T> t_list)
    {
        this.t_list = t_list;
    }
    
    //Default konstruktor, instansierar en ArrayList
     public ListManager()
    {
        t_list = new ArrayList<T>() {};
    }
     
      /// <summary>
        /// Metod som hanterar listan av valfri typ genom att den är deklarerad med <T> så håller respektive lista sina egna objekt
        /// </summary>
        /// <param name="aType"></param>
        /// <returns></returns>
    public boolean Add(T aType)
    {
        if (aType != null)
        {
            t_list.add(aType);
            return true;
        }
        else
            return false;

    }

    /// <summary>
    /// Metod som tar bort item i listan på valt index
    /// </summary>
    /// <param name="anIndex"></param>
    /// <returns></returns>
    public boolean DeleteAt(int anIndex)
    {
        try
        {
            if (CheckIndex(anIndex))
            {
                t_list.remove(anIndex);
                return true;
            }
            else
                return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /// <summary>
    /// Hämtar och ger information om vad som finns på valt index i listan
    /// </summary>
    /// <param name="anIndex"></param>
    /// <returns>Item i listan på utsatt index</returns>
    public T GetAt(int anIndex)
    {
        T item = t_list.get(anIndex);

        return item;

    }

    /// <summary>
    /// Metod för att verifera att valt objekt i listan ligger innanför listans index
    /// </summary>
    /// <param name="index"></param>
    /// <returns>True om objekt är inom listans gränser annars false</returns>
    public boolean CheckIndex(int index)
    {
        count = t_list.size();
        if (index <= count && index >= 0)
            return true;
        else
            return false;
    }

    /// <summary>
    /// Metod för att ändra i listan
    /// </summary>
    /// <param name="aType">input om vad för objekt som ska ändras</param>
    /// <param name="anIndex">input som visar vilket index som ska ändras</param>
    /// <returns></returns>
    public boolean ChangeAt(T aType, int anIndex)
    {
        if (CheckIndex(anIndex))
        {
            t_list.remove(anIndex);
            t_list.add(anIndex, aType);
            return true;
        }
        else
            return false;

    }//Slut på metod ChangeAt

    /// <summary>
    /// Metod från interface som returnerar innehållet i en collection i form av en string array
    /// </summary>
    /// <returns></returns>
    /*
    public String[] toStringArray()
    {
        int index = t_list.size();
        String[] strInfoStrings = new String[index];
        
        
        /*
        for (int i = 0; i < index; i++)
        {
            strInfoStrings[i++] = (Case)t_list.toString();
        }
        return strInfoStrings;
    }//Slut på metod ToStringArray
    */

    @Override
    public int getSize()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getElementAt(int index)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
