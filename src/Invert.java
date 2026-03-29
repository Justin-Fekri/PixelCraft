public class Invert extends PerPixelConverter {
    @Override
    protected int transformPixel(int rgb) {
        ARGB p = new ARGB(rgb);
        return new ARGB(p.alpha, 255 - p.red, 255 - p.green, 255 - p.blue).toInt();
    }
}