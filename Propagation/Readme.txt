This is a prototype/proof of concept of a Java implementation of the propagator architecture described in
Software Design for Flexibility by Chris Hanson and Gerald Jay Sussman.  That textbook provides examples
of propagators written in the Scheme programming language which is an MIT designed dialect of LISP.

This first iteration introduces a bare bones cell that fires content change events and some core propagators
that can be used for doing some basic math.

I am speculating that I might be reinventing the wheel and that perhaps there is a java library already available
that was written for the MIT Genesis System.