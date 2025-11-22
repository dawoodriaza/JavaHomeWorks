public class Lab1 {
    public static void main(String[] args){
for(int i= 0 ; i <=20;i++){
    System.out.print("*");
}
        System.out.println("");
int stars=5;
        for(int i= 0 ; i <=5;i++){
            System.out.print("*");
            // 1 <=0
            //1 <= 1

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("");

        for (int i = stars; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



        int numbers= 100;
        for(int i =0 ; i <= numbers;i++) {
           if (i % 5 ==0 && i % 3 ==0 ) {
                System.out.println("FizzBuzz");
            }
            if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 ==0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
