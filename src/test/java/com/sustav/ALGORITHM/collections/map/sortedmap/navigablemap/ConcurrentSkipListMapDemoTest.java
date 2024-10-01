package com.sustav.ALGORITHM.collections.map.sortedmap.navigablemap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentSkipListMapDemoTest {

    @Test
    public void givenSkipListMap_whenNavConcurrently_thenCountCorrect() throws InterruptedException {
        NavigableMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();

        int count = countMapElementByPollingFirstEntry(skipListMap, 10000, 4);

        assertEquals(10000 * 4, count);
    }

    @Test
    public void givenTreeMap_whenNavConcurrently_thenCountError() throws InterruptedException {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        int count = countMapElementByPollingFirstEntry(treeMap, 10000, 4);

        assertNotEquals(10000 * 4, count);
    }

    private int countMapElementByPollingFirstEntry(NavigableMap<Integer, Integer> navigableMap, int elementCount, int concurrencyLevel) throws InterruptedException {

        for (int i = 0; i < elementCount * concurrencyLevel; i++) {
            navigableMap.put(i, i);
        }

        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executorService
                = Executors.newFixedThreadPool(concurrencyLevel);
        for (int j = 0; j < concurrencyLevel; j++) {
            executorService.execute(() -> {
                for (int i = 0; i < elementCount; i++) {
                    if (navigableMap.pollFirstEntry() != null) {
                        counter.incrementAndGet();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        return counter.get();
    }
}