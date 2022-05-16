/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planificaicongrafica;

/**
 *
 * @author Eduardo
 */
public class modelo {
    private int NumP;
    private int HoraLl;
    private int TiempoS;
    private int TiempoF;
    private int TiempoR;
    private float TeimpoNR;

    public modelo(int HoraLl, int TiempoS) {
        this.HoraLl = HoraLl;
        this.TiempoS = TiempoS;
    }
    
    

    public int getNumP() {
        return NumP;
    }

    public void setNumP(int NumP) {
        this.NumP = NumP;
    }

    public int getHoraLl() {
        return HoraLl;
    }

    public void setHoraLl(int HoraLl) {
        this.HoraLl = HoraLl;
    }

    public int getTiempoS() {
        return TiempoS;
    }

    public void setTiempoS(int TiempoS) {
        this.TiempoS = TiempoS;
    }

    public int getTiempoF() {
        return TiempoF;
    }

    public void setTiempoF(int TiempoF) {
        this.TiempoF = TiempoF;
    }

    public int getTiempoR() {
        return TiempoR;
    }

    public void setTiempoR(int TiempoR) {
        this.TiempoR = TiempoR;
    }

    public float getTeimpoNR() {
        return TeimpoNR;
    }

    public void setTeimpoNR(float TeimpoNR) {
        this.TeimpoNR = TeimpoNR;
    }
    
    
}
