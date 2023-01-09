package sunfish.smallmouth;

import java.util.*;
import sunfish.bluegill.*;

public class Integral extends ShiftRegister<Double> implements SignalPath {

	private double sum;
	
	public Integral ( int length ) {
		super( length, 0.0 );
	}
	
	public Integral ( int length, Double steadyState ) {
		super( length, steadyState );
		sum = steadyState.doubleValue() * length;
	}
	
	public Integral ( List<Double> list ) {
		this( list.size() ); // initialize to zeros
		for ( Double d : list ) output( d ); // shift in this list
	}
	
	public double output ( Double last ) {
		Double first = shift( last );
		sum += (last.doubleValue() - first.doubleValue());
		return sum;
	}
	
	public static void main (String[] args) {
		SignalPath integral0 = new Integral( 5 );
		for (int i=0;i<10;i++) System.out.println( integral0.output( (double)i ) );
		
		System.out.println();
		
		SignalPath integral1 = new Integral( 5, 10.0 );
		for (int i=0;i<10;i++) System.out.println( integral1.output( (double)i ) );
		
		System.out.println();
		
		List<Double> l = new ArrayList<Double>( Arrays.asList(0.0,1.0,3.0,7.0,3.0,1.0,0.0) );
		SignalPath integral2 = new Integral( l );
		for (int i=0;i<10;i++) System.out.println( integral2.output( (double)i ) );
	}
	
}
