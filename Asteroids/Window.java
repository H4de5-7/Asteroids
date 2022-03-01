package Asteroids;
import javax.swing.*;
import java.awt.event.*;

public class Window {
    public static void main(String[] args) {
        int Height=Windows.HEIGHT.getValue();
        int Width=Windows.WIDTH.getValue();
        JFrame window = new JFrame();
        window.setSize(Width, Height);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Picture pic = new Picture();
        window.add(pic);
        MeListener ll = new MeListener(pic);
        window.addKeyListener(ll);
        window.setVisible(true);
        //pic.Music();
        pic.action();
    }
}
