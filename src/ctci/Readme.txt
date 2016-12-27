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