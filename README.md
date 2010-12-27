This attempt at the Messaging Kata was meant to do two things: First, it was a chance to try out the
kata, and to hash out a more concrete form for it than the basic description we came up with at
Boston Software Craftsmanship the other night. Second, it was an attempt to follow the Object
Calisthenics rules as strictly as possible.

Now that this round is done, I think I have a great little reusable exercise here. Making the
end-to-end tests pass one at a time gives a series of short, attainable goals, each of which has
just enough complexity to bring up interesting design questions. Each new test has an opportunity
to challenge the existing design by complicating something that should have been simple before.
And by including a main method and some expected output, it makes you think about how your program
interacts with the outside world, rather than just living happily in object-land forever.

Indeed, this was the original goal of the exercise. When we started trying out the Object
Calisthenics rules at Boston SC, we were hampered by the knowledge that, sooner or later, you have
to deal with unwrapped strings if you want real output. So we set up specific inputs and outputs
to the application and then started working from there. As we'd started doing in the meeting, I've
followed most of the rules extremely strictly. Indeed, I suspect our interpretation of the
No Getters or Setters rule was more aggressive than Jeff Bay would have intended: in the meeting,
we essentially banned ever returning a value from a function, and I've followed that interpretation
throughout this exercise.

The effects of the Object Calisthenics rules were interesting. On the one hand, they did force
certain kinds of simplicity on the code, and I don't think it got appreciably harder to change over
the course of the exercise. On the other hand, the really aggressive tell-don't-ask style forced
a really uncomfortable level of indirection in some situations, and even though the mailer and
message packages were technically pretty well separated from each other, there was still a lot of
weird sort-of-coupling between them.

In the next round, I think I'd allow getters, or at least return values, in a few specific cases:

# Implementing toString() to get a string representation of an object for printing.
# Creating objects, either to transform one object into another or to implement a factory.
# Reporting the condition of an object (for example, isValid()).

Next up, we'll see how that goes.