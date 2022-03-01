package Asteroids;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;
public class asteroids {
    double MIN_SPEED=0.5;
    double MAX_SPEED=1.5;
    double cx=Math.random()*1600,cy=Math.random()*1000;
    double deltax=0;
    double deltay=0;
    double []x={-90,80,-10,10,30,-50};
    double []y={-85,-45,-5,15,35,80};
    int asteroidsflag=3;
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    asteroids(){
        double a=Math.random();
        deltax=MIN_SPEED+Math.random()*(MAX_SPEED-MIN_SPEED);
        deltay=MIN_SPEED+Math.random()*(MAX_SPEED-MIN_SPEED);
        if(a<0.25){
            cx=0;
        }else if(a>=0.25&&a<0.5){
            cy=0;
        }else if(a>=0.5&&a<0.75){
            cx=0;
            cy=-cy;
        }else if(a>=0.75){
            cy=0;
            cx=-cx;
        }
        if(Math.random()<=0.5){
            deltax=-deltax;
        }
        if(Math.random()<=0.5){
            deltay=-deltay;
        }
        for(int i=0;i<x.length;i++){
            x[i]+=cx;
            y[i]+=cy;
        }
    }
    public void draw(Graphics g) {
        int[] x1 = {(int) x[0], (int) x[1], (int) x[2], (int) x[3], (int) x[4], (int) x[5]};
        int[] y1 = {(int) y[0], (int) y[1], (int) y[2], (int) y[3], (int) y[4], (int) y[5]};
        g.setColor(Color.ORANGE);
        g.drawPolygon(x1, y1, 6);
    }

    public boolean hit(Shape a){
        Polygon p=new Polygon(new int[] {(int) x[0], (int) x[1], (int) x[2], (int) x[3], (int) x[4], (int) x[5]},
                new int[] {(int) y[0], (int) y[1], (int) y[2], (int) y[3], (int) y[4], (int) y[5]},6);
        Area area=new Area(p);
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    public void fly(){
        for(int i=0;i<x.length;i++){
            x[i]+=deltax;
            y[i]+=deltay;
        }
        cx+=deltax;
        cy+=deltay;
        chongzhiasteroids();
    }
    private void chongzhiasteroids(){
        if(y[0]<0&&y[1]<0&&y[2]<0&&y[3]<0&&y[4]<0&&y[5]<0){
            for(int i=0;i<x.length;i++){
                y[i]+=Height;
            }
            cy+=Height;
        }
        else if(y[0]>Height&&y[1]>Height&&y[2]>Height&&y[3]>Height&&y[4]>Height&&y[5]>Height){
            for(int i=0;i<x.length;i++){
                y[i]-=Height;
            }
            cy-=Height;
        }
        if(x[0]<0&&x[1]<0&&x[2]<0&&x[3]<0&&x[4]<0&&x[5]<0){
            for(int i=0;i<x.length;i++){
                x[i]+=Width;
            }
            cx+=Width;
        }else if(x[0]>Width&&x[1]>Width&x[2]>Width&&x[3]>Width&x[4]>Width&&x[5]>Width){
            for(int i=0;i<x.length;i++){
                x[i]-=Width;
            }
            cx-=Width;
        }
    }
}
