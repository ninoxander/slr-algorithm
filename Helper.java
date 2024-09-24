public class Helper {
    DataSet dataSet = new DataSet();
    public Helper(DataSet _dataSet){
        this.dataSet = _dataSet;
    }
    // Calcula la sumatoria de los items de x.
    public float sumatoriaX(){
        int n = this.dataSet.getSizeX();
        float[] x = dataSet.getX();
        float resultadoSumatoria = 0;
        for (int i = 0; i < n; i++){
            // System.out.println("data x: " + x[i]);
            resultadoSumatoria+= x[i];
        }
        return resultadoSumatoria;
    }
    // Calcula la sumtaoria de los items de y.
    public float sumatoriaY(){
        float[] y = this.dataSet.getY();
        int n = this.dataSet.getSizeY();
        float resutadoSumatoria = 0;
        for (int i = 0; i < n; i++){
            resutadoSumatoria+= y[i];
        }
        return resutadoSumatoria;
    }
    // Calcula la mediana de X
    public float medianaX(){
        return this.sumatoriaX() / this.dataSet.getSizeX();
    }
    // Calcula la mediana de Y
    public float medianaY() {
        return this.sumatoriaY() / this.dataSet.getSizeY();
    }
    // Calcula el cociente de xi * yi
    public float[] multXY(){
        float[] mult = new float[this.dataSet.getSizeX()];
        float[] dataX = this.dataSet.getX();
        float[] dataY = this.dataSet.getY();
        for(int i = 0; i < this.dataSet.getSizeX(); i++){
            mult[i] = dataY[i] * dataX[i];
            //System.out.println(datay[i]+" "+dataX[i]);
        }
        return  mult;
    }
    // Calcula la sumtaoria de los cocientes xi * yi
    public float sumatoriaXY(){
        float sumatoria = 0;
        float[] mult = this.multXY();
        for(int i = 0; i < mult.length ;i++){
            sumatoria+= mult[i];
        }
        return sumatoria;
    }
    // Calcula la sumtaoria cuadrada de cada item en x
    public float sumatoriaXCuadrada() {
        float sumatoria = 0;
        float[] xcuadrada = this.dataSet.getX();
        for(int i = 0; i < this.dataSet.getSizeX(); i++){
            sumatoria += (float) Math.pow((double) xcuadrada[i], 2);
        }
        return sumatoria;
    }
    // Calcula beta 1
    float beta1() {
        float num = this.dataSet.getSizeX() * sumatoriaXY() - (sumatoriaX() * sumatoriaY());
        float den = this.dataSet.getSizeX() * sumatoriaXCuadrada() - (sumatoriaX() * sumatoriaX());
        return num / den;
    }
    // Calcula beta 2
    float beta0() {
        float num = (sumatoriaXCuadrada() * sumatoriaY()) - (sumatoriaX() * sumatoriaXY());
        float den = (this.dataSet.getSizeX() * sumatoriaXCuadrada()) - (float) (Math.pow(sumatoriaX(), 2));
        return num / den;
    }
}
