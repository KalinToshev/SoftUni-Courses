package bg.softuni.hiberspring.util.impl;

import bg.softuni.hiberspring.util.FileUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static bg.softuni.hiberspring.common.Constants.PATH_TO_FILES;

@Component
public class FileUtilImpl implements FileUtil {
    @Override
    public String readFile(String fileName) throws IOException {
        return Files.readString(Path.of(PATH_TO_FILES + fileName));
    }
}
