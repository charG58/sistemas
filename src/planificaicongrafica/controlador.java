/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planificaicongrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Eduardo
 */
public class controlador extends JFrame{
    private ArrayList<modelo> list;
    float MediaA;
    float MediaF;
    
    public controlador(){
        int horaLl, tiempoS;
        ArrayList<modelo> Temp = new ArrayList<>();        
        int Ps=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de procesos: ",JOptionPane.QUESTION_MESSAGE));
        int NumeroPro=Ps;
        System.out.println(NumeroPro);
        for(int ct=Ps+1;Ps!=0;Ps--){
            String mensaje="Ingrese la hora de llegada del proceso No."+(ct-Ps)+": ";
            horaLl=Integer.parseInt(JOptionPane.showInputDialog(null,mensaje,"Hora de llegada del proceos",JOptionPane.QUESTION_MESSAGE));
            tiempoS=Integer.parseInt(JOptionPane.showInputDialog(null,"Y su tiempo de servicio:","Tiempo servicio del proceos",JOptionPane.QUESTION_MESSAGE));
            Temp.add(new modelo(horaLl,tiempoS));
        }
        boolean on = true;
        ArrayList<modelo>fifo=new ArrayList<>();
        while(on){
            int mini=1000000;
            if(!Temp.isEmpty()){
                int cont=0, pos=0;
                for(modelo Mmodelo:Temp){
                    if( Mmodelo.getHoraLl() <=mini){
                        mini=Mmodelo.getHoraLl();
                        pos=cont++;
                    }else{
                        cont++;
                    }
                }
                fifo.add(Temp.remove(pos));
            }else{
                on=false;
            }
        }
        int TiempoF=0,num=1;
        float MediaTq=0, Media=0, Tiemponr,tiempo,tiempo1;
        for(int cont=0;cont<fifo.size();cont++){
            fifo.get(cont).setNumP(num++);
            if(cont==0){
                TiempoF=fifo.get(0).getHoraLl()+TiempoF+fifo.get(cont).getTiempoS();
            }else{
                TiempoF=TiempoF+ fifo.get(cont).getTiempoS();
            }
            fifo.get(cont).setTiempoF(TiempoF);
            fifo.get(cont).setTiempoR(TiempoF-fifo.get(cont).getHoraLl());
            Tiemponr=(float)fifo.get(cont).getTiempoR();
            fifo.get(cont).setTeimpoNR(Tiemponr/fifo.get(cont).getTiempoS());
            tiempo=(float)fifo.get(cont).getTiempoR();
            MediaTq=MediaTq-tiempo;
            tiempo1=(float)fifo.get(cont).getTeimpoNR();
            Media=Media+tiempo1;
            }
            MediaA=MediaTq/NumeroPro;
            MediaF=Media/NumeroPro;
            list=fifo;
            
            setTitle("Algoritmo de Planificación: FIFO ");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100,100,800,600);
            int nool=NumeroPro+1;
            System.out.println(nool);
            Object datos[][]=new Object[5][nool];
            for(int fil=0;fil<5;fil++){
                switch(fil){
                    case 0:
                        datos[fil][0]="Hora de Llegada: ";
                        break;
                    case 1:
                        datos[fil][0]="Tiempo de servicio";
                        break;
                    case 2:
                        datos[fil][0]="Tiempo Finalizacion: ";
                        break;
                    case 3:
                        datos[fil][0]="Tiempo Retorno ";
                        break;
                    case 4:
                        datos[fil][0]="Tiempo NR: ";
                        break;
                }
                int con=0;
                for(int col=1;col<nool;col++,con++){
                    switch(fil){
                        case 0:
                            datos[fil][col]=fifo.get(con).getHoraLl();
                            break;
                        case 1:
                            datos[fil][col]=fifo.get(con).getTiempoS();
                            break;
                        case 2:
                            datos[fil][col]=fifo.get(con).getTiempoF();
                            break;
                        case 3:
                            datos[fil][col]=fifo.get(con).getTiempoR();
                            break;
                        case 4:
                            datos[fil][col]=fifo.get(con).getTeimpoNR();
                            break;
                            
                    }
                }
            }
            int in=0;
            Object columna[]=new Object[nool];
            for(int i=0;i<nool;i++){
                if(i==0){
                    columna[i]="Numero de Proceso: ";
                }else{
                    columna[i]=fifo.get(in).getNumP();
                    System.out.println(columna[i]);
                    in++;
                }
            }
            JTable tb1=new JTable(datos,columna);
            JScrollPane panel=new JScrollPane(tb1);
            getContentPane().add(panel,BorderLayout.CENTER);
            setVisible(true);
        }
          
        public void paint(Graphics g){
            super.paint(g);
            int sizelist = list.size();
            int size = list.get(sizelist-1).getTiempoF();
            g.setColor(Color.BLACK);
            g.drawString("Media Tq: ", 550, 160);
            String Tq=Float.toString(MediaA);
            g.drawString(Tq, 640, 160);
            
            g.drawString("Media Tq/Timepo Salida: ", 480, 190);
            String Tqs=Float.toString(MediaA);
            g.drawString(Tqs, 640, 190);
            
            g.drawString("FIFO / Proceso", 100, 200);
            int total=size*22;
            g.drawLine(50, 249, (total+50), 249);
            sizelist *=22;
            g.drawLine(50, 250, 50, (sizelist+250));
            
            int limite=21;
            for(int ps=0;total>0;total-=22,ps++){
                String proc=Integer.toString(ps);
                if(ps==0){
                    g.drawString(proc,50, 248);
                }else{
                    g.drawString(proc, (limite+50), 248);
                    limite +=22;
                }
            }
            limite = 22;
            for(int ps=1; sizelist>0;sizelist-=22,ps++){
                String proc=Integer.toString(ps);
                if(ps==1){
                    g.drawString(proc,41, 271);
                }else{
                    g.drawString(proc, 41,(limite+271));
                    limite +=22;
                }
            }
            int posY=250, tiempFin=0;
            int iniq,inip;
            
            for(modelo delo:list){
                if(delo.getNumP() == 1){
                    iniq=delo.getHoraLl() * 22;
                    inip=0;
                    tiempFin=delo.getTiempoF();
                }else{
                    iniq=tiempFin * 22;
                    inip=(delo.getNumP()-1)*22;
                    tiempFin=delo.getTiempoF();
                }
                int TiemS=delo.getTiempoS();
                
                int R=(int)(Math.random()*256);
                int G=(int)(Math.random()*256);
                int B=(int)(Math.random()*256);
                
                Color randomColor = new Color(R,G,B);
                
                int posX=50;
                g.setColor(randomColor);
                for(;TiemS>0;TiemS--){
                    detenerTiempo();
                    g.fillRect((posX+iniq),(posY+inip),20,20);
                    posX+=22;
                }
            }
        }
        public static void detenerTiempo(){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                
            }
        }
    }
    

