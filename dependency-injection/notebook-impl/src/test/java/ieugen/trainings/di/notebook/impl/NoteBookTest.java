package ieugen.trainings.di.notebook.impl;

import ieugen.trainings.di.notebook.api.Battery;
import ieugen.trainings.di.notebook.api.Display;
import ieugen.trainings.di.notebook.api.Keyboard;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class NoteBookTest {

    @Test
    public void testNotebookCreationWithMocks() throws Exception {
        NoteBook noteBook = new NoteBook(mock(Battery.class), mock(Display.class), mock(Keyboard.class));

        String result = noteBook.boot();

        Assert.assertThat(result, CoreMatchers.containsString("Mock for Battery"));
    }
}