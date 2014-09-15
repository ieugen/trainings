package ieugen.trainings.di.notebook.impl;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class NoteBookSetterInjectionTest {

    @Test
    public void testNotebookCreationWithMocks() throws Exception {
        NoteBookSetterInjection noteBook = new NoteBookSetterInjection();

        noteBook.setBattery(mock(Battery.class));
        noteBook.setDisplay(mock(Display.class));
        noteBook.setKeyboard(mock(Keyboard.class));

        String result = noteBook.boot();

        Assert.assertThat(result, CoreMatchers.containsString("Mock for Battery"));
    }
}