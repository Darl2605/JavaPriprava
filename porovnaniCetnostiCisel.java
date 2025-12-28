/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zkouska;

import java.util.Scanner;

/**
 *
 * @author sedla
 * 
 * zjednodušeně co se chce je udělat program co ti řekne jestli zadaný čísla jsou přesmyčky je to na kokot popsaný
 * 
 * příklad:
 *  "123" = "312" true
 *  "431" = "342" false
 *  "1233" = "123" false
 *  
 * oříšek tady má být v tom že to nemáme porovnávat jako znaky, prostě bez použití stringu etc..
 */
public class zadani_dva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long prvniD;
        long druhaD;
        while(true)
        {
            System.out.println("Pokracovat? a/n");
            String ans = sc.next();
            if(!(ans.equalsIgnoreCase("a")))
                break;
            System.out.println("Zadej prvni dvojici cisel");
            prvniD = sc.nextLong();
            System.out.println("Zadej druhou dvojici cisel");
            druhaD = sc.nextLong();
            int[] CetJedna = cetnostCisel(prvniD);
            int[] CetDva = cetnostCisel(druhaD);
            if(porovnanicetnosti(CetJedna, CetDva))
            {
                System.out.println("Obsahuji stejne cifry ve stejnem poctu");
            }
            else
                System.out.println("Neobsahuji stejne pocty cifer");
        }
    }
    
    static int[] cetnostCisel(long cislo)
    {
        int[] cetnost = new int[10];
        while(cislo > 0)
        {
            long mod = cislo % 10;
            for (int i = 0; i < 10; i++) {
                if (mod == i)
                {
                    cetnost[i] += 1;
                    cislo /= 10;
                }
            }
        }
        return cetnost;
    }
    
    static boolean porovnanicetnosti(int[] PrvniDvojice, int[] DruhaDvojice)
    {
        boolean StejnaCetnost = true;
        for (int i = 0; i < 10; i++) {
            if(PrvniDvojice[i] != DruhaDvojice[i])
            {
                StejnaCetnost = false;
                break;
            }
        }
        return StejnaCetnost;
    }
}
