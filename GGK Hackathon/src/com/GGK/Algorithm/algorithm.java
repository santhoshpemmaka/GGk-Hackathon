package com.GGK.Algorithm;

import java.util.Scanner;
import java.lang.*;
import java.lang.reflect.Method;
import java.util.*;

public class algorithm
{
	
	  public static void main(String[] args) throws Exception, Exception {
	  
	  System.out.println(Aachar1("Ganesh@21"));
	  System.out.println(Aachar2("Ganesh@21"));
	  System.out.println(Aachar3("Ganesh@21"));
	  System.out.println(Aachar4("Ganesh@21"));
	  System.out.println(Aachar5("Ganesh@21"));
	  System.out.println(Aachar6("Ganesh@21"));
	  System.out.println(Aachar7("Ganesh@21"));
	  System.out.println(Aachar8("Ganesh@21"));
	  System.out.println(Aachar9("Ganesh@21"));
	  System.out.println(Aachar10("Ganesh@21"));
	  }
	  


/* next character */
public static String Aachar1(String str) {
	
	char[] ch = str.toCharArray(); 
	str="";
	for(int i=0;i<ch.length;i++)
	{
		ch[i]++;
		if(ch[i]>=127)
			ch[i]=33;
		str+=ch[i];
	}
	return str;
}

/* fibanocci */
public static String Aachar2(String ch)
{
    char[] s=ch.toCharArray();
    String str;
    int th,f,se,t,p,c,i=0;
    f=s[0]-'0';
    se=s[1]-'0';
    for(c=0;c<ch.length();c++)
    {
        th=f+se;
        if(th>9)
        {
            p=0;
            while(th>0)
            {
                p+=th%10;
                th=th/10;
            }
            th=p;
        }
        s[i]=(char)(th +'0');
        i++;
        f=se;
        se=th;
    }
    str=String.valueOf(s);
    return str;
}

/*ascii bit manipulation using xor operation*/
public static String Aachar3(String ch)
{
    char[] s=ch.toCharArray();
    String str;
    int i,j,t,p,l,No;
    l=ch.length();
    for(i=0;i<ch.length();i++)
    {
        if(i==(l-1))
            s[i]=(char)(s[i]^s[0]);
        else
            s[i]=(char)(s[i]^s[i+1]);
        if(s[i]<33)
        {
            s[i]+=32;
        }
        if(s[i]>=127)
            s[i]=(char)~(s[i]);
   
    
    }
    str=String.valueOf(s);
    return str;
}

/* prime */
public static String Aachar4(String ch)
{
    char[] s=ch.toCharArray();
    String str;
    int t,i,j,c=0,l,p;
    for(i=0;i<s.length;i++);
    l=i;
    for(i=0;i<s.length;i++)
    {
        p=s[i]-'0';
        t=p+1;
        while(true)
        {
            c=0;
            for(j=1;j<=t/2;j++)
            {
                if(t%j==0)
                {
                    c++;
                }
            }
            if(c==1)
                break;
            t++;
        }
        if (p<=6)
            s[i]=(char)(t+'0');
        else
            s[i]=(char)((l--)+'0');
    }
    str=String.valueOf(s);
    return str;
}


/*Key value is the length of given string plus the sum of the digits in given string. The key value is added to each variable in the string*/
public static String Aachar5(String c)
{
    char[] str=c.toCharArray();
    String s;
    int sum=0;
    for(int i=0;i<c.length();i++)
    {
        if(Character.isDigit(str[i]))
        {
            sum+=str[i]-'0';
        }
    }
    int key=c.length()+sum;
    for(int i=0;i<str.length;i++)
    {
        str[i]=(char)(str[i]+key);
        str[i]=(char)(str[i]%127);
        if(str[i]<33)
        {
            str[i]=(char)(32+str[i]);
        }
    }
    s=String.valueOf(str);
    return s;
}

/*ascii values convert to octal plus position of character*/
public static String Aachar6(String c)
{
    char[] str=c.toCharArray();
    for(int i=0;i<c.length();i++)
    {
        String a=Integer.toOctalString(str[i]);
        int b=Integer.valueOf(a);
        b=(b+i)%127;
        if(b<33)
        {
            b=b+32;
        }
        str[i]=(char)b;
    }
    String n=String.valueOf(str);
    return n;

}

/*fibannoci using password 1st two characters added with last character in string*/
public static String Aachar7(String ch)
{
    char[] s=ch.toCharArray();
    String str;
    int th,f,se,c,i=0;
    f=s[0]+s[ch.length()-1];
    se=s[1]+s[ch.length()-1];
    for(c=0;c<ch.length();c++)
    {
        th=(f+se)%127;
        if(th<33)
        {
            th+=32;
        }
        s[i]=(char)(th);
        i++;
        f=se;
        se=th;
    }
    str=String.valueOf(s);
    return str;
}

/*Key value is the length of given string plus the sum of the Characters ascii values divided by 2*/
public static String Aachar8(String c)
{
    char[] str=c.toCharArray();
    String s;
    int sum=0;
    for(int i=0;i<c.length();i++)
    {
            sum+=str[i];
    }
    int key=c.length()+sum/2;
    for(int i=0;i<str.length;i++)
    {
        str[i]=(char)(str[i]+key);
        str[i]=(char)(str[i]%127);
        if(str[i]<33)
        {
            str[i]=(char)(32+str[i]);
        }
        key--;
    }
    s=String.valueOf(str);
    return s;
}

/*using a constant string as key*/
public static String Aachar9(String c)
{
    char[] str=c.toCharArray();
    String s;
    char[] key={'f','l','o','a','t','i','n','g'};
    int j=key.length-1;
    for(int i=0;i<str.length;i++)
    {
        str[i]=(char)(str[i]+key[j]);
        str[i]=(char)(str[i]%127);
        if(str[i]<33)
        {
            str[i]=(char)(32+str[i]);
        }
        j--;
        if(j==-1)
        {
            j=key.length-1;
        }
    }
    s=String.valueOf(str);
    return s;
}



/*ascii values convert to binary and left shift to 1 position*/
public static String Aachar10(String c)
{
    char[] str=c.toCharArray();
    for(int i=0;i<c.length();i++)
    {
        String a=Integer.toBinaryString(str[i]);
        int b=Integer.valueOf(a);
        b=b<<1;
        b=b%127;
        if(b<33)
        {
            b=b+32;
        }
        str[i]=(char)b;
    }
    String n=String.valueOf(str);
    return n;
}
}