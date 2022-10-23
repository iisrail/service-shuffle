package com.bob.assg.conroller;

import java.util.Arrays;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bob.assg.service.ShuffleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
public class ShuffleController {

	private final ShuffleService shuffleService;

	@PostMapping(value = "/shuffle/{size}")
	public ResponseEntity<String> genereateArray(@PathVariable("size") @Min(1) @Max(1000) int size) {
		log.info("genereateArray start {}",size);		
		int[] shufArr = shuffleService.genereateArray(size);
		log.info("genereateArray end");
		return ResponseEntity.ok(Arrays.toString(shufArr));
	}
	
    /**
     * Exception handler if ConstraintViolationException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String return400(ConstraintViolationException ex) {
        return ex.getMessage();

    }



}
