/**
 * TODO: Insert description here. (generated by srallabandi)
 */
public class Spider {

  public static void moveRightDown(int startX, int startY, int steps, boolean printFirst) {
    if (steps == 0) {
      return;
    }
    // move right by n steps
    for (int i = 0; i < steps; i++) {
      if (i == 0) {
        if (printFirst) {
          System.out.println(startX + ", " + startY);
        } 
      } else {
        System.out.println(startX + ", " + startY);
      }       
      startY = startY + 1;
    }
    startY = startY - 1;
    printFirst = false;
    // move down by n-1 steps
    // steps--;
    for (int i = 0; i < steps; i++) {
      if (i == 0) {
        if (printFirst) {
          System.out.println(startX + ", " + startY);
        } 
      } else {
        System.out.println(startX + ", " + startY);
      }       
      startX = startX  + 1;
    }  
    startX = startX - 1;
    steps--;
    moveLeftUp(startX, startY, steps, false);
  }

  public static void moveLeftUp(int startX, int startY, int steps, boolean printFirst) {
    if (steps == 0) {
      return;
    }
    // move left by n steps
    for (int i = 0; i < steps; i++) {
      if (i == 0) {
        if (printFirst) {
          System.out.println(startX + ", " + startY);
        } 
      } else {
        System.out.println(startX + ", " + startY);
      }      
      startY = startY - 1;
    }
    startY = startY + 1;
    // move up by n-1 steps
    steps--;
    for (int i = 0; i < steps; i++) {
      if (i == 0) {
        if (printFirst) {
          System.out.println(startX + ", " + startY);
        } 
      } else {
        System.out.println(startX + ", " + startY);
      }      
      startX = startX  - 1;
    }
    startX = startX  + 1;
    steps--;
    moveRightDown(startX, startY, steps, false);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    moveRightDown(1, 1, 5, true);

  }

}