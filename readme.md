# Physics Engine

## Introduction
This project is a simple main.physics engine with the goal of maximum accessibility.
This library is largely inspired by Daniel Shiffman's (♥) main.physics engine tutorial
and my frustration with the JavaFx Point2D class.

## Why it was created
The main reason for the creation of this project was my frustration with the Point2D class provided by JavaFx 8
It seems unnecessarily complicated to me, since Vectors aren't changeable once they are created
and many useful operations, like limiting the length of a vector, are missing.

## Goals
This library tries to improve on the problems with the standard JavaFx implementation by providing changeable main.vectors
and a basic main.physics engine to help getting started with the programming of main.physics simulations and animations.
All classes and methods are created with the goal of maximum accessibility and utility.

## How to contribute
If you want to contribute to this library by writing some code you can simply do that an open a pull request.
If you encounter a bug, need help or have a suggestion how to improve the code, you can do so by opening an issue.
If you don't know how to do that https://www.youtube.com/watch?v=WMykv2ZMyEQ is an explanatory video about Github issues
and https://www.youtube.com/watch?v=_NrSWLQsDL4 is one about pull requests.

### Rules to contribute
#### Pull requests
The main goal of this library is ease of use. So if you want to contribute please keep that in mind.
Even if you find the many overloads I did unnecessary, please also include them in your code as they increase
ease of use drastically. It would be great if you also comment your code and write test for it.
If you are having trouble following the rules don't hesitate contacting me via an issue, i'm sure we can find a solution

#### Issues
* If you are opening an issue please make sure that you issue is replicable
* I have a full time job so please be patient if your issue isn't instantly solved
* Stay friendly: just because its the internet, it doesn't mean people don't have feelings anymore
* Don't be afraid to ask questions: it's better for everyone when your question gets resolved quickly

## How to install the Library
If you are interested in the code just clone this repository (here is a link that shows you how to do that).
otherwise you can just use this link in the download section to download the jar. How you can include the libraries into your project
is shown in the following videos
* Eclipse: https://www.youtube.com/watch?v=3aYYrzl3xzk
* IntelliJ: https://www.youtube.com/watch?v=QAJ09o3Xl_0

### Download
With the following link you can download the jar and just use it
* https://www.dropbox.com/s/a8gnbnb93507djh/Physics.jar?dl=0

## How to use the Library
### Vector2D
This class is essentially a combination of the p5.js Vectors and the Point2D class made by JavaFx.
Vectors are generally used to story and modify the positions of objects and agents in an n-dimensional space.
As can be guessed from the name, this class is meant to be used for 2D environments. For examples of uses for
Vectors i would highly recommend Daniel Shiffman's Youtube videos and his book Nature of Code.

* youtube channel: https://www.youtube.com/channel/UCvjgXvBlbQiydffZU7m1_aw
* book: https://natureofcode.com/book/

This is a short and broad description of all methods. More in depth descriptions are commented in the code an will be
shown by the suggestion algorithms of most IDEs:

* Constructor
  * Creates a vector based on the given Parameters
* SetAllComponents
  * Sets all values of the Vector to the specified Value
* CreateFromAngle
  * Creates a vector pointing in the specified direction
* CreateRandomVector2D
  * Creates a unit vector with a random rotation
* Add
  * Adds 2 Vectors together
* Sub
  * Subtracts one Vector from anther one
* Multiply
  * Multiplies two main.vectors
* Div
  * Divides one vector with another
* Distance
  * Calculates the euclidean distance between two main.vectors
* Normalize
  * Sets the magnitude of a vector to 1
* GetMag
  * Returns the magnitude of a vector
* GetMagSquared
  * Returns the squared magnitude of a vector, which is faster to compute
* getDirection
  * Returns the current rotation of the vector
* Limit
  * Reduces the magnitude of a vector if it is greater than the specified number to the specified number
* Lerp
  * Creates a vector at a specified point between two other main.vectors
