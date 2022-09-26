package list4.Q10;

import java.util.ArrayList;

public class ArmstrongNumber {

    public int      number;
    public boolean  armstrong;

    public ArmstrongNumber(int number){
        this.number = number;
        isArmstrong();
    }

    public void isArmstrong() {
        ArrayList<Integer> numbers = splitNumbers();
        int sum = sum(numbers);

        armstrong = sum == this.number;
    }

    private int sum(ArrayList<Integer> numbers){

        int sum = 0;

        for (Integer number: numbers) {
            sum += Math.pow(number, numbers.size());
        }

        return sum;
    }

    private ArrayList<Integer> splitNumbers(){
        int num = number;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < number * 10; i *= 10) {

            if (number % i == number){
                i /= 10;

                for (int j = i; j >= 1; j /= 10) {
                    int alg  = (num - (j * (num / j)));
                    num -= alg;
                    numbers.add(num / j);
                    num = alg;
                }

                i *= 10;
            }
        }

        return numbers;
    }

    @Override
    public String toString() {

        ArrayList<Integer> numbers = splitNumbers();

        int     power   = numbers.size();
        String  out     = "";
        int     index   = 0;

        for (Integer number: numbers) {
            out = out.concat(String.format("%d^%d ", number, power));

            if (index == numbers.size() - 1){
                out = out.concat(String.format("= %d", sum(numbers)));
            } else {
                out = out.concat("+ ");
            }

            index++;
        }

        return out;
    }
}
