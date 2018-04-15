package rsaGui;


import java.math.BigInteger;

import java.util.Random;



public class CryptoClass {

private BigInteger p;

private BigInteger q;

private BigInteger N;

private BigInteger phi;

private BigInteger e;

private BigInteger d;

private int bitlength = 1024;

private Random     r;

public CryptoClass()

{
    r = new Random();

    p = BigInteger.probablePrime(bitlength, r); // p=big prime

    q = BigInteger.probablePrime(bitlength, r); // q=big prime

    N = p.multiply(q); //n = p*q

    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); //phi = (p-1)*(q-1)

    e = BigInteger.probablePrime(bitlength / 2, r); // e = low number

    
    while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) //finding  e

    {

        e.add(BigInteger.ONE); //e++

    }

    d = e.modInverse(phi); //d = e^-1(mod n)
}

public CryptoClass(BigInteger e, BigInteger d, BigInteger N)
{
    this.e = e;

    this.d = d;

    this.N = N;
}


public BigInteger encrypt(String message)
{
	byte [] messageByte = message.getBytes();
	
	BigInteger messageInt = new BigInteger(messageByte);
	
	System.out.println("plainText:: " + messageInt + "e: "+e+" n: "+N+"\n\n");
	
	BigInteger cipherText = messageInt.modPow(e ,  N);
	
	return cipherText;
}



// Decrypt message

public BigInteger decrypt(String message)
{
	BigInteger messageInt = new BigInteger(message);
	
	BigInteger cipherText = messageInt.modPow(d ,  N);
	
	
	//System.out.println("plainText:: " + cipherText + "d: "+d+" n: "+N);
	return cipherText;
}

	
}
