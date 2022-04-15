package util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    public static int[] dias = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static String sumaDias(String f, int dias)
    {

        int d = getDia(f);
        int m = getMes(f);
        int a = getAnio(f);
        Date fecha = Date.valueOf(a+"-"+(m+1)+"-"+d);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, dias);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int anio = cal.get(Calendar.YEAR);

        return ((dia<10)?"0"+dia:dia)+"/"+((mes<10)?"0"+mes:mes)+"/"+anio;
    }

    public static boolean bisiesto(int a)
    {
        return (a%4==0 && !(a%100==0 && a%400!=0));
    }

    public static boolean valida(String f)
    {
        if (f.length()!=10) return false;
        if (f.charAt(2)!='/' || f.charAt(5)!='/') return false;
        try
        {
            int dia = Integer.parseInt(f.substring(0,2));
            int mes = Integer.parseInt(f.substring(3,5));
            int anio = Integer.parseInt(f.substring(6));
            if (mes < 1 || mes > 12) return false;
            if (bisiesto(anio)) dias[1]++;
            if (dia < 1 || dia > dias[mes-1]) return false;
            return true;

        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static int getDia(String f)
    {
        if (valida(f))
            return Integer.parseInt(f.substring(0,2));
        else
            return -1;
    }

    public static int getMes(String f)
    {
        if (valida(f))
            return Integer.parseInt(f.substring(3,5));
        else
            return -1;
    }

    public static int getAnio(String f)
    {
        if (valida(f))
            return Integer.parseInt(f.substring(6));
        else
            return -1;
    }

    public static boolean llegado(String f)
    {
        Calendar cal= Calendar.getInstance();
        int dHoy = cal.get(Calendar.DAY_OF_MONTH);
        int mHoy = cal.get(Calendar.MONTH)+1;
        int aHoy = cal.get(Calendar.YEAR);
        int dF = getDia(f);
        int mF = getMes(f);
        int aF = getAnio(f);
        if (dF==-1 || mF==-1 || aF == -1)
        {
            System.out.println("Formato de fecha incorrecto");
            return false;
        }

        if (aHoy < aF) return false;
        if (aHoy > aF) return true;
        if (mHoy < mF) return false;
        if (mHoy > mF) return true;
        return dHoy>=dF;





    }

}
