import java.util.Calendar;

public class Appointment implements Comparable<Appointment> {

	private Calendar time;
	private int duration;
	private String description;
	private boolean isCompleted;

	/**
	 * This is the Appointment constructor.
	 * 
	 * @param time
	 *            When this appointment will take place
	 * 
	 * @param duration
	 *            The length of the given task, in minutes.
	 * 
	 * @param description
	 *            A long description of the scheduled appointment.
	 * 
	 * @param isCompleted
	 *            True if this task is completed, otherwise false.
	 */
	public Appointment(Calendar time, int duration, String description,
			boolean isCompleted) {  	//Class constructor
		this.time = time;				//differentiates with parameter and instance variable
		this.duration = duration;		//assignment operation
		this.description = description;
		this.isCompleted = isCompleted;
	}

	/**
	 * Get this Appointment's description.
	 * 
	 * @return The description of this class
	 */
	public String getDescription() {  //getter or accessor
		return description;
	}

	/**
	 * Get the time of this Appointment
	 * 
	 * @return The time this task is scheduled for.
	 */
	public Calendar getTime() {
		return time;
	}

	/**
	 * Get the duration of this Appointment
	 * 
	 * @return The length of time this task is scheduled for.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Has this appointment been completed?
	 * 
	 * @return true if the Appointment is completed, false otherwise.
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * This method sets the completion status of an Appointment
	 * 
	 * @param toSet
	 *            The completion status to assign to this Appointment
	 */
	public void setCompleted(boolean toSet) {
		isCompleted = toSet;
	}

	/**
	 * Compare one Appointment to another. Appointment t1 is "greater than"
	 * Appointment t2 if t1's scheduled time is sooner. If they are at the same
	 * time, t1 is > t2 if t1's duration is longer. If the duration is the same,
	 * return the compareTo value for their respective descriptions. Also, t1
	 * "equals" t2 if they have the same time, duration and description.
	 * 
	 * @param apptToCompare
	 *            The instance to compare this Appointment to.
	 * @return A positive integer if this appointment is "greater than"
	 *         apptToCompare; zero if this is "equal to" apptToCompare; a
	 *         negative integer if this is "less than" apptToCompare.
	 */
	public int compareTo(Appointment apptToCompare) {
		if (this.time.compareTo(apptToCompare.getTime()) == 0) {	  // == equality statement
			if (this.duration == apptToCompare.getDuration()) {   //if durations are the same
				if (this.description == apptToCompare.getDescription())
					return 0;   //if the descriptions of the events are the same
				else
					return this.description.compareTo(apptToCompare.getDescription());  //the descriptions are different
				}
			else if (this.duration < apptToCompare.getDuration())
				return 1;
			else
				return -1;
			}
		else if (time.compareTo(apptToCompare.getTime()) < 0)
			return -1; //T2 is sooner
		else 
			return 1;
	}

	/**
	 * The toString method should return a representation of an Appointment as a
	 * String in the following format: Time of Appointment: <time> Duration:
	 * <duration> Completed? <isCompleted> Description: <description>
	 * 
	 * 
	 * @return A string representation of an Appointment
	 */
	public String toString() {
         return "Appointment time: " + this.time + "\n" + "Duration: " + duration + "\n" + "Is completed: " + isCompleted + "\n" + "Description: " + description;
	}
}
