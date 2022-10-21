
public class Main {

	public static void main(String[] args) {
		
		View v = new ViewImpl();
		Model m = new ModelImpl(v);
		ControllerImpl c = new ControllerImpl(v,m);

	}

}
