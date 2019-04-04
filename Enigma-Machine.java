import hsa.*;
public class JackieMaxCustomEnigma {
    public static void main (String [] args) {
	// This is a custom Enigma
	String keyboard       = "ABCDEF";
	String label3         = "ABCDEF";
	String rotor3         = "FAEBCD";
	String label2         = "ABCDEF";
	String rotor2         = "EAFBDC";
	String label1         = "ABCDEF";
	String rotor1         = "DFEABC";
	String labelReflector = "ABCDEF";
	String rotorReflector = "CFAEDB";
	
	Stdout.print ("Enter setting for rotor 1: ");
	char setting1 = Stdin.readChar();
	Stdout.print ("Enter setting for rotor 2: ");
	char setting2 = Stdin.readChar();
	Stdout.print ("Enter setting for rotor 3: ");
	char setting3 = Stdin.readChar();
	char letter = '\0';
	for (;label1.charAt(0) != setting1;){
	    label1 = label1.substring (1) + label1.charAt (0);
	    rotor1 = rotor1.substring (1) + rotor1.charAt (0);
	}
	for (;label2.charAt(0) != setting2;){
	    label2 = label2.substring (1) + label2.charAt (0);
	    rotor2 = rotor2.substring (1) + rotor2.charAt (0);
	}
	for (;label3.charAt(0) != setting3;){
	    label3 = label3.substring (1) + label3.charAt (0);
	    rotor3 = rotor3.substring (1) + rotor3.charAt (0);
	}
	do {
	    do {
		do {
		    letter = Stdin.readChar();
		    int position = -1;
		    position = keyboard.indexOf (letter);
		    letter = rotor3.charAt (position);
		    position = label3.indexOf(letter);
		    letter = rotor2.charAt(position);
		    position = label2.indexOf(letter);
		    letter = rotor1.charAt(position);
		    position = label1.indexOf(letter);
		    letter = rotorReflector.charAt(position);
		    position = labelReflector.indexOf(letter);
		    letter = label1.charAt(position);
		    position = rotor1.indexOf(letter);
		    letter = label2.charAt(position);
		    position = rotor2.indexOf(letter);
		    letter = label3.charAt(position);
		    position = rotor3.indexOf(letter);
		    letter = keyboard.charAt(position);
		    label3 = label3.substring (1) + label3.charAt (0);
		    rotor3 = rotor3.substring (1) + rotor3.charAt (0);
		    System.out.println (letter);
		} while (label3.charAt(0) != setting3);
		label2 = label2.substring (1) + label2.charAt (0);
		rotor2 = rotor2.substring (1) + rotor2.charAt (0);
	    } while (label2.charAt(0) != setting2);
	} while (true);
    }   
}
