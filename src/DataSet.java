package src;

public class DataSet {
    private float[] x = {23,26,30,34,43,48,52,57,58};
    private float[] y = {651,762,856,1063,1190,1298,1421,1440,1518};

    public int getSizeX(){
        return this.x.length;
    }
    public int getSizeY(){
        return  this.y.length;
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
