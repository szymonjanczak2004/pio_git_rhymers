package edu.kis.vh.nursery;
/**Klasa reprezentujaca wyliczanke w oparciu o kolejke FIFO**/
public class FIFORhymer extends DefaultCountingOutRhymer {

    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();
    /**Zwraca i usuwa najstarszy element**/
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
