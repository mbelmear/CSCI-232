/*
class is a blueprint for an object(i.e. a "thing") in java
Student s1 = new Student("Joe"); -> how to instantiate an object
    -java object: instances of classes, program entities
static means that object or attribute is shared across variables
needs data, variables, actions, or variables, constructors, methods

Java variable assignment:
x = y gives x a copy of whatever the value in y is

Running Time: Number of operations required to complete algorithm

Big O Notation: Upper bound on asymptotic growth, ie. Worst case upper bound of a function, tells us the limiting part of our algorithm

Linked List: Linear data structure of ordered objects, nodes that point to other nodes
    -payload is inside of nodes, can be variables and actions otherwise known as data and methods
    -inserting into a linked list is constant 

Trees: are data structures used to store elements hierarchically, not linearly like arrays and linked lists
    -entities that make up a tree are called nodes
    -node is an instance of a class or an object
    -root is the node at the top of hierarchy 
    -parent for a given node, its parent is the node that directly precedes it in the hierarchy
        -every node has a parent except for the root, nodes MAY NOT have multiple parents
    -child: for a given node, its children are the node(s) that directly follow it in the hierarchy 
    -internal node: a node with at least one child, ie a parent
    -leaf node: a node without children
        -every node is an internal node or a leaf node 
    -edge: a pair of nodes such that one is the parent of the other, there is no edge 
    -path is a sequence of edge-connected nodes
    -a subtree is a given node and all of its descendants
    -depth of a node is the number of edges in the unique path back to the root
    -height of a tree is the maximum depth of any of its nodes

With a tree we want to be able to:
    -insert a node
    -remove a node
    -get the children/parents of a node
    -traverse or search 
    -get the depth or the height 

SOME of these operations don't depend on the purpose of the tree
-An array list is a resizeable array

Point of this course is to learn how to turn ideas into code
-write pseudocode to outline the structure of your program
-to instantiate a tree we need a root node in our tree class

How to search for a value in a tree:
-breadth first, visit all nodes at the same depth before progressing to next depth
-depth first, explore full path

-breadth first:
    -visit the root
    -visit all depth 1 nodes
    -visit all depth 2 nodes
    -visit all depth 3 nodes
    -etc...

How do we implement this?
    -use a queue: which is first in first out
    -everytime we visit a node we:
        1.execute the action
        2.add all of its children to the queue
        3.remove visited node from the queue

-depth first:
    -go all the way down to the first leaf
    -backtrack until unvisited child is encountered 
    -repeat

How do we implement this?
    -use a stack: which is first in last out
    -everytime we visit a node:
        1.remove a node from the stack
        2.execute the action 
        3.push all children to the stack

Binary Search Tree:
    Properties:
        -a bst is composed of COMPARABLE data elements
        -a bst is a binary tree meaning that each node has two children
        -for each node, all LEFT-HAND descendants have values that are less than the node
        -for each node, all RIGHT-HAND descendants have values that are larger than the node
        -there can't be any duplicate values

Why use a BST?
    -in general, at depth d, there are at most 2^d nodes
    -given a bst with n nodes, the greatest number of edges we would have to traverse to go from the root to the leaf is n - 1, or the height of the tree
    -smallest height of a bst is n = 2^0 + 2^1 + 2^h or x = 2^(h+1) - 1 or O(log n)
    -we can search through a bst in O(log n) time
    -so we can access any node in a specific type of binary tree in O(log n) time
    -we can also test if a specific value is in a collection in log n time
    -however we can already do this with a sorted array and a binary search!
    -managing a bst is more efficient than managing an array

Binary Search Tree - Insertion:
    -find where it should go 
    -modify pointers
    Trends:
        -we're always inserting a new leaf!
    -If tree is empty that means the root is null
    -Need to check if the root is equal to null,
        -if so then we are going to make a new node and point root to it
    -else we are going to make a variable called current to point to the root
    -need a boolean placed to be equal to false to check in the future if we have placed a new node or not
    -need a while loop to loop while placed is still false
        -need an if statement to check if new values are less that the value of the current 
            -need a nested if statement to check if the current node on the left is not null
                -if true then make the current point to the left node
            -need a nested else statement, if the current node to the left is null
                -then add the new node by setting the current node's left value to the new nodes value and 
                -set the current node's value as the parent node
                -then set the boolean placed equal to true
    -(outside of the while loop) otherwise 
        -if the node to the right of the current node is not null 
            -set current to the node to the right of current
        -else make the new node we want to inset equal to the right node of the current node 
            -set the current node's value to be the parent of the node we just inserted to the right of the current node
            -again set the boolean placed variable equal to true meaning that we have successfully found a place for the new node 

Binary Search Tree - Removal:
    step 1: find the node in the tree
    step 2: change the parent to point to null
    Does this always work?
        not if you want to remove a node that has children, only works for a leaf
    Case 1: Node has no children
    Case 2: Node has 1 child
    Case 3: Node has 2 children
    for case 2, point parent of current to child of current
    for case 3, find the largest node on the left hand side of the tree by going left once and then right as 
            many times as needed until there are no more children, put the value of that node into the value of the node being removed
            then remove the largest node on the left-hand side
    running time of a good tree is O(log n) and running time of a bad tree is O(n)

recursion 
-is just calling a method from inside of itself
-solve the problem by solving identical smaller problems 
-what is the "smaller problem"
    -process the left side, then process the right side
    -need a base case otherwise you will get a stack overflow error
    -traversing a bst by processing the left, printing, and then processing the right, will produce a sorted output
    -this is called an in order traversal
    -preorder traversal method
    -postorder traversal method

    Inorder search traversal
    public void depthFirst(Node n){
        if (n != null){
            depthFirst(n.getLeft());
            System.out.println(n.getValue());
            depthFirst(n.getRight());
        }
    }

Types of Trees:
    -binary search tree
    -red black tree:
        -similar to 2-3 trees 
        -some say that it is similar to a 2-3-4 tree
    -before red black trees, there were avl trees, rebalancing takes more effort
    -a red black is the most widely used/popular choice today
        -insert and delete potentially faster than AVL trees
    -a B tree is optimized for reading and writing large blocks of data
        -commonly used for databases and file systems
    
Red Black Trees:
    -a red black tree is an implementation of a 2-3 tree
    -why use a red black tree:
        -needed when height balancing is a desireable trait, insertion/deletion must not be too slow either
    -real world uses/examples of red black trees
        -process scheduler in linux uses red black trees
        -computational geometry data structures
        -hashmap in java 8 uses rb tree instead of linked 
        -some implementations of pattern mining
        -java 8 TreeMap
    -a red black tree is a bst with 2 node types - red and black
        -tree must balance when node is inserted or removed
    -implementation requirements:
        -every node must be either red or black
        -the root must be black
        -a red node's children must be black
        -a null child is considered to be a black leaf node
        -all red children must lean left 
        -all paths from a node to any null leaf descendant node must have the same number of black nodes
    -a tree that meets these requirements with N nodes will have a height of O(logN)
    -all newly inserted nodes are red
    
quiz 1 review:
    -we can bring any notes we need but no electronic devices
    -8 questions:
        -bst traversal questions
        -bst method description questions
        -bst application questions
        -bst running time questions

    bst wrap up:
    -h is the height of the tree, bsts achieve o(h) insertion, deletion, and search time
    -the shortest a bst can possibly be is o(log n) where n is the number of nodes in the tree
    -the best possible running time for insertion/deletion/searching in bsts is O(log n)
    -a naive bst is not guaranteed to achieve minimal height 
    -balanced binary trees do achieve near that minimal height

Red-Black Trees cont.
    -self balancing bst
    -guaranteed O(log n) insertion, deletion, search
    -nodes contain parent/children pointers and a red or black color
    rules:
    -every node is red or black
    -root is black
    -null nodes pointed to by leaves are black
    -if a node is red, both of its children are black
    -for every node, each path to descendant null leaves contain the same number of black nodes
    Result: is a limit on how tall a tree can get without filling in
    Problem: inserting and deleting break the rules (searching does not)
    Solution: after inserting/deleting, fix rule violations
    Process:
    -start with a valid red-black tree
    -insert a new node as red
    -perform re-coloring and rotations to fix violations
    -continue until root is reached

Hashing:
    -Dictionary:   
        -Need a Key with Values
    What array index does address x go into?
        x % 100
    % is a modulo operator meaning what is the remainder of a number inside of another number, 132 % 100 = 32
    x % 100 is a hash function
    Hash Function: Function that translates key values into array indices(hash value)
    Collision: when two keys hash to the same array index
    Hash Tables/Map:
        -takes key values and puts them into an array
        Considerations:
            -How big to make array?
            -How to avoid collisions?
            -How to handle collisions?
    Hash Tables 101:
    Theory.
    Hash Functions.
    Statistical likelihood.
    Expected performance.
    Application.
    Tools in hand.
    Java functionality.
    MOST IMPORTANT THING IS TO PRACTICE AND IMPLEMENT USING REAL WORLD APPLICATIONS
    % 100 is an example of modular hashing with 100 being the size of the array
        -this is a hash function
    Lessons:
    1. Use as much of the key as possible
    2. Make sure your array is big enough but not too big
    3. Use a prime number array size
    Hash Functions:
    -Function that translates key values into array indices.
    Requirements:
        -well defined for all input 
        -identical keys map to identical indices
        -maps to a specific range
    Goals:
        -easy to compute
        -uniformly distributes keys across range(collision avoidance)
    Collision Avoidance = Hash Functions

Algorithms:
    -An algorithm is the process for solving a problem
    -Filling out a table will always have a running time of O(n^2)
    Divide and Conquer battle plan:
        -divide problem into subproblems that are smaller instances of the same problem
        -conquer the subproblems by solving recursively 
        -merge solutions to each subproblem
        HOW DO WE DO THIS?
        Merge Sort:
            -divide array in half
            -sort sub arrays
            -merge into sorted array

Quiz 2:
    -notes are allowed
    -9 questions with 3 sections:
        -6 questions on hashing code critique
        -1 question on testing
        -2 questions on bsts vs hashing
    Review:
        Hashing:
        -increase the size of the hash function modulo or decrease the size of the array to fix collisions
        -need to append element to pre-existing linked list instead of creating a new linked list
        -need to remove from an existing linked list instead of pointing the hashed element to null, as this will cause a null collision exception
        -don't check to see if a hashed element contains a value, see if the linked list at that spot contains the desired value, search the linked list
        Testing:
        -What is the goal of software testing
            -Quantify its performance in realistic conditions.
        BSTs
        -what are binary search trees better at than hashtables?
        -why are they better?
            -they are better at searching for data as it relates to other data, ordered pairs, ceilings, highers, etc...
            -they are better at this because there is order and rules encoded into the construction of a bst
        HashTables:
        -what are hashtables better at than bsts?
        -why are they better?
            -they are better at inserting and deleting
            -they are also better at finding values that have no order
            -they are better at this as you can directly address a value into an array which is constant time

Graphs:
    -it's an abstract structure that has a very wide applicability 
    -vertices are called nodes (the dots)
    -edges (lines)
    -need to define the set of nodes and the set of edges; G = (V, E)
    -which dots connect to which dots
    -edges can be directed or undirected -> errors basically, is there only one way to get somewhere or multiple
    -a simple graph has at most one edge between a pair of vertices and no edges that start and end at the same vertex
    -a path is a sequence of vertices connected by edges without loops
    -an edge is a path but a path is not necessarily an edge
    -loops are not allowed in paths 
    -a cycle is a sequence of vertices connected by edges with loops
    -a connected graph is a graph that has a path between every vertex pair
    -degree of a vertex = deg(v) = the number of edges touching it (undirected)
    What are some operations would we want to perform on a graph?
        -add vertices and edges
        -find paths
        -connected or not?
        -find the degree
        -is it simple?
        -get number of vertices or edges
        -get neighbors of a vertex
        -is there a cycle?
        -find max degree 
    *Can't do anything until we know how to represent a graph in a computer*
    So how do we represent a graph in a computer?
        -you could use an adjacency list
        -you could use an adjacency matrix -> boolean matrix 
        -you could use objects
            ex. public class Node{
                private Set<Node> neighbors;
            }
        -adjacency list is just an array of linked lists
    How do we come up with a generic process to see if there is a path from node 0 to 5?
    How can we store and compute paths of graphs?
        -what if for each vertex we stored the previous vertex
        -backtrack and start at the ending vertex
        -start at the ending vertex and find its previous vertex and then find its previous vertex until we get to the starting node
    How can we do this with Code?
        -create/initialize previous vertex
        -populate previous vertex
        -get path to end vertex 
    Minimum Spanning Tree:
        Edge-weighted graph: a graph where each edge has a weight(cost)
        MST Goal: connect all vertices to each other with a minimum weight subset of edges
        Tree-connected graph with no loops
        Spanning Tree-tree that includes all vertices in a graph
        Minimum Spanning Tree-spanning tree whose sum of edge costs is the minimum possible value
        Kruskal's MST Algorithm:
            -at each iteration, add the edge with the smallest weight, that does not create a cycle
    *Three questions for any algorithm: running time? validity/correctness? and performance/accuracy?*
    Cycle Finding:
        Rules:
            -only add edge if vertices have different connected component markers
            -to add edge, pick one vertex's marker add change ALL vertices with the other marker
        Connected Component (in the tree) Marker
    Is the solution valid(i.e., is the output a spanning tree)?
    Is the solution optimal(i.e., is the output a MINIMUM spanning tree)?
    For Kruskal's algorithm, 
        proof of validity: let G = (V, E) be connected, and T C E be the set of edges resulting from kruskal's algorithm
    T is a tree because it is connected (otherwise we could have added more edges without creating cycles) and there are no cycles
        proof of optimality: let G = (V, E) be connected, and T C E be the set of edges resulting from kruskal's algorithm 
    Consider the iteration that edge e = (u,v) is added by kruskal's algorithm. Let S be the set of v and nodes connected to v. Clearly 
    v E S and u E V\S (otherwise adding e would have created a cycle). We are picking the cheapest such edge (otherwise the cheaper edge would have 
    been selected since it would not have created a cycle either). By the cut property lemma, this edge must be part of the MST
    MST Cut Property:
        Lemma: the cheapest edge e between S and V\S is part of every MST
        Proof: any MST of G must include some edge between S and V\S (otherwise it would not be a tree)
        Let e be the cheapest edge between S and V\S
        Suppose T is a ST that does not include e, then:
            1. T U {e} must have a cycle (since spanning tree T already has a path between u and v, so adding e will create a cycle)
            2. That cycle must have another edge e' between S and V\S (since there must be a path from u E to v E V\S in T)
        Remove e' to form T' = T U  {e}\{e'}
        T' is a tree (removing edge from cycle cannot disconnect graph)
        T' spans V (same number of edges as ST T)
        weight(T') = weight(T) + weight(e) - weight(e') -> weight(T') < weight(T), since weight(e) < weight(e') -> T' is a cheaper ST
        so therefore, e is part of every MST.
    Prim's MST Algorithm:
        -Beginning at any node, add the node that can be connected as cheaply as possible to the tree we are building
    Last Lab: Negate the edge costs 
    Project: Graph must be integers
    What is the SHORTEST PATH between two vertices?
        -the path with the smallest sum of edge weights
    Assumptions:
        -graph is directed
        -graph is edge-weighted
        -edge weights are non-negative
        -graph need not be simple(though the example will be)
    We are going to find the shortest path between vertex 0 and every other vertex, flooding out from 0
    Easy to find the path from the leaf to the root but difficult to find the path from the root to the leaf
    So how do we keep track of routes?
    If this is the shortest path from 0 to 6, what can we say about the shortest path from 0 to 3?
    Claim: There cannot possibly be a shorter path from 0 to 2 than the edge from 0 to 2 because non-negative edge weights mean every other path is at least .38 or .26
    We need some process for progressing through the graph
        -What if we prioritized neighbors based on path (not the edge) distance?
    Add neighbors to queue/previous 
    Rule: when processing a vertex V, only add/modify queue for neighbor u if and only if:
        distance[v] + weight(v, u) < distance[u]
    Dijkstra's algorithm:
        -we have found the shortest path when the queue is empty
     
Quiz 3: 
    Provide a graph with at least one negative edge weight where the shortest path found by Dijkstra's algorithm is not actually the shortest path.
    What is the path found by Dijkstra's? 
    What is the actual shortest path? 
    Why did Dijkstra's fail to find the actual shortest path?    
    Find the minimum spanning tree in a graph
    Suppose I had a set of edges to represent a spanning tree, why is it guaranteed that adding any edge to that set will no longer make it a spanning tree?
    What is the minimum number of edges that could be in a minimum spanning tree of a graph with n vertices?
    What is the max?
    6 Questions:
        -graph representation
        -scenario, how would you solve it?
        -find mst
        -mst conceptual question
        -find shortest path distance and previous arrays
        -shortest path conceptual question

    Scenario Examples: 
        -suppose a road network is called robust if there is a path between any pair of nodes, even if an arbitrary edge is removed
         from the network. Given a graph representing a road network, how could you determine if it is robust?
            -loop through all the edges, remove it, see if it's connected, if not, return false, put edge back, 
             return true after checking all the edges
        
        -consider a social network consisting of vertices(people) and edges(contact between people in the last 24 hours).
         suppose someone was just diagnosed with covid. what is the most efficient way to start screening other potentially infected people?
            -breadth-first search, then close contacts get checked before further away contacts

    MST Conceptual Question Examples:
        -what is the minimum number of edges in a mst of a graph with n vertices?
            -n - 1, you can confirm it inductively 
        -what is the maximum number of edges in a mst of a graph with n vertices?
            -n - 1, you can't add any more edges
        
    SP Conceptual Question Examples:
        -why does the shortest path algorithm from class not require the graph to be simple(i.e. no parallel edges, no self-loops)?
            -self-loops will never be taken as they can't lower the cost of a path (as long as the edges aren't negative). 
             parallel edges don't complicate anything, since only the cheapest one is ever considered, and all others are ignored
        *New Rule: once a vertex has been removed from the queue, never put it back on the queue*
        -can you think of a graph (with negative edge weights) where the shortest path algorithm from class fails to find the shortest path?
*/