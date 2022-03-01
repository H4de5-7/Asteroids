package Asteroids;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Polygon;
import java.awt.geom.Area;
public class asteroidsm extends asteroids {
    double MIN_SPEEDM=0.75;
    double MAX_SPEEDM=2;;
    double []xm={0,80,40,20,0,-20};
    double []ym={20,80,100,60,80,60};
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    asteroidsm(double cxm,double cym){
        asteroidsflag=2;
        deltax=MIN_SPEEDM+Math.random()*(MAX_SPEEDM-MIN_SPEEDM);
        deltay=MIN_SPEEDM+Math.random()*(MAX_SPEEDM-MIN_SPEEDM);
        this.cx=cxm;
        this.cy=cym;
        if(Math.random()<=0.5){
            deltax=-deltax;
        }
        if(Math.random()<=0.5){
            deltay=-deltay;
        }
        for(int i=0;i<xm.length;i++){
            xm[i]+=cx;
            ym[i]+=cy;
        }
    }
    public void draw(Graphics g) {
        int[] x1 = {(int) xm[0], (int) xm[1], (int) xm[2], (int) xm[3], (int) xm[4], (int) xm[5]};
        int[] y1 = {(int) ym[0], (int) ym[1], (int) ym[2], (int) ym[3], (int) ym[4], (int) ym[5]};
        g.setColor(Color.ORANGE);
        g.drawPolygon(x1, y1, 6);
    }
    public void fly(){
        for(int i=0;i<xm.length;i++){
            xm[i]+=deltax;
            ym[i]+=deltay;
        }
        cx+=deltax;
        cy+=deltay;
        chongzhiasteroidsm();
    }
    public boolean hit(Shape a){
        Polygon p=new Polygon(new int[] {(int) xm[0], (int) xm[1], (int) xm[2], (int) xm[3], (int) xm[4], (int) xm[5]},
                new int[] {(int) ym[0], (int) ym[1], (int) ym[2], (int) ym[3], (int) ym[4], (int) ym[5],},6);
        Area area=new Area(p);
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    public void chongzhiasteroidsm(){
            if(ym[0]<0&&ym[1]<0&&ym[2]<0&&ym[3]<0&&ym[4]<0&&ym[5]<0){
                for(int i=0;i<xm.length;i++){
                    ym[i]+=Height;
                }
                cy+=Height;
            }else if(ym[0]>Height&&ym[1]>Height&&ym[2]>Height&&ym[3]>Height&&ym[4]>Height&&ym[5]>Height){
                for(int i=0;i<xm.length;i++){
                    ym[i]-=Height;
                }
                cy-=Height;
            }
            if(xm[0]<0&&xm[1]<0&&xm[2]<0&&xm[3]<0&&xm[4]<0&&xm[5]<0){
                for(int i=0;i<xm.length;i++){
                    xm[i]+=Width;
                }
                cx+=Width;
            }else if(xm[0]>Width&&xm[1]>Width&xm[2]>Width&&xm[3]>Width&xm[4]>Width&&xm[5]>Width){
                for(int i=0;i<xm.length;i++){
                    xm[i]-=Width;
                }
                cx-=Width;
        }
    }

}
