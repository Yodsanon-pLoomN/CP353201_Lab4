package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class RankingTestNorm {
	Ranking testRanking;
	
	@BeforeEach
	public void setUp() throws Exception {
		testRanking = new Ranking();
	}
	
	@DisplayName("Normal boundary value testing")
	@ParameterizedTest
	@CsvSource({
		"0,4,500,Standard",
		"1,4,500,Standard",
		"50000,4,500,Gold",
		"99999,4,500,Gold",
		"100000,4,500,Gold",
		"50000,0,500,Standard",
		"50000,1,500,Silver",
		"50000,6,500,Standard",
		"50000,7,500,Standard",
		"50000,4,0,Standard",
		"50000,4,1,Standard",
		"50000,4,999,Gold",
		"50000,4,1000,Gold"
	})
	void testBoundary(int purchaseTotal, int frequency, int pointCollected, String expected) {
		assertEquals(expected, testRanking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected));
	}

}



