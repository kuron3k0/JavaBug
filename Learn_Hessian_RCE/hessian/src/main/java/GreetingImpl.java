
public class GreetingImpl implements GreetingAPI {

    private String _greeting = "Hello, world";

    public GreetingImpl() {
    }

    public void setGreeting(String greeting) {
        this._greeting = greeting;
    }

    public String greeting() {
        return this._greeting;
    }

    public String hello() {
        return this._greeting;
    }
}
