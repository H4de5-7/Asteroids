package Asteroids;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.Polygon;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.io.File;
import java.net.URI;
import java.net.URL;
public class Picture extends JComponent{
    public static BufferedImage background;
    Me me=new Me();//创建一个飞机;
    Bullet []BulletArray=new Bullet[0];//创建一个子弹数组
    UFO []UFOArray=new UFO[0];//创建一个ufo数组
    Bullet []UFOBulletArray=new Bullet[0];//
    asteroids []asteroidsArray=new asteroids[0];//创建一个陨石数组
    Balldisappear []ballArray=new Balldisappear[0];
    int menuflag=0;
    int score=0;
    int scoretemp=0;
    int ufobullettime=0;
    int asteroidstime=0;
    int ufoflag=1;
    int wudinum=0;
    int life=3;
    int highest=0;
    int startflag=0;
    int addasteroidsflag=0;
    int addasteroidsnum=1;
    int yy=-1000;
    int mehuanum=0;
    int Height=Windows.HEIGHT.getValue();
    int Width=Windows.WIDTH.getValue();
    File f;
    URI uri;
    URL url;
    static{
        try{
            background = ImageIO.read(Picture.class.getResource("background1.jpg"));
        }catch(Exception e){
            e.getStackTrace();
        }
    }
    /*void Music(){//注意，java只能播放无损音质，如.wav这种格式"E:\\Studying\\Programming\\untitled\\src\\Asteroids\\The XX-Intro.wav"
        try {
            f = new File("The XX-Intro.wav"); //绝对路径
            //uri = f.toURI();
            url = f.toURL(); //解析路径
            AudioClip aau;
            aau = Applet.newAudioClip(url);
            if(aau!=null)System.out.println("not null");
            aau.play();
            aau.loop();  //单曲循环
        } catch (Exception e)
        {
            e.printStackTrace();
            }

    }*/
    public void mehua(){
        mehuanum++;
       if(mehuanum<=150){
           me.y1[0]-=1;
           me.y1[1]-=1;
           me.y1[2]-=1;
       }
    }
    public void paintComponent(Graphics g){
        if(startflag==1) {
            if(menuflag==0) {
                mehua();
                paintbackground(g);
                paintMe(g);
                paintBullet(g);
                paintScore(g);
                paintUFO(g);
                paintufobullet(g);
                paintasteroids(g);
                paintball(g);
                if (life <= 0) {
                    paintover(g);
                }
            }else{
                paintbackground(g);
                paintMenu(g);
            }
        }else if(startflag==0){
            paintbackground(g);
            paintstart(g);
        }
    }
    public void paintMe(Graphics g){
        me.draw(g);
    }
    public void paintufobullet(Graphics g){
        for(int i=0;i<UFOBulletArray.length;i++){
            UFOBulletArray[i].drawred(g);
        }
    }
    public void paintasteroids(Graphics g){
        for(int i=0;i<asteroidsArray.length;i++){
            asteroidsArray[i].draw(g);
        }
    }
    public void paintbackground(Graphics g){
        yy++;
        if(yy>=0)yy=-Height;
        g.drawImage(background, 0, yy, null);
    }
    public void paintball(Graphics g){
        for(int i=0;i<ballArray.length;i++){
            if(ballArray[i].flag==0) {
                ballArray[i].draw(g);
            }else if(ballArray[i].flag==1){
                ballArray[i].drawline(g);
            }
        }
    }
    public void paintBullet(Graphics g){//画出子弹
        for(int i=0;i<BulletArray.length;i++){
            BulletArray[i].draw(g);
        }
    }
    public void paintMenu(Graphics g) {
        int menux = 550; // x坐标
        int menuy = 200; // y坐标
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40); // 字体
        g.setColor(Color.red);
        g.setFont(font); // 设置字体
        g.drawString("Accelerate : ↑" , menux, menuy); // 画分数
        menuy += 80;
        g.drawString("Decelerate : ↓" , menux, menuy); // 画分数
        menuy += 80;
        g.drawString("Turn left : ←" , menux, menuy);
        menuy += 80;
        g.drawString("Turn right : →" ,menux, menuy); // 画命      }
        menuy += 80;
        g.drawString("Fire : Space" , menux, menuy); // 画分数
        menuy += 80;
        g.drawString("Moving to a random safe place : Shift" , menux, menuy); // 画分数
    }
    public void paintScore(Graphics g) {
        int scorex = 10; // x坐标
        int scorey = 40; // y坐标
        int scorexx=1000;
        int scoreyy=40;
        int menux=300;
        int menuy=40;
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 35); // 字体
        g.setColor(Color.red);
        g.setFont(font); // 设置字体
        g.drawString("SCORE:" + score, scorex, scorey); // 画分数
        g.drawString("HIGHEST SCORE:" + highest, scorexx, scoreyy); // 画分数
        g.drawString("MENU(ESC)" , menux, menuy);
        //g.drawString("MENU" , menux-100, menuy-30);
        scorey = scorey + 50; // y坐标增20
        g.drawString("LIFE:" + life, scorex, scorey); // 画命      }
    }
    public void paintover(Graphics g){
        int scorex = 400; // x坐标
        int scorey = 500; // y坐标
        int scorexx=400;
        int scoreyy=575;
        int scorexxx=400;
        int scoreyyy=650;
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100); // 字体
        g.setColor(Color.WHITE);
        g.setFont(font); // 设置字体
        g.drawString("GAME OVER", scorex, scorey);
        Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 50); // 字体
        g.setFont(font1); // 设置字体
        g.drawString("Your score is "+score, scorexx, scoreyy);
        Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 50); // 字体
        g.setFont(font2); // 设置字体
        g.drawString("Please press 'B' to restart", scorexxx, scoreyyy);
    }
    public void paintstart(Graphics g){
        int scorex = 400; // x坐标
        int scorey = 400; // y坐标
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 150); // 字体
        g.setColor(Color.BLUE);
        g.setFont(font); // 设置字体
        g.drawString("Asteroids", scorex, scorey);
        scorey+=60;
        scorex+=150;
        Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 50); // 字体
        g.setColor(Color.BLUE);
        g.setFont(font1); // 设置字体
        g.drawString("Press 'S' to start", scorex, scorey); // 画命      }
    }
    public void paintUFO(Graphics g){
        for(int i=0;i<UFOArray.length;i++){
            UFOArray[i].draw(g);
        }
    }
    public void ballfly(){
        for(int i=0;i<ballArray.length;i++){
            if(ballArray[i].count>=150){
                Balldisappear temp = ballArray[i];
                ballArray[i] = ballArray[ballArray.length - 1];
                ballArray[ballArray.length - 1] = temp;
                ballArray = Arrays.copyOf(ballArray, ballArray.length - 1);
            }else ballArray[i].fly();
        }
    }
    public void BulletFly() {//飞机子弹飞行
        for(int i=0;i<BulletArray.length;i++) {
            int index1=-1;
            int index2=-1;
            for (int j = 0; j < UFOArray.length; j++) {
                if (!UFOArray[j].hit(new Polygon(new int[]{(int) (BulletArray[i].x + 2), (int) (BulletArray[i].x - 2), (int) (BulletArray[i].x), (int) (BulletArray[i].x)}, new int[]{(int) (BulletArray[i].y), (int) (BulletArray[i].y), (int) (BulletArray[i].y + 2), (int) (BulletArray[i].y - 2)}, 4))) {
                    index1 = i;
                    UFO temp = UFOArray[j];
                    UFOArray[j] = UFOArray[UFOArray.length - 1];
                    UFOArray[UFOArray.length - 1] = temp;
                    UFOArray = Arrays.copyOf(UFOArray, UFOArray.length - 1);
                    //j--;
                    for(int m=0;m<4;m++) {
                        ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                        ballArray[ballArray.length - 1] = new Balldisappear(temp.cx, temp.cy);
                    }
                    score += 300;
                    scoretemp+=300;
                }
            }
            for (int k = 0; k < asteroidsArray.length; k++) {
                //double tempcx=0;double tempcy=0;
                if (!asteroidsArray[k].hit(new Polygon(new int[]{(int) (BulletArray[i].x + 2), (int) (BulletArray[i].x - 2), (int) (BulletArray[i].x), (int) (BulletArray[i].x)}, new int[]{(int) (BulletArray[i].y), (int) (BulletArray[i].y), (int) (BulletArray[i].y + 2), (int) (BulletArray[i].y - 2)}, 4))) {
                    index2 = i;
                    asteroids temp = asteroidsArray[k];
                    //tempcx=asteroidsArray[k].cx;tempcy=asteroidsArray[k].cy;
                    asteroidsArray[k] = asteroidsArray[asteroidsArray.length - 1];
                    asteroidsArray[asteroidsArray.length - 1] = temp;
                    asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length - 1);
                    for(int m=0;m<4;m++) {
                        ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                        ballArray[ballArray.length - 1] = new Balldisappear(temp.cx, temp.cy);
                    }
                    //k--;
                    if(temp.asteroidsflag==3) {
                        asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                        asteroidsArray[asteroidsArray.length - 1] = new asteroidsm(temp.cx, temp.cy);
                        asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                        asteroidsArray[asteroidsArray.length - 1] = new asteroidsm(temp.cx, temp.cy);
                        score += 300;
                        scoretemp+=300;
                    }else if(temp.asteroidsflag==2){
                        asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                        asteroidsArray[asteroidsArray.length - 1] = new asteroidsl(temp.cx, temp.cy);
                        asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                        asteroidsArray[asteroidsArray.length - 1] = new asteroidsl(temp.cx, temp.cy);
                        score += 400;
                        scoretemp+=400;
                    }else if(temp.asteroidsflag==1){
                        //System.out.println("xiao");
                        score += 500;
                        scoretemp+=500;
                    }
                }
            }
            if (index1 != -1) {
                Bullet temp = BulletArray[index1];
                BulletArray[index1] = BulletArray[BulletArray.length - 1];
                BulletArray[BulletArray.length - 1] = temp;
                BulletArray = Arrays.copyOf(BulletArray, BulletArray.length - 1);
            } else if (index2 != -1 && index1 == -1) {
                Bullet temp = BulletArray[index2];
                BulletArray[index2] = BulletArray[BulletArray.length - 1];
                BulletArray[BulletArray.length - 1] = temp;
                BulletArray = Arrays.copyOf(BulletArray, BulletArray.length - 1);
            }
        }



        for(int i=0;i<BulletArray.length;i++) {
            if (BulletArray[i].count < 850) {
                BulletArray[i].fly();
            } else {
                Bullet temp = BulletArray[i];
                BulletArray[i] = BulletArray[BulletArray.length - 1];
                BulletArray[BulletArray.length - 1] = temp;
                BulletArray = Arrays.copyOf(BulletArray, BulletArray.length - 1);
                //i--;
            }
        }
    }

    public void UFOfly() {//UFO飞行
        for(int i=0;i<UFOArray.length;i++) {
            ufobullettime++;
            if (ufobullettime % 40 == 0) {
                UFOBulletArray = Arrays.copyOf(UFOBulletArray, UFOBulletArray.length + 1);
                UFOBulletArray[UFOBulletArray.length-1]=new Bullet(UFOArray[i].cx,UFOArray[i].cy,ufoflag);
                ufoflag = (ufoflag + 2) % 12;
            }
            if (UFOArray[i].hit(new Polygon(new int[]{(int) me.x1[0], (int) me.x1[1], (int) me.x1[2]}, new int[]{(int) me.y1[0], (int) me.y1[1], (int) me.y1[2]}, 3))) {
                UFOArray[i].fly();
            } else {
                UFO temp=UFOArray[i];
                UFOArray[i]=UFOArray[UFOArray.length-1];
                UFOArray[UFOArray.length-1]=temp;
                UFOArray = Arrays.copyOf(UFOArray, UFOArray.length - 1);
                for(int m=0;m<4;m++) {
                    ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                    ballArray[ballArray.length - 1] = new Balldisappear(temp.cx, temp.cy);
                }
                for(int m=0;m<4;m++) {
                    ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                    ballArray[ballArray.length - 1] = new Balldisappear(me.cx, me.cy);
                    ballArray[ballArray.length - 1].flag=1;
                    ballArray[ballArray.length - 1].linepoint();
                }
                // i--;
                life--;
                me=new Me();
                mehuanum=0;
                mehua();
                me.wudiflag=1;
            }
        }
    }
    public void ufobulletfly() {//ufo子弹飞行
        for(int i=0;i<UFOBulletArray.length;i++){
            if (UFOBulletArray[i].hit(new Polygon(new int[]{(int) me.x1[0], (int) me.x1[1], (int) me.x1[2]}, new int[]{(int) me.y1[0], (int) me.y1[1], (int) me.y1[2]}, 3))&&UFOBulletArray[i].count<1000) {
                UFOBulletArray[i].fly();
            } else if(UFOBulletArray[i].count>=1000){
                Bullet temp=UFOBulletArray[i];
                UFOBulletArray[i]=UFOBulletArray[UFOBulletArray.length-1];
                UFOBulletArray[UFOBulletArray.length-1]=temp;
                UFOBulletArray = Arrays.copyOf(UFOBulletArray, UFOBulletArray.length - 1);
                //i--;
            }else{
                Bullet temp=UFOBulletArray[i];
                UFOBulletArray[i]=UFOBulletArray[UFOBulletArray.length-1];
                UFOBulletArray[UFOBulletArray.length-1]=temp;
                UFOBulletArray = Arrays.copyOf(UFOBulletArray, UFOBulletArray.length - 1);
                // i--;
                for(int m=0;m<4;m++) {
                    ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                    ballArray[ballArray.length - 1] = new Balldisappear(me.cx, me.cy);
                    ballArray[ballArray.length - 1].flag=1;
                    ballArray[ballArray.length - 1].linepoint();
                }
                life--;
                me=new Me();
                mehuanum=0;
                mehua();
                me.wudiflag=1;
            }
        }
    }

    public void asteroidsfly(){
        for(int i=0;i<asteroidsArray.length;i++){
            if (asteroidsArray[i].hit(new Polygon(new int[]{(int)me.x1[0],(int)me.x1[1],(int)me.x1[2]},new int[]{(int)me.y1[0],(int)me.y1[1],(int)me.y1[2]},3))) {
                asteroidsArray[i].fly();
            } else {
                asteroids temp=asteroidsArray[i];
                asteroidsArray[i]=asteroidsArray[asteroidsArray.length-1];
                asteroidsArray[asteroidsArray.length-1]=temp;
                asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length - 1);
                // i--;
                for(int m=0;m<4;m++) {
                    ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                    ballArray[ballArray.length - 1] = new Balldisappear(temp.cx, temp.cy);
                }
                for(int m=0;m<4;m++) {
                    ballArray = Arrays.copyOf(ballArray, ballArray.length + 1);
                    ballArray[ballArray.length - 1] = new Balldisappear(me.cx, me.cy);
                    ballArray[ballArray.length - 1].flag=1;
                    ballArray[ballArray.length - 1].linepoint();
                }
                if(temp.asteroidsflag==3) {
                    asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                    asteroidsArray[asteroidsArray.length - 1] = new asteroidsm(temp.cx, temp.cy);
                    asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                    asteroidsArray[asteroidsArray.length - 1] = new asteroidsm(temp.cx, temp.cy);
                }else if(temp.asteroidsflag==2){
                    asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                    asteroidsArray[asteroidsArray.length - 1] = new asteroidsl(temp.cx, temp.cy);
                    asteroidsArray = Arrays.copyOf(asteroidsArray, asteroidsArray.length + 1);
                    asteroidsArray[asteroidsArray.length - 1] = new asteroidsl(temp.cx, temp.cy);
                }else if(temp.asteroidsflag==1){

                }
                life--;
                me=new Me();
                mehuanum=0;
                mehua();
                me.wudiflag=1;
            }
        }

    }


    public void addasteroids(){
            if (addasteroidsflag == 0) {
                asteroidsArray = Arrays.copyOf(asteroidsArray, addasteroidsnum);
                for (int i = 0; i < asteroidsArray.length; i++) {
                    asteroidsArray[i] = new asteroids();
                }
                addasteroidsflag = 1;
                addasteroidsnum += 1;
            } else {
                asteroidstime++;
                if (asteroidstime % 1500 == 0) {
                    UFOArray = Arrays.copyOf(UFOArray, UFOArray.length + 1);
                    UFOArray[UFOArray.length - 1] = new UFO();
                    //System.out.println(asteroidsArray.length);
                    // for(int i=0;i<asteroidsArray.length;i++){
                    //System.out.print(asteroidsArray[i].asteroidsflag+" ");
                    //}System.out.println("");
                }
            }
            if (asteroidsArray.length == 0 && UFOArray.length == 0) {
                addasteroidsflag = 0;
            }
    }

    public void addlife(){
        if(scoretemp>=10000){
            life++;
            scoretemp-=10000;
        }
    }

    public void shanxian(){
        int shanxianflag=0;
        double mecx=0;
        double mecy=0;
        while(true){
            shanxianflag=0;
            mecx=Math.random()*1400;
            mecy=Math.random()*750;
            for(int i=0;i<asteroidsArray.length;i++){
                if(!asteroidsArray[i].hit((new Polygon(new int[]{(int)mecx,(int)mecx-15,(int)mecx+15},new int[]{(int)mecy-25,(int)mecy+15,(int)mecy+15},3)))){
                    shanxianflag=1;
                }
            }
            for(int i=0;i<UFOArray.length;i++){
                if(!UFOArray[i].hit((new Polygon(new int[]{(int)mecx,(int)mecx-15,(int)mecx+15},new int[]{(int)mecy-25,(int)mecy+15,(int)mecy+15},3)))){
                    shanxianflag=1;
                }
            }
            for(int i=0;i<UFOBulletArray.length;i++){
                if(!UFOBulletArray[i].hit((new Polygon(new int[]{(int)mecx,(int)mecx-15,(int)mecx+15},new int[]{(int)mecy-25,(int)mecy+15,(int)mecy+15},3)))){
                    shanxianflag=1;
                }
            }
            if(shanxianflag==0)break;
        }
        me=new Me();
        me.cx=mecx;
        me.cy=mecy;
        me.x1[0]=me.cx;me.x1[1]=me.cx-15;me.x1[2]=me.cx+15;
        me.y1[0]=me.cy-25;me.y1[1]=me.cy+15;me.y1[2]=me.cy+15;
    }


    public void action() {//执行画布的操作
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {//每次需要执行的代码放到这里面
                if (startflag == 1) {
                    if (menuflag == 1) {
                        repaint();
                    } else {
                        if (me.wudiflag == 1) {
                            wudinum++;
                            addasteroids();
                            for (int i = 0; i < asteroidsArray.length; i++) asteroidsArray[i].fly();
                            for (int i = 0; i < UFOArray.length; i++) UFOArray[i].fly();
                            for (int i = 0; i < UFOBulletArray.length; i++) UFOBulletArray[i].fly();
                            for (int i = 0; i < BulletArray.length; i++) BulletArray[i].fly();
                            for (int i = 0; i < ballArray.length; i++) ballArray[i].fly();
                            repaint();
                            if (wudinum >= 120 && life > 0) {
                                me.wudiflag = 0;
                                wudinum = 0;
                            }
                        } else {
                            addlife();
                            addasteroids();
                            me.fly();//更新飞机的状态
                            BulletFly();//更新飞机射出去的子弹
                            ufobulletfly();//更新ufo射出去的子弹
                            UFOfly();//更新ufo的状态
                            ballfly();
                            asteroidsfly();
                            repaint();//实时更新
                        }
                    }
                    }else{
                        repaint();
                }

            }
        };
        timer.schedule(task,0,10);
    }
}

