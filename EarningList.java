package EntityList;

import Entity.Earning;

public class EarningList {
    private Earning[] earnings;
    private int size;

    public EarningList(int capacity) {
        earnings = new Earning[capacity];
        size = 0;
    }

    public void insert(Earning earning) {
        if (size < earnings.length) {
            earnings[size++] = earning;
        }
    }

    public Earning[] getAll() {
        Earning[] allEarnings = new Earning[size];
        System.arraycopy(earnings, 0, allEarnings, 0, size);
        return allEarnings;
    }
}
