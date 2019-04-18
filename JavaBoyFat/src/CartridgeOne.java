import java.applet.Applet;
import java.awt.Component;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;


public class CartridgeOne {
	
	final int[][] romSizeTable = { { 0, 2 }, { 1, 4 }, { 2, 8 }, { 3, 16 },
			{ 4, 32 }, { 5, 64 }, { 6, 128 }, { 7, 256 }, { 0x52, 72 },
			{ 0x53, 80 }, { 0x54, 96 } };

	private Component applet;
	private String romFileName;
	private int[] RTCReg = new int[5];
	private byte[] ram = new byte[0x10000];
	
	private boolean cartridgeReady = false;
	
	final String[] cartTypeTable = { "ROM Only", /* 00 */
			"ROM+MBC1", /* 01 */
			"ROM+MBC1+RAM", /* 02 */
			"ROM+MBC1+RAM+BATTERY", /* 03 */
			"Unknown", /* 04 */
			"ROM+MBC2", /* 05 */
			"ROM+MBC2+BATTERY", /* 06 */
			"Unknown", /* 07 */
			"ROM+RAM", /* 08 */
			"ROM+RAM+BATTERY", /* 09 */
			"Unknown", /* 0A */
			"Unsupported ROM+MMM01",/* 0B */
			"Unsupported ROM+MMM01+SRAM", /* 0C */
			"Unsupported ROM+MMM01+SRAM+BATTERY", /* 0D */
			"Unknown", /* 0E */
			"ROM+MBC3+TIMER+BATTERY", /* 0F */
			"ROM+MBC3+TIMER+RAM+BATTERY", /* 10 */
			"ROM+MBC3", /* 11 */
			"ROM+MBC3+RAM", /* 12 */
			"ROM+MBC3+RAM+BATTERY", /* 13 */
			"Unknown", /* 14 */
			"Unknown", /* 15 */
			"Unknown", /* 16 */
			"Unknown", /* 17 */
			"Unknown", /* 18 */
			"ROM+MBC5", /* 19 */
			"ROM+MBC5+RAM", /* 1A */
			"ROM+MBC5+RAM+BATTERY", /* 1B */
			"ROM+MBC5+RUMBLE", /* 1C */
			"ROM+MBC5+RUMBLE+RAM", /* 1D */
			"ROM+MBC5+RUMBLE+RAM+BATTERY" /* 1E */};
	
	final byte bZip = 1;
	final byte bJar = 2;
	final byte bGZip = 3;
	final byte bNotCompressed = 0;
	
	private byte[] rom;
	
	private int cartType;
	private int numBanks;
	
	private String romIntFileName;

	/*
	 * Construtor da "fita"
	 */
	
	
	public CartridgeOne(String romFileName, Component component) {
		this.romFileName = romFileName;
		InputStream inputStrm = null;
		try {
			inputStrm = openRom(romFileName, component, openRom(romFileName));
			final byte[] firstBank = new byte[0x04000];

			int total = 0x04000;
			do {
				total -= inputStrm.read(firstBank, 0x04000 - total, total); // Read the
																		// first
																		// bank
																		// (bank
																		// 0)
			} while (total > 0);

			cartType = firstBank[0x0147];

			numBanks = lookUpCartSize(firstBank[0x0148]); // Determine the
															// number of 16kb
															// rom banks

			// is.close();
			// is = new FileInputStream(new File(romFileName));
			rom = new byte[0x04000 * numBanks]; // Recreate the ROM array with
												// the correct size

			// Copy first bank into main rom array
			for (int r = 0; r < 0x4000; r++) {
				rom[r] = firstBank[r];
			}

			total = 0x04000 * (numBanks - 1); // Calculate total ROM size (first
												// one already loaded)
			do { // Read ROM into memory
				total -= inputStrm.read(rom, rom.length - total, total); // Read the
																	// entire
																	// ROM
			} while (total > 0);
			inputStrm.close();

			JavaBoy.debugLog("Loaded ROM '" + romFileName + "'.  " + numBanks
					+ " banks, " + (numBanks * 16) + "Kb.  " + getNumRAMBanks()
					+ " RAM banks.");
			JavaBoy.debugLog("Type: " + cartTypeTable[cartType] + " ("
					+ JavaBoy.hexByte(cartType) + ")");

			if (!verifyChecksum() && (component instanceof Frame)) {
				new ModalDialog((Frame) component, "Warning",
						"This cartridge has an invalid checksum.",
						"It may not execute correctly.");
			}

			if (!JavaBoy.runningAsApplet) {
				loadBatteryRam();
			}

			// Set up the real time clock
			/*Calendar rightNow = Calendar.getInstance();

			int days = rightNow.get(Calendar.DAY_OF_YEAR);
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int minute = rightNow.get(Calendar.MINUTE);
			int second = rightNow.get(Calendar.SECOND);

			RTCReg[SECONDS] = second;
			RTCReg[MINUTES] = minute;
			RTCReg[HOURS] = hour;
			RTCReg[DAYS_LO] = days & 0x00FF;
			RTCReg[DAYS_HI] = (days & 0x01FF) >> 8;

			realTimeStart = System.currentTimeMillis();
			lastSecondIncrement = realTimeStart;
*/
			cartridgeReady = true;

		} catch (IOException e) {
			System.out
					.println("Error opening ROM image '" + romFileName + "'!");
		} catch (IndexOutOfBoundsException e) {
			new ModalDialog((Frame) component, "Error",
					"Loading the ROM image failed.",
					"The file is not a valid Gameboy ROM.");
		}

	}
	
/*
* ====================================================================
*/
	
