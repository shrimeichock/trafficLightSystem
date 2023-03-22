ASSIGNMENT 4 SYSC3303
---------------------
Author: Shrimei Chock 101146327

FILE NAMES
-----------
tests Package

- stateMachineTest.java: sample test file, the test() method contains a typical test scenario. The remaining tests use assertions to check specfic scenarios

stateMachine Package

- Context.java: the main interface for the state machine
- Operational.java: initial state, shows that traffic light is working
- PedestriansEnabled.java: initial state for pedestrian logic
- PedestrianFlash.java: state where pedestrian walk light is flashng
- PedestrianWalk.java: state where pedestrian walk light is enabled
- State.java: basic state interface, holds common methods for all states
- VehicleLight.java: an enum for possible vehicle light colours 
- VehiclesEnabled.java: initial state for vehicle logic
- VehiclesGreen.java: state for when vehicle light is green for 10 seconds
- VehiclesGreenInt.java: state where vehicle light continues to be green until pedestrian arrives
- VehiclesYellow.java: state where vehicle light is yellow
- WalkLight.java: enum for possible walk light symbols

SETUP INSTRUCTIONS
------------------
To run the project in Eclipse, complete the following steps:
 
1. Select File -> Import -> General -> Existing Projects Into Workspace. Select the "Select archive file" option and browse to the downloaded zip file called "101146327_Assignment4".
2. Project named "101146327_Assignment4" will be created in your workspace.
3. To run the program, right-click the test case you would like to run. Select "Run as" -> "JUnit Test". 

DEFECTS
--------
- If pedestrian clicks button during FLASHING state and doesn't walk across (since it is technically against the law), the button click will not be held for the next GREEN state. This can be tested by running the 'testWaitingInFlash()' test case. 
- Should ideally count down numbers for pedestrians, so they know how long they have to cross. This was not implemented in the code.
- Should ideally leave some overlap where both the vehicle lights are red and pedestrians can't walk to allow those crossing to finish safely. This is essentially what the vehicle enabled and pedestrian enabled states are for but they should last longer. This fix was not implemented in the code.

ERRORS
-------
- The set/kill timer methods are unnecessary. A timer by definition counts down on its own. The 'start' and 'stop' is only required for stopwatches
- The given state machine does not show how Pedestrian_waiting events during yellow or pedestrian_enabled states should be handled (i.e. should we add to the counter if someone clicks the button during the flashing state so they have more time to cross?). It was assumed that nothing happens and the light just moves to the next state as if no button was clicked.
