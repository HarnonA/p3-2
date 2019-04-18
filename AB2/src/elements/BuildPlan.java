package elements;

public class BuildPlan {

	private Item[] elements;
	private String s1 = "String1";
	private String s2 = "String2";
	private String s3 = "String3";
	private String s4 = "String4";

	public BuildPlan() {
		// create new Array of elements
		this.elements = new Item[] { new Invocation(s1), new Invocation(s2),
				new Invocation(s3), new Invocation(s4), new Body(), new Engine() };
	}

	public void accept(I_BuildPlan visitor) {
		// TODO Auto-generated method stub
		for (Item item : elements) {
			item.accept(visitor);
		}
		visitor.visit(this);
	}
}
