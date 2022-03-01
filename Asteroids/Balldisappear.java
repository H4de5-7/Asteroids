package Asteroids;
import java.awt.*;
import java.awt.Graphics;
public class Balldisappear {
    double MIN_SPEED=1;
    double MAX_SPEED=2;
    double x=0,y=0;
    int speed=3 ;
    int count=0;
    double speedy=0;
    double speedx=0;
    int flag=0;
    double []xl={20,50};
    double []yl={20,50};
    Balldisappear(double x,double y){
        this.speedx=MIN_SPEED+Math.random()*(MAX_SPEED-MIN_SPEED);
        this.speedy=MIN_SPEED+Math.random()*(MAX_SPEED-MIN_SPEED);
        this.x=x;
        this.y=y;
        if(Math.random()<=0.5){
            speedx=-speedx;
        }
        if(Math.random()<=0.5){
            speedy=-speedy;
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval((int)x, (int)y, 5, 5);
    }
    public void linepoint(){
        for(int i=0;i<xl.length;i++){
            xl[i]+=x;
            yl[i]+=y;
        }
    }
    public void drawline(Graphics g){
        g.setColor(Color.GREEN);
        g.drawPolyline(new int[]{(int)xl[0],(int)xl[1]}, new int[]{(int)yl[0],(int)yl[1]},2);
    }
    public void fly(){
        y+=speedy;
        x+=speedx;
        count+=speed;
        for(int i=0;i<xl.length;i++){
            xl[i]+=speedx;
            yl[i]+=speedy;
        }
    }
}
