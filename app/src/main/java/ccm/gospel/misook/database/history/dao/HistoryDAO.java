package ccm.gospel.misook.database.history.dao;


import ccm.gospel.misook.database.BasicDAO;

public interface HistoryDAO<T> extends BasicDAO<T> {
    T getLatestEntry();
}
