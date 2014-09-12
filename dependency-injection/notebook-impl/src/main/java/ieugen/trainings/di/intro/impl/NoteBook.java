package ieugen.trainings.di.intro.impl;

import ieugen.trainings.di.intro.api.Battery;
import ieugen.trainings.di.intro.api.Computer;
import ieugen.trainings.di.intro.api.Display;
import ieugen.trainings.di.intro.api.Keyboard;

public class NoteBook implements Computer {

    private Battery battery;
    private Display display;
    private Keyboard keyboard;

    public NoteBook(Battery battery, Display display, Keyboard keyboard) {
        this.battery = battery;
        this.display = display;
        this.keyboard = keyboard;
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
