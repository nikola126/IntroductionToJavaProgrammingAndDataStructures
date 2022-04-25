package com.programming.java;

import com.programming.java.chapter1.ChapterOne;
import com.programming.java.chapter2.ChapterTwo;
import com.programming.java.chapter3.ChapterThree;
import com.programming.java.chapter4.ChapterFour;
import com.programming.java.chapter5.ChapterFive;
import com.programming.java.chapter6.ChapterSix;

public class JavaApplication {

	public static void main(String[] args) {
//		ChapterOne chapterOne = new ChapterOne();
//		chapterOne.printAll();
//		ChapterTwo chapterTwo = new ChapterTwo();
//		chapterTwo.printAll();
//		ChapterThree chapterThree = new ChapterThree();
//		chapterThree.printAll();
//		ChapterFour chapterFour = new ChapterFour();
//		chapterFour.printAll();
//		ChapterFive chapterFive = new ChapterFive();
//		chapterFive.printAll();
		ChapterSix chapterSix = new ChapterSix();
		System.out.println(ChapterSix.getPentagonalNumber(4));
		System.out.println(ChapterSix.sumDigits(12345));
		System.out.println(ChapterSix.isPalindrome(12321));
		ChapterSix.displayReversed(12345);
		ChapterSix.displaySortedNumbers(5, 10, 1);
		ChapterSix.displayPattern(5);
	}

}
