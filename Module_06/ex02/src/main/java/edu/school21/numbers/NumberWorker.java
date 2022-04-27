package edu.school21.numbers;

public class NumberWorker {

    public int digitsSum(int number) {
        int res = 0;

        while (number > 0)
        {
            res = res + (number % 10);
            number = number / 10;
        }
        return res;
    }

    public boolean isPrime(int number) {
        int	i = 2;

        if (number <= 1) {
            throw new IllegalNumberException("Number less than 2 is passed to the program");
        }
        if (number == 2 || number == 3) {
            return true;
        }
        int res = 0;
        while (res < number) {
            res = i * i;
            if (number % i == 0)
                return false;
            i++;
        }
        return true;
    }
}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String s) {
        super(s);
    }
}