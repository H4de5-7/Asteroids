package Asteroids;
import java.awt.*;
import java.awt.geom.Area;
public class Me  {
    double []x1={750,735,765};
    double []y1={710,750,750};
    double cx=750;double cy=585;
    int flag=0;
    double angle=0,angle1=45,angle2=45,L=25,L1=21.21;
    double deltaAngle=30;
    double speedx=0;
    double speedy=0;
    int wudiflag=0;
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    //private int life=0;
    public Me(){

    }
    //public int getLife(){
     //   return life;
   // }
   // public void addLife(){
     //   life++;
   // }
   // public void minusLife(){
    //    life--;
   // }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillPolygon (new int[]{(int)x1[0],(int)x1[1],(int)x1[2]},new int[]{(int)y1[0],(int)y1[1],(int)y1[2]},3);
        //bulletlist创建子弹list；
        //在这里把bulletlist里的每个Node都遍历一遍把位置paint

    }
    public void drawwudi(Graphics g){
        g.setColor(Color.BLUE);
        int []x={(int)x1[0],(int)x1[1],(int)x1[2]};
        int []y={(int)y1[0],(int)y1[1],(int)y1[2]};
        g.drawPolygon(x,y,3);
        //bulletlist创建子弹list；
        //在这里把bulletlist里的每个Node都遍历一遍把位置paint

    }
    public void addspeed(){
        if(flag==0)speedy-=0.2;
        else if(flag==1){speedy-=0.173;speedx+=0.1;}
        else if(flag==2){speedy-=0.1;speedx+=0.173;}
        else if(flag==3)speedx+=0.2;
        else if(flag==4){speedy+=0.1;speedx+=0.173;}
        else if(flag==5){speedy+=0.173;speedx+=0.1;}
        else if(flag==6)speedy+=0.2;
        else if(flag==7){speedy+=0.173;speedx-=0.1;}
        else if(flag==8){speedy+=0.1;speedx-=0.173;}
        else if(flag==9)speedx-=0.2;
        else if(flag==10){speedy-=0.1;speedx-=0.173;}
        else if(flag==11){speedy-=0.173;speedx-=0.1;}
    }
    public void minusspeed(){
        if(flag==0)speedy+=0.2;
        else if(flag==1){speedy+=0.173;speedx-=0.1;}
        else if(flag==2){speedy+=0.1;speedx-=0.173;}
        else if(flag==3)speedx-=0.2;
        else if(flag==4){speedy-=0.1;speedx-=0.173;}
        else if(flag==5){speedy-=0.173;speedx-=0.1;}
        else if(flag==6)speedy-=0.2;
        else if(flag==7){speedy-=0.173;speedx+=0.1;}
        else if(flag==8){speedy-=0.1;speedx+=0.173;}
        else if(flag==9)speedx+=0.2;
        else if(flag==10){speedy+=0.1;speedx+=0.173;}
        else if(flag==11){speedy+=0.173;speedx+=0.1;}
    }
    public void fly(){
        cx+=speedx;
        cy+=speedy;
        for(int i=0;i<3;i++){
            y1[i]+=speedy;
            x1[i]+=speedx;
            //System.out.println("sb");
        }
        if(speedx<=-10)speedx=-10;
        if(speedx>=10)speedx=10;
        if(speedy<=-10)speedy=-10;
        if(speedy>=10)speedy=10;
        chongzhi();
    }
    public void rotateLeft(){
        flag=(flag-1)%12;
        if(flag<0)flag+=12;
        angle = (deltaAngle + angle)%360;
        x1[0] = cx-Math.sin(angle*Math.PI/180) * L;
        y1[0] = cy-Math.cos(angle*Math.PI/180) * L;
        angle2=(angle2-deltaAngle)%360;
        angle1=(angle1+deltaAngle)%360;
        x1[1] = cx-Math.cos(angle1*Math.PI/180) * L1;//75
        y1[1] = cy+Math.sin(angle1*Math.PI/180) * L1;//75
        x1[2] = cx+Math.cos(angle2*Math.PI/180) * L1;//15
        y1[2] = cy+Math.sin(angle2*Math.PI/180) * L1;//15
    }
    public void rotateRight(){
        flag=(flag+1)%12;
        angle = (-deltaAngle + angle)%360;
        x1[0] = cx-Math.sin(angle*Math.PI/180) * L;
        y1[0] = cy-Math.cos(angle*Math.PI/180) * L;
        angle2=(angle2+deltaAngle)%360;
        angle1=(angle1-deltaAngle)%360;
        x1[1] = cx-Math.cos(angle1*Math.PI/180) * L1;//75
        y1[1] = cy+Math.sin(angle1*Math.PI/180) * L1;//75
        x1[2] = cx+Math.cos(angle2*Math.PI/180) * L1;//15
        y1[2] = cy+Math.sin(angle2*Math.PI/180) * L1;//15
    }
    public boolean hit(Shape a){
        Polygon p=new Polygon(new int[]{(int)x1[0],(int)x1[1],(int)x1[2]},new int[]{(int)y1[0],(int)y1[1],(int)y1[2]},3);
        Area area=new Area(p);
        area.intersect(new Area(a));
        return area.isEmpty();
    }
    public void meback(){
        this.x1[0]=150;this.x1[1]=135;this.x1[2]=165;
        this.y1[0]=110;this.y1[1]=150;this.y1[2]=150;
        this.cx=150;this.cy=135;
    }
    public void chongzhi(){
        if(y1[0]<0&&y1[1]<0&&y1[2]<0){
            y1[0]+=Height;
            y1[1]+=Height;
            y1[2]+=Height;
        }else if(y1[0]>Height&&y1[1]>Height&&y1[2]>Height){
            y1[0]-=Height;
            y1[1]-=Height;
            y1[2]-=Height;
        }
        if(x1[0]<0&&x1[1]<0&&x1[2]<0){
            x1[0]+=Width;
            x1[1]+=Width;
            x1[2]+=Width;
        }else if(x1[0]>Width&&x1[1]>Width&x1[2]>Width){
            x1[0]-=Width;
            x1[1]-=Width;
            x1[2]-=Width;
        }
    }

}
