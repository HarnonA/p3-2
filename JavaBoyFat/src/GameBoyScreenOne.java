/*

JavaBoy
                                  
COPYRIGHT (C) 2001 Neil Millstone and The Victoria University of Manchester
                                                                         ;;;
This program is free software; you can redistribute it and/or modify it
under the terms of the GNU General Public License as published by the Free
Software Foundation; either version 2 of the License, or (at your option)
any later version.        

This program is distributed in the hope that it will be useful, but WITHOUT
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
more details.


You should have received a copy of the GNU General Public License along with
this program; if not, write to the Free Software Foundation, Inc., 59 Temple
Place - Suite 330, Boston, MA 02111-1307, USA.

 */

import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.io.*;
import java.applet.*;
import java.net.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.util.StringTokenizer;
import java.util.Hashtable;
import javax.sound.sampled.*;

/**
 * This class is used when JavaBoy is run as an application to provide the user
 * interface.
 */

class GameBoyScreenOnea extends Frame implements ActionListener, ComponentListener, ItemListener {
	GraphicsChip graphicsChip = null;
	JavaBoyOne javBoy;

	CheckboxMenuItem viewFrameCounter;
	CheckboxMenuItem viewSpeedThrottle;

	CheckboxMenuItem viewFrameSkip0;
	CheckboxMenuItem viewFrameSkip1;
	CheckboxMenuItem viewFrameSkip2;
	CheckboxMenuItem viewFrameSkip3;
	CheckboxMenuItem viewFrameSkip4;

	CheckboxMenuItem soundChannel1Enable;
	CheckboxMenuItem soundChannel2Enable;
	CheckboxMenuItem soundChannel3Enable;
	CheckboxMenuItem soundChannel4Enable;

	CheckboxMenuItem soundFreq11;
	CheckboxMenuItem soundFreq22;
	CheckboxMenuItem soundFreq44;

	CheckboxMenuItem soundBuffer200;
	CheckboxMenuItem soundBuffer300;
	CheckboxMenuItem soundBuffer400;

	CheckboxMenuItem networkServer;
	CheckboxMenuItem fileGameboyColor;

	CheckboxMenuItem viewSingle;
	CheckboxMenuItem viewDouble;
	CheckboxMenuItem viewTriple;
	CheckboxMenuItem viewQuadrouple;

	CheckboxMenuItem networkPrinter;

	TextField hostAddress;
	Dialog connectDialog;
	
	static public int[][] schemeColours = {
		{ 0xFFFFFFFF, 0xFFAAAAAA, 0xFF555555, 0xFF000000, 0xFFFFFFFF,
				0xFFAAAAAA, 0xFF555555, 0xFF000000, 0xFFFFFFFF, 0xFFAAAAAA,
				0xFF555555, 0xFF000000 },

		{ 0xFFFFFFC0, 0xFFC2C41E, 0xFF949600, 0xFF656600, 0xFFFFFFC0,
				0xFFC2C41E, 0xFF949600, 0xFF656600, 0xFFFFFFC0, 0xFFC2C41E,
				0xFF949600, 0xFF656600 },

		{ 0xFFC0C0FF, 0xFF4040FF, 0xFF0000FF, 0xFF000080, 0xFFC0FFC0,
				0xFF00C000, 0xFF008000, 0xFF004000, 0xFFC0FFC0, 0xFF00C000,
				0xFF008000, 0xFF004000 },

		{ 0xFFFFC0FF, 0xFF8080FF, 0xFFC000C0, 0xFF800080, 0xFFFFFF40,
				0xFFC0C000, 0xFFFF4040, 0xFF800000, 0xFF80FFFF, 0xFF00C0C0,
				0xFF008080, 0xFF004000 } };
	
	static public String[] schemeNames = { "Standard colours", "LCD shades",
		"Midnight garden", "Psychadelic" };

	CheckboxMenuItem[] schemes = new CheckboxMenuItem[schemeNames.length];

