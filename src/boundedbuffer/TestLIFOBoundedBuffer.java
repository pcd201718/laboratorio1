package boundedbuffer;

import java.util.Random;

public class TestLIFOBoundedBuffer {
	
	public static enum Metodo {GET, PUT};
	
	public static void main(String args[]) {

		//testBufferFull
		//testBufferEmpty
		//testAppropriateValue
		randomTest();
		
	}
	
	private static void randomTest() {
		
		LIFOBoundedBuffer buffer = new LIFOBoundedBuffer();
		Random rand_method = new Random(System.currentTimeMillis());
		Random rand_value = new Random(System.currentTimeMillis());
		int value = 0, pos = -1;
		final int runs = 100; 
		int curr_runs = 0;
		while(curr_runs++ < runs) {
			value = rand_value.nextInt(10);
			switch(Metodo.values()[rand_method.nextInt(2)]) {
				case GET: {
					buffer.get();
					break;
				}
				case PUT: {
					pos = buffer.put(value);
					if(pos != -1)
						assert(buffer.isPresent(value));					
					break;
				}
				default: {
					assert(false);
				}					
			}
			System.out.println("Buffer remaining size is: " + buffer.getRemainingSize());
		}
	}
}
