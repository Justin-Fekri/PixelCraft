import java.awt.image.BufferedImage;

public abstract class RecursiveSpatialConverter extends Converter {
    @Override
    protected BufferedImage process(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        processRow(image, newImage, width, height, 0);
        return newImage;
    }

    // Recursive method to act as the "y" loop
    private void processRow(BufferedImage src, BufferedImage dst, int width, int height, int y) {
        if (y >= height) return;
        processCol(src, dst, width, height, y, 0);
        processRow(src, dst, width, height, y + 1);
    }

    // Recursive method to act as the "x" loop
    private void processCol(BufferedImage src, BufferedImage dst, int width, int height, int y, int x) {
        if (x >= width) return;
        mapPixel(src.getRGB(x, y), dst, width, height, x, y);
        processCol(src, dst, width, height, y, x + 1);
    }

    protected abstract void mapPixel(int pixel, BufferedImage dst, int width, int height, int x, int y);
}