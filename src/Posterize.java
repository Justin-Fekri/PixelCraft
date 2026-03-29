public class Posterize extends PerPixelConverter {
    @Override
    protected int transformPixel(int rgb) {
        ARGB p = new ARGB(rgb);
        int r = (p.red / 64) * 64;
        int g = (p.green / 64) * 64;
        int b = (p.blue / 64) * 64;
        return new ARGB(p.alpha, r, g, b).toInt();
    }
}
