# The Project
Example of a basic cobweb clustering algorithm made in Java, with the objective of clustering a given object in a node with multiple children.

## The Clustered Structure
Cell: an object used as a case study for the clustering algorithm. It's composed of the following attributes: cell color, number of cores and tails.

<p align="center">
  
  <img src="https://user-images.githubusercontent.com/78516763/168347195-137a0a2a-29e1-4a66-9e6d-fe303d0ce77d.png">
</p>

# How it's done
The algorithm receives an Node (namely a _root_), an object that stores a list of Cells and other Nodes linked to it, referred to as Children, and also a new Cell to be added to the root, called _record_. Firstly, the _root_ is checked for having any nodes in its Children list. If so, it receives two sub-nodes, the fist one containing the _root_ original Cell, and the other receiving the _record_ argument of the algorithm.
