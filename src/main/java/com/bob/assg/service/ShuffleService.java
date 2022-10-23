package com.bob.assg.service;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bob.assg.web.LogDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShuffleService {

	private final LogClient logClient;
	
	public int[] genereateArray(int size) {
		LogDto logDto = new LogDto(size); 
		logClient.sendLog(logDto);
		return genereateShuffledArray(size); 
	}
	
	private int[] genereateShuffledArray(int size) {
		log.debug("start genereateShuffledArray {}", size);
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i + 1;
		}
		shuffle(arr);
		log.debug("end genereateShuffledArray array {} ", Arrays.toString(arr));
		return arr;
	}
	
    private void shuffle(int[] array) {
    	Random random = new Random();
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	
	
}
