package fitness.bridgeto10k;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DoWorkout extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workout);
		Bundle extras = getIntent().getExtras();
		long id = extras.getLong("id");
		
		Workout w = DataService.getNthWorkout(id);
		
		TextView descriptionView = (TextView) this.findViewById(R.id.description);
		
		descriptionView.setText(w.getM_description());
		
		setTitle(w.getM_title());
	}
}
