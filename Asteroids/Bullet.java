package Asteroids;
import java.awt.*;
import java.awt.geom.Area;
public class Bullet {
    double x=0,y=0;
    int speed=9 ;
    int count=0;
    int flagbullet=0;
    double speedx=0;
    double speedy=0;
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
   // public Bullet(double xc,double yc,double mexc,double meyc){
    //    this.x=xc;
    //    this.y=yc;
     //   this.mex=mexc;
      //  this.mey=meyc;
  //  }
    public Bullet(double x,double y,int flag){
        this.x=x;
        this.y=y;
        this.flagbullet=flag;
        if(flagbullet==0)speedy-=speed;
        else if(flagbullet==1){speedy-=0.866*speed;speedx+=0.5*speed;}
        else if(flagbullet==2){speedy-=0.5*speed;speedx+=0.866*speed;}
        else if(flagbullet==3)speedx+=speed;
            //  k=(mey-y)/(mex-x);
        else if(flagbullet==4){speedy+=0.5*speed;speedx+=0.866*speed;}
        else if(flagbullet==5){speedy+=0.866*speed;speedx+=0.5*speed;}
        else if(flagbullet==6)speedy+=speed;
        else if(flagbullet==7){speedy+=0.866*speed;speedx-=0.5*speed;}
        else if(flagbullet==8){speedy+=0.5*speed;speedx-=0.866*speed;}
        else if(flagbullet==9)speedx-=speed;
        else if(flagbullet==10){speedy-=0.5*speed;speedx-=0.866*speed;}
        else if(flagbullet==11){speedy-=0.866*speed;speedx-=0.5*speed;}
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)x, (int)y, 4, 4);
    }
    public void drawred(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, 10, 10);
    }
    public void fly(){
        y+=speedy;
        x+=speedx;
        count+=speed;
        chongzhibullet();
    }
    public void setterx(int x){
        this.x=x;
    }
    public void settery(int y){
        this.y=y;
    }
    public  boolean hit(Shape p) {
        Rectangle a = new Rectangle((int)x, (int)y, 1, 1);
        Area area=new Area(p);;
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    private void chongzhibullet(){
        if(x<0){
            x+=Width;
        }else if(x>Width){
            x-=Width;
        }
        if(y<0){
            y+=Height;
        }else if(y>Height){
            y-=Height;
        }
    }

}
