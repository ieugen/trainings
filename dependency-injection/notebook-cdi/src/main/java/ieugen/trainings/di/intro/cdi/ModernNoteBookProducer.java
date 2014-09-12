package ieugen.trainings.di.intro.cdi;

import ieugen.trainings.di.intro.api.Battery;
import ieugen.trainings.di.intro.api.Display;
import ieugen.trainings.di.intro.api.Keyboard;
import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.LedKeyboard;
import ieugen.trainings.di.intro.impl.NoteBook;
import ieugen.trainings.di.intro.impl.RetinaDisplay;

import javax.enterprise.inject.Produces;

public class ModernNoteBookProducer {

    @Produces
    public NoteBook createNoteBook(Battery battery, Display display, Keyboard keyboard) {
        return new NoteBook(battery, display, keyboard);
    }

    @Produces
    public Battery defaultBattery() {
        return new DefaultBattery();
    }

    @Produces
    public RetinaDisplay retinaDisplay() {
        return new RetinaDisplay();
    }

    @Produces
    public LedKeyboard ledKeyboard() {
        return new LedKeyboard();
    }

}
