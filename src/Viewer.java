import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Viewer {
    static final Frame frame = new Frame();

    public static String openFile() {
        FileDialog fd = null;
        try {
            fd = new FileDialog(frame, "파일열기");
            fd.setVisible(true);
            return fd.getFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fd != null) {
                fd.dispose();
            }
        }
    }

    static void printHexView(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = fis.readAllBytes();
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
