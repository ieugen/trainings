package ieugen.trainings.di.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ieugen.trainings.di.notebook.api.Computer;

public class NoteBookApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ModernNoteBookModule());

        Computer noteBook = injector.getInstance(Computer.class);
        noteBook.boot();
    }
}
