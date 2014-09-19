package di.spring.testing.model;

public class ProductionBarImpl implements IBar {

    public static final String MESSAGE = "Salut. Tocmai am apelat resurse externe " +
            "și costisitoare de pe mediul de productie.";

    @Override
    public String doIt() {
        System.out.println(MESSAGE);
        return MESSAGE;
    }
}
