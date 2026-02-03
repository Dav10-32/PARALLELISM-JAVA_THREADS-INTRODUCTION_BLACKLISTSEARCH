/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) {
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        // int cores = Runtime.getRuntime().availableProcessors();
        // System.out.println("Núcleos disponibles: " + cores);
        // List<Integer> blackListOcurrences = hblv.checkHost("202.24.34.55", 100);
        // System.out.println("The host was found in the following blacklists:" + blackListOcurrences);
        int[] threadCounts = { 200, 500 };
        String ip = "202.24.34.55";

        for (int threads : threadCounts) {
            long startTime = System.currentTimeMillis();
            List<Integer> occurrences = hblv.checkHost(ip, threads);
            long endTime = System.currentTimeMillis();
            System.out.println("Threads: " + threads + " | Time: " + (endTime - startTime) + "ms | Occurrences: "
                    + occurrences.size());
        }
    }

}
