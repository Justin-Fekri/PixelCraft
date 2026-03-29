import java.awt.image.BufferedImage;

public class MirrorRecursive extends RecursiveSpatialConverter {
    @Override
    protected void mapPixel(int pixel, BufferedImage dst, int width, int height, int x, int y) {
        // Flips the pixel horizontally
        dst.setRGB(width - 1 - x, y, pixel);
    }
}