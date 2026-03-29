import java.awt.image.BufferedImage;

public class Rotate extends Converter {
    @Override
    protected BufferedImage process(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Swap width and height for the new image dimensions
        BufferedImage newImg = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Rotates the image 90 degrees clockwise
                newImg.setRGB(height - 1 - y, x, image.getRGB(x, y));
            }
        }
        return newImg;
    }
}