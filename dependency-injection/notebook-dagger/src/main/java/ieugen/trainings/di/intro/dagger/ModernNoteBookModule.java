package ieugen.trainings.di.intro.dagger;

import dagger.Module;
import dagger.Provides;
import ieugen.trainings.di.intro.api.Computer;
import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.LedKeyboard;
import ieugen.trainings.di.intro.impl.NoteBook;
import ieugen.trainings.di.intro.impl.RetinaDisplay;

@Module(
        injects = Computer.class
)
public class ModernNoteBookModule {

    @Provides
    public Computer modernNoteBook(DefaultBattery battery, RetinaDisplay display, LedKeyboard keyboard) {
        return new NoteBook(battery, display, keyboard);
    }

    @Provides
    public RetinaDisplay retinaDisplay() {
        return new RetinaDisplay();
    }

    @Provides
    public LedKeyboard ledKeyboard() {
        return new LedKeyboard();
    }

    @Provides
    public DefaultBattery defaultBattery() {
        return new DefaultBattery();
    }

}
