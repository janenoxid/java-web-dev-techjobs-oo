package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2; // two empty constructors
    Job test_job3;
    Job test_job4; // two equal objects (except for ID)

    Employer employer;
    Location location;
    PositionType positionType;
    CoreCompetency coreCompetency;

    @Before
    public void createJobObject(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId(){
        assertTrue((test_job1.getId() == 1) && (test_job2.getId() == 2));
        // didn't work to do assertTrue (test_job.getId() == (test_job.getId()+1))... why??
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(test_job3.getId() == 3);
        assertTrue(test_job3.getName() == "Product tester");
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);

        assertTrue(test_job3.getEmployer().getValue() == "ACME");
        assertTrue(test_job3.getLocation().getValue() == "Desert");
        assertTrue(test_job3.getPositionType().getValue() == "Quality control");
        assertTrue(test_job3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(test_job3.equals(test_job4));
    }

}
