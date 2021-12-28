package exercise1;
import java.util.Random;
import java.util.Scanner;


class QuestionBank
{
    //array of questions.
    private final String[] questions = {
            "What is the static member?",
            "What is protected modifier?",
            "Method which doesnt have return type is called?",
            "Which package is associated with math class?",
            "which access modifier is more restricted?"
    };
    //answers for above questions
    private final String[] answers={
            "we can call it without creating an object.",
            "All protected member are accessible within class and child but not outside of the class. ",
            "void",
            "java.lang.Math*;",
            "private"
    };
    //options for each of the above questions.
    private final String[][] options = {
            {"we can call it without creating an object.","we should make an object in order to access it","a","non of the above"},
            {"All protected member are accessible within class and child but not outside of the class.","Not accessible within the class","Only accessible outside of the class","Non of the above"},
            {"void","return type","b","non of the above"},
            {"java.lang.Math*;","java.util.Random;","java.util.Scanner;","non of the above"},
            {"private","public","protected","non of the above"}
    };

    //random object
    Random randomObject;
    //scanner
    Scanner in;

    QuestionBank()
    {
        randomObject = new Random();
        in = new Scanner(System.in);

    }
    //function that simulates the questions
//by printing the question and its options for given question index.
    int simulateQuestion(int qInd)
    {

        System.out.println("\n"+(qInd+1)+". "+questions[qInd]);
        int opLen = options[qInd].length;
        for(int i = 0 ; i < opLen ; i++)
        {
            System.out.println("\n"+(char)('a'+i)+". "+options[qInd][i]);
        }
        return qInd;
    }
    //function that takes the option user entered.(a,b,c,d,)
//and gets the option answer (a -> london) selected and
//checks the option answer with the answers[qInd]
    boolean checkAnswer(String answer,int qInd)
    {
        if(answer.length() != 1)
        {
            return false;
        }

        int opLen = options[qInd].length;
        String choosenAns="";
        boolean found = false;
        String i_thOp;
        for(int i =0; i<opLen;i++)
        {
            i_thOp = ""+(char)('a'+i);

            if(answer.equals(i_thOp))
            {
                choosenAns = options[qInd][i];
                found = true;
                break;
            }
        }

        if(!found)
        {
            return false;
        }
        else
        {

            return answers[qInd].equals(choosenAns);
        }
    }
    //function that simulates the process.
//by printing the question , options and checking the answer
//iterating thorugh all questions.
  public  void inputAnswer()
    {
        int posScore = 0;
        int negScore = 0;
        for(int i = 0;i<questions.length;i++)
        {
            int qInd = simulateQuestion(i);
            System.out.print("\nEnter your option: ");
            String ans = in.nextLine();
            System.out.println("");
            if(checkAnswer(ans,qInd))
            {
                System.out.println(generateMessage(true));
                posScore++;
            }
            else
            {
                System.out.println(generateMessage(false));
                negScore++;
            }
        }
        System.out.println("\nTotal Right Answer: "+posScore);
        System.out.println("Total Wrong Answer: "+negScore);
        float percent = (float)posScore /(posScore + negScore);
        System.out.println(String.format("Percentage of Right Answers: %.2f",percent));

    }

    String generateMessage(boolean positive)
    {
//if want to print to positive messsages.
        if(positive)
        {
//positive messages.
            switch(randomObject.nextInt(4))
            {
                case 0:
                    return "Excellent!";

                case 1:
                    return "Good!";

                case 2:
                    return "Keep up the good work!";

                case 3:
                    return "Nice work!";

            }
        }
        else
        {
//negative messages

            switch(randomObject.nextInt(4))
            {
                case 0:
                    return "No. Please try again";

                case 1:
                    return "Wrong. Try one more time" ;

                case 2:
                    return "Don't give up!" ;

                case 3:
                    return "No. Keep trying..";

            }
        }
        return"";
    }

}