package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobThree instanceof Job);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobThree.getName(), "Product tester");
        assertEquals(jobThree.getEmployer().getValue(), "ACME");
        assertEquals(jobThree.getLocation().getValue(), "Desert");
        assertEquals(jobThree.getPositionType().getValue(), "Quality control");
        assertEquals(jobThree.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Coder", new Employer("Apple"), new Location("KC"), new PositionType("Developer"), new CoreCompetency("Drive"));
        Job jobTwo = new Job("Coder", new Employer("Apple"), new Location("KC"), new PositionType("Developer"), new CoreCompetency("Drive"));
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobOne = new Job("Coder", new Employer("Apple"), new Location("KC"), new PositionType("Developer"), new CoreCompetency("Drive"));

        String str = jobOne.toString();
        String n = "\n";

        assertEquals(str.charAt(0), n.charAt(0));
        assertEquals(str.charAt(str.length() - 1),n.charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobOne = new Job("Coder", new Employer("Apple"), new Location("KC"), new PositionType("Developer"), new CoreCompetency("Drive"));

        String str = jobOne.toString();

        assertTrue(str.contains("Name: Coder"));
        assertTrue(str.contains("Employer: Apple"));
        assertTrue(str.contains("Location: KC"));
        assertTrue(str.contains("Position Type: Developer"));
        assertTrue(str.contains("Core Competency: Drive"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Coder", new Employer(""), new Location(null), new PositionType("Developer"), new CoreCompetency("Drive"));

        String str = jobOne.toString();
        assertTrue(str.contains("Employer: Data not available"));
        assertTrue(str.contains("Location: Data not available"));
    }

}
