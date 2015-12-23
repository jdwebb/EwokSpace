
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

public class robotAlpha {

	 Robot robot = new Robot();
	
	public static void main(String [] args) throws AWTException {
		new robotAlpha();
	}
	public robotAlpha() throws AWTException {
        robot.delay(2500);
        
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SPACE);
        
        robot.delay(45);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SPACE);
        
        robot.delay(300);
        
        type("t");
        type("e");
        type("r");
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(25);
        
        robot.delay(5000);
        
        type("telnet towel.blinkenlights.nl");
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(25);
        
        // To stop it, type Ctrl-] and then 'quit'
        
	}
	public void type(String s){
		//robotAlpha.robot.keyPress(code);
		byte[] bytes = s.getBytes();
		
	    for (byte b : bytes) {
	      int code = b;
	      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
	      if (code > 96 && code < 123) code = code - 32;
	      robot.delay(40);
	      robot.keyPress(code);
	      robot.keyRelease(code);
	    }
	  }

}
