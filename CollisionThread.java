
public class CollisionThread extends Thread {
    private final int colltype;
    private final Snake snake;
    private final Point obstacle1;
    private final Point obstacle2;
    private final Point obstacle3;
    public boolean collision = false;
    
	public CollisionThread(int colltype, Snake snake, Point obstacle1, Point obstacle2, Point obstacle3) {
		this.colltype = colltype;
		this.snake = snake;
		this.obstacle1 = obstacle1;
		this.obstacle2 = obstacle2;
		this.obstacle3 = obstacle3;
		
		
    }
	
	public void run(){  
	     // hitting a boundary is colltype 0, hitting itself is colltype 1, and object collision is coll type 2
		 Point head = snake.getHead();
		if(colltype == 0){
	         collision = head.getX() <= 20
	                || head.getX() >= GameRender.WIDTH + 10
	                || head.getY() <= 40
	                || head.getY() >= GameRender.HEIGHT + 30;

		}else if(colltype == 1) {
			 for(Point t : snake.getTail()) {
		            collision = collision || head.equals(t);
		        }
		}else {
			 if (snake.getHead().intersects(obstacle1, 20) || snake.getHead().intersects(obstacle2, 20) || snake.getHead().intersects(obstacle3, 20)) {
	                collision = true;
	            }
		}

	   } 
	public boolean getCollision() {
		return collision;
	}
}
