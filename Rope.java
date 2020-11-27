public interface Rope{

	Rope append(char c);

	Rope append(CharSequence suffix);

	Rope append(CharSequence csq, int start, int end);

    Rope delete(int start, int end);


	int indexOf(char ch);

	int indexOf(char ch, int fromIndex);

	int indexOf(CharSequence sequence);

	int indexOf(CharSequence sequence, int fromIndex);


    Rope insert(int dstOffset, CharSequence s);


    Iterator<Character> iterator(int start);


	Rope trimStart();

    Matcher matcher(Pattern pattern);


    public boolean matches(Pattern regex);

    public boolean matches(String regex);


    public Rope rebalance();

    public Rope reverse();


    Iterator<Character> reverseIterator();

    Iterator<Character> reverseIterator(int start);

	Rope trimEnd();

	Rope subSequence(int start, int end);

	Rope trim();


    public void write(Writer out) throws IOException;

    public void write(Writer out, int offset, int length) throws IOException;

    
    public Rope padStart(int toLength);
    
    public Rope padStart(int toLength, char padChar);

    
    public Rope padEnd(int toLength);
    
    public Rope padEnd(int toLength, char padChar);
    

    public boolean isEmpty();
    

    public boolean startsWith(CharSequence prefix);

    public boolean startsWith(CharSequence prefix, int offset);
    
    public boolean endsWith(CharSequence suffix);

    public boolean endsWith(CharSequence suffix, int offset);
}