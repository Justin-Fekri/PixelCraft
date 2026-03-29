import java.awt.image.BufferedImage;

public class Blur extends Converter {
    @Override
    protected BufferedImage process(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImg.setRGB(x, y, getBoxBlur(image, x, y, width, height));
            }
        }
        return newImg;
    }

    private int getBoxBlur(BufferedImage img, int x, int y, int w, int h) {
        int r = 0, g = 0, b = 0, a = 0, count = 0;

        // Simple 3x3 grid check
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                int nx = x + dx;
                int ny = y + dy;

                // Check if the neighbor is inside the picture boundaries
                if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    ARGB p = new ARGB(img.getRGB(nx, ny));
                    r += p.red;
                    g += p.green;
                    b += p.blue;
                    a += p.alpha;
                    count++;
                }
            }
        }
        return new ARGB(a/count, r/count, g/count, b/count).toInt();
    }
}