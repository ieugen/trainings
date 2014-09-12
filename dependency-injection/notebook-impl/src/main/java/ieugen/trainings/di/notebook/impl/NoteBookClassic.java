package ieugen.trainings.di.notebook.impl;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Computer;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;

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
    public String boot() {
        System.out.println("Booting :" + this.toString());
        return this.toString();
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
