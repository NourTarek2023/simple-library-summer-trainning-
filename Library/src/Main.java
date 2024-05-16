import java.util.*;

public class Main {
    static ArrayList<Books> store = new ArrayList<>();

    public static void showBook(){
        if (store.isEmpty())
            System.out.println("Store is Empty Please Enter some Books !");
        else
            System.out.println(store);
    }

    public static void addBook(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Name Of The Book :");
        String name = sc1.nextLine();
        System.out.println("Enter Type Of The Book :");
        String type = sc1.nextLine();
        System.out.println("Enter Author Of The Book :");
        String author = sc1.nextLine();
        System.out.println("About Of The Book :");
        String about = sc1.nextLine();
        Books b = new Books(name,type,author,about);
        store.add(b);
    }

    public static void editBook() {
        Scanner sc2 = new Scanner(System.in);
        int index = -1, x;

        System.out.println("Enter Name Of the Book to Edit: ");
        String name = sc2.nextLine().toLowerCase();

        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getBookTitle().toLowerCase().equals(name) ) {
                index = i;
                break;
            }
        }

        if (index==-1)
            System.out.println("Sorry Book Not  Found!");

        else {
            System.out.println("1-Edit Title Of The Book \n2-Edit Type Of The Book \n3-Edit Author Of The Book" +
                    "\n4-Edit the synopsis of the book \n5-Delete the book");
            x = sc2.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter new Title :");
                    String title = sc2.nextLine();
                    store.get(index).setBookTitle(title);
                    break;
                case 2:
                    System.out.println("Enter new Type :");
                    String type = sc2.nextLine();
                    store.get(index).setBookType(type);
                    break;
                case 3:
                    System.out.println("Enter new Author :");
                    String author = sc2.nextLine();
                    store.get(index).setAuthor(author);
                    break;
                case 4:
                    System.out.println("Enter new Synopsis :");
                    String about = sc2.nextLine();
                    store.get(index).setAboutTheBook(about);
                    break;
                case 5:
                    store.remove(index);
                    System.out.println("Successfully Deleted");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

    public static boolean search(){
        boolean  found=false;
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter Book To Search:");
        String name = sc3.nextLine().toLowerCase();
        for (int i=0; i<store.size() ; i++)
        {
            if(store.get(i).getBookTitle().toLowerCase().equals(name)) {
                found = true;
                System.out.println(store.get(i));
            }
        }
        return found;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Books b1 = new Books("Atomic Habits","Psychology Books"," James Clear","An Easy & Proven Way to Build Good Habits & Break Bad Ones");
        Books b2 = new Books("Surrounded by Psychopaths","Psychology Books","Thomas Erikson"," How to Protect Yourself from Being Manipulated and Exploited in Business (and in Life)");
        store.add(b1);
        store.add(b2);

        int input;
        do {
            System.out.println(" 1- Show Books\n 2- Add a Book\n 3- Edit a Book\n 4- Search\n 5- Exit");
            input = sc.nextInt();
            switch (input){
                case 1:
                    showBook();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.out.println("Successful Exit");
                    break;
                default:
                    System.out.println("Invalid Input");
            }


        }
        while (input!=5);

    }
}