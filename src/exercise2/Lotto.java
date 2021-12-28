package exercise2;

import java.util.Random;

import javax.swing.JOptionPane;

class Lotto{

    private int numbers[] = new int[3];

    Lotto(){

        setRandomNumber();

    }

    void setRandomNumber(){

        Random rand = new Random();

        for(int i=0;i<3;i++){

            numbers[i] = rand.nextInt(10);

        }

    }

    int[] getNumbers(){

        return numbers;

    }

    int getNumberSum(){

        return numbers[0]+numbers[1]+numbers[2];

    }

    void playGame() {

        for(int i=0;i<5;i++){

            String userInput = JOptionPane.showInputDialog("Enter a number between 3 to 27 : \nTry : "+(i+1));

            int number = Integer.parseInt(userInput);

            if(number==getNumberSum()){

                JOptionPane.showMessageDialog(null,"Congratulations!!! You won");

            }

            setRandomNumber();

        }

        JOptionPane.showMessageDialog(null,"Hard luck!!! You loss");

    }

}

class LottoPlay {

    public static void main(String[] args) {

        Lotto game = new Lotto();

        game.playGame();

    }

}