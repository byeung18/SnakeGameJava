package model;

import java.io.IOException;
import java.io.PrintWriter;

public interface Saveable {
    boolean save(String fileName) throws IOException;
}
