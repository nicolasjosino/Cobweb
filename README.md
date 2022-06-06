# The Project
Example of a basic cobweb clustering algorithm made in Java, with the objective of clustering a given object in a node with multiple children.

<p align="center">  
  <img src="https://user-images.githubusercontent.com/78516763/172085678-bb1060b0-8987-4a15-b5ee-2a7ac054e5f1.png">
</p>

## The Clustered Structure
Cell: an object used as a case study for the clustering algorithm. It's composed of the following attributes: cell color, number of cores and tails.

<p align="center">  
  <img src="https://user-images.githubusercontent.com/78516763/168347195-137a0a2a-29e1-4a66-9e6d-fe303d0ce77d.png">
</p>

## How it's done
The algorithm receives an Node (namely a _root_), an object that stores a list of Cells and other Nodes linked to it, referred to as Children, and also a new Cell to be added to the root, called _record_. Firstly, the _root_ is checked for having any nodes in its Children list. If so, it receives two sub-nodes, the fist one containing the _root_ original Cell, and the other receiving the _record_ argument of the algorithm.

### The other scenario:
If the _root_ cell already has children, some calculations are needed. There will be simulations for the insertion of _record_ in each children of _root_, as well as a simulation for a new children altogether. For each scenario, the *Category Utility* is defined, which envolves calculations using each Node's Cells' attribute incidence. A HashMap is instantiated for storing the category utility value to each node, which will all be compared later for deciding which one's most eligible for receiving the new Cell record. These category utility values are also compared to the situation of inserting a new node containing solely the _record_ Cell within it.
Lastly, if the course of action to take is inserting _record_ in a pre-existing node, the cobweb function is called recursively, in order to either divide the chosen node into two children of its own, or to validate which of its existing children shall receive the _record_ cell, continuing the clustering process.

<!-- <p align="center">  
  <img src="https://user-images.githubusercontent.com/78516763/172087430-26f6e5ee-8910-4a7e-b81c-7494b9855523.png">
</p> -->
