package model;

import java.io.IOException;

public interface Loadable {
    boolean load(String inputFile) throws IOException;
}
