package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void beforeEach() { numberWorker = new NumberWorker(); }

    @ParameterizedTest(name = "{index} - {0} is a prime")
    @ValueSource(ints = {2147483629, 113, 2, 3, 5, 7, 11, 13, 17, 19, 23})
    void isPrimeForPrimes(int number) {
            Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest(name = "{index} - {0} is not a prime")
    @ValueSource(ints = {2147483628, 112, 6, 42, 4, 16, 75})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest(name = "{index} - {0} is illegal")
    @ValueSource(ints = {1, 0, -2549, -42, -1, -2147483627})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(IllegalNumberException.class, ()-> numberWorker.isPrime(number));
    }

    @ParameterizedTest(name = "{index} - digits sum of number {0} is equal to {1}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void checkDigitsSum(int number, int res) {
        Assertions.assertEquals(numberWorker.digitsSum(number), res);
    }
}