* SetMag
  * Sets the Magnitude of the vector to a specified amount
* Midpoint
  * creates a vector in the middle of two other main.vectors
* DotProduct
  * Computes the dot product of two main.vectors
* GetAbsoluteAngle
  * Computes the angle between two main.vectors
* Rotate
  * Rotates the main.vectors by a specified amount
* ToPoint2D
  * Converts the Vector2D to a Point2D object
* GetX
  * Returns the value of X
* SetX
  * Changes the value of X
* GetY
  * Returns the value of Y
* SetY
  * Changes the value of Y
* Equals
  * checks if two main.vectors point at the same point, also works with Point2D
* Hashcode
  * Computes the hashcode of the vector
* ToString
  * Converts the vector into a string

### Physics2D
This class is a Java port of the main.physics that Daniel Shiffman implements in his book Nature of Code.
I therefore highly recommend watching his tutorial series about autonomous agents if you want an
in depth understanding of the topic.

* tutorial series: https://www.youtube.com/playlist?list=PLRqwX-V7Uu6YHt0dtyf4uiw8tKOxQLvlW

Here is also a rough overview of how to work with main.physics objects.
A main.physics object (from here on called agent) stores 5 essential values
* Location
  * The location is typically a pixel coordinate on your window and should therefore not exceed your window size
* Velocity
  * The velocity is the current speed of the agent and will never exceed the maximum speed
* Acceleration
  * The acceleration is the force that either speeds the agent up, slows it down or changes its direction.
  It will never be greater than the maximum force
* Maximum Speed
  * The maximum speed is typically the amount of pixels a vehicle can cross per update and should be greater than 0
* Maximum Force
  * The maximum force is the amount force an agent can use to change its velocity.
  It should be between 0(can't accelerate) and the maximum speed(instant acceleration)
* Friction
  * The friction is the constant amount of deceleration an agent receives while moving.
  It should have a value between 0(no friction) and 1(immovable object)

These values govern how the agent moves. The agent also has two basic interactions:
It can chase something and it can flee from something. Whenever you command the agent to perform
one of these actions it calculates how it will change its velocity to best obey your command.
you can repeat these command any number of times before commanding the agent to actually execute the commands.
the resulting acceleration will be the average of all of your commands. This acceleration is than added to the velocity
and the velocity is added to the location. Afterwards friction is applied to the velocity.
In the end the acceleration will be reset so that the next commands can be issued.
This model results in very realistic movements and is a good approximation of the real world.

This is a short and broad description of all methods.

* Constructor
  * Creates an agent based on the given Parameters
* Seek
  * Commands the agent to seek a point
* Avoid
  * Commands the agent to avoid a point
* Move
  * Commands the agent to either seek or avoid a point
* UpdatePosition
  * Computes the new Position of an agent after all Commands have been issued
* SetLocation
  * Moves The agent to a location
  * The location is typically a pixel coordinate on your window and should therefore not exceed your window size
* GetLocation
  * Returns the current location
* GetX
  * Returns the value of X
* SetX
  * Changes the value of X
* GetY
  * Returns the value of Y
* SetY
  * Changes the value of Y
* Distance
  * Computes the distance of an agent to a point
* GetVelocity
  * Returns the current velocity
* GetAcceleration
  * Returns the current acceleration
* GetMaxSpeed
  * Returns the maximum speed with which an agent can travel
* SetMaxSpeed
  * Changes the maximum speed with which an agent can travel
  * The maximum speed is typically the amount of pixels a vehicle can cross per update and should be greater than 0
* GetMaxForce
  * Returns the maximum force with which an agent can turn
* SetMaxForce
  * Changes the maximum force with which an agent can turn
  * The maximum force should be between 0(can't accelerate) and maximum speed(instant acceleration)
* GetFriction
  * Returns the amount of friction that slows the agent down
* SetFriction
  * Sets the friction which intern is responsible for reducing the velocity of the agent at every step
  * The friction should have a value between 0(no friction) and 1(immovable object)
