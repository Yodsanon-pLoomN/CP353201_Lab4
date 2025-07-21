package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
		"0,15,500,Standard",
		"1,15,500,Standard",
		"50000,15,500,Standard",
		"99999,15,500,Standard",
		"100000,15,500,Standard",
		"50000,0,500,Standard",
		"50000,1,500,Standard",
		"50000,29,500,Standard",
		"50000,30,500,Standard",
		"50000,15,0,Standard",
		"50000,15,1,Standard",
		"50000,15,999,Standard",
		"50000,15,1000,Standard"
	})
	void testBoundary(int purchaseTotal, int frequency, int pointCollected, String expected) {
		assertEquals(expected, testRanking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected));
	}

}



