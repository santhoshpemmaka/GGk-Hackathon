package com.GGK.Algorithm;

public class binarykey
{
    public static void main(String[] args)
    {
        System.out.println(binaryKey("somesh","21-01-1999"));
    }
    
    /*Key value is the sum of ascii values of characters in the string turned to binary form*/
    public static String binaryKey(String c, String ch)
    {
        char[] str=c.toCharArray();
        int sum=0;
        for(int i=0;i<c.length();i++)
        {
            sum+=str[i];
        }
        int key=sum%32768;
        String b=Integer.toBinaryString(key);
        b=String.format("%14s",b).replace(' ','0');
        
        char[] str1=ch.toCharArray();
        int sum1=0;
        for(int i=0;i<ch.length();i++)
        {
            sum1+=str1[i];
        }
        long key1 = sum1%96 ;
        
        return b+key1;
	}
    

}