package Asteroids;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Area;
import java.awt.Polygon;
import java.awt.Shape;
public class UFO {
    static double MAX_SPEED=3.5;
    static double MIN_SPEED=1;
    double deltax=0;
    double deltay=0;
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    double cx=Math.random()*Width,cy=Math.random()*Height;
    double []x={-25,-20,-15,-15,15,15,20,25,20,-20};
    double []y={0,-15,-15,-25,-25,-15,-15,0,15,15};

    UFO(){
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
        for(int i=0;i<10;i++){
            x[i]+=cx;
            y[i]+=cy;
        }
    }
    public void draw(Graphics g) {
        int[] x1 = {(int) x[0], (int) x[1], (int) x[2], (int) x[3], (int) x[4], (int) x[5], (int) x[6], (int) x[7], (int) x[8], (int) x[9]};
        int[] y1 = {(int) y[0], (int) y[1], (int) y[2], (int) y[3], (int) y[4], (int) y[5], (int) y[6], (int) y[7], (int) y[8], (int) y[9]};
        g.setColor(Color.CYAN);
        g.drawPolygon(x1, y1, 10);
    }
    public void fly(){
        for(int i=0;i<10;i++){
            x[i]+=deltax;
            y[i]+=deltay;
        }
        cx+=deltax;
        cy+=deltay;
        if(cx<0)cx+=Width;
        else if(cx>Width)cx-=Width;
        if(cy<0)cy+=Height;
        else if(cy>Height)cy-=Height;
        chongzhiUFO();
    }
    public boolean hit(Shape a){
        Polygon p=new Polygon(new int[] {(int) x[0], (int) x[1], (int) x[2], (int) x[3], (int) x[4], (int) x[5], (int) x[6], (int) x[7], (int) x[8], (int) x[9]},
        new int[] {(int) y[0], (int) y[1], (int) y[2], (int) y[3], (int) y[4], (int) y[5], (int) y[6], (int) y[7], (int) y[8], (int) y[9]},10);
        Area area=new Area(p);
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    public void chongzhiUFO(){
        if(y[0]<0&&y[1]<0&&y[2]<0&&y[3]<0&&y[4]<0&&y[5]<0&&y[6]<0&&y[7]<0&&y[8]<0&&y[9]<0){
            for(int i=0;i<10;i++){
                y[i]+=Height;
            }
        }else if(y[0]>Height&&y[1]>Height&&y[2]>Height&&y[3]>Height&&y[4]>Height&&y[5]>Height&&y[6]>Height&&y[7]>Height&&y[8]>Height&&y[9]>Height){
            for(int i=0;i<10;i++){
                y[i]-=Height;
            }
        }
        if(x[0]<0&&x[1]<0&&x[2]<0&&x[3]<0&&x[4]<0&&x[5]<0&&x[6]<0&&x[7]<0&&x[8]<0&&x[9]<0){
            for(int i=0;i<10;i++){
                x[i]+=Width;
            }
        }else if(x[0]>Width&&x[1]>Width&x[2]>Width&&x[3]>Width&x[4]>Width&&x[5]>Width&x[6]>Width&&x[7]>Width&x[8]>Width&&x[9]>Width){
            for(int i=0;i<10;i++){
                x[i]-=Width;
            }
        }
    }
}
