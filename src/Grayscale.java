public class Grayscale extends PerPixelConverter {
    @Override
    protected int transformPixel(int rgb) {
        ARGB p = new ARGB(rgb);
        int gray = (p.red + p.green + p.blue) / 3;
        return new ARGB(p.alpha, gray, gray, gray).toInt();
    }
}