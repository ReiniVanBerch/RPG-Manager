# RPG-Manager
## Idea

The RPG-Manager is an open-source-project starting created with the idea of being able to handle different TableTop Games 
focussing on RPGs. As popular RPGs, for example Dungeons and Dragons with D&D Beyond, have digital toolsets, but many 
other systems lack this kind of support. The aim of this project is it to create a toolset that can be tinkered and tweaked with
so it can be used for any kind of TableTop Game.

## Structure

As of release 0.2.0 this will be able to handle character with simple qualities. To elaborate on this further.  
Each character has nothing for themselves for sure, but a name. If the character has an unknown name, give him a name based on his backstory, maybe "Mountain boy" or "Lesser Troll"  
Other than that a character has qualities. These qualities are upon the user to be defined in greater detail and what they stand for.  

### Qualities

The qualities have a comment, so the users realise that something is for example HP, as files can be shared with others.  
These qualities have a typenumber, see more below.
And an array of the corresponding values.

#### Typenumber
The typenumber is an integer from 0 to 255. It is to be understood as two as to hex numbers.  
The first represents whether it is an integer, a bool, a double or a string.  
The second represents the type of quality.  
The following types of quality exist:
- Fixed Value
- Changing Value
- Range
- Range with a current Value
- List

If either equates to 0xF than an error occurred in that part occurred. If both are 0xF then there are serious issues.