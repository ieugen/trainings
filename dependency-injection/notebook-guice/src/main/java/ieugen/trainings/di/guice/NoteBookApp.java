package ieugen.trainings.di.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ieugen.trainings.di.notebook.impl.NoteBook;

public class NoteBookApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ModernNoteBookModule());

        NoteBook noteBook = injector.getInstance(NoteBook.class);
        noteBook.boot();
    }
}
