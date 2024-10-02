package src;

public class DiscreteMath {
    private DataSet dataSet;
    public float QuadT, t, varB0, varB1;
    public float B0StandError, B1StandError;
    public float SRC, SEC, STC;
    public float RSquared, R;
    public float MCX;

    // Constructor
    public DiscreteMath(DataSet _dataSet) {
        this.dataSet = _dataSet;
    }

    // Function to get the sum of given array items
    public float getSum(float[] data) {
        float sum = 0;
        for (float v : data) {
            sum += v;
        }
        return sum;
    }

    // Get x sum
    public float getXSum() {
        return getSum(dataSet.getX());
    }

    // Get y sum
    public float getYSum() {
        return getSum(dataSet.getY());
    }

    // Get average of x
    public float getMaX() {
        return getXSum() / dataSet.getSizeX();
    }

    // Get average of y
    public float getMaY() {
        return getYSum() / dataSet.getSizeY();
    }

    // Get xi (original x values)
    public float[] getXi() {
        return dataSet.getX(); // Simplemente devolver los valores originales
    }

    // Get yi (original y values)
    public float[] getYi() {
        return dataSet.getY(); // Simplemente devolver los valores originales
    }

    // Get xi * yi
    public float[] getXI() {
        float[] dataX = dataSet.getX();
        float[] dataY = dataSet.getY();
        float[] mult = new float[dataSet.getSizeX()];

        for (int i = 0; i < dataSet.getSizeX(); i++) {
            mult[i] = dataY[i] * dataX[i];
        }
        return mult;
    }

    // Get xi * yi sum
    public float getXYSum() {
        return getSum(getXI());
    }

    // Get quad x
    public float[] getQuadX() {
        float[] quadx = new float[dataSet.getSizeX()];
        float[] x = dataSet.getX();
        for (int i = 0; i < dataSet.getSizeX(); i++) {
            quadx[i] = x[i] * x[i];
        }
        return quadx;
    }

    // Get quad x sum
    public float getQuadXSum() {
        return getSum(getQuadX());
    }

    // Get beta 1
    public float getBeta1() {
        float num = this.dataSet.getSizeX() * getXYSum() - (getXSum() * getYSum());
        float den = this.dataSet.getSizeX() * getQuadXSum() - (getXSum() * getXSum());
        return num / den;
    }

    // Get beta 0
    public float getBeta0() {
        return getMaY() - getBeta1() * getMaX();
    }

    // Get y sample
    public float[] getYBar() {
        float[] ysample = new float[this.dataSet.getSizeX()];
        float[] xi = this.getXi();
        float beta0 = getBeta0();
        float beta1 = getBeta1();

        for (int i = 0; i < this.dataSet.getSizeX(); i++) {
            ysample[i] = beta0 + beta1 * xi[i]; // Usar los valores originales de xi
        }
        return ysample;
    }

    // Get ui
    public float[] getUI() {
        float[] ui = new float[dataSet.getSizeX()];
        float[] ym = getYBar();
        float[] y = dataSet.getY();

        for (int i = 0; i < dataSet.getSizeX(); i++) {
            ui[i] = y[i] - ym[i];
        }
        return ui;
    }

    // Get quad ui
    public float[] getQuadUI() {
        float[] ui = getUI();
        float[] quadUI = new float[dataSet.getSizeX()];
        for (int i = 0; i < dataSet.getSizeX(); i++) {
            quadUI[i] = ui[i] * ui[i];
        }
        return quadUI;
    }

    // Linear Regression
    public void linearRegression() {
        // Sums
        int size = this.dataSet.getSizeX();
        float sumxi = this.getSum(this.getXI());
        float sumyi = this.getSum(this.getYi());
        float sumx2 = this.getSum(this.getQuadX());
        float sumym = this.getSum(this.getYBar());
        float sumui = this.getSum(this.getUI());
        float sumqu = this.getSum(this.getQuadUI());

        // Calculate coefficients
        this.QuadT = sumqu / (size - 2);
        this.t = (float) Math.sqrt((double) this.QuadT);

        // Coefficients
        float beta1 = getBeta1();
        float beta0 = getBeta0();

        this.B1StandError = (float) Math.sqrt((this.QuadT / (size - 2)) / (this.getQuadXSum() - ((getXSum() * getXSum()) / size)));
        this.B0StandError = (float) Math.sqrt((this.QuadT / (size - 2)) * (1.0 / size + (getMaX() * getMaX()) / (this.getQuadXSum() - ((getXSum() * getXSum()) / size))));

        this.SRC = sumqu;
        // System.out.println("!!!!!!!!! debug"  + this.SRC);
        this.SEC = (beta1 * beta1) * sumx2;
        this.STC = this.SEC + this.SRC;
        this.RSquared = 1 - (this.SRC / this.STC);
        this.R = (float) Math.sqrt((double) this.RSquared);
        this.MCX = (float) Math.sqrt((double) ((sumx2 - this.getQuadXSum()) / size));
    }
}
