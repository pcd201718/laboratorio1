package boundedbuffer;


/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     x.y          (current version number of program)
 * @since       m.n          (the version of the package this class was first added to)
 * 
 * What this class does: Implements a LIFO BoundedBuffer. The current implementation handles the special cases (see below) as follows:
 * -- issuing a get when the buffer is empty: return null a special value used to differentiate this case (avoid using an integral value 
 * as this way we exclude it from the set of potential buffered values)
 * -- issuing a put when the buffer is full: return -1, denoting that the value was not queued.
 */


public class LIFOBoundedBuffer {

	/**
	 * Default buffer size for all bounded_buffers in case no size is specified.
	 * */
	public static final int DEFAULT_BUFFER_SIZE = 10;
	/**
	 * Array of int containing buffer entries.
	 * */
	private int[] buffer;
	/**
	 * Maximum number that can be stored inside the buffer
	 * */
	private int bufferSize;
	/**
	 * Next position where to store a value
	 * */
	private int index;
	
	/**
	 * Builds a BoundedBuffer with an internal buffer of default size (@see DEFAULT_BUFFER_SIZE)
	 */
	public LIFOBoundedBuffer() {
		this(DEFAULT_BUFFER_SIZE);
	}
	
	/**
	 * Builds a BoundedBuffer with an internal buffer of bufferSize
	 * @param bufferSize: the size of the internal buffer array.
	 */
	public LIFOBoundedBuffer(int bufferSize) {
		/*
		 * Parameter sanity check. XXX: might even through an exception ...
		 */
		this.bufferSize = (bufferSize == 0)? DEFAULT_BUFFER_SIZE:( (bufferSize<0)? Math.abs(bufferSize):bufferSize);
		buffer = new int[bufferSize];
		index = 0;
	}

	/**
	 * Used to test whether the buffer is empty or not.
	 * @return boolean: true in case buffer contains some elements, false otherwise.
	 * */
	public boolean isEmpty() {
		return index == 0;
	}
	
	/**
	 * Method used to test whether the buffer is full or not
	 * @return boolean: true in case buffer is full of elements, false otherwise.
	 * */
	public boolean isFull() {
		return index == buffer.length;
	}
	
	/**
	 * Method used to test whether a specific element is present in the buffer
	 * @return boolean: true in case the element is present, false otherwise.
	 * */
	public boolean isPresent(int value) {
		for(int i=0; i<index; i++)
			if(value == buffer[i])
				return true;
		return false;
	}
	
	/**
	 * Method used to insert a value into the buffer
	 * @param value: the value to store in the array
	 * @return int: -1 in case the element could not be inserted (i.e., buffer is full), otherwise the position is returned.
	 * */
	public int put(int value) {
		if(isFull()) return -1;
		
		buffer[index++] = value;
		return index-1;
	}
	
	/**
	 * Method used to retrieve a value from the buffer
	 * @return Integer: null in case there is no element inside the buffer, the element otherwise.
	 * */
	public Integer get() {
		if(isEmpty()) return null;
		return buffer[--index];
	}	
	
	/**
	 * Method used to get the maximum buffer size
	 * @return int: maximum buffer size allocated for this BoundedBuffer object
	 * */
	public int getBufferSize() {return bufferSize;}
	
	/**
	 * Method used to get the remaining buffer size used to store elements
	 * @return int: the number of available entries.
	 * */
	public int getRemainingSize() {
		return (isFull())? 0: bufferSize-index;
	}
	
	/**
	 * Returns a snapshot of the buffer
	 * */
	public String toString() {
		StringBuilder builder = new StringBuilder("{ Array[");
		for(int e: buffer) {
			builder.append(e + ", ");
		}
		
		builder.append("] ");
		//amount of available positions
		builder.append(" FreeSlots(" + (bufferSize-index) + ")");
		//first put available position
		builder.append(" NextIndex(" + index + ")");
		builder.append("}");
		return builder.toString();
	}
	
	public static void main(String args[]) {
		LIFOBoundedBuffer buff = new LIFOBoundedBuffer(10);
		buff.put(1);
		buff.put(2);		
		System.out.println(buff);
		
	}
	
}
