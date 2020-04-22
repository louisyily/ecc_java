package ecc.elliptic;

import ecc.*;

public class TestECCrypto {
    public static void no_main(String[] args) {
	try {
	    EllipticCurve ec = new EllipticCurve(new secp256r1());
	    CryptoSystem cs = new ECCryptoSystem(ec);

	    Key sk = (ECKey)cs.generateKey();
	    Key pk = sk.getPublic();
	    System.out.println(sk+"\n"+pk);

	    String plain=new String("plain");
	    byte[] test1=plain.getBytes();
	    byte[] test2 = cs.encrypt(test1, plain.length(), pk);
	    String enc=new String(" ");
	    try {
	    	enc=new String((cs.encrypt(test1,plain.length(),pk)));
	    } catch(Exception e) {
		    System.out.println("Exception!");
	    }
	    System.out.println("Plain Text is : "+plain);
	    System.out.println("Encrypted text is: "+enc);
	    byte[] dec=cs.decrypt(test2,sk);
	    String decrypt=new String(dec);
	    System.out.println("Decrypted text is: "+decrypt);
	} catch (InsecureCurveException e) {
	    System.out.println("TestCryptoStreams: "+e);
	}
    }
}
