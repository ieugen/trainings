package ieugen.trainings.di.manual;

import ieugen.trainings.di.notebook.api.Computer;
import ieugen.trainings.di.notebook.impl.DefaultBattery;
import ieugen.trainings.di.notebook.impl.LedKeyboard;
import ieugen.trainings.di.notebook.impl.NoteBook;
import ieugen.trainings.di.notebook.impl.NoteBookClassic;
import ieugen.trainings.di.notebook.impl.RetinaDisplay;

public class DependencyInjectionMain {

    public static void main(String[] args) {

        System.out.println("Booting the classic notebook");
        Computer classic = new NoteBookClassic();
        classic.boot();

        // Notice that we manually inject the required dependencies in our object before use.
        System.out.println("Booting the modern DI notebook");
        Computer modern = new NoteBook(new DefaultBattery(), new RetinaDisplay(), new LedKeyboard());
        modern.boot();

    }
}
