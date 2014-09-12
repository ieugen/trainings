package ieugen.trainings.di.intro;

import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.LedKeyboard;
import ieugen.trainings.di.intro.impl.RetinaDisplay;

public class Main {

    public static void main(String[] args) {

        System.out.println("Booting the classic notebook");

        NoteBookClassic classic = new NoteBookClassic();
        classic.boot();

        System.out.println("Booting the modern DI notebook");
        NoteBookDI modern = new NoteBookDI(new DefaultBattery(), new RetinaDisplay(), new LedKeyboard());
        modern.boot();

    }
}
