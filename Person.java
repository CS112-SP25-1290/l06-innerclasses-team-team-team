public class Person implements Comparable
{
	//Todo: (Part 2) create helper inner class for Identity
	protected class Identity {
		private String pronouns;
		private String background;

		public Identity() {
			pronouns = "";
			background = "";
		}

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		@Override
		public String toString() {
			return "My pronouns are " + pronouns + ", and my background is: " + background;
		}

		@Override
		public boolean equals(Object other) {
			if (other == null || !(other instanceof Identity))
			{
				return false;
			}

			Identity id = (Identity) other;
			return this.pronouns.equals(id.pronouns) && this.background.equals(id.background);
		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "";
	public static final String DEFAULT_BACKGROUND = "";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.story = new Identity();
		this.setAll(name, pronouns, background, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.getPronouns(), original.getBackground(), original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPronouns(String pronouns) {
		this.story.pronouns = pronouns;
	}

	public void setBackground(String background) {
		this.story.background = background;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String pronouns, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronouns);
		this.setBackground(background);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public String getPronouns() {
		if (story == null)
		{
			throw new NullPointerException("This Person's Identity has not been initialised!");
		}
		return this.story.pronouns;
	}

	public String getBackground() {
		if (story == null)
		{
			throw new NullPointerException("This Person's Identity has not been initialised!");
		}
		return this.story.background;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other == null || (!(other instanceof Person))) {
			return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	// Todo: (Part 1) override compareTo method to implement Comparable interface
	@Override
	public int compareTo(Object o)
	{
		if (o == null || (!(o instanceof Person))) {
			return 0;
		}
		
		Person otherPerson = (Person) o;
		return this.getPrivilege() - otherPerson.getPrivilege();
	}
}