	//public InputStream openRom(String romFileName, Component component) {
	public byte openRom(String romFileName) {
		//byte bFormat;
		//boolean bFoundGBROM = false;
		//String romName = "None";

		if (romFileName.toUpperCase().indexOf("ZIP") > -1) {
			return 1;
		} else if (romFileName.toUpperCase().indexOf("JAR") > -1) {
			return 1;
		} else if (romFileName.toUpperCase().indexOf("GZ") > -1) {
			return 3;
		} else {
			return 0;
		}
		
	}

		// Simplest case, open plain gb or gbc file.
		// Open a cartridge not compacted
	public InputStream openRom(String romFileName, Component component, byte bFormat) {
		boolean bFoundGBROM = false;
		String romName = "None";
		if (bFormat == bNotCompressed) {
			try {
				romIntFileName = stripExtention(romFileName);
//********* Warning ******** | * | * | | * | * | | * | * | | * | * | | * | * | | * | * | | * | * | 
				if (JavaBoy.runningAsApplet) {
					return new java.net.URL(((Applet) (component)).getDocumentBase(),
							romFileName).openStream();
				} else {
					return new FileInputStream(new File(romFileName));
				}
			} catch (Exception e) {
				System.out.println("Cant open file");
				return null;
			}
		}

		// Should the ROM be loaded from a ZIP compressed file?
		if (bFormat == bZip) {
			System.out.println("Loading ZIP Compressed ROM");

			java.util.zip.ZipInputStream zip;

			try {

				if (JavaBoy.runningAsApplet) {
					zip = new java.util.zip.ZipInputStream(
							new java.net.URL(((Applet) (component)).getDocumentBase(),
									romFileName).openStream());
				} else {
					zip = new java.util.zip.ZipInputStream(
							new java.io.FileInputStream(romFileName));
				}

				// Check for valid files (GB or GBC ending in filename)
				java.util.zip.ZipEntry ze;

				while ((ze = zip.getNextEntry()) != null) {
					String str = ze.getName();
					if (str.toUpperCase().indexOf(".GB") > -1
							|| str.toUpperCase().indexOf(".GBC") > -1) {
						bFoundGBROM = true;
						romIntFileName = stripExtention(str);
						romName = str;
						// Leave loop if a ROM was found.
						break;
					}
				}
				// Show an error if no ROM file was found in the ZIP
				if (!bFoundGBROM) {
					if (JavaBoy.runningAsApplet) {
						new ModalDialog((Frame) component, "Error",
								"No GBx ROM found!", "");
					}
					System.err.println("No GBx ROM found!");
					throw new java.io.IOException("ERROR");
				}
				if (!JavaBoy.runningAsApplet) {
					System.out.println("Found " + romName);
				}
				return zip;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}

		if (bFormat == bGZip) {
			System.out.println("Loading GZIP Compressed ROM");
			romIntFileName = stripExtention(romFileName);
			try {
				if (JavaBoy.runningAsApplet) {
					return new java.util.zip.GZIPInputStream(
							new java.net.URL(((Applet) (component)).getDocumentBase(),
									romFileName).openStream());
				} else {
					return new java.util.zip.GZIPInputStream(
							new java.io.FileInputStream(romFileName));
				}
			} catch (Exception e) {
				System.out.println("Can't open file");
				return null;
			}
		}

		// Will never get here
		return null;
	}
	/*
	* ====================================================================
	*/	
	public int lookUpCartSize(int sizeByte) {
		int i = 0;
		while ((i < romSizeTable.length) && (romSizeTable[i][0] != sizeByte)) {
			i++;
		}

		if (romSizeTable[i][0] == sizeByte) {
			return romSizeTable[i][1];
		} else {
			return -1;
		}
	}
	/*
	* ====================================================================
	*/	
	
	/*
	 * retorna a string sem a extensão após o ponto
	 */
	
	String stripExtention(String filename) {
		if (filename.lastIndexOf('.') != -1) {
			return filename.substring(0, filename.lastIndexOf('.'));
		} else {
			return filename;
		}
	}
	/*
	* ====================================================================
	*/	
	
	
	public int getNumRAMBanks() {
		if (rom[0x149] == 0) return 0;
		else if (rom[0x149] == 2) return 1;
		else if (rom[0x149] == 3) return 4;
		else if (rom[0x149] == 4) return 16;
		else return 0;
	}
	/*
	* ====================================================================
	*/	
	
	public boolean verifyChecksum() {
		int checkSum = (JavaBoy.unsign(rom[0x14E]) << 8)
				+ JavaBoy.unsign(rom[0x14F]);

		int total = 0; // Calculate ROM checksum
		for (int r = 0; r < rom.length; r++) {
			if ((r != 0x14E) && (r != 0x14F)) {
				total = (total + JavaBoy.unsign(rom[r])) & 0x0000FFFF;
			}
		}

		return checkSum == total;
	}
	
	
	public void loadBatteryRam() {
		String saveRamFileName = romFileName;
		int numRamBanks;

		try {
			int dotPosition = romFileName.lastIndexOf('.');

			if (dotPosition != -1) {
				saveRamFileName = romFileName.substring(0, dotPosition)
						+ ".sav";
			} else {
				saveRamFileName = romFileName + ".sav";
			}

			/*
			 * if (rom[0x149] == 0x03) { numRamBanks = 4; } else { numRamBanks =
			 * 1; }
			 */
			numRamBanks = getNumRAMBanks();

			if ((cartType == 3) || (cartType == 9) || (cartType == 0x1B)
					|| (cartType == 0x1E) || (cartType == 0x10)
					|| (cartType == 0x13)) {
				FileInputStream is = new FileInputStream(new File(
						saveRamFileName));
				is.read(ram, 0, numRamBanks * 8192);
				is.close();
				System.out.println("Read SRAM from '" + saveRamFileName + "'");
			}
			if (cartType == 6) {
				FileInputStream is = new FileInputStream(new File(
						saveRamFileName));
				is.read(ram, 0, 512);
				is.close();
				System.out.println("Read SRAM from '" + saveRamFileName + "'");
			}

		} catch (IOException e) {
			System.out.println("Error loading battery RAM from '"
					+ saveRamFileName + "'");
		}
	}
	public final byte addressRead(int addr) {
		// if (disposed) System.out.println("oh.  dodgy cartridge");

		// if (cartType == 0) {
		// return (byte) (rom[addr] & 0x00FF);
		// } else {
		if ((addr >= 0xA000) && (addr <= 0xBFFF)) {
			switch (cartType) {
			case 0x0F:
			case 0x10:
			case 0x11:
			case 0x12:
			case 0x13: { /* MBC3 */
				if (ramBank >= 0x04) {
					// System.out.println("Reading RTC reg " + ramBank + " is "
					// + RTCReg[ramBank - 0x08]);
					return (byte) RTCReg[ramBank - 0x08];
				} else {
					return ram[addr - 0xA000 + ramPageStart];
				}
			}

			default: {
				return ram[addr - 0xA000 + ramPageStart];
			}
			}
		}
		if (addr < 0x4000) {
			return (byte) (rom[addr]);
		} else {
			return (byte) (rom[pageStart + addr - 0x4000]);
		}
		// }
	}



}
