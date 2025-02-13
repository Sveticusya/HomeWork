public class ArrayFiller implements Runnable {

    private Integer start;
    private Integer end;
    private double[] array;
    public ArrayFiller(Integer start, Integer end, double[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }
    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}
