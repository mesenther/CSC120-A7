Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

First, I decided to overload the class constructors for House, Library, and Cafe. I gave each of them at least one constructor that does not require the address of the building, since that might not always be known. Then, for House I overloaded the nResidents method to compare the number of residents to a given number, in case someone would like to know if there are more/fewer residents than a certain amount like a capacity. For Library, I overloaded the checkOut method to take in any number of arguments, so someone can take out as many books as they like at once. Finally, for the Cafe class, I overloaded the sellCoffee method to specify the number of coffees being sold, in case someone would like multiple of one order.

Overall, I had little trouble with this assignment. I did realize that my previous implementation of the Cafe constructor (which set the initial supplies via user input) wasn't a good idea as the only constructor available, because it not only assumes the supplies are known, but it's also tedious and unnecessary for when you're just trying to put a Cafe on a map. So I decided to get rid of the user input entirely and just create more overloaded constructors depending on which info is known.

To someone taking this course in the future, I'd recommend planning out carefully what info you might know before calling a class constructor, so that creating instances isn't tedious or requires info that you're less likely to know.