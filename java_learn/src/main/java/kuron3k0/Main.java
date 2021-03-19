package kuron3k0;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            //Class.forName("com.kuron3k0.TrainPrint");
          //  Class clazz = Class.forName("java.lang.Runtime");

          //  Runtime runtime= (Runtime)clazz.getMethod("getRuntime").invoke(clazz);

          ///  clazz.getMethod("exec",String.class).invoke(runtime,"calc.exe");


            Class clazz = Class.forName("java.lang.ProcessBuilder");

            //Class.forName("java.lang.Array").newInstance(Class.forName("java.lang.String"),1);
            clazz.getMethod("start").invoke(clazz.getConstructor(String[].class).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
