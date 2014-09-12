package ieugen.trainings.di.notebook.dagger;

import dagger.Module;
import dagger.Provides;
import ieugen.trainings.di.notebook.api.Computer;
import ieugen.trainings.di.notebook.impl.DefaultBattery;
import ieugen.trainings.di.notebook.impl.LedKeyboard;
import ieugen.trainings.di.notebook.impl.NoteBook;
import ieugen.trainings.di.notebook.impl.RetinaDisplay;

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
