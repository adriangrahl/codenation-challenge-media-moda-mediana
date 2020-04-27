package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {
	
	private StatisticUtil() {}

	public static int average(int[] elements) {
		return (int) 
				IntStream.of(elements).average()
				.orElseThrow(IllegalArgumentException::new);
	}

	public static int mode(int[] elements) {		
		Map<Integer, Integer> mapElementToOccurrences = IntStream.of(elements).boxed()
				.collect(Collectors.toMap(chave -> chave, valor -> 1, (valor, n) -> valor+1));
		
		return mapElementToOccurrences.entrySet().stream()
			.sorted(Collections.reverseOrder(Entry.comparingByValue()))
			.findFirst()
			.map(Entry::getKey)
			.orElseThrow(IllegalArgumentException::new);
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		if (elements.length % 2 == 1) {
			return elements[elements.length/2];
		}
		int leftElement = elements[elements.length/2 - 1];
		int rightElement = elements[elements.length/2];
		return (leftElement + rightElement) / 2;
	}
	
}