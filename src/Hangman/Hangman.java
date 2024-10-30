package Hangman;
import java.util.*;

public class Hangman {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        Settings.Start();
        Settings.Contin(scan);
    }
}

class Settings{
    static int health=6;
    final static String[] words=new String[]{"инкапсуляция", "искушение", "взбднуть", "радость", "расположение", "аллея", "армагеддон", "Санкт-Петербург"};
    static Stack<String> man=new Stack<String>(){{push(" \\");push("\n/");push("\\");push("|");push("\n/");push(" O ");}};
    static StringBuilder manPicture=new StringBuilder();
    static char[] hangmanWord;
    static char[] blank;

    public static void Start(){
        System.out.println(String.format("\t\tДОБРО ПОЖАЛОВАТЬ В ПРОСТУЮ ВИСЕЛИЦУ!\nУ вас будет всего %s попыток, чтобы отгадать слово, иначе вас повесят!", health));
        Random generator=new Random();
        hangmanWord=words[generator.nextInt(0,words.length)].toCharArray();
        blank=new char[hangmanWord.length];
        Arrays.fill(blank,'_');
        for(int i=0;i<hangmanWord.length;i++){
            if('-'==hangmanWord[i]){
                blank[i]='-';
            }
        }
    }

    public static void Contin(Scanner sca){
        if(health<1){System.out.println(manPicture.toString()+"\nПОВЕШЕН");return;}
        boolean temp=false;
        System.out.print(String.format("%s\n%s\nУ вас попыток: %s\nВВЕДИТЕ БУКВУ:",manPicture.toString(),ToStr(blank),health));
        char letter=sca.next().charAt(0);
        for(int i=0;i<hangmanWord.length;i++){
            if(Character.toLowerCase(letter)==Character.toLowerCase(hangmanWord[i])){
                blank[i]=letter;
                temp=true;
            }
        }
        if(temp){
            if (!(new String(blank).contains("_"))) {System.out.println("ВЫ ОТГОДАЛИ СЛОВО");return;}
            Contin(sca);
        }
        else {
            DrawMan(manPicture);
            Contin(sca);
        }
    }
    private static void DrawMan(StringBuilder manPicture){
        health--;
        manPicture.append(man.pop());
    }
    private static String ToStr(char ...words){
        StringBuilder res=new StringBuilder();
        for(char i:words){
            res.append(i);
        }
        return res.toString();
    }
}