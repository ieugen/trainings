package ieugen.trainings.di.intro;

import ieugen.trainings.di.intro.api.Battery;
import ieugen.trainings.di.intro.api.Computer;
import ieugen.trainings.di.intro.api.Display;
import ieugen.trainings.di.intro.api.Keyboard;
import ieugen.trainings.di.intro.impl.DefaultBattery;
import ieugen.trainings.di.intro.impl.DefaultDisplay;
import ieugen.trainings.di.intro.impl.USKeyboard;

public class NoteBookClassic implements Computer {

    private Battery battery;
    private Display display;
    private Keyboard keyboard;

    public NoteBookClassic() {
        this.battery = new DefaultBattery();
        this.display = new DefaultDisplay();
        this.keyboard = new USKeyboard();
    }

    @Override
    public void boot() {
        System.out.println("Booting :" + this.toString());
    }

    @Override
    public String toString() {
        return "NotebookClassic{" +
                "battery=" + battery +
                ", display=" + display +
                ", keyboard=" + keyboard +
                '}';
    }
}
