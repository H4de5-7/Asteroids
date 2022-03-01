package Asteroids;

public enum Windows{
    HEIGHT(1000),WIDTH(1600);
    private int Value;
    private Windows(int rv){
        this.Value=rv;
    }
    public int getValue(){
        return Value;
    }

}
