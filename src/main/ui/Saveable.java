package ui;

import java.io.IOException;
import java.io.PrintWriter;

public interface Saveable {
    static boolean save() throws IOException {
        // abstract
        return true;
    }
}
