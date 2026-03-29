import java.awt.image.BufferedImage;

public abstract class PerPixelConverter extends Converter {
    @Override
    protected BufferedImage process(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Standard nested loops for first-year level
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                newImage.setRGB(x, y, transformPixel(rgb));
            }
        }
        return newImage;
    }

    protected abstract int transformPixel(int rgb);
}