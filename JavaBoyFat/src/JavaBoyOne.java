import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.io.*;
import java.applet.*;
import java.net.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;
import javax.sound.sampled.*;

public class JavaBoyOne extends java.applet.Applet implements Runnable,
		KeyListener, WindowListener, MouseListener, ActionListener,
		ItemListener {
	
	public static boolean runningAsApplet;
	Cartridge cartridge;
	Dmgcpu dmgcpu;
	private boolean saveToWebEnable = false;
	private PopupMenu popupMenu;
	private String versionString;
	private CheckboxMenuItem soundCheck;
	boolean keyListener = false;
	 GameBoyScreenOne mainWindow;
	GameLink gameLink;
	
	String debuggerQueue = null;
	boolean debuggerPending = false;
	boolean debuggerActive = false;
	private boolean appletRunning = true;
	short breakpointAddr = -1;
	short breakpointBank;
	short breakpointInstr;
	
//===========================================
	public JavaBoyOne(String cartName) {
		mainWindow = new GameBoyScreenOne("JavaBoy " + versionString, this);
		mainWindow.setVisible(true);
		this.requestFocus();
		// mainWindow.addKeyListener(this);
		mainWindow.addWindowListener(this);
		// cartridge = new Cartridge(cartName, mainWindow);
		// dmgcpu = new Dmgcpu(cartridge, mainWindow);
	}
//===========================================
	public String getVersion() {
		return versionString;
	}
//===========================================
	public void setApplet(boolean bool) {
		runningAsApplet = bool;
	}
//===========================================
	public void start() {
		Thread p = new Thread(this);

		runningAsApplet = true;
		setupKeyboard();

		cartridge = new Cartridge(getParameter("ROMIMAGE"), this);
		dmgcpu = new Dmgcpu(cartridge, null, this);
		dmgcpu.graphicsChip.setMagnify(getSize().width / 160);
		this.requestFocus();
		p.start();

		saveToWebEnable = getParameter("SAVERAMURL") != null;

		popupMenu = new java.awt.PopupMenu();
		popupMenu.add("JavaBoy " + versionString);
		popupMenu.add("-");
		popupMenu.add("Define Controls");
		popupMenu.add(soundCheck = new java.awt.CheckboxMenuItem("Sound"));
		popupMenu.add("-");
		popupMenu.add("Reset");

		if (saveToWebEnable) {
			popupMenu.add("Save");
			popupMenu.add("Load");
		}

		/*popupMenu.add("-");
		popupMenu.add("Size: 1x");
		popupMenu.add("Size: 2x");
		popupMenu.add("Size: 3x");
		popupMenu.add("Size: 4x");
		popupMenu.add("-");
		//popupMenu.add("FrameSkip: 0");
		popupMenu.add("FrameSkip: 1");
		popupMenu.add("FrameSkip: 2");
		popupMenu.add("FrameSkip: 3");
		popupMenu.add("-");
		popupMenu.add("JavaBoy Website");
		popupMenu.addActionListener(this);*/

		soundCheck.addItemListener(this);
		setSoundEnable((getParameter("SOUND") == null)
				|| (getParameter("SOUND").equals("ON")));

		addMouseListener(this);
		add(popupMenu);

		cartridge.outputCartInfo();

	}

	// ========================================
	public void setupKeyboard() {
		if (!keyListener) {
			if (!runningAsApplet) {
				System.out.println("Starting key controls");
				mainWindow.addKeyListener(this);
				mainWindow.requestFocus();
			} else {
				addKeyListener(this);
			}
			keyListener = true;
		}
	}
	
	
	
	
	
	public void setSoundEnable(boolean on) {
		soundCheck.setState(on);
		if (dmgcpu.soundChip != null) {
			dmgcpu.soundChip.channel1Enable = on;
			dmgcpu.soundChip.channel2Enable = on;
			dmgcpu.soundChip.channel3Enable = on;
			dmgcpu.soundChip.channel4Enable = on;
		}
	}
	
	
	public void dispose() {
		if (cartridge != null)
			cartridge.dispose();
		if (dmgcpu != null)
			dmgcpu.dispose();
	}

	
	public void queueDebuggerCommand(String command) {
		debuggerQueue = command;
		debuggerPending = true;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("Size: 1x")) {
			dmgcpu.graphicsChip.setMagnify(1);
			imageSizeChanged = true;
		} else if (e.getActionCommand().equals("Size: 2x")) {
			dmgcpu.graphicsChip.setMagnify(2);
			imageSizeChanged = true;
		} else if (e.getActionCommand().equals("Size: 3x")) {
			dmgcpu.graphicsChip.setMagnify(3);
			imageSizeChanged = true;
		} else if (e.getActionCommand().equals("Size: 4x")) {
			dmgcpu.graphicsChip.setMagnify(4);
			imageSizeChanged = true;
		} else if (e.getActionCommand().equals("Define Controls")) {
			new DefineControls();
		} else if (e.getActionCommand().equals("FrameSkip: 0")) {
			dmgcpu.graphicsChip.frameSkip = 1;
		} else if (e.getActionCommand().equals("FrameSkip: 1")) {
			dmgcpu.graphicsChip.frameSkip = 2;
		} else if (e.getActionCommand().equals("FrameSkip: 2")) {
			dmgcpu.graphicsChip.frameSkip = 3;
		} else if (e.getActionCommand().equals("FrameSkip: 3")) {
			dmgcpu.graphicsChip.frameSkip = 4;
		} else if (e.getActionCommand().equals("Reset")) {
			dmgcpu.reset();
		} else if (e.getActionCommand().equals("Save")) {

			try {
				dmgcpu.cartridge.saveBatteryRAMToWeb(new URL(
						getParameter("SAVERAMURL")), getParameter("USERNAME"),
						dmgcpu);
			} catch (MalformedURLException ex) {

			}

			// f.hide();

		} else if (e.getActionCommand().equals("Load")) {
			try {
				// dmgcpu.terminateProcess();
				dmgcpu.cartridge.loadBatteryRAMFromWeb(new URL(
						getParameter("LOADRAMURL")), getParameter("USERNAME"),
						dmgcpu);
				// do {
				// java.lang.Thread.sleep(1);
				// } while (!dmgcpu.cartridge.needsResetEnable());
				System.out.println("Resetting...");
				// dmgcpu.terminate = false;
				// dmgcpu.execute(-1);
			} catch (Exception ex) {

			}

		} else if (e.getActionCommand().equals("JavaBoy Website")) {
			try {
				getAppletContext().showDocument(new URL(WEBSITE_URL), "_new");
			} catch (MalformedURLException ex) {

			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		if (runningAsApplet) {
			System.out.println("Starting...");
			/*
			 * if (getParameter("AUTOSCRIPT") == null) {
			 * executeDebuggerScript("startup.scp"); } else {
			 * executeDebuggerScript(getParameter("AUTOSCRIPT")); }
			 */

			do {
				dmgcpu.reset();
				dmgcpu.execute(-1);
			} while (appletRunning);
		}

		do {
			// repaint();
			try {
				getDebuggerMenuChoice();
				java.lang.Thread.sleep(1);
				this.requestFocus();
			} catch (InterruptedException e) {
				System.out.println("Interrupted!");
				break;
			}
		} while (appletRunning);
		dispose();
		System.out.println("Thread terminated");

		// TODO Auto-generated method stub

	}
	public void getDebuggerMenuChoice() {
		String command = new String("");
		char b = 0;
		if (dmgcpu != null)
			dmgcpu.terminate = false;

		if (!debuggerActive) {
			if (debuggerPending) {
				debuggerPending = false;
				executeDebuggerCommand(debuggerQueue);
			}
		} else {
			System.out.println();
			System.out.print("Enter command ('?' for help)> ");

			while ((b != 10) && (appletRunning)) {
				try {
					b = (char) System.in.read();
				} catch (IOException e) {

				}
				if (b >= 32)
					command = command + b;
			}
		}
		if (appletRunning)
			executeDebuggerCommand(command);
	}
	
	
	public void executeDebuggerCommand(String commands) {
		StringTokenizer commandTokens = new StringTokenizer(commands, ";");

		while (commandTokens.hasMoreTokens()) {
			executeSingleDebuggerCommand(commandTokens.nextToken());
		}
	}
	
	/** Execute a single debugger command */
	public void executeSingleDebuggerCommand(String command) {
		StringTokenizer st = new StringTokenizer(command, " \n");

		try {
			switch (st.nextToken().charAt(0)) {
			case '?':
				displayDebuggerHelp();
				break;
			case 'd':
				try {
					int address = Integer.valueOf(st.nextToken(), 16)
							.intValue();
					int length = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Dumping " + JavaBoy.hexWord(length)
							+ " instructions starting from "
							+ JavaBoy.hexWord(address));
					hexDump(address, length);
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("Invalid number of parameters to 'd' command.");
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				break;
			case 'i':
				try {
					int address = Integer.valueOf(st.nextToken(), 16)
							.intValue();
					int length = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Dissasembling "
							+ JavaBoy.hexWord(length)
							+ " instructions starting from "
							+ JavaBoy.hexWord(address));
					dmgcpu.disassemble(address, length);
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("Invalid number of parameters to 'i' command.");
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				break;
			case 'p':
				try {
					int length = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Dissasembling "
							+ JavaBoy.hexWord(length)
							+ " instructions starting from program counter ("
							+ JavaBoy.hexWord(dmgcpu.pc) + ")");
					dmgcpu.disassemble(dmgcpu.pc, length);
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("Invalid number of parameters to 'p' command.");
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				break;
			case 'k':
				try {
					String keyName = st.nextToken();
					dmgcpu.ioHandler.toggleKey(keyName);
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("Invalid number of parameters to 'k' command.");
				}
				break;
			case 'r':
				try {
					String reg = st.nextToken();
					try {
						int val = Integer.valueOf(st.nextToken(), 16)
								.intValue();
						if (dmgcpu.setRegister(reg, val)) {
							System.out.println("- Set register " + reg + " to "
									+ JavaBoy.hexWord(val) + ".");
						} else {
							System.out.println("Invalid register name '" + reg
									+ "'.");
						}
					} catch (java.util.NoSuchElementException e) {
						System.out.println("Missing value");
					} catch (NumberFormatException e) {
						System.out.println("Error parsing hex value.");
					}
				} catch (java.util.NoSuchElementException e) {
					showRegisterValues();
				}
				break;
			case 's':
				System.out.println("- CPU Reset");
				dmgcpu.reset();
				break;
			case 'o':
				repaint();
				break;
			case 'c':
				try {
					String fn = st.nextToken();
					System.out.println("* Starting execution of script '" + fn
							+ "'");
					executeDebuggerScript(fn);
					System.out.println("* Script execution finished");
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("* Starting execution of default script");
					executeDebuggerScript("default.scp");
					System.out.println("* Script execution finished");
				}
				break;
			case 'q':
				cartridge.restoreMapping();
				System.out.println("- Quitting debugger");
				deactivateDebugger();
				break;
			case 'e':
				int address;
				try {
					address = Integer.valueOf(st.nextToken(), 16).intValue();
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
					break;
				} catch (java.util.NoSuchElementException e) {
					System.out.println("Missing address.");
					break;
				}
				System.out.print("- Written data starting at "
						+ JavaBoy.hexWord(address) + " (");
				if (!st.hasMoreTokens()) {
					System.out.println("");
					System.out.println("Missing data value(s)");
					break;
				}
				try {
					while (st.hasMoreTokens()) {
						short data = (byte) Integer.valueOf(st.nextToken(), 16)
								.intValue();
						dmgcpu.addressWrite(address++, data);
						// System.out.print(JavaBoy.hexByte(unsign(data)));
						// if (st.hasMoreTokens()) System.out.print(", ");
					}
					System.out.println(")");
				} catch (NumberFormatException e) {
					System.out.println("");
					System.out.println("Error parsing hex value.");
				}
				break;
			case 'b':
				try {
					if (breakpointAddr != -1) {
						cartridge.saveMapping();
						cartridge.mapRom(breakpointBank);
						dmgcpu.addressWrite(breakpointAddr, breakpointInstr);
						cartridge.restoreMapping();
						breakpointAddr = -1;
						System.out.println("- Clearing original breakpoint");
						dmgcpu.setBreakpoint(false);
					}
					int addr = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Setting breakpoint at "
							+ JavaBoy.hexWord(addr));
					breakpointAddr = (short) addr;
					breakpointInstr = (short) dmgcpu.addressRead(addr);
					breakpointBank = (short) cartridge.currentBank;
					dmgcpu.addressWrite(addr, 0x52);
					dmgcpu.setBreakpoint(true);
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("Invalid number of parameters to 'b' command.");
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				break;
			case 'g':
				setupKeyboard();
				cartridge.restoreMapping();
				dmgcpu.execute(-1);
				break;
			case 'n':
				try {
					int state = Integer.valueOf(st.nextToken(), 16).intValue();
					if (state == 1) {
						dmgcpu.interruptsEnabled = true;
					} else {
						dmgcpu.interruptsEnabled = false;
					}
				} catch (java.util.NoSuchElementException e) {
					// Nothing!
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				System.out.print("- Interrupts are ");
				if (dmgcpu.interruptsEnabled)
					System.out.println("enabled.");
				else
					System.out.println("disabled.");

				break;
			case 'm':
				try {
					int bank = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Mapping ROM bank "
							+ JavaBoy.hexByte(bank) + " to 4000 - 7FFFF");
					cartridge.saveMapping();
					cartridge.mapRom(bank);
				} catch (java.util.NoSuchElementException e) {
					System.out.println("- ROM Mapper state:");
					System.out.println(cartridge.getMapInfo());
				}
				break;
			case 't':
				try {
					cartridge.restoreMapping();
					int length = Integer.valueOf(st.nextToken(), 16).intValue();
					System.out.println("- Executing " + JavaBoy.hexWord(length)
							+ " instructions starting from program counter ("
							+ JavaBoy.hexWord(dmgcpu.pc) + ")");
					dmgcpu.execute(length);
					if (dmgcpu.pc == breakpointAddr) {
						dmgcpu.addressWrite(breakpointAddr, breakpointInstr);
						breakpointAddr = -1;
						System.out.println("- Breakpoint instruction restored");
					}
				} catch (java.util.NoSuchElementException e) {
					System.out
							.println("- Executing instruction at program counter ("
									+ JavaBoy.hexWord(dmgcpu.pc) + ")");
					dmgcpu.execute(1);
				} catch (NumberFormatException e) {
					System.out.println("Error parsing hex value.");
				}
				break;
			default:
				System.out
						.println("Command not recognized.  Try looking at the help page.");
			}
		} catch (java.util.NoSuchElementException e) {
			// Do nothing
		}

	}
	
	public void hexDump(int address, int length) {
		int start = address & 0xFFF0;
		int lines = length / 16;
		if (lines == 0)
			lines = 1;

		for (int l = 0; l < lines; l++) {
			System.out.print(JavaBoy.hexWord(start + (l * 16)) + "   ");
			for (int r = start + (l * 16); r < start + (l * 16) + 16; r++) {
				System.out.print(JavaBoy.hexByte(unsign(dmgcpu.addressRead(r)))
						+ " ");
			}
			System.out.print("   ");
			for (int r = start + (l * 16); r < start + (l * 16) + 16; r++) {
				char c = (char) dmgcpu.addressRead(r);
				if ((c >= 32) && (c <= 128)) {
					System.out.print(c);
				} else {
					System.out.print(".");
				}
			}
			System.out.println("");
		}
	}
	
	public void displayDebuggerHelp() {
		System.out
				.println("Enter a command followed by it's parameters (all values in hex):");
		System.out.println("?                     Display this help screen");
		System.out
				.println("c [script]            Execute _c_ommands from script file [default.scp]");
		System.out.println("s                     Re_s_et CPU");
		System.out
				.println("r                     Show current register values");
		System.out
				.println("r reg val             Set value of register reg to value val");
		System.out
				.println("e addr val [val] ...  Write values to RAM / ROM starting at address addr");
		System.out
				.println("d addr len            Hex _D_ump len bytes starting at addr");
		System.out
				.println("i addr len            D_i_sassemble len instructions starting at addr");
		System.out
				.println("p len                 Disassemble len instructions starting at current PC");
		System.out.println("n                     Show interrupt state");
		System.out.println("n 1|0                 Enable/disable interrupts");
		System.out
				.println("t [len]               Execute len instructions starting at current PC [1]");
		System.out.println("g                     Execute forever");
		System.out
				.println("o                     Output Gameboy screen to applet window");
		System.out.println("b addr                Set breakpoint at addr");
		System.out.println("k [keyname]           Toggle Gameboy key");
		System.out.println("m bank                _M_ap to ROM bank");
		System.out.println("m                     Display current ROM mapping");
		System.out.println("q                     Quit debugger interface");
		System.out.println("<CTRL> + C            Quit JavaBoy");
	}
	public void executeDebuggerScript(String fn) {
		InputStream is = null;
		BufferedReader in = null;
		try {

			if (JavaBoy.runningAsApplet) {
				is = new URL(getDocumentBase(), fn).openStream();
			} else {
				is = new FileInputStream(new File(fn));
			}
			in = new BufferedReader(new InputStreamReader(is));

			String line;
			while (((line = in.readLine()) != null) && (!dmgcpu.terminate)
					&& (appletRunning)) {
				executeDebuggerCommand(line);
			}

			in.close();
		} catch (IOException e) {
			System.out.println("Can't open script file '" + fn + "'!");
		}
	}
	
	/** Output the current register values to the console */
	public void showRegisterValues() {
		System.out.println("- Register values");
		System.out.print("A = " + JavaBoy.hexWord(dmgcpu.a) + "    BC = "
				+ JavaBoy.hexWord(dmgcpu.b) + JavaBoy.hexWord(dmgcpu.c));
		System.out.print("    DE = " + JavaBoy.hexByte(dmgcpu.d)
				+ JavaBoy.hexByte(dmgcpu.e));
		System.out.print("    HL = " + JavaBoy.hexWord(dmgcpu.hl));
		System.out.print("    PC = " + JavaBoy.hexWord(dmgcpu.pc));
		System.out.println("    SP = " + JavaBoy.hexWord(dmgcpu.sp));
		System.out.println("F = " + JavaBoy.hexByte(unsign((short) dmgcpu.f)));
	}
	
	public void deactivateDebugger() {
		debuggerActive = false;
	}
	static public short unsign(short b) {
		if (b < 0) {
			return (short) (256 + b);
		} else {
			return b;
		}
	}



	
}