	/** Creates the JavaBoy interface, with the specified title text */
	public GameBoyScreenOne(String s, JavaBoyOne jb) {
		super(s);
		javBoy = jb;
		setWindowSize(2);

		this.addComponentListener(this);

		MenuBar menuBar = new MenuBar();
		//===========================================
		MenuItem fileOpen = new MenuItem("Open ROM");
		fileOpen.setActionCommand("Open ROM");
		fileOpen.addActionListener(this);
		//===========================================
		MenuItem fileEmulate = new MenuItem("Emulate");
		fileEmulate.setActionCommand("Emulate");
		fileEmulate.addActionListener(this);
		//===========================================
		MenuItem fileReset = new MenuItem("Reset");
		fileReset.setActionCommand("Reset");
		fileReset.addActionListener(this);
		//===========================================
		MenuItem filePause = new MenuItem("Pause");
		filePause.setActionCommand("Pause");
		filePause.addActionListener(this);
		//===========================================
		MenuItem fileControls = new MenuItem("Define controls...");
		fileControls.setActionCommand("Controls");
		fileControls.addActionListener(this);
		//===========================================
		fileGameboyColor = new CheckboxMenuItem("Use Gameboy Color features");
		fileGameboyColor.addItemListener(this);
		fileGameboyColor.setState(true);
		//===========================================
		MenuItem fileQuit = new MenuItem("Exit");
		fileQuit.setActionCommand("Exit");
		fileQuit.addActionListener(this);
		//===========================================
		//+++++++++++++++++++++++++++++++++++++++++++
		//===========================================
		viewSingle = new CheckboxMenuItem("Size: actual");
		viewSingle.addItemListener(this);
		//===========================================
		viewDouble = new CheckboxMenuItem("Size: 2x");
		viewDouble.addItemListener(this);
		//===========================================
		viewTriple = new CheckboxMenuItem("Size: 3x");
		viewTriple.addItemListener(this);
		//===========================================
		viewQuadrouple = new CheckboxMenuItem("Size: 4x");
		viewQuadrouple.addItemListener(this);
		//===========================================
		//===========================================
		viewFrameSkip0 = new CheckboxMenuItem("Frame skip: 0");
		viewFrameSkip0.addItemListener(this);
		//===========================================
		viewFrameSkip1 = new CheckboxMenuItem("Frame skip: 1");
		viewFrameSkip1.addItemListener(this);
		//===========================================
		viewFrameSkip2 = new CheckboxMenuItem("Frame skip: 2");
		viewFrameSkip2.addItemListener(this);
		//===========================================
		viewFrameSkip3 = new CheckboxMenuItem("Frame skip: 3");
		viewFrameSkip3.addItemListener(this);
		//===========================================
		viewFrameSkip4 = new CheckboxMenuItem("Frame skip: 4");
		viewFrameSkip4.addItemListener(this);

		viewFrameCounter = new CheckboxMenuItem("Frame counter");
		viewFrameCounter.setActionCommand("Frame counter");
		viewFrameCounter.addActionListener(this);

		viewSpeedThrottle = new CheckboxMenuItem("Speed throttle");
		viewSpeedThrottle.setActionCommand("Speed throttle");
		viewSpeedThrottle.addActionListener(this);
		viewSpeedThrottle.setState(true);

		CheckboxMenuItem viewStandardCols = new CheckboxMenuItem(
				"Standard colours");
		viewStandardCols.addItemListener(this);
		viewStandardCols.setState(true);

		CheckboxMenuItem viewLcdCols = new CheckboxMenuItem("LCD shades");
		viewLcdCols.addItemListener(this);

		CheckboxMenuItem viewGreenyCols = new CheckboxMenuItem("Greeny shades");
		viewGreenyCols.addItemListener(this);

		MenuItem debugEnter = new MenuItem("Enter debugger");
		debugEnter.setActionCommand("Enter debugger");
		debugEnter.addActionListener(this);

		MenuItem debugExecuteScript = new MenuItem("Execute script");
		debugExecuteScript.setActionCommand("Execute script");
		debugExecuteScript.addActionListener(this);

		soundChannel1Enable = new CheckboxMenuItem("Channel 1 (Square wave)");
		soundChannel1Enable.addItemListener(this);
		soundChannel1Enable.setState(true);

		soundChannel2Enable = new CheckboxMenuItem("Channel 2 (Square wave)");
		soundChannel2Enable.addItemListener(this);
		soundChannel2Enable.setState(true);

		soundChannel3Enable = new CheckboxMenuItem("Channel 3 (Voluntary wave)");
		soundChannel3Enable.addItemListener(this);
		soundChannel3Enable.setState(true);

		soundChannel4Enable = new CheckboxMenuItem("Channel 4 (Noise)");
		soundChannel4Enable.addItemListener(this);
		soundChannel4Enable.setState(true);

		soundFreq11 = new CheckboxMenuItem("Sample rate: 11khz");
		soundFreq11.addItemListener(this);

		soundFreq22 = new CheckboxMenuItem("Sample rate: 22khz");
		soundFreq22.addItemListener(this);

		soundFreq44 = new CheckboxMenuItem("Sample rate: 44khz");
		soundFreq44.addItemListener(this);
		soundFreq44.setState(true);

		soundBuffer200 = new CheckboxMenuItem("Buffer length: 200ms");
		soundBuffer200.addItemListener(this);
		soundBuffer200.setState(true);

		soundBuffer300 = new CheckboxMenuItem("Buffer length: 300ms");
		soundBuffer300.addItemListener(this);

		soundBuffer400 = new CheckboxMenuItem("Buffer length: 400ms");
		soundBuffer400.addItemListener(this);

		MenuItem networkConnect = new MenuItem("Connect to client");
		networkConnect.setActionCommand("Connect to client");
		networkConnect.addActionListener(this);

		networkServer = new CheckboxMenuItem("Allow connections");
		networkServer.addItemListener(this);

		networkPrinter = new CheckboxMenuItem("Emulate printer");
		networkPrinter.addItemListener(this);
		//===========================================
		//++++++++++++++++++++++++++++++++++++++++++
		Menu fileMenu = new Menu("File");
		Menu viewMenu = new Menu("View");
		Menu soundMenu = new Menu("Sound");
		Menu networkMenu = new Menu("Serial Port");
		Menu debugMenu = new Menu("Debug");
		//++++++++++++++++++++++++++++++++++++++++++
		//===========================================
		fileMenu.add(fileOpen);
		fileMenu.add(fileReset);
		fileMenu.add(filePause);
		fileMenu.add(fileEmulate);
		fileMenu.add(fileGameboyColor);
		fileMenu.add(fileControls);
		fileMenu.add(new MenuItem("-"));
		fileMenu.add(fileQuit);

		viewMenu.add(viewSingle);
		viewMenu.add(viewDouble);
		viewMenu.add(viewTriple);
		viewMenu.add(viewQuadrouple);
		viewMenu.add(new MenuItem("-"));
		viewMenu.add(viewFrameSkip0);
		viewMenu.add(viewFrameSkip1);
		viewMenu.add(viewFrameSkip2);
		viewMenu.add(viewFrameSkip3);
		viewMenu.add(viewFrameSkip4);
		viewMenu.add(new MenuItem("-"));
		viewMenu.add(viewFrameCounter);
		viewMenu.add(viewSpeedThrottle);
		viewMenu.add(new MenuItem("-"));

		for (int r = 0; r < schemeNames.length; r++) {
			schemes[r] = new CheckboxMenuItem(schemeNames[r]);
			schemes[r].addItemListener(this);
			viewMenu.add(schemes[r]);
			if (r == 0)
				schemes[r].setState(true);
		}

		soundMenu.add(soundChannel1Enable);
		soundMenu.add(soundChannel2Enable);
		soundMenu.add(soundChannel3Enable);
		soundMenu.add(soundChannel4Enable);
		soundMenu.add(new MenuItem("-"));
		soundMenu.add(soundFreq11);
		soundMenu.add(soundFreq22);
		soundMenu.add(soundFreq44);
		soundMenu.add(new MenuItem("-"));
		soundMenu.add(soundBuffer200);
		soundMenu.add(soundBuffer300);
		soundMenu.add(soundBuffer400);

		networkMenu.add(networkConnect);
		networkMenu.add(networkServer);
		networkMenu.add(networkPrinter);

		debugMenu.add(debugEnter);
		debugMenu.add(debugExecuteScript);

		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(soundMenu);
		menuBar.add(networkMenu);
		menuBar.add(debugMenu);

		setMenuBar(menuBar);

	}

