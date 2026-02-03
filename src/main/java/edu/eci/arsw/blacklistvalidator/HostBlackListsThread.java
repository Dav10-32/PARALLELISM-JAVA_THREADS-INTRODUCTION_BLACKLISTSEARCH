package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;

/**
 * Thread that searches for an IP address in a specific range of blacklists.
 */
public class HostBlackListsThread extends Thread {

    private int startIndex;
    private int endIndex;
    private String ipAddress;
    private int occurrencesCount = 0;
    private int checkedListsCount = 0;
    private LinkedList<Integer> blackListIndices = new LinkedList<>();
    private HostBlacklistsDataSourceFacade skds;

    public HostBlackListsThread(int startIndex, int endIndex, String ipAddress, HostBlacklistsDataSourceFacade skds) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.ipAddress = ipAddress;
        this.skds = skds;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            checkedListsCount++;
            if (skds.isInBlackListServer(i, ipAddress)) {
                blackListIndices.add(i);
                occurrencesCount++;
            }
        }
    }

    public int getOccurrencesCount() {
        return occurrencesCount;
    }

    public List<Integer> getBlackListIndices() {
        return blackListIndices;
    }

    public int getCheckedListsCount() {
        return checkedListsCount;
    }
}
