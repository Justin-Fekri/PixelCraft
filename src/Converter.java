import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Converter {
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(inputFileName));
        BufferedImage processedImage = process(image);
        ImageIO.write(processedImage, "PNG", new File(outputFileName));
    }
    protected abstract BufferedImage process(BufferedImage image);
}