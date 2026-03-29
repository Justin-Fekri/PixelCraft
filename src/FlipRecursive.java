import java.awt.image.BufferedImage;

public class FlipRecursive extends RecursiveSpatialConverter {
    @Override
    protected void mapPixel(int pixel, BufferedImage dst, int width, int height, int x, int y) {

        dst.setRGB(x, height - 1 - y, pixel);
    }
}