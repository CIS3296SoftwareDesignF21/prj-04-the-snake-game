import java.util.concurrent.CopyOnWriteArrayList;

public class Snake {
    private Direction direction;
    private Point head;
    private CopyOnWriteArrayList<Point> tail;

    
    public Snake(int x, int y) {
        this.head = new Point(x, y);
        this.direction = Direction.RIGHT;
        this.tail = new CopyOnWriteArrayList<Point>();
        
        this.tail.add(new Point(0, 0));
        this.tail.add(new Point(0, 0));
        this.tail.add(new Point(0, 0));
    }

    public void move(int speed) {


        //ArrayList newTail = new ArrayList<Point>();

        //create a thread safe arraylist

        CopyOnWriteArrayList<Point> newTail = new CopyOnWriteArrayList<Point>();
        
        for (int i = 0, size = tail.size(); i < size; i++) {
            Point current = tail.get(i);
            Point previous = i == 0 ? head : tail.get(i - 1);

            newTail.add(new Point(previous.getX(), previous.getY()));
        }
        
        this.tail = newTail;
        
        this.head.move(this.direction, speed);
    }
    
    public void addTail() {
        Point last = this.tail.get(this.tail.size() - 1);
        
        this.tail.add(new Point(-10, -10));


    }

    //i think this is where we need to edit for the treads for the direction
    public void turn(Direction d) {       
        if (d.isX() && direction.isY() || d.isY() && direction.isX()) {
           direction = d; 
        }       
    }
    
    public CopyOnWriteArrayList<Point> getTail() {
        return this.tail;
    }
    
    public Point getHead() {
        return this.head;
    }

}
