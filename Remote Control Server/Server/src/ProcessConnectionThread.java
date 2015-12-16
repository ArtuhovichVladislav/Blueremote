import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.microedition.io.*;

public class ProcessConnectionThread extends Thread {
	private StreamConnection comm = null;
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String ENTER = "enter";
	public static final String CALC = "calc";
	public static final String COMP = "comp";
	public static final String BROW = "brow";
	public static final String NOTE = "note";
	public static final String KEYB = "keyboard";
	public static final String CLOSE = "close";
	public static final String BACK = "back";
	public static final String FORW = "forw";
	public static final String ESC = "esc";
	public static final String RIGHT_MOUSE_BTN = "right_mouse";
	public static final String LEFT_MOUSE_BTN = "left_mouse";

	public static final String PLAY_BTN = "play";
	public static final String NEXT_BTN = "next";
	public static final String PREV_BTN = "prev";
	public static final String VOL_UP = "vol_up";
	public static final String VOL_DOWN = "vol_down";
	public static final String VOL_MUTE = "mute";
	public static final String VOL_UNMUTE = "unmute";
	public static final String MEDIA_PLAYER = "player";

	public static final String FROM_START_BTN = "from_start";
	public static final String FROM_NOW_BTN = "from_now";

	public static final String PREV_SLIDE_BTN = "prev_slide";
	public static final String FORW_SLIDE_BTN = "forw_slide";
	public static final String EXIT_FULLSCREEN_BTN = "exit_fullscreen";

	public static final String START = "start";
	public static final String SHUTDOWN = "shutdown";

	public static final String COPY = "copy";
	public static final String PASTE = "paste";
	public static final String CUT = "cut";
	public static final String SELECT_ALL = "select_all";
	public static final String SHOW_DESKTOP = "show_desktop";
	public static final String FULL_SCREEN = "full_screen";
	public static final String MINIMIZE_WINDOW = "minimize_window";
	public static final String SELECT_WINDOW = "select_window";
	public static final String F1 = "F1";
	public static final String F2 = "F2";
	public static final String F3 = "F3";
	public static final String F4 = "F4";
	public static final String F5 = "F5";
	public static final String F6 = "F6";
	public static final String F7 = "F7";
	public static final String F8 = "F8";
	public static final String F9 = "F9";
	public static final String F10 = "F10";
	public static final String F11 = "F11";
	public static final String F12 = "F12";
	public static final String POWER_POINT = "powerpoint";

	Boolean disconnect = false;
	int counter;
	public static final String BACK_SPACE_BTN = "back_space";

	public ProcessConnectionThread(StreamConnection conn) {
		comm = conn;
	}
	
