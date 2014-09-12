package ieugen.trainings.di.notebook.impl;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Computer;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;

import javax.inject.Inject;

public class NoteBook implements Computer {

    private Battery battery;
    private Display display;
    private Keyboard keyboard;

    @Inject
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
