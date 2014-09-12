package ieugen.trainings.di.notebook.cdi;

import ieugen.trainings.di.notebook.api.Computer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class NoteBookApp {

    public static void main(String[] args) {
        WeldContainer container = new Weld().initialize();
        Computer noteBook = container.instance().select(Computer.class).get();
        noteBook.boot();
    }
}
