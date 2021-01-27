package mocks;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;

public class MockFileResource extends FileResource {

    @Override
    public CSVParser getCSVParser() {

        return null;
    }
}
