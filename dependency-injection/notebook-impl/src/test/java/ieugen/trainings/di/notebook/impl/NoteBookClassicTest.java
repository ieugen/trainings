package ieugen.trainings.di.notebook.impl;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NoteBookClassicTest {

    @Test
    public void testNoteBookClassic() throws Exception {
        NoteBookClassic classic = new NoteBookClassic();

        String result = classic.boot();

        Assert.assertThat(result, CoreMatchers.containsString("DefaultBattery"));
    }
}