package ieugen.trainings.di.notebook.impl;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Computer;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;

public class NoteBookSetterInjection implements Computer {

    private Battery battery;
    private Display display;
    private Keyboard keyboard;

    public NoteBookSetterInjection() {
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
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
