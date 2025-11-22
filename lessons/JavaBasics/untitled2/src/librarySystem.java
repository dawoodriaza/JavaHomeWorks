//public class librarySystem {
//
//
//    private static int total_books = 500;
//    protected static int borrowed_books = 0;
//    public static String library_mame= "Central Library";
//
//
//    public static void addBooks(int count){
//        if(count>0){
//            total_books += count;
//            System.out.println(count + " books added. Total Books " + total_books);
//        }
//        else {
//            System.out.println("Invalid Book Count ");
//        }
//    }
//
//    protected static void borrowed_books(int count){
//        if(count > 0 && count <= total_books){
//            total_books -=count;
//            borrowed_books += count;
//            System.out.println(count + "Books Borrowed. Remainng Books "+ total_books);
//        }
//        else{
//            System.out.println("Cannot borrow books. insufficient books ");
//        }
//    }
//
//    private static void applyMaintenance(){
//        int books_for_maintenance = 10;
//        total_books -= books_for_maintenance;
//        System.out.println("Maintenace Applied: "+books_for_maintenance + " books removed. Total Now " + total_books);
//    }
//
//
//    public static void transactionSummary(){
//        int borrowed_books = 50;
//        System.out.println("local borrowed books "+ borrowed_books);
//        System.out.println("Actual borrowed books " + librarySystem.borrowed_books);
//        int transaction_total = total_books + librarySystem.borrowed_books;
//        System.out.println("Total Books including borrowed "+ transaction_total);
//    }
//
//
//    public static void  showTotalBooks(){
//        System.out.println("Total Books in library " + total_books);
//    }
//
//
//    public static void main(String [] args){
//
//        System.out.println("Library name" + library_mame);
//        addBooks(50);
//        borrowed_books(30);
//        applyMaintenance();
//        transactionSummary();
//        showTotalBooks();
//    }
//}
