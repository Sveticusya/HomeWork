public class LetterPrinter implements Runnable{
    private char letter;
    private CommonResource sync;
    public LetterPrinter(char letter, CommonResource sync) {
        this.letter = letter;
        this.sync = sync;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            if(sync.canPrintLetter(letter)) {
                System.out.print(letter);
                sync.next();
                i++;
            }
        }
    }
}
