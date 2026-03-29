public class Brightness extends PerPixelConverter {
    @Override
    protected int transformPixel(int rgb) {
        ARGB p = new ARGB(rgb);
        int r = Math.min(255, p.red + 60);
        int g = Math.min(255, p.green + 60);
        int b = Math.min(255, p.blue + 60);
        return new ARGB(p.alpha, r, g, b).toInt();
    }
}