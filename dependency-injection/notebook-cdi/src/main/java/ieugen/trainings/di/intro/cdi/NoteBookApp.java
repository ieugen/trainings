package ieugen.trainings.di.intro.cdi;

import ieugen.trainings.di.intro.impl.NoteBook;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class NoteBookApp {

    public static void main(String[] args) {
        WeldContainer container = new Weld().initialize();
        NoteBook noteBook = container.instance().select(NoteBook.class).get();
        noteBook.boot();
    }
}
