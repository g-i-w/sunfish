package sunfish.bluegill;

import java.util.*;

public class ShiftRegister<T> extends LinkedList<T> {

	private String delim = ",";
	
	public ShiftRegister ( int length, T initValue ) {
		for (int i=0; i<length; i++) {
			addLast(initValue);
		}
	}

	public ShiftRegister ( List<T> initValues ) {
		for (T value : initValues) {
			addLast(value);
		}
	}
	
	public T shift ( T newPoint ) {
		addLast( newPoint );
		return removeFirst();
	}
	
	public void setDelim ( String delim ) {
		this.delim = delim;
	}
	
	public String toString () {
		int stringLength = this.get(0).toString().length();
		StringBuilder str = new StringBuilder( this.size()*stringLength + (this.size()-1)*delim.length() );
		for (T item : this) {
			str
				.append(delim)
				.append(item);
		}
		return str.toString().substring(delim.length()); // delete leading delim
	}
		
	public static void main (String[] args) throws Exception {
		ShiftRegister<Byte> sr = new ShiftRegister<>( 3, (byte)0x01 );
		for (int i=0;i<10;i++) System.out.println( sr.shift( (byte)i ) );
		System.out.println( sr );
		
		System.out.println();
		
		List<Double> l = new ArrayList<Double>( Arrays.asList(0.0,1.0,3.0,7.0,3.0,1.0,0.0) );
		ShiftRegister<Double> sr_d = new ShiftRegister<>( l );
		for (int i=0;i<10;i++) System.out.println( sr_d.shift( (double)i ) );
		System.out.println( sr_d );
	}
	
}
