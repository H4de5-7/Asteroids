package Asteroids;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Polygon;
import java.awt.geom.Area;
public class asteroidsl extends asteroids {
    double MIN_SPEEDM=1;
    double MAX_SPEEDM=3;
    double []xl={10,20,30,35,25};
    double []yl={30,20,15,35,40};
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    asteroidsl(double cx,double cy){
        asteroidsflag=1;
        deltax=MIN_SPEEDM+Math.random()*(MAX_SPEEDM-MIN_SPEEDM);
        deltay=MIN_SPEEDM+Math.random()*(MAX_SPEEDM-MIN_SPEEDM);
        this.cx=cx;
        this.cy=cy;
        if(Math.random()<=0.5){
            deltax=-deltax;
        }
        if(Math.random()<=0.5){
            deltay=-deltay;
        }
        for(int i=0;i<xl.length;i++){
            xl[i]+=cx;
            yl[i]+=cy;
        }
    }
    public void draw(Graphics g) {
        int[] x1 = {(int) xl[0], (int) xl[1], (int) xl[2], (int) xl[3], (int) xl[4]};
        int[] y1 = {(int) yl[0], (int) yl[1], (int) yl[2], (int) yl[3], (int) yl[4]};
        g.setColor(Color.ORANGE);
        g.drawPolygon(x1, y1, 5);
    }
    public void fly(){
        for(int i=0;i<xl.length;i++){
            xl[i]+=deltax;
            yl[i]+=deltay;
        }
        cx+=deltax;
        cy+=deltay;
        chongzhiasteroidsl();
    }
    public boolean hit(Shape a){
        Polygon p=new Polygon(new int[] {(int) xl[0], (int) xl[1], (int) xl[2], (int) xl[3], (int) xl[4]},
                new int[] {(int) yl[0], (int) yl[1], (int) yl[2], (int) yl[3], (int) yl[4]},5);
        Area area=new Area(p);
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    public void chongzhiasteroidsl(){
        if(yl[0]<0&&yl[1]<0&&yl[2]<0&&yl[3]<0&&yl[4]<0){
            for(int i=0;i<xl.length;i++){
                yl[i]+=Height;
            }
            cy+=Height;
        }else if(yl[0]>Height&&yl[1]>Height&&yl[2]>Height&&yl[3]>Height&&yl[4]>Height){
            for(int i=0;i<xl.length;i++){
                yl[i]-=Height;
            }
            cy-=Height;
        }
        if(xl[0]<0&&xl[1]<0&&xl[2]<0&&xl[3]<0&&xl[4]<0){
            for(int i=0;i<xl.length;i++){
                xl[i]+=Width;
            }
            cx+=Width;
        }else if(xl[0]>Width&&xl[1]>Width&xl[2]>Width&&xl[3]>Width&xl[4]>Width){
            for(int i=0;i<xl.length;i++){
                xl[i]-=Width;
            }
            cy-=Width;
        }
    }
}
