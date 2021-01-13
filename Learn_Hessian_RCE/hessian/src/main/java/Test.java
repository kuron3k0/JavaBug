//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import com.caucho.hessian.client.HessianProxyFactory;

public class Test {
    public Test() {
    }

    public static void main(String[] args) throws Exception {
        sendToBp();
    }

    public static void sendToBp() throws Exception {
       // System.setProperty("http.proxyHost", "127.0.0.1");
       // System.setProperty("http.proxyPort", "8888");
        String url = "http://127.0.0.1:8080/hessian/hessiantest";
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setOverloadEnabled(true);
        GreetingAPI basic = (GreetingAPI)factory.create(GreetingAPI.class, url);
        basic.hello();
    }
}
