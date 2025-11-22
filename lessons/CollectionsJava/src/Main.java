import java.util.*;

public class Main {
//    public static void printSightings(ArrayList<String> wild_life) {
//        for (String animal : wild_life) {
//            System.out.println("Today, I spotted a " + animal + " in the concrete jungle.");
//        }
//    }
//
//    public static Integer addSum(int [] array) {
//    if (array.length ==0){
//        return 0;
//    }
//
//        if(array.length ==1){
//       return array[0];
//    }
//
//        return array[0]+array[1];
//
//
//    }
    public static void main(String[] args) {


//        ArrayList<String> movieList =  new ArrayList<>();
//        movieList.add("Avatar");
//        movieList.add("SpiderMan");
//        movieList.add("SuperMan");
//        movieList.add("Batmnan");
//
//
//        for(int i= 0; i<movieList.size();i++){
//            System.out.println("Movie is"+ movieList.get(i) + "at index" +i);
//        }
//
//        for(String movie:movieList){
//            System.out.println("I Love "+ movie);
//        }
//
//        int [] num = {2,5,8,9,5,5,8};
//        System.out.println(num.length);
//
//        ArrayList<String> wild_life =  new ArrayList<>();
//        wild_life.add("Cat");
//        wild_life.add("Dog");
//        wild_life.add("Cheetah");
//        wild_life.add("Lion");
//        wild_life.add("Tiger");
//
//      printSightings(wild_life);
//
//int[] array_num ={1,5};
//
//
//      int summ=  addSum(array_num);
//        System.out.println(summ);
        //Array Declaration
//        int [] an_array;
//        an_array = new int[10];
//
//        an_array[0] = 111;
//        an_array[1] = 222;
//        System.out.println(an_array[0]);
//        System.out.println(an_array[1]);
//        System.out.println(an_array[3]);
//        System.out.println(an_array[8]);
//
//        System.out.println(an_array.length);


//
//
//        int [] prime_numbers = {5,3,11,7,8,2,30};
//        int value = 10;
//
//Arrays.sort(prime_numbers);
//        System.out.println(Arrays.toString(prime_numbers));
//    System.out.println(prime_numbers);
//        int index = Arrays.binarySearch(prime_numbers,value);
//
//        System.out.println("index " + index + "value" + prime_numbers[index]);
//        String[] fav_things = {
//                "rainDrops", "roses", "Kittens"
//        };
//        fav_things[3]= "Chococlate";
//        System.out.println(Arrays.toString(fav_things));


//        ArrayList<String> few_things = new ArrayList<>();
//        few_things.add("Copper Kettles");
//        few_things.add("Black Pepper");
//        System.out.println(few_things);
//
//        few_things.add(0,"Chocolate");
//
//        System.out.println(few_things);
//        few_things.add(0,"Worm woolen mittens");
//
//
//        few_things.remove(0);
//        System.out.println(few_things);
//
//        few_things.remove("Copper Kettles");
//        System.out.println(few_things);
//
//        System.out.println(few_things.size());
        /*
         *
         *
         * */
//        LinkedList<String> ice_cream_flavours = new LinkedList<>();
//
//        ice_cream_flavours.add("Orea");
//        ice_cream_flavours.add("Cherry");
//        ice_cream_flavours.add("Mango");
//
//        System.out.println(ice_cream_flavours);
//        System.out.println(ice_cream_flavours.remove(0));
//        System.out.println(ice_cream_flavours);
//        System.out.println(ice_cream_flavours.remove("Mango"));
//        System.out.println(ice_cream_flavours);
//        System.out.println(ice_cream_flavours.size());
//        System.out.println(ice_cream_flavours.set(0,"Vanilla"));
//
//        System.out.println(ice_cream_flavours);


//        LinkedList<Integer> numbers = new LinkedList<Integer>();
//        numbers.add(1);//0
//        numbers.add(2);//1
//        numbers.add(3);//2
//        numbers.add(4);//3
//        numbers.add(5);//4
//        numbers.add(6);//5
//        numbers.add(7);//6
//        numbers.add(8);//7
//        numbers.add(9);//8
//        numbers.add(10);//9
//        numbers.add(11);//10
//        numbers.add(12);//11
//        numbers.add(13);//12
//        numbers.add(14);//13
//        numbers.add(15);//14
//
//        for(int i =5 ; i <= 15;i++){
//            if (numbers.contains(i)){
//                numbers.remove( Integer.valueOf(i));
//            }
//        }
//        System.out.println(numbers.size());
//    }

        HashMap<String,String> studentMap = new HashMap<>();

        studentMap.put("555","Saad");
        studentMap.put("555","Saad");
        studentMap.put("666","Iqbal");
//Multiple key value pairs

        studentMap.putAll(Map.of("111","Saad",
                "222","Iqbal",
                "333","Khan",

                "444","Ali"));
        System.out.println(studentMap);
        System.out.println(studentMap.get("111"));
        System.out.println(studentMap.remove("333"));
        System.out.println(studentMap.size());

        System.out.println(studentMap);



        HashMap<String, String> dictionary= new HashMap<>();

        dictionary.put("Apple","A fruit from the tree");
        dictionary.put("Lake","A large body of water");

        System.out.println("dictionary"+dictionary);


/*
*
* Independent Practice: Collections (15 min)
Create a LinkedList of strings with the values {"One","Two","Three","Four"}.
Create a HashMap with the keys {"One","Two","Three","Four"} taken from the list and the integer values {1,2,3,4} taken from the array.
Print out the HashMap size after adding the above items.
* */
        LinkedList<String> numbers = new LinkedList<>();
        numbers.add("one");//0
        numbers.add("Two");//1
        numbers.add("Three");//2
        numbers.add("Four");//3

        HashMap<String, Integer> merge = new HashMap<String, Integer>();

        merge.putAll(Map.of(numbers.get(0), 1 , numbers.get(1), 2,numbers.get(2), 3,
                numbers.get(3), 4 ));
        System.out.println(merge.size());
        System.out.println(merge);




    }
}
