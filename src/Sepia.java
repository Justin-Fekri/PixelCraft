public class Sepia extends PerPixelConverter {
    @Override
    protected int transformPixel(int rgb) {
        ARGB p = new ARGB(rgb);
        int tr = (int)(0.393 * p.red + 0.769 * p.green + 0.189 * p.blue);
        int tg = (int)(0.349 * p.red + 0.686 * p.green + 0.168 * p.blue);
        int tb = (int)(0.272 * p.red + 0.534 * p.green + 0.131 * p.blue);
        return new ARGB(p.alpha, Math.min(255, tr), Math.min(255, tg), Math.min(255, tb)).toInt();
    }
}