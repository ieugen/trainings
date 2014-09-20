package persistence.simple.spring.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Settings {

    private boolean fooEnabled;
    private String message;

    public boolean isFooEnabled() {
        return fooEnabled;
    }

    public void setFooEnabled(boolean fooEnabled) {
        this.fooEnabled = fooEnabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
