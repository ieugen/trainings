package ieugen.trainings.di.guice;

import com.google.inject.AbstractModule;
import ieugen.trainings.di.intro.api.Battery;
import ieugen.trainings.di.intro.api.Computer;
import ieugen.trainings.di.intro.api.Display;
import ieugen.trainings.di.intro.api.Keyboard;
import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.LedKeyboard;
import ieugen.trainings.di.intro.impl.NoteBook;
import ieugen.trainings.di.intro.impl.RetinaDisplay;

public class ModernNoteBookModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(Keyboard.class).to(LedKeyboard.class);
        bind(Display.class).to(RetinaDisplay.class);
        bind(Battery.class).to(DefaultBattery.class);
        bind(Computer.class).to(NoteBook.class);
    }
}
