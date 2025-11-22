public class HelloWorld {
    public static void main(String[] args){
        // S is upper Case , whenever a  word Start with S it is Class , out is method , println
        // static means the method belongs to the class itself
        System.out.println("Hello Java!");
        // this is single Line comment
        /*
        * to write multiple line comment
        * */



//        class Human{
//            static int legs = 2;
//            static int hands = 2;
//
//            String nationality;
//        }
//        class Main {
//            public static void main(String[] args) {
//                Human human1 = new Human();
//                Human human2 = new Human();
//
//                human2.legs = 2;
//
//                human1.nationality = "Bahraini";
//                human2.nationality = "Pakistani";
//                System.out.println("Human1 Legs: " + human1.legs);
//                System.out.println("Human1 nationality: " +  human1.nationality);
//                System.out.println("Human1 nationality: " +  human2.nationality);
//            }
//        }
        int number = 400;
        String my_name = "Dawood";
        double price = 6.99;
        int income = 1000_000;
        var name ="apple";
        var age = 50;
        var pi=3.14;
//        System.out.println("Name "+ name);
//
//        System.out.println("Type:"+  name.getClass().getName().getClass());
//
//        System.out.println("Type:"+ ((Object) age).getClass().getName());
//        System.out.println("Type:"+ ((Object) pi).getClass().getName());

//double num = 5.0/2.0;

//        double num = 5d/2d;
        double num = 5f/2f;
        System.out.println(num);

        //short 16bits
        // int 32 bits 0.06 MILLION  (THOUSAND)
        // long 64 bits  4 BILLION
        // float 32bits  18 * 10(18)
        // double 64 bits
        // BigDecimal Limited only by memory
// Primitive and NonPrimitive Data types

        // Primitive dataTypes in which value is assigned,and they cannot be divided into another datatypes. Cannot be mutated
        // No primitive values like array are divided into many types like Array has int , string and are mutable   like you can make array of integers and string, but you cannot make int a string


        int num1=20;
        int num2 = 30;
        float pricee=200.0f;
        double pis=3.14;


        // Java Arithematics
//        System.out.println("Add:"+ (2+2));
//        System.out.println(Math.pow(3,2));

        double a = 100.7;
        int b = (int) a;
        System.out.println(b);


        // Control fLOW AND LOOPS
//        boolean most_beautiful = false;
//        String country_name;
//        if(most_beautiful){
//            country_name = "Bahrain";
//        }
//        else{
//            country_name= "America";
//        }
//
//        System.out.println(country_name);

        
//        String animal_Type1 = "Kit";
//        String animal_Type2 = "tens";
//
//        String animal_type  = animal_Type1+animal_Type2;
//        if (animal_type.equals("puppies")){
//            animal_type+="!!!";
//
//        } else if (animal_type =="puppies"){
//            animal_type+="!!!";
//
//        } else if (animal_type.equals("Kittens")) {
//            animal_type += "!!";
//        }
//        else {
//            animal_type = "!" + animal_type;
//        }
//        System.out.println("animal_Type = " + animal_type);


        // For loop
//        for (int i= 0; i <=10 ; i++){
//            System.out.println("i = " + i);
//        }
//        int i = 5;
//        while(i<=5){
//            System.out.println("i = " + i);
//            i++;
//        }
        int i = 0;
        do{
            System.out.println("i = " + i);
            i++;
        }while(i <= 5);

    }
}
