public class CommonResource {
    char nextLetter = 'A';

    synchronized public boolean canPrintLetter(char letter) {
        return nextLetter == letter;
    }

    synchronized public void next() {
        if(nextLetter == 'A')
            nextLetter = 'B';
        else if(nextLetter == 'B')
            nextLetter = 'C';
        else
            nextLetter = 'A';
    }
}
