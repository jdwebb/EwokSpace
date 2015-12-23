//Testing of the Appointment.java and the AppointmentCollection.java
//Jim Webb
//January 28, 2015


import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class AppointmentTest {
	public static void main (String args []) {

		Calendar appt1 = Calendar.getInstance();
		appt1.set(2015, 8, 17);
		Calendar appt2 = Calendar.getInstance();
		appt2.set(2025, 1, 21);

		Appointment math = new Appointment(appt1, 2, "Go to Math", true);
		Appointment spanish = new Appointment(appt2, 3, "Go to Spanish", false);
		Appointment english = new Appointment(appt1, 4, "Go to English", false);
		Appointment latin = new Appointment(appt1, 2, "Go to Math", true);
		Appointment french = new Appointment(appt1, 2, "Go to France", false);

		AppointmentCollection collection = new AppointmentCollection();


/***************************************************************

*	Testing section

*

*
		System.out.println(math.getDescription());
		System.out.println(spanish.getTime());
		System.out.println(english.getDuration());
		System.out.println(math.isCompleted());
		math.setCompleted(true);
		System.out.println(math.isCompleted());

		System.out.println(math.compareTo(spanish));  	// -1 math is earlier
		System.out.println(spanish.compareTo(math));    // 1 math is earlier		
		System.out.println(math.compareTo(latin));		// 0 everything is the same
		System.out.println(math.compareTo(french));		// 7 the descriptions are different
		System.out.println(math.compareTo(english));    // 1 english duration is longer
		System.out.println(english.compareTo(math));    // -1 math duration is shorter

		System.out.println(french.toString());

		//Begin AppointmentCollection testing
		collection.addAppt(math);
		collection.addAppt(spanish);
		collection.addAppt(english);
		collection.addAppt(latin);
		collection.addAppt(french);

		System.out.println(collection.getPendingAppts());
		System.out.println(collection.getCompletedAppts());
		System.out.println(collection.getPastDueAppts());

******************************************************************/


	}  //end of main
}//end of program






