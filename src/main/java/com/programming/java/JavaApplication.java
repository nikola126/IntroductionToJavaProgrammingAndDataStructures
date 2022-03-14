package com.programming.java;

import com.programming.java.chapter1.ChapterOne;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		ChapterOne taskOne = new ChapterOne();
		taskOne.taskOne();
	}

}
