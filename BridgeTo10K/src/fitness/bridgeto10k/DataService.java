package fitness.bridgeto10k;

import java.util.ArrayList;

public class DataService {

	public static int getNumberofworkouts() {
		return numberOfWorkouts;
	}

	static final String[] descriptions = {
			"Run 10 min/walk 1 min Repeat x 4.",
			"Run 10 min/walk 1 min Repeat x 4.",
			"Run 10 min/walk 1 min Repeat x 4.",
			"Run 15 min/walk 1 min Repeat x 3.",
			"Run 15 min/walk 1 min Repeat x 3.",
			"Run 15 min/walk 1 min Repeat x 3.",
			"Run 17 min/walk 1 min Repeat x 3.",
			"Run 17 min/walk 1 min Repeat x 3.",
			"Run 17 min/walk 1 min Repeat x 3.",
			"Run 18 min/walk 1 min Repeat x 3.",
			"Run 18 min/walk 1 min Repeat x 3.",
			"Run 18 min/walk 1 min Repeat x 3.",
			"Run 22 min/walk 1 min Repeat x 2.",
			"Run 25 min/walk 1 min Repeat x 2.",
			"Run 30 min/walk 1 min Repeat x 2.",
			"Run 60 min.",
			"Run 60 min.",
			"Run 60 min.",
		};
	
	static final int numberOfWorkouts = descriptions.length;
	
	public DataService()
	{
		
	}
	
	public static Workout getNthWorkout(long N)
	{
		Workout w = new Workout();
		w.setM_title("Week " + (N/3 + 1) + " Day " + (N%3 + 1));
		w.setM_description(descriptions[(int)N]);
		return w;
	}
	
	// Temporary. Until WorkoutArrayAdapter is changed
	// to inherit from BaseAdapter instead
	
	public static ArrayList<Workout> getAllWorkouts()
	{
		ArrayList<Workout> workouts = new ArrayList<Workout>();
		
		for(int i = 0; i < numberOfWorkouts; i++)
		{
			workouts.add(getNthWorkout(i));
		}
		return workouts;
	}
}
