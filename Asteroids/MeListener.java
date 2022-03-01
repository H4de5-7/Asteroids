package Asteroids;


import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
public class MeListener  implements KeyListener,MouseListener {
    private Picture picture;

    public MeListener(Picture p) {
        picture = p;
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mousePressed(MouseEvent e) {
        //if(e.getButton() == MouseEvent.BUTTON1) {
            //if(e.getX()<300&&e.getY()>10&&e.getX()>200&&e.getY()<40)
            //System.out.println("s");
            //  }

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_S){
            picture.startflag=1;
       }
       if(picture.startflag==1){
           if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
               picture.menuflag=(picture.menuflag+1)%2;
           }
       }
       if(picture.startflag==1&&picture.mehuanum>150) {
            if (picture.me.wudiflag != 1&&picture.menuflag==0) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    picture.me.rotateLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    picture.me.rotateRight();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    picture.me.addspeed();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    picture.me.minusspeed();
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    picture.BulletArray = Arrays.copyOf(picture.BulletArray, picture.BulletArray.length + 1);
                    picture.BulletArray[picture.BulletArray.length - 1] = new Bullet(picture.me.x1[0] - 2, picture.me.y1[0] - 2, picture.me.flag);
                    //在bulletlist添加一个Node
                } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    picture.shanxian();
                }
                picture.repaint();
            }
            if (picture.life <= 0) {
                picture.life=0;
                if (e.getKeyCode() == KeyEvent.VK_B) {
                    if (picture.score > picture.highest) picture.highest = picture.score;
                    picture.BulletArray = new Bullet[0];//创建一个子弹数组
                    picture.UFOArray = new UFO[0];//创建一个ufo数组
                    picture.UFOBulletArray = new Bullet[0];//创建一个ufo子弹数组
                    picture.asteroidsArray = new asteroids[0];//创建一个陨石数组
                    picture.ballArray = new Balldisappear[0];
                    picture.me = new Me();
                    picture.score = 0;
                    picture.ufobullettime = 0;
                    picture.asteroidstime = 0;
                    picture.ufoflag = 1;
                    picture.wudinum = 0;
                    picture.life = 3;
                    picture.scoretemp = 0;
                    picture.addasteroidsflag=0;
                    picture.addasteroidsnum=1;
                    picture.yy=-1000;
                    picture.mehuanum=0;
                }
            }
        }

            //实时更新
        }
}
