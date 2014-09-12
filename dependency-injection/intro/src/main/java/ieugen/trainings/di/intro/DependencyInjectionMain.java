package ieugen.trainings.di.intro;

import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.LedKeyboard;
import ieugen.trainings.di.intro.impl.NoteBook;
import ieugen.trainings.di.intro.impl.NoteBookClassic;
import ieugen.trainings.di.intro.impl.RetinaDisplay;

public class DependencyInjectionMain {

    public static void main(String[] args) {

        System.out.println("Booting the classic notebook");
        NoteBookClassic classic = new NoteBookClassic();
        classic.boot();

        // Notice that we manually inject the required dependencies in our object before use.
        System.out.println("Booting the modern DI notebook");
        NoteBook modern = new NoteBook(new DefaultBattery(), new RetinaDisplay(), new LedKeyboard());
        modern.boot();

    }
}
