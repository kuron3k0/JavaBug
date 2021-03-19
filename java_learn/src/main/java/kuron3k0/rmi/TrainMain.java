package kuron3k0.rmi;


import java.rmi.Naming;

public class TrainMain {
    public static void main(String[] args) throws Exception {
        RMIServer.IRemoteHelloWorld hello = (RMIServer.IRemoteHelloWorld) Naming.lookup("rmi://127.0.0.1:1099/Hello");
        String ret = hello.hello();
        System.out.println( ret);
    }
}

