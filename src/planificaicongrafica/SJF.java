/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planificaicongrafica;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class SJF {
    public void inicio(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de procesos: ",JOptionPane.QUESTION_MESSAGE));
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];

        int st=0, tot=0;
        float avgwt=0, avgta=0;

        for(int i=0;i<n;i++)
        {
            at[i]= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la hora de llegada del proceso #" + (i+1) + ":",JOptionPane.QUESTION_MESSAGE));
            bt[i]= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su tiempo de rafaga: ",JOptionPane.QUESTION_MESSAGE));
            pid[i] = i+1;
            f[i] = 0;
        }


        while(true)
        {
            int c=n, min = 999999;

            if (tot == n)
                break;

            for (int i=0; i<n; i++)
            {

                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                pid[tot] = c + 1;
                tot++;
            }
        }

        System.out.println("\nProceso  \tLlegada  \tRafaga  \tcompletado \tTiempo  \tEspera");
        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]);
        }
        System.out.println ("\nPromedio de espera "+ (float)(avgta/n));
        System.out.println ("Promedio de ida "+ (float)(avgwt/n));
        sc.close();
        for(int i=0;i<n;i++)
        {
            System.out.print(pid[i] + " ");
        }
        
    }
}
    

