import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Calendar;

/**
 * This class represents an appointment scheduler
 * @author Jim Webb
 * @date 1-28-2015
 */
public class AppointmentCollection {

	private ArrayList<Appointment> schedule = new ArrayList<Appointment>();  //Creates an array of appointments

	/**
	 * This method adds an Appointment instance to this collection. It will not
	 * allow a duplicate of another Appointment to be added, as determined by
	 * compareTo. Furthermore, no two Appointments can be added with the same
	 * time, or can there be any overlap between Appointments. (e.g. No
	 * Appointment may be added between the start time and end time of another
	 * Appointment)
	 * 
	 * @param appt
	 *            The appointment to add to this collection.
	 * 
	 * @return true of the Appointment was successfully added, or false if not
	 *         (e.g. there was a duplicate).
	 */
	public boolean addAppt(Appointment appt){
		for(Appointment i: schedule){
			if (appt.compareTo(i) == 0){ 	//if two events are the same, do not add to arraylist
				return false;
			}
		}//end for loop
		schedule.add(appt);
		return true;
	}

	/**
	 * This method removes a Appointment instance from this collection. The
	 * given Appointment instance must be identical to another Appointment
	 * instance in this collection, as determined by compareTo. If the method
	 * determines that there is a Appointment in the collection that matches the
	 * given Appointment, it will be removed and the method will return true.
	 * Otherwise, it will do nothing to the collection and return false.
	 * 
	 * @param toRemove
	 *            An instance identical to an Appointment to remove from this
	 *            collection.
	 * 
	 * @return true if the Appointment was removed, false if not.
	 */
	public boolean removeAppt(Appointment toRemove){
		for(int i = 0; i < schedule.size(); i++){  				//searches through the array
			if (toRemove.compareTo(schedule.get(i)) == 0){   	//basically if any appointments are the same
				schedule.remove(i);  							//removes the repeated one and returns true
				return true;
			}
		} //end of for loop
		return false;
	}

	/**
	 * This method gets a List of uncompleted Appointments with approaching
	 * times and puts them in chronological order. It should ignore Appointments
	 * that have been completed and Appointments with deadlines that have
	 * passed. (An Appointment whose time plus duration has passed)
	 * 
	 * @return A sorted List of pending Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getPendingAppts(){
		Collections.sort(schedule);
		List<Appointment> pendingSchedule = new ArrayList<Appointment>();
		for(Appointment appt: schedule){
			if (appt.isCompleted() == false){ 
				if ((appt.getTime().getTimeInMillis() + appt.getDuration()) > System.currentTimeMillis()){
					pendingSchedule.add(appt);
				}
			}
		}
		Collections.sort(pendingSchedule);
		return pendingSchedule;
	}

	/**
	 * This method gets a List of completed Appointments and puts them in
	 * chronological order.
	 * 
	 * @return A sorted List of completed Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getCompletedAppts(){
		Collections.sort(schedule);
		List<Appointment> completedSchedule = new ArrayList<Appointment>();
		for(Appointment appt: schedule){
			if (appt.isCompleted() == false){
				completedSchedule.add(appt);
			}
		}
		Collections.sort(completedSchedule);
		return completedSchedule;
	}

	/**
	 * This method returns a sorted list of Appointments that have not been
	 * completed and whose deadlines have passed.
	 * 
	 * 
	 * @return A sorted List of past-due Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getPastDueAppts(){
		Collections.sort(schedule);
		List<Appointment> pastSchedule = new ArrayList<Appointment>();
		for(Appointment appt: schedule){
			if (appt.isCompleted() == false){
				if ((appt.getTime().getTimeInMillis() + appt.getDuration()) > System.currentTimeMillis()) {
				pastSchedule.add(appt);
				}
			}
		}
		Collections.sort(pastSchedule);
		return pastSchedule;
	}




} //end AppointmentCollection.java










