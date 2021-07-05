# visitor example
* Employee hierarchy is actually not needed, even 1 class could cover all scenarios (just put 0 as fixed salary or as comissionRate), but it's done for Visitor pattern illustration purposes
* I had to refresh my knowledge about Visitor and looks like in "pure" implementation method "visit" suppose to return void (and set calculated salary in Employee object). I dont like to modify object, so I decided to change method signature. Discussable thing
* I hope it's ok to not implement Json generation and main goal of this task was to implement Visitor, so I just used Jackson
* Company object is done just to show, how to work with list of Visitorable objects
* `gradle run` to run program
* Task by itself looks like Visitor pattern demo (based on text and overall idea, that I wouldnt use several classes for Employee in real life anyway: everything could be done in 1 class as I mentioned before + in any case not a good idea to mix fixed data like salary and variative data - "Volume" together in 1 class, because volume will change every month and it's not a part of Employee contract), so I decided that tests are not needed here