	/** Creates a connection dialog for Game Link connections */
	public void makeConnectDialog() {
		connectDialog = new Dialog(this, "Game Link connect", true);
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();

		p1.add(new Label("Host address:"), "Center");

		hostAddress = new TextField(35);
		p2.add(hostAddress, "Center");

		Button connectButton = new Button("Connect");
		connectButton.setActionCommand("Connect ok");
		connectButton.addActionListener(this);

		Button cancelButton = new Button("Cancel");
		cancelButton.setActionCommand("Connect cancel");
		cancelButton.addActionListener(this);

		p3.add(cancelButton, "West");
		p3.add(connectButton, "East");

		connectDialog.add(p1, "North");
		connectDialog.add(p2, "Center");
		connectDialog.add(p3, "South");

		connectDialog.setSize(350, 125);
		connectDialog.setResizable(false);
		connectDialog.show();
	}

	/**
	 * Sets the current GraphicsChip object which is responsible for drawing the
	 * screen
	 */
	public void setGraphicsChip(GraphicsChip g) {
		graphicsChip = g;
	}

	public void update(Graphics g) {
		paint(g);
	}

	/** Clear the frame to white */
	public void clearWindow() {
		Dimension d = getSize();
		Graphics g = getGraphics();
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, d.width, d.height);
	}

	public void componentHidden(ComponentEvent e) {

	}

	public void componentMoved(ComponentEvent e) {

	}

	public void componentResized(ComponentEvent e) {
		clearWindow();
	}

	public void componentShown(ComponentEvent e) {

	}

	/**
	 * Resize the Frame to a suitable size for a Gameboy with a magnification
	 * given
	 */
	public void setWindowSize(int mag) {
		setSize(175 * mag + 20, 174 * mag + 20);
	}

	public void setSoundFreq() {
		if ((javBoy.dmgcpu != null) && (javBoy.dmgcpu.soundChip.soundEnabled)) {
			if (soundFreq11.getState()) {
				javBoy.dmgcpu.soundChip.setSampleRate(11025);
			}
			if (soundFreq22.getState()) {
				javBoy.dmgcpu.soundChip.setSampleRate(22050);
			}
			if (soundFreq44.getState()) {
				javBoy.dmgcpu.soundChip.setSampleRate(44100);
			}
		}
	}

	public void setBufferLength() {
		if ((javBoy.dmgcpu != null) && (javBoy.dmgcpu.soundChip.soundEnabled)) {
			if (soundBuffer200.getState()) {
				javBoy.dmgcpu.soundChip.setBufferLength(200);
			}
			if (soundBuffer300.getState()) {
				javBoy.dmgcpu.soundChip.setBufferLength(300);
			}
			if (soundBuffer400.getState()) {
				javBoy.dmgcpu.soundChip.setBufferLength(400);
			}
		}
	}

	public void setChannelEnable() {
		if ((javBoy.dmgcpu != null) && (javBoy.dmgcpu.soundChip.soundEnabled)) {
			javBoy.dmgcpu.soundChip.channel1Enable = soundChannel1Enable
					.getState();
			javBoy.dmgcpu.soundChip.channel2Enable = soundChannel2Enable
					.getState();
			javBoy.dmgcpu.soundChip.channel3Enable = soundChannel3Enable
					.getState();
			javBoy.dmgcpu.soundChip.channel4Enable = soundChannel4Enable
					.getState();
		}
	}

	public void setMagnify() {
		if (javBoy.dmgcpu != null) {
			if (viewSingle.getState()) {
				javBoy.dmgcpu.graphicsChip.setMagnify(1);
			}
			if (viewDouble.getState()) {
				javBoy.dmgcpu.graphicsChip.setMagnify(2);
			}
			if (viewTriple.getState()) {
				javBoy.dmgcpu.graphicsChip.setMagnify(3);
			}
			if (viewQuadrouple.getState()) {
				javBoy.dmgcpu.graphicsChip.setMagnify(4);
			}
		}
	}

	public void setFrameSkip() {
		if (javBoy.dmgcpu != null) {
			if (viewFrameSkip0.getState()) {
				graphicsChip.frameSkip = 1;
			}
			if (viewFrameSkip1.getState()) {
				graphicsChip.frameSkip = 2;
			}
			if (viewFrameSkip2.getState()) {
				graphicsChip.frameSkip = 3;
			}
			if (viewFrameSkip3.getState()) {
				graphicsChip.frameSkip = 4;
			}
			if (viewFrameSkip4.getState()) {
				graphicsChip.frameSkip = 5;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		// System.out.println("Command: " + command);

		if (command.equals("Open ROM")) {

			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.terminate = true;
				if (javBoy.cartridge != null)
					javBoy.cartridge.dispose();
				if (javBoy.dmgcpu != null) {
					javBoy.dmgcpu.dispose();
					javBoy.dmgcpu = null;
				}
				clearWindow();
			}

			FileDialog fd = new FileDialog(this, "Open ROM");
			fd.show();

			if (fd.getFile() != null) {
				javBoy.cartridge = new Cartridge(fd.getDirectory()
						+ fd.getFile(), this);
				javBoy.dmgcpu = new Dmgcpu(javBoy.cartridge, javBoy.gameLink,
						this);
				// applet.gameBoyPrinter = new GameBoyPrinter();
				if (javBoy.gameLink != null)
					javBoy.gameLink.setDmgcpu(javBoy.dmgcpu);
				setGraphicsChip(javBoy.dmgcpu.graphicsChip);
				setSoundFreq();
				setBufferLength();
				setMagnify();
				setFrameSkip();
				setChannelEnable();
				javBoy.dmgcpu.allowGbcFeatures = fileGameboyColor.getState();
				javBoy.dmgcpu.reset();
			}

		} else if (command.equals("Frame counter")) {
			viewFrameCounter.setState(!viewFrameCounter.getState());
		} else if (command.equals("Speed throttle")) {
			viewSpeedThrottle.setState(!viewSpeedThrottle.getState());
		} else if (command.equals("Emulate")) {
			if ((javBoy.cartridge != null) && (javBoy.cartridge.cartridgeReady)) {
				javBoy.queueDebuggerCommand("g");
				javBoy.dmgcpu.terminate = true;
			} else {
				new ModalDialog(this, "Error", "You need to load a ROM before",
						"you select 'Emulate'.");
			}
		} else if (command.equals("Reset")) {
			javBoy.queueDebuggerCommand("s;g");
			javBoy.dmgcpu.terminate = true;
		} else if (command.equals("Pause")) {
			javBoy.dmgcpu.terminate = true;
		} else if (command.equals("Controls")) {
			// makeControlsDialog();
			new DefineControls();
		} else if (command.equals("Execute script")) {
			if (javBoy.dmgcpu != null) {
				FileDialog fd = new FileDialog(this, "Execute debugger script");
				fd.show();
				javBoy.queueDebuggerCommand("c " + fd.getDirectory()
						+ fd.getFile());
				javBoy.dmgcpu.terminate = true;
			} else {
				new ModalDialog(this, "Error",
						"Load a ROM before executing a debugger script", "");
			}
		} else if (command.equals("Enter debugger")) {
			if (javBoy.dmgcpu != null) {
				javBoy.debuggerActive = true;
				javBoy.dmgcpu.terminate = true;
			} else {
				new ModalDialog(this, "Error",
						"Load a ROM before entering the debugger", "");
			}
		} else if (command.equals("1x")) {
			javBoy.dmgcpu.graphicsChip.setMagnify(1);
			setWindowSize(1);
			clearWindow();
		} else if (command.equals("2x")) {
			javBoy.dmgcpu.graphicsChip.setMagnify(2);
			setWindowSize(2);
			clearWindow();
		} else if (command.equals("3x")) {
			javBoy.dmgcpu.graphicsChip.setMagnify(3);
			setWindowSize(3);
			clearWindow();
		} else if (command.equals("4x")) {
			javBoy.dmgcpu.graphicsChip.setMagnify(4);
			setWindowSize(4);
			clearWindow();
		} else if (command.equals("Connect to client")) {
			makeConnectDialog();
		} else if (command.equals("Connect cancel")) {
			connectDialog.hide();
			connectDialog = null;
		} else if (command.equals("Connect ok")) {
			connectDialog.hide();
			connectDialog = null;
			javBoy.gameLink = new TCPGameLink(this, hostAddress.getText());
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.gameLink = javBoy.gameLink;
				javBoy.gameLink.setDmgcpu(javBoy.dmgcpu);
			}
		} else if (command.equals("Exit")) {
			javBoy.dispose();
			System.exit(0);
		}
	}

	public void setColourScheme(String command) {
		if (javBoy.dmgcpu == null) {
			new ModalDialog(this, "Error", "Load a ROM before selecting",
					"a colour scheme.");
			for (int r = 0; r < schemeNames.length; r++) {
				if (schemeNames[r] == command) {
					schemes[r].setState(false);
				}
			}
		} else {
			for (int r = 0; r < schemeNames.length; r++) {
				int set0 = schemeColours[r][0];
				int set1 = schemeColours[r][1];
				int set2 = schemeColours[r][2];
				int set3 = schemeColours[r][3];
				int set4 = schemeColours[r][4];
				int set5 = schemeColours[r][5];
				int set6 = schemeColours[r][6];
				int set7 = schemeColours[r][7];
				int set8 = schemeColours[r][8];
				int set9 = schemeColours[r][9];
				int set10 = schemeColours[r][10];
				int set11 = schemeColours[r][11];
				
				if (schemeNames[r] == command) {
					javBoy.dmgcpu.graphicsChip.backgroundPalette.setColours(
							set0, set1, set2, set3);

					javBoy.dmgcpu.graphicsChip.obj1Palette.setColours(
							set4, set5, set6, set7);

					javBoy.dmgcpu.graphicsChip.obj2Palette.setColours(
							set8, set9, set10, set11);
					javBoy.dmgcpu.graphicsChip.invalidateAll();
				} else {
					schemes[r].setState(false);
				}
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		String command = (String) e.getItem();
		System.out.println(command);
		if (command.equals("Channel 1 (Square wave)")) {
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.soundChip.channel1Enable = soundChannel1Enable
						.getState();
			}
		} else if (command.equals("Channel 2 (Square wave)")) {
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.soundChip.channel2Enable = soundChannel2Enable
						.getState();
			}
		} else if (command.equals("Channel 3 (Voluntary wave)")) {
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.soundChip.channel3Enable = soundChannel3Enable
						.getState();
			}
		} else if (command.equals("Channel 4 (Noise)")) {
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.soundChip.channel4Enable = soundChannel4Enable
						.getState();
			}
		} else if (command.equals("Size: actual")) {
			viewSingle.setState(true);
			viewDouble.setState(false);
			viewTriple.setState(false);
			viewQuadrouple.setState(false);
			setMagnify();
			setWindowSize(1);
		} else if (command.equals("Size: 2x")) {
			viewSingle.setState(false);
			viewDouble.setState(true);
			viewTriple.setState(false);
			viewQuadrouple.setState(false);
			setMagnify();
			setWindowSize(2);
		} else if (command.equals("Size: 3x")) {
			viewSingle.setState(false);
			viewDouble.setState(false);
			viewTriple.setState(true);
			viewQuadrouple.setState(false);
			setMagnify();
			setWindowSize(3);
		} else if (command.equals("Size: 4x")) {
			viewSingle.setState(false);
			viewDouble.setState(false);
			viewTriple.setState(false);
			viewQuadrouple.setState(true);
			setMagnify();
			setWindowSize(4);
		} else if (command.equals("Sample rate: 11khz")) {
			soundFreq22.setState(false);
			soundFreq44.setState(false);
			soundFreq11.setState(true);
			setSoundFreq();
		} else if (command.equals("Sample rate: 22khz")) {
			soundFreq11.setState(false);
			soundFreq44.setState(false);
			soundFreq22.setState(true);
			setSoundFreq();
		} else if (command.equals("Frame skip: 0")) {
			viewFrameSkip0.setState(true);
			viewFrameSkip1.setState(false);
			viewFrameSkip2.setState(false);
			viewFrameSkip3.setState(false);
			viewFrameSkip4.setState(false);
			setFrameSkip();
		} else if (command.equals("Frame skip: 1")) {
			viewFrameSkip0.setState(false);
			viewFrameSkip1.setState(true);
			viewFrameSkip2.setState(false);
			viewFrameSkip3.setState(false);
			viewFrameSkip4.setState(false);
			setFrameSkip();
		} else if (command.equals("Frame skip: 2")) {
			viewFrameSkip0.setState(false);
			viewFrameSkip1.setState(false);
			viewFrameSkip2.setState(true);
			viewFrameSkip3.setState(false);
			viewFrameSkip4.setState(false);
			setFrameSkip();
		} else if (command.equals("Frame skip: 3")) {
			viewFrameSkip0.setState(false);
			viewFrameSkip1.setState(false);
			viewFrameSkip2.setState(false);
			viewFrameSkip3.setState(true);
			viewFrameSkip4.setState(false);
			setFrameSkip();
		} else if (command.equals("Frame skip: 4")) {
			viewFrameSkip0.setState(false);
			viewFrameSkip1.setState(false);
			viewFrameSkip2.setState(false);
			viewFrameSkip3.setState(false);
			viewFrameSkip4.setState(true);
			setFrameSkip();
		} else if (command.equals("Sample rate: 44khz")) {
			soundFreq11.setState(false);
			soundFreq22.setState(false);
			soundFreq44.setState(true);
			setSoundFreq();
		} else if (command.equals("Buffer length: 200ms")) {
			soundBuffer300.setState(false);
			soundBuffer400.setState(false);
			soundBuffer200.setState(true);
			setBufferLength();
		} else if (command.equals("Buffer length: 300ms")) {
			soundBuffer200.setState(false);
			soundBuffer400.setState(false);
			soundBuffer300.setState(true);
			setBufferLength();
		} else if (command.equals("Buffer length: 400ms")) {
			soundBuffer200.setState(false);
			soundBuffer300.setState(false);
			soundBuffer400.setState(true);
			setBufferLength();
		} else if (command.equals("Use Gameboy Color features")) {
			if (javBoy.dmgcpu != null) {
				javBoy.dmgcpu.allowGbcFeatures = !javBoy.dmgcpu.allowGbcFeatures;
			} else {
				fileGameboyColor.setState(!fileGameboyColor.getState());
			}
		} else if (command.equals("Allow connections")) {
			if (javBoy.gameLink == null) {
				javBoy.gameLink = new TCPGameLink(this);
				if (javBoy.gameLink.serverRunning) {
					networkServer.setState(true);
				} else {
					networkServer.setState(false);
					javBoy.gameLink = null;
				}
				if (javBoy.dmgcpu != null) {
					javBoy.dmgcpu.gameLink = javBoy.gameLink;
					javBoy.gameLink.setDmgcpu(javBoy.dmgcpu);
				}
			} else {
				javBoy.gameLink.shutDown();
				javBoy.gameLink = null;
				if (javBoy.dmgcpu != null)
					javBoy.dmgcpu.gameLink = null;
			}
		} else if (command.equals("Emulate printer")) {
			if (networkPrinter.getState()) {
				if (javBoy.gameLink != null) {
					javBoy.gameLink.shutDown();
					networkServer.setState(false);
				}
				javBoy.gameLink = new GameBoyPrinter();
				javBoy.gameLink.setDmgcpu(javBoy.dmgcpu);
				javBoy.dmgcpu.gameLink = javBoy.gameLink;
			} else {
				javBoy.gameLink.shutDown();
				javBoy.gameLink = null;
			}
		} else {
			setColourScheme(command);
		}

	}

	public void paint(Graphics g) {
		if (graphicsChip != null) {
			Dimension d = getSize();
			int x = (d.width / 2) - (graphicsChip.width / 2);
			int y = (d.height / 2) - (graphicsChip.height / 2);
			boolean b = graphicsChip.draw(g, x, y + 20, this);
			if (viewFrameCounter.getState()) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, d.height - 20, d.width, 20);
				g.setColor(new Color(0, 0, 0));
				g.drawString(graphicsChip.getFPS() + " frames per second", 10,
						d.height - 7);
			}
		}
	}
}
