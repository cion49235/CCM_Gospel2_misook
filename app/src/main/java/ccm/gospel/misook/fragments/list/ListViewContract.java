package ccm.gospel.misook.fragments.list;


import ccm.gospel.misook.fragments.ViewContract;

public interface ListViewContract<I, N> extends ViewContract<I> {
    void showListFooter(boolean show);

    void handleNextItems(N result);
}
