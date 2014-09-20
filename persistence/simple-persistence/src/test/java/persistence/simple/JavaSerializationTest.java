package persistence.simple;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import persistence.simple.model.Bar;
import persistence.simple.model.Foo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaSerializationTest {

    public static final String FILE_NAME = "serialization.data";

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testSerialization() throws Exception {
        File cretedFile = temporaryFolder.newFile(FILE_NAME);

        Foo foo = createFoo();
        printFoo(foo);
        // write to disk
        try (FileOutputStream fos = new FileOutputStream(cretedFile);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            out.writeObject(foo);
            out.close();
        }

        // read from disk
        Foo newFoo;
        try (FileInputStream fin = new FileInputStream(cretedFile);
             ObjectInputStream in = new ObjectInputStream(fin)) {

            newFoo = (Foo) in.readObject();
            in.close();
        }
        printFoo(newFoo);
    }


    private void printFoo(Foo foo) {
        System.out.println("--- ");
        System.out.println(foo);
        System.out.println("--- ");
    }

    private Foo createFoo() {
        List<Bar> bars = new ArrayList<>();

        bars.add(new Bar(1, "first bar"));
        bars.add(new Bar(2, "second bar"));

        Foo foo = new Foo(10, bars);

        return foo;
    }

}