	public Boolean disconnect() {
		return disconnect;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = comm.openInputStream();
			System.out.println("Waiting for the input");
			System.out.println(InputContext.getInstance().getLocale());
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					inputStream));
			Robot robo = new Robot();
			
			while (true) {
				disconnect = false;
				//Thread.sleep(100);
				
				String lineRead = bReader.readLine();
				System.out.println(lineRead);
				//InputContext.getInstance().selectInputMethod(Locale.);

				if (lineRead == null) {
					System.out.println("Process terminating");
					disconnect = true;
					break;
				} else
					switch (lineRead) {
						case START:
							robo.keyPress(KeyEvent.VK_WINDOWS);
							robo.keyRelease(KeyEvent.VK_WINDOWS);
							break;
						case SHUTDOWN:
							Runtime.getRuntime().exec("rundll32.exe user32.dll,LockWorkStation");
							break;
						case RIGHT:
							robo.keyPress(KeyEvent.VK_RIGHT);
							robo.keyRelease(KeyEvent.VK_RIGHT);
							break;
						case LEFT:
							robo.keyPress(KeyEvent.VK_LEFT);
							robo.keyRelease(KeyEvent.VK_LEFT);
							break;
						case CALC:
							Runtime.getRuntime().exec("calc");
							break;
						case UP:
							robo.keyPress(KeyEvent.VK_UP);
							robo.keyRelease(KeyEvent.VK_UP);
							break;
						case DOWN:
							robo.keyPress(KeyEvent.VK_DOWN);
							robo.keyRelease(KeyEvent.VK_DOWN);
							break;
						case COMP:
							Runtime.getRuntime().exec("explorer");
							break;
						case NOTE:
							Runtime.getRuntime().exec("notepad");
							break;
						case ENTER:
							robo.keyPress(KeyEvent.VK_ENTER);
							robo.keyRelease(KeyEvent.VK_ENTER);
							break;
						case BACK:
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_LEFT);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_LEFT);
							break;
						case CLOSE:
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_F4);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_F4);
							break;
						case FORW:
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_RIGHT);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_RIGHT);
							break;
						case ESC:
							robo.keyPress(KeyEvent.VK_ESCAPE);
							robo.keyRelease(KeyEvent.VK_ESCAPE);
							break;
						case BROW:
							Runtime.getRuntime().exec(
									new String[] { "cmd", "/c", "start chrome" });
							break;
						case KEYB:
							robo.keyPress(KeyEvent.VK_WINDOWS);
							robo.keyRelease(KeyEvent.VK_WINDOWS);
							break;
						case RIGHT_MOUSE_BTN:
							robo.mousePress(InputEvent.BUTTON3_MASK);
							robo.mouseRelease(InputEvent.BUTTON3_MASK);
							break;
						case LEFT_MOUSE_BTN:
							robo.mousePress(InputEvent.BUTTON1_MASK);
							robo.mouseRelease(InputEvent.BUTTON1_MASK);
							break;
						case PLAY_BTN:
							// ///////////////////////////////////////////////////////////////////
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_NUMPAD5);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_NUMPAD5);
							break;
						case NEXT_BTN:
							// ////////////////////////////////////////////////////////////////////
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_NUMPAD6);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_NUMPAD4);
							break;
						case PREV_BTN:
							// ////////////////////////////////////////////////////////////////////
							robo.keyPress(KeyEvent.VK_ALT);
							robo.keyPress(KeyEvent.VK_NUMPAD4);
							robo.keyRelease(KeyEvent.VK_ALT);
							robo.keyRelease(KeyEvent.VK_NUMPAD4);
							break;
						case VOL_UP:
							Runtime.getRuntime()
									.exec(new String[] { "cmd", "/c",
											"start /B nircmdc changesysvolume 3000 " });
							break;
						case VOL_DOWN:
							Runtime.getRuntime()
									.exec(new String[] { "cmd", "/c",
											"start /B nircmdc changesysvolume -3000 " });
							break;
						case VOL_MUTE:
							if(counter % 2 == 0) {
								Runtime.getRuntime().exec(
										new String[]{"cmd", "/c",
												"start /B nircmdc mutesysvolume 0"});
							}
							else {
								Runtime.getRuntime().exec(
										new String[] { "cmd", "/c",
												"start /B nircmdc mutesysvolume 1" });
							}
							counter++;
							break;
						case MEDIA_PLAYER:
							Runtime.getRuntime().exec(
									new String[] { "cmd", "/c", "start aimp3" });
							break;
						case FROM_START_BTN:
							robo.keyPress(KeyEvent.VK_F5);
							robo.keyRelease(KeyEvent.VK_F5);
							break;
						case FROM_NOW_BTN:
							robo.keyPress(KeyEvent.VK_SHIFT);
							robo.keyPress(KeyEvent.VK_F5);
							robo.keyRelease(KeyEvent.VK_SHIFT);
							robo.keyRelease(KeyEvent.VK_F5);
							break;
						case PREV_SLIDE_BTN:
							robo.keyPress(KeyEvent.VK_LEFT);
							robo.keyRelease(KeyEvent.VK_LEFT);
							break;
						case FORW_SLIDE_BTN:
							robo.keyPress(KeyEvent.VK_RIGHT);
							robo.keyRelease(KeyEvent.VK_RIGHT);
							break;
						case EXIT_FULLSCREEN_BTN:
							robo.keyPress(KeyEvent.VK_ESCAPE);
							robo.keyRelease(KeyEvent.VK_ESCAPE);
							break;
						case COPY:
							robo.keyPress(KeyEvent.VK_CONTROL);
							robo.keyPress(KeyEvent.VK_C);
							robo.keyRelease(KeyEvent.VK_CONTROL);
							robo.keyRelease(KeyEvent.VK_C);
							break;
						case PASTE:
							robo.keyPress(KeyEvent.VK_CONTROL);
							robo.keyPress(KeyEvent.VK_V);
							robo.keyRelease(KeyEvent.VK_CONTROL);
							robo.keyRelease(KeyEvent.VK_V);
							break;
						case CUT:
							robo.keyPress(KeyEvent.VK_CONTROL);
							robo.keyPress(KeyEvent.VK_X);
							robo.keyRelease(KeyEvent.VK_CONTROL);
							robo.keyRelease(KeyEvent.VK_X);
							break;
						case SHOW_DESKTOP:
							robo.keyPress(KeyEvent.VK_WINDOWS);
							robo.keyPress(KeyEvent.VK_D);
							robo.keyRelease(KeyEvent.VK_WINDOWS);
							robo.keyRelease(KeyEvent.VK_D);
							break;
						case SELECT_ALL:
							robo.keyPress(KeyEvent.VK_CONTROL);
							robo.keyPress(KeyEvent.VK_A);
							robo.keyRelease(KeyEvent.VK_CONTROL);
							robo.keyRelease(KeyEvent.VK_A);
							break;
						case FULL_SCREEN:
							robo.keyPress(KeyEvent.VK_WINDOWS);
							robo.keyPress(KeyEvent.VK_UP);
							robo.keyRelease(KeyEvent.VK_WINDOWS);
							robo.keyRelease(KeyEvent.VK_UP);
							break;
						case MINIMIZE_WINDOW:
							robo.keyPress(KeyEvent.VK_WINDOWS);
							robo.keyPress(KeyEvent.VK_DOWN);
							robo.keyRelease(KeyEvent.VK_WINDOWS);
							robo.keyRelease(KeyEvent.VK_DOWN);
							break;
						case SELECT_WINDOW:
							Runtime.getRuntime()
									.exec(new String[] { "cmd", "/c",
											"start explorer shell:::{3080F90E-D7AD-11D9-BD98-0000947B0257}" });
							break;
						case F1:
							robo.keyPress(KeyEvent.VK_F1);
							robo.keyRelease(KeyEvent.VK_F1);
							break;
						case F2:
							robo.keyPress(KeyEvent.VK_F2);
							robo.keyRelease(KeyEvent.VK_F2);
							break;
						case F3:
							robo.keyPress(KeyEvent.VK_F3);
							robo.keyRelease(KeyEvent.VK_F3);
							break;
						case F4:
							robo.keyPress(KeyEvent.VK_F4);
							robo.keyRelease(KeyEvent.VK_F4);
							break;
						case F5:
							robo.keyPress(KeyEvent.VK_F5);
							robo.keyRelease(KeyEvent.VK_F5);
							break;
						case F6:
							robo.keyPress(KeyEvent.VK_F6);
							robo.keyRelease(KeyEvent.VK_F6);
							break;
						case F7:
							robo.keyPress(KeyEvent.VK_F7);
							robo.keyRelease(KeyEvent.VK_F7);
							break;
						case F8:
							robo.keyPress(KeyEvent.VK_F8);
							robo.keyRelease(KeyEvent.VK_F8);
							break;
						case F9:
							robo.keyPress(KeyEvent.VK_F9);
							robo.keyRelease(KeyEvent.VK_F9);
							break;
						case F10:
							robo.keyPress(KeyEvent.VK_F10);
							robo.keyRelease(KeyEvent.VK_F10);
							break;
						case F11:
							robo.keyPress(KeyEvent.VK_F11);
							robo.keyRelease(KeyEvent.VK_F11);
							break;
						case F12:
							robo.keyPress(KeyEvent.VK_F12);
							robo.keyRelease(KeyEvent.VK_F12);
							break;
						case POWER_POINT:
							Runtime.getRuntime().exec(
									new String[] { "cmd", "/c", "start POWERPNT" });
							break;
						case BACK_SPACE_BTN:
							robo.keyPress(KeyEvent.VK_BACK_SPACE);
							robo.keyRelease(KeyEvent.VK_BACK_SPACE);
							break;
						default:
							if (lineRead.contains(",")) {

								float movex = Float
										.parseFloat(lineRead.split(",")[0]);// extract
								// movement
								// in
								// x
								// direction
								float movey = Float
										.parseFloat(lineRead.split(",")[1]);// extract
								// movement
								// in
								// y
								// direction
								Point point = MouseInfo.getPointerInfo()
										.getLocation(); // Get
								// current
								// mouse
								// position
								float nowx = point.x;
								float nowy = point.y;
								robo.mouseMove((int) (nowx + movex),
										(int) (nowy + movey));// Move mouse pointer
								// to
								// new location
							} else {
								switch (lineRead.charAt(0)) {
									case 'a':
										robo.keyPress(KeyEvent.VK_A);
										robo.keyRelease(KeyEvent.VK_A);
										break;
									case 'b':
										robo.keyPress(KeyEvent.VK_B);
										robo.keyRelease(KeyEvent.VK_B);
										break;
									case 'c':
										robo.keyPress(KeyEvent.VK_C);
										robo.keyRelease(KeyEvent.VK_C);
										break;
									case 'd':
										robo.keyPress(KeyEvent.VK_D);
										robo.keyRelease(KeyEvent.VK_D);
										break;
									case 'e':
										robo.keyPress(KeyEvent.VK_E);
										robo.keyRelease(KeyEvent.VK_E);
										break;
									case 'f':
										robo.keyPress(KeyEvent.VK_F);
										robo.keyRelease(KeyEvent.VK_F);
										break;
									case 'g':
										robo.keyPress(KeyEvent.VK_G);
										robo.keyRelease(KeyEvent.VK_G);
										break;
									case 'h':
										robo.keyPress(KeyEvent.VK_H);
										robo.keyRelease(KeyEvent.VK_H);
										break;
									case 'i':
										robo.keyPress(KeyEvent.VK_I);
										robo.keyRelease(KeyEvent.VK_I);
										break;
									case 'j':
										robo.keyPress(KeyEvent.VK_J);
										robo.keyRelease(KeyEvent.VK_J);
										break;
									case 'k':
										robo.keyPress(KeyEvent.VK_K);
										robo.keyRelease(KeyEvent.VK_K);
										break;
									case 'l':
										robo.keyPress(KeyEvent.VK_L);
										robo.keyRelease(KeyEvent.VK_L);
										break;
									case 'm':
										robo.keyPress(KeyEvent.VK_M);
										robo.keyRelease(KeyEvent.VK_M);
										break;
									case 'n':
										robo.keyPress(KeyEvent.VK_N);
										robo.keyRelease(KeyEvent.VK_N);
										break;
									case 'o':
										robo.keyPress(KeyEvent.VK_O);
										robo.keyRelease(KeyEvent.VK_O);
										break;
									case 'p':
										robo.keyPress(KeyEvent.VK_P);
										robo.keyRelease(KeyEvent.VK_P);
										break;
									case 'q':
										robo.keyPress(KeyEvent.VK_Q);
										robo.keyRelease(KeyEvent.VK_Q);
										break;
									case 'r':
										robo.keyPress(KeyEvent.VK_R);
										robo.keyRelease(KeyEvent.VK_R);
										break;
									case 's':
										robo.keyPress(KeyEvent.VK_S);
										robo.keyRelease(KeyEvent.VK_S);
										break;
									case 't':
										robo.keyPress(KeyEvent.VK_T);
										robo.keyRelease(KeyEvent.VK_T);
										break;
									case 'u':
										robo.keyPress(KeyEvent.VK_U);
										robo.keyRelease(KeyEvent.VK_U);
										break;
									case 'v':
										robo.keyPress(KeyEvent.VK_V);
										robo.keyRelease(KeyEvent.VK_V);
										break;
									case 'w':
										robo.keyPress(KeyEvent.VK_W);
										robo.keyRelease(KeyEvent.VK_W);
										break;
									case 'x':
										robo.keyPress(KeyEvent.VK_X);
										robo.keyRelease(KeyEvent.VK_X);
										break;
									case 'y':
										robo.keyPress(KeyEvent.VK_Y);
										robo.keyRelease(KeyEvent.VK_Y);
										break;
									case 'z':
										robo.keyPress(KeyEvent.VK_Z);
										robo.keyRelease(KeyEvent.VK_Z);
										break;
									case 'A':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_A);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_A);
										break;
									case 'B':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_B);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_B);
										break;
									case 'C':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_C);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_C);
										break;
									case 'D':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_D);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_D);
										break;
									case 'E':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_E);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_E);
										break;
									case 'F':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_F);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_F);
										break;
									case 'G':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_G);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_G);
										break;
									case 'H':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_H);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_H);
										break;
									case 'I':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_I);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_I);
										break;
									case 'J':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_J);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_J);
										break;
									case 'K':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_K);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_K);
										break;
									case 'L':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_L);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_L);
										break;
									case 'M':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_M);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_M);
										break;
									case 'N':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_N);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_N);
										break;
									case 'O':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_O);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_O);
										break;
									case 'P':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_P);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_P);
										break;
									case 'Q':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_Q);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_Q);
										break;
									case 'R':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_R);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_R);
										break;
									case 'S':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_S);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_S);
										break;
									case 'T':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_T);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_T);
										break;
									case 'U':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_U);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_U);
										break;
									case 'V':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_V);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_V);
										break;
									case 'W':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_W);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_W);
										break;
									case 'X':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_X);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_X);
										break;
									case 'Y':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_Y);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_Y);
										break;
									case 'Z':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_Z);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_Z);
										break;
									case '`':
										robo.keyPress(KeyEvent.VK_BACK_QUOTE);
										robo.keyRelease(KeyEvent.VK_BACK_QUOTE);
										break;
									case '~':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_BACK_QUOTE);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_BACK_QUOTE);
										break;
									case '!':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_1);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_1);
										break;
									case '@':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_2);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_2);
										break;
									case '#':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_3);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_3);
										break;
									case '$':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_4);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_4);
										break;
									case '%':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_5);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_5);
										break;
									case '^':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_6);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_6);
										break;
									case '&':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_7);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_7);
										break;
									case '*':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_8);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_8);
										break;
									case '(':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_9);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_9);
										break;
									case ')':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_0);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_0);
										break;
									case '-':
										robo.keyPress(KeyEvent.VK_MINUS);
										robo.keyRelease(KeyEvent.VK_MINUS);
										break;
									case '_':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_MINUS);
										robo.keyRelease(KeyEvent.VK_MINUS);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										break;
									case '=':
										robo.keyPress(KeyEvent.VK_EQUALS);
										robo.keyRelease(KeyEvent.VK_EQUALS);
										break;
									case '+':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_EQUALS);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_EQUALS);
										break;
									case '[':
										robo.keyPress(KeyEvent.VK_OPEN_BRACKET);
										robo.keyRelease(KeyEvent.VK_OPEN_BRACKET);
										break;
									case '{':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_OPEN_BRACKET);
										robo.keyRelease(KeyEvent.VK_OPEN_BRACKET);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										break;
									case ']':
										robo.keyPress(KeyEvent.VK_CLOSE_BRACKET);
										robo.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
										break;
									case '}':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_CLOSE_BRACKET);
										robo.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										break;
									case ';':
										robo.keyPress(KeyEvent.VK_SEMICOLON);
										robo.keyRelease(KeyEvent.VK_SEMICOLON);
										break;
									case ':':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_SEMICOLON);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_SEMICOLON);
										break;
									case '\'':;
										robo.keyPress(KeyEvent.VK_QUOTE);
										robo.keyRelease(KeyEvent.VK_QUOTE);
										break;
									case '"':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_QUOTE);
										robo.keyRelease(KeyEvent.VK_QUOTE);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										break;
									case '\\':
										robo.keyPress(KeyEvent.VK_BACK_SLASH);
										robo.keyRelease(KeyEvent.VK_BACK_SLASH);
										break;
									case '|':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_BACK_SLASH);
										robo.keyRelease(KeyEvent.VK_BACK_SLASH);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										break;
									case ',':
										robo.keyPress(KeyEvent.VK_COMMA);
										robo.keyRelease(KeyEvent.VK_COMMA);
										break;
									case '<':
										robo.keyPress(KeyEvent.VK_COMMA);
										robo.keyRelease(KeyEvent.VK_COMMA);
										break;
									case '.':
										robo.keyPress(KeyEvent.VK_PERIOD);
										robo.keyRelease(KeyEvent.VK_PERIOD);
										break;
									case '>':
										robo.keyPress(KeyEvent.VK_PERIOD);
										robo.keyRelease(KeyEvent.VK_PERIOD);
										break;
									case '/':
										robo.keyPress(KeyEvent.VK_SLASH);
										robo.keyRelease(KeyEvent.VK_SLASH);
										break;
									case '?':
										robo.keyPress(KeyEvent.VK_SHIFT);
										robo.keyPress(KeyEvent.VK_SLASH);
										robo.keyRelease(KeyEvent.VK_SHIFT);
										robo.keyRelease(KeyEvent.VK_SLASH);
										break;
									case '0':
										robo.keyPress(KeyEvent.VK_0);
										robo.keyRelease(KeyEvent.VK_0);
										break;
									case '1':
										robo.keyPress(KeyEvent.VK_1);
										robo.keyRelease(KeyEvent.VK_1);
										break;
									case '2':
										robo.keyPress(KeyEvent.VK_2);
										robo.keyRelease(KeyEvent.VK_2);
										break;
									case '3':
										robo.keyPress(KeyEvent.VK_3);
										robo.keyRelease(KeyEvent.VK_3);
										break;
									case '4':
										robo.keyPress(KeyEvent.VK_4);
										robo.keyRelease(KeyEvent.VK_4);
										break;
									case '5':
										robo.keyPress(KeyEvent.VK_5);
										robo.keyRelease(KeyEvent.VK_5);
										break;
									case '6':
										robo.keyPress(KeyEvent.VK_6);
										robo.keyRelease(KeyEvent.VK_6);
										break;
									case '7':
										robo.keyPress(KeyEvent.VK_7);
										robo.keyRelease(KeyEvent.VK_7);
										break;
									case '8':
										robo.keyPress(KeyEvent.VK_8);
										robo.keyRelease(KeyEvent.VK_8);
										break;
									case '9':
										robo.keyPress(KeyEvent.VK_9);
										robo.keyRelease(KeyEvent.VK_9);
										break;
									case ' ':
										robo.keyPress(KeyEvent.VK_SPACE);
										robo.keyRelease(KeyEvent.VK_SPACE);
										break;
								}
							}
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
