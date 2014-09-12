package ieugen.trainings.di.notebook.cdi;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;
import ieugen.trainings.di.notebook.impl.DefaultBattery;
import ieugen.trainings.di.notebook.impl.LedKeyboard;
import ieugen.trainings.di.notebook.impl.NoteBook;
import ieugen.trainings.di.notebook.impl.RetinaDisplay;

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
