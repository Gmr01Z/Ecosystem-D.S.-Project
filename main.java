import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        river riverA = new river(40 );
        animal[] aArr = riverA.getRiver();
        riverA.assign();
        showGraphics(riverA);
        for(int i = 0; i < 50; i++){
            move(riverA);

        }
        }



    public static void print(river a){
        for(int i = 0; i < a.getRiver().length; i++){
            System.out.print(a.getRiver()[i]);
            System.out.print(" ");
        }
    }
    //1bear -1fish 0null
    public static int check(int aPosition, river a, int move){
        if(a.getRiver()[aPosition+move] != null && move != 0) {
            if (a.getRiver()[aPosition + move].getIdentifier().equals("bear")) {
                return 1;
            } else if (a.getRiver()[aPosition + move].getIdentifier().equals("fish")) {
                return -1;
            }
        }
        return 0;
    }

    public static animal[] react(int aPosition, river a, int move){
        animal anml = a.getRiver()[aPosition];
        animal[] aArr = a.getRiver();
        if(anml == null){
        }else if(isBear(anml)){
            if(check(aPosition, a, move) == 0){
                aArr[aPosition] = null;
                aArr[aPosition + move] = new bear(aPosition + move);
            }else if(check(aPosition, a, move) == -1){
                aArr[aPosition] = null;
                aArr[aPosition + move] = new bear(aPosition + move);
            }else if(check(aPosition, a, move) == 1){
                aArr[decision(findNull(aArr))] = new bear(decision(findNull(aArr)));
            }
        }else if(isFish(anml)){
            if(check(aPosition, a, move) == 0){
                aArr[aPosition] = null;
                aArr[aPosition + move] = new fish(aPosition + move);
            }else if(check(aPosition, a, move) == -1){
                aArr[decision(findNull(aArr))] = new fish(decision(findNull(aArr)));
            }else if(check(aPosition, a, move) == 1){
                aArr[aPosition] = null;
            }
        }
        return aArr;
    }


    public static boolean isBear(animal anml){
        return anml.getIdentifier().equals("bear");
    }
    public static boolean isFish(animal anml){
        return anml.getIdentifier().equals("fish");
    }
    public static ArrayList<Integer> findNull(animal[] aArr){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < aArr.length; i++){
            if(aArr[i] == null){
                list.add(i);
            }
        }
        return list;
    }
    public static int decision(ArrayList<Integer> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    public static void clearScreen(){
        try {
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            }
        } catch(Exception e){

        }
    }

    public static void move(river riverA) {
        animal[] aArr = riverA.getRiver();
        for (int i = 0; i < riverA.getRiver().length; i++) {
            if (riverA.getRiver()[i] != null) {
                if (i != 0 && i != aArr.length - 1) {
                    react(i, riverA, riverA.getRiver()[i].move());
                } else if (i == 0) {
                    react(i, riverA, riverA.getRiver()[i].leftEdgeMove());
                } else if (i == aArr.length - 1) {
                    react(i, riverA, riverA.getRiver()[i].rightEdgeMove());
                }
                clearScreen();
            }
            if (findNull(riverA.getRiver()).size() == 0) {
                break;
            }
            showGraphics(riverA);
            clearScreen();
        }
    }
    public static void showGraphics(river riverA){
        String river = "";
        animal[] aArr = riverA.getRiver();
        for(int i = 0; i < aArr.length-1; i++){
            if(aArr[i] != null) {
                if (isFish(aArr[i])) {
                    river += "\uD83D\uDC1F";
                } else if (isBear(aArr[i])) {
                    river += "\uD83D\uDC3B";
                }
            }else{
                river += "  ";
            }
        }
        System.out.println();
        System.out.print("\u001B[44m" + river );
        System.out.println();
    }
}
