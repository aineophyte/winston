# winston
Projects inspired by Patrick Winston's AI lectures.

At this point, these are all Java implementations.

The IdentificationTree project is based on the information presented in Chapter 21 of Patrick Winston's Artificial Intelligence text book and Lecture 11 of the lectures videos at
https://ocw.mit.edu/courses/6-034-artificial-intelligence-fall-2010/video_galleries/lecture-videos/.  I recommend the whole series to anyone interested in AI even if you
think you are already knowledgeable about the topic.

The ConnectFour project is the beginnings of a Mini-Max implementation of the Milton Bradley (now Hasbro) Connect Four board game.  Mini-Max is Lecture 6 of Winston's 6.034 class.
That topic also included a homework exercise of enhancing a working version of Connect Four written in python.  I have not spent the time to look at the python implementation.
This Java implemtation is my design from scratch and makes use of some modern technologies like a Cassandra nosql data store and gRPC.  The static evaluators can definitely be improved.
Alpha-Beta pruning logic is not implemented yet.  It also needs some basic opening strategy moves that might take precedence over the Mini-Max responses to the opening moves of the opponent.
