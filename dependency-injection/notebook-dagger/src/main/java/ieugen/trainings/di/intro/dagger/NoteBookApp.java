package ieugen.trainings.di.intro.dagger;

import dagger.ObjectGraph;
import ieugen.trainings.di.intro.api.Computer;

public class NoteBookApp {

    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(ModernNoteBookModule.class);

        Computer noteBook = objectGraph.get(Computer.class);
        noteBook.boot();
    }
}
