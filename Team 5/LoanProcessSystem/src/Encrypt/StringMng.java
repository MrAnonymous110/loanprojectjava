/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Encrypt;

/**
 *
 * @author Administrator
 */
public class StringMng {
    public static String getName(String name)
    {
        String regex = "[ ]+";
        String[] s= name.split(regex);
        String txt="";
        for(String str : s)
        {
            char[] c = str.toCharArray();
            c[0] = Character.toUpperCase(c[0]);
            txt+=new String(c)+" ";
        }
        return txt.trim();
    }
}
