package di.spring.testing.model;

public class DevBar implements IBar {

    private String message = "Profilul DEV este activ.";

    @Override
    public String doIt() {
        // we don't do heavy computation here
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
