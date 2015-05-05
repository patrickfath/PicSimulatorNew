package picSimuNew;

import java.util.ArrayList;

public class Worker {


	static ArrayList<String> hexCodes = new ArrayList<>();
	static ArrayList<String> adressesToJumpTo = new ArrayList<>();
	static int startIndexInArray = 0;

	public static void subSTheArrayList(ArrayList<String> arrayLinesReadIn) {
		for(int i = 0; i < arrayLinesReadIn.size(); i++) {
			adressesToJumpTo.add(arrayLinesReadIn.get(i).substring(0, 4));
			if(adressesToJumpTo.get(i).equals("0000")) {
				startIndexInArray = i;
			}
			hexCodes.add(arrayLinesReadIn.get(i).substring(5, 9));
			System.err.println(adressesToJumpTo.get(i) + "     "+ hexCodes.get(i));
		}
	}


	public static void stepByStepClick(ArrayList<String> arrayLinesReadIn) {
		int instructions = 0;
		boolean pclCheck = false;
		int literals = 0;
		int indexPlus = 1;

		int test = CreateCodeTable.testTable.getSelectionIndex();
		if(hexCodes.get(test).equals("    ")) {
			System.err.println("empty");
			System.err.println(arrayLinesReadIn.get(test));
			pclCheck = true;
			if(hexCodes.get(test+1).equals("    ")) {
				System.err.println("teste1");
				pclCheck = true;
				CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck, 2);
			} 
		} else {
			instructions = Integer.parseInt(hexCodes.get(test),16);
			System.err.println(instructions);
		}


		int opcode;

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
			pclCheck = true;
			CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck, indexPlus);
		}

		//COMF
		if(opcode == 9) {

		}

		//DECF
		if(opcode == 3) {
			pclCheck = true;
		}

		//DECFSZ
		if(opcode == 11) {
			pclCheck = true;
		}

		//INCF
		if(opcode == 10) {
			pclCheck = true;
		}

		//INCFSZ
		if(opcode == 15) {

		}

		//IORWF
		if(opcode == 4) {

		}

		//MOVF
		if(opcode == 8) {
			pclCheck = true;
		}

		//MOVWF
		if(opcode == 0 && destination == 1) {
			pclCheck = true;
			CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck, indexPlus);
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
			pclCheck = true;
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
			pclCheck = true;
			CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck, indexPlus);
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
			CreateCodeTable.runStep(arrayLinesReadIn, literals,pclCheck, indexPlus);
		}

		//Goto
		if(opcode == 5) {
			System.err.println("++++++gotU");
			CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck, indexPlus);
		}
		System.out.println(literals);

	}

}

//TODO
//TODO
//TODO
//TODO
//TODO
//TODO
//TODO
//TODO
//TODO


//		public static void runStepThrough(ArrayList<String> arrayLinesReadIn) {
//			int instructions = 0;
//			for(int i = 0; i < arrayLinesReadIn.size(); i++) {
//				if(hexCodes.get(i).equals("    ")) {
//					System.err.println("empty");
//				} else {
//					instructions = Integer.parseInt(hexCodes.get(i),16);
//					System.err.println(instructions);
//				}
//
//
//				//		if(instructions == 0) {
//				//			System.err.println("null");
//				//		} else {
//				//			System.err.println(instructions);
//				//		}
//
//				int opcode;
//				int literals;
//				//TODO
//				//Byte-Oriented File Register Operations
//				opcode = instructions >> 8;
//			int destination = (instructions & 0x0080) >> 7;
//			int address = (instructions & 0x007F);
//
//			//ADDWF
//			if(opcode == 7) {
//
//			}
//
//			//ANDWF
//			if(opcode == 5) {
//
//			}
//
//			//CLRF
//			if(opcode == 1 && destination == 1) {
//
//			}
//
//			//CLRW
//			if(opcode == 1 && destination == 0) {
//				//			pclCheck = true;
//			}
//
//			//COMF
//			if(opcode == 9) {
//
//			}
//
//			//DECF
//			if(opcode == 3) {
//
//			}
//
//			//DECFSZ
//			if(opcode == 11) {
//
//			}
//
//			//INCF
//			if(opcode == 10) {
//				//			pclCheck = true;
//			}
//
//			//INCFSZ
//			if(opcode == 15) {
//
//			}
//
//			//IORWF
//			if(opcode == 4) {
//
//			}
//
//			//MOVF
//			if(opcode == 8) {
//
//			}
//
//			//MOVWF
//			if(opcode == 0 && destination == 1) {
//
//			}
//
//			//NOP
//			if(opcode == 0 && destination == 0) {
//
//			}
//
//			//RLF
//			if(opcode == 13) {
//
//			}
//
//			//RRF
//			if(opcode == 12) {
//
//			}
//
//			//SUBWF
//			if(opcode == 2) {
//
//			}
//
//			//SWAPF
//			if(opcode == 14) {
//
//			}
//
//			//XORWF
//			if(opcode == 6) {
//
//			}
//
//
//			//TODO
//			//Bit-oriented File Register Operations
//			opcode = instructions >> 10;
//			int bit = (instructions & 0x0380) >> 7;
//
//			//BCF
//			if(opcode == 4) {
//
//			}
//
//			//BSF
//			if(opcode == 5) {
//
//			}
//
//			//BTFSC
//			if(opcode == 6) {
//
//			}
//
//			//BTFSS
//			if(opcode == 7) {
//
//			}
//
//			//TODO
//			//Literal and Control Operations
//			opcode = instructions >> 8;
//			literals = (instructions & 0x00FF);
//
//			// ADDLW
//			if((opcode & 0xFE) == 62) {
//
//			}
//
//			//ANDLW
//			if(opcode == 57) {
//
//			}
//
//			//CLRWDT
//			if(opcode == 100) {
//
//			}
//
//			//RETFIE
//			if(opcode == 9) {
//
//			}
//
//			//RETURN
//			if(opcode == 8) {
//
//			}
//
//			//SLEEP
//			if(opcode == 99) {
//
//			}
//
//			//IORLW
//			if(opcode == 56) {
//
//			}
//
//			//MOVLW
//			if((opcode & 0xFE) == 48) {
//
//			}
//
//			//RETLW
//			if((opcode & 0xFE) == 52) {
//
//			}
//
//			//SUBLW
//			if((opcode & 0xFE) == 60) {
//
//			}
//
//			//XORLW
//			if(opcode == 58) {
//
//			}
//
//
//			//TODO
//			//Call and Goto
//			opcode = instructions >> 11;
//			literals = (instructions & 0x07FF);
//
//			//Call
//			if(opcode == 4) {
//				//			CreateCodeTable.runStep(arrayLinesReadIn, literals);
//			}
//
//			boolean pclCheck= false;
//			//Goto
//			if(opcode == 5) {
//				System.err.println("++++++gotU");
//				//			CreateCodeTable.runStep(arrayLinesReadIn, literals, pclCheck);
//			}
//			}
//		}






