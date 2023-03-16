# 1

## 1.6

first create a min heap using the minimum value in each array, then popmin and add it to the merged array, add the next
value from the array that the value was taken from.<br>
Might need to store a pair of values in the heap, to keep track of
where the value came from

# 2
priority queue lol

# 3 
## 3.1
save largest value in var then swap with last element in array partition. <br>
bubble down the new max value till we have a heap again. <br>
repeat m times

## 3.2
__Delete__: asuming the given numbers are indexes in the heap array this is possible using the same method as remove max for delete <br>
__Fusion__: still asuming that we are given indexes we can just delete the two elements to be fused and add the new element with the sum of the two previous values.

## 3.3
if node greater than x add to result and recuse on children

## 3.4
Maintain a second min-heap, which can be extracted minimum from.<br>
cant figure out how to find the min value in max heap in log(n)
and opposite
<br>
<br>
maybe using a stronger heap based on sorted array, so that min value is always at the end.<br>
unsure of runtimes on insert and delete

# 4
Gem objekter af sattelit data i heap.



