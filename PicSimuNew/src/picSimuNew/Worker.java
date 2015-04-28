package picSimuNew;

import java.util.ArrayList;

public class Worker {

	static ArrayList<String> hexCodes = new ArrayList<>();
	public static void workWithArrayList(ArrayList<String> listWithLinesOfCodeReadIn) {
		for(int i = 0; i < listWithLinesOfCodeReadIn.size(); i++) {
			if(listWithLinesOfCodeReadIn.get(i).substring(5, 9).equals("    ")) {				
			} else {
				hexCodes.add(listWithLinesOfCodeReadIn.get(i).substring(5, 9));
			}
		}
	}

	public static void stepThrough() {
		int instructions = Integer.parseInt(hexCodes.get(0),16);

		int opcode;
		int literals;
		//TODO
		//Byte-Oriented File Register Operations
		opcode = instructions >> 8;
		int destination = (instructions & 0x0080) >> 7;
		int address = (instructions & 0x007F);

		//ADDWF
		if(opcode == 7) {

		}

		//ANDWF
		if(opcode == 5) {

		}

		//CLRF
		if(opcode == 1 && destination == 1) {

		}

		//CLRW
		if(opcode == 1 && destination == 0) {

		}

		//COMF
		if(opcode == 9) {

		}

		//DECF
		if(opcode == 3) {

		}

		//DECFSZ
		if(opcode == 11) {

		}

		//INCF
		if(opcode == 10) {

		}

		//INCFSZ
		if(opcode == 15) {

		}

		//IORWF
		if(opcode == 4) {

		}

		//MOVF
		if(opcode == 8) {

		}

		//MOVWF
		if(opcode == 0 && destination == 1) {

		}

		//NOP
		if(opcode == 0 && destination == 0) {

		}

		//RLF
		if(opcode == 13) {

		}

		//RRF
		if(opcode == 12) {

		}

		//SUBWF
		if(opcode == 2) {

		}

		//SWAPF
		if(opcode == 14) {

		}

		//XORWF
		if(opcode == 6) {

		}


		//TODO
		//Bit-oriented File Register Operations
		opcode = instructions >> 10;
		int bit = (instructions & 0x0380) >> 7;

		//BCF
		if(opcode == 4) {

		}

		//BSF
		if(opcode == 5) {

		}

		//BTFSC
		if(opcode == 6) {

		}

		//BTFSS
		if(opcode == 7) {

		}

		//TODO
		//Literal and Control Operations
		opcode = instructions >> 8;
		literals = (instructions & 0x00FF);

		// ADDLW
		if((opcode & 0xFE) == 62) {

		}

		//ANDLW
		if(opcode == 57) {

		}

		//CLRWDT
		if(opcode == 100) {

		}

		//RETFIE
		if(opcode == 9) {

		}

		//RETURN
		if(opcode == 8) {

		}

		//SLEEP
		if(opcode == 99) {

		}

		//IORLW
		if(opcode == 56) {

		}

		//MOVLW
		if((opcode & 0xFE) == 48) {

		}

		//RETLW
		if((opcode & 0xFE) == 52) {

		}

		//SUBLW
		if((opcode & 0xFE) == 60) {

		}

		//XORLW
		if(opcode == 58) {

		}


		//TODO
		//Call and Goto
		opcode = instructions >> 11;
		literals = (instructions & 0x07FF);

		//Call
		if(opcode == 4) {

		}

		//Goto
		if(opcode == 5) {
			System.err.println("gotU");
		}



	}


}


