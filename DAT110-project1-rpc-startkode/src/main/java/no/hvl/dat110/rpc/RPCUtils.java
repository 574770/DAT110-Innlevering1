package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
			
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
		if (payload == null) {
			byte[] rpcmsg = new byte[1];
			rpcmsg[0] = rpcid;
			return rpcmsg;
		}
		byte[] rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		for (int i = 1; i <= payload.length; i++) {
			rpcmsg[i] = payload[i - 1];
		}
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		
		byte[] payload = new byte[rpcmsg.length - 1];

		for (int i = 1; i < rpcmsg.length; i++) {
			payload[i - 1] = rpcmsg[i];
		}
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		// TODO - START 
		
		byte[] encoded = str.getBytes();
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		// TODO - START 
		
		String decoded = new String(data);
		
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		
		
		// TODO - START 
		
		byte[] encoded = new byte[1];
		encoded[0] = 1;
				
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		
		
		// TODO - START 
		
		byte[] encoded = ByteBuffer.allocate(4).putInt(x).array();
			
		
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		// TODO - START 
		
		int decoded = ByteBuffer.wrap(data).getInt();
		
		// TODO - END
		
		return decoded;
		
	}
}
