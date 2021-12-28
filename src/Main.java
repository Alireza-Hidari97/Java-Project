class Main

{

//overloaded methods named add

    static int add(int a, int b)

    {

        int c = a+b;

        return c;

    }

    static float add(float a, float b)

    {

        float c = a+b;

        return c;

    }

    static int add(int a, int b, int c)

    {

        int d=a+b+c;

        return d;

    }

//main function

    public static void main(String[] args)

    {

        System.out.println("First method:");

        System.out.println("Sum of two integer variable: "+add(4,5));

        System.out.println("Second method:");

        System.out.println("Sum of two float variable: "+(4.3+6.7));

        System.out.println("Third method:");

        System.out.println("Sum of three integer variable: "+(1+2+3));

    }

}