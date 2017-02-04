# FilteringIteratorSample

Learning little bit more about Iterator Design Pattern by creating
sample FilteringIterator class whose objective is to simply skip 
any item that doesn't meet the test condition of another object that
is passed during instantiation of FilteringIterator.

Some notes about this problem:
- Since iterator is one directional, how to synchronize between 
   hasNext() and next() operator where the first one is supposed 
   to onlty peek the next item and inform whether next element is 
   available, but the peeked item may not meet the test condition, 
   in which case hasNext() method is actually doing more than peek.
- Use of flags and cachednext item may not be the best solution 
   I feel like I am still mixing my core structural programming 
   knowledge with Objected oriented programming skills. Perhaps an  
   exercise for someone else to clone my code and enhance. 
- "To throw an Exception when iterator reach to an end or return null" ? 
  I noticed some of the iterator class in java (e.g. Scanner) is throwing 
  NoSuchElementException, but for my sample Iterator demo with Numbers, 
  I decided to return null.   
