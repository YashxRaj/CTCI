Yash Raj.

It is possible by first cloning the repository and then creating a General project based on that. Then you can convert it to Java project. Here is how:

First go to File>Import...>Projects from GIT.
In the Select a Git Repository view you first press Clone. And follow instructions. This will create a local "checkout" of the repository to your computer. You can set the folder to be your workspace so it looks like any other of your eclipse projects.
After you have cloned the repository you get back to Import-view. Now you can select the repository you just cloned from the list.
Click Next and select Import as General Project. Now you have a git repository to eclipse.
Convert it to Java project: Add nature and buildCommand elements from other Java project to your .project file:
Relevant sections from .project:

<buildSpec>
    <buildCommand>
        <name>org.eclipse.jdt.core.javabuilder</name>
        <arguments>
        </arguments>
    </buildCommand>
</buildSpec>
<natures>
    <nature>org.eclipse.jdt.core.javanature</nature>
</natures>
Then from Project>Properties>Java Build Path>Source add your source folders (and possible libraries).

Edit: Added the conversion to Java project.

Few Words on Chapter 4 : Trees and Graphs
-----------------------------------------
Tree:
- Can have many nodes.
(Binary Tree , Ternary Tree, etc.)

Binary Tree:
- Can have atmost 2 child nodes.

Binary Search Tree:
- For every node N, all descendents left of N <= N > all descendents right of N.
Possible variations include: 
Duplicate values not allowed in the tree, OR
Duplicate values must be on the right side, OR
Duplicate values can be on either side.
 - This must be true for all nodes.
 				INVALID BST (Because 12 appears to the left of 8)
 					8
 				   / \
 				  4	  10
 				/  \    \
 			   2	12   20

Balanced BST:
- Left and right subtree's heights differ by ATMOST 1 level (FOR EACH NODE).
- Must have O(log n) times for insert and delete.
- 2 Types: Red-Black Trees and AVL Trees.

Full(Strictly) Binary Tree:
- Each node must have either zero or two child nodes. (ie, no node has only one child.) 
- Always contains (2*(number of leaves in the tree) - 1) Nodes (4 Leaves ? 2*4 - 1 = 7 Nodes.)

Complete Binary Tree:
- All levels except the last level must be FULLY filled.
- Last level must have leaves filled from left to right.

Perfect Binary Tree:
- Both Full and Complete. (All leaves on the same level, and this level has the maximum nodes it can have.)

Traversals:
 <      ^       >
Pre    In	  Post
N,L,R  L,N,R  L,R,N

MinHeap:
- Complete binary tree where each node is smaller than its children.
- Operations: Insert and extractMin.
