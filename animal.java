public class animal {
    protected String identifier;
    protected int position;
    public animal(int position){
        this.position = position;

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int move() {
        int x = (int) (Math.random() * 9);
        if (x < 3) {
            position++;
            return 1;
        } else if (x < 6) {
            position--;
            return -1;
        }else{
            return 0;
        }
    }
    public int leftEdgeMove() {
        double x = Math.random();
        if (x < 0.5) {
            position++;
            return 1;
        } else if (x >= 0.5) {
            return 0;
        }
        return 0;
    }
    public int rightEdgeMove() {
        double x = Math.random();
        if (x < 0.5) {
            position--;
            return -1;
        } else if (x >= 0.5) {
            return 0;
        }
        return 0;
    }

    public String toString() {
        return identifier;
    }

}
