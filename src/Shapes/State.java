package Shapes;

public class State {
    private String type;
    private String state;
    public State(){
        state="OnAir";

    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
