import java.util.Arrays;

public class river {
    animal[] river = new animal[10];

    public river(){
    }

    public river(int x){
        river = new animal[x];
    }

    public animal[] getRiver() {
        return river;
    }

    public void setRiver(animal[] river) {
        this.river = river;
    }

    public void assign(){
        for(int i = 0; i < river.length; i++){
            int x = (int) (Math.random() * 12 + 1);
            if (x < 4) {
                river[i] = new bear(i);
            } else if (x < 7) {
                river[i] = new fish(i);
            }
        }
    }

}
