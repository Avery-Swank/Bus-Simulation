# Bus-Simulation
This Java program is a Bus Simulation of the Minneapolis Metro Transit transportation system. An assigment in my Computer Science 1933 course Intro to Algorithms and Data Structures.

The goal of this assignment was to understand Queues and Priority Queues with a set number of buses, and a certain randomness with passengers at each bus station. Using only simulations, we had to determine the most optimal number of buses and at what stations they start their bus route. 

## Simulation Variables
The most optimal bus count was determined by the following variables:
  * Fixed time between bus stops
  * Dynamic time based on how many people want to get off a single bus at a certain route
  * Dynamic time based on how many people want to get on a single bus at a certain route
  * Whether or not a bus has to wait at its stop in order for the bus ahead to get far away
