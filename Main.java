public class Main {
    public static void main (String[] args){
        DataSet data = new DataSet();
        Helper helper = new Helper(data);
        // Betas
        System.out.println("Beta 0 : " + helper.beta0());
        System.out.println("Beta 1 : " + helper.beta1());

        // Testing out: forecast and known data.
        float[] forecastdata = {55, 60, 65, 125, 340, 1200};

        for(int i = 0; i < forecastdata.length; i++){ // Forecast
            System.out.println(forecastdata[i] + ") " + (helper.beta1() * forecastdata[i]));
        }
    }
}
