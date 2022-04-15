package util;

import java.util.Scanner;

public class Lector {

    public static int leerInt(String p)
    {
        Scanner sc = new Scanner(System.in);
        boolean leido = false;
        int dato=0;
        while (!leido)
        {
            if (p!=null)
                System.out.println(p);
            try
            {
                dato = sc.nextInt();
                leido = true;
            }
            catch (Exception e)
            {
                System.out.println("Dato no válido");
                sc.nextLine();
            }
        }
        return dato;
    }

    public static int leerInt(String p,int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        boolean leido = false;
        int dato=0;
        while (!leido)
        {
            if (p!=null)
                System.out.println(p);
            try
            {
                dato = sc.nextInt();
                if (dato < min || dato > max)
                    System.out.println("Dato no valido");
                else
                    leido = true;
            }
            catch (Exception e)
            {
                System.out.println("Dato no válido");
                sc.nextLine();
            }
        }
        return dato;
    }

    public static boolean leerSiNo(String p)
    {
        Scanner sc = new Scanner(System.in);
        boolean leido = false;
        char dato='a';
        while (!leido)
        {
            if (p!=null)
                System.out.println(p+ " (Ss/Nn)");
            try
            {
                dato = sc.nextLine().toLowerCase().charAt(0);
                if (dato != 's'  && dato != 'n')
                    System.out.println("Respuesta no válida");
                else
                    leido = true;
            }
            catch (Exception e)
            {
                System.out.println("Respuesta no válida");
            }
        }
        return dato=='s';
    }

    public static String leerLinea(String p)
    {
        Scanner sc = new Scanner(System.in);
        if (p!=null)
            System.out.println(p);
        return sc.nextLine();
    }
}